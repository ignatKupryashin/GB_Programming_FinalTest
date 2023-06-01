-- В подключенном MySQL репозитории создать базу данных “Друзья человека”
DROP DATABASE IF EXISTS humanFriends;
CREATE DATABASE humanFriends;
USE humanFriends;


-- Создать таблицы с иерархией из диаграммы в БД
CREATE TABLE cats (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animalName VARCHAR(20),
    commands VARCHAR(500),
    birthday DATE
);
CREATE TABLE dogs (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animalName VARCHAR(20),
    commands VARCHAR(500),
    birthday DATE
);
CREATE TABLE humsters (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animalName VARCHAR(20),
    commands VARCHAR(500),
    birthday DATE
);
CREATE TABLE horses (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animalName VARCHAR(20),
    commands VARCHAR(500),
    birthday DATE
);
CREATE TABLE camels (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animalName VARCHAR(20),
    commands VARCHAR(500),
    birthday DATE
);
CREATE TABLE donkeys (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    animalName VARCHAR(20),
    commands VARCHAR(500),
    birthday DATE
);



-- Заполнить низкоуровневые таблицы именами(животных), командами которые они выполняют и датами рождения
INSERT INTO cats (animalName, commands, birthday) values
('Веник', 'Кушать', '2012-12-12'),
('Катя', 'Кусать', '2017-01-07'),
('Пушок', 'Спать, Кусать', '2020-06-03');

INSERT INTO dogs (animalName, commands, birthday) values
('Бобик', 'Сидеть', '2012-12-12'),
('Рекс', 'Рядом', '2022-01-07'),
('Джейн', 'Сидеть', '2020-03-03');

INSERT INTO humsters (animalName, commands, birthday) values
('Хома', 'Грызть', '2012-12-12'),
('Хомка', 'Грызть', '2021-01-07'),
('Хомище', 'Грызть', '2023-03-03');

INSERT INTO horses (animalName, commands, birthday) values
('Грэй', 'Но', '2012-12-12'),
('Плотва', 'Шевелись', '2022-01-07'),
('Джейн', 'Сидеть', '2023-03-03');

INSERT INTO camels (animalName, commands, birthday) values
('Лайт', 'Плевать', '2012-12-12'),
('Блэк', 'Идти', '2022-01-07'),
('Широгуб', 'Сидеть', '2020-03-03');

INSERT INTO donkeys (animalName, commands, birthday) values
('ИА', 'Грустить', '2012-12-12'),
('Осел', 'Говорить', '2022-01-07'),
('Товарищ', 'Идти', '2020-03-03');


-- select * from cats;
-- select * from dogs;
-- select * from humsters;
-- select * from horses;
-- select * from camels;
-- select * from donkeys;

-- Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. 
DELETE FROM camels WHERE id != 0;

-- Объединить таблицы лошади, и ослы в одну таблицу. 
CREATE TABLE horsesAndDonkeys(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
	SELECT animalName, commands, birthday, 'Лошадь' as type FROM horses
    UNION
    SELECT animalName, commands, birthday, 'Осел' as type FROM donkeys;
    
-- 11.Создать новую таблицу “молодые животные” в которую попадут все животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице
CREATE TABLE youngAnimals(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
	SELECT 
		animalName,
        commands,
        birthday,
        ROUND(TIMESTAMPDIFF(MONTH, birthday, NOW()) DIV 12 + TIMESTAMPDIFF(MONTH, birthday, NOW()) % 12 / 100, 2) as age
	FROM cats
    WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) > 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) < 3
    UNION
    SELECT 
		animalName,
        commands,
        birthday,
        ROUND(TIMESTAMPDIFF(MONTH, birthday, NOW()) DIV 12 + TIMESTAMPDIFF(MONTH, birthday, NOW()) % 12 / 100, 2) as age
	FROM dogs
    WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) > 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) < 3
    UNION
    SELECT 
		animalName,
        commands,
        birthday,
        ROUND(TIMESTAMPDIFF(MONTH, birthday, NOW()) DIV 12 + TIMESTAMPDIFF(MONTH, birthday, NOW()) % 12 / 100, 2) as age
	FROM humsters
    WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) > 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) < 3
    UNION
    SELECT 
		animalName,
        commands,
        birthday,
        ROUND(TIMESTAMPDIFF(MONTH, birthday, NOW()) DIV 12 + TIMESTAMPDIFF(MONTH, birthday, NOW()) % 12 / 100, 2) as age
	FROM horses
    WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) > 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) < 3
    UNION
    SELECT 
		animalName,
        commands,
        birthday,
        ROUND(TIMESTAMPDIFF(MONTH, birthday, NOW()) DIV 12 + TIMESTAMPDIFF(MONTH, birthday, NOW()) % 12 / 100, 2) as age
	FROM donkeys
    WHERE TIMESTAMPDIFF(YEAR, birthday, NOW()) > 1 AND TIMESTAMPDIFF(YEAR, birthday, NOW()) < 3;
    
   -- SELECT * from youngAnimals;

-- Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам. 

CREATE TABLE humanFriends(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY)
SELECT
	animalName,
    commands,
    birthday,
    id as oldId,
    'cats' as oldTable
FROM cats
UNION
SELECT
	animalName,
    commands,
    birthday,
    id as oldId,
    'dogs' as oldTable
FROM dogs
UNION
SELECT
	animalName,
    commands,
    birthday,
    id as oldId,
    'humsters' as oldTable
FROM humsters
UNION
SELECT
	animalName,
    commands,
    birthday,
    id as oldId,
    'horses' as oldTable
FROM horses
UNION
SELECT
	animalName,
    commands,
    birthday,
    id as oldId,
    'donkeys' as oldTable
FROM donkeys;

-- SELECT * FROM humanFriends;
