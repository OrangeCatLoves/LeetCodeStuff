-- Write your PostgreSQL query statement below
-- What this query does is to first find the earliest date, and then checking to see if a date-entry exists as well on the day after
-- If there exists such a date, it means that the user did login within 2 consecutive days and is added to the table.
-- This counts the number of players with successful consecutive 2 day logins
-- The inner subquery calculates the total number of distinct ids (Denominator)

SELECT ROUND(
    COUNT(player_id)::numeric / 
    (SELECT COUNT(DISTINCT player_id)
    FROM Activity), 2) AS fraction
FROM Activity
WHERE (player_id, event_date) IN (
    SELECT player_id, MIN(event_date) + 1
    FROM Activity
    GROUP BY player_id
)
