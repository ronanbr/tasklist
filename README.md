# TaskList #

### Used Resources ###

* JAVA8
* JSF 2.2.13 
* Amazon RDS with MySQL Engine
* Hibernate
* CDI
* JPA
* TomCat8 (Local)
* Amazon Elastic Beanstalk (Hospedagem)
* Maven
* PrimeFaces 5.3

### Comments ###

* The hibernate default configuration is to "create-drop". If you restart the server, the data will be erased on database and created from scratch again. To preserve the data, you'll need to change the value of property named "hibernate.hbm2ddl.auto" to "update" on persistence.xml

### Developer ###

* Ronan Cardoso - ronan.uni@gmail.com
