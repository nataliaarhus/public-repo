import msal
import requests
import pandas as pd
from datetime import date, timedelta
import secret_manager_utils as smu
import load_to_db as ltd

def get_msal_token(payload):
    # Use MSAL to get token
    credentials = smu.get_api_credentials(payload['secret_name'])
    client_id = credentials['client_id']
    client_secret = credentials['client_secret']
    authority_url = credentials['authority_url']    # https://login.microsoftonline.com/{tenant_name}
    scope = payload['scope']
    app = msal.ConfidentialClientApplication(client_id, authority=authority_url, client_credential=client_secret)
    result = app.acquire_token_for_client(scopes=scope)
    return result

def get_data_from_api(url, access_token, activity_date):
    if activity_date is not None:
        url = url + "?startDateTime='" + activity_date + "T00:00:00'&endDateTime='" + activity_date + "T23:59:59'"
    header = {'Content-Type': 'application/json', 'Authorization': f'Bearer {access_token}'}
    api_call = requests.get(url=url, headers=header)
    print(api_call.json())

    # Initialize an empty df
    df = pd.DataFrame()

    # Set continuation URL
    contUrl = api_call.json()['continuationUri']

    # Get all Activities for first hour, save to dataframe (df1) and append to empty created df
    result = api_call.json()['activityEventEntities']
    df1 = pd.DataFrame(result)
    pd.concat([df, df1])

    # Call Continuation URL as long as results get one back to get all activities through the day
    while contUrl is not None:
        api_call_cont = requests.get(url=contUrl, headers=header)
        contUrl = api_call_cont.json()['continuationUri']
        result = api_call_cont.json()['activityEventEntities']
        df2 = pd.DataFrame(result)
        df = pd.concat([df, df2])

    # Set ID as Index of df
    df = df.set_index('Id')
    return df

def main(payload):
    result = get_msal_token(payload)
    # print(result)
    if 'access_token' in result:
        access_token = result['access_token']
        activity_date = payload['activity_date']
        url = payload['url']
        df = get_data_from_api(url, access_token, activity_date)
        df.to_csv('export_dataframe.csv', index=None, header=True)


if __name__ == '__main__':
    Payload = {
        'secret_name': '',
        'scope': ["https://analysis.windows.net/powerbi/api/.default"],
        'url': 'https://api.powerbi.com/v1.0/myorg/admin/activityevents',
        'activity_date': (date.today() - timedelta(days=1)).strftime("%Y-%m-%d")
    }
    main(Payload)
