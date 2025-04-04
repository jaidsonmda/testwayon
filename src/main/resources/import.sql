-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

-- a) Retornar os nomes de todos os vendedores que não têm pedidos com a empresa "Samsonic".
SELECT p.Name
FROM Person p
WHERE p.ID NOT IN (
    SELECT DISTINCT o.salesperson_id
    FROM Orders o
             JOIN Customer c ON o.customer_id = c.ID
    WHERE c.Name = 'Samsonic'
);

--b) Atualizar os nomes dos vendedores que fizeram 2 ou mais pedidos, adicionando ‘*’ no final do nome.
UPDATE Person
SET Name = CONCAT(Name, '*')
WHERE ID IN (
    SELECT salesperson_id
    FROM Orders
    GROUP BY salesperson_id
    HAVING COUNT(ID) >= 2
);
-- c) Deletar todos os vendedores que fizeram pedidos para a cidade de Jackson.
DELETE FROM Person
WHERE ID IN (
    SELECT DISTINCT o.salesperson_id
    FROM Orders o
             JOIN Customer c ON o.customer_id = c.ID
    WHERE c.City = 'Jackson'
);
-- d) Retornar o total de vendas de cada vendedor, exibindo "zero" para quem não vendeu nada.
SELECT p.Name, COALESCE(SUM(o.Amount), 0) AS total_sales
FROM Person p
         LEFT JOIN Orders o ON p.ID = o.salesperson_id
GROUP BY p.Name;