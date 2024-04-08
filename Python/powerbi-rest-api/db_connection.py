import psycopg2
from psycopg2.extras import RealDictCursor
import secret_manager_utils as smu

def connect_db(environment_name):
    env_name = environment_name.lower()
    if env_name == 'production':
        credentials = smu.get_db_credentials('') # add prod secret name
    elif env_name == 'preprod':
        credentials = smu.get_db_credentials('') # add preprod secret name
    else:
        credentials = smu.get_db_credentials('') # add staging secret name
    try:
        conn = psycopg2.connect(**credentials)
        conn.autocommit = True  # auto-commit each entry to the database
        conn.cursor_factory = RealDictCursor
        print("Connected Successfully to DB: " + str(credentials.get('database')) + "@" + str(credentials.get('host')))
        return conn
    except:
        raise



