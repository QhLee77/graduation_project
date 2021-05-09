/*
 Navicat MySQL Data Transfer

 Source Server         : 115.159.24.181
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 115.159.24.181
 Source Database       : mydb

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : utf-8

 Date: 11/18/2020 02:15:18 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` varchar(64) NOT NULL,
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级类别id',
  `parent_name` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL COMMENT '类别名称',
  `description` varchar(500) DEFAULT NULL COMMENT '类别描述',
  `creator_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `space_id` int(11) DEFAULT '1' COMMENT '空间Id',
  `order_num` int(11) DEFAULT '0' COMMENT '排序',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` int(1) DEFAULT '1' COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `cols` varchar(255) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `category`
-- ----------------------------
BEGIN;
INSERT INTO `category` VALUES ('0ncWavla', 'XDikJuJ0', '光谱论文', '2019年', '已经发表的论文', '1', '1', '2', null, '1', '2020-11-08 12:16:14', '2020-11-08 12:16:13', null), ('1000', '', '顶层类别', '总公司', '无描述内容', null, '1', '0', null, '0', '2020-08-13 02:38:27', '2020-11-08 11:54:29', null), ('1002', '1000', '总公司', '上海分公司', '无描述内容', null, '1', '0', null, '0', '2020-08-13 02:38:27', '2020-11-08 02:57:11', null), ('7hMvn1mV', '1000', '总公司', '成都分公司', '成都', null, '1', '2', null, '0', '2020-08-13 04:16:50', '2020-11-08 02:57:14', null), ('CSrGVECV', 'XDikJuJ0', '光谱论文', '2018年', '已经发表的论文', '1', '1', '1', null, '1', '2020-11-08 12:14:47', '2020-11-08 12:16:26', null), ('GL02BlTK', 'hzpONCiu', '李敏论文', '天', '天', '8', '1', '1', null, '0', '2020-11-10 16:44:35', '2020-11-10 16:44:34', null), ('ht5Vhmoe', 'hzpONCiu', '李敏论文', '地', '', '1', '1', '5', null, '1', '2020-11-08 13:19:28', '2020-11-08 13:19:27', null), ('hzpONCiu', 'I6JU84bJ', '图像论文', '李敏论文', '', '1', '1', '1', null, '1', '2020-11-08 13:18:49', '2020-11-08 13:18:49', null), ('I6JU84bJ', 'WdN4HzUj', '图像', '图像论文', '', '1', '1', '1', null, '1', '2020-11-08 13:17:32', '2020-11-08 13:17:32', null), ('JUmEhJPl', '', 'top category', '光谱', '2020.11.8', '1', '1', '1', null, '0', '2020-11-08 12:04:24', '2020-11-08 12:04:23', null), ('OerpyliD', '', 'top category', '光谱程序', '', '1', '1', '2', null, '1', '2020-11-08 12:19:54', '2020-11-08 12:19:54', null), ('pQs21x2S', 'JUmEhJPl', '光谱', '研一', '2020.11.8', '1', '1', '1', null, '0', '2020-11-08 12:05:14', '2020-11-08 12:05:13', null), ('r7fCFbTC', 'XDikJuJ0', '光谱论文', '2020年', '已经发表的论文', '1', '1', '3', null, '1', '2020-11-08 12:18:46', '2020-11-08 12:18:46', null), ('rzWqq3s2', 'OerpyliD', '光谱程序', '机器学习-MATLAB', '', '1', '1', '1', null, '1', '2020-11-08 12:26:54', '2020-11-08 12:26:54', null), ('sfThM8EB', 'rzWqq3s2', '机器学习-MATLAB', '分类程序', 'SVM', '1', '1', '1', null, '1', '2020-11-08 12:20:40', '2020-11-08 12:27:09', null), ('TvMmBeVh', 'rzWqq3s2', '机器学习-MATLAB', '定量程序', 'PLS', '1', '1', '2', null, '1', '2020-11-08 12:22:36', '2020-11-08 12:27:17', null), ('vjBgZzpw', 'hzpONCiu', '李敏论文', '人', '人', '8', '1', '3', null, '0', '2020-11-10 16:44:58', '2020-11-10 16:44:58', null), ('WdN4HzUj', '', 'top category', '图像', '图像数据及相关论文', '1', '1', '3', null, '1', '2020-11-08 13:04:28', '2020-11-10 16:43:38', null), ('XDikJuJ0', '', 'top category', '光谱论文', '', '1', '1', '1', null, '1', '2020-11-08 12:10:17', '2020-11-10 16:43:33', null), ('z4dR7KAc', '', 'top category', '图像', '图像数据', '1', '1', '2', null, '0', '2020-11-08 12:05:11', '2020-11-08 12:05:10', null);
COMMIT;

-- ----------------------------
--  Table structure for `download`
-- ----------------------------
DROP TABLE IF EXISTS `download`;
CREATE TABLE `download` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `download_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '下载的编号,从1000 开始自动增长',
  `applicant_id` int(11) DEFAULT NULL COMMENT '申请人id',
  `application_name` varchar(255) DEFAULT NULL COMMENT '申请人名字',
  `application_time` datetime DEFAULT NULL COMMENT '申请时间',
  `application_remark` varchar(255) DEFAULT NULL COMMENT '申请的备注说明',
  `checker_id` int(11) DEFAULT NULL COMMENT '审核人id',
  `checker_name` varchar(255) DEFAULT NULL COMMENT '审核人名字',
  `check_time` datetime DEFAULT NULL COMMENT '审核时间',
  `check_remark` varchar(255) DEFAULT NULL COMMENT '审核的备注说明',
  `status` int(1) DEFAULT NULL COMMENT '-1 无需审核，默认通过  0 未审核  1 通过  2 不通过',
  `zip_password` varchar(255) DEFAULT NULL COMMENT '解压密码',
  `zip_file` varchar(400) DEFAULT NULL COMMENT '压缩包文件路径',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `last_download_time` datetime DEFAULT NULL COMMENT '最后一次下载时间',
  `download_count` int(11) DEFAULT NULL COMMENT '下载次数',
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `download_number` (`download_number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `download`
-- ----------------------------
BEGIN;
INSERT INTO `download` VALUES ('1000000025010461', '2', '9', '严紫薇', '2020-11-10 17:05:53', 'PLS程序.rar', '8', '黄柯翔-系统维护', '2020-11-13 22:13:20', '', '1', '51b4', null, null, null, null, '2020-11-13 22:13:20'), ('1000000346979434', '1', '8', '黄柯翔-系统维护', '2020-11-10 16:49:09', '陈晨-宫颈脱落细胞液.pdf手动阀是的萨顶顶撒阿斯蒂芬阿斯蒂芬阿斯蒂芬阿萨德打分', null, null, null, null, '0', '913d', null, null, null, null, '2020-11-10 16:49:09'), ('1000001798713352', '3', '8', '黄柯翔-系统维护', '2020-11-13 22:13:03', '陈晨-宫颈脱落细胞液.pdf', '8', '黄柯翔-系统维护', '2020-11-13 22:13:26', '', '1', '0b9d', '/3-陈晨-宫颈脱落细胞液(1个文件).zip', null, null, null, '2020-11-13 22:13:26');
COMMIT;

-- ----------------------------
--  Table structure for `download_fileInfo`
-- ----------------------------
DROP TABLE IF EXISTS `download_fileInfo`;
CREATE TABLE `download_fileInfo` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `download_id` varchar(64) DEFAULT NULL COMMENT '下载记录id',
  `fileInfo_id` varchar(50) DEFAULT NULL COMMENT '文件id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `download_fileInfo`
-- ----------------------------
BEGIN;
INSERT INTO `download_fileInfo` VALUES ('1000000228817830', '1000000346979434', '1000000096383373'), ('1000001075348193', '1000001798713352', '1000000096383373'), ('1000001850468252', '1000000025010461', '1000002113352931');
COMMIT;

-- ----------------------------
--  Table structure for `file_info`
-- ----------------------------
DROP TABLE IF EXISTS `file_info`;
CREATE TABLE `file_info` (
  `id` varchar(64) NOT NULL COMMENT '主键id',
  `file_number` int(11) NOT NULL AUTO_INCREMENT COMMENT '文件编号id,从1000 开始自动增长',
  `file_name` varchar(255) NOT NULL COMMENT '文件名字',
  `md5` varchar(32) DEFAULT NULL COMMENT '文件md5',
  `category_id` varchar(64) DEFAULT NULL COMMENT '文件类别id',
  `category_name` varchar(255) DEFAULT NULL COMMENT '文件类别名称',
  `space_id` varchar(64) DEFAULT NULL COMMENT '空间id',
  `space_name` varchar(255) DEFAULT NULL COMMENT '空间名称',
  `creator_id` int(11) DEFAULT NULL COMMENT '上传者id',
  `creator_name` varchar(50) DEFAULT NULL COMMENT '上传者名称',
  `file_keys` varchar(255) DEFAULT NULL COMMENT '关键字',
  `detail` text COMMENT '详细说明',
  `contentType` varchar(128) DEFAULT NULL COMMENT '文件类型',
  `size` int(11) DEFAULT NULL COMMENT '文件大小',
  `path` varchar(255) DEFAULT NULL COMMENT '物理路径',
  `url` varchar(1024) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `file_number` (`file_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
--  Records of `file_info`
-- ----------------------------
BEGIN;
INSERT INTO `file_info` VALUES ('1000000096383373', '5', '陈晨-宫颈脱落细胞液.pdf', '92aa5cf6df9e9d799006cc3e5f3817ed', 'r7fCFbTC', '2020年', null, null, '1', '管理员', 'OPTIK（2.187）', '', 'application/pdf', '466295', '/20201108-aa5cf6-陈晨-宫颈脱落细胞液.pdf', null, '1', '2020-11-08 12:40:35', '2020-11-08 12:41:05'), ('1000000772251975', '8', '现代网络综述+高古学+107556520207.rar', 'eeac1c5970432e73d0ec0d4caee74378', 'WdN4HzUj', '图像', null, null, '1', '管理员', null, null, 'application/octet-stream', '177308', '/20201108-ac1c59-现代网络综述+高古学+107556520207.rar', null, '0', '2020-11-08 13:05:11', '2020-11-08 13:05:27'), ('1000000853332576', '2', '陈芳芳.zip', '3631390fc13912c04689d7c1343905e0', 'pQs21x2S', '研一', null, null, '1', '管理员', null, null, 'application/x-zip-compressed', '148', '/20201108-31390f-陈芳芳.zip', null, '0', '2020-11-08 12:07:47', '2020-11-08 12:12:01'), ('1000000933137006', '6', '5优化svm.rar', '4700b0c75149dff39119a9616af276cc', 'sfThM8EB', '分类程序', null, null, '1', '管理员', null, null, 'application/octet-stream', '149292', '/20201108-00b0c7-5优化svm.rar', null, '1', '2020-11-08 12:44:12', '2020-11-08 12:44:12'), ('1000001146135919', '3', '郑向向-甲状腺血清样本.pdf', '503eea81f0a1a3c7dd5ad081883bb347', 'CSrGVECV', '2018年', null, null, '1', '管理员', 'IEEE Photonics Journal（2.833）', '<p>样本数量：</p><p>神经网络模型：</p>', 'application/pdf', '3416416', '/20201108-3eea81-郑向向-甲状腺血清样本.pdf', null, '1', '2020-11-08 12:30:06', '2020-11-09 21:32:47'), ('1000001332824364', '1', '陈晨-宫颈脱落细胞液.pdf', '92aa5cf6df9e9d799006cc3e5f3817ed', '1002', '上海分公司', null, null, '1', '管理员', null, null, 'application/pdf', '466295', '/20201108-aa5cf6-陈晨-宫颈脱落细胞液.pdf', null, '0', '2020-11-08 11:50:23', '2020-11-08 11:54:19'), ('1000001997064499', '4', '郑向向-高血压血清样本.pdf', 'b17edcb596e4c81d7e7065c7ff2f7359', '0ncWavla', '2019年', null, null, '1', '管理员', 'Spectrochimica Acta Part A: Molecular and Biomolecular（3.232）', '', 'application/pdf', '831507', '/20201108-7edcb5-郑向向-高血压血清样本.pdf', null, '1', '2020-11-08 12:38:21', '2020-11-08 12:39:26'), ('1000002113352931', '7', 'PLS程序.rar', '60c41d68950d50e3a5f3ead14813e41e', 'TvMmBeVh', '定量程序', null, null, '1', '管理员', null, null, 'application/octet-stream', '1766752', '/20201108-c41d68-PLS程序.rar', null, '1', '2020-11-08 12:45:26', '2020-11-08 12:45:26');
COMMIT;

-- ----------------------------
--  Table structure for `nodelist`
-- ----------------------------
DROP TABLE IF EXISTS `nodelist`;
CREATE TABLE `nodelist` (
  `id` int(11) DEFAULT NULL,
  `nodecontent` varchar(300) COLLATE utf8_unicode_ci DEFAULT NULL,
  `pid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
--  Records of `nodelist`
-- ----------------------------
BEGIN;
INSERT INTO `nodelist` VALUES ('1', 'a', null), ('2', 'b', '1'), ('3', 'c', '1'), ('4', 'd', '2'), ('5', 'e', '3'), ('6', 'f', '3'), ('7', 'g', '5'), ('8', 'h', '7'), ('9', 'i', '8'), ('10', 'j', '8');
COMMIT;

-- ----------------------------
--  Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` varchar(20) NOT NULL COMMENT '权限id',
  `name` varchar(100) NOT NULL COMMENT '权限名称',
  `description` varchar(255) DEFAULT NULL COMMENT '权限描述',
  `url` varchar(255) DEFAULT NULL COMMENT '权限访问路径',
  `perms` varchar(255) DEFAULT NULL COMMENT '权限标识',
  `parent_id` int(11) DEFAULT NULL COMMENT '父级权限id',
  `type` int(1) DEFAULT NULL COMMENT '类型   0：目录   1：菜单   2：按钮',
  `order_num` int(3) DEFAULT '0' COMMENT '排序',
  `icon` varchar(50) DEFAULT NULL COMMENT '图标',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `permission`
-- ----------------------------
BEGIN;
INSERT INTO `permission` VALUES ('1', '1', '首页', '工作台', '/workdest', 'workdest', '0', '1', '1', 'fa fa-home', '1', '2017-09-27 21:22:02', '2020-11-10 16:40:19'), ('2', '2', '权限管理', '权限管理', null, null, '0', '0', '8', 'fa fa-th-list', '1', '2017-07-13 15:04:42', '2020-10-25 20:50:01'), ('3', '201', '用户列表', '用户管理', '/users', 'users', '36', '1', '1', 'fa fa-circle-o', '1', '2017-07-13 15:05:47', '2020-08-05 02:38:31'), ('4', '20101', '列表查询', '用户列表查询', '/user/list', 'user:list', '3', '2', '0', null, '1', '2017-07-13 15:09:24', '2017-10-09 05:38:29'), ('5', '20102', '新增', 'Add User', '/user/add', 'user:add', '3', '2', '0', null, '1', '2017-07-13 15:06:50', '2018-02-28 17:58:46'), ('6', '20103', '编辑', '编辑用户', '/user/edit', 'user:edit', '3', '2', '0', null, '1', '2017-07-13 15:08:03', '2018-02-27 10:53:14'), ('7', '20104', '删除', '删除用户', '/user/delete', 'user:delete', '3', '2', '0', null, '1', '2017-07-13 15:08:42', '2018-02-27 10:53:14'), ('8', '20105', '批量删除', '批量删除用户', '/user/batch/delete', 'user:batchDelete', '3', '2', '0', '', '1', '2018-07-11 01:53:09', '2018-07-11 01:53:09'), ('9', '20106', '分配角色', '分配角色', '/user/assign/role', 'user:assignRole', '3', '2', '0', null, '1', '2017-07-13 15:09:24', '2017-10-09 05:38:29'), ('10', '202', '角色管理', '角色管理', '/roles', 'roles', '2', '1', '2', 'fa fa-circle-o', '1', '2017-07-17 14:39:09', '2018-02-27 10:53:14'), ('11', '20201', '列表查询', '角色列表查询', '/role/list', 'role:list', '10', '2', '0', null, '1', '2017-10-10 15:31:36', '2018-02-27 10:53:14'), ('12', '20202', '新增', 'Add Role', '/role/add', 'role:add', '10', '2', '0', null, '1', '2017-07-17 14:39:46', '2018-02-27 10:53:14'), ('13', '20203', '编辑', '编辑角色', '/role/edit', 'role:edit', '10', '2', '0', null, '1', '2017-07-17 14:40:15', '2018-02-27 10:53:14'), ('14', '20204', '删除', '删除角色', '/role/delete', 'role:delete', '10', '2', '0', null, '1', '2017-07-17 14:40:57', '2018-02-27 10:53:14'), ('15', '20205', '批量删除', '批量删除角色', '/role/batch/delete', 'role:batchDelete', '10', '2', '0', '', '1', '2018-07-10 22:20:43', '2018-07-10 22:20:43'), ('16', '20206', '分配权限', '分配权限', '/role/assign/permission', 'role:assignPerms', '10', '2', '0', null, '1', '2017-09-26 07:33:05', '2018-02-27 10:53:14'), ('17', '203', '菜单管理', '资源管理', '/permissions', 'permissions', '2', '1', '1', 'fa fa-circle-o', '1', '2017-09-26 07:33:51', '2020-08-05 02:41:22'), ('18', '20301', '列表查询', '资源列表', '/permission/list', 'permission:list', '17', '2', '0', null, '1', '2018-07-12 16:25:28', '2018-07-12 16:25:33'), ('19', '20302', '新增', '新增资源', '/permission/add', 'permission:add', '17', '2', '0', null, '1', '2017-09-26 08:06:58', '2018-02-27 10:53:14'), ('20', '20303', '编辑', '编辑资源', '/permission/edit', 'permission:edit', '17', '2', '0', null, '1', '2017-09-27 21:29:04', '2018-02-27 10:53:14'), ('21', '20304', '删除', '删除资源', '/permission/delete', 'permission:delete', '17', '2', '0', null, '1', '2017-09-27 21:29:50', '2018-02-27 10:53:14'), ('22', '3', '运维管理', '运维管理', null, null, '0', '0', '9', 'fa fa-th-list', '1', '2018-07-06 15:19:26', '2020-10-25 20:50:09'), ('23', '301', '数据监控', '数据监控', '/database/monitoring', 'database', '22', '1', '1', 'fa fa-circle-o', '1', '2018-07-06 15:19:55', '2018-09-12 13:14:48'), ('25', '401', '图标工具', '图标工具', '/icons', 'icons', '2', '1', '3', 'fa fa-circle-o', '1', '2018-07-06 15:21:00', '2020-08-05 02:40:51'), ('28', '1000000884924014', '在线用户', '在线用户', '/online/users', 'onlineUsers', '36', '1', '4', 'fa fa-circle-o', '1', '2018-07-18 21:00:38', '2020-08-05 02:39:15'), ('29', '1000000433323073', '在线用户查询', '在线用户查询', '/online/user/list', 'onlineUser:list', '28', '2', '0', null, '1', '2018-07-18 21:01:25', '2018-07-19 12:48:04'), ('30', '1000000903407910', '踢出用户', '踢出用户', '/online/user/kickout', 'onlineUser:kickout', '28', '2', '0', null, '1', '2018-07-18 21:41:54', '2018-07-19 12:48:25'), ('31', '1000000851815490', '批量踢出', '批量踢出', '/online/user/batch/kickout', 'onlineUser:batchKickout', '28', '2', '0', '', '1', '2018-07-19 12:49:30', '2018-07-19 12:49:30'), ('32', '1000000151546917', '我的资源', '文件内容', null, null, '0', '0', '3', 'fa fa-th-list', '1', '2020-08-05 02:19:03', '2020-11-03 00:38:42'), ('33', '1000001773085311', '我的上传', '', '/myuploads', 'myuploads', '32', '1', '1', 'fa fa-circle-o', '1', '2020-08-05 02:20:56', '2020-10-25 20:51:14'), ('34', '1000000957531210', '资源浏览', '浏览所有文件', '/files', 'files', '0', '1', '2', 'fa  fa-files-o', '1', '2020-08-05 02:24:59', '2020-11-09 02:22:49'), ('35', '1000000847789263', '我的下载', '', '/mydownloads', 'mydownloads', '32', '1', '2', 'fa fa-circle-o', '1', '2020-08-05 02:35:51', '2020-08-05 02:36:03'), ('36', '1000001575093565', '用户管理', '用户管理', null, null, '0', '0', '6', 'fa fa-th-list', '1', '2020-08-05 02:37:56', '2020-10-30 05:08:31'), ('37', '1000000731132094', '分类管理', '分类管理', '/categorys', 'categorys', '0', '1', '5', 'fa fa-list', '1', '2020-10-10 16:29:24', '2020-11-09 02:24:39'), ('44', '1000001373445896', '下载审核', '审核用户的下载申请', '/downloads-uncheck', 'downloads-uncheck', '0', '1', '4', 'fa fa-check-square-o', '1', '2020-10-30 00:45:20', '2020-11-09 02:24:26'), ('47', '1000001015032290', '申请下载', '申请下载', '/download/apply', 'download:applicant', '34', '2', '0', null, '1', '2020-10-31 02:26:45', '2020-11-05 04:15:55'), ('48', '1000001305231446', '直接下载', '直接下载', '/download/immediately', 'download:immediately', '34', '2', '0', null, '1', '2020-10-31 02:29:34', '2020-11-05 04:16:48'), ('49', '1000000920456820', '文件上传', '文件上传', '/fileInfo/submitUpload', 'fileUpload', '34', '2', '0', '', '1', '2020-11-05 03:08:19', '2020-11-05 03:08:19'), ('50', '1000000072387719', '文件编辑', '文件编辑', '/fileInfo/edit_submit', 'fileinfo:edit', '34', '2', '0', null, '1', '2020-11-05 03:26:35', '2020-11-05 03:29:08'), ('51', '1000001188395999', '文件删除', '文件删除', '/fileInfo/delete', 'fileinfo:delete', '34', '2', '0', null, '1', '2020-11-05 03:28:48', '2020-11-05 04:19:29'), ('52', '1000000313034620', '下载', '下载自己上传的文件', '/download/download_my', 'download_my', '33', '2', '0', null, '1', '2020-11-05 04:31:05', '2020-11-05 04:40:18'), ('53', '1000000013268613', '编辑', '编辑我上传的文件', '/fileInfo/edit_my', 'fileinfo:editMy', '33', '2', '0', '', '1', '2020-11-05 04:34:52', '2020-11-05 04:34:52'), ('54', '1000000273801412', '删除', '删除我上传的文件', '/fileInfo/delete-myfileinfo', 'fileinfo:deleteMy', '33', '2', '0', null, '1', '2020-11-05 04:53:26', '2020-11-05 04:54:27'), ('55', '1000000476632703', '下载', '下载审核通过后的文件', '/download/check_yes', 'download:check_yes', '35', '2', '0', '', '1', '2020-11-05 05:01:01', '2020-11-05 05:01:01'), ('56', '1000001144386980', '新增', '新增类别', '/category/add', 'category:add', '37', '2', '0', '', '1', '2020-11-05 05:21:20', '2020-11-05 05:21:20'), ('57', '1000001239157799', '编辑', '编辑分类', '/category/edit', 'category:edit', '37', '2', '0', '', '1', '2020-11-05 05:22:13', '2020-11-05 05:22:13'), ('58', '1000000922683612', '删除', '删除分类', '/category/delete', 'category:delete', '37', '2', '0', null, '1', '2020-11-05 05:23:02', '2020-11-05 05:28:40'), ('59', '1000002052051196', '通过', '审核通过', '/download/check', 'download:check_ok', '44', '2', '0', null, '1', '2020-11-05 05:53:09', '2020-11-05 06:09:27'), ('60', '1000001882751316', '拒绝', '审核拒绝', '/download/check', 'download:check_no', '44', '2', '0', null, '1', '2020-11-05 05:53:39', '2020-11-05 05:54:03'), ('61', '1000001362140602', '已通过的下载', '浏览已通过的下载申请', '/downloads-passed', 'list-downloads-passed', '44', '2', '0', null, '1', '2020-11-05 05:56:18', '2020-11-05 05:57:31'), ('62', '1000001146126330', '已拒绝的下载', '浏览已拒绝的下载申请', '/downloads-refuse', 'list-downloads-refuse', '44', '2', '0', '', '1', '2020-11-05 05:57:21', '2020-11-05 05:57:21'), ('63', '1000002086930502', '重置密码', '重置密码，用户名密码一致', '/user/resetPWD', 'resetPWD', '3', '2', '0', '', '1', '2020-11-08 00:39:03', '2020-11-08 00:39:03');
COMMIT;

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `name` varchar(50) NOT NULL COMMENT '角色名称',
  `description` varchar(255) DEFAULT NULL COMMENT '角色描述',
  `status` int(1) NOT NULL COMMENT '状态：1有效；2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('1', '1', '超级管理员', '超级管理员(系统维护使用)', '1', '2017-06-28 20:30:05', '2020-11-08 02:17:44'), ('2', '2', '管理员', '管理员', '1', '2017-06-30 23:35:19', '2017-10-11 09:32:33'), ('3', '3', '普通用户', '普通用户', '1', '2017-06-30 23:35:44', '2018-07-13 11:44:06'), ('4', '1000001092850668', '下载-审核者', '审核普通用户的下载申请', '1', '2020-11-05 03:37:40', null);
COMMIT;

-- ----------------------------
--  Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  `permission_id` varchar(20) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3049 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role_permission`
-- ----------------------------
BEGIN;
INSERT INTO `role_permission` VALUES ('2795', '1000001260689576', '1000000957531210'), ('2796', '1000001260689576', '1000000920456820'), ('2938', '1', '1'), ('2939', '1', '1000000957531210'), ('2940', '1', '1000001015032290'), ('2941', '1', '1000001305231446'), ('2942', '1', '1000000920456820'), ('2943', '1', '1000000072387719'), ('2944', '1', '1000001188395999'), ('2945', '1', '1000001373445896'), ('2946', '1', '1000002052051196'), ('2947', '1', '1000001882751316'), ('2948', '1', '1000001362140602'), ('2949', '1', '1000001146126330'), ('2950', '1', '1000000151546917'), ('2951', '1', '1000001773085311'), ('2952', '1', '1000000313034620'), ('2953', '1', '1000000013268613'), ('2954', '1', '1000000273801412'), ('2955', '1', '1000000847789263'), ('2956', '1', '1000000476632703'), ('2957', '1', '1000000731132094'), ('2958', '1', '1000001144386980'), ('2959', '1', '1000001239157799'), ('2960', '1', '1000000922683612'), ('2961', '1', '1000001575093565'), ('2962', '1', '201'), ('2963', '1', '20101'), ('2964', '1', '20102'), ('2965', '1', '20103'), ('2966', '1', '20104'), ('2967', '1', '20105'), ('2968', '1', '20106'), ('2969', '1', '1000002086930502'), ('2970', '1', '1000000884924014'), ('2971', '1', '1000000433323073'), ('2972', '1', '1000000903407910'), ('2973', '1', '1000000851815490'), ('2974', '1', '2'), ('2975', '1', '203'), ('2976', '1', '20301'), ('2977', '1', '20302'), ('2978', '1', '20303'), ('2979', '1', '20304'), ('2980', '1', '202'), ('2981', '1', '20201'), ('2982', '1', '20202'), ('2983', '1', '20203'), ('2984', '1', '20204'), ('2985', '1', '20205'), ('2986', '1', '20206'), ('2987', '1', '401'), ('2988', '1', '3'), ('2989', '1', '301'), ('2990', '2', '1'), ('2991', '2', '1000000957531210'), ('2992', '2', '1000001305231446'), ('2993', '2', '1000000920456820'), ('2994', '2', '1000000072387719'), ('2995', '2', '1000001188395999'), ('2996', '2', '1000001373445896'), ('2997', '2', '1000002052051196'), ('2998', '2', '1000001882751316'), ('2999', '2', '1000001362140602'), ('3000', '2', '1000001146126330'), ('3001', '2', '1000000151546917'), ('3002', '2', '1000001773085311'), ('3003', '2', '1000000313034620'), ('3004', '2', '1000000013268613'), ('3005', '2', '1000000273801412'), ('3006', '2', '1000000847789263'), ('3007', '2', '1000000476632703'), ('3008', '2', '1000000731132094'), ('3009', '2', '1000001144386980'), ('3010', '2', '1000001239157799'), ('3011', '2', '1000000922683612'), ('3012', '2', '1000001575093565'), ('3013', '2', '201'), ('3014', '2', '20101'), ('3015', '2', '20102'), ('3016', '2', '20103'), ('3017', '2', '20104'), ('3018', '2', '20105'), ('3019', '2', '20106'), ('3020', '2', '1000002086930502'), ('3021', '2', '1000000884924014'), ('3022', '2', '1000000433323073'), ('3023', '2', '1000000903407910'), ('3024', '2', '1000000851815490'), ('3025', '2', '2'), ('3026', '2', '202'), ('3027', '2', '20201'), ('3028', '2', '20202'), ('3029', '2', '20203'), ('3030', '2', '20204'), ('3031', '2', '20205'), ('3032', '2', '20206'), ('3033', '3', '1'), ('3034', '3', '1000000957531210'), ('3035', '3', '1000001015032290'), ('3036', '3', '1000000920456820'), ('3037', '3', '1000000151546917'), ('3038', '3', '1000001773085311'), ('3039', '3', '1000000313034620'), ('3040', '3', '1000000013268613'), ('3041', '3', '1000000273801412'), ('3042', '3', '1000000847789263'), ('3043', '3', '1000000476632703'), ('3044', '1000001092850668', '1000001373445896'), ('3045', '1000001092850668', '1000002052051196'), ('3046', '1000001092850668', '1000001882751316'), ('3047', '1000001092850668', '1000001362140602'), ('3048', '1000001092850668', '1000001146126330');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL,
  `real_name` varchar(100) DEFAULT NULL,
  `salt` varchar(128) DEFAULT NULL COMMENT '加密盐值',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系方式',
  `sex` int(255) DEFAULT NULL COMMENT '年龄：1男2女',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `status` int(1) NOT NULL COMMENT '用户状态：1有效; 2删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  PRIMARY KEY (`id`,`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '1', 'admin', '6046c090f053c333f29c9ffa3fffe18b', '管理员', 'cecf98e18e544da1f0aed449839f1da1', 'admin@qq.com', '18181818181', '1', '8', '1', '2018-05-23 21:22:06', '2020-11-08 02:20:37', '2020-11-18 02:07:28'), ('8', '1000000693048586', 'root', '7113a7f1ad64553e653161989900711c', '黄柯翔-系统维护', '343ef29ad09317306bd43082577e32f8', '175175005@qq.com', '18696572966', '1', '30', '1', '2020-11-08 02:29:02', '2020-11-08 02:50:51', '2020-11-15 18:24:29'), ('9', '1000001080492730', '107551801923', 'aecfa08515b9b04d81d1bdc8773dfc97', '严紫薇', '637674e504428491d1ff57ba428b7492', '', '', '1', null, '1', '2020-11-10 17:03:26', '2020-11-10 17:03:35', '2020-11-10 17:05:18');
COMMIT;

-- ----------------------------
--  Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) NOT NULL COMMENT '用户id',
  `role_id` varchar(20) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_role`
-- ----------------------------
set global log_bin_trust_function_creators=TRUE;
BEGIN;
INSERT INTO `user_role` VALUES ('10', '1000000693048586', '1'), ('11', '1', '2'), ('12', '1000001080492730', '3');
COMMIT;

-- ----------------------------
--  Function structure for `get_child_list`
-- ----------------------------
DROP FUNCTION IF EXISTS `get_child_list`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `get_child_list`(in_id varchar(10)) RETURNS varchar(1000) CHARSET utf8 COLLATE utf8_unicode_ci
begin
    declare ids varchar(1000) default '';
    declare tempids varchar(1000);

    set tempids = in_id;
    while tempids is not null do
            set ids = CONCAT_WS(',',ids,tempids);
            select GROUP_CONCAT(id) into tempids from category where FIND_IN_SET(parent_id,tempids)>0;
        end while;
    return ids;
end
 ;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
