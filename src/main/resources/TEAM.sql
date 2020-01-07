/*
Navicat Oracle Data Transfer
Oracle Client Version : 10.2.0.5.0

Source Server         : tea
Source Server Version : 100200
Source Host           : localhost:1521
Source Schema         : TEAM

Target Server Type    : ORACLE
Target Server Version : 100200
File Encoding         : 65001

Date: 2020-01-07 10:24:56
*/


-- ----------------------------
-- Table structure for BUSINESS
-- ----------------------------
DROP TABLE "TEAM"."BUSINESS";
CREATE TABLE "TEAM"."BUSINESS" (
"ID" NUMBER(20) NOT NULL ,
"ACCOUNT" VARCHAR2(20 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(20 BYTE) NOT NULL ,
"HEAD_PORTRAIT" VARCHAR2(30 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of BUSINESS
-- ----------------------------
INSERT INTO "TEAM"."BUSINESS" VALUES ('1', 'acc1', 'pass1', null);
INSERT INTO "TEAM"."BUSINESS" VALUES ('2', 'boss', 'boss', null);
INSERT INTO "TEAM"."BUSINESS" VALUES ('3', 'acc2', 'pass2', '36759picture.jpg');
INSERT INTO "TEAM"."BUSINESS" VALUES ('4', 'acc3', 'pass3', '83499picture.jpg');
INSERT INTO "TEAM"."BUSINESS" VALUES ('5', 'acc4', 'pass4', '37364picture.jpg');

-- ----------------------------
-- Table structure for COLLECTION
-- ----------------------------
DROP TABLE "TEAM"."COLLECTION";
CREATE TABLE "TEAM"."COLLECTION" (
"ID" NUMBER(20) NOT NULL ,
"GOODS_ID" NUMBER(20) NOT NULL ,
"CUSTOMER_ID" NUMBER(20) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of COLLECTION
-- ----------------------------
INSERT INTO "TEAM"."COLLECTION" VALUES ('6', '2', '1');
INSERT INTO "TEAM"."COLLECTION" VALUES ('8', '1', '1');
INSERT INTO "TEAM"."COLLECTION" VALUES ('5', '1', '2');

-- ----------------------------
-- Table structure for CUSTOMER
-- ----------------------------
DROP TABLE "TEAM"."CUSTOMER";
CREATE TABLE "TEAM"."CUSTOMER" (
"ID" NUMBER(20) NOT NULL ,
"ACCOUNT" VARCHAR2(20 BYTE) NOT NULL ,
"PASSWORD" VARCHAR2(20 BYTE) NOT NULL ,
"HEAD_PORTRAIT" VARCHAR2(30 BYTE) NOT NULL ,
"NICKNAME" VARCHAR2(20 BYTE) NOT NULL ,
"ADDRESS" VARCHAR2(40 BYTE) NOT NULL ,
"REAL_NAME" VARCHAR2(20 BYTE) NULL ,
"GENDER" VARCHAR2(10 BYTE) NULL ,
"PHONE_NUMBER" VARCHAR2(15 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of CUSTOMER
-- ----------------------------
INSERT INTO "TEAM"."CUSTOMER" VALUES ('1', 'acc1', 'pass1', 'head1', 'nick1', 'address1', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('2', 'acc2', 'pass2', 'head2', 'nick2', 'address2', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('3', 'acc3', 'pass3', 'head3', 'nick3', 'address3', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('4', 'username4', 'pass4', 'head4', 'nick4', 'address4', 'real1', 'male', '123');
INSERT INTO "TEAM"."CUSTOMER" VALUES ('5', 'acc5', 'pass5', 'head5', 'neck5', 'add5', 'real5', 'male', '123');
INSERT INTO "TEAM"."CUSTOMER" VALUES ('6', 'acc6', 'pass6', '96204picture.jpg', 'nickname6', 'address6', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('7', 'acc7', 'pass7', '74611picture.jpg', 'niackname7', 'address7', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('8', 'acc8', 'pass8', '67796picture.jpg', 'niackname8', 'address8', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('12', 'nick9', 'pass9', '25191picture.jpg', 'nick9', 'add9', null, null, null);
INSERT INTO "TEAM"."CUSTOMER" VALUES ('13', 'acc10', 'pass10', '96182picture.jpg', 'nick10', 'add10', null, null, null);

-- ----------------------------
-- Table structure for DELIVERYMAN
-- ----------------------------
DROP TABLE "TEAM"."DELIVERYMAN";
CREATE TABLE "TEAM"."DELIVERYMAN" (
"ID" NUMBER(20) NOT NULL ,
"NAME" VARCHAR2(20 BYTE) NOT NULL ,
"PHONE_NUMBER" VARCHAR2(20 BYTE) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of DELIVERYMAN
-- ----------------------------
INSERT INTO "TEAM"."DELIVERYMAN" VALUES ('1', 'name', '123');
INSERT INTO "TEAM"."DELIVERYMAN" VALUES ('2', 'name2', '123');
INSERT INTO "TEAM"."DELIVERYMAN" VALUES ('3', 'name3', '123');
INSERT INTO "TEAM"."DELIVERYMAN" VALUES ('5', 'name4', '13233441234');
INSERT INTO "TEAM"."DELIVERYMAN" VALUES ('8', 'name8', '13233441238');
INSERT INTO "TEAM"."DELIVERYMAN" VALUES ('11', 'name11', '13233441211');

-- ----------------------------
-- Table structure for GOODS
-- ----------------------------
DROP TABLE "TEAM"."GOODS";
CREATE TABLE "TEAM"."GOODS" (
"ID" NUMBER(20) NOT NULL ,
"NAME" VARCHAR2(20 BYTE) NOT NULL ,
"PICTURE" VARCHAR2(30 BYTE) NOT NULL ,
"PRICE" NUMBER(7,2) NOT NULL ,
"QUANTITY" NUMBER(5) NOT NULL ,
"DESCRIPTION" VARCHAR2(200 BYTE) NULL ,
"CATEGORY_ID" NUMBER(20) NULL ,
"COLLECTION_NUMBER" NUMBER(20) NULL ,
"COST" NUMBER(7,2) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of GOODS
-- ----------------------------
INSERT INTO "TEAM"."GOODS" VALUES ('1', 'name1', 'piecture1', '12.50', '100', null, '1', '2', '10.50');
INSERT INTO "TEAM"."GOODS" VALUES ('2', 'name2', 'piecture2', '12.50', '300', null, '1', '1', '10.50');
INSERT INTO "TEAM"."GOODS" VALUES ('3', 'name3', 'piecture3', '12.50', '300', null, '3', '0', '10.50');
INSERT INTO "TEAM"."GOODS" VALUES ('4', 'name4', '55152picture.jpg', '12', '50', null, '3', '0', '10');

-- ----------------------------
-- Table structure for GOODS_CATEGORY
-- ----------------------------
DROP TABLE "TEAM"."GOODS_CATEGORY";
CREATE TABLE "TEAM"."GOODS_CATEGORY" (
"ID" NUMBER(20) NOT NULL ,
"NAME" VARCHAR2(30 BYTE) NOT NULL ,
"REGION" VARCHAR2(20 BYTE) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of GOODS_CATEGORY
-- ----------------------------
INSERT INTO "TEAM"."GOODS_CATEGORY" VALUES ('1', 'category1', 'shopping');
INSERT INTO "TEAM"."GOODS_CATEGORY" VALUES ('2', 'category2', 'shopping');
INSERT INTO "TEAM"."GOODS_CATEGORY" VALUES ('3', 'category3', 'food');
INSERT INTO "TEAM"."GOODS_CATEGORY" VALUES ('4', 'category4', 'food');
INSERT INTO "TEAM"."GOODS_CATEGORY" VALUES ('5', 'category5', 'food');
INSERT INTO "TEAM"."GOODS_CATEGORY" VALUES ('6', 'category6', 'food');

-- ----------------------------
-- Table structure for ORDER_ITEM
-- ----------------------------
DROP TABLE "TEAM"."ORDER_ITEM";
CREATE TABLE "TEAM"."ORDER_ITEM" (
"ID" NUMBER(20) NOT NULL ,
"GOODS_ID" NUMBER(20) NOT NULL ,
"ORDER_ID" NUMBER(20) NULL ,
"QUANTITY" NUMBER(7) NOT NULL ,
"AMOUNT" NUMBER(10,2) NOT NULL ,
"CUSTOMER_ID" NUMBER(20) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of ORDER_ITEM
-- ----------------------------
INSERT INTO "TEAM"."ORDER_ITEM" VALUES ('17', '1', null, '1', '12.50', '1');
INSERT INTO "TEAM"."ORDER_ITEM" VALUES ('13', '1', '21', '1', '12.50', '1');
INSERT INTO "TEAM"."ORDER_ITEM" VALUES ('14', '2', '21', '1', '12.50', '1');
INSERT INTO "TEAM"."ORDER_ITEM" VALUES ('15', '1', '22', '1', '12.50', '2');
INSERT INTO "TEAM"."ORDER_ITEM" VALUES ('16', '2', '22', '1', '12.50', '2');

-- ----------------------------
-- Table structure for SEARCH
-- ----------------------------
DROP TABLE "TEAM"."SEARCH";
CREATE TABLE "TEAM"."SEARCH" (
"ID" NUMBER(20) NOT NULL ,
"KEYWORD" VARCHAR2(20 BYTE) NOT NULL ,
"CUSTOMER_ID" NUMBER(20) NOT NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of SEARCH
-- ----------------------------
INSERT INTO "TEAM"."SEARCH" VALUES ('26', 'bb', '1');
INSERT INTO "TEAM"."SEARCH" VALUES ('27', 'cc', '1');
INSERT INTO "TEAM"."SEARCH" VALUES ('25', 'aa', '1');

-- ----------------------------
-- Table structure for USER_ORDER
-- ----------------------------
DROP TABLE "TEAM"."USER_ORDER";
CREATE TABLE "TEAM"."USER_ORDER" (
"ID" NUMBER(20) NOT NULL ,
"ORDER_TIME" DATE NOT NULL ,
"AMOUNT" NUMBER(7,2) NOT NULL ,
"STATUS" VARCHAR2(10 BYTE) NOT NULL ,
"DELIVERY_TIME" DATE NOT NULL ,
"METHODS_OF_PAYMENT" VARCHAR2(10 BYTE) NOT NULL ,
"NOTES" VARCHAR2(100 BYTE) NULL ,
"IS_CANCELED" VARCHAR2(20 BYTE) NOT NULL ,
"CANCEL_REASON" VARCHAR2(100 BYTE) NULL ,
"DELIVERYMAN_ID" NUMBER(20) NULL ,
"CUSTOMER_ID" NUMBER(20) NULL ,
"DELETED" NUMBER(20) NULL 
)
LOGGING
NOCOMPRESS
NOCACHE

;

-- ----------------------------
-- Records of USER_ORDER
-- ----------------------------
INSERT INTO "TEAM"."USER_ORDER" VALUES ('6', TO_DATE('2019-11-22 14:55:02', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-11-22 14:55:02', 'YYYY-MM-DD HH24:MI:SS'), 'method1', null, '未取消', null, null, '1', '0');
INSERT INTO "TEAM"."USER_ORDER" VALUES ('7', TO_DATE('2019-11-22 16:21:45', 'YYYY-MM-DD HH24:MI:SS'), '100', '待接单', TO_DATE('2019-11-22 16:21:45', 'YYYY-MM-DD HH24:MI:SS'), 'methods', null, '未取消', null, null, '1', '0');
INSERT INTO "TEAM"."USER_ORDER" VALUES ('8', TO_DATE('2019-11-25 14:17:07', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-11-25 14:47:07', 'YYYY-MM-DD HH24:MI:SS'), 'method2', 'note2', '未取消', null, null, '2', '0');
INSERT INTO "TEAM"."USER_ORDER" VALUES ('9', TO_DATE('2019-11-22 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '300', '待付款', TO_DATE('2019-11-26 09:01:32', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, '0');
INSERT INTO "TEAM"."USER_ORDER" VALUES ('11', TO_DATE('2019-10-22 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-12-09 19:04:20', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('10', TO_DATE('2019-10-22 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '待接单', TO_DATE('2019-12-09 19:04:29', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('12', TO_DATE('2018-10-22 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-12-09 19:06:23', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('13', TO_DATE('2019-12-01 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-12-09 19:08:23', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('14', TO_DATE('2019-12-10 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-12-10 19:18:22', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('15', TO_DATE('2019-12-10 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '已取消', TO_DATE('2019-12-10 19:18:39', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '顾客', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('16', TO_DATE('2019-12-11 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '待收货', TO_DATE('2019-12-11 16:58:43', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '顾客', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('17', TO_DATE('2019-12-11 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '待发货', TO_DATE('2019-12-11 17:00:02', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '顾客', null, '1', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('18', TO_DATE('2019-12-12 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '待收货', TO_DATE('2019-12-12 10:19:42', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '催单', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('19', TO_DATE('2019-12-12 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '待发货', TO_DATE('2019-12-12 10:21:40', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '催单', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('20', TO_DATE('2019-12-18 14:40:30', 'YYYY-MM-DD HH24:MI:SS'), '100', '已完成', TO_DATE('2019-12-18 22:11:41', 'YYYY-MM-DD HH24:MI:SS'), 'methods3', null, '未取消', null, '3', null, null);
INSERT INTO "TEAM"."USER_ORDER" VALUES ('21', TO_DATE('2019-12-19 14:14:35', 'YYYY-MM-DD HH24:MI:SS'), '20', '待付款', TO_DATE('2019-12-19 14:44:35', 'YYYY-MM-DD HH24:MI:SS'), '支付宝', null, '未取消', null, null, '1', '0');
INSERT INTO "TEAM"."USER_ORDER" VALUES ('22', TO_DATE('2019-12-19 19:26:37', 'YYYY-MM-DD HH24:MI:SS'), '30', '待付款', TO_DATE('2019-12-19 19:56:37', 'YYYY-MM-DD HH24:MI:SS'), '支付宝', null, '未取消', null, null, '2', '0');

-- ----------------------------
-- Sequence structure for BUSINESS_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."BUSINESS_ID_SEQ";
CREATE SEQUENCE "TEAM"."BUSINESS_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 6
 NOCACHE ;

-- ----------------------------
-- Sequence structure for COLLECTION_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."COLLECTION_ID_SEQ";
CREATE SEQUENCE "TEAM"."COLLECTION_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 9
 NOCACHE ;

-- ----------------------------
-- Sequence structure for CUSTOMER_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."CUSTOMER_ID_SEQ";
CREATE SEQUENCE "TEAM"."CUSTOMER_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 14
 NOCACHE ;

-- ----------------------------
-- Sequence structure for DELIVERYMAN_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."DELIVERYMAN_ID_SEQ";
CREATE SEQUENCE "TEAM"."DELIVERYMAN_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 12
 NOCACHE ;

-- ----------------------------
-- Sequence structure for GOODS_CATEGORY_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."GOODS_CATEGORY_ID_SEQ";
CREATE SEQUENCE "TEAM"."GOODS_CATEGORY_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 1
 NOCACHE ;

-- ----------------------------
-- Sequence structure for GOODS_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."GOODS_ID_SEQ";
CREATE SEQUENCE "TEAM"."GOODS_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 5
 NOCACHE ;

-- ----------------------------
-- Sequence structure for ORDER_ITEM_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."ORDER_ITEM_ID_SEQ";
CREATE SEQUENCE "TEAM"."ORDER_ITEM_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 18
 NOCACHE ;

-- ----------------------------
-- Sequence structure for SEARCH_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."SEARCH_ID_SEQ";
CREATE SEQUENCE "TEAM"."SEARCH_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 28
 NOCACHE ;

-- ----------------------------
-- Sequence structure for USER_ORDER_ID_SEQ
-- ----------------------------
DROP SEQUENCE "TEAM"."USER_ORDER_ID_SEQ";
CREATE SEQUENCE "TEAM"."USER_ORDER_ID_SEQ"
 INCREMENT BY 1
 MINVALUE 1
 MAXVALUE 9999999999999999999999999999
 START WITH 23
 NOCACHE ;

-- ----------------------------
-- Indexes structure for table BUSINESS
-- ----------------------------

-- ----------------------------
-- Checks structure for table BUSINESS
-- ----------------------------
ALTER TABLE "TEAM"."BUSINESS" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."BUSINESS" ADD CHECK ("ACCOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."BUSINESS" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "TEAM"."BUSINESS" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."BUSINESS" ADD CHECK ("ACCOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."BUSINESS" ADD CHECK ("PASSWORD" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table BUSINESS
-- ----------------------------
ALTER TABLE "TEAM"."BUSINESS" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table COLLECTION
-- ----------------------------

-- ----------------------------
-- Checks structure for table COLLECTION
-- ----------------------------
ALTER TABLE "TEAM"."COLLECTION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."COLLECTION" ADD CHECK ("GOODS_ID" IS NOT NULL);
ALTER TABLE "TEAM"."COLLECTION" ADD CHECK ("CUSTOMER_ID" IS NOT NULL);
ALTER TABLE "TEAM"."COLLECTION" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."COLLECTION" ADD CHECK ("GOODS_ID" IS NOT NULL);
ALTER TABLE "TEAM"."COLLECTION" ADD CHECK ("CUSTOMER_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table COLLECTION
-- ----------------------------
ALTER TABLE "TEAM"."COLLECTION" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table CUSTOMER
-- ----------------------------

-- ----------------------------
-- Checks structure for table CUSTOMER
-- ----------------------------
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("ACCOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("HEAD_PORTRAIT" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("NICKNAME" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("ADDRESS" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("ACCOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("PASSWORD" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("HEAD_PORTRAIT" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("NICKNAME" IS NOT NULL);
ALTER TABLE "TEAM"."CUSTOMER" ADD CHECK ("ADDRESS" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table CUSTOMER
-- ----------------------------
ALTER TABLE "TEAM"."CUSTOMER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table DELIVERYMAN
-- ----------------------------

-- ----------------------------
-- Checks structure for table DELIVERYMAN
-- ----------------------------
ALTER TABLE "TEAM"."DELIVERYMAN" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."DELIVERYMAN" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEAM"."DELIVERYMAN" ADD CHECK ("PHONE_NUMBER" IS NOT NULL);
ALTER TABLE "TEAM"."DELIVERYMAN" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."DELIVERYMAN" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEAM"."DELIVERYMAN" ADD CHECK ("PHONE_NUMBER" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table DELIVERYMAN
-- ----------------------------
ALTER TABLE "TEAM"."DELIVERYMAN" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table GOODS
-- ----------------------------

-- ----------------------------
-- Checks structure for table GOODS
-- ----------------------------
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("PICTURE" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("PRICE" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("QUANTITY" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("PICTURE" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("PRICE" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS" ADD CHECK ("QUANTITY" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GOODS
-- ----------------------------
ALTER TABLE "TEAM"."GOODS" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table GOODS_CATEGORY
-- ----------------------------

-- ----------------------------
-- Checks structure for table GOODS_CATEGORY
-- ----------------------------
ALTER TABLE "TEAM"."GOODS_CATEGORY" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS_CATEGORY" ADD CHECK ("NAME" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS_CATEGORY" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."GOODS_CATEGORY" ADD CHECK ("NAME" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table GOODS_CATEGORY
-- ----------------------------
ALTER TABLE "TEAM"."GOODS_CATEGORY" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table ORDER_ITEM
-- ----------------------------

-- ----------------------------
-- Checks structure for table ORDER_ITEM
-- ----------------------------
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("GOODS_ID" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("QUANTITY" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("AMOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("CUSTOMER_ID" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("GOODS_ID" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("QUANTITY" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("AMOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."ORDER_ITEM" ADD CHECK ("CUSTOMER_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table ORDER_ITEM
-- ----------------------------
ALTER TABLE "TEAM"."ORDER_ITEM" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table SEARCH
-- ----------------------------

-- ----------------------------
-- Checks structure for table SEARCH
-- ----------------------------
ALTER TABLE "TEAM"."SEARCH" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."SEARCH" ADD CHECK ("KEYWORD" IS NOT NULL);
ALTER TABLE "TEAM"."SEARCH" ADD CHECK ("CUSTOMER_ID" IS NOT NULL);
ALTER TABLE "TEAM"."SEARCH" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."SEARCH" ADD CHECK ("KEYWORD" IS NOT NULL);
ALTER TABLE "TEAM"."SEARCH" ADD CHECK ("CUSTOMER_ID" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table SEARCH
-- ----------------------------
ALTER TABLE "TEAM"."SEARCH" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Indexes structure for table USER_ORDER
-- ----------------------------

-- ----------------------------
-- Checks structure for table USER_ORDER
-- ----------------------------
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("ORDER_TIME" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("AMOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("DELIVERY_TIME" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("METHODS_OF_PAYMENT" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("IS_CANCELED" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("ID" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("ORDER_TIME" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("AMOUNT" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("STATUS" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("DELIVERY_TIME" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("METHODS_OF_PAYMENT" IS NOT NULL);
ALTER TABLE "TEAM"."USER_ORDER" ADD CHECK ("IS_CANCELED" IS NOT NULL);

-- ----------------------------
-- Primary Key structure for table USER_ORDER
-- ----------------------------
ALTER TABLE "TEAM"."USER_ORDER" ADD PRIMARY KEY ("ID");

-- ----------------------------
-- Foreign Key structure for table "TEAM"."COLLECTION"
-- ----------------------------
ALTER TABLE "TEAM"."COLLECTION" ADD FOREIGN KEY ("CUSTOMER_ID") REFERENCES "TEAM"."CUSTOMER" ("ID");
ALTER TABLE "TEAM"."COLLECTION" ADD FOREIGN KEY ("GOODS_ID") REFERENCES "TEAM"."GOODS" ("ID");

-- ----------------------------
-- Foreign Key structure for table "TEAM"."GOODS"
-- ----------------------------
ALTER TABLE "TEAM"."GOODS" ADD FOREIGN KEY ("CATEGORY_ID") REFERENCES "TEAM"."GOODS_CATEGORY" ("ID");

-- ----------------------------
-- Foreign Key structure for table "TEAM"."ORDER_ITEM"
-- ----------------------------
ALTER TABLE "TEAM"."ORDER_ITEM" ADD FOREIGN KEY ("GOODS_ID") REFERENCES "TEAM"."GOODS" ("ID");
ALTER TABLE "TEAM"."ORDER_ITEM" ADD FOREIGN KEY ("ORDER_ID") REFERENCES "TEAM"."USER_ORDER" ("ID");

-- ----------------------------
-- Foreign Key structure for table "TEAM"."SEARCH"
-- ----------------------------
ALTER TABLE "TEAM"."SEARCH" ADD FOREIGN KEY ("CUSTOMER_ID") REFERENCES "TEAM"."CUSTOMER" ("ID");

-- ----------------------------
-- Foreign Key structure for table "TEAM"."USER_ORDER"
-- ----------------------------
ALTER TABLE "TEAM"."USER_ORDER" ADD FOREIGN KEY ("CUSTOMER_ID") REFERENCES "TEAM"."CUSTOMER" ("ID");
ALTER TABLE "TEAM"."USER_ORDER" ADD FOREIGN KEY ("DELIVERYMAN_ID") REFERENCES "TEAM"."DELIVERYMAN" ("ID");
