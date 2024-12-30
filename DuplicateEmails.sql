# Write your MySQL query statement below

/*
The key is the GROUP BY operation. After the GROUP BY clause groups the emails, there is only one row per unique email in the result set. The 
HAVING clause then ensures that only emails that appear more than once are included.
Since the email is already grouped (and DISTINCT isn't needed), each duplicate email is printed only once, because the GROUP BY eliminates multiple # occurrences of the same email in the result.
HAVING here serves as a filter
*/

SELECT email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;

