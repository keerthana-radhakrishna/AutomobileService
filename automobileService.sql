------employee login table-------
create table loginkr (username varchar(25),password varchar(25),empid number);
alter table loginkr add primary key(empid);

insert into loginkr values('ramesh','ra123',101);
insert into loginkr values('suresh','su123',102);
insert into loginkr values('keerthana','ke123',106);


------customer table-------
create table customerk (cusname varchar(25),phonenumber varchar(25),carnumber varchar(25));
alter table customerk add primary key(phonenumber);

select * from customerk;

--insert into customerk values('ria','346456','ty76');

------car services table---
create table carservices (serviceid number,carnumber varchar(25),services varchar(25));
alter table carservices add primary key(serviceid);

select * from carservices;

--insert into carservices values('ria','346456','ty76');

-----sequence for serviceid-----
CREATE SEQUENCE ser_id MINVALUE 1 START WITH 1 INCREMENT BY 1

------services table----
create table serviceskr (services varchar(25),grossamt number);
alter table serviceskr add primary key(services);

insert into serviceskr values('polishing',6000);
insert into serviceskr values('wheelbalancing',8000);
insert into serviceskr values('decors',12000);

ALTER TABLE carservices ADD FOREIGN KEY (services) REFERENCES serviceskr(services);

------insurance table----
create table insurancekr (carnumber varchar(25),services varchar(25),amt number);

insert into insurancekr values('jm-98','wheelbalancing', 2000);
insert into insurancekr values('rt09','decors', 3000);
insert into insurancekr values('mh-8-t-908','polishing', 5000);

select * from insurancekr;
