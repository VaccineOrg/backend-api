CREATE USER VACCINEORG IDENTIFIED BY VACCINEORG;
GRANT CONNECT TO VACCINEORG;
GRANT UNLIMITED TABLESPACE TO VACCINEORG;
GRANT create session TO VACCINEORG;
GRANT create table TO VACCINEORG;
GRANT create view TO VACCINEORG;
GRANT create any trigger TO VACCINEORG;
GRANT create any procedure TO VACCINEORG;
GRANT create sequence TO VACCINEORG;
GRANT create synonym TO VACCINEORG;

-- TABLE: VACCINE
CREATE TABLE VACCINEORG.VACCINE(
	vaccine_id_pk NUMBER(10) NOT NULL,
	vaccine_name VARCHAR2(50) NOT NULL,	
	vaccine_description VARCHAR2(200),
	date_create DATE NOT NULL,
	CONSTRAINT vaccine_name_unique UNIQUE (vaccine_name),
    CONSTRAINT vaccine_pk PRIMARY KEY  (vaccine_id_pk)
);

CREATE SEQUENCE VACCINEORG.VACCINE_SEQ START WITH 1;

-- Table: CAMPAIGN
CREATE TABLE VACCINEORG.CAMPAIGN (
	campaign_id_pk NUMBER(10) NOT NULL,
	campaign_name VARCHAR2(100) NOT NULL,
	campaign_status VARCHAR(25) NOT NULL,
	date_begin DATE NOT NULL,
	date_end DATE NOT NULL,
	date_create DATE NOT NULL,
	CONSTRAINT campaign_name UNIQUE (campaign_name),
    CONSTRAINT campaign_id_pk PRIMARY KEY (campaign_id_pk)
);

CREATE SEQUENCE VACCINEORG.CAMPAIGN_SEQ START WITH 1;

-- Table: USERS
CREATE TABLE VACCINEORG.USERS (
	user_id_pk NUMBER(10) NOT NULL,
	user_name VARCHAR2(200) NOT NULL,
	employee_id NUMBER(10) NOT NULL,
	date_create DATE  NOT NULL,
    CONSTRAINT user_id_pk PRIMARY KEY  (user_id_pk)
);

CREATE SEQUENCE VACCINEORG.USERS_SEQ START WITH 1;

-- Table: VaccineCampaign
CREATE TABLE VACCINEORG.VACCINE_CAMPAIGN(
	vaccine_campaign_id_pk NUMBER(10) NOT NULL,
	campaign_id NUMBER(10)  NOT NULL,
	vaccine_id NUMBER(10)  NOT NULL,
    date_create DATE  NOT NULL,
    number_vaccines NUMBER(6) NOT NULL,
	CONSTRAINT vaccine_campaign_id_pk PRIMARY KEY(vaccine_campaign_id_pk)
);

CREATE SEQUENCE VACCINEORG.VACCINECAMPAIGN_SEQ START WITH 1;


-- Table: UserVaccineCampaign
CREATE TABLE VACCINEORG.USER_VACCINE_CAMPAIGN (
	user_vaccine_campaign_id_pk NUMBER(10) NOT NULL,
	user_id NUMBER(10) NOT NULL,
	campaign_id NUMBER(10) NOT NULL,
	vaccine_id NUMBER(10) NOT NULL,
	date_create DATE,
	CONSTRAINT user_vaccine_campaign_id_pk PRIMARY KEY(user_vaccine_campaign_id_pk)
);

CREATE SEQUENCE VACCINEORG.USERVACCINECAMPAIGN_SEQ START WITH 1;

ALTER TABLE VACCINEORG.VACCINE_CAMPAIGN ADD CONSTRAINT FK_1_VACCINE_CAMPAIGN
    FOREIGN KEY (vaccine_id)
    REFERENCES VACCINEORG.VACCINE (vaccine_id_pk)
    ON DELETE CASCADE;


ALTER TABLE VACCINEORG.VACCINE_CAMPAIGN ADD CONSTRAINT FK_2_VACCINE_CAMPAIGN
    FOREIGN KEY (campaign_id)
    REFERENCES VACCINEORG.CAMPAIGN (campaign_id_pk)
    ON DELETE CASCADE;


ALTER TABLE VACCINEORG.USER_VACCINE_CAMPAIGN ADD CONSTRAINT FK_1_CAMPAIGN_VACCINE_USER
    FOREIGN KEY (vaccine_id)
    REFERENCES VACCINEORG.VACCINE (vaccine_id_pk)
    ON DELETE CASCADE;


ALTER TABLE VACCINEORG.USER_VACCINE_CAMPAIGN ADD CONSTRAINT FK_2_CAMPAIGN_VACCINE_USER
    FOREIGN KEY (campaign_id)
    REFERENCES VACCINEORG.CAMPAIGN (campaign_id_pk)
    ON DELETE CASCADE;


ALTER TABLE VACCINEORG.USER_VACCINE_CAMPAIGN ADD CONSTRAINT FK_3_CAMPAIGN_VACCINE_USER
    FOREIGN KEY (user_id)
    REFERENCES VACCINEORG.USERS (user_id_pk)
    ON DELETE CASCADE;





