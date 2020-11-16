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

 Date: 16/11/2020 13:10:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of messages
-- ----------------------------
INSERT INTO `messages` VALUES (1, '最近大火的马保国是什么梗？', '建议全文背诵：朋友们好啊，我是混元形意太极门掌门人马宝国，刚才有个朋友问我马老师发生什么事了，我说怎么回事？给我发了一个张截图，我一看！噢，原来是昨天有两个年轻人，30多岁，一个体重90多公斤，一个体重80多公斤。塔们说，有一个说我在健身房练功，颈椎练坏了，马老师你能不能教教我混元功法？帮助治疗一下我的颈椎病。\n\n作者：子王非王\n链接：https://www.zhihu.com/question/428910415/answer/1565663074\n来源：知乎\n著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。', 'Beam', 'https://pic2.zhimg.com/80/v2-0fcc705de7514337f5836644c8158e52_720w.jpg?source=1940ef5c', 1, '2020-11-09 14:22:15', '2020-11-09 14:22:23');
INSERT INTO `messages` VALUES (4, 'Toptrees领先 ×美院动物保护协会：这个冬天，给TA一个家', '“给TA一个家”——宠物食品品牌Toptrees领先和美院动物保护协会（下简称“动保协会”）共同发起的流浪猫狗小屋正式安置，在冬日来临之际，让美院校园里的流浪动物们多了能遮风避雨的地方。此外，Toptrees领先还为美院动保协会捐赠了爱心猫犬粮及零食，首批总重约100kg。', '来源: 大众新闻', 'https://nimg.ws.126.net/?url=http%3A%2F%2Fcrawl.ws.126.net%2F79418b74e3aeb359f08d3fa1f505c98b.png&thumbnail=660x2147483647&quality=80&type=jpg', 1, '2020-11-11 15:45:28', '2020-11-11 15:45:28');
INSERT INTO `messages` VALUES (5, '津城警事｜“爱鸟护飞”、保护野生动物，江津公安在行动', '11月10日，重庆市2020年“爱鸟护飞”专项行动暨江津区野生动物保护宣传月启动发布会在几江长江大桥桥头开展，江津区公安局联合辖区派出所积极参与现场宣传，提高全民保护野生动物的意识。', '来源: 潇湘晨报', 'https://pics0.baidu.com/feed/5ab5c9ea15ce36d36d500202669fab80e950b124.jpeg?token=e897b61d06178aafbe0428cb899dc909', 1, '2020-11-11 15:46:30', '2020-11-11 15:46:30');

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
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of popularizations
-- ----------------------------
INSERT INTO `popularizations` VALUES (1, '宠物猫狗吃巧克力会中毒？', '一小块巧克力中含有的可可碱，猫和狗也需要很长的时间才能分解完。过量的可可碱，会导致狗、猫产生消化异常、兴奋、脱水、心率缓慢等问题，有时会致命。\r\n\r\n论证人类美食，宠物毒药\r\n\r\n巧克力是最让人愉悦的食物之一，不过，对狗和猫来说，它却是和除草剂、防冻液、耗子药齐名的致命剧毒。巧克力中含有可可碱，它是巧克力带给人快感的源泉，同咖啡因和茶碱一样，可可碱也是植物用来防备动物取食的毒剂。人可以很快地通过肝脏和肾脏将可可碱处理并排出体外，而猫狗排出可可碱就慢得多，吃多了会中毒而死。这方面猫比狗要走运，因为猫对甜味不敏感，巧克力和水果对猫来说味同嚼蜡，而大多数狗则喜爱甜食（这也与从小的饮食习惯有关）。\r\n\r\n根据著名的兽医手册Merck Veterinary Manual中的剂量说明，29g的牛奶巧克力（约1.5块最小号的德芙牛奶巧克力）会让一只3公斤的小型犬（博美、吉娃娃等）产生呕吐、痢疾、剧渴等症状，而80g牛奶巧克力（4块最小号的德芙牛奶巧克力）就可能让3公斤的小型犬类有死亡危险了。这方面猫比狗要走运，因为猫对甜味不敏感，巧克力和水果对猫来说味同嚼蜡，而大多数狗则喜爱甜食（这也与从小的饮食习惯有关）。\r\n\r\n水果也可能带来问题\r\n\r\n水果对人类好处多多，对猫和狗也不啻于毒药。比如葡萄和葡萄干，狗吃了有可能引起肾衰竭并可致命，虽然视狗的品种和体质不同，有的狗吃点葡萄看起来也没什么反应，但为了狗的健康，别给它们吃这些东西。而其他水果也有可能引起狗的呕吐和腹泻。', '风迷路了', NULL, 1, 3, '2020-11-10 19:09:45', '2020-11-10 19:09:47');
INSERT INTO `popularizations` VALUES (4, '根据宠物猫狗的体型，要打不同剂量的疫苗？', '无论宠物体型，免疫还是需要注射整个剂量以保证疫苗的保护性，但是对于体重小和玩具型品种的狗狗需要给予更多的关注。不能因为绝育增加了点点疫苗不良反应的风险就不做绝育，尽可能每次只进行一种疫苗的免疫。', '一支草', NULL, 1, 3, '2020-11-11 15:58:24', '2020-11-11 15:58:24');
INSERT INTO `popularizations` VALUES (5, '仓鼠怎么养?', '导语：可爱的毛茸茸的动物是世界上最受欢迎的动物之一，就比如说小小的仓鼠，一看就能让人爱上它。那么你们知道仓鼠怎么养吗?之前小编为大家讲解过十大对人类友好的动物，今天呢就为大家揭秘养仓鼠所需要知道的12件事情，感兴趣的不妨一起往下看!', '软萌颜 ', 'http://www.tanmizhi.com/img/allimg/12/15-1Q21Q10J2.png', 1, 3, '2020-11-11 16:03:43', '2020-11-11 16:03:43');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `user_id` int(255) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
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
  `user_intro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_createtime` datetime(0) DEFAULT NULL,
  `user_updatetime` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'root', 'Beam', '梁豪', '63a9f0ea7bb98050796b649e85481845', 2, '1583836536', '', NULL, '河南', 'BeammStark@gmail.com', '郑州', 'I AM CEO', '2020-11-06 14:03:37', '2020-11-11 21:42:00');
INSERT INTO `user_info` VALUES (16, 'ZhangSan', '张三', '张三', 'e10adc3949ba59abbe56e057f20f883e', 1, '110', NULL, NULL, '重庆', 'zhangsan110@gmail.com', '羊山区', 'i love code', '2020-11-06 17:26:54', '2020-11-12 17:54:30');

SET FOREIGN_KEY_CHECKS = 1;
