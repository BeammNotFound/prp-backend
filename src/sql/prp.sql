/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : localhost:3306
 Source Schema         : prp

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 28/11/2020 19:38:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for adoption_pets
-- ----------------------------
DROP TABLE IF EXISTS `adoption_pets`;
CREATE TABLE `adoption_pets`  (
  `ap_id` int(11) NOT NULL AUTO_INCREMENT,
  `ap_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ap_age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ap_breed` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ap_DH` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '疾病史',
  `ap_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ap_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ap_base` int(255) DEFAULT NULL,
  `ap_createtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`ap_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of adoption_pets
-- ----------------------------
INSERT INTO `adoption_pets` VALUES (1, '花花', '三个月', '野猫', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'https://img9.51tietu.net/pic/2019-091021/4ps1awasijj4ps1awasijj.jpg', 3, '2020-11-28 19:04:57');
INSERT INTO `adoption_pets` VALUES (2, '嘟嘟', '三岁', '英短', '无', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f7ce7316.jpg', 3, '2020-11-28 19:28:36');
INSERT INTO `adoption_pets` VALUES (3, '七七', '一岁', '豹纹', '2019年曾有情流感，已医治好', '活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱活泼可爱', 'http://pic1.win4000.com/wallpaper/2020-11-03/5fa10f7f08cc4.jpg', 3, '2020-11-28 19:32:32');

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
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of background_images
-- ----------------------------
INSERT INTO `background_images` VALUES (1, NULL, 'http://pic.netbian.com/uploads/allimg/170630/140735-14988028550a5d.jpg', '2020-11-28 16:51:37');
INSERT INTO `background_images` VALUES (2, NULL, 'http://pic.netbian.com/uploads/allimg/170704/213426-149917526630c4.jpg', '2020-11-28 16:51:51');
INSERT INTO `background_images` VALUES (3, NULL, 'http://pic.netbian.com/uploads/allimg/170714/224444-1500043484b8fa.jpg', '2020-11-28 16:52:03');

-- ----------------------------
-- Table structure for bases
-- ----------------------------
DROP TABLE IF EXISTS `bases`;
CREATE TABLE `bases`  (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `b_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_status` int(255) DEFAULT NULL,
  `b_joinPopulation` int(255) DEFAULT NULL,
  `b_contacts` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `b_population` int(255) DEFAULT NULL,
  `b_createtime` datetime(0) DEFAULT NULL,
  `b_endtime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`b_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of bases
-- ----------------------------
INSERT INTO `bases` VALUES (1, '成都爱之家动物救助中心', 'https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1606570482996&di=e200e2c34d328fc979318406bbd14132&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F2017-12-01%2F5a20f8c0a36e4.jpg', '四川省成都市', '【爱之家简介】流浪动物的生态救助中心及爱心教育基地！救助流浪动物22年！于2009年在民政局正式注册成立。', 1, 14, '张先生', '123@gmail.com', '12345678911', 50, '2009-03-12 11:35:05', '2020-12-18 15:00:17');
INSERT INTO `bases` VALUES (2, '郑州动物之家', 'd5069c12d0cfc522c389d6a7c14ad1b1_720w.jpg', '上海市', 'Tesla 全轮驱动车型搭载两台独立电机以提升冗余度，每台电机只有一个活动部件，耐用性高且易于维护。与传统的全轮驱动系统不同，两台电机可精准地分配前后轮扭矩，操控性和牵引力控制更为出色。', 1, 11, '李先生', '321@qq.com', '12345678911', 40, '2020-11-23 16:45:42', '2020-11-27 15:00:28');
INSERT INTO `bases` VALUES (3, 'Beam的猫咖馆', '07a20fc6c0d9a441a50526861f0e0c6b_720w.jpg', '美国', '探索Apple 充满创新的世界,选购各式 iPhone、iPad、Apple Watch 和 Mac,浏览各种配件、娱乐产品,并获得相关产品的专家支持服务。', 1, 12, '梁豪', 'Beamm0613@163.com', '15838365368', 50, '2020-11-03 15:00:33', '2021-04-23 15:00:38');

-- ----------------------------
-- Table structure for bases_images
-- ----------------------------
DROP TABLE IF EXISTS `bases_images`;
CREATE TABLE `bases_images`  (
  `bi_id` int(11) NOT NULL AUTO_INCREMENT,
  `bi_base` int(255) DEFAULT NULL,
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
INSERT INTO `messages` VALUES (5, '津城警事｜“爱鸟护飞”、保护野生动物，江津公安在行动', '11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现场宣传，提高全民保护野生动物的意识。', '来源: 潇湘晨报', 'https://pics0.baidu.com/feed/5ab5c9ea15ce36d36d500202669fab80e950b124.jpeg?token=e897b61d06178aafbe0428cb899dc909', 1, '2020-11-11 15:46:30', '2020-11-11 15:46:30');
INSERT INTO `messages` VALUES (7, 'OWOH x 浦江王阿姨流浪动物公益项目温暖魔都', '随着天气逐渐变冷，流浪动物的吃饱穿暖问题也引起了众多爱宠人士的关注。没有固定的家，没有主人的宠爱，没有足够的食粮，没有御寒的住所，继而引发无数的流浪猫狗很难挺过寒冬的死亡现象。作为国内知名的宠物 APP-OWOH，于 12 月 21 日 -22 日在新天地湖滨路活力街区举办了 ‘ 给毛孩点一份外卖 ’ 的爱心救助公益活动，帮助流浪动物过冬、解决领养问题，此次活动也吸引了上海各个地区数万位爱宠人士到现场捐出自己的一份爱心，把有意向的流浪动物领养回家。', '来源: MY宠物', 'https://www.mychongwu.com/uploads/images/2019/1226/1577328917240074.jpg', 1, '2020-11-24 09:34:31', '2020-11-24 09:34:31');

-- ----------------------------
-- Table structure for popularizations
-- ----------------------------
DROP TABLE IF EXISTS `popularizations`;
CREATE TABLE `popularizations`  (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_details` varchar(10000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `p_pv` int(255) DEFAULT NULL COMMENT '访问量',
  `p_type` int(255) DEFAULT NULL COMMENT '科普类型：\r\n1 品种科普\r\n2 动物常患疾病\r\n3 动物冷知识',
  `p_createtime` datetime(0) DEFAULT NULL,
  `p_updatetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`p_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of popularizations
-- ----------------------------
INSERT INTO `popularizations` VALUES (1, '宠物猫狗吃巧克力会中毒？', '一小块巧克力中含有的可可碱，猫和狗也需要很长的时间才能分解完。过量的可可碱，会导致狗、猫产生消化异常、兴奋、脱水、心率缓慢等问题，有时会致命。\r\n\r\n论证人类美食，宠物毒药\r\n\r\n巧克力是最让人愉悦的食物之一，不过，对狗和猫来说，它却是和除草剂、防冻液、耗子药齐名的致命剧毒。巧克力中含有可可碱，它是巧克力带给人快感的源泉，同咖啡因和茶碱一样，可可碱也是植物用来防备动物取食的毒剂。人可以很快地通过肝脏和肾脏将可可碱处理并排出体外，而猫狗排出可可碱就慢得多，吃多了会中毒而死。这方面猫比狗要走运，因为猫对甜味不敏感，巧克力和水果对猫来说味同嚼蜡，而大多数狗则喜爱甜食（这也与从小的饮食习惯有关）。\r\n\r\n根据著名的兽医手册Merck Veterinary Manual中的剂量说明，29g的牛奶巧克力（约1.5块最小号的德芙牛奶巧克力）会让一只3公斤的小型犬（博美、吉娃娃等）产生呕吐、痢疾、剧渴等症状，而80g牛奶巧克力（4块最小号的德芙牛奶巧克力）就可能让3公斤的小型犬类有死亡危险了。这方面猫比狗要走运，因为猫对甜味不敏感，巧克力和水果对猫来说味同嚼蜡，而大多数狗则喜爱甜食（这也与从小的饮食习惯有关）。\r\n\r\n水果也可能带来问题\r\n\r\n水果对人类好处多多，对猫和狗也不啻于毒药。比如葡萄和葡萄干，狗吃了有可能引起肾衰竭并可致命，虽然视狗的品种和体质不同，有的狗吃点葡萄看起来也没什么反应，但为了狗的健康，别给它们吃这些东西。而其他水果也有可能引起狗的呕吐和腹泻。', '风迷路了', 'https://pic2.zhimg.com/80/v2-951048e9a61563f797c25484d170807d_720w.jpg', 1, 2, '2020-11-10 19:09:45', '2020-11-10 19:09:47');
INSERT INTO `popularizations` VALUES (4, '根据宠物猫狗的体型，要打不同剂量的疫苗？', '无论宠物体型，免疫还是需要注射整个剂量以保证疫苗的保护性，但是对于体重小和玩具型品种的狗狗需要给予更多的关注。不能因为绝育增加了点点疫苗不良反应的风险就不做绝育，尽可能每次只进行一种疫苗的免疫。', '一支草', 'https://pic4.zhimg.com/80/v2-4981e6e4109428dd16009c7e631060a3_720w.jpg', 1, 1, '2020-11-11 15:58:24', '2020-11-11 15:58:24');
INSERT INTO `popularizations` VALUES (5, '仓鼠怎么养?', '导语：可爱的毛茸茸的动物是世界上最受欢迎的动物之一，就比如说小小的仓鼠，一看就能让人爱上它。那么你们知道仓鼠怎么养吗?之前小编为大家讲解过十大对人类友好的动物，今天呢就为大家揭秘养仓鼠所需要知道的12件事情，感兴趣的不妨一起往下看!', '软萌颜 ', 'http://www.tanmizhi.com/img/allimg/12/15-1Q21Q10J2.png', 1, 3, '2020-11-11 16:03:43', '2020-11-11 16:03:43');
INSERT INTO `popularizations` VALUES (7, '猫咪偷窥你上厕所并不是色，而是一种“幼猫行为”', '每次上厕所，总能感觉到有一双眼睛在暗处盯着我，好几次都觉得背后发凉！甚至想去某大仙处领几张符挂在厕所。直到我意外地看到了厕所门外，一动不动盯着我的猫......猫咪难道有偷窥欲？  一开始只是一动不动，后来胆子就慢慢大了，开始推门和挠门了。然而我家厕所门还是坏的，轻轻一推里面就暴露无遗。于是最后就演变成了我在蹲坑的这头看猫，猫在蹲坑的那头外头看我，相顾无言唯有一行。', 'HolisticBlend活力枫叶 ', 'https://pic2.zhimg.com/v2-25ccc07e956f6541d61e665baf5b7df5_b.jpg', 1, 3, '2020-11-24 09:44:02', '2020-11-24 09:44:02');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_type` int(2) NOT NULL COMMENT '1是管理员；2是普通用户',
  `user_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_info` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_application` int(3) DEFAULT NULL,
  `user_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_createtime` datetime(0) DEFAULT NULL,
  `user_updatetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`user_id`, `user_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'root', 'Beam', '梁豪', '123123', 2, '1583836536', 'https://pic4.zhimg.com/80/v2-557a700c26facb72f4ed088041e23c17_720w.jpg', 'I love code', '河南', 'Beamm0613@163.com', '郑州', 3, 'I AM CEO', '2020-11-06 14:03:37', '2020-11-11 21:42:00');
INSERT INTO `user_info` VALUES (16, 'ZhangSan', '张三', '张三', 'e10adc3949ba59abbe56e057f20f883e', 1, '110', 'https://pic1.zhimg.com/80/v2-cc3a5cdd40e9dab5c5ea3e934d4a31e0_720w.jpg', 'I love code', '重庆', 'zhangsan110@gmail.com', '羊山区', NULL, 'i love code', '2020-11-06 17:26:54', '2020-11-12 17:54:30');
INSERT INTO `user_info` VALUES (17, '1223697311@qq.com', 'weirdo', NULL, '1bbd886460827015e5d605ed44252251', 1, NULL, 'https://pic3.zhimg.com/80/v2-ef8d69f363056224d695ac495f9e6b62_720w.jpg', 'I love code', NULL, '1223697311@qq.com', NULL, NULL, NULL, '2020-11-16 17:52:54', '2020-11-16 17:52:54');

SET FOREIGN_KEY_CHECKS = 1;
