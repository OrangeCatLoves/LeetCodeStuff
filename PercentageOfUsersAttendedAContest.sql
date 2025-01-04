-- Write your PostgreSQL query statement below
-- Group by contest_id then sort them
-- contest_id ASC is used to resolve ties when percentage values are the same.
SELECT contest_id, round(count(user_id)::numeric / (SELECT count(user_id) from Users)::numeric * 100.00, 2) as percentage
FROM Register
GROUP BY contest_id
ORDER BY percentage desc, contest_id 
