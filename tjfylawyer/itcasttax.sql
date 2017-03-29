/*
SQLyog Ultimate v8.32 
MySQL - 5.5.36 : Database - itcasttax
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`itcasttax` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `complain` */

DROP TABLE IF EXISTS `complain`;

CREATE TABLE `complain` (
  `comp_id` varchar(32) NOT NULL,
  `comp_company` varchar(100) DEFAULT NULL,
  `comp_name` varchar(20) DEFAULT NULL,
  `comp_mobile` varchar(20) DEFAULT NULL,
  `is_NM` bit(1) DEFAULT NULL,
  `comp_time` datetime DEFAULT NULL,
  `comp_title` varchar(200) NOT NULL,
  `to_comp_name` varchar(20) DEFAULT NULL,
  `to_comp_dept` varchar(100) DEFAULT NULL,
  `comp_content` longtext,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `complain` */

insert  into `complain`(`comp_id`,`comp_company`,`comp_name`,`comp_mobile`,`is_NM`,`comp_time`,`comp_title`,`to_comp_name`,`to_comp_dept`,`comp_content`,`state`) values ('1','部门A','用户1','13260988888','','2017-03-27 00:00:00','1','1','1',NULL,'2'),('2',NULL,'yo','13260988888','',NULL,'2',NULL,NULL,NULL,'1'),('2c933b335b143226015b1432d02a0001',NULL,NULL,NULL,'\0','2017-03-28 17:15:26','wwwwwwwwwwwww','320test',NULL,'<p>wwwwwwwwwwwwwwww</p>','1'),('2c933b335b143226015b1433c6fa0002',NULL,NULL,NULL,'\0','2017-03-28 17:16:28','wwwwwwwwwwwww','320test',NULL,'<p>wwwwwwwwwwwwwwww</p>','0'),('2c933b335b143226015b1434a8ab0003',NULL,NULL,NULL,'\0','2017-03-28 17:17:27','wwwwwwwwwwwww','320test',NULL,'<p>wwwwwwwwwwwwwwww</p>','0'),('2c933b335b143226015b1434ddad0004',NULL,NULL,NULL,'\0','2017-03-28 17:17:40','333','320test',NULL,'<p>333333333333333333<br/></p>','0'),('3',NULL,NULL,'13260988888','',NULL,'3',NULL,NULL,NULL,'1'),('4',NULL,NULL,'13260988888','',NULL,'4',NULL,NULL,NULL,'1'),('5',NULL,NULL,NULL,'',NULL,'5',NULL,NULL,NULL,'1'),('6',NULL,NULL,NULL,'',NULL,'6',NULL,NULL,NULL,'1'),('7',NULL,NULL,NULL,'',NULL,'7',NULL,NULL,NULL,'1');

/*Table structure for table `complain_reply` */

DROP TABLE IF EXISTS `complain_reply`;

CREATE TABLE `complain_reply` (
  `reply_id` varchar(32) NOT NULL,
  `comp_id` varchar(32) NOT NULL,
  `replyer` varchar(20) DEFAULT NULL,
  `reply_dept` varchar(100) DEFAULT NULL,
  `reply_time` datetime DEFAULT NULL,
  `reply_content` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`reply_id`),
  KEY `FK6A0B84141EF57131` (`comp_id`),
  CONSTRAINT `FK6A0B84141EF57131` FOREIGN KEY (`comp_id`) REFERENCES `complain` (`comp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `complain_reply` */

insert  into `complain_reply`(`reply_id`,`comp_id`,`replyer`,`reply_dept`,`reply_time`,`reply_content`) values ('2c933b335b138abc015b138b45d90001','2',NULL,NULL,'2017-03-28 14:12:26','3333333333333333'),('2c933b335b138abc015b138b75650002','2',NULL,NULL,'2017-03-28 14:12:38','444444444444444444'),('2c933b335b138abc015b138b960b0003','2',NULL,NULL,'2017-03-28 14:12:46','555555555555555555555555555555'),('2c933b335b138abc015b138c10850004','6',NULL,NULL,'2017-03-28 14:13:18','11111111111111111111'),('2c933b335b138abc015b138c37130005','6',NULL,NULL,'2017-03-28 14:13:27','222222222222222222222'),('2c933b335b138abc015b138c72030006','6',NULL,NULL,'2017-03-28 14:13:43','3333333333333333333333333333333333333333333'),('2c933b335b13b9a5015b13bba3fd0001','4',NULL,'部门A','2017-03-28 15:05:16','11111111111111111111'),('2c933b335b13b9a5015b13bbbb2c0002','4',NULL,'部门A','2017-03-28 15:05:21','2222222222222222222222222'),('2c933b335b13b9a5015b13bbd5750003','4',NULL,'部门A','2017-03-28 15:05:28','33333333333333333333333333'),('2c933b335b13b9a5015b13bbec990004','4',NULL,'部门A','2017-03-28 15:05:34','444444444444444444444444'),('2c933b335b14bd74015b14be33840001','2c933b335b143226015b1432d02a0001',NULL,'部门A','2017-03-28 19:47:41','6666666666666'),('2c933b335b14bd74015b14be58f90002','2c933b335b143226015b1432d02a0001',NULL,'部门A','2017-03-28 19:47:50','77777777777777777'),('2c933b335b14bd74015b14be7c5c0003','2c933b335b143226015b1432d02a0001',NULL,'部门A','2017-03-28 19:47:59','8888888888888'),('2c933b335b14bd74015b14bea0a10004','2c933b335b143226015b1432d02a0001',NULL,'部门A','2017-03-28 19:48:08','99999999999999'),('40287d815b0fdaf9015b0fe84d720000','1','2','部门A','2017-03-27 21:15:34','sssss'),('40287d815b0fdaf9015b0fe86cc70001','1','2','部门A','2017-03-27 21:15:42','bbbb'),('40287d815b0fdaf9015b0fe88a120002','1','2','部门A','2017-03-27 21:15:49','3333333333333'),('40287d815b0fdaf9015b0fea49c30003','1','2','部门A','2017-03-27 21:17:44','4444444444');

/*Table structure for table `info` */

DROP TABLE IF EXISTS `info`;

CREATE TABLE `info` (
  `info_id` varchar(32) NOT NULL,
  `type` varchar(10) DEFAULT NULL,
  `source` varchar(50) DEFAULT NULL,
  `title` varchar(100) NOT NULL,
  `content` longtext,
  `memo` varchar(200) DEFAULT NULL,
  `creator` varchar(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `info` */

insert  into `info`(`info_id`,`type`,`source`,`title`,`content`,`memo`,`creator`,`create_time`,`state`) values ('2c933b335af90e4b015af91018960001','tzgg','4','4','',' 4','320test','2017-03-23 10:47:36','1'),('2c933b335af90e4b015af910358c0002','tzgg','5','5','',' ','320test','2017-03-23 10:47:47','1'),('2c933b335af90e4b015af9104e100003','nszd','6','6','','  666','320test','2017-03-23 10:47:54','1'),('2c933b335af90e4b015af91065650004','nszd','7','7','',' 7 666','320test','2017-03-23 10:48:01','0'),('40287d815af0439e015af044d41a0001','zcsd','qq','qq','<p>qqq</p>',' qq','320test','2017-03-21 17:48:38','0'),('40287d815af3f7f8015af401a08b0001','tzgg','不知道','不说','<p>是是是是是是是是是<br/></p>',' 三司使','320test','2017-03-22 11:13:08','0'),('40287d815af6627d015af6634ec80001','tzgg','2','2','<p>2</p>',' 2','320test','2017-03-22 22:19:40','1'),('40287d815af6627d015af66370350002','nszd','333','22222223','',' 333   4','320test','2017-03-22 22:19:49','1');

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` varchar(32) NOT NULL,
  `name` varchar(20) NOT NULL,
  `state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`name`,`state`) values ('6d136c6c9ae649ea995b0719217567ca','2','0'),('a25e0b2c3e9f49efb8705ef89ec2d201','1','1'),('c01591550bd640eda24da85877f13c18','55555555555555','1'),('d609e03fae2f4bd38185d452a1791a6a','4','0');

/*Table structure for table `role_privilege` */

DROP TABLE IF EXISTS `role_privilege`;

CREATE TABLE `role_privilege` (
  `role_id` varchar(32) NOT NULL,
  `code` varchar(20) NOT NULL,
  PRIMARY KEY (`role_id`,`code`),
  KEY `FK45FBD62869372004` (`role_id`),
  CONSTRAINT `FK45FBD62869372004` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_privilege` */

insert  into `role_privilege`(`role_id`,`code`) values ('6d136c6c9ae649ea995b0719217567ca','nsfw'),('6d136c6c9ae649ea995b0719217567ca','zxxx'),('a25e0b2c3e9f49efb8705ef89ec2d201','hqfw'),('a25e0b2c3e9f49efb8705ef89ec2d201','xzgl'),('c01591550bd640eda24da85877f13c18','nsfw'),('c01591550bd640eda24da85877f13c18','zxxx'),('d609e03fae2f4bd38185d452a1791a6a','zxxx');

/*Table structure for table `tmonth` */

DROP TABLE IF EXISTS `tmonth`;

CREATE TABLE `tmonth` (
  `imonth` int(50) NOT NULL,
  PRIMARY KEY (`imonth`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tmonth` */

insert  into `tmonth`(`imonth`) values (1),(2),(3),(4),(5),(6),(7),(8),(9),(10),(11),(12);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(32) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `dept` varchar(20) NOT NULL,
  `account` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `headImg` varchar(100) DEFAULT NULL,
  `gender` bit(1) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `mobile` varchar(20) DEFAULT NULL,
  `birthday` datetime DEFAULT NULL,
  `state` varchar(1) DEFAULT NULL,
  `memo` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33333351 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`name`,`dept`,`account`,`password`,`headImg`,`gender`,`email`,`mobile`,`birthday`,`state`,`memo`) values (33333339,'1','部门A','1','1',NULL,'','2222222222222222222','2','2017-03-01 00:00:00','0','2'),(33333348,'320test','部门A','320test','320test',NULL,'\0','320test','320test','2017-02-27 00:00:00','1','320test'),(33333349,'2','部门A','2','2',NULL,'','2','2','2017-02-28 00:00:00','1',''),(33333350,'3','部门A','3','3',NULL,'','3','3','2017-02-28 00:00:00','1','3');

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `role_id` varchar(32) NOT NULL,
  `user_id` varchar(32) NOT NULL,
  PRIMARY KEY (`role_id`,`user_id`),
  KEY `FK143BF46A69372004` (`role_id`),
  CONSTRAINT `FK143BF46A69372004` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`role_id`,`user_id`) values ('6d136c6c9ae649ea995b0719217567ca','33333349'),('a25e0b2c3e9f49efb8705ef89ec2d201','33333348'),('c01591550bd640eda24da85877f13c18','33333348');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
