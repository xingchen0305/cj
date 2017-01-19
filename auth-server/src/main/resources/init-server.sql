/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50712
 Source Host           : localhost
 Source Database       : qy_oauth2

 Target Server Type    : MySQL
 Target Server Version : 50712
 File Encoding         : utf-8

 Date: 10/29/2016 16:56:01 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `authorities`
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `authorities`
-- ----------------------------
BEGIN;
INSERT INTO `authorities` VALUES ('1', 'VIEW_FLIGHT', '查看Flight', null);
COMMIT;

-- ----------------------------
--  Table structure for `oauth_access_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `oauth_client_details`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(256) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `oauth_client_details`
-- ----------------------------
BEGIN;
INSERT INTO `oauth_client_details` VALUES ('qy-admin-client', 'oauth2-resource', '$2a$10$hTGtbco/ZqgvosoQVWdOdeKYBcJSspdPpVtfqyF7uUUBVz0UtBXWy', 'read,write,openid', 'password,refresh_token', 'http://localhost:8080/qydcos/login', 'ROLE_ADMIN', '1800', null, null, null), ('qy-client', 'oauth2-resource', '$2a$10$hTGtbco/ZqgvosoQVWdOdeKYBcJSspdPpVtfqyF7uUUBVz0UtBXWy', 'read,write,openid', 'password,authorization_code,refresh_token', 'http://localhost:8080/qydcos/login', 'ROLE_CLIENT', '1800', null, null, null);
COMMIT;

-- ----------------------------
--  Table structure for `oauth_client_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_token`;
CREATE TABLE `oauth_client_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `oauth_code`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_code`;
CREATE TABLE `oauth_code` (
  `code` varchar(256) DEFAULT NULL,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `oauth_refresh_token`
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `remark` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', 'ROLE_ADMIN', '管理员', null), ('2', 'ROLE_USER', '普通用户', null);
COMMIT;

-- ----------------------------
--  Table structure for `role_authorities`
-- ----------------------------
DROP TABLE IF EXISTS `role_authorities`;
CREATE TABLE `role_authorities` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `auth_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_role_authorities_role_id` (`role_id`),
  KEY `fk_role_authorities_auth_id` (`auth_id`),
  CONSTRAINT `fk_role_authorities_auth_id` FOREIGN KEY (`auth_id`) REFERENCES `authorities` (`id`),
  CONSTRAINT `fk_role_authorities_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `role_authorities`
-- ----------------------------
BEGIN;
INSERT INTO `role_authorities` VALUES ('1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_role_role_id` (`role_id`),
  KEY `fk_user_role_user_id` (`user_id`) USING BTREE,
  CONSTRAINT `fk_user_role_role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `fk_user_role_user_id` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `user_role`
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES ('1', '5', '1'), ('3', '8', '2'), ('4', '9', '2');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(500) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `iaas_user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', 'admin', '$2a$10$hTGtbco/ZqgvosoQVWdOdeKYBcJSspdPpVtfqyF7uUUBVz0UtBXWy', '1', null), ('2', 'foo', '$2a$10$VoCa.XcXhzU8mjfCvxDAwuGxcz9NDV4XhKBtHZRH82psCj3JJsm3.', '1', null), ('3', 'john', '$2a$10$hTGtbco/ZqgvosoQVWdOdeKYBcJSspdPpVtfqyF7uUUBVz0UtBXWy', '1', null), ('4', 'johnzhang', '$2a$10$jecT7Idr.sl0iED2UC7fxulozbdTwVk7Gr8c4sk0hYachGBw0.9MC', '1', null), ('5', 'juntest', '$2a$10$hTGtbco/ZqgvosoQVWdOdeKYBcJSspdPpVtfqyF7uUUBVz0UtBXWy', '1', '123456789'), ('8', 'foo1', '$2a$10$NZ1RCJtMvMqUEs53PgLVgOKA5TEeIPh723JdVdLr/imwklXeAam/e', '1', '123456789'), ('9', 'robot-1', '$2a$10$SEc6dHDp1sKwViIa5IQF1OMkVKWXJbEGH7yduHaxiXCqLSYUYsTye', '1', '123456789');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
