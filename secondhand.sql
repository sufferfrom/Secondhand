/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost
 Source Database       : secondhand

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : utf-8

 Date: 11/21/2018 17:41:03 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `buy`
-- ----------------------------
DROP TABLE IF EXISTS `buy`;
CREATE TABLE `buy` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `c_id` int(10) DEFAULT NULL,
  `s_id` int(10) DEFAULT NULL,
  `state` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `buy`
-- ----------------------------
BEGIN;
INSERT INTO `buy` VALUES ('1', '1', '1', '1'), ('4', '14', '4', '1'), ('5', '14', '5', '0');
COMMIT;

-- ----------------------------
--  Table structure for `customer`
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `customer`
-- ----------------------------
BEGIN;
INSERT INTO `customer` VALUES ('14', 'rain', '123', 'nylrain@163.com');
COMMIT;

-- ----------------------------
--  Table structure for `shopping`
-- ----------------------------
DROP TABLE IF EXISTS `shopping`;
CREATE TABLE `shopping` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `money` int(10) DEFAULT NULL,
  `c_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `shopping`
-- ----------------------------
BEGIN;
INSERT INTO `shopping` VALUES ('1', '44', '44', null, 'http://cos.rain1024.com/markdown/1_160x160.jpg', '44', '1'), ('4', '台灯', '台灯', null, 'http://localhost:8090/imgupload/u=716848151,2390838901&fm=27&gp=0.jpg', '12', '14'), ('5', '哈哈', '没有', null, 'http://localhost:8090/imgupload/wallhaven-59204.jpg', '100', '14');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
