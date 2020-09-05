/*
 Navicat Premium Data Transfer

 Source Server         : localhost.docker.mysql8
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 30/08/2020 19:29:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for aio_users
-- ----------------------------
DROP TABLE IF EXISTS `aio_users`;
CREATE TABLE `aio_users` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(64) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of aio_users
-- ----------------------------
BEGIN;
INSERT INTO `aio_users` VALUES (1, '5e00c197-eab3-11ea-ae6a-0242ac110003', 'toni');
INSERT INTO `aio_users` VALUES (2, '814322c7-eab3-11ea-ae6a-0242ac110003', 'billie');
INSERT INTO `aio_users` VALUES (3, '85c7cd9a-eab3-11ea-ae6a-0242ac110003', 'griffin');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
