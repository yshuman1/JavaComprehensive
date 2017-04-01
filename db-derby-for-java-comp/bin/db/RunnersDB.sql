CONNECT 'jdbc:derby:MurachDB;create=true';

-- drop tables (ignore errors if they don't exist)
DROP TABLE RunnersStats;


-- create RunnersStats table
CREATE TABLE RunnersStats
(
    name VARCHAR(20), 
	runnersSpeed INT, 
	restPercentage INT
);

-- insert data into RunnersStats table
INSERT INTO RunnersStats 
(name, runnersSpeed, restPercentage)
VALUES
('Tortoise', 10, 0), 
('Hare', 100, 90),
('Dog', 50, 40),
('Cat', 30, 75);


-- view data in Products table
SELECT * FROM RunnersStats;



DISCONNECT;