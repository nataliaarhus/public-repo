-- Create a table copy
create table schema.table_name_202400101
as select 
*
from schema.table_name ;

-- Delete specific records from a table without a unique key
with dlt as (
	select 
	ctid, 
	row_number() over (partition by oc.snapshot_date, oc.item_id order by oc.snapshot_date desc) as rn, 
	oc.*
	from schema.item_values oc
)
delete from schema.item_values where ctid in (select ctid from dlt where rn > 1);

-- Specific records
update schema.item_values
set 
value1 = 0,
value2 =  0
where snapshot_date = '2024-01-01' 
and item_id = 0 
and contraint1 = '' 
and contraint2 = '' 
and contraint3 = '';

-- Drop / add columns
ALTER TABLE schema.table_name
	DROP column column1 ;

ALTER TABLE schema.table_name
	add column column2 bool,
	add column column3 int8 ;


-- Create a table definition and add index
CREATE TABLE schema.table_name (
	column_key int8 DEFAULT nextval('table_name_column_key_seq'::regclass) NOT NULL,
	column1 varchar(500) NULL,
	column2 timestamp NULL,
	column3 int4 NULL,
	column4 int8 NOT NULL
);
CREATE UNIQUE INDEX table_name_column_key ON schema.table_name USING btree (column_key);
CREATE INDEX table_name_column2 ON schema.table_name USING btree (column2, column2, column4);

