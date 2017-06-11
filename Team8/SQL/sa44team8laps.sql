CREATE SCHEMA `sa44team8laps` ;


USE cats;

CREATE TABLE `sa44team8laps`.`employee` (
  `employeeid` VARCHAR(15) NOT NULL,
  `managerid` VARCHAR(15) NULL,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`employeeid`));


CREATE TABLE `sa44team8laps`.`role` (
  `roleid` VARCHAR(15) NOT NULL,
  `name` VARCHAR(45) NULL,
  `description` VARCHAR(45) NULL,
  PRIMARY KEY (`roleid`));


CREATE TABLE `sa44team8laps`.`user` (
  `userid` VARCHAR(15) NOT NULL,
  `name` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `employeeid` VARCHAR(15) NULL,
  PRIMARY KEY (`userid`),
  INDEX `efk_idx` (`employeeid` ASC),
  CONSTRAINT `efk`
    FOREIGN KEY (`employeeid`)
    REFERENCES `cats`.`employee` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `sa44team8laps`.`userrole` (
  `roleid` VARCHAR(15) NOT NULL,
  `userid` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`roleid`, `userid`),
  CONSTRAINT `ufk`
    FOREIGN KEY (`userid`)
    REFERENCES `cats`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `rfk`
    FOREIGN KEY (`roleid`)
    REFERENCES `sa44team8laps`.`role` (`roleid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `sa44team8laps`.`department` (
  `departmentid` VARCHAR(15) NOT NULL,
  `managerid` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`departmentid`),
  INDEX `mfk_idx` (`managerid` ASC),
  CONSTRAINT `mfk`
    FOREIGN KEY (`managerid`)
    REFERENCES `cats`.`employee` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


CREATE TABLE `sa44team8laps`.`application` (
  `applicationid` int NOT NULL AUTO_INCREMENT,
  `employeeid` VARCHAR(15) NULL,
  `leavetype` VARCHAR(45) NULL,
  `fromdate` DATE NULL,
  `todate` DATE NULL,
  `status` VARCHAR(15) NULL,
  `reason` VARCHAR(100) NULL,
  `comments` VARCHAR(100) NULL,
  PRIMARY KEY (`applicationid`),
  INDEX `efk_idx` (`employeeid` ASC),
  CONSTRAINT `efk1`
    FOREIGN KEY (`employeeid`)
    REFERENCES `sa44team8laps`.`employee` (`employeeid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE `sa44team8laps`.`leavetype` (
  `leaveid` int NOT NULL AUTO_INCREMENT,
  `leavename` VARCHAR NOT NULL,
  `leavedescription` VARCHAR(100) NULL,
  PRIMARY KEY (`leaveid`),
  INDEX `cfk_idx` (`courseid` ASC),
  CONSTRAINT `cfk`
    FOREIGN KEY (`courseid`)
    REFERENCES `sa44team8laps`.`course` (`courseid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `sa44team8laps`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("dilbert",
"pointy",
"Dilbert");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("pointy",
"dogbert",
"Pointy");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("alice",
"pointy",
"Alice");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("wally",
"pointy",
"Wally");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("ashok",
"dilbert",
"Ashok");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("dogbert",
"",
"Dogbert");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("ted",
"",
"Ted");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("howard",
"",
"Loud Howard");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("catbert",
"dogbert",
"Catbert HR");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("ratbert",
"dogbert",
"Ratbert low form");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("bob",
"pointy",
"Bob the dino");



INSERT INTO `cats`.`employee`
(`employeeid`,
`managerid`,
`name`)
VALUES
("tina",
"",
"Tina the technical writer");



----

INSERT INTO `cats`.`role`
(`roleid`,
`name`,
`description`)
VALUES
("admin",
"Administrator",
"System administrator");


INSERT INTO `cats`.`role`
(`roleid`,
`name`,
`description`)
VALUES
("staff",
"Staff",
"Staff members");


INSERT INTO `cats`.`role`
(`roleid`,
`name`,
`description`)
VALUES
("manager",
"Manager",
"Manager");


----

INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("dilbert",
"dilbert",
"dilbert",
"dilbert");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("pointy",
"pointy",
"pointy",
"pointy");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("alice",
"alice",
"alice",
"alice");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("wally",
"wally",
"wally",
"wally");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("ashok",
"ashok",
"ashok",
"ashok");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("dogbert",
"dogbert",
"dogbert",
"dogbert");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("ted",
"ted",
"ted",
"ted");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("howard",
"howard",
"howard",
"howard");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("catbert",
"catbert",
"catbert",
"catbert");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("ratbert",
"ratbert",
"ratbert",
"ratbert");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("bob",
"bob",
"bob",
"bob");


INSERT INTO `cats`.`user`
(`userid`,
`name`,
`password`,
`employeeid`)
VALUES
("tina",
"tina",
"tina",
"tina");


----

INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("manager",
"dilbert");



INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"dilbert");



INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("manager",
"pointy");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"pointy");




INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"alice");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"wally");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"ashok");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("manager",
"dogbert");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"dogbert");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"ted");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"howard");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("admin",
"catbert");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"catbert");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"ratbert");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"bob");


INSERT INTO `cats`.`userrole`
(`roleid`,
`userid`)
VALUES
("staff",
"tina");


---

INSERT INTO `cats`.`department`
(`departmentid`,
`managerid`)
VALUES
("engineering",
"pointy");

INSERT INTO `cats`.`department`
(`departmentid`,
`managerid`)
VALUES
("hr",
"catbert");


