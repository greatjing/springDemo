create DATABASE /*!32312 IF NOT EXISTS*/ `spring` /*!40100 default character SET utf8 */;

use `spring`;
DROP TABLE IF EXISTS `demo_resource`;

CREATE table `demo_resource`(
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
	`name` varchar(20)   DEFAULT NULL COMMENT '简称',
	`title` varchar(100) DEFAULT NULL COMMENT '标题',
	`url` varchar(100)   DEFAULT NULL COMMENT '地址',
	primary key(`id`)
)ENGINE=MyISAM AUTO_INCREMENT=1029 DEFAULT CHARSET=utf8;

INSERT INTO `demo_resource`(`id`, `name`, `title`, `url`) VALUES (999,'qq',  '腾讯测试平台', 'http://utest.qq.com/');
INSERT INTO `demo_resource`(`id`, `name`, `title`, `url`) VALUES (999,'alibaba',  '阿里测试平台', 'http://mqc.aliyun.com/');
INSERT INTO `demo_resource`(`id`, `name`, `title`, `url`) VALUES (999,'baidu',  '百度测试平台', 'http://mtc.baidu.com/');