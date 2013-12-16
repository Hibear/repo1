/*
MySQL Data Transfer
Source Host: localhost
Source Database: shoes_store
Target Host: localhost
Target Database: shoes_store
Date: 2013-7-14 PM 04:11:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for comments_info
-- ----------------------------
CREATE TABLE `comments_info` (
  `review_id` int(10) NOT NULL auto_increment,
  `user_id` int(10) default NULL,
  `goo_goods_id` int(10) default NULL,
  `goods_id` int(11) default NULL,
  `user_name` varchar(100) default NULL,
  `review_text` varchar(1000) default NULL,
  `review_time` datetime default NULL,
  PRIMARY KEY  (`review_id`),
  KEY `FK_Reference_15` (`goo_goods_id`),
  KEY `FK_Reference_3` (`user_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`goo_goods_id`) REFERENCES `goods_info` (`goods_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_class_info
-- ----------------------------
CREATE TABLE `goods_class_info` (
  `class_id` int(10) NOT NULL auto_increment,
  `class_name` varchar(100) default NULL,
  PRIMARY KEY  (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_info
-- ----------------------------
CREATE TABLE `goods_info` (
  `goods_id` int(10) NOT NULL auto_increment,
  `class_id` int(10) default NULL,
  `goods_type_code` varchar(100) default NULL,
  `goods_name` varchar(100) default NULL,
  `goods_keys` varchar(100) default NULL,
  `goods_text` varchar(250) default NULL,
  `goods_pt` varchar(50) default NULL,
  `goods_price_shop` float default NULL,
  `goods_price_user` float default NULL,
  `goods_is_new` varchar(10) default NULL,
  `is_recommend` varchar(10) default NULL,
  `goods_buy_number` int(11) default NULL,
  `goods_in_time` datetime default NULL,
  `is_cheap` varchar(10) default NULL,
  PRIMARY KEY  (`goods_id`),
  KEY `class_id` (`class_id`),
  CONSTRAINT `goods_info_ibfk_8` FOREIGN KEY (`class_id`) REFERENCES `goods_class_info` (`class_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_link_order_info
-- ----------------------------
CREATE TABLE `goods_link_order_info` (
  `order_id` int(10) NOT NULL,
  `goods_id` int(10) NOT NULL,
  `order_number` int(10) default NULL,
  KEY `FK_Reference_11` (`order_id`),
  KEY `FK_Reference_12` (`goods_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`order_id`) REFERENCES `order_records_info` (`order_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_link_shoppingcart_info
-- ----------------------------
CREATE TABLE `goods_link_shoppingcart_info` (
  `shoppingcart_id` int(10) NOT NULL auto_increment,
  `goods_id` int(10) NOT NULL,
  `goods_number` int(10) default NULL,
  PRIMARY KEY  (`shoppingcart_id`),
  KEY `FK_Reference_13` (`goods_id`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`shoppingcart_id`) REFERENCES `shoppingcart_info` (`shoppingcart_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_picture_info
-- ----------------------------
CREATE TABLE `goods_picture_info` (
  `picture_id` int(10) NOT NULL auto_increment,
  `goods_id` int(10) default NULL,
  `picture_name` varchar(100) default NULL,
  `picture_url` varchar(50) default NULL,
  PRIMARY KEY  (`picture_id`),
  KEY `goods_id` (`goods_id`),
  CONSTRAINT `goods_picture_info_ibfk_6` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for goods_receipt_link_info
-- ----------------------------
CREATE TABLE `goods_receipt_link_info` (
  `goods_id` int(10) NOT NULL,
  `receipt_id` int(10) NOT NULL,
  `receipt_number` int(10) default NULL,
  KEY `FK_Reference_16` (`goods_id`),
  KEY `FK_Reference_17` (`receipt_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`goods_id`) REFERENCES `goods_info` (`goods_id`),
  CONSTRAINT `FK_Reference_17` FOREIGN KEY (`receipt_id`) REFERENCES `receipt_info` (`receipt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for manager_info
-- ----------------------------
CREATE TABLE `manager_info` (
  `manager_id` int(10) NOT NULL auto_increment,
  `manager_name` varchar(100) default NULL,
  `manager_pwd` varchar(50) default NULL,
  `manager_create_time` datetime default NULL,
  PRIMARY KEY  (`manager_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for order_records_info
-- ----------------------------
CREATE TABLE `order_records_info` (
  `order_id` int(10) NOT NULL auto_increment,
  `user_id` int(10) default NULL,
  `order_user_real_name` varchar(100) default NULL,
  `order_user_address` varchar(300) default NULL,
  `order_user_post_code` int(10) default NULL,
  `order_user_phone` varchar(20) default NULL,
  `order_user_email` varchar(100) default NULL,
  `order_goods_send_type` varchar(50) default NULL,
  `order_time` datetime default NULL,
  `goods_price` float default NULL,
  `tran_fee` float default NULL,
  `is_confirm` varchar(10) default NULL,
  PRIMARY KEY  (`order_id`),
  KEY `FK_Reference_1` (`user_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for receipt_info
-- ----------------------------
CREATE TABLE `receipt_info` (
  `receipt_id` int(10) NOT NULL auto_increment,
  `receipt_price` float default NULL,
  `receipt_time` datetime default NULL,
  PRIMARY KEY  (`receipt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for shoppingcart_info
-- ----------------------------
CREATE TABLE `shoppingcart_info` (
  `shoppingcart_id` int(10) NOT NULL auto_increment,
  `user_id` int(10) default NULL,
  PRIMARY KEY  (`shoppingcart_id`),
  KEY `FK_Reference_14` (`user_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
CREATE TABLE `user_info` (
  `user_id` int(10) NOT NULL auto_increment,
  `user_name` varchar(100) default NULL,
  `user_pwd` varchar(50) default NULL,
  `user_email` varchar(100) default NULL,
  `user_phone` varchar(20) default NULL,
  `user_address` varchar(100) default NULL,
  `is_user_check` varchar(5) default NULL,
  `user_create_time` datetime default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `comments_info` VALUES ('1', '10010', '221', '131', '常回家看看', '很喜欢，大小，颜色合适', '2013-07-02 15:08:38');
INSERT INTO `comments_info` VALUES ('3', '10010', '221', '131', '我', '不喜欢', '2012-02-05 21:27:31');
INSERT INTO `comments_info` VALUES ('4', '10010', '221', '131', '其他', '款式很好，喜欢！', '2013-07-14 09:18:45');
INSERT INTO `comments_info` VALUES ('5', '10010', '221', '131', null, '真的不好看', '2013-07-14 09:32:45');
INSERT INTO `comments_info` VALUES ('6', null, '221', '131', null, '真的不好看', '2013-07-14 09:57:13');
INSERT INTO `comments_info` VALUES ('7', '10012', '221', '131', null, '和', '2013-07-14 10:28:45');
INSERT INTO `comments_info` VALUES ('8', '10012', '221', '131', null, '跳楼价', '2013-07-14 10:52:16');
INSERT INTO `comments_info` VALUES ('9', '10012', '221', '131', null, '真的是跳楼价', '2013-07-14 10:52:54');
INSERT INTO `comments_info` VALUES ('10', '10012', '221', '10010', null, '测试', '2013-07-14 10:54:10');
INSERT INTO `goods_class_info` VALUES ('11', '测试');
INSERT INTO `goods_class_info` VALUES ('12', '测试2');
INSERT INTO `goods_class_info` VALUES ('13', '测试3');
INSERT INTO `goods_class_info` VALUES ('22', '皮鞋');
INSERT INTO `goods_class_info` VALUES ('33', '休闲鞋');
INSERT INTO `goods_class_info` VALUES ('44', '运动鞋');
INSERT INTO `goods_class_info` VALUES ('55', ' 帆布鞋');
INSERT INTO `goods_class_info` VALUES ('66', ' 靴子');
INSERT INTO `goods_class_info` VALUES ('77', '凉鞋');
INSERT INTO `goods_class_info` VALUES ('88', '单鞋');
INSERT INTO `goods_info` VALUES ('221', '22', '22xx1', '老人头皮鞋', '经典，正装', '新款意大利老人头正品英伦系带潮流韩版正装皮鞋内增高6厘米男鞋', '老人头', '498', '388', '是', '是', null, '2013-07-11 15:12:03', '是');
INSERT INTO `goods_info` VALUES ('222', '22', '22xx2', '英伦风皮鞋', '英伦，牛皮', '新款英伦头层牛皮男鞋皮鞋潮鞋休闲皮鞋低帮鞋', '英伦风', '218', '198', '是', '是', null, '2013-07-11 15:23:45', '是');
INSERT INTO `goods_info` VALUES ('223', '22', '22xx3', '意尔康牛皮鞋', '意尔康，牛皮', '新款意尔康牛皮真皮 商务皮鞋 商务单鞋', '意尔康', '425', '400', '是', '是', null, '2013-07-11 15:28:35', '是');
INSERT INTO `goods_info` VALUES ('224', '22', '22xx4', '百丽皮鞋', '百丽，牛皮', '新款百丽正品鞋 真牛皮 商务鞋', '百丽', '298', '298', '是', '是', null, '2013-07-11 15:36:15', '否');
INSERT INTO `goods_info` VALUES ('225', '22', '22xx5', '红蜻蜓皮鞋', '红蜻蜓，商务，牛皮', '新款红蜻蜓牛皮 商务 休闲皮鞋', '红蜻蜓', '199', '199', '是', '是', null, '2013-07-11 15:38:55', '否');
INSERT INTO `goods_info` VALUES ('331', '33', '33xx1', '休闲鞋', '休息，时尚', '夏季男士休闲鞋', '万斯', '99', '88', '是', '是', null, '2013-07-11 15:54:24', '是');
INSERT INTO `goods_info` VALUES ('441', '44', '44xx1', 'Nike板鞋', '运动，潮流', 'Nike耐克 男式 经典Blazer系列复古怀旧鞋带鞋底亮丽配色高帮运动文化鞋    \r\nNike耐克 男式 经典Blazer系列复古怀旧鞋带鞋底亮丽配色高帮运动文化鞋    \r\nNike耐克 男式 经典Blazer系列复古怀旧鞋带鞋底亮丽配色高帮运动文化鞋   ', 'Nike', '799', '369', '是', '是', null, '2013-07-23 14:52:01', '是');
INSERT INTO `goods_info` VALUES ('442', '44', '44xx3', '运动鞋', '运动，流行', '山地越野系列多方位防护性能超轻便携透气防滑户外鞋    鞋头部位是特殊设计的攀岩区域，前脚掌采用防护垫片在攀登时提供更加安全舒适的感受。\r\n', 'Adidas', '680', '300', '否', '是', null, '2013-07-23 15:37:34', '是');
INSERT INTO `goods_info` VALUES ('444', '44', '44xx5', '鸿星尔克运动鞋', '跑步鞋', '鸿星尔克 男式 减压耐磨鞋底渐变拼接面舒适跑步鞋   ', '鸿星尔克', '299', '198', '是', '是', null, '2013-07-23 16:00:35', '是');
INSERT INTO `goods_info` VALUES ('666', '11', '44xx5', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `goods_info` VALUES ('667', '88', 'null', 'null', 'null', 'null', 'null', '0', '0', 'null', 'null', '0', null, 'null');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('2', '221', '3');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('4', '221', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('5', '221', '6');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('6', '221', '6');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('7', '224', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('8', '224', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('9', '221', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('10', '221', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('11', '224', '33');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('12', '221', '4');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('20', '225', '4');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('21', '225', '4');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('22', '221', '4');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('23', '221', null);
INSERT INTO `goods_link_shoppingcart_info` VALUES ('37', '221', '11');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('38', '221', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('39', '221', '12');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('40', '221', '1');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('41', '224', '111');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('42', '221', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('43', '224', '12');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('44', '224', '2');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('45', '221', '1');
INSERT INTO `goods_link_shoppingcart_info` VALUES ('46', '221', '12');
INSERT INTO `goods_picture_info` VALUES ('1', '444', '22', 'front-stage/img/t1.jpg');
INSERT INTO `goods_picture_info` VALUES ('2', '442', '22', 'front-stage/img/t1.jpg');
INSERT INTO `goods_picture_info` VALUES ('3', '223', '22', 'front-stage/img/t2.jpg');
INSERT INTO `goods_picture_info` VALUES ('4', '222', '男性品牌', 'front-stage/img/nanxingpp2.jpg');
INSERT INTO `goods_picture_info` VALUES ('5', '222', '男性品牌', 'front-stage/img/nanxingpp1.jpg');
INSERT INTO `goods_picture_info` VALUES ('6', '222', '女性品牌', 'front-stage/img/nvxingpp2.jpg');
INSERT INTO `goods_picture_info` VALUES ('7', '222', '女性品牌', 'front-stage/img/nvxingpp1.jpg');
INSERT INTO `goods_picture_info` VALUES ('12', '223', '耐克标牌', 'front-stage/img/nike.jpg');
INSERT INTO `goods_picture_info` VALUES ('13', '225', '李宁标牌', 'front-stage/img/lining.jpg');
INSERT INTO `goods_picture_info` VALUES ('14', '224', '鸿星尔克', 'front-stage/img/hongxierke.jpg');
INSERT INTO `goods_picture_info` VALUES ('15', '223', '爱旅儿', 'front-stage/img/ailuer.jpg');
INSERT INTO `goods_picture_info` VALUES ('18', '222', '女性热卖', 'front-stage/img/nvxingremai2.jpg');
INSERT INTO `goods_picture_info` VALUES ('19', '222', '女性热卖', 'front-stage/img/brandsf1.jpg');
INSERT INTO `goods_picture_info` VALUES ('20', '223', '男性热卖', 'front-stage/img/nankuanB.jpg');
INSERT INTO `goods_picture_info` VALUES ('21', '223', '更多', 'front-stage/img/more.jpg');
INSERT INTO `goods_picture_info` VALUES ('30', '224', '时尚女性', 'front-stage/img/13.jpg');
INSERT INTO `goods_picture_info` VALUES ('31', '224', '时尚女性', 'front-stage/img/9.jpg');
INSERT INTO `goods_picture_info` VALUES ('32', '221', '时尚女性', 'front-stage/img/10.jpg');
INSERT INTO `goods_picture_info` VALUES ('33', '221', '时尚女性', 'front-stage/img/32.jpg');
INSERT INTO `goods_picture_info` VALUES ('34', '221', '时尚女性', 'front-stage/img/31.jpg');
INSERT INTO `goods_picture_info` VALUES ('35', '221', '时尚女性', 'front-stage/img/37.jpg');
INSERT INTO `goods_picture_info` VALUES ('36', '221', '时尚女性', 'front-stage/img/22.jpg');
INSERT INTO `goods_picture_info` VALUES ('37', '221', '时尚女性', 'front-stage/img/26.jpg');
INSERT INTO `goods_picture_info` VALUES ('38', '221', '时尚女性', 'front-stage/img/38.jpg');
INSERT INTO `goods_picture_info` VALUES ('39', '221', '时尚女性', 'front-stage/img/34.jpg');
INSERT INTO `goods_picture_info` VALUES ('40', '221', '时尚女性', 'front-stage/img/33.jpg');
INSERT INTO `goods_picture_info` VALUES ('41', '221', '时尚女性', 'front-stage/img/12.jpg');
INSERT INTO `goods_picture_info` VALUES ('50', '222', '时尚男鞋', 'front-stage/img/18.png');
INSERT INTO `goods_picture_info` VALUES ('51', '222', '时尚男鞋', 'front-stage/img/17.png');
INSERT INTO `goods_picture_info` VALUES ('52', '222', '时尚男鞋', 'front-stage/img/16.png');
INSERT INTO `goods_picture_info` VALUES ('53', '222', '时尚男鞋', 'front-stage/img/4.png');
INSERT INTO `goods_picture_info` VALUES ('54', '222', '时尚男鞋', 'front-stage/img/5.png');
INSERT INTO `goods_picture_info` VALUES ('55', '222', '时尚男鞋', 'front-stage/img/6.png');
INSERT INTO `goods_picture_info` VALUES ('56', '222', '时尚男鞋', 'front-stage/img/7.png');
INSERT INTO `goods_picture_info` VALUES ('57', '222', '时尚男鞋', 'front-stage/img/8.png');
INSERT INTO `goods_picture_info` VALUES ('58', '222', '时尚男鞋', 'front-stage/img/9.png');
INSERT INTO `goods_picture_info` VALUES ('59', '223', '时尚男鞋', 'front-stage/img/11.png');
INSERT INTO `goods_picture_info` VALUES ('60', '223', '时尚男鞋', 'front-stage/img/14.png');
INSERT INTO `goods_picture_info` VALUES ('61', '223', '时尚男鞋', 'front-stage/img/15.png');
INSERT INTO `goods_picture_info` VALUES ('70', '224', '运动潮流', 'front-stage/img/s10.jpg');
INSERT INTO `goods_picture_info` VALUES ('71', '224', '运动潮流', 'front-stage/img/s11.jpg');
INSERT INTO `goods_picture_info` VALUES ('72', '224', '运动潮流', null);
INSERT INTO `goods_picture_info` VALUES ('73', '224', '运动潮流', 'front-stage/img/s1.jpg');
INSERT INTO `goods_picture_info` VALUES ('74', '224', '运动潮流', 'front-stage/img/s2.jpg');
INSERT INTO `goods_picture_info` VALUES ('75', '224', '运动潮流', 'front-stage/img/s3.jpg');
INSERT INTO `goods_picture_info` VALUES ('76', '224', '运动潮流', 'front-stage/img/s4.jpg');
INSERT INTO `goods_picture_info` VALUES ('77', '221', '运动潮流', 'front-stage/img/s5.jpg');
INSERT INTO `goods_picture_info` VALUES ('78', '221', '运动潮流', 'front-stage/img/t2.jpg');
INSERT INTO `goods_picture_info` VALUES ('79', '221', '运动潮流', 'front-stage/img/t1.jpg');
INSERT INTO `goods_picture_info` VALUES ('80', '221', '运动潮流', 'front-stage/img/s8.jpg');
INSERT INTO `goods_picture_info` VALUES ('81', '221', '运动潮流', 'front-stage/img/brandsf12222.jpg');
INSERT INTO `manager_info` VALUES ('100806001', '杨雄', '123', '2013-07-14 12:50:56');
INSERT INTO `manager_info` VALUES ('100806002', '吐钊', '123', '2013-07-13 21:56:22');
INSERT INTO `manager_info` VALUES ('100806003', '汪洪梅', '123', '2013-07-09 14:16:53');
INSERT INTO `manager_info` VALUES ('100806004', '岳利', '123', '2013-07-09 14:16:56');
INSERT INTO `manager_info` VALUES ('100806005', '曾微中', '123', '2013-07-09 14:16:59');
INSERT INTO `manager_info` VALUES ('100806006', '汪泳', '123', '2013-07-09 14:17:03');
INSERT INTO `manager_info` VALUES ('100806007', '小明', '222', '2013-07-12 19:57:19');
INSERT INTO `manager_info` VALUES ('100806008', '傻鸟', '1234', '2013-07-13 21:54:38');
INSERT INTO `manager_info` VALUES ('100806009', '泥鳅', '000', '2013-07-13 21:55:02');
INSERT INTO `manager_info` VALUES ('100806010', '小苍苍', '123', '2013-07-14 15:02:29');
INSERT INTO `order_records_info` VALUES ('1', '10010', '赵晓', '重庆', '552323', '4564512', '4546@qq.com', '快递', '2013-07-14 12:50:26', '452.3', '22', '否');
INSERT INTO `order_records_info` VALUES ('2', '10010', '赵信', '重庆', '552323', '12354465', '6564@qq.com', '申通', '2013-07-11 11:46:06', '5656', '20', '是');
INSERT INTO `order_records_info` VALUES ('3', '10011', '双方', '地方', '5656', '546', '156@qq.com', '双方', '2013-07-11 11:06:04', '5466', '2', '是');
INSERT INTO `order_records_info` VALUES ('4', '10010', '双方', '双方', '46465', '11312', '56465@qq.com', '快递', '2013-07-11 11:07:49', '4564', '500', '是');
INSERT INTO `order_records_info` VALUES ('22', '10012', '悟空', '算法', '55654', '132122', '2123@qq.com', '的份上', '2013-07-13 21:46:08', '455', '20', '是');
INSERT INTO `order_records_info` VALUES ('23', '10012', '悟空', '重庆', '54655', '55655', '565555@qq.com', '方式', '2013-07-13 21:48:50', '656', '5', '是');
INSERT INTO `order_records_info` VALUES ('25', '10012', '悟空', '重庆西南', '565565', '212121212', '55565@qq.com', '地方', '2013-07-13 21:52:09', '54546', '12', '是');
INSERT INTO `order_records_info` VALUES ('30', '10012', '悟空', '重庆北部', '546565', '512212', '2324@qq.com', '是', '2013-07-13 22:02:50', '565', '12', '是');
INSERT INTO `order_records_info` VALUES ('32', '10012', '悟空', '重庆', '4565', '212313', '1212@qq.com', '数据库', '2013-07-13 22:05:19', '4546', '12', '是');
INSERT INTO `order_records_info` VALUES ('33', '10012', '悟空', '重庆', '250000', '13428968493', '13@qq.com', '提前', '2013-07-11 11:05:13', '32', '12', '否');
INSERT INTO `order_records_info` VALUES ('111', '10012', '悟空', '123', '1323131', '1', '13', '131', '2013-07-14 12:27:10', '31', '31', '31');
INSERT INTO `order_records_info` VALUES ('122', '10012', '悟空', '12121121', '121', '1211', '1211', '11', '2013-07-14 12:19:24', '11', '11', '12');
INSERT INTO `order_records_info` VALUES ('123', '10012', '悟空', '111', '11111', '111', '11', '1111', '2013-07-14 12:44:07', '1111', '1211', '12');
INSERT INTO `order_records_info` VALUES ('1234', '12347', '八戒', '4145454', '22241', '415454', '545', '45', '2013-07-14 12:57:46', '45', '45', '4');
INSERT INTO `order_records_info` VALUES ('11111', '10012', '悟空', '123', '121', '21', '21', '21', '2013-07-14 12:28:24', '12', '121', '是');
INSERT INTO `order_records_info` VALUES ('12121', '10012', '悟空', '12121121', '12', '212', '121', '21', '2013-07-13 23:33:28', '1', '21', '是');
INSERT INTO `receipt_info` VALUES ('1', '200', '2013-07-09 14:41:19');
INSERT INTO `receipt_info` VALUES ('2', '300', '2013-07-09 14:42:31');
INSERT INTO `receipt_info` VALUES ('3', '250', '2013-07-09 14:42:44');
INSERT INTO `receipt_info` VALUES ('7', '560', '2013-07-10 20:48:32');
INSERT INTO `receipt_info` VALUES ('15', '565', '2013-07-10 22:46:13');
INSERT INTO `receipt_info` VALUES ('1223', '32', '2013-07-14 15:02:46');
INSERT INTO `shoppingcart_info` VALUES ('1', '10010');
INSERT INTO `shoppingcart_info` VALUES ('2', '10011');
INSERT INTO `shoppingcart_info` VALUES ('3', '10012');
INSERT INTO `shoppingcart_info` VALUES ('4', '10012');
INSERT INTO `shoppingcart_info` VALUES ('5', '10012');
INSERT INTO `shoppingcart_info` VALUES ('6', '10012');
INSERT INTO `shoppingcart_info` VALUES ('7', '10012');
INSERT INTO `shoppingcart_info` VALUES ('8', '10012');
INSERT INTO `shoppingcart_info` VALUES ('9', '10012');
INSERT INTO `shoppingcart_info` VALUES ('10', '10012');
INSERT INTO `shoppingcart_info` VALUES ('11', '10012');
INSERT INTO `shoppingcart_info` VALUES ('12', '10012');
INSERT INTO `shoppingcart_info` VALUES ('13', '10012');
INSERT INTO `shoppingcart_info` VALUES ('14', '10012');
INSERT INTO `shoppingcart_info` VALUES ('15', '10012');
INSERT INTO `shoppingcart_info` VALUES ('16', '10012');
INSERT INTO `shoppingcart_info` VALUES ('17', '10012');
INSERT INTO `shoppingcart_info` VALUES ('18', '10012');
INSERT INTO `shoppingcart_info` VALUES ('19', '10012');
INSERT INTO `shoppingcart_info` VALUES ('20', '10012');
INSERT INTO `shoppingcart_info` VALUES ('21', '10012');
INSERT INTO `shoppingcart_info` VALUES ('22', '10012');
INSERT INTO `shoppingcart_info` VALUES ('23', '10012');
INSERT INTO `shoppingcart_info` VALUES ('24', '10012');
INSERT INTO `shoppingcart_info` VALUES ('25', '10012');
INSERT INTO `shoppingcart_info` VALUES ('26', '10012');
INSERT INTO `shoppingcart_info` VALUES ('27', '10012');
INSERT INTO `shoppingcart_info` VALUES ('28', '10012');
INSERT INTO `shoppingcart_info` VALUES ('29', '10012');
INSERT INTO `shoppingcart_info` VALUES ('30', '10012');
INSERT INTO `shoppingcart_info` VALUES ('33', '10012');
INSERT INTO `shoppingcart_info` VALUES ('34', '10012');
INSERT INTO `shoppingcart_info` VALUES ('41', '10012');
INSERT INTO `shoppingcart_info` VALUES ('43', '10012');
INSERT INTO `shoppingcart_info` VALUES ('31', '12341');
INSERT INTO `shoppingcart_info` VALUES ('32', '12341');
INSERT INTO `shoppingcart_info` VALUES ('35', '12341');
INSERT INTO `shoppingcart_info` VALUES ('36', '12341');
INSERT INTO `shoppingcart_info` VALUES ('37', '12341');
INSERT INTO `shoppingcart_info` VALUES ('42', '12341');
INSERT INTO `shoppingcart_info` VALUES ('38', '12342');
INSERT INTO `shoppingcart_info` VALUES ('39', '12343');
INSERT INTO `shoppingcart_info` VALUES ('40', '12344');
INSERT INTO `shoppingcart_info` VALUES ('44', '12347');
INSERT INTO `shoppingcart_info` VALUES ('45', '12349');
INSERT INTO `shoppingcart_info` VALUES ('46', '12351');
INSERT INTO `user_info` VALUES ('10010', '123', 'dfs', 'fs', 'ad', 'dsf', '否', '2013-07-10 22:29:29');
INSERT INTO `user_info` VALUES ('10011', 'howareyou', '123', '13@qq.com', '15469877415', '四川省', '否', '2013-07-10 21:57:01');
INSERT INTO `user_info` VALUES ('10012', '悟空', '123', '14@qq.com', '13428968493', '福建省泉州市', '否', '2013-07-10 22:25:06');
INSERT INTO `user_info` VALUES ('12333', 'visuojj', '989898', '5214@qq.com', '5485721', '贵阳市', ' 是', '2013-07-12 09:08:42');
INSERT INTO `user_info` VALUES ('12334', '样设计', '121', '12', '1', '21', '是', '2013-07-11 21:20:54');
INSERT INTO `user_info` VALUES ('12335', '大号多少级', '换句话', '就看见', '21', '2121', '是', '2013-07-11 21:21:35');
INSERT INTO `user_info` VALUES ('12336', '和设计还是', '数据库', '21', '212', '21', '是', '2013-07-11 21:24:42');
INSERT INTO `user_info` VALUES ('12337', 'yue', '123', '123@qq.com', '18798009073', '贵州贵阳', '是', '2013-07-12 09:05:28');
INSERT INTO `user_info` VALUES ('12338', '月', '123', '13123', '1221', ' ', '是', '2013-07-12 18:58:06');
INSERT INTO `user_info` VALUES ('12339', '215', '123', '', '', '', '是', '2013-07-12 21:38:46');
INSERT INTO `user_info` VALUES ('12340', '3', '3', '3', '3', '3', '是', '2013-07-13 17:12:39');
INSERT INTO `user_info` VALUES ('12341', '阅历', '123', '123@qq.com', '187982232120', '贵阳', '是', '2013-07-14 10:01:17');
INSERT INTO `user_info` VALUES ('12342', '悠悠', '123', '123456@qq.com', '123', '221', '是', '2013-07-14 10:20:58');
INSERT INTO `user_info` VALUES ('12343', '辅导', '123', '123456@qq.com', '123', '123', '是', '2013-07-14 10:28:35');
INSERT INTO `user_info` VALUES ('12344', '哈喽', '123', '123', '1232', '12312', '是', '2013-07-14 10:30:22');
INSERT INTO `user_info` VALUES ('12345', '问', '123', '333', '1354566786442', '式', '是', '2013-07-14 11:07:32');
INSERT INTO `user_info` VALUES ('12346', 'yueli', '123456', '123456@qq.com', '18798009073', '贵阳', '是', '2013-07-14 11:21:51');
INSERT INTO `user_info` VALUES ('12347', '八戒', '123', '', '', '', '否', '2013-07-14 11:50:08');
INSERT INTO `user_info` VALUES ('12348', '八戒', '123', '123', '123', '123', '是', '2013-07-14 12:57:11');
INSERT INTO `user_info` VALUES ('12349', '汪涵', '123', '751154643@qq.com', '18798010381', '湖南省长沙市', '是', '2013-07-14 13:08:37');
INSERT INTO `user_info` VALUES ('12350', '111', '111', '111', '111', '111', '是', '2013-07-14 14:01:14');
INSERT INTO `user_info` VALUES ('12351', '小苍', '123', '1123', '123', '12', '是', '2013-07-14 15:03:21');
