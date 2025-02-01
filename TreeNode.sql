-- Write your PostgreSQL query statement below
 
WITH root_node AS ( 
    SELECT 
        id, 
        p_id 
    FROM Tree 
    WHERE p_id IS NULL 
), leaf_node AS ( 
    SELECT 
        t1.id, 
        t1.p_id 
    FROM Tree t1 LEFT JOIN Tree t2 
    ON t1.id = t2.p_id 
    WHERE t2.id IS NULL 
) 
 
SELECT 
    id, 
    'Root' AS type 
FROM Tree 
WHERE (id) IN (SELECT id FROM root_node) 
 
UNION 
 
SELECT 
    id, 
    'Leaf' AS type 
FROM Tree 
WHERE (id, p_id) IN (SELECT id, p_id FROM leaf_node) 
 
UNION 
 
SELECT 
    id, 
    'Inner' AS type 
From Tree 
WHERE (id) NOT IN (SELECT id FROM leaf_node) AND (id) NOT IN (SELECT id FROM root_node)
