/*
Navicat MySQL Data Transfer

Date: 2017-04-18
Author: zhongqs
*/

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'jack', 'Jz0XxZh3K2MJtAEvDhL3zA==', 'jack', 'nie', 'jack@qq.com', 'Active');
INSERT INTO `sys_user` VALUES ('2', 'admin', 'Ucpd/waMOTiZIzJRRQ2V4g==', 'admin', 'nie', 'admin@qq.com', 'Active');
INSERT INTO `sys_user` VALUES ('3', 'dba', 'xgRU1Vr3ekiTkPTDgMFu9g==', 'dba', 'nie', 'dba@qq.com', 'Active');

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'USER');
INSERT INTO `sys_role` VALUES ('2', 'DBA');
INSERT INTO `sys_role` VALUES ('3', 'ADMIN');

-- ----------------------------
-- Records of sys_user_role_rel
-- ----------------------------
INSERT INTO `sys_user_role_rel` VALUES ('1', '1');
INSERT INTO `sys_user_role_rel` VALUES ('3', '2');
INSERT INTO `sys_user_role_rel` VALUES ('2', '3');
INSERT INTO `sys_user_role_rel` VALUES ('3', '3');
