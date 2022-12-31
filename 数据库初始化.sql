CREATE DATABASE  IF NOT EXISTS `flightsys_db`;
USE `flightsys_db`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: flightsys_db
-- ------------------------------------------------------
-- Server version	8.0.19
--
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `id` tinyint NOT NULL AUTO_INCREMENT COMMENT 'id唯一标识',
  `username` varchar(20) NOT NULL COMMENT '账户名',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员表';


--
-- Table structure for table `t_flight_info`
--

DROP TABLE IF EXISTS `t_flight_info`;
CREATE TABLE `t_flight_info` (
  `flight_no` tinyint NOT NULL AUTO_INCREMENT COMMENT '航班编号（标识航班）',
  `flight_number` varchar(6) NOT NULL COMMENT '航班号（标识飞机）',
  `airline_company` varchar(50) NOT NULL COMMENT '航空公司',
  `from_city` varchar(45) NOT NULL COMMENT '始发地',
  `to_city` varchar(45) NOT NULL COMMENT '目的地',
  `stopover` varchar(45) DEFAULT NULL COMMENT '经停',
  `plan_takeoff_time` datetime NOT NULL COMMENT '计划起飞时间',
  `plan_arrival_time` datetime NOT NULL COMMENT '计划到达时间',
  `actual_takeoff_time` datetime DEFAULT NULL COMMENT '实际起飞时间',
  `actual_arrival_time` datetime DEFAULT NULL COMMENT '实际到达时间',
  `terminal` varchar(10) NOT NULL COMMENT '航站楼',
  `gate` varchar(3) NOT NULL COMMENT '登机口',
  `check_in_counter` varchar(3) NOT NULL COMMENT '值机柜台',
  `flight_statu` varchar(100) DEFAULT NULL COMMENT '航班状态',
  PRIMARY KEY (`flight_no`),
  UNIQUE KEY `flight_no_UNIQUE` (`flight_no`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='航班信息';


-- Dump completed on 2022-12-31 18:27:38
