/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80025
 Source Host           : 127.0.0.1:3306
 Source Schema         : zero

 Target Server Type    : MySQL
 Target Server Version : 80025
 File Encoding         : 65001

 Date: 14/03/2022 23:23:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
                            `id`           bigint                                                       NOT NULL AUTO_INCREMENT COMMENT '主键id',
                            `system_id`    bigint                                                       NOT NULL COMMENT '适用系统的id（备用）',
                            `code`         varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '编码（备用）',
                            `name`         varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '名中文称',
                            `name_english` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci          DEFAULT NULL COMMENT '英文名称',
                            `sort`         smallint                                                     NOT NULL COMMENT '排序用权重（数字小的在前面）',
                            `parent_id`    int                                                                   DEFAULT '0' COMMENT '父级id',
                            `level`        smallint                                                     NOT NULL DEFAULT '1' COMMENT '级别，1=第一级，2=第二级，，，',
                            `state`        smallint                                                     NOT NULL DEFAULT '0' COMMENT '状态，暂时规划true=非0/false=0',
                            `url`          varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         DEFAULT NULL COMMENT '菜单URL地址',
                            `icon`         varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         DEFAULT NULL COMMENT 'icon地址',
                            `remark`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci         DEFAULT NULL COMMENT '备注',
                            `create_time`  datetime                                                              DEFAULT NULL COMMENT '创建时间',
                            `update_time`  datetime                                                              DEFAULT NULL COMMENT '更新时间',
                            PRIMARY KEY (`id`) USING BTREE,
                            KEY            `inx_name` (`name`) USING BTREE COMMENT '名称索引',
                            KEY            `uk` (`system_id`,`url`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
BEGIN;
INSERT INTO `sys_menu` VALUES (1, 4, '0', '系统', 'system', 41, 0, 1, 1, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (2, 4, '0', '文件', 'file', 42, 0, 1, 1, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (3, 4, '0', '测试', 'test', 43, 0, 1, 1, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (4, 4, '0', 'app', 'application', 44, 0, 1, 1, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (5, 4, '0', '高级', 'special', 45, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-07-09 17:18:19');
INSERT INTO `sys_menu` VALUES (6, 4, '0', '一级菜单A', 'A', 1, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (7, 4, '0', '一级菜单B', 'B', 2, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (8, 4, '0', '一级菜单C', 'C', 3, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (9, 4, '0', '一级菜单D', 'D', 4, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (10, 4, '0', '一级菜单E', 'E', 5, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (11, 4, '0', '一级菜单F', 'F', 6, 0, 1, 0, NULL, NULL, NULL, '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (12, 4, '0', '用户列表', NULL, 100, 1, 2, 1, '/user', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (13, 4, '0', 'role', NULL, 100, 1, 2, 1, '/role', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (14, 4, '0', '文件', NULL, 100, 1, 2, 1, '/file', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (15, 4, '0', '主页', NULL, 100, 1, 2, 1, '/index', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (16, 4, '0', '登录', NULL, 100, 1, 2, 1, '/login', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (17, 4, '0', '样式测试', NULL, 100, 3, 2, 1, '/css-test', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (18, 4, '0', '图片预览', NULL, 100, 1, 2, 1, '/file-search', NULL, '4', '2019-11-25 11:21:33', '2019-11-25 11:21:33');
INSERT INTO `sys_menu` VALUES (19, 4, '0', '博客', NULL, 100, 1, 2, 1, '/blog', NULL, '', NULL, NULL);
INSERT INTO `sys_menu` VALUES (20, 4, '0', '链接', NULL, 100, 1, 2, 1, '/链接', NULL, '点点滴滴都是', NULL, NULL);
INSERT INTO `sys_menu` VALUES (21, 4, '0', '菜单', NULL, 100, 1, 2, 1, '/menu', NULL, 'menu', NULL, NULL);
INSERT INTO `sys_menu` VALUES (22, 4, '0', '博客管理', NULL, 100, 4, 2, 1, '/manage-blog', NULL, 'manage-blog.....', NULL, NULL);
INSERT INTO `sys_menu` VALUES (23, 4, '0', '写博客', NULL, 100, 4, 2, 1, '/bmd', NULL, 'blog-MD', NULL, NULL);
INSERT INTO `sys_menu` VALUES (24, 4, '0', '测试博客详情', NULL, 100, 4, 2, 1, '/blog-detail', NULL, '测试', NULL, NULL);
INSERT INTO `sys_menu` VALUES (25, 4, '0', '测试ModalDemo', NULL, 100, 4, 2, 1, '/ModalDemo', NULL, '测试', NULL, NULL);
INSERT INTO `sys_menu` VALUES (26, 4, '0', 'File文件', NULL, 100, 2, 2, 1, '/file', NULL, NULL, NULL, NULL);
INSERT INTO `sys_menu` VALUES (27, 4, '0', '账单管理', NULL, 100, 2, 2, 1, '/sr', NULL, 'ShoppingReceipt', NULL, NULL);
INSERT INTO `sys_menu` VALUES (28, 4, '0', 'Resource', NULL, 100, 2, 2, 1, '/resource', NULL, 'ResourceResourceResource', NULL, NULL);
INSERT INTO `sys_menu` VALUES (29, 4, '0', 'File1', NULL, 100, 2, 2, 0, '/file1', NULL, 'For test file list Module', NULL, NULL);
INSERT INTO `sys_menu` VALUES (30, 4, '0', 'QR', NULL, 100, 3, 2, 1, '/qr-test', NULL, '二维码的', NULL, NULL);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
