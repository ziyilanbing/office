/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2017-03-13 09:15
Author: zhongqs
*/

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `datatables`;
CREATE TABLE `office`.`datatables` (
  `id` INT NOT NULL COMMENT '',
  `rendering_engine` VARCHAR(45) NULL COMMENT '',
  `browser` VARCHAR(45) NULL COMMENT '',
  `platforms` VARCHAR(45) NULL COMMENT '',
  `engine_version` VARCHAR(45) NULL COMMENT '',
  `css_grade` VARCHAR(45) NULL COMMENT '',
  `create_time` TIMESTAMP NULL COMMENT '',
  `create_by` VARCHAR(45) NULL COMMENT '',
  `update_time` TIMESTAMP NULL COMMENT '',
  `update_by` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`id`)  COMMENT '')
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `office`.`datatables` (`id`, `rendering_engine`, `browser`, `platforms`, `engine_version`, `css_grade`) VALUES ('1', 'Trident', 'Internet Explorer 4.0', 'Win 95+', ' 4 ', ' X ');