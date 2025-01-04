-- Write your PostgreSQL query statement below
-- LEFT OUTER JOIN then GROUP BY time_stamp and user_id of the Confirmations table

SELECT s.user_id, round(avg(case when action = 'confirmed' then 1 else 0 end), 2) as confirmation_rate
FROM Signups s 
LEFT JOIN Confirmations c
ON s.user_id = c.user_id
GROUP BY s.user_id, s.time_stamp
