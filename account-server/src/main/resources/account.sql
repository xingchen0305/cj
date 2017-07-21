/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : account

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-17 18:07:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `account_name` varchar(100) NOT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`account_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('zhangnan', '女', '11');

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `postcode` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `account_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `account_name` (`account_name`),
  CONSTRAINT `address_ibfk_1` FOREIGN KEY (`account_name`) REFERENCES `account` (`account_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('2', '中国北京', null, '123141241', 'zhangnan');

-- ----------------------------
-- Table structure for star
-- ----------------------------
DROP TABLE IF EXISTS `star`;
CREATE TABLE `star` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(255) DEFAULT NULL,
  `startime` datetime DEFAULT NULL,
  `account_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `star_ibfk_1` (`account_name`),
  CONSTRAINT `star_ibfk_1` FOREIGN KEY (`account_name`) REFERENCES `account` (`account_name`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of star
-- ----------------------------
INSERT INTO `star` VALUES ('7', 'dsfaf', '2017-07-17 17:44:03', 'zhangnan');
