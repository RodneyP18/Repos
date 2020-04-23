DROP DATABASE IF EXISTS SuperHeroSightings;

CREATE DATABASE SuperHeroSightings;

USE SuperHeroSightings;

CREATE TABLE Powers(
	PowerId INT Primary Key NOT NULL auto_increment,
	SuperPower varchar(20)
);

CREATE TABLE Locations(
	LocationId INT Primary Key NOT NULL auto_increment,
	LocationName varchar(40) NOT NULL,
	LocationDesc varchar(300),
	Address varchar(50),
    latitude numeric(20, 10),
	longitude numeric(20, 10)
);

CREATE TABLE Organizations(
	OrgId INT Primary Key NOT NULL auto_increment,
	OrgName varchar(30),
	OrgDesc varchar(300),
	Address varchar(50),
	Phone varchar(50),
	Email varchar(30)
);

CREATE TABLE Heroes(
	HeroId INT Primary Key NOT NULL auto_increment,
	`Name` varchar(40) not null,
	`Description` varchar(300) not null,
	PowerId INT NOT NULL,
	Foreign Key (PowerId) references Powers(PowerId)
);



CREATE TABLE HeroOrg(
	HeroId INT NOT NULL,
    OrgId INT NOT NULL,
    PRIMARY KEY pk_HeroOrg (HeroId, OrgId),
    foreign key  (HeroId) references Heroes(HeroId),
    foreign key  (OrgId) references Organizations(OrgId)
);

CREATE TABLE Sightings(
	SightingId INT Primary KEY auto_increment,
	HeroId INT NOT NULL,
    LocationId INT NOT NULL,
    SightingDate Date NOT NULL,
    foreign key  (HeroId) references Heroes(HeroId),
    foreign key  (LocationId) references Locations(LocationId)
);