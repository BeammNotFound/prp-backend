/*
 Navicat Premium Data Transfer

 Source Server         : monsterteam.top
 Source Server Type    : MySQL
 Source Server Version : 50562
 Source Host           : monsterteam.top:3306
 Source Schema         : prp

 Target Server Type    : MySQL
 Target Server Version : 50562
 File Encoding         : 65001

 Date: 10/05/2021 14:17:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adoption_form
-- ----------------------------
DROP TABLE IF EXISTS `adoption_form`;
CREATE TABLE `adoption_form`  (
  `af_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `pet_id` int(11) NULL DEFAULT NULL,
  `base_id` int(11) NULL DEFAULT NULL,
  `af_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_age` int(11) NULL DEFAULT NULL,
  `af_appraise` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_info1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_info2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_info3` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_info4` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_info5` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_info6` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `af_create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`af_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of adoption_form
-- ----------------------------
INSERT INTO `adoption_form` VALUES (4, 3, 1, 2, '河南省信阳市', 21, '乐观可爱', '是', '是', '是', '是', '是', '是', '2020-12-13 18:18:54');
INSERT INTO `adoption_form` VALUES (5, 1, 4, 1, '河南省郑州市', 11, '热爱动物', '是', '是', '是', '是', '是', '是', '2020-12-13 18:24:09');
INSERT INTO `adoption_form` VALUES (6, 2, 3, 3, '河南省信阳市', 11, '性格开放', '是', '是', '是', '是', '是', '是', '2020-12-15 17:20:17');
INSERT INTO `adoption_form` VALUES (7, 3, 5, 1, '河南省郑州市', 11, '乐于沟通', '是', '是', '是', '是', '是', '是', '2020-12-15 17:33:18');
INSERT INTO `adoption_form` VALUES (8, 1, 5, 1, '111', 12, '11111', '是', '是', '是', '是', '是', '是', '2021-04-13 19:42:52');
INSERT INTO `adoption_form` VALUES (9, 1, 7, 2, '河南省信阳市', 12, '11111', '是', '是', '是', '是', '是', '是', '2021-04-13 19:45:12');
INSERT INTO `adoption_form` VALUES (10, 2, 2, 1, 'string', 2, 'string', 'string', 'string', 'string', 'string', 'string', 'string', '2021-04-13 21:19:27');
INSERT INTO `adoption_form` VALUES (11, 1, 6, 1, '河南省信阳市', 12, '11111', '是', '是', '是', '是', '是', '是', '2021-04-13 21:21:10');
INSERT INTO `adoption_form` VALUES (12, 6, 3, 1, '测试', 21, '测试', '是', '是', '是', '是', '是', '是', '2021-04-13 21:24:09');
INSERT INTO `adoption_form` VALUES (13, 6, 2, 3, '111', 12, '乐观可爱', '是', '是', '是', '是', '是', '是', '2021-04-13 21:44:58');
INSERT INTO `adoption_form` VALUES (14, 4, 7, 2, '测试', 22, '测试', '是', '是', '是', '是', '是', '是', '2021-04-13 21:45:58');

-- ----------------------------
-- Table structure for adoption_pets
-- ----------------------------
DROP TABLE IF EXISTS `adoption_pets`;
CREATE TABLE `adoption_pets`  (
  `ap_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `pet_id` int(11) NULL DEFAULT NULL,
  `ap_status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `ap_pass_time` datetime NULL DEFAULT NULL,
  `ap_application_time` datetime NULL DEFAULT NULL COMMENT '领养时间',
  PRIMARY KEY (`ap_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 19 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of adoption_pets
-- ----------------------------
INSERT INTO `adoption_pets` VALUES (1, 3, 1, 2, '待审批', '2021-03-06 16:02:41', '2021-04-13 21:54:24');
INSERT INTO `adoption_pets` VALUES (2, 1, 1, 3, '待审批', '2021-03-05 09:44:01', '2021-04-13 21:54:23');
INSERT INTO `adoption_pets` VALUES (3, 1, 1, 4, '待审批', '2021-03-07 10:53:16', '2021-04-13 21:54:21');
INSERT INTO `adoption_pets` VALUES (4, 1, 2, 5, '待审批', '2021-03-07 10:54:40', '2021-04-13 21:54:19');
INSERT INTO `adoption_pets` VALUES (5, 2, 3, 7, '待审批', '2021-03-07 11:31:37', '2021-04-13 21:54:18');
INSERT INTO `adoption_pets` VALUES (6, 1, 3, 6, '待审批', '2021-03-07 11:33:41', '2021-04-13 21:54:16');
INSERT INTO `adoption_pets` VALUES (12, 1, 1, 5, '待审批', NULL, '2021-04-13 19:42:52');
INSERT INTO `adoption_pets` VALUES (13, 2, 1, 7, '待审批', NULL, '2021-04-13 19:45:12');
INSERT INTO `adoption_pets` VALUES (14, 1, 2, 2, '待审批', NULL, '2021-04-13 21:19:27');
INSERT INTO `adoption_pets` VALUES (15, 1, 1, 6, '待审批', NULL, '2021-04-13 21:21:10');
INSERT INTO `adoption_pets` VALUES (16, 1, 6, 3, '待审批', '2021-04-13 21:35:19', '2021-04-13 21:54:15');
INSERT INTO `adoption_pets` VALUES (17, 3, 6, 2, '待审批', NULL, '2021-04-13 21:44:58');
INSERT INTO `adoption_pets` VALUES (18, 2, 4, 7, '待审批', NULL, '2021-04-13 21:45:58');

-- ----------------------------
-- Table structure for application_volunteer
-- ----------------------------
DROP TABLE IF EXISTS `application_volunteer`;
CREATE TABLE `application_volunteer`  (
  `av_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `base_id` int(11) NULL DEFAULT NULL,
  `av_status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `av_pass_time` datetime NULL DEFAULT NULL COMMENT '通过时间',
  `av_application_time` datetime NULL DEFAULT NULL COMMENT '申请时间',
  PRIMARY KEY (`av_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of application_volunteer
-- ----------------------------
INSERT INTO `application_volunteer` VALUES (26, 3, 1, '审批驳回', '2021-03-05 15:08:45', '2020-12-14 17:45:36');
INSERT INTO `application_volunteer` VALUES (27, 2, 2, '审批通过', '2021-03-07 15:09:45', '2021-01-06 15:09:49');
INSERT INTO `application_volunteer` VALUES (28, 1, 3, '审批通过', '2021-03-09 21:58:12', '2021-01-21 15:10:15');

-- ----------------------------
-- Table structure for background_images
-- ----------------------------
DROP TABLE IF EXISTS `background_images`;
CREATE TABLE `background_images`  (
  `i_id` int(11) NOT NULL AUTO_INCREMENT,
  `i_src` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `i_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`i_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of background_images
-- ----------------------------
INSERT INTO `background_images` VALUES (1, 'https://p26-tt.byteimg.com/origin/pgc-image/58e6d29c19ef4bcfaf64379891659e2b', '2020-11-28 16:51:37');
INSERT INTO `background_images` VALUES (2, 'https://p6-tt-ipv6.byteimg.com/origin/pgc-image/3c4b1d0ee5c048d292608031c146d677', '2020-11-28 16:51:51');
INSERT INTO `background_images` VALUES (3, 'https://p1-tt-ipv6.byteimg.com/origin/pgc-image/1962155d96b9471996aaba52be3a74c2', '2020-11-28 16:52:03');
INSERT INTO `background_images` VALUES (4, 'https://p1-tt-ipv6.byteimg.com/origin/pgc-image/4fa73bd79f314674a581b7dd3fbf856c', '2020-11-30 15:24:18');
INSERT INTO `background_images` VALUES (5, 'https://p9-tt-ipv6.byteimg.com/origin/pgc-image/e69c5f90ea5a40438ee8c5a3dc37f66e', '2020-11-30 15:24:29');

-- ----------------------------
-- Table structure for base_messages
-- ----------------------------
DROP TABLE IF EXISTS `base_messages`;
CREATE TABLE `base_messages`  (
  `bm_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NULL DEFAULT NULL,
  `bm_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bm_detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bm_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bm_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bm_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`bm_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of base_messages
-- ----------------------------
INSERT INTO `base_messages` VALUES (1, 3, 'Beam猫咖馆开业啦！', '这个世界是多么冷酷，然而，待在猫儿身边，世界就可以变得美好而温柔了。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', 'Beam', 'https://img.imgdb.cn/item/604c899f5aedab222c5189fe.jpg', '2020-11-30 15:31:05');
INSERT INTO `base_messages` VALUES (2, 3, '宠物，让美好的生活多一些！', '凭什么，猫猫狗狗长得圆圆的就是可爱，我长得圆圆的就是胖子。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', 'Beam', 'https://img.imgdb.cn/item/604d79145aedab222cb8d95c.jpg', '2020-11-30 16:35:20');
INSERT INTO `base_messages` VALUES (3, 3, '保护动物，你我的职责。', '你有你的家人 你的朋友 你的同学，可是猫的世界只有你，她的一生都在陪伴你。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', 'Beam', 'https://img.imgdb.cn/item/604d79145aedab222cb8d95e.jpg', '2020-11-30 16:35:33');
INSERT INTO `base_messages` VALUES (4, 2, '成都爱之家动物救助中心开业啦！', '不曾养过宠物的人，很难想象与宠物一起生活是什么样子，养过宠物的人，则无法想象没有宠物的日子该怎么过。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', '张先生', 'https://img.imgdb.cn/item/604d79145aedab222cb8d960.jpg', '2020-11-30 16:36:26');
INSERT INTO `base_messages` VALUES (5, 2, '没有动物，生命没有了动力！', '我会记住你带我去过的每一个地方，寸步不离。相依相守。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', '张先生', 'https://img.imgdb.cn/item/604d79145aedab222cb8d962.jpg', '2020-11-30 16:36:40');
INSERT INTO `base_messages` VALUES (6, 2, '善待动物，和谐生存!', '你高兴时我比你更高兴，你难过时我想倾尽所有逗你开心。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', '张先生', 'https://img.imgdb.cn/item/604d79a95aedab222cb91a76.jpg', '2020-11-30 16:36:50');
INSERT INTO `base_messages` VALUES (7, 1, '郑州动物之家开业啦！', '希望大家能够救助全国各地的宠物！11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', '李先生', 'https://img.imgdb.cn/item/604d79a95aedab222cb91a7a.jpg', '2020-11-30 16:37:29');
INSERT INTO `base_messages` VALUES (8, 1, '保护动物就是，保护我们的同类。', '提高环境意识，爱护花草树木，保护野生动物，维护公共设施，促进人与人人与社会人与自然的协调发展。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', '李先生', 'https://img.imgdb.cn/item/604d79a95aedab222cb91a7e.jpg', '2020-11-30 16:37:43');
INSERT INTO `base_messages` VALUES (9, 1, '愿动物的爱永远伴随着你成长。', '是先有鸟还是先有蛋，你不知道，我不知道，只有鸟知道。是鸟先消失还是蛋先消失，你知道，我知道，只有鸟不知道。11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月\r\n                        启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现\r\n                        场宣传，提高全民保护野生动物的意识。活动现场，民警向前来赏鸟的市民发放推进长江禁捕，严禁出售、经营、加工非法捕捞工具、渔获，自然保护区条例...', '李先生', 'https://img.imgdb.cn/item/604d79a95aedab222cb91a83.jpg', '2020-11-30 16:37:54');

-- ----------------------------
-- Table structure for bases
-- ----------------------------
DROP TABLE IF EXISTS `bases`;
CREATE TABLE `bases`  (
  `base_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `b_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`base_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bases
-- ----------------------------
INSERT INTO `bases` VALUES (1, '成都动物救助中心', 'https://img.imgdb.cn/item/60642fdb8322e6675c614a12.jpg', '四川省成都市', '世界是平等的，请爱护动物，没有爱就没有美好！', 'anni', '123@gmail.com', '12345678881', '2009-03-12 11:35:05');
INSERT INTO `bases` VALUES (2, '郑州动物之家', 'https://img.imgdb.cn/item/604c884d5aedab222c50f024.jpg', '河南省郑州市', '保护动物，人人有责！', '李先生', '321@qq.com', '12345678911', '2020-11-23 16:45:42');
INSERT INTO `bases` VALUES (3, 'Beam的猫咖馆', 'https://img.imgdb.cn/item/604c88935aedab222c5110aa.jpg', '上海市', '别让人类成为孤单的声明！', 'Beam', 'Beamm0613@163.com', '15838365368', '2020-11-03 15:00:33');

-- ----------------------------
-- Table structure for bases_images
-- ----------------------------
DROP TABLE IF EXISTS `bases_images`;
CREATE TABLE `bases_images`  (
  `bi_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NULL DEFAULT NULL,
  `bi_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bi_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`bi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of bases_images
-- ----------------------------
INSERT INTO `bases_images` VALUES (1, 3, 'https://img.imgdb.cn/item/604c899f5aedab222c5189fe.jpg', '2020-11-28 19:17:25');
INSERT INTO `bases_images` VALUES (2, 3, 'https://img.imgdb.cn/item/604c899f5aedab222c518a00.jpg', '2020-11-28 19:17:34');
INSERT INTO `bases_images` VALUES (3, 3, 'https://img.imgdb.cn/item/604c899f5aedab222c518a04.jpg', '2020-11-28 19:17:42');
INSERT INTO `bases_images` VALUES (4, 3, 'https://img.imgdb.cn/item/604c899f5aedab222c518a09.jpg', '2020-11-28 19:18:01');
INSERT INTO `bases_images` VALUES (5, 3, 'https://img.imgdb.cn/item/604c89d15aedab222c51a453.jpg', '2020-11-28 19:18:23');
INSERT INTO `bases_images` VALUES (6, 2, 'https://img.imgdb.cn/item/604c89d15aedab222c51a456.jpg', '2020-11-28 19:18:39');
INSERT INTO `bases_images` VALUES (7, 2, 'https://img.imgdb.cn/item/604c89d15aedab222c51a45a.jpg', '2020-11-28 19:18:51');
INSERT INTO `bases_images` VALUES (8, 2, 'https://img.imgdb.cn/item/604c89d15aedab222c51a461.jpg', '2020-11-28 19:19:28');
INSERT INTO `bases_images` VALUES (9, 2, 'https://img.imgdb.cn/item/604c89fe5aedab222c51b7d4.jpg', '2020-11-28 19:19:42');
INSERT INTO `bases_images` VALUES (10, 2, 'https://img.imgdb.cn/item/604c89fe5aedab222c51b7d6.jpg', '2020-11-28 19:20:03');
INSERT INTO `bases_images` VALUES (11, 1, 'https://img.imgdb.cn/item/604c89fe5aedab222c51b7dd.jpg', '2020-11-28 19:20:21');
INSERT INTO `bases_images` VALUES (12, 1, 'https://img.imgdb.cn/item/604c89fe5aedab222c51b7e0.jpg', '2020-11-28 19:20:35');
INSERT INTO `bases_images` VALUES (13, 1, 'https://img.imgdb.cn/item/604c8a145aedab222c51c034.jpg', '2020-11-28 19:21:04');
INSERT INTO `bases_images` VALUES (14, 1, 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f79cbf8c.jpg', '2020-11-28 19:21:22');
INSERT INTO `bases_images` VALUES (15, 1, 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f7bec170.jpg', '2020-11-28 19:21:34');
INSERT INTO `bases_images` VALUES (16, 4, 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/f0f71252-77ab-4777-a45b-1aa195dcff0c20170824_103410014_iOS.jpg', '2021-03-16 16:46:44');
INSERT INTO `bases_images` VALUES (17, 4, 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/37ec0122-3396-4ac8-8529-214a0c25cc9720170824_103236315_iOS.png', '2021-03-16 16:52:27');
INSERT INTO `bases_images` VALUES (18, 4, 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/a2e5c492-34b4-40fd-9607-a1eb128c3ecf20170824_103155400_iOS.png', '2021-03-16 16:52:44');
INSERT INTO `bases_images` VALUES (19, 4, 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/35c01160-6df8-4ab0-99c7-7631f83dc93720170824_103242089_iOS.png', '2021-03-16 16:53:04');
INSERT INTO `bases_images` VALUES (20, 4, 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/2b984de5-9191-4bd7-a2cf-35bb3aaf485320170824_103148522_iOS.png', '2021-03-16 16:53:12');

-- ----------------------------
-- Table structure for contact
-- ----------------------------
DROP TABLE IF EXISTS `contact`;
CREATE TABLE `contact`  (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NULL DEFAULT NULL,
  `user_id` int(11) NULL DEFAULT NULL,
  `c_words` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `c_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`c_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of contact
-- ----------------------------
INSERT INTO `contact` VALUES (10, 1, 1, '测试留言', '2020-12-13 15:58:59');

-- ----------------------------
-- Table structure for pet_starred
-- ----------------------------
DROP TABLE IF EXISTS `pet_starred`;
CREATE TABLE `pet_starred`  (
  `ps_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `pi_id` int(11) NULL DEFAULT NULL,
  `ps_create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`ps_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pet_starred
-- ----------------------------
INSERT INTO `pet_starred` VALUES (2, 2, 3, '2021-03-10 18:18:34');
INSERT INTO `pet_starred` VALUES (14, 1, 5, '2021-04-13 15:33:51');
INSERT INTO `pet_starred` VALUES (17, 3, 7, '2021-04-13 16:10:58');
INSERT INTO `pet_starred` VALUES (18, 6, NULL, '2021-04-13 21:13:01');
INSERT INTO `pet_starred` VALUES (19, 1, 2, '2021-05-09 18:07:18');
INSERT INTO `pet_starred` VALUES (20, 1, 2, '2021-05-09 21:11:21');
INSERT INTO `pet_starred` VALUES (21, 1, 4, '2021-05-09 21:13:10');
INSERT INTO `pet_starred` VALUES (22, 1, 2, '2021-05-10 10:52:09');
INSERT INTO `pet_starred` VALUES (23, 1, 4, '2021-05-10 10:53:38');

-- ----------------------------
-- Table structure for pets_info
-- ----------------------------
DROP TABLE IF EXISTS `pets_info`;
CREATE TABLE `pets_info`  (
  `pi_id` int(11) NOT NULL AUTO_INCREMENT,
  `pi_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_breed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_DH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '疾病史',
  `pi_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_image_1` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_image_2` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_image_3` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `pi_image_4` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `base_id` int(255) NULL DEFAULT NULL,
  `pi_createtime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`pi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of pets_info
-- ----------------------------
INSERT INTO `pets_info` VALUES (2, '嘟嘟', '三岁', '英短', '无', '你打我时请记得，我拥有可以咬碎你手骨的尖锐牙齿，我只是选择不做这样的事。把我带回家之前，请记得我的寿命约有十到十五年，若你离弃我，会是我最大的痛苦。小狗总是活在当下。它们不会记仇，更不会让仇恨生根发芽。它们每时每刻都在原谅和遗忘。', 'https://p9-tt-ipv6.byteimg.com/origin/pgc-image/40753fa097bc4000bb0010c9bcfbf7f3', 'https://p6-tt-ipv6.byteimg.com/origin/pgc-image/a927385d887d4faa980b0e782e54c8e4', 'https://img.imgdb.cn/item/604d78875aedab222cb88c5d.jpg', 'https://img.imgdb.cn/item/604d78875aedab222cb88c61.jpg', 3, '2021-03-31 16:17:18');
INSERT INTO `pets_info` VALUES (3, '七七', '一岁', '金毛', '2019年曾有情流感，已医治好', '它的尾巴翘的老高.见了熟人就不停的摆动,好像不住的在对你说：你好，你好，你好。', 'https://czapi.superbed.cn/static/images/2021/03/13/604c85725aedab222c4f9152.jpg', 'https://p1-tt-ipv6.byteimg.com/origin/pgc-image/0c80eab6baf94e37b61e522d506c4059', 'https://p1-tt-ipv6.byteimg.com/origin/pgc-image/b246bcba79574a38a90a687bce572b55', 'https://p9-tt-ipv6.byteimg.com/origin/pgc-image/9495637ad1554fefbe3cd2e2c511f609', 3, '2021-03-31 16:18:12');
INSERT INTO `pets_info` VALUES (4, '花菜', '三个月', '英短', '无', '我相信每只猫都有魔法，我始终弄不明白的是我收养了猫，还是猫恩准我了我走进她的生活', 'https://p26-tt.byteimg.com/origin/pgc-image/1589d5da383744b4b0fc91a7b20c83ff', 'https://p6-tt-ipv6.byteimg.com/origin/pgc-image/468415c585284a0092929475bb8e3bc7', 'https://p3-tt-ipv6.byteimg.com/origin/pgc-image/e8e67214859d4a79ae911c252530840b', 'https://p9-tt-ipv6.byteimg.com/origin/pgc-image/4502d1a07bca4921a32fbac4ec81f3e3', 1, '2021-03-31 16:18:13');
INSERT INTO `pets_info` VALUES (5, '小白', '一岁', '阿拉斯加', '无', '狗狗一辈子只有主人，可主人一辈子会有很多朋友', 'https://p1-tt-ipv6.byteimg.com/origin/pgc-image/3103444ff5274034937a6f9023d8e620', 'https://p6-tt-ipv6.byteimg.com/origin/pgc-image/a64f1344765c4a8d902b4c8da4e0bb53', 'https://img.imgdb.cn/item/604c86095aedab222c4fdfcb.jpg', 'https://img.imgdb.cn/item/604c86095aedab222c4fdfcf.jpg', 1, '2021-03-31 16:18:19');
INSERT INTO `pets_info` VALUES (6, '金毛', '五个月', '波斯猫', '无', '它不爱动、不爱玩耍、安静，主要靠它们的大眼睛来交流。它们不会过多地需要人的关注，能在家中独处，胆子比较小。', 'https://img.imgdb.cn/item/604c87485aedab222c507909.jpg', 'https://img.imgdb.cn/item/604c87485aedab222c50790d.jpg', 'https://img.imgdb.cn/item/604c87485aedab222c50790f.jpg', 'https://img.imgdb.cn/item/604c87485aedab222c507915.jpg', 2, '2020-12-30 16:21:57');
INSERT INTO `pets_info` VALUES (7, '哈士奇', '五个月', '哈士奇', '2019年曾有情流感，已医治好', '我永远忘不了今天铲屎的时候我家主子鄙夷的眼神，“我是在给你铲屎，又不是在偷你屎！”', 'https://img.imgdb.cn/item/604c86555aedab222c500a72.jpg', 'https://img.imgdb.cn/item/604c86555aedab222c500a75.jpg', 'https://img.imgdb.cn/item/604c86555aedab222c500a78.jpg', 'https://img.imgdb.cn/item/604c86555aedab222c500a7c.jpg', 2, '2021-03-31 16:19:10');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_sex` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_age` int(11) NULL DEFAULT NULL,
  `user_type` int(2) NOT NULL COMMENT '1是管理员；2是普通用户',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `user_createtime` datetime NULL DEFAULT NULL,
  `user_updatetime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'root', '管理员', '管理员', 'https://img.imgdb.cn/item/6061c2668322e6675cff7bc6.jpg', '63a9f0ea7bb98050796b649e85481845', '男', 22, 2, '15838365360', 'Beamm0613@163.com', 'I love code', 'I AM CEO', '河南省', '郑州市中原区', '2020-11-06 14:03:37', '2021-05-08 19:34:59');
INSERT INTO `user_info` VALUES (2, 'ZhangSan', '张三', '张三', 'https://img.imgdb.cn/item/604c87e25aedab222c50c50a.jpg', '25d55ad283aa400af464c76d713c07ad', '男', 21, 1, '110', 'zhangsan110@gmail.com', 'I love code', 'i love code', '重庆', '羊山区', '2020-11-06 17:26:54', '2020-11-12 17:54:30');
INSERT INTO `user_info` VALUES (3, '1223697311@qq.com', 'weirdo', '美少女', 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/d2f2a574-51a0-4da8-952a-65eddf278c63下载.jpg', 'bae5e3208a3c700e3db642b6631e95b9', '女', 20, 1, '18568275991', '1223697311@qq.com', '我是你爸爸我是你爸爸我是你爸爸我是你爸爸我是你爸爸我是你爸爸', '我是你爸爸我是你爸爸我是你爸爸我是你爸爸我是你爸爸', '福建省', '福州市梅城镇', '2020-11-16 17:52:54', '2021-04-08 20:32:14');
INSERT INTO `user_info` VALUES (4, 'lianghao', 'BeamStark', '梁豪', 'https://img.imgdb.cn/item/6061c2838322e6675cff9fee.jpg', 'ee990c1ccfb7af0cbf4c5ac02c2cd636', '男', 22, 1, '15838365368', 'BeammStark@gmail.com', 'i love code ', 'i am ceo', '河南省', '郑州市中原区', '2021-03-29 20:04:04', '2021-03-29 20:04:06');
INSERT INTO `user_info` VALUES (5, '1916960257@qq.com', '11111', NULL, NULL, '1bbd886460827015e5d605ed44252251', NULL, NULL, 1, NULL, '1916960257@qq.com', NULL, NULL, NULL, NULL, '2021-04-06 20:56:14', '2021-04-06 20:56:14');
INSERT INTO `user_info` VALUES (6, '604520242@qq.com', '洋洋', '杜宇洋', 'https://club-2020.oss-cn-beijing.aliyuncs.com/Beam/e780f3f0-6658-4d82-be67-e30af1ea8a68111.jpg', '25d55ad283aa400af464c76d713c07ad', '女', NULL, 1, '15838310695', '604520242@qq.com', '', '我事洋洋', '河南省', '信阳市新县', '2021-04-13 21:11:22', '2021-04-13 21:35:58');

-- ----------------------------
-- Table structure for volunteer_form
-- ----------------------------
DROP TABLE IF EXISTS `volunteer_form`;
CREATE TABLE `volunteer_form`  (
  `vf_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NULL DEFAULT NULL,
  `base_id` int(11) NULL DEFAULT NULL,
  `vf_age` int(11) NULL DEFAULT NULL,
  `vf_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_join_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_family_agree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_health` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_join_work` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_had_car` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_receive_train` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_had_joined` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_profession` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_real_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vf_create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`vf_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of volunteer_form
-- ----------------------------
INSERT INTO `volunteer_form` VALUES (5, 1, 1, 20, '18568275991', '周六,周日', '是', '否', '救助组,看时间决议', '无', '是', '是', 'IT', '梁豪', NULL);
INSERT INTO `volunteer_form` VALUES (6, 2, 2, 22, '15838365368', '周六，周日', '是', '否', '救援组', '无', '是', '是', 'TT', '张三', NULL);
INSERT INTO `volunteer_form` VALUES (7, 3, 3, 21, '11212412341', '周一', '是', '否', '救援组', '无', '是', '是', '程序员', '美少女', NULL);

-- ----------------------------
-- Table structure for volunteer_info
-- ----------------------------
DROP TABLE IF EXISTS `volunteer_info`;
CREATE TABLE `volunteer_info`  (
  `vi_id` int(11) NOT NULL AUTO_INCREMENT,
  `base_id` int(11) NULL DEFAULT NULL,
  `vi_status` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vi_requirement` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vi_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vi_joinPopulation` int(11) NULL DEFAULT NULL,
  `vi_population` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `vi_start_time` datetime NULL DEFAULT NULL,
  `vi_end_time` datetime NULL DEFAULT NULL,
  `vi_create_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`vi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of volunteer_info
-- ----------------------------
INSERT INTO `volunteer_info` VALUES (1, 3, '已截止', '具备诚实守信和精诚团结精神', '测试测试测试测试1', 59, '60', '2020-08-19 18:28:08', '2020-11-20 18:28:02', '2020-12-05 18:28:12');
INSERT INTO `volunteer_info` VALUES (2, 2, '未开始', '具备诚实守信和精诚团结精神', '测试测试测试测试2', 12, '50', '2021-08-01 16:00:27', '2022-09-01 16:00:22', '2020-12-09 16:00:32');
INSERT INTO `volunteer_info` VALUES (3, 1, '可报名', '具备诚实守信和精诚团结精神', '测试测试测试测试3', 10, '40', '2021-04-01 08:00:00', '2021-06-01 08:00:00', '2020-12-09 16:02:18');

SET FOREIGN_KEY_CHECKS = 1;
