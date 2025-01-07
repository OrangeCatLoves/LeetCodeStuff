-- Write your PostgreSQL query statement below
-- Passed only 10/19 testcases. I don't know what went wrong :(
-- Top half is correct, bottom half is wrong :/
SELECT 
    min(name) as results
FROM Users
WHERE (user_id) IN (
    SELECT user_id
    FROM MovieRating
    GROUP BY user_id
    HAVING count(*) = (SELECT max(cnt) FROM (SELECT count(*) as cnt FROM MovieRating GROUP BY user_id))
)

UNION ALL

(SELECT title as results
FROM
    (SELECT movie_id, title, AVG(rating) avg_rating
    FROM MovieRating LEFT JOIN Movies USING (movie_id)
    WHERE to_char(created_at, 'YYYY-MM') = '2020-02'
    GROUP BY movie_id, title) movies_
ORDER BY avg_rating DESC, title
LIMIT 1)

-- SELECT 
--     min(title) as results
-- FROM Movies
-- WHERE (movie_id) IN (
--     SELECT movie_id
--     FROM MovieRating
--     WHERE TO_CHAR(created_at, 'YYYY-MM') = '2020-02'
--     GROUP BY movie_id
--     HAVING avg(rating) = (SELECT max(rate) FROM (SELECT avg(rating) as rate FROM MovieRating GROUP BY movie_id))
-- )  




