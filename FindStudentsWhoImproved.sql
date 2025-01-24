-- Write your PostgreSQL query statement below

WITH latest_date AS (
    SELECT -- Table containing the latest date of the exam for specific student + subject
        student_id,
        subject,
        MAX(exam_date)
    FROM Scores
    GROUP BY (student_id, subject)
),
earliest_date AS (
    SELECT -- Table containing the earliest date of the exam for specific student + subject
        student_id,
        subject,
        MIN(exam_date)
    FROM Scores
    GROUP BY (student_id, subject)
),
combined_dates AS (
    SELECT
        student_id,
        subject,
        score,
        exam_date
    FROM Scores
    WHERE (student_id, subject, exam_date) IN (
        (SELECT * FROM latest_date)
        UNION 
        (SELECT * FROM earliest_date)
    )
),
joined_table AS (
    SELECT
        c1.student_id,
        c1.subject,
        c1.score AS first_score,
        c2.score AS latest_score
    FROM combined_dates c1 INNER JOIN combined_dates c2
    ON c1.student_id = c2.student_id AND c1.subject = c2.subject
    WHERE c2.exam_date > c1.exam_date AND c2.score > c1.score
)

SELECT * FROM joined_table
ORDER BY (student_id, subject) ASC
