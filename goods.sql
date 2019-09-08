create database goods;

-- -- 使用数据库
use goods;

-- -- 设置编码
SET NAMES utf8;

-- -- user 用户表
-- -- id 用户id
-- -- username 用户名
-- -- password 密码
-- -- balance 余额 
create table user
(
	id int AUTO_INCREMENT primary key,
	username varchar(32) not null unique,
	password varchar(32) not null,
	balance float
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -- product 产品表
-- -- id 产品id
-- -- name 产品名称
-- -- price 产品价格
-- -- count 库存
-- -- specifications 规格参数
-- -- info 产品信息
-- -- image 图片地址
create table product
(
	id int AUTO_INCREMENT primary key,
	name varchar(32) not null,
	price float,
	count int,
	specifications varchar(255) not null,
	info  varchar(255) not null,
	image varchar(128) not null,
	image1 varchar(128) not null
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into user (username,password,balance) VALUES ('root', '123', 1200);

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 001', 234, 998,'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距',
'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距','images/110.jpg','images/001.jpg');

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 002', 123, 100,'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距',
'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距','images/22.jpg','images/002.jpg');

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 003', 456, 245,'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距',
'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距','images/33.jpg','images/003.jpg');

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 004', 789, 778,'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距',
'产品用户使用手册参数： 小车的长度、宽度、高度 使用的电源（供电方式、电压） 连接方式：蓝牙（频率、名称、密码） 轴距','images/44.jpg','images/004.jpg');
