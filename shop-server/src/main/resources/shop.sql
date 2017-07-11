/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50718
Source Host           : 127.0.0.1:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-07-11 19:22:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `C_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `C_NAME` varchar(50) DEFAULT NULL,
  `T_ID` int(11) unsigned DEFAULT NULL,
  `C_OWNER` varchar(50) NOT NULL,
  `ASSET_ID` varchar(255) DEFAULT NULL,
  `C_EXT` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `T_ID` (`T_ID`),
  CONSTRAINT `commodity_ibfk_1` FOREIGN KEY (`T_ID`) REFERENCES `commodity-type` (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', 'JAVA入门', '1', 'hexiuyu', '113123', null);

-- ----------------------------
-- Table structure for commodity-ext
-- ----------------------------
DROP TABLE IF EXISTS `commodity-ext`;
CREATE TABLE `commodity-ext` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `T_ID` int(10) unsigned DEFAULT NULL,
  `VALUE` varchar(50) DEFAULT NULL,
  `DESC` varchar(255) DEFAULT NULL,
  `REGEX` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `T_ID` (`T_ID`),
  CONSTRAINT `commodity-ext_ibfk_1` FOREIGN KEY (`T_ID`) REFERENCES `commodity-type` (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity-ext
-- ----------------------------
INSERT INTO `commodity-ext` VALUES ('1', '1', 'name', '书名', null);
INSERT INTO `commodity-ext` VALUES ('2', '1', 'author', '作者', null);
INSERT INTO `commodity-ext` VALUES ('3', '1', 'press', '出版社', null);
INSERT INTO `commodity-ext` VALUES ('4', '1', 'description', '简介', null);

-- ----------------------------
-- Table structure for commodity-type
-- ----------------------------
DROP TABLE IF EXISTS `commodity-type`;
CREATE TABLE `commodity-type` (
  `T_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `T_NAME` varchar(255) DEFAULT NULL,
  `T_DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`T_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commodity-type
-- ----------------------------
INSERT INTO `commodity-type` VALUES ('1', 'book', '书籍');

-- ----------------------------
-- Table structure for exchange
-- ----------------------------
DROP TABLE IF EXISTS `exchange`;
CREATE TABLE `exchange` (
  `E_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `C_ID` int(10) unsigned DEFAULT NULL,
  `E_VALUE` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`E_ID`),
  KEY `C_ID` (`C_ID`),
  CONSTRAINT `exchange_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `commodity` (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of exchange
-- ----------------------------

-- ----------------------------
-- Table structure for rent
-- ----------------------------
DROP TABLE IF EXISTS `rent`;
CREATE TABLE `rent` (
  `R_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `C_ID` int(10) unsigned NOT NULL,
  `R_PRICE` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`R_ID`),
  KEY `C_ID` (`C_ID`),
  CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `commodity` (`C_ID`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rent
-- ----------------------------

-- ----------------------------
-- Table structure for sell
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `S_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `C_ID` int(11) unsigned NOT NULL,
  `S_PRICE` decimal(7,2) DEFAULT NULL,
  PRIMARY KEY (`S_ID`),
  KEY `C_ID` (`C_ID`),
  CONSTRAINT `sell_ibfk_1` FOREIGN KEY (`C_ID`) REFERENCES `commodity` (`C_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('1', '1', '10.00');
