-- Write your PostgreSQL query statement below

SELECT
    round(sum(tiv_2016::numeric), 2) as tiv_2016
FROM Insurance i
WHERE (pid) IN (
    SELECT DISTINCT(i1.pid)
    FROM Insurance i1
    INNER JOIN Insurance i2 ON i1.tiv_2015 = i2.tiv_2015
    GROUP BY i1.pid
    HAVING count(*) > 1
) and (lat, lon) NOT IN (
    SELECT
        lat, lon
    FROM Insurance
    WHERE pid != i.pid
)
