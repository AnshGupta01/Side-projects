create database bankmanagementsystem;
show databases;
use bankmanagementsystem;

create table login(formno varchar(20), cardnumber varchar(25), pin varchar(10));
create table signup(formno varchar(20),name varchar(20),father_name varchar(20),dob varchar(20),gender varchar(20),email varchar(30),marital_status varchar(20),address varchar(40),city varchar(25),state varchar(25),pin varchar(20));
create table signuptwo(formno varchar(20),religion varchar(20),cateogory varchar(20),income varchar(20),education varchar(20),occupation varchar(20),pan varchar(20),aadhar varchar(20), senior_citizen varchar(20),existing_account varchar(20));
create table signupthree(ormno varchar(20),accountType varchar(25),cardNumber varchar(25),pin varchar(20), facilities varchar(100));
create table bank(pin varchar(10), date varchar(50), type varchar(20), amount varchar(20));

select * from signup;
select * from signuptwo;
select * from signupthree;
select * from bank;
select * from login;
show tables;



