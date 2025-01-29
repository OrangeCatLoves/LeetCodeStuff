-- Write your PostgreSQL query statement below

WITH odd_id AS (
    SELECT
        id,
        student
    FROM Seat
    WHERE id % 2 = 1
), even_id AS (
    SELECT
        id,
        student
    FROM Seat
    WHERE id % 2 = 0
)

SELECT * FROM (
    SELECT
        o.id,
        e.student
    FROM odd_id o INNER JOIN even_id e
    ON o.id + 1 = e.id

    UNION

    SELECT
        e.id,
        o.student
    FROM odd_id o INNER JOIN even_id e
    ON o.id + 1 = e.id

    UNION

    SELECT
        id,
        student
    FROM Seat
    WHERE id = (SELECT COUNT(*) FROM Seat) AND id % 2 = 1
) ORDER BY id ASC
