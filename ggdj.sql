/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : ggdj

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-07-01 11:21:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(2) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `goodsName` varchar(20) NOT NULL DEFAULT '' COMMENT '商品名',
  `typeId` int(11) NOT NULL DEFAULT '0' COMMENT '商品类型号',
  `goodsDescription` text NOT NULL COMMENT '商品描述',
  `supplierId` int(2) DEFAULT '0' COMMENT '供应商号，外键',
  `goodsPrice` double NOT NULL DEFAULT '0' COMMENT '商品价格',
  `img` varchar(100) DEFAULT NULL COMMENT '图片路径',
  PRIMARY KEY (`goodsId`),
  UNIQUE KEY `goodsName` (`goodsName`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='商品信息表';

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('6', '猕猴桃子', '3', '产地：陕西\r\n功效：猕猴桃中含有的血清促进素具有稳定情绪、镇静心情的作用，另外它所含的天然肌醇，有助于脑部活动，因此能帮助忧郁之人走出情绪低谷。猕猴桃中有良好的膳食纤维，它不仅能降低胆固醇，促进心脏健康，而且可以帮助消化，防止便秘，快速清除并预防体内堆积的有害代谢物。祖国医学认为，猕猴桃甘酸性寒，能够解热除烦，止渴利尿。\r\n适合人群：其味酸甜可口，一般人都可以食用。情绪低落、常吃烧烤的人应食用猕猴桃。经常便秘者适合吃猕猴桃。明目。', '1', '23', 'images/img7.jpg');
INSERT INTO `goods` VALUES ('13', '香蕉', '3', '产地：东南亚地区\r\n　　功效：它含有一种特殊的氨基酸，这种氨基酸能帮助人体制造“开心激素”，减轻心理压力，解除忧郁，令人快乐开心。睡前吃香蕉，还有镇静的作用。香蕉几乎含有所有的维生素和矿物质，食物纤维含量丰富，而热量却很低。因此，香蕉就成了减肥的最佳食品，是女士们的最爱水果。香蕉还有润肠通便、润肺止咳、清热解毒、助消化和滋补的作用。常吃香蕉还能楗脑。\r\n　　适合人群：老少皆宜，减肥者首选。', '1', '10', 'images/img5.jpg');
INSERT INTO `goods` VALUES ('17', '龙眼', '1', '功效：龙眼含有多种营养物质，有补血安神、健脑益智、补养心脾的功效，是健脾长智的传统食物，对失眠、心悸、神经衰弱、记忆力减退、贫血有益。\r\n    适合人群：体弱、妇女最适宜食用', '1', '14', 'images/img8.jpg');
INSERT INTO `goods` VALUES ('18', '樱桃', '2', '产地：美国、智利、新西兰\r\n 功效：樱桃的含铁量特别高，位于各种水果之首。樱桃营养丰富，具有调中益气，健脾和胃、祛风湿，“令人好颜色，美志性”之功效，对食欲不振、消化不良、风湿身痛等均有益处。经常食有樱桃能养颜驻容，使皮肤红润嫩白，去皱消斑。\r\n    适合人群：适合一般人食用。', '3', '25', 'images/img1.jpg');
INSERT INTO `goods` VALUES ('19', '荔枝', '1', '产地：广东、广西、福建、四川\r\n    功效：常食荔枝能补脑健身，开胃益脾，有促进食欲之功效。荔枝拥有丰富的维生素，可促进微细血管的血液循环，防止雀斑的发生，令皮肤更加光滑。    \r\n适合人群：除有上火症状的人外均可食用。尤其适合产妇、老人、体质虚弱者、病后调养者食用。', '1', '18', 'images/img25.jpg');
INSERT INTO `goods` VALUES ('20', '西瓜', '1', '产地：广西，海南，湖北\r\n    功效：西瓜可清热解暑，除烦止渴。西瓜中含有大量的水分，在急性热病发烧、口渴汗多、烦躁时，吃上一块又甜又沙、水分十足的西瓜，症状会马上改善。\r\n在治疗肾炎和降低血压方面，西瓜可算是果菜之中的好医生。它所含的的糖和盐能利尿并消除肾脏炎症；蛋白酶能把不溶性蛋白质转化为可溶的蛋白质，增加肾炎病人的营养；它还含有能使血压降低的物质。', '8', '5', 'images/img3.jpg');
INSERT INTO `goods` VALUES ('21', '葡萄', '1', '产地：新疆，乌鲁木齐\r\n　　功效：葡萄中的糖易被人体吸收。葡萄中的糖主要是葡萄糖，能很快被人体吸收。葡萄是消化能力较弱者的理想果品。葡萄中含有一种有益的抗癌物质，可以防止健康细胞癌变，并能防止癌细胞扩散。而且葡萄汁可以帮助器官移植手术患者减少排异反应，促进早日康复。', '54', '8', 'images/img13.png');
INSERT INTO `goods` VALUES ('22', '山竹', '1', '产地：马来西亚、泰国、菲律宾\r\n    功效：山竹含有一种特殊物质，具有降燥、清凉解热的作用，这使山竹能克榴莲之燥热。它含有丰富的蛋白质和脂类，对机体有很好的补养作用，对体弱、营养不良、病后都有很好的调养作用。\r\n适合人群：一般人都可食用。体弱，病后的人更适合。', '67', '13', 'images/img10.jpg');
INSERT INTO `goods` VALUES ('23', '橘子', '1', '大叔大婶多', '2', '3', 'images/img14.png');
INSERT INTO `goods` VALUES ('24', '苹果', '2', '功效：苹果是心血管的保护神、心脏病患者的健康水果，因为它不含饱和脂肪、胆固醇和钠。苹果中的胶质能保持血糖的稳定，所以苹果不但是糖尿病患者的健康小吃，而且是一切想要控制血糖水平的人必不可少的水果。祖国医学认为，苹果甘凉，具有生津止渴、润肺除烦、健脾益胃、养心益气、润肠、止泻、解暑、醒酒等功效。苹果有着天然的怡人香气，具有明显的消除压抑感作用。', '2', '12', 'images/img4.jpg');
INSERT INTO `goods` VALUES ('25', '榴莲', '1', '功效：榴莲含有丰富的蛋白质和脂类，对机体有很好的补养作用，是良好的果品类营养来源。榴莲有特殊的气味，不同的人感受不同，有的人认为其臭如猫屎，有的人认为香气馥郁。榴莲的这种气味有开胃，促进食欲的功效，其中的膳食纤维还能促进肠蠕动。\r\n    适合人群：一般健康人都可食用。病后及妇女产后可用之来补养身体。', '1', '23', 'images/img12.jpg');
INSERT INTO `goods` VALUES ('26', '草莓', '1', '功效：草莓的营养成分容易被人体消化、吸收，多吃也不会受凉或上火，是老少皆宜的健康食品。草莓中所含的胡萝卜素是合成维生素A的重要物质，具有明日养肝作用。据研究，女性常吃草莓，对皮肤、头发均有保健作用。草莓在德国被誉为“神奇之果”。草莓还可以减肥，因为它含有一种叫天冬氨酸的物质，可以自然而平缓地除去体内的“矿渣”。', '1', '13', 'images/img22.jpg');
INSERT INTO `goods` VALUES ('27', '芒果', '1', '功效主治：益胃止呕，解渴利尿。主治口渴咽干，食欲不振，消化不良，晕眩呕吐，咽痛音哑，咳嗽痰多，气喘等病症。常食芒果可以不断补充体内维生素C的消耗，降低胆固醇、甘油三酯，有利于防治心血管疾病。芒果的糖类及维生素含量非常丰富，尤其维生素A原含量占水果之首位，具有明目的作用。\r\n  适合人群：一般人都可食用', '1', '10', 'images/img2.png');
INSERT INTO `goods` VALUES ('28', '雪梨', '2', '功效：梨性味甘寒，具有清心润肺的作用，对肺结核、气管炎和上呼吸道感染的患者所出现的咽干、痒痛、音哑、痰稠等症皆有益。具有降低血压、养阴清热的功效。梨可清喉降火，播音、演唱人员经常食用煮好的熟梨，能增加口中的津液，起到保养嗓子的作用。 \r\n    适合人群：一般人都可食用。尤其是嗓子需要保护的人。降血压', '1', '8', 'images/circle1.png');
INSERT INTO `goods` VALUES ('29', '火龙果 ', '1', '功效：火龙果中的白蛋白是具黏性、胶质性的物质，对重金属中毒有解毒的功效。它对胃壁还有保护作用。火龙果含有维生素E和一种更为特殊的成分——花青素。花青素在葡萄皮、红甜菜等果蔬中都含有，但以火龙果果实中的花青素含量最高。\r\n　　适合人群：胃病患者。', '1', '9', 'images/img15.png');

-- ----------------------------
-- Table structure for oder
-- ----------------------------
DROP TABLE IF EXISTS `oder`;
CREATE TABLE `oder` (
  `orderId` varchar(20) NOT NULL,
  `userId` int(255) NOT NULL,
  `userAddress` varchar(255) NOT NULL,
  `price` double(25,2) NOT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of oder
-- ----------------------------
INSERT INTO `oder` VALUES ('20170530_012945', '10', 'GuangDong', '14.00', null, '2017-05-30 01:29:45');
INSERT INTO `oder` VALUES ('20170530_012959', '10', 'GuangDong', '16.00', null, '2017-05-30 01:29:59');
INSERT INTO `oder` VALUES ('20170530_145905', '10', 'GuangDong', '101.00', null, '2017-05-30 14:59:05');
INSERT INTO `oder` VALUES ('20170530_145940', '10', 'GuangDong', '22.00', null, '2017-05-30 14:59:40');
INSERT INTO `oder` VALUES ('20170530_150004', '10', 'GuangDong', '13.00', null, '2017-05-30 15:00:04');
INSERT INTO `oder` VALUES ('20170608_093505', '23', '广西来宾', '42.00', null, '2017-06-08 09:35:05');
INSERT INTO `oder` VALUES ('20170608_094017', '23', '广西来宾', '56.00', null, '2017-06-08 09:40:17');
INSERT INTO `oder` VALUES ('20170608_095135', '23', '广西来宾', '8.00', null, '2017-06-08 09:51:35');
INSERT INTO `oder` VALUES ('20170608_104824', '23', '广西来宾', '14.00', null, '2017-06-08 10:48:24');
INSERT INTO `oder` VALUES ('20170608_112336', '23', '广西来宾', '86.00', null, '2017-06-08 11:23:36');
INSERT INTO `oder` VALUES ('20170613', '10', '测试地址', '30.00', null, '2017-06-14 08:51:48');
INSERT INTO `oder` VALUES ('20170614', '10', '测试地址', '30.00', null, '2017-06-14 08:56:28');
INSERT INTO `oder` VALUES ('20170629_224325', '23', '广西南宁西乡塘区广西大学', '32.00', null, '2017-06-29 22:43:25');
INSERT INTO `oder` VALUES ('20170629_224631', '23', '广西南宁西乡塘区广西大', '20.00', null, '2017-06-29 22:46:31');
INSERT INTO `oder` VALUES ('20170630_221434', '23', '广西南宁西乡塘区广西大', '90.00', null, '2017-06-30 22:14:34');

-- ----------------------------
-- Table structure for oquantity
-- ----------------------------
DROP TABLE IF EXISTS `oquantity`;
CREATE TABLE `oquantity` (
  `oQuantityId` int(11) NOT NULL AUTO_INCREMENT COMMENT '数量编号',
  `goodsId` int(10) NOT NULL DEFAULT '0' COMMENT '商品号',
  `quantity` int(10) NOT NULL DEFAULT '0' COMMENT '数量',
  `orderId` varchar(20) NOT NULL DEFAULT '0' COMMENT '订单编号',
  PRIMARY KEY (`oQuantityId`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8 COMMENT='订单商品数量表';

-- ----------------------------
-- Records of oquantity
-- ----------------------------
INSERT INTO `oquantity` VALUES ('22', '1', '1', '20170512_150725');
INSERT INTO `oquantity` VALUES ('23', '3', '1', '20170512_150725');
INSERT INTO `oquantity` VALUES ('24', '1', '1', '20170512_151022');
INSERT INTO `oquantity` VALUES ('25', '1', '1', '20170512_205953');
INSERT INTO `oquantity` VALUES ('26', '1', '1', '20170513_163941');
INSERT INTO `oquantity` VALUES ('27', '6', '1', '20170513_172019');
INSERT INTO `oquantity` VALUES ('28', '3', '1', '20170513_172019');
INSERT INTO `oquantity` VALUES ('29', '5', '1', '20170513_173938');
INSERT INTO `oquantity` VALUES ('30', '5', '1', '20170513_174141');
INSERT INTO `oquantity` VALUES ('31', '1', '3', '20170513_202825');
INSERT INTO `oquantity` VALUES ('32', '1', '2', '20170513_232029');
INSERT INTO `oquantity` VALUES ('33', '3', '2', '20170513_232029');
INSERT INTO `oquantity` VALUES ('34', '3', '2', '20170526_014653');
INSERT INTO `oquantity` VALUES ('35', '3', '1', '20170530_001608');
INSERT INTO `oquantity` VALUES ('36', '17', '1', '20170530_005717');
INSERT INTO `oquantity` VALUES ('37', '3', '1', '20170530_005717');
INSERT INTO `oquantity` VALUES ('38', '6', '1', '20170530_005726');
INSERT INTO `oquantity` VALUES ('39', '6', '1', '20170530_010120');
INSERT INTO `oquantity` VALUES ('40', '6', '1', '20170530_010130');
INSERT INTO `oquantity` VALUES ('41', '17', '1', '20170530_010141');
INSERT INTO `oquantity` VALUES ('42', '3', '1', '20170530_010141');
INSERT INTO `oquantity` VALUES ('43', '13', '1', '20170530_010749');
INSERT INTO `oquantity` VALUES ('44', '6', '1', '20170530_010754');
INSERT INTO `oquantity` VALUES ('45', '6', '2', '20170530_012858');
INSERT INTO `oquantity` VALUES ('46', '13', '2', '20170530_012858');
INSERT INTO `oquantity` VALUES ('47', '17', '1', '20170530_012945');
INSERT INTO `oquantity` VALUES ('48', '3', '1', '20170530_012959');
INSERT INTO `oquantity` VALUES ('49', '6', '2', '20170530_145905');
INSERT INTO `oquantity` VALUES ('50', '18', '2', '20170530_145905');
INSERT INTO `oquantity` VALUES ('51', '20', '1', '20170530_145905');
INSERT INTO `oquantity` VALUES ('52', '17', '1', '20170530_145940');
INSERT INTO `oquantity` VALUES ('53', '21', '1', '20170530_145940');
INSERT INTO `oquantity` VALUES ('54', '22', '1', '20170530_150004');
INSERT INTO `oquantity` VALUES ('55', '6', '1', '20170607_111309');
INSERT INTO `oquantity` VALUES ('56', '6', '3', '20170607_195855');
INSERT INTO `oquantity` VALUES ('57', '3', '1', '20170608_001014');
INSERT INTO `oquantity` VALUES ('58', '17', '1', '20170608_085621');
INSERT INTO `oquantity` VALUES ('59', '17', '3', '20170608_093505');
INSERT INTO `oquantity` VALUES ('60', '17', '4', '20170608_094017');
INSERT INTO `oquantity` VALUES ('61', '21', '1', '20170608_095135');
INSERT INTO `oquantity` VALUES ('62', '17', '1', '20170608_104824');
INSERT INTO `oquantity` VALUES ('63', '22', '1', '20170608_112336');
INSERT INTO `oquantity` VALUES ('64', '18', '1', '20170608_112336');
INSERT INTO `oquantity` VALUES ('65', '3', '3', '20170608_112336');
INSERT INTO `oquantity` VALUES ('66', '13', '1', '20170609_150907');
INSERT INTO `oquantity` VALUES ('67', '17', '1', '20170609_150907');
INSERT INTO `oquantity` VALUES ('68', '20', '1', '20170609_150907');
INSERT INTO `oquantity` VALUES ('69', '13', '3', '20170613');
INSERT INTO `oquantity` VALUES ('70', '13', '3', '20170613');
INSERT INTO `oquantity` VALUES ('71', '18', '3', '20170616_111612');
INSERT INTO `oquantity` VALUES ('72', '19', '2', '20170618_121806');
INSERT INTO `oquantity` VALUES ('73', '18', '2', '20170618_121806');
INSERT INTO `oquantity` VALUES ('74', '17', '2', '20170618_121806');
INSERT INTO `oquantity` VALUES ('75', '18', '4', '20170618_122650');
INSERT INTO `oquantity` VALUES ('76', '17', '1', '20170618_122650');
INSERT INTO `oquantity` VALUES ('77', '13', '1', '20170629_224325');
INSERT INTO `oquantity` VALUES ('78', '24', '1', '20170629_224325');
INSERT INTO `oquantity` VALUES ('79', '20', '2', '20170629_224325');
INSERT INTO `oquantity` VALUES ('80', '27', '2', '20170629_224631');
INSERT INTO `oquantity` VALUES ('81', '13', '1', '20170630_083406');
INSERT INTO `oquantity` VALUES ('82', '24', '1', '20170630_083406');
INSERT INTO `oquantity` VALUES ('83', '20', '1', '20170630_083406');
INSERT INTO `oquantity` VALUES ('84', '19', '5', '20170630_221434');

-- ----------------------------
-- Table structure for people
-- ----------------------------
DROP TABLE IF EXISTS `people`;
CREATE TABLE `people` (
  `peopleId` int(11) NOT NULL AUTO_INCREMENT,
  `peopleType` varchar(255) NOT NULL,
  `minNumber` int(2) NOT NULL,
  `maxNumber` int(3) NOT NULL,
  `morning` varchar(255) NOT NULL,
  `lunch` varchar(255) NOT NULL,
  `evening` varchar(255) NOT NULL,
  `advice` varchar(255) NOT NULL,
  PRIMARY KEY (`peopleId`),
  UNIQUE KEY `peopleType` (`peopleType`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of people
-- ----------------------------
INSERT INTO `people` VALUES ('4', '虚弱人群', '0', '25', '龙眼', '葡萄', '山竹', '气虚、脾虚有气虚、脾虚的儿童——在选择西瓜、香瓜、芒果、梨和香蕉这几种冷性的水果时要特别谨慎。气虚，一般是指体弱，而脾虚，是说消化系统比较差，肠蠕动慢。所以，这类儿童越吃寒冷的水果，越会降低肠胃蠕动，使肌肉无力，吃多了会因为消化不良而导致腹胀。因此，肠胃功能不好的幼儿，如果想吃凉性水果，最好在午饭后、晚饭前少吃一点，不可过量。');
INSERT INTO `people` VALUES ('5', '亚健康', '26', '50', '香蕉', '苹果', '西瓜', '您的身体处于亚健康状态哦。要注意补充维生素好好休息。当你失眠的时候，睡前吃香蕉，有镇静的作用；食用苹果等还可抗癌，缓解抑郁；西瓜可清热解暑，除烦止渴。在治疗肾炎和降低血压方面，西瓜可算是果菜之中的好医生。');
INSERT INTO `people` VALUES ('6', '一般人群', '51', '75', '草莓', '榴莲', '苹果', '您的身体情况一般。一般人群食用的水果总类很多，有时可根据身体不同的状况食用。');
INSERT INTO `people` VALUES ('7', '健康人群', '76', '100', '樱桃', '橘子', '香蕉', '恭喜您，您属于健康人群哦。健康人群一般的水果都可以食用，但是要注意吃果时间，太晚吃水果不好(⊙o⊙)哦！！');

-- ----------------------------
-- Table structure for record
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `recordId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，自增',
  `orderId` int(11) NOT NULL DEFAULT '0' COMMENT '订单编号',
  `price` float NOT NULL DEFAULT '0' COMMENT '价格',
  PRIMARY KEY (`recordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单记录表';

-- ----------------------------
-- Records of record
-- ----------------------------

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplierId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增',
  `supplierName` varchar(255) NOT NULL DEFAULT '' COMMENT '唯一',
  `supplierAddress` varchar(255) NOT NULL DEFAULT '' COMMENT '供应商地址',
  `suImg` varchar(255) DEFAULT NULL,
  `suTel` varchar(255) DEFAULT NULL,
  `suFruit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`supplierId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='供应商表';

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('6', '王大姐', '广西南宁海吉星水果批发市场', 'images/gx1.jpg', '232423432', '哈密瓜、各种瓜');
INSERT INTO `supplier` VALUES ('7', '南宁绿色果果公司', '南宁大学东路', 'images/gx2.jpg', '1232454556', '柿子');

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text` (
  `textId` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL COMMENT '内容',
  `img` varchar(255) DEFAULT NULL COMMENT '图片路径',
  `memo` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`textId`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Records of text
-- ----------------------------
INSERT INTO `text` VALUES ('3', '壮乡迷人风景', 'images/silk1.jpg', '轮播图片1');
INSERT INTO `text` VALUES ('57', '一带一路', 'images/silk2.jpg', '轮播图片2');
INSERT INTO `text` VALUES ('59', '美！壮乡姑娘摘水果', 'images/silk3.jpg', '轮播图片3');
INSERT INTO `text` VALUES ('65', '《夏季吃果知识》--果蔬应保持完好、外观正常、新鲜、无异味。不管什么原因引起的水果外伤，凡外形不完好，色泽变化，均应慎重选用。如水果表面略有小斑或少量虫蛀，应用刀挖去腐烂、虫蛀处，及其周围超过2厘米处的果肉部分。如霉变、腐烂、虫蛀面积达到或超过水果的1/3，则应该扔掉，不能再吃。\r\n', 'images/img3.jpg', '中部图片-1');
INSERT INTO `text` VALUES ('67', '《夏季吃果知识》--生吃果蔬前，要用水清洗干净，尤其注意果蒂等不容易清洗的部分，因为果蒂容易藏有污垢、细菌、虫卵等。一般果蔬用大量清水冲洗即可，也可再用清水浸泡10~20分钟。需要削皮的水果也要先洗净。切水果前，要先将手、案板、刀具和器具清洗干净，不要和处理生食的案板、刀具等混用，以免造成细菌污染。\r\n', 'images/img2.png', '中部图片-2');
INSERT INTO `text` VALUES ('68', '《夏季吃果知识》--谨慎购买路边小摊贩切开的哈密瓜、西瓜、菠萝等，因为他们的加工条件很难保证清洁卫生，食用后易引起食物中毒。如果买了，回家后要切掉原有切口处的一层果肉后再食用，且不可再存放。', 'images/img10.jpg', '中部图片-3');
INSERT INTO `text` VALUES ('69', '《夏季吃果知识》--果蔬尽量现吃现切，切开的果蔬不宜在室温下久存，应当尽快用保鲜盒或保鲜膜包裹储存于冰箱冷藏室。请注意，冰箱只能减缓细菌繁殖，储存时间不宜过长，塞得太满也会降低冷藏效果。', 'images/img23.jpg', '中部图片-4');
INSERT INTO `text` VALUES ('70', '《夏季吃果知识》--如果怀疑因进食不卫生的果蔬出现恶心、呕吐、腹痛、腹泻等症状，请及时就医。可疑食物不要立即丢弃，它们可能会帮助医生或公共卫生人员找到致病原因。\r\n', 'images/errorimg3.jpg', '中部图片-5');
INSERT INTO `text` VALUES ('71', '如果一个苹果能够15分钟吃完，则苹果中的有机酸和果酸就可以把口腔中的细菌杀死。', 'images/img4.jpg', '底部图片-1');
INSERT INTO `text` VALUES ('72', '樱桃性温热，热性病及虚热咳嗽者忌食；樱桃核仁含氰甙，水解后产生氢氰酸，药用时应小心中毒。', 'images/img1.jpg', '底部图片-2');
INSERT INTO `text` VALUES ('73', '山竹。山竹原名莽吉柿，原产于东南亚，一般种植10年才开始结果，对环境要求非常严格，因此是名副其实的绿色水果，与榴莲齐名，号称“果中皇后”。\r\n', 'images/img10.jpg', '底部图片-3');

-- ----------------------------
-- Table structure for tquantity
-- ----------------------------
DROP TABLE IF EXISTS `tquantity`;
CREATE TABLE `tquantity` (
  `tQuantityId` int(11) NOT NULL AUTO_INCREMENT COMMENT '数量编号',
  `goodsId` int(1) NOT NULL DEFAULT '0' COMMENT '商品号',
  `quantity` int(11) NOT NULL DEFAULT '0' COMMENT '数量',
  `trolleyId` int(11) NOT NULL DEFAULT '0' COMMENT '购物车编号',
  PRIMARY KEY (`tQuantityId`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='购物车商品数量表';

-- ----------------------------
-- Records of tquantity
-- ----------------------------
INSERT INTO `tquantity` VALUES ('4', '8', '1', '1');
INSERT INTO `tquantity` VALUES ('8', '2', '1', '1');
INSERT INTO `tquantity` VALUES ('12', '13', '1', '1');

-- ----------------------------
-- Table structure for trolley
-- ----------------------------
DROP TABLE IF EXISTS `trolley`;
CREATE TABLE `trolley` (
  `trolleyId` int(11) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  `userName` varchar(255) NOT NULL DEFAULT '' COMMENT '用户名',
  `price` float(255,0) DEFAULT '0' COMMENT '价格',
  PRIMARY KEY (`trolleyId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='购物车表';

-- ----------------------------
-- Records of trolley
-- ----------------------------
INSERT INTO `trolley` VALUES ('1', 'fly', '0');
INSERT INTO `trolley` VALUES ('2', 'LY', '0');
INSERT INTO `trolley` VALUES ('3', 'flying', '0');
INSERT INTO `trolley` VALUES ('5', 'flyin', '0');
INSERT INTO `trolley` VALUES ('7', 'Sweet', '0');
INSERT INTO `trolley` VALUES ('10', 'flu', '0');
INSERT INTO `trolley` VALUES ('18', 'Lily', '0');

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增',
  `typeName` varchar(255) DEFAULT '' COMMENT '类型名',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '健身最爱');
INSERT INTO `type` VALUES ('2', '美容养颜');
INSERT INTO `type` VALUES ('3', '瘦体纤身');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键,自增',
  `userName` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户，唯一',
  `userPass` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `userType` int(11) NOT NULL DEFAULT '1' COMMENT '用户类型。1.普通用户 2.管理员',
  `userMail` varchar(255) NOT NULL COMMENT '邮箱',
  `userAddress` varchar(255) NOT NULL DEFAULT '' COMMENT '用户地址',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'fly', '123456', '1', 'feifei@qq.com', 'GuangDong');
INSERT INTO `user` VALUES ('20', 'haha', '123456', '2', 'haha@qq.com', '西大的大榕树下');
INSERT INTO `user` VALUES ('23', 'flying', '1234', '1', '529291585@qq.com', '广西南宁西乡塘区广西大');
INSERT INTO `user` VALUES ('24', 'guagua', '123456', '2', '434357458@qq.com', '广西大学\r\n');
INSERT INTO `user` VALUES ('34', 'flu', '1234', '1', 'edfef@qq.com', '');
