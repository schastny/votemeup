#fill created table with sample data

INSERT INTO proposal (proposal_text, creation_date, vote_start_date, prop_status, prop_level, userd_id, categ_id)VALUES 
	('Likvidirovat GAI','2014-01-12 20:00:00', '2014-02-12 10:00:00', 'active','state',3,1),
	('Pereimenovat militsiu v poitsiu','2014-01-12 20:00:00', '2014-02-12 10:00:00', 'active','state',1,1),
	('Pereimenovat Berkut v Omon','2014-01-12 20:00:00', '2014-02-12 10:00:00', 'active','state',6,1),
	('Razrewit korotkostvol','2013-12-12 20:00:00', '2014-02-12 10:00:00', 'active','state',2,2),
	('Ликвидировать автономию Крыма','2014-01-01 20:00:00', '2014-02-12 10:00:00', 'active','state',1,3),
	('Открывать переднюю дверь на троллейбусах','2014-01-12 20:00:00', '2014-02-12 10:00:00', 'active','local',4,4),
	('Снизить акциз на пиво','2014-01-01 8:00:00', '2014-02-12 10:00:00', 'active','state',2,5);


INSERT INTO userd (first_name, second_name, last_name, birth_year, sex, registration_date, city, email, user_login, user_password) VALUES 
	('Иван','Иванович','Иванов','1954','male','2012-10-12 12:30:00','Львов','df@df.df',NULL,NULL),
	('Сидор','Иванович','Козлодоев','1960','male','2012-10-12 12:30:00','Киев','sdfd@mail.ru',NULL,NULL),
	('Федот','Иванович','Иванов','1965','male','2012-10-12 12:30:00','Львов','df@gmail.com',NULL,NULL),
	('Аристарх','Иванович','Суходрищев','1974','male','2012-10-12 12:30:00','Львов','df@df.df',NULL,NULL),
	('Иван','Петрович','Абрамов','1980','male','2013-10-12 12:30:00','Харьков','df@df.df',NULL,NULL),
	('Лидия','Моисеевна','Сидорова','1980','female','2011-10-12 12:30:00','Алчевск','df@df.df',NULL,NULL);



INSERT INTO role (role_name, role_description) VALUES 
	('user','Can create proposals, vote, comment'  ),
	('admin','Edit comments, delete spam'  ),
	('jur_editor','Check proposals for law compliance '  );



INSERT INTO userd_role (userd_id, role_id) VALUES 
	(1,1),
	(2,1),
	(3,1),
	(4,2),
	(5,3),
	(6,1);
	
	
INSERT INTO category (categ_name) VALUES 
	('Силовые структуры'),
	('Общественная безопасность'),
	('Государственное устройство'),
	('Транспорт'),
	('Налогообложение');
	
	
INSERT INTO document (doc_name, doc_url) VALUES
	('Конституция Украины', 'http://pornosite.net/old/const.pdf'),
	('Фото закрытой двери','http://erjer.org.ua/ererf/pdd.jpg'),
   ('Пиво дорогое','http://erjer.org.ua/ererf/drink.jpg');
	
	
INSERT INTO proposal_doc  VALUES 
	(1,2),
	(6,2),
	(5,1);





INSERT INTO vote (userd_id,proposal_id, vote, vote_date) VALUES 
	(1, 1, 'yes', '2013-01-20 12:30:00'),
	(1, 2, 'no', '2013-02-20 12:30:00'),
	(1, 6, 'yes', '2013-03-20 12:30:00'),
	(1, 7, 'no', '2013-04-20 12:30:00'),
	(2, 3, 'yes', '2013-05-20 12:30:00'),
	(2, 4, 'yes', '2013-06-20 12:30:00'),
	(3, 6, 'no', '2013-07-20 12:30:00'),
	(6, 5, 'no', '2014-01-20 12:30:00'),
	(5, 6, 'yes', '2014-02-20 12:30:00')
;




INSERT INTO commentd (userd_id,proposal_id, comment_text, comment_date) VALUES 
	(1, 1, 'Фу, какая гадость', '2013-01-20 12:30:00'),
	(1, 2, 'Хрень', '2013-02-20 12:30:00'),
	(1, 6, 'Ну его', '2013-03-20 12:30:00'),
	(1, 7, 'Не стоит принимать', '2013-04-20 12:30:00'),
	(2, 3, 'yes', '2013-05-20 12:30:00'),
	(2, 4, 'yes', '2013-06-20 12:30:00'),
	(3, 6, 'По любому не стоит', '2013-07-20 12:30:00'),
	(6, 5, 'no', '2014-01-20 12:30:00'),
	
	(5, 6, 'Понаехало тут', '2014-02-20 9:30:00'),
	(1, 7, 'расстрелять всех', '2013-04-20 8:30:00'),
	(2, 3, 'Нах', '2013-05-20 7:30:00'),
	(2, 4, 'Пидорасты', '2013-06-20 6:30:00'),
	(3, 6, 'В сибирь', '2013-07-20 5:30:00'),
	(6, 5, 'Полностью поддерживаю', '2014-01-20 4:30:00'),
	(5, 6, 'Частично согласен', '2014-02-20 3:30:00')
;
