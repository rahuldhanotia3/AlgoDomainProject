# AlgoDomainProject

1 .As a first step you have to create data base schema as mentioned below

sql related details.

three tables
1.customer(customername,customerid)
2.seller(sellername, sellerid)
3.products(productid,productname,producttype,productcategory,productpricerange,sellerid)


create database demoproject
use demoproject

---customer table all queries---

create table customer(customername varchar(1000),customerid varchar(100));
insert into customer (customername,customerid) values ("Ramesh","customer001");
insert into customer (customername,customerid) values ("Suresh","customer002");
insert into customer (customername,customerid) values ("Mukesh","customer003");

---seller table all queries---

create table seller(sellername varchar(1000),sellerid varchar(100));
insert into seller (sellername,sellerid) values ("Rahul","seller001");
insert into seller (sellername,sellerid) values ("Rinku","seller002");
insert into seller (sellername,sellerid) values ("Mohanlal","seller003");
insert into seller (sellername,sellerid) values ("Jethalal","seller004");
insert into seller (sellername,sellerid) values ("Tawde","seller005");
insert into seller (sellername,sellerid) values ("Reddy","seller006");


create table products(productid varchar(100),productname varchar(100),producttype varchar(100),productcategory varchar(100),pricerange varchar(100),sellerid varchar(100));
insert into products(productid,productName,producttype,productcategory,pricerange,sellerid) values ("1","Laptop","Electronics","Electronics","20000-50000","1");


2. after creating all the database related tables you have to import project into intellij with gradel. 
3. after this build and run the project. 
