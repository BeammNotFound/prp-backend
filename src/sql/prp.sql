/*
 Navicat Premium Data Transfer

 Source Server         : 明军
 Source Server Type    : MySQL
 Source Server Version : 50732
 Source Host           : 47.94.104.224:3306
 Source Schema         : prp

 Target Server Type    : MySQL
 Target Server Version : 50732
 File Encoding         : 65001

 Date: 08/03/2021 15:56:19
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adoption_form
-- ----------------------------
DROP TABLE IF EXISTS `adoption_form`;
CREATE TABLE `adoption_form`  (
  `af_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `pet_id` int(11) DEFAULT NULL,
  `base_id` int(11) DEFAULT NULL,
  `af_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_age` int(11) DEFAULT NULL,
  `af_appraise` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_info1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_info2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_info3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_info4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_info5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_info6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `af_create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`af_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adoption_form
-- ----------------------------
INSERT INTO `adoption_form` VALUES (3, 3, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `adoption_form` VALUES (4, 3, 1, 2, '河南省信阳市', 21, '乐观可爱', '是', '是', '是', '是', '是', '是', '2020-12-13 18:18:54');
INSERT INTO `adoption_form` VALUES (5, 3, 4, 1, '111', 11, '11111', '是', '是', '是', '是', '是', '是', '2020-12-13 18:24:09');
INSERT INTO `adoption_form` VALUES (6, 3, 3, 3, '河南省信阳市', 11, '11111', '是', '是', '是', '是', '是', '是', '2020-12-15 17:20:17');
INSERT INTO `adoption_form` VALUES (7, 3, 5, 1, '河南省信阳市', 11, '11111', '是', '是', '是', '是', '是', '是', '2020-12-15 17:33:18');
INSERT INTO `adoption_form` VALUES (8, 1, 4, 1, '123', 12, '123', '是', '是', '是', '是', '是', '是', '2020-12-15 17:34:59');
INSERT INTO `adoption_form` VALUES (9, 1, 6, 2, '123', 12, '123', '是', '是', '是', '是', '是', '是', '2020-12-15 17:36:35');
INSERT INTO `adoption_form` VALUES (10, 1, 5, 1, '123', 12, '123', '是', '是', '是', '是', '是', '是', '2020-12-15 17:37:41');

-- ----------------------------
-- Table structure for adoption_pets
-- ----------------------------
DROP TABLE IF EXISTS `adoption_pets`;
CREATE TABLE `adoption_pets`  (
  `ap_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `pet_id` int(11) DEFAULT NULL,
  `ap_status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ap_pass_time` datetime(0) DEFAULT NULL,
  `ap_application_time` datetime(0) DEFAULT NULL COMMENT '领养时间',
  PRIMARY KEY (`ap_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adoption_pets
-- ----------------------------
INSERT INTO `adoption_pets` VALUES (1, 3, 1, 2, '审批通过', '2021-03-06 16:02:41', '2020-12-02 22:00:14');
INSERT INTO `adoption_pets` VALUES (2, 1, 1, 1, '审批通过', '2021-03-05 09:44:01', '2020-12-05 15:58:42');
INSERT INTO `adoption_pets` VALUES (3, 1, 1, 1, '审批通过', '2021-03-07 10:53:16', '2020-12-05 16:03:05');
INSERT INTO `adoption_pets` VALUES (4, 1, 2, 1, '审批通过', '2021-03-07 10:54:40', '2020-12-13 17:18:53');
INSERT INTO `adoption_pets` VALUES (5, 2, 3, 1, '审批通过', '2021-03-07 11:31:37', '2020-12-13 18:18:54');
INSERT INTO `adoption_pets` VALUES (6, 1, 3, 4, '审批通过', '2021-03-07 11:33:41', '2020-12-13 18:24:09');
INSERT INTO `adoption_pets` VALUES (7, 3, 3, 3, '审批驳回', NULL, '2020-12-15 17:20:17');
INSERT INTO `adoption_pets` VALUES (8, 1, 3, 5, '待审批', NULL, '2020-12-15 17:33:18');
INSERT INTO `adoption_pets` VALUES (9, 1, 1, 4, '待审批', NULL, '2020-12-15 17:34:59');
INSERT INTO `adoption_pets` VALUES (10, 2, 1, 6, '待领养', NULL, '2020-12-15 17:36:35');
INSERT INTO `adoption_pets` VALUES (11, 1, 1, 5, '待审批', NULL, '2020-12-15 17:37:41');
INSERT INTO `adoption_pets` VALUES (21, NULL, NULL, 21, '待领养', NULL, NULL);

-- ----------------------------
-- Table structure for application_volunteer
-- ----------------------------
DROP TABLE IF EXISTS `application_volunteer`;
CREATE TABLE `application_volunteer`  (
  `av_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `base_id` int(11) DEFAULT NULL,
  `av_status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `av_pass_time` datetime(0) DEFAULT NULL COMMENT '通过时间',
  `av_application_time` datetime(0) DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`av_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of application_volunteer
-- ----------------------------
INSERT INTO `application_volunteer` VALUES (26, 3, 1, '审批驳回', '2021-03-05 15:08:45', '2020-12-14 17:45:36');
INSERT INTO `application_volunteer` VALUES (27, 2, 2, '审批通过', '2021-03-07 15:09:45', '2021-01-06 15:09:49');
INSERT INTO `application_volunteer` VALUES (28, 1, 3, '待审批', NULL, '2021-01-21 15:10:15');

-- ----------------------------
-- Table structure for background_images
-- ----------------------------
DROP TABLE IF EXISTS `background_images`;
CREATE TABLE `background_images`  (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `i_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `i_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `i_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of background_images
-- ----------------------------
INSERT INTO `background_images` VALUES (1, NULL, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571638041&di=22c081740596de79d06a827b982f2593&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-06-27%2F5b334187a10d9.jpg', '2020-11-28 16:51:37');
INSERT INTO `background_images` VALUES (2, NULL, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324722&di=c2e98fc643ca7b256a50cbe5c114a973&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F5472ea90ed2cb.jpg', '2020-11-28 16:51:51');
INSERT INTO `background_images` VALUES (3, NULL, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571537721&di=5065fe0165716fcd9a2f5803c339087c&imgtype=0&src=http%3A%2F%2Fimage.biaobaiju.com%2Fuploads%2F20191101%2F15%2F1572593235-DFQzqrLhkt.jpg', '2020-11-28 16:52:03');
INSERT INTO `background_images` VALUES (4, NULL, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606573028329&di=2c9c8741dde3856e7a3f01c02297c1e0&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F5%2F5565394460f19.jpg', '2020-11-30 15:24:18');
INSERT INTO `background_images` VALUES (5, NULL, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571553271&di=1dfe76c1d9ca3bda23eb4c023d62e1e8&imgtype=0&src=http%3A%2F%2Fs2.168muyu.com%2Fupload%2Fgallery%2F1001%2F298e8bcdaee549a3.jpg', '2020-11-30 15:24:29');

-- ----------------------------
-- Table structure for base_messages
-- ----------------------------
DROP TABLE IF EXISTS `base_messages`;
CREATE TABLE `base_messages`  (
  `bm_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(255) DEFAULT NULL,
  `bm_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bm_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bm_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bm_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bm_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`bm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of base_messages
-- ----------------------------
INSERT INTO `base_messages` VALUES (1, 3, 'Beam猫咖馆开业啦', '开业啦我好开心开业啦我好开心开业啦我好开心开业啦我好开心', 'Beam', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572811930&di=175471acd7ccabb4f20ca7ad4cfcc000&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-01-17%2F5a5ebe752a280.jpg', '2020-11-30 15:31:05');
INSERT INTO `base_messages` VALUES (2, 3, 'Beam猫咖馆开业啦2', '开业啦我好开心开业啦我好开心开业啦我好开心开业啦我好开心2', 'Beam', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572811930&di=175471acd7ccabb4f20ca7ad4cfcc000&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-01-17%2F5a5ebe752a280.jpg', '2020-11-30 16:35:20');
INSERT INTO `base_messages` VALUES (3, 3, 'Beam猫咖馆开业啦3', '开业啦我好开心开业啦我好开心开业啦我好开心开业啦我好开心3', 'Beam', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572811930&di=175471acd7ccabb4f20ca7ad4cfcc000&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-01-17%2F5a5ebe752a280.jpg', '2020-11-30 16:35:33');
INSERT INTO `base_messages` VALUES (4, 2, '成都爱之家动物救助中心开业啦', '我不想加数据了我不想加数据了我不想加数据了', '张先生', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '2020-11-30 16:36:26');
INSERT INTO `base_messages` VALUES (5, 2, '成都爱之家动物救助中心开业啦2', '我不想加数据了我不想加数据了我不想加数据了2', '张先生', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '2020-11-30 16:36:40');
INSERT INTO `base_messages` VALUES (6, 2, '成都爱之家动物救助中心开业啦3', '我不想加数据了我不想加数据了我不想加数据了3', '张先生', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '2020-11-30 16:36:50');
INSERT INTO `base_messages` VALUES (7, 1, '郑州动物之家', '真不想加了啊啊啊啊真不想加了啊啊啊啊真不想加了啊啊啊啊', '李先生', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '2020-11-30 16:37:29');
INSERT INTO `base_messages` VALUES (8, 1, '郑州动物之家2', '真不想加了啊啊啊啊真不想加了啊啊啊啊真不想加了啊啊啊啊2', '李先生', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '2020-11-30 16:37:43');
INSERT INTO `base_messages` VALUES (9, 1, '郑州动物之家3', '真不想加了啊啊啊啊真不想加了啊啊啊啊真不想加了啊啊啊啊3', '李先生', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '2020-11-30 16:37:54');

-- ----------------------------
-- Table structure for bases
-- ----------------------------
DROP TABLE IF EXISTS `bases`;
CREATE TABLE `bases`  (
  `base_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`base_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bases
-- ----------------------------
INSERT INTO `bases` VALUES (1, '成都爱之家动物救助中心', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570482996&di=e200e2c34d328fc979318406bbd14132&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-12-01%2F5a20f8c0a36e4.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571324720&di=bbd2ce4efa3d2cb0babc7b7b82a19ad3&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F537d90f67c413.jpg', '四川省成都市', '【爱之家简介】流浪动物的生态救助中心及爱心教育基地！救助流浪动物22年！于2009年在民政局正式注册成立。', '张先生', '123@gmail.com', '12345678911', '2009-03-12 11:35:05');
INSERT INTO `bases` VALUES (2, '郑州动物之家', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572811929&di=9d61552fc1d40958e20957e057dba899&imgtype=0&src=http%3A%2F%2Fpicture.ik123.com%2Fuploads%2Fallimg%2F161118%2F12-16111q51050.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571721135&di=de7bb68293f5bb701ab2f7a8ca13f919&imgtype=0&src=http%3A%2F%2Fs2.168muyu.com%2Fupload%2Fgallery%2F1001%2F36008df2ede930f7.jpg', '上海市', 'Tesla 全轮驱动车型搭载两台独立电机以提升冗余度，每台电机只有一个活动部件，耐用性高且易于维护。与传统的全轮驱动系统不同，两台电机可精准地分配前后轮扭矩，操控性和牵引力控制更为出色。', '李先生', '321@qq.com', '12345678911', '2020-11-23 16:45:42');
INSERT INTO `bases` VALUES (3, 'Beam的猫咖馆', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572811934&di=460d27770cae8efb4c550725ee2839a0&imgtype=0&src=http%3A%2F%2Fpic4.bbzhi.com%2Fdongwubizhi%2Fgaoqingdongwubizhixiazai%2Fgaoqingdongwubizhixiazai_350162_12.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572811926&di=18fb735e54b26ee857a2dfe107550bb7&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F5%2F55ec0ba414380.jpg', '美国', '探索Apple 充满创新的世界,选购各式 iPhone、iPad、Apple Watch 和 Mac,浏览各种配件、娱乐产品,并获得相关产品的专家支持服务。', '梁豪', 'Beamm0613@163.com', '15838365368', '2020-11-03 15:00:33');

-- ----------------------------
-- Table structure for bases_images
-- ----------------------------
DROP TABLE IF EXISTS `bases_images`;
CREATE TABLE `bases_images`  (
  `bi_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(255) DEFAULT NULL,
  `bi_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `bi_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`bi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bases_images
-- ----------------------------
INSERT INTO `bases_images` VALUES (1, 3, 'https://img9.51tietu.net/pic/2019-091021/nwmw2fofpodnwmw2fofpod.jpg', '2020-11-28 19:17:25');
INSERT INTO `bases_images` VALUES (2, 3, 'https://img9.51tietu.net/pic/2019-091021/q2lwiavotr1q2lwiavotr1.jpg', '2020-11-28 19:17:34');
INSERT INTO `bases_images` VALUES (3, 3, 'https://img9.51tietu.net/pic/2019-091021/ezpqlziet2jezpqlziet2j.jpg', '2020-11-28 19:17:42');
INSERT INTO `bases_images` VALUES (4, 3, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606572354467&di=31868267719aebb2146eeb2ca9a2ec4f&imgtype=0&src=http%3A%2F%2F00.minipic.eastday.com%2F20170717%2F20170717064222_345a75b17569b93eab1f6d1b33521e39_3.jpeg', '2020-11-28 19:18:01');
INSERT INTO `bases_images` VALUES (5, 3, 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2592323940,3437201934&fm=26&gp=0.jpg', '2020-11-28 19:18:23');
INSERT INTO `bases_images` VALUES (6, 2, 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1862754643,753794590&fm=26&gp=0.jpg', '2020-11-28 19:18:39');
INSERT INTO `bases_images` VALUES (7, 2, 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3241611160,3654364116&fm=26&gp=0.jpg', '2020-11-28 19:18:51');
INSERT INTO `bases_images` VALUES (8, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606569774695&di=fbc8a4d20732ad29997eba2c8ff3f4be&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2018-01-17%2F5a5ec207ecdf1.jpg', '2020-11-28 19:19:28');
INSERT INTO `bases_images` VALUES (9, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606569965144&di=8ee3c52f858c1908160f0d4bc28622c1&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F8%2F5643fb4ac61f7.jpg', '2020-11-28 19:19:42');
INSERT INTO `bases_images` VALUES (10, 2, 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570072467&di=937ebb23c637937f761a5fab00b1441b&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2Fd%2F58c2778ec34b1.jpg', '2020-11-28 19:20:03');
INSERT INTO `bases_images` VALUES (11, 1, 'http://pic1.win4000.com/wallpaper/2020-06-05/5ed9d65be2791.jpg', '2020-11-28 19:20:21');
INSERT INTO `bases_images` VALUES (12, 1, 'http://pic1.win4000.com/wallpaper/2020-09-17/5f62f59829421.jpg', '2020-11-28 19:20:35');
INSERT INTO `bases_images` VALUES (13, 1, 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f78f34cc.jpg', '2020-11-28 19:21:04');
INSERT INTO `bases_images` VALUES (14, 1, 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f79cbf8c.jpg', '2020-11-28 19:21:22');
INSERT INTO `bases_images` VALUES (15, 1, 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f7bec170.jpg', '2020-11-28 19:21:34');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `c_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `c_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (10, 1, '我喜欢你', '2020-12-13 15:58:59');

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
  `m_id` int(11) NOT NULL AUTO_INCREMENT,
  `m_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `m_details` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `m_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `m_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `m_pv` int(255) DEFAULT NULL,
  `m_createtime` datetime(0) DEFAULT NULL,
  `m_updatetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`m_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (4, 'Toptrees领先 ×美院动物保护协会：这个冬天，给TA一个家', '“给TA一个家”——宠物食品品牌Toptrees领先和美院动物保护协会（下简称“动保协会”）共同发起的流浪猫狗小屋正式安置，在冬日来临之际，让美院校园里的流浪动物们多了能遮风避雨的地方。此外，Toptrees领先还为美院动保协会捐赠了爱心猫犬粮及零食，首批总重约100kg。', '来源: 大众新闻', 'https://nimg.ws.126.net/?url=http%3A%2F%2Fcrawl.ws.126.net%2F79418b74e3aeb359f08d3fa1f505c98b.png&thumbnail=660x2147483647&quality=80&type=jpg', 1, '2020-11-11 15:45:28', '2020-11-11 15:45:28');
INSERT INTO `messages` VALUES (5, '津城警事｜“爱鸟护飞”、保护野生动物，江津公安在行动', '11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现场宣传，提高全民保护野生动物的意识。', '来源: 潇湘晨报', 'https://pic3.zhimg.com/80/v2-03bdcbc6ebca5b0653ddb9440970f146_720w.jpg', 1, '2020-11-11 15:46:30', '2020-11-11 15:46:30');
INSERT INTO `messages` VALUES (7, 'OWOH x 浦江王阿姨流浪动物公益项目温暖魔都', '随着天气逐渐变冷，流浪动物的吃饱穿暖问题也引起了众多爱宠人士的关注。没有固定的家，没有主人的宠爱，没有足够的食粮，没有御寒的住所，继而引发无数的流浪猫狗很难挺过寒冬的死亡现象。作为国内知名的宠物 APP-OWOH，于 12 月 21 日 -22 日在新天地湖滨路活力街区举办了 ‘ 给毛孩点一份外卖 ’ 的爱心救助公益活动，帮助流浪动物过冬、解决领养问题，此次活动也吸引了上海各个地区数万位爱宠人士到现场捐出自己的一份爱心，把有意向的流浪动物领养回家。', '来源: MY宠物', 'https://www.mychongwu.com/uploads/images/2019/1226/1577328917240074.jpg', 1, '2020-11-24 09:34:31', '2020-11-24 09:34:31');

-- ----------------------------
-- Table structure for pets_info
-- ----------------------------
DROP TABLE IF EXISTS `pets_info`;
CREATE TABLE `pets_info`  (
  `pi_id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_breed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_DH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '疾病史',
  `pi_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_image_1` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_image_2` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_image_3` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pi_image_4` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `base_id` int(255) DEFAULT NULL,
  `pi_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`pi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pets_info
-- ----------------------------
INSERT INTO `pets_info` VALUES (2, '嘟嘟', '三岁', '英短', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f7ce7316.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571553271&di=1dfe76c1d9ca3bda23eb4c023d62e1e8&imgtype=0&src=http%3A%2F%2Fs2.168muyu.com%2Fupload%2Fgalleryhttp://pic1.win4000.com/wallpaper/2020-11-18/5fb489f15f9bc.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358098195&di=96c020db47a03a15280755b82a55662d&imgtype=0&src=http%3A%2F%2Fpic.rmb.bdstatic.com%2F73db4b50954b8a67d44c82e84437de03.jpeg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571553271&di=1dfe76c1d9ca3bda23eb4c023d62e1e8&imgtype=0&src=http%3A%2F%2Fs2.168muyu.com%2Fupload%2Fgallery%2F1001%2F298e8bcdaee549a3.jpg', 3, '2021-03-06 16:21:44');
INSERT INTO `pets_info` VALUES (3, '七七', '一岁', '豹纹', '2019年曾有情流感，已医治好', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f7f08cc4.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570896430&di=480625fc74545d63f2fc0fe3c3b598db&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaperhttp://pic1.win4000.com/wallpaper/2020-11-http://pic1.win4000.com/wallpaper/2020-11-13/5fae02db82a70.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570896430&di=480625fc74545d63f2fc0fe3c3b598db&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F9%2F551521c398610.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358098247&di=9673f1dc4db4186fd388c8fd5c351574&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fq_70%2Cc_zoom%2Cw_640%2Fimages%2F20180827%2Fa5444c40c0284ebc8aa681b15bfec5f4.jpg', 3, '2021-03-06 16:21:48');
INSERT INTO `pets_info` VALUES (4, '大q', '三个月', '英短', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571537721&di=5065fe0165716fcd9a2f5803c339087c&imgtype=0&src=http%3A%2F%2Fimage.biaobaiju.com%2Fuploads%2F20191101%2F15%2F1572593235-DFQzqrLhkt.jpg', 'http://pic1.win4000.com/wallpaper/2020-11-https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3193766112,992114955&fm=26&gp=0.jpg', 'http://pic1.win4000.com/wallpaper/2020-11-18/5fb489ec15383.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358098247&di=96de7095341e7727d542c1241ca4810a&imgtype=0&src=http%3A%2F%2Fgw.alicdn.com%2Fimgextra%2Fi3%2F254751444%2FTB25w8EaXXXXXXRXXXXXXXXXXXX-254751444.jpg', 1, '2021-03-06 16:21:51');
INSERT INTO `pets_info` VALUES (5, '小白', '一岁', '无毛', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606571263377&di=deac956ffaf7c3f3727a3e6b9e98194f&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F6%2F53d6f88f1802f.jpg', 'http://pic1.win4000.com/wallpaper/2020-11-18/5fb489edd36b0.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358098245&di=892fa3e1c8ba9bec32250800e2197508&imgtype=0&src=http%3A%2F%2Fpic41.nipic.com%2F20140429%2F18613761_132224353126_2.jpg', 'http://pic1.win4000.com/wallpaper/2020-11-18/5fb489edd36b0.jpg', 1, '2021-03-06 16:21:55');
INSERT INTO `pets_info` VALUES (6, '金毛', '五个月', '金毛', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570884427&di=410ec2c59f2ec697fee2ec3902a4fe85&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fwallpaper%2F1309%2F29%2Fc0%2F26600200_1380425742844.jpg', 'http://pic1.win4000.com/wallpaper/2020-11-18/5fb489eeae9aa.jpg', 'http://pic1.win4000.com/wallpaper/2020-11-https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358098195&di=b04d1403857cd585443de8aa6054fbd8&imgtype=0&src=http%3A%2F%2F5b0988e595225.cdn.sohucs.com%2Fimages%2F20180511%2F5d7a9ab54a26422a991942a7d3153701.jpeg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358098243&di=f9c173dba5ba4c2bb1d59e40f8daad52&imgtype=0&src=http%3A%2F%2Fimg.article.pchome.net%2F00%2F49%2F20%2F97%2Fpic_lib%2Fs960x639%2F12s960x639.jpg', 2, '2020-12-30 16:21:57');
INSERT INTO `pets_info` VALUES (7, '金毛2', '五个月', '金毛', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570884427&di=410ec2c59f2ec697fee2ec3902a4fe85&imgtype=0&src=http%3A%2F%2Fimg.pconline.com.cn%2Fimages%2Fupload%2Fupc%2Ftx%2Fwallpaper%2F1309%2F29%2Fc0%2F26600200_1380425742844.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358317542&di=fa1007c19a17f99ce955cb75baca5664&imgtype=0&src=http%3A%2F%2Fpic8.58cdn.com.cn%2Fp1%2Fbig%2Fn_v2067e13ee29454f088a9af439cdf6c8a9.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358317540&di=147fb37e89c4fbfe6bf4f663f4033e7a&imgtype=0&src=http%3A%2F%2Fpic8.58cdn.com.cn%2Fp1%2Fbig%2Fn_v2285ae73b1b574e3599253d083e7614ac.jpg', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1607358317540&di=ee1388646b082ff6b264d29b4da7b2ab&imgtype=0&src=http%3A%2F%2Ftct.ganjistatic1.com%2Fgjfsqq%2Fgjupload%2Fd566ea4197364004b8787d04204bd2cc_600-0_6-0.jpg', 2, NULL);
INSERT INTO `pets_info` VALUES (9, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, '2021-03-07 14:23:39');
INSERT INTO `pets_info` VALUES (10, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, '2021-03-07 14:23:44');
INSERT INTO `pets_info` VALUES (11, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, '2021-03-07 15:01:22');
INSERT INTO `pets_info` VALUES (21, '111', '11111', '111', '111111', '111', NULL, NULL, NULL, NULL, NULL, '2021-03-07 16:35:00');

-- ----------------------------
-- Table structure for popularizations
-- ----------------------------
DROP TABLE IF EXISTS `popularizations`;
CREATE TABLE `popularizations`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_details` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `p_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_pv` int(255) DEFAULT NULL COMMENT '访问量',
  `p_type` int(255) DEFAULT NULL COMMENT '科普类型：\r\n1 品种科普\r\n2 动物常患疾病\r\n3 动物冷知识',
  `p_createtime` datetime(0) DEFAULT NULL,
  `p_updatetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of popularizations
-- ----------------------------
INSERT INTO `popularizations` VALUES (1, '宠物猫狗吃巧克力会中毒？', '一小块巧克力中含有的可可碱，猫和狗也需要很长的时间才能分解完。过量的可可碱，会导致狗、猫产生消化异常、兴奋、脱水、心率缓慢等问题，有时会致命。 论证人类美食，宠物毒药 巧克力是最让人愉悦的食物之一，不过，对狗和猫来说，它却是和除草剂、防冻液、耗子药齐名的致命剧毒。巧克力中含有可可碱，它是巧克力带给人快感的源泉，同咖啡因和茶碱一样，可可碱也是植物用来防备动物取食的毒剂。人可以很快地通过肝脏和肾脏将可可碱处理并排出体外，而猫狗排出可可碱就慢得多，吃多了会中毒而死。这方面猫比狗要走运，因为猫对甜味不敏感，巧克力和水果对猫来说味同嚼蜡，而大多数狗则喜爱甜食（这也与从小的饮食习惯有关）。 根据著名的兽医手册Merck Veterinary Manual中的剂量说明，29g的牛奶巧克力（约1.5块最小号的德芙牛奶巧克力）会让一只3公斤的小型犬（博美、吉娃娃等）产生呕吐、痢疾、剧渴等症状，而80g牛奶巧克力（4块最小号的德芙牛奶巧克力）就可能让3公斤的小型犬类有死亡危险了。这方面猫比狗要走运，因为猫对甜味不敏感，巧克力和水果对猫来说味同嚼蜡，而大多数狗则喜爱甜食（这也与从小的饮食习惯有关）。水果也可能带来问题 水果对人类好处多多，对猫和狗也不啻于毒药。比如葡萄和葡萄干，狗吃了有可能引起肾衰竭并可致命，虽然视狗的品种和体质不同，有的狗吃点葡萄看起来也没什么反应，但为了狗的健康，别给它们吃这些东西。而其他水果也有可能引起狗的呕吐和腹泻。', '风迷路了', 'https://pic2.zhimg.com/80/v2-951048e9a61563f797c25484d170807d_720w.jpg', 1, 2, '2020-11-10 19:09:45', '2020-11-10 19:09:47');
INSERT INTO `popularizations` VALUES (4, '根据宠物猫狗的体型，要打不同剂量的疫苗？', '无论宠物体型，免疫还是需要注射整个剂量以保证疫苗的保护性，但是对于体重小和玩具型品种的狗狗需要给予更多的关注。不能因为绝育增加了点点疫苗不良反应的风险就不做绝育，尽可能每次只进行一种疫苗的免疫。', '一支草', 'https://pic4.zhimg.com/80/v2-4981e6e4109428dd16009c7e631060a3_720w.jpg', 1, 1, '2020-11-11 15:58:24', '2020-11-11 15:58:24');
INSERT INTO `popularizations` VALUES (5, '仓鼠怎么养?', '导语：可爱的毛茸茸的动物是世界上最受欢迎的动物之一，就比如说小小的仓鼠，一看就能让人爱上它。那么你们知道仓鼠怎么养吗?之前小编为大家讲解过十大对人类友好的动物，今天呢就为大家揭秘养仓鼠所需要知道的12件事情，感兴趣的不妨一起往下看!', '软萌颜 ', 'http://www.tanmizhi.com/img/allimg/12/15-1Q21Q10J2.png', 1, 3, '2020-11-11 16:03:43', '2020-11-11 16:03:43');
INSERT INTO `popularizations` VALUES (7, '猫咪偷窥你上厕所并不是色，而是一种“幼猫行为”', '每次上厕所，总能感觉到有一双眼睛在暗处盯着我，好几次都觉得背后发凉！甚至想去某大仙处领几张符挂在厕所。直到我意外地看到了厕所门外，一动不动盯着我的猫......猫咪难道有偷窥欲？  一开始只是一动不动，后来胆子就慢慢大了，开始推门和挠门了。然而我家厕所门还是坏的，轻轻一推里面就暴露无遗。于是最后就演变成了我在蹲坑的这头看猫，猫在蹲坑的那头外头看我，相顾无言唯有一行。', 'HolisticBlend活力枫叶 ', 'https://pic2.zhimg.com/v2-25ccc07e956f6541d61e665baf5b7df5_b.jpg', 1, 3, '2020-11-24 09:44:02', '2020-11-24 09:44:02');
INSERT INTO `popularizations` VALUES (8, '猫老叫怎么办 首先需要判断小猫叫的原因', '猫老叫怎么办?首先判断小猫叫的原因<br>1)如果是到了发情期，<br>可以采取绝育的方式，有效解决持续叫的情况(关于绝育，有的主人会觉得残忍，但实际并不是的，这是对这寿命的延长和身体健康的一种保护，更重要的还可以减少更多的流浪猫。)但对于小猫也许并不是发情所导致，所以必须慎重。<br>2)对环境不熟悉<br>猫咪来到新的环境时，会因为陌生而一直叫，此时的主人一定要借此机会消除小猫的紧张感并培养感情(下面会讲到如何消除紧张感)。<br>3)细心的对待它<br>首先准备好完善的饮食工具是基本的，接著就是要带它认识新的环境，主要是喝水、饮食以及猫砂的位置，当它一叫就抱起来安抚它，也可以准备一些玩具，时间久了情况就会改善。<br>4)可能是生病了<br>如果猫咪的叫声是萎靡的，看起来状态也不是很好的样子，就可能是生病了，要赶紧送医检查，以免造成生命危险。<br>如何消除猫咪紧张感?<br>1、给它一点空间<br>猫咪刚到这个新家的时候，会因为陌生而处于一种紧张的状态，会显得非常胆怯，但当过一段时间后，让它多跟人接触的后，胆怯就会减少不少，所以要给它一点空间和时间来适应。<br>2、主人要怎么做<br>主人可以先轻轻地抚摸它，轻轻摸摸它的头，温柔地和它说说话，每天固定一个时间进行这样的互动，久了猫咪就会愿意相信你了，要得到猫咪的信任必须付出一定的耐心才可以。<br>3、可以利用诱惑<br>对小猫咪的紧张感，也可以从诱惑开始著手，可以准备一顿丰盛的大餐，当它吃得忘我的时候，就可以趁这时候轻轻地抚摸它的头，一定要温柔一点，千万不能吓到它!<br>猫老叫怎么办?以下注意事项主人一定要知道!<br>1、隔离危险家电<br>在猫咪来到这个新环境之前，主人必须先把猫咪可能碰触到的家具，都放置在安全的地方，以免猫咪接触到而有生病危险，尤其是柜子上或是其他高的家具都要特别注意。<br>2、保证环境安全<br>像一些外漏的电线都必须收起来，以免猫咪啃咬的时候被电击，没在用时就要随手关掉电源，火炉边也必须要安全的栅栏，以免猫咪碰触到而引发生生病危险，需制造一个安全空间。<br>3、训练窝裡睡觉<br>要训练猫咪在窝裡睡觉，训练前必须先准备一个温暖舒适的窝，若经过几次训练之后猫咪还是不愿在里头睡觉，可以在窝上盖上一层罩子，让它不能往外跑，时间久了也就习惯了。', 'Beam', 'http://www.ichong123.com/files/2016/11/10/182/11.jpg', 1, 1, '2020-12-06 17:39:44', '2020-12-06 17:39:44');
INSERT INTO `popularizations` VALUES (10, '美系秋田犬长多高 公犬肩高在66到71厘米', '秋田犬好养吗<br>秋田犬平时应戴上项圈和拴上牵绳，外出时要由主人牵住，以防野性发作，对人和其他动物发起攻击。平时要经常教它养成听从主人命令和指唤的习惯。特别要能听懂主人喝止不许它侵犯人和其他动物的命令，防止它越轨而闯下祸端。<br>平时还应注意训练它养成爱清洁卫生的习惯。特别要养成定点排便的习惯。不许它随处便溺，破坏环境卫生。在饲养过程中，要时刻注意它的行为举止，留心是否有精神状态异常、食欲减退、大便变形、鼻垫过干或发热等患病迹象，美歪，一旦发现状态失常，美歪网，患上疾病，就应及时采取治疗措施。<br>美系秋田犬体型特点<br>在实际的饲养过程中，美系秋田犬的体型较大，给人较为威武的感觉，因此饲养美系秋田犬需要消耗较多的资金满足美系秋田犬的饮食与生活需求，在饲养美系秋田犬的时候，要求每位饲养者能够为美系秋田犬提供充足的食物与营养成分，才能够保障美系秋田犬以较为健康的形态完成全部的生长过程，达到强身健体的目的，有效减少各类疾病对于美系秋田犬的危害。<br>美系秋田犬特征<br>体形大，机敏，强壮，肌肉丰满。头部呈三角形，吻部长。眼睛小，两耳直立，与后颈部在一条直线上，这是秋田犬的特征之一。另一个特征是尾大而卷曲，与宽阔的头部对称，与其它犬种很好区分。<br>体型<br>公犬：肩高66~71cm，体重45~55kg<br>母犬：肩高61~66cm，体重40~55kg<br>缺点：公犬低于63厘米，母犬低于58厘米', 'Beam', 'http://www.ichong123.com/files/2016/12/25/249/hwzei00.png', 1, 2, '2020-12-06 18:15:53', '2020-12-06 18:15:53');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_sex` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_type` int(2) NOT NULL COMMENT '1是管理员；2是普通用户',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_star_petId` int(11) DEFAULT NULL,
  `user_star_volunteerId` int(11) DEFAULT NULL,
  `user_createtime` datetime(0) DEFAULT NULL,
  `user_updatetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'root', 'Beam', '梁豪', 'https://pic4.zhimg.com/80/v2-557a700c26facb72f4ed088041e23c17_720w.jpg', '25d55ad283aa400af464c76d713c07ad', '女', 21, 2, '15838365360', 'Beamm0613@163.com', 'I love code', 'I AM CEO', '河南省', '驻马店市古吕镇', NULL, NULL, '2020-11-06 14:03:37', '2020-12-15 20:09:56');
INSERT INTO `user_info` VALUES (2, 'ZhangSan', '张三', '张三', 'https://pic1.zhimg.com/80/v2-cc3a5cdd40e9dab5c5ea3e934d4a31e0_720w.jpg', '25d55ad283aa400af464c76d713c07ad', '男', 21, 1, '110', 'zhangsan110@gmail.com', 'I love code', 'i love code', '重庆', '羊山区', NULL, NULL, '2020-11-06 17:26:54', '2020-11-12 17:54:30');
INSERT INTO `user_info` VALUES (3, '1223697311@qq.com', 'weirdo', '美少女', 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/7df21398-0df0-4635-87ce-1c03cb4b9794下载.jpg', '1bbd886460827015e5d605ed44252251', '女', 20, 1, '18568275991', '1223697311@qq.com', '我是你爸爸我是你爸爸我是你爸爸我是你爸爸我是你爸爸我是你爸爸', '我是你爸爸我是你爸爸我是你爸爸我是你爸爸我是你爸爸', '北京市', '北京市西城区', NULL, NULL, '2020-11-16 17:52:54', '2020-12-14 15:58:38');
INSERT INTO `user_info` VALUES (18, '604520242@qq.com', 'ahaha', NULL, NULL, '25d55ad283aa400af464c76d713c07ad', NULL, NULL, 1, NULL, '604520242@qq.com', NULL, NULL, NULL, NULL, NULL, NULL, '2020-12-04 17:49:07', '2020-12-04 17:49:07');
INSERT INTO `user_info` VALUES (19, 'Beamm0613@163.com', '12312', NULL, NULL, '25d55ad283aa400af464c76d713c07ad', NULL, NULL, 1, NULL, 'Beamm0613@163.com', NULL, NULL, NULL, NULL, NULL, NULL, '2020-12-04 17:50:25', '2020-12-04 17:50:25');

-- ----------------------------
-- Table structure for volunteer_form
-- ----------------------------
DROP TABLE IF EXISTS `volunteer_form`;
CREATE TABLE `volunteer_form`  (
  `vf_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `base_id` int(11) DEFAULT NULL,
  `vf_age` int(11) DEFAULT NULL,
  `vf_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_join_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_family_agree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_health` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_join_work` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_had_car` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_receive_train` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_had_joined` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vf_create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`vf_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of volunteer_form
-- ----------------------------
INSERT INTO `volunteer_form` VALUES (5, 3, 1, 20, '18568275991', '周六,周日', '是', '否', '救助组,看时间决议', '无', '是', '是', 'IT', '晏金玉', NULL);
INSERT INTO `volunteer_form` VALUES (6, 4, 2, 22, '15838365368', '周六，周日', '是', '否', '救援组', '无', '是', '是', 'TT', '梁豪', NULL);

-- ----------------------------
-- Table structure for volunteer_info
-- ----------------------------
DROP TABLE IF EXISTS `volunteer_info`;
CREATE TABLE `volunteer_info`  (
  `vi_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) DEFAULT NULL,
  `vi_status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vi_requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vi_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vi_joinPopulation` int(11) DEFAULT NULL,
  `vi_population` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `vi_start_time` datetime(0) DEFAULT NULL,
  `vi_end_time` datetime(0) DEFAULT NULL,
  `vi_create_time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`vi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of volunteer_info
-- ----------------------------
INSERT INTO `volunteer_info` VALUES (1, 3, '已截止', '具备诚实守信和精诚团结精神', '测试测试测试测试1', 59, '60', '2020-08-19 18:28:08', '2020-11-20 18:28:02', '2020-12-05 18:28:12');
INSERT INTO `volunteer_info` VALUES (2, 2, '未开始', '具备诚实守信和精诚团结精神', '测试测试测试测试2', 12, '50', '2021-02-17 16:00:27', '2022-07-26 16:00:22', '2020-12-09 16:00:32');
INSERT INTO `volunteer_info` VALUES (3, 1, '可报名', '具备诚实守信和精诚团结精神', '测试测试测试测试3', 10, '40', '2020-10-21 16:02:13', '2021-01-10 16:02:04', '2020-12-09 16:02:18');

SET FOREIGN_KEY_CHECKS = 1;
