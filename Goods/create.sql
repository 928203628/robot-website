-- -- �������ݿ�goods
create database goods;

-- -- ʹ�����ݿ�
use goods;

-- -- ���ñ���
SET NAMES utf8;

-- -- user �û���
-- -- id �û�id
-- -- username �û���
-- -- password ����
-- -- balance ��� 
create table user
(
	id int AUTO_INCREMENT primary key,
	username varchar(32) not null unique,
	password varchar(32) not null,
	balance float
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- -- product ��Ʒ��
-- -- id ��Ʒid
-- -- name ��Ʒ����
-- -- price ��Ʒ�۸�
-- -- count ���
-- -- specifications ������
-- -- info ��Ʒ��Ϣ
-- -- image ͼƬ��ַ
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

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 001', 234, 998,'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���',
'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���','images/110.jpg','images/001.jpg');

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 002', 123, 100,'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���',
'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���','images/22.jpg','images/002.jpg');

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 003', 456, 245,'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���',
'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���','images/33.jpg','images/003.jpg');

insert into product (name,price,count,specifications,info,image,image1) VALUES ('Robot 004', 789, 778,'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���',
'��Ʒ�û�ʹ���ֲ������ С���ĳ��ȡ���ȡ��߶� ʹ�õĵ�Դ�����緽ʽ����ѹ�� ���ӷ�ʽ��������Ƶ�ʡ����ơ����룩 ���','images/44.jpg','images/004.jpg');
