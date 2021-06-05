---- -> User

INSERT INTO VACCINEORG.users values (
    VACCINEORG.users_seq.NEXTVAL, 'Bruno', 105030, to_date('23/02/2021','DD/MM/YYYY'), 'bruno@gmail.com', '1234'
);

INSERT INTO VACCINEORG.users values (
    VACCINEORG.users_seq.NEXTVAL, 'Luiz', 105031, to_date('20/05/2021','DD/MM/YYYY'), 'luiz@gmail.com', '1234'
);

INSERT INTO VACCINEORG.users values (
    VACCINEORG.users_seq.NEXTVAL, 'Gabriel', 105032, to_date('19/05/2021','DD/MM/YYYY'), 'gabriel@gmail.com', '1234'
);

INSERT INTO VACCINEORG.users values (
    VACCINEORG.users_seq.NEXTVAL, 'Gustavo', 105033, to_date('19/05/2021','DD/MM/YYYY'), 'gabriel@gmail.com', '1234'
);

----- -> Vaccine

INSERT INTO VACCINEORG.vaccine values (
    VACCINEORG.vaccine_seq.NEXTVAL, 'Coronavacc', 'Vacina contra covid-19', to_date('18/05/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.vaccine values (
    VACCINEORG.vaccine_seq.NEXTVAL, 'Vacina contra gripe', 'Vacina contra gripe 2021', to_date('18/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.vaccine values (
    VACCINEORG.vaccine_seq.NEXTVAL, 'Catapora', 'Vacina contra catapora 2021', to_date('18/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.vaccine values (
    VACCINEORG.vaccine_seq.NEXTVAL, 'Poliomielite', 'Vacina contra poliomielite 2021', to_date('18/04/2021','DD/MM/YYYY')
);

---- -> Campaign

INSERT INTO VACCINEORG.campaign values (
    VACCINEORG.campaign_seq.NEXTVAL, 'Campanha contra covid-19', 'IN_PROGRESS', to_date('18/04/2021','DD/MM/YYYY'), to_date('18/06/2021','DD/MM/YYYY'), to_date('08/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.campaign values (
    VACCINEORG.campaign_seq.NEXTVAL, 'Campanha contra Gripe', 'ACCESSION', to_date('18/04/2021','DD/MM/YYYY'), to_date('28/04/2021','DD/MM/YYYY'), to_date('08/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.campaign values (
    VACCINEORG.campaign_seq.NEXTVAL, 'Campanha contra catapora', 'CLOSED', to_date('10/03/2021','DD/MM/YYYY'), to_date('20/04/2021','DD/MM/YYYY'), to_date('22/01/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.campaign values (
    VACCINEORG.campaign_seq.NEXTVAL, 'Campanha contra Poliomielite', 'SIGN_UP', to_date('20/06/2021','DD/MM/YYYY'), to_date('20/08/2021','DD/MM/YYYY'), to_date('22/01/2021','DD/MM/YYYY')
);

---- -> VACCINE_CAMPAIGN

INSERT INTO VACCINEORG.vaccine_campaign values (
    VACCINEORG.vaccinecampaign_seq.NEXTVAL, 1, 1, to_date('20/03/2021','DD/MM/YYYY'), 200
);

INSERT INTO VACCINEORG.vaccine_campaign values (
    VACCINEORG.vaccinecampaign_seq.NEXTVAL, 2, 2, to_date('18/04/2021','DD/MM/YYYY'), 600
);

INSERT INTO VACCINEORG.vaccine_campaign values (
    VACCINEORG.vaccinecampaign_seq.NEXTVAL, 3, 3, to_date('25/04/2021','DD/MM/YYYY'), 430
);

INSERT INTO VACCINEORG.vaccine_campaign values (
    VACCINEORG.vaccinecampaign_seq.NEXTVAL, 4, 4, to_date('25/04/2021','DD/MM/YYYY'), 1640
);

---- -> USER_VACCINE_CAMPAIGN

INSERT INTO VACCINEORG.user_vaccine_campaign values (
    VACCINEORG.uservaccinecampaign_seq.NEXTVAL, 1, 1, 1, to_date('25/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.user_vaccine_campaign values (
    VACCINEORG.uservaccinecampaign_seq.NEXTVAL, 2, 2, 2, to_date('25/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.user_vaccine_campaign values (
    VACCINEORG.uservaccinecampaign_seq.NEXTVAL, 3, 3, 3, to_date('25/04/2021','DD/MM/YYYY')
);

INSERT INTO VACCINEORG.user_vaccine_campaign values (
    VACCINEORG.uservaccinecampaign_seq.NEXTVAL, 4, 4, 4, to_date('25/04/2021','DD/MM/YYYY')
);

