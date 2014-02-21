# Скрипт пересоздает базу данных votemeup, 
# constraints пока не добавлены

DROP DATABASE votemeup;
CREATE DATABASE votemeup;
USE votemeup;
CREATE TABLE proposal (
	proposal_id INT(6) NOT NULL AUTO_INCREMENT,
	#yes_count INT(6),
	#no_count INT(6),
	proposal_text TEXT,
	creation_date DATETIME,
	vote_start_date DATETIME,
	prop_status ENUM ('active', 'complete', 'inChecking'),
	prop_level ENUM ('local','region','state'),
	userd_id INT(6),	#FK, autor
	categ_id INT(6),	#FK
	PRIMARY KEY (proposal_id)
);




CREATE TABLE userd (
	userd_id INT(7) NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(50),
	second_name VARCHAR(50),
	last_name VARCHAR(50),
	birth_year YEAR,
	sex ENUM ('male','female'),
	registration_date DATETIME,
	city VARCHAR(50),
	email VARCHAR(250),
	user_login VARCHAR(20),
	user_password VARCHAR(20),
	PRIMARY KEY (userd_id)
);


CREATE TABLE role (
	role_id INT(7) NOT NULL AUTO_INCREMENT,
	role_name VARCHAR(20),
	role_description VARCHAR(250),
	PRIMARY KEY (role_id)
);



CREATE TABLE userd_role (
	userd_id INT(7) NOT NULL , #PF
	role_id INT(7)  NOT NULL ,#PF
   PRIMARY KEY (userd_id, role_id)
);




CREATE TABLE category (
	categ_id INT(7) NOT NULL AUTO_INCREMENT,
	categ_name VARCHAR(250),
	#category_description VARCHAR(250),
	PRIMARY KEY (categ_id)
);




CREATE TABLE document (
	doc_id INT(7) NOT NULL AUTO_INCREMENT,
	doc_name VARCHAR(250),
	#doc_descr VARCHAR(250),
	doc_url TEXT,
	PRIMARY KEY (doc_id)
);



CREATE TABLE proposal_doc (
	proposal_id INT(7), #PF
	doc_id INT(7) #PF
	PRIMARY KEY (proposal_id, doc_id) # there are no duplicated documents
	
);




CREATE TABLE vote (
	#vote_id INT(7) NOT NULL AUTO_INCREMENT,
	userd_id INT(7) NOT NULL , #PFK
	proposal_id INT(7) NOT NULL, #PFK
	vote ENUM ('yes','no'),
	vote_date DATETIME,
	PRIMARY KEY (userd_id, proposal_id) #only one vote for one proposal
);



CREATE TABLE commentd (
	comment_id INT(7) NOT NULL AUTO_INCREMENT,
	userd_id INT(7), #FK
	proposal_id INT(7), #FK
	comment_text TEXT,
	comment_date DATETIME,
	PRIMARY KEY (comment_id)
);

