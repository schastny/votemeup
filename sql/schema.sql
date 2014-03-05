# Скрипт пересоздает базу данных votemeup, 
# constraints пока не добавлены

DROP DATABASE votemeup;
CREATE DATABASE votemeup;
USE votemeup;
CREATE TABLE proposal (
	proposal_id INT(6) NOT NULL AUTO_INCREMENT,
	#yes_count INT(6),
	#no_count INT(6),
	proposal_name TEXT,
	proposal_text TEXT,
	proposal_result TEXT,
	creation_date DATETIME,
	#vote_start_date DATETIME,
	proposal_status_id INT(6), #FK, in separate table
	proposal_level_id INT(6), #FK, in separate table
	userd_id BIGINT(6),	#FK, autor
	categ_id BIGINT(6),	#FK
	PRIMARY KEY (proposal_id)
);




CREATE TABLE userd (
	userd_id INT(7) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50),
	#second_name VARCHAR(50),
	last_name VARCHAR(50),
	birth_year YEAR,
	sex ENUM ('male','female'),
	registration_date DATETIME,
	city VARCHAR(50),
	email VARCHAR(250),
	user_login VARCHAR(20),
	user_password VARCHAR(20),
	user_status_id INT(6),  #FK
	role_id INT(6),
	PRIMARY KEY (userd_id)
);


CREATE TABLE role (
	role_id INT(7) NOT NULL AUTO_INCREMENT,
	role_name VARCHAR(20),
	role_description VARCHAR(250),
	PRIMARY KEY (role_id)
);





CREATE TABLE category (
	category_id INT(7) NOT NULL AUTO_INCREMENT,
	category_name VARCHAR(250),
	#category_description VARCHAR(250),
	PRIMARY KEY (category_id)
);

CREATE TABLE proposal_category (   #join table for many-to-many rel
	category_id INT(6),
	proposal_id INT(6)
);


CREATE TABLE document (
	doc_id INT(7) NOT NULL AUTO_INCREMENT,
	doc_name VARCHAR(250),
	#doc_descr VARCHAR(250),
	doc_url TEXT,
	proposal_id INT,
	PRIMARY KEY (doc_id)
);






CREATE TABLE vote (
	vote_id INT(7) NOT NULL AUTO_INCREMENT,
	userd_id INT(7) NOT NULL , #PFK
	proposal_id INT(7) NOT NULL, #PFK
	vote  VARCHAR(4),
	vote_date DATETIME,
	PRIMARY KEY (vote_id)
	 #add restr only one vote for one proposal
);



CREATE TABLE commentd (
	comment_id INT(7) NOT NULL AUTO_INCREMENT,
	userd_id INT(7), #FK
	proposal_id INT(7), #FK
	comment_text TEXT,
	comment_date DATETIME,
	PRIMARY KEY (comment_id)
);

#auxilary tables
CREATE TABLE user_status (
	user_status_id INT(7) NOT NULL AUTO_INCREMENT,
	user_status VARCHAR(250),
	PRIMARY KEY (user_status_id)

);

CREATE TABLE proposal_status (
	proposal_status_id INT(7) NOT NULL AUTO_INCREMENT,
	proposal_status VARCHAR(250),
	PRIMARY KEY (proposal_status_id)

);

CREATE TABLE proposal_level (
	proposal_level_id INT(7) NOT NULL AUTO_INCREMENT,
	proposal_level VARCHAR(250),
	PRIMARY KEY (proposal_level_id)

);

