-- Pivot values
-- create extension tablefunc ; -- needs to be created to use the CROSSTAB
select *
from crosstab(' select distinct item_id , item_code, item_status , 
				min(status_update_date) over (partition by item_status) as status_date
				from schema.table_name t 
				where item_id = 0  
				order by 1'
				, 'values (''status1''), (''status2''), (''status3'') ')
as ( item_id int, item_code int, status1 timestamp, status2 timestamp, status3 timestamp)
;

-- Calculates the occurance of each change type
with results as (
	with t as (
		select
		t.*, count(item_id) over (partition by t.item_id, t.item_code) as count_items
		from schema.table_name t
		left join schema.table_name1 s on s.item_code = t.item_code and s.column1 = t.column1 
		where s.column2 in ('a' , 'b')
	)
	select
	t.*
	case when t.column1 <> lag(column1) Over (Partition by t.item_code, t.item_id Order By t.change_date) then 'change1' end as change1,
	case when t.column2 <> lag(column2) Over (Partition by t.item_code, t.item_id Order By t.change_date) then 'change2' end as change2,
	case when t.column3 <> lag(column3) Over (Partition by t.item_code, t.item_id Order By t.change_date) then 'change3' end as change3,
	case when COALESCE(t.column4, -1) <> lag(COALESCE(t.column4, -1)) Over (Partition by t.item_code, t.item_id Order By t.change_date) then 'change4' end as change4,
	case when COALESCE(t.column5 ,-1) <> lag(COALESCE(t.column5 ,-1)) Over (Partition by t.item_code, t.item_id Order By t.change_date) then 'change5' end as change5
	from t
	where t.count_items >1
)
select  
unnest(array[r.change1, r.change2, r.change3, r.change4,r.change5]) as changes,
count(*) as cnt
from results r 
group by unnest(array[r.change1, r.change2, r.change3, r.change4,r.change5]) 
order by count(*) desc ;