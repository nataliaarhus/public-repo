import json
import boto3
from botocore.exceptions import ClientError

def get_db_credentials(secret_name):
    session = boto3.session.Session()
    client = session.client(service_name='secretsmanager')

    try:
        secret_response = client.get_secret_value(
            SecretId=secret_name
        )
        secret = json.loads(secret_response['SecretString'])
        credentials = {'host': secret.get("host"), 'database': secret.get("db"), 'user': secret.get("username"),
                       'password': secret.get("password"), 'port': secret.get("port")}
        return credentials
    except ClientError as e:
        raise e

def get_api_credentials(secret_name):
    session = boto3.session.Session()
    client = session.client(service_name='secretsmanager')

    try:
        secret_response = client.get_secret_value(
            SecretId=secret_name
        )
        secret = json.loads(secret_response['SecretString'])
        credentials = {'client_id': secret.get("client_id"), 'client_secret': secret.get("client_secret")}
        return credentials
    except ClientError as e:
        raise e
