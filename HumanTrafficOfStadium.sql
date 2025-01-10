-- Write your PostgreSQL query statement below
With visit_cte as (
    SELECT id, visit_date, people,
    row_number() over() as row_num,
    id - row_number() over() as diff
    FROM Stadium
    WHERE people >= 100
)

SELECT id, visit_date, people
FROM visit_cte
WHERE diff IN (
    SELECT diff
    FROM visit_cte
    GROUP BY diff
    HAVING COUNT(*) >= 3
)
