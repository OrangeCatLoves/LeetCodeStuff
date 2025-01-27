-- Write your PostgreSQL query statement below

WITH even_sum AS (
    SELECT 
        SUM(amount) AS total_amt,
        transaction_date
    FROM transactions
    WHERE amount % 2 = 0
    GROUP BY transaction_date
), odd_sum AS (
    SELECT
        SUM(amount) AS total_amt,
        transaction_date
    FROM transactions
    WHERE amount % 2 = 1
    GROUP BY transaction_date
)

SELECT
    COALESCE(e.transaction_date, o.transaction_date) AS transaction_date,
    COALESCE(o.total_amt, 0) AS odd_sum,
    COALESCE(e.total_amt, 0) AS even_sum
FROM even_sum e FULL JOIN odd_sum o
ON e.transaction_date = o.transaction_date
