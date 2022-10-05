/*
 Navicat Premium Data Transfer

 Source Server         : citelis lab docker
 Source Server Type    : MySQL
 Source Server Version : 80030 (8.0.30)
 Source Host           : 0.0.0.0:33062
 Source Schema         : citelis_lab

 Target Server Type    : MySQL
 Target Server Version : 80030 (8.0.30)
 File Encoding         : 65001

 Date: 04/10/2022 20:34:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for process
-- ----------------------------
DROP TABLE IF EXISTS `process`;
CREATE TABLE `process` (
  `id` int NOT NULL AUTO_INCREMENT,
  `envio` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `module_name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `auto_name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `bank_name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `hitch` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `term` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `client_id` int DEFAULT NULL,
  `process_id` int DEFAULT NULL,
  `seller_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `USER_ID_FK` (`client_id`),
  KEY `PROCESS_ID_FK` (`process_id`),
  KEY `SELLER_ID_FK` (`seller_id`),
  CONSTRAINT `PROCESS_ID_FK` FOREIGN KEY (`process_id`) REFERENCES `process` (`id`),
  CONSTRAINT `SELLER_ID_FK` FOREIGN KEY (`seller_id`) REFERENCES `user` (`id`),
  CONSTRAINT `USER_ID_FK` FOREIGN KEY (`client_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb3_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;

SET FOREIGN_KEY_CHECKS = 1;
