-- Write your PostgreSQL query statement below
SELECT TO_CHAR(t.trans_date, 'YYYY-MM') as month, 
country, 
count(*) as trans_count, 
SUM(case when state = 'approved' then 1 else 0 end) as approved_count, 
SUM(amount) as trans_total_amount, 
SUM(case when state = 'approved' then amount else 0 end) as approved_total_amount
FROM Transactions t
GROUP BY t.country, TO_CHAR(t.trans_date, 'YYYY-MM')
