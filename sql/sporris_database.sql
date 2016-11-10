SET search_path TO sporris_database;

DROP TABLE response;
DROP TABLE result;
DROP TABLE alternative;
DROP TABLE question;
DROP TABLE sporris;
DROP TABLE s_user;

CREATE TABLE s_user (
	uid SERIAL NOT NULL,
	user_name VARCHAR NOT NULL,
	user_password VARCHAR NOT NULL,
	PRIMARY KEY(uid)
);

CREATE TABLE sporris (
	sid SERIAL NOT NULL,
	sporris_name VARCHAR NOT NULL,
	sporris_user INT NOT NULL,
	sporris_tag VARCHAR(6) NOT NULL,
	active BOOLEAN,
	last_edited TIMESTAMP,
	expire_date TIMESTAMP,
	PRIMARY KEY(sid),
	FOREIGN KEY(sporris_user) REFERENCES s_user(uid)
);

CREATE TABLE question (
	qid SERIAL NOT NULL,
	question_text VARCHAR NOT NULL,
	question_sporris INT NOT NULL,
	allow_multiple BOOLEAN,
	allow_text BOOLEAN,
	list_index INT,
	PRIMARY KEY(qid),
	FOREIGN KEY(question_sporris) REFERENCES sporris(sid)
);

CREATE TABLE alternative (
	aid SERIAL NOT NULL,
	alternative_text VARCHAR NOT NULL,
	alternative_question INT NOT NULL,
	PRIMARY KEY(aid),
	FOREIGN KEY(alternative_question) REFERENCES question(qid)
);

CREATE TABLE result (
	rid SERIAL NOT NULL,
	result_name VARCHAR NOT NULL,
	result_sporris INT NOT NULL,
	PRIMARY KEY(rid),
	FOREIGN KEY(result_sporris ) REFERENCES sporris(sid)
);

CREATE TABLE response (
	response_id SERIAL NOT NULL,
	response_text VARCHAR NOT NULL,
	response_result INT NOT NULL,
	PRIMARY KEY(response_id),
	FOREIGN KEY(response_result ) REFERENCES result(rid)
);

INSERT INTO s_user VALUES (0,'Bolle','123');
INSERT INTO s_user VALUES (100,'BigOldTestUser','pass');
INSERT INTO sporris VALUES (0,'Undersøkelse',0,'123qwe',true,'2004-10-19 10:23:54','2100-10-19 10:23:54');
INSERT INTO question VALUES (0,'Heter du Geir?',0,FALSE,FALSE,0);
INSERT INTO alternative VALUES (0,'Ja',0);
INSERT INTO alternative VALUES (1,'Nei',0);


INSERT INTO sporris VALUES (100,'Undersøkelse',0,'234wer',true,'2004-10-19 10:23:54','2100-10-19 10:23:54');
INSERT INTO question VALUES (1,'Heter du Geir?',0,FALSE,FALSE,100);
INSERT INTO alternative VALUES (2,'Ja',1);
INSERT INTO alternative VALUES (3,'Nei',1);
INSERT INTO question VALUES (2,'Heter du Per?',0,FALSE,FALSE,100);
INSERT INTO alternative VALUES (4,'Ja',2);
INSERT INTO alternative VALUES (5,'Nei',2);