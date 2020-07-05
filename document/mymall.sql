/*
 Navicat Premium Data Transfer

 Source Server         : MySql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : mymall

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 05/07/2020 18:15:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for orderdetails
-- ----------------------------
DROP TABLE IF EXISTS `orderdetails`;
CREATE TABLE `orderdetails`  (
  `orderid` int(0) NOT NULL COMMENT 'orderid',
  `productionid` int(0) NOT NULL COMMENT 'productionid',
  `number` int(0) NULL DEFAULT NULL COMMENT 'number',
  PRIMARY KEY (`orderid`, `productionid`) USING BTREE,
  INDEX `productionid`(`productionid`) USING BTREE,
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`productionid`) REFERENCES `production` (`productionId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orderdetails
-- ----------------------------
INSERT INTO `orderdetails` VALUES (3005, 1001, 8);
INSERT INTO `orderdetails` VALUES (3006, 1002, 8);
INSERT INTO `orderdetails` VALUES (3007, 1002, 8);
INSERT INTO `orderdetails` VALUES (3007, 1003, 8);

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`  (
  `orderId` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `orderNm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'name',
  PRIMARY KEY (`orderId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES (3005, '2020-07-05T18:11:18.145');
INSERT INTO `orders` VALUES (3006, '2020-07-05T18:11:27.159');
INSERT INTO `orders` VALUES (3007, '2020-07-05T18:12:13.607');

-- ----------------------------
-- Table structure for production
-- ----------------------------
DROP TABLE IF EXISTS `production`;
CREATE TABLE `production`  (
  `productionId` int(0) NOT NULL AUTO_INCREMENT,
  `productionNm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` int(0) NOT NULL DEFAULT 0,
  PRIMARY KEY (`productionId`) USING BTREE,
  INDEX `productionId`(`productionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of production
-- ----------------------------
INSERT INTO `production` VALUES (1001, 'computer', 12);
INSERT INTO `production` VALUES (1002, 'pad', 4);
INSERT INTO `production` VALUES (1003, 'phone', 12);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'role id',
  `roleName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'role name',
  `roleZh` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'role zhongwen',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (2001, 'admin', '管理员');
INSERT INTO `role` VALUES (2002, 'user', '普通用户');
INSERT INTO `role` VALUES (2003, 'test1', '测试人员1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'user id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user name',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'user password',
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user telephone',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user address',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'user email',
  `sex` enum('男','女') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '男' COMMENT 'user sex',
  `credit` int(0) NOT NULL DEFAULT 0 COMMENT 'credit',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1005 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1001, 'wang', '1234', '12345', NULL, NULL, '男', 0);
INSERT INTO `user` VALUES (1002, 'jeason', '1234', '12345', NULL, NULL, '男', 0);
INSERT INTO `user` VALUES (1003, 'test', '1234', '12345', '', NULL, '男', 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uid` int(0) NOT NULL COMMENT 'user id',
  `rid` int(0) NOT NULL COMMENT 'role id',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3004 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (3001, 1001, 2001);
INSERT INTO `user_role` VALUES (3002, 1002, 2002);
INSERT INTO `user_role` VALUES (3003, 1003, 2003);

SET FOREIGN_KEY_CHECKS = 1;
