/*CREATE SCHEMA*/
/*CREATE SCHEMA TICKET_OFFICE  
CHARACTER SET = 'UTF8' 
COLLATE = 'utf8_general_ci';*/

/*CREATE TABLE SEANCE*/
/*CREATE TABLE TICKET_OFFICE.SEANCE (
    ID INT(7) NOT NULL AUTO_INCREMENT,
    UDLN INT(1),
    COUNTRY VARCHAR(50),
    TOWN VARCHAR(50),
    THEATRE VARCHAR(50),
    CINEMA_HALL VARCHAR(50),
    DATE_SEANCE DATE,
    TIME_SEANCE TIME,
    FILM_NAME VARCHAR(50),
    NUMBER_CHAIR INT,
    COST_CHAIR INT,
    PRIMARY KEY (ID)
)DEFAULT CHARSET=utf8;*/

/*CREATE TABALE USERS*/
/*/CREATE TABLE TICKET_OFFICE.USERS (
    ID INT(7) NOT NULL AUTO_INCREMENT,
    UDLN INT(1),
    LOGIN VARCHAR(50),
    PASS VARCHAR(50),
    MAIL VARCHAR(50),
    TELEPHONE VARCHAR(50),
    PRIMARY KEY (ID)
)DEFAULT CHARSET=utf8;*/

/*CREATE TABALE TICKETS*/
/*CREATE TABLE TICKET_OFFICE.TICKETS (
    ID INT(7) NOT NULL AUTO_INCREMENT,
    ID_SEANCE INT(7),
    ID_USERS INT(7),
    UDLN INT(1),
    NUMBER_CHAIR INT,
    COST_CHAIR INT,
    CHAIR_BUY VARCHAR(100),
    COMMENTARY VARCHAR(200),
    PRIMARY KEY (ID)
)DEFAULT CHARSET=utf8;*/

/*CREATE USER FOR SCHEMA*/
/*CREATE USER 'TEMP_USER_TICKET_OFFICE'@'LOCALHOST' IDENTIFIED BY '0000';
GRANT SELECT, INSERT, UPDATE ON TICKET_OFFICE.* TO 'TEMP_USER_TICKET_OFFICE'@'LOCALHOST';*/

/*drop table TICKET_OFFICE.Seance;*/
/*DROP TABLE TICKET_OFFICE.SEANCE;
DROP TABLE TICKET_OFFICE.USERS;
DROP TABLE TICKET_OFFICE.TICKETS;*/

/*INSERT INTO MBC_TABLE ( DT , NM ) VALUES('2013-10-10','Hello');*/
/*DELETE FROM TICKET_OFFICE.USERS WHERE ID<100;*/
/*SEANCE USERS TICKETS*/
SELECT  * FROM TICKET_OFFICE.USERS;