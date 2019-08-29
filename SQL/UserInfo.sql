CREATE TABLE UserInfo (
 id INT PRIMARY KEY UNIQUE NOT NULL AUTO_INCREMENT,
 login_id varchar(255) UNIQUE NOT NULL,
 name varchar(255) NOT NULL,
 birth_date DATE NOT NULL,
 password varchar(255) NOT NULL,
 create_date DATETIME NOT NULL,
 update_date DATETIME NOT NULL
);


insert into UserInfo
(login_id,name,birth_date,password,
create_date,update_date)
values('admin','管理者','2000-01-01','aaa',
'2017-10-06 16:31:14','2017-10-06 16:31:14');

insert into UserInfo
(login_id,name,birth_date,password,
create_date,update_date)
values('id0001','香川真司','1988-04-01','bbb',
'2017-10-06 16:31:14','2017-10-06 16:31:14');

insert into UserInfo
(login_id,name,birth_date,password,
create_date,update_date)
values('id0002','岡崎信','2009-04-23','ccc',
'2017-10-06 16:31:14','2017-10-06 16:31:14');

insert into UserInfo
(login_id,name,birth_date,password,
create_date,update_date)
values('id0003','本田圭一','1999-03-03','ddd',
'2017-10-06 16:31:14','2017-10-06 16:31:14');
