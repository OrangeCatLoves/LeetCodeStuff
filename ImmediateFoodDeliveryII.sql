-- Write your PostgreSQL query statement below

WITH extracted_table AS (
    SELECT
        customer_id,
        order_date,
        CASE WHEN order_date = customer_pref_delivery_date THEN 1 ELSE 0 END AS imm
    FROM Delivery
    WHERE (customer_id, order_date) IN (
        SELECT
            customer_id,
            MIN(order_date) AS earliest_date
        FROM Delivery
        GROUP BY customer_id
    )
)

SELECT ROUND((SUM(imm)::numeric / (SELECT COUNT(customer_id) FROM extracted_table)) * 100, 2) AS immediate_percentage
FROM extracted_table
