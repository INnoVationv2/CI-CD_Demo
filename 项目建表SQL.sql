/*
 Navicat Premium Data Transfer

 Source Server         : docker
 Source Server Type    : MySQL
 Source Server Version : 80027
 Source Host           : localhost:3306
 Source Schema         : smart_agriculture

 Target Server Type    : MySQL
 Target Server Version : 80027
 File Encoding         : 65001

 Date: 05/05/2022 14:55:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for EQUIP
-- ----------------------------
DROP TABLE IF EXISTS `EQUIP`;
CREATE TABLE `EQUIP` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `farm_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of EQUIP
-- ----------------------------
BEGIN;
INSERT INTO `EQUIP` (`id`, `name`, `status`, `farm_id`) VALUES (1, '抽水泵', '运行中', 1);
INSERT INTO `EQUIP` (`id`, `name`, `status`, `farm_id`) VALUES (2, '浇灌机', '停止工作', 1);
INSERT INTO `EQUIP` (`id`, `name`, `status`, `farm_id`) VALUES (3, '空调', '运行中', 1);
INSERT INTO `EQUIP` (`id`, `name`, `status`, `farm_id`) VALUES (4, '抽水泵', '停止工作', 2);
INSERT INTO `EQUIP` (`id`, `name`, `status`, `farm_id`) VALUES (5, '浇灌机', '运行中', 2);
COMMIT;

-- ----------------------------
-- Table structure for FARM_LAND
-- ----------------------------
DROP TABLE IF EXISTS `FARM_LAND`;
CREATE TABLE `FARM_LAND` (
  `id` int NOT NULL AUTO_INCREMENT,
  `location` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `crop` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `status` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of FARM_LAND
-- ----------------------------
BEGIN;
INSERT INTO `FARM_LAND` (`id`, `location`, `crop`, `status`, `comment`) VALUES (1, '40.22077N,116.2312E', '玉米', '良好', '承包自王宇');
INSERT INTO `FARM_LAND` (`id`, `location`, `crop`, `status`, `comment`) VALUES (2, '40.22077N,116.2312E', '黄瓜', '较差', '还剩一年到期');
INSERT INTO `FARM_LAND` (`id`, `location`, `crop`, `status`, `comment`) VALUES (3, '王家村', '大大大南瓜', '不行了要', '地不行，人也不行');
INSERT INTO `FARM_LAND` (`id`, `location`, `crop`, `status`, `comment`) VALUES (4, '王家村', '大大大南瓜', '不行了要', '地不行，人也不行');
INSERT INTO `FARM_LAND` (`id`, `location`, `crop`, `status`, `comment`) VALUES (5, '王家村', '大大大南瓜', '不行了要', '地不行，人也不行');
INSERT INTO `FARM_LAND` (`id`, `location`, `crop`, `status`, `comment`) VALUES (6, '王家村', '大大大南瓜', '不行了要', '地不行，人也不行');
COMMIT;

-- ----------------------------
-- Table structure for FARM_MONITOR
-- ----------------------------
DROP TABLE IF EXISTS `FARM_MONITOR`;
CREATE TABLE `FARM_MONITOR` (
  `id` int NOT NULL AUTO_INCREMENT,
  `farm_id` int DEFAULT NULL,
  `monitor_time` datetime DEFAULT NULL,
  `temp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ph` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `moi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `salt` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of FARM_MONITOR
-- ----------------------------
BEGIN;
INSERT INTO `FARM_MONITOR` (`id`, `farm_id`, `monitor_time`, `temp`, `ph`, `moi`, `salt`) VALUES (1, 1, '2022-05-04 22:50:44', '38', '6', '60', '11');
INSERT INTO `FARM_MONITOR` (`id`, `farm_id`, `monitor_time`, `temp`, `ph`, `moi`, `salt`) VALUES (2, 1, '2022-05-20 22:54:59', '77', '88', '55', '44');
COMMIT;

-- ----------------------------
-- Table structure for FRUIT
-- ----------------------------
DROP TABLE IF EXISTS `FRUIT`;
CREATE TABLE `FRUIT` (
  `id` int NOT NULL AUTO_INCREMENT,
  `farm_id` int DEFAULT NULL,
  `sale_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of FRUIT
-- ----------------------------
BEGIN;
INSERT INTO `FRUIT` (`id`, `farm_id`, `sale_date`, `start_date`, `end_date`) VALUES (1, 1, '2022-05-05', '2022-05-01', '2022-05-24');
COMMIT;

-- ----------------------------
-- Table structure for SPECIALIST
-- ----------------------------
DROP TABLE IF EXISTS `SPECIALIST`;
CREATE TABLE `SPECIALIST` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `specialize` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `work_time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of SPECIALIST
-- ----------------------------
BEGIN;
INSERT INTO `SPECIALIST` (`id`, `name`, `specialize`, `work_time`, `phone`) VALUES (1, '王建军', '苹果树', '9:00 - 18:00', '18888888888');
COMMIT;

-- ----------------------------
-- Table structure for USER
-- ----------------------------
DROP TABLE IF EXISTS `USER`;
CREATE TABLE `USER` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of USER
-- ----------------------------
BEGIN;
INSERT INTO `USER` (`id`, `username`, `password`, `email`, `phone`) VALUES (1, 'sid01', '681201', '270815979@qq.com', '7758521');
INSERT INTO `USER` (`id`, `username`, `password`, `email`, `phone`) VALUES (2, 'sid02', '681201', '123456@gmail.com', '18888888888');
INSERT INTO `USER` (`id`, `username`, `password`, `email`, `phone`) VALUES (4, 'sid03', '888888', '12345@gmail.com', '123456');
INSERT INTO `USER` (`id`, `username`, `password`, `email`, `phone`) VALUES (5, 'sid05', '888888', '12345@gmail.com', '123456');
COMMIT;

-- ----------------------------
-- Table structure for WEATHER
-- ----------------------------
DROP TABLE IF EXISTS `WEATHER`;
CREATE TABLE `WEATHER` (
  `id` int NOT NULL AUTO_INCREMENT,
  `monitor_time` datetime DEFAULT NULL,
  `temp` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `humi` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `wind` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `rain` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

-- ----------------------------
-- Records of WEATHER
-- ----------------------------
BEGIN;
INSERT INTO `WEATHER` (`id`, `monitor_time`, `temp`, `humi`, `wind`, `rain`) VALUES (1, '2022-05-05 12:58:25', '28', '12', '23', '97');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
