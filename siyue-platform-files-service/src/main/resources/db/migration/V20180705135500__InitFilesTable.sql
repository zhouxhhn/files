drop TABLE  if exists siyue_files;
CREATE TABLE `siyue_files` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `file_type` varchar(50) DEFAULT NULL COMMENT '文件类型',
  `file_size` bigint(20) DEFAULT NULL COMMENT '文件大小',
  `url` varchar(250) DEFAULT NULL COMMENT '存储地址url',
  `user_id` bigint(20) DEFAULT NULL COMMENT '上传人的用户id',
  `file_secret` varchar(50) DEFAULT NULL COMMENT '文件密钥',
  `create_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `upload_platform` varchar(50) DEFAULT NULL COMMENT '上传服务平台',
  `platform` varchar(50) DEFAULT NULL COMMENT '斯越平台',
  PRIMARY KEY (`id`)
) COMMENT='文件表';







