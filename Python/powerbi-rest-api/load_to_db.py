import db_connection as dbc
import sqlalchemy
from sqlalchemy import create_engine, text, delete,Table,MetaData

def load_to_db(environment_name, table_name, schema_name, df):
    params = dbc.connect_db(environment_name)
    # print("params: " + params)
    engine = sqlalchemy.create_engine(params, isolation_level ='AUTOCOMMIT')
    with engine.connect() as conn:
        conn.execute(text(f'TRUNCATE TABLE {schema_name}.{table_name}'))
    print("############### Loading to table : ", table_name)
    df.to_sql(name=table_name, con=engine, schema=schema_name, if_exists='append', index=False, method='multi')