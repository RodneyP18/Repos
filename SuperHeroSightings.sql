DROP DATABASE IF EXISTS SuperHeroSightings;

CREATE DATABASE SuperHeroSightings;

USE SuperHeroSightings;

CREATE TABLE Powers(
	PowerId INT Primary Key NOT NULL auto_increment,
	SuperPower varchar(20)
);

CREATE TABLE Locations(
	LocationId INT Primary Key NOT NULL auto_increment,
	LocName varchar(40) NOT NULL,
	LocDescription varchar(300),
	Address varchar(50),
	LocCoord varchar(10)
);

CREATE TABLE Organizations(
	OrgId INT Primary Key NOT NULL auto_increment,
	OrgName varchar(30),
	OrgDescriptiom varchar(300),
	Address varchar(50),
	Phone varchar(10),
	Email varchar(30)
);

CREATE TABLE Heroes(
	HeroId INT Primary Key NOT NULL auto_increment,
	`Name` varchar(40) not null,
	`Description` varchar(300) not null,
    OrgId INT not null,
	PowerId INT NOT NULL,
    Foreign Key (OrgId) references Organizations(OrgId),
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
	HeroId INT NOT NULL,
    LocationId INT NOT NULL,
    PRIMARY KEY pk_HeroSighting (HeroId, LocationId),
    foreign key  (HeroId) references Heroes(HeroId),
    foreign key  (LocationId) references Locations(LocationId)
);