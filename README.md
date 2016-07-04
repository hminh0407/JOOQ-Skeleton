# JOOQ Skeleton
An example project to demonstrate how to use JOOQ with Flyway in conjunction with Spring framework for an SQL development

## Table of contents

* [Information](#information)
* [The application](#the-application)
* [Installation](#installation)

## Information

### What is JOOQ? 
http://www.jooq.org/

### DB Migration tool
* Why do we need a database migration tool? 
http://www.methodsandtools.com/tools/flyway.php
* Flyway with distributed version control 
http://www.jeremyjarrell.com/using-flyway-db-with-distributed-version-control/

### JOOQ & Flyway 
https://blog.jooq.org/2014/06/25/flyway-and-jooq-for-unbeatable-sql-development-productivity/

### JOOQ & Spring
* The classic (not use springboot):
    * http://www.jooq.org/doc/latest/manual/getting-started/tutorials/jooq-with-spring/
    * http://www.petrikainulainen.net/using-jooq-with-spring/
* Springboot 
http://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-jooq.html

## The application
* Java 8 as JVM
* Spring as DI framework
* vagrant and docker are used to create a maintainable dev environment
* flyway mvn plugin is used to migrate database with mvn task (mvn generate-sources)
* jooq code gen mvn plugin is used to generate JOOQ's class (mvn generate-sources)
* simpleflatmapper is used to map jooq's record object to POJO (Plain Old Java Object)


## Installation

### Prerequisites
* Vagrant
* Docker
* Maven

### Setup
* Make sure that docker has been started
* Copy or link Vagrantfile from vagrant/Vagrantfile to app level folder
`cp vagrant/Vagrantfile .`
`ln -s vagrant/Vagrantfile .`
* Bring up the database with 
vagrant up postgres

### Run
* Migrate database and run jooq code generator with: 
mvn generate-sources
* run Unit Test with: 
mvn test

