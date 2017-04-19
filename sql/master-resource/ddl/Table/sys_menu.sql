/*
Navicat MySQL Data Transfer

Date: 2017-04-18
Author: zhongqs
*/
-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------

DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `office`.`sys_menu` (
  `MENU_PK` INT NOT NULL,
  `MENU_ID` VARCHAR(10) NULL COMMENT '菜单ID',
  `MENU_NAME` VARCHAR(45) NULL COMMENT '菜单名称',
  `MENU_URL` VARCHAR(45) NULL COMMENT '菜单URL',
  `PARENT_MENU_ID` VARCHAR(10) NULL COMMENT '父层菜单ID',
  `DISPLAY_ORDER` VARCHAR(2) NULL COMMENT '显示顺序',
  `CREATE_BY` VARCHAR(10) NULL COMMENT '作成者',
  `CREATE_IP` VARCHAR(20) NULL COMMENT '作成者IP',
  `CREATE_TIME` TIMESTAMP NULL COMMENT '作成时间',
  `UPDATE_BY` VARCHAR(10) NULL,
  `UPDATE_IP` VARCHAR(20) NULL,
  `UPDATE_TIME` TIMESTAMP NULL,
  PRIMARY KEY (`MENU_PK`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('1', '00000', 'Glad Office', 'top/init', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('2', '00000', '工时管理', '#', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('3', '00000', '工时登记', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('4', '00000', '工时明细查询', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('5', '00000', '工时合计查询', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('6', '00000', '休假管理', '#', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('7', '00000', '休假申请', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('8', '00000', '休假修改', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('9', '00000', '休假查询', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
INSERT INTO `office`.`sys_menu` (`MENU_PK`, `MENU_ID`, `MENU_NAME`, `MENU_URL`, `CREATE_BY`, `CREATE_IP`, `CREATE_TIME`, `UPDATE_BY`, `UPDATE_IP`, `UPDATE_TIME`)VALUES ('10', '00000', '有薪休假统计', '####', 'admin', '10.10.0.201', '2017/4/18 17:05', 'admin', '10.10.0.201', '2017/4/18 17:05');
