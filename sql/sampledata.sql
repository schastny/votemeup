#fill created table with sample data
SET FOREIGN_KEY_CHECKS = 0;


INSERT INTO proposal (proposal_name, proposal_text, proposal_result, creation_date, proposal_status_id, proposal_level_id, userd_id )VALUES 
	('Likvidirovat GAI','blabla','blablabla','2014-01-12 20:00:00', 1,1,3),
	('Pereimenovat militsiu v poitsiu','blabla','blablabla','2014-01-12 20:00:00',  1,3,1),
	('Pereimenovat Berkut v Omon','blabla','blablabla','2014-01-12 20:00:00',  1,1,6),
	('Razrewit korotkostvol','blabla','blablabla','2013-12-12 20:00:00', 1,1,2),
	('Ликвидировать автономию Крыма','blabla','blablabla','2014-01-01 20:00:00',  1,3,1),
	('Открывать переднюю дверь на троллейбусах','blabla','blablabla','2014-01-12 20:00:00',  1,2,4),
	('Снизить акциз на пиво','blabla','blablabla','2014-01-01 8:00:00',  1,1,2);


INSERT INTO userd (first_name, last_name, birth_year, sex, registration_date, email, user_login, user_password, user_status_id, role_id, country_id, region_id, city_id, district_id ) VALUES 
	('Иван','Иванов','1954','male','2012-10-12 12:30:00','df@df.df',NULL,NULL,1,1,1,3,1,6),
	('Сидор','Козлодоев','1960','male','2012-10-12 12:30:00','sdfd@mail.ru',NULL,NULL,1,1,1,3,1,7),
	('Федот','Иванов','1965','male','2012-10-12 12:30:00','df@gmail.com',NULL,NULL,1,1,1,3,2,1),
	('Аристарх','Суходрищев','1974','male','2012-10-12 12:30:00','df@df.df',NULL,NULL,1,1,1,3,2,1),
	('Иван','Абрамов','1980','male','2013-10-12 12:30:00','df@df.df',NULL,NULL,1,3,1,3,2,2),
	('Лидия','Сидорова','1980','female','2011-10-12 12:30:00','df@df.df',NULL,NULL,1,2,1,3,2,3);



INSERT INTO role (role_name, role_description) VALUES 
	('user','Can create proposals, vote, comment'  ),
	('admin','Edit comments, delete spam'  ),
	('jur_editor','Check proposals for law compliance '  );



INSERT INTO category (category_name) VALUES 
	('Силовые структуры'),
	('Общественная безопасность'),
	('Государственное устройство'),
	('Транспорт'),
	('Налогообложение');
	
INSERT INTO proposal_category (proposal_proposal_id, category_category_id ) VALUES
	(1,1),
	(2,1),
	(2,2),
	(3,1),
	(4,2),
	(5,3),
	(6,4),
	(7,5)
;	

INSERT INTO country (country_name) VALUES
	('Украина'),
	('Россия')
;

INSERT INTO region (region_name,country_id) VALUES
	('Киевская обл',1),
	('Днепропетровская обл',1),
	('АР Крым',1),
	('Рязанская обл',2)
;

INSERT INTO city (city_name, region_id) VALUES
	('Симферополь',3),
	('Севастополь',3),
	('Киев',1),
	('Рязань',4)
;

INSERT INTO district (district_name, city_id) VALUES
	('Ленинский',2),
	('Гагаринский',2),
	('Нахимовский',2),
	('Балаклавский',2),
	('Киевский',1),
	('Центральный',1),
	('Железнодорожный',1)
;
	
INSERT INTO document (doc_name, doc_url, proposal_id) VALUES
	('Конституция Украины', 'http://pornosite.net/old/const.pdf',1),
	('Фото закрытой двери','http://erjer.org.ua/ererf/pdd.jpg',2),
   ('Пиво дорогое','http://erjer.org.ua/ererf/drink.jpg',3);
	
	

INSERT INTO vote (userd_id,proposal_id, vote, vote_date) VALUES 
	(1, 1, 1, '2013-01-20 12:30:00'),
	(1, 2, 0, '2013-02-20 12:30:00'),
	(1, 6, 1, '2013-03-20 12:30:00'),
	(1, 7, 0, '2013-04-20 12:30:00'),
	(2, 3, 1, '2013-05-20 12:30:00'),
	(2, 4, 1, '2013-06-20 12:30:00'),
	(3, 6, 0, '2013-07-20 12:30:00'),
	(6, 5, 0, '2014-01-20 12:30:00'),
	(5, 6, 1, '2014-02-20 12:30:00')
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



INSERT INTO user_status (user_status) VALUES
	('active'),
	('banned'),
	('deleted')
;

INSERT INTO proposal_status (proposal_status) VALUES
	('voteActibe'),
	('inChecking'),
	('completed'),
	('uncorrect')
;


INSERT INTO proposal_level (proposal_level) VALUES
	('Государственный'),
	('Муниципальный'),
	('Региональный')
;

SET FOREIGN_KEY_CHECKS = 1;
