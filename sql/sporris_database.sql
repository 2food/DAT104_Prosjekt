SET search_path TO sporris_database;

DROP TABLE response;
DROP TABLE result;
DROP TABLE alternative;
DROP TABLE question;
DROP TABLE sporris;
DROP TABLE s_user;

CREATE TABLE s_user (
	uid INT NOT NULL,
	user_name VARCHAR NOT NULL,
	user_password VARCHAR NOT NULL,
	PRIMARY KEY(uid)
);

CREATE TABLE sporris (
	sid INT NOT NULL,
	sporris_name VARCHAR NOT NULL,
	sporris_user INT NOT NULL,
	sporris_tag VARCHAR(6) NOT NULL,
	active BOOLEAN,
	PRIMARY KEY(sid),
	FOREIGN KEY(sporris_user) REFERENCES s_user(uid)
);

CREATE TABLE question (
	qid INT NOT NULL,
	question_text VARCHAR NOT NULL,
	question_sporris INT NOT NULL,
	allow_multiple BOOLEAN,
	allow_text BOOLEAN,
	PRIMARY KEY(qid),
	FOREIGN KEY(question_sporris) REFERENCES sporris(sid)
);

CREATE TABLE alternative (
	aid INT NOT NULL,
	alternative_text VARCHAR NOT NULL,
	alternative_question INT NOT NULL,
	PRIMARY KEY(aid),
	FOREIGN KEY(alternative_question) REFERENCES question(qid)
);

CREATE TABLE result (
	rid INT NOT NULL,
	result_name VARCHAR NOT NULL,
	result_sporris INT NOT NULL,
	PRIMARY KEY(rid),
	FOREIGN KEY(result_sporris ) REFERENCES sporris(sid)
);

CREATE TABLE response (
	response_id INT NOT NULL,
	response_text VARCHAR NOT NULL,
	resonse_result INT NOT NULL,
	PRIMARY KEY(response_id),
	FOREIGN KEY(resonse_result ) REFERENCES result(rid)
);

INSERT INTO s_user VALUES (0,'user1','pass');
INSERT INTO sporris VALUES (0,'Undersøkelse',0,'123qwe',true);
INSERT INTO question VALUES (0,'Heter du Geir?',0,FALSE,FALSE);
INSERT INTO alternative VALUES (0,'Ja',0);
INSERT INTO alternative VALUES (1,'Nei',0);
INSERT INTO result VALUES (0,'Aktiv',0);
INSERT INTO response VALUES (0,'sp1_0',0);
INSERT INTO response VALUES (1,'sp1_1',0);