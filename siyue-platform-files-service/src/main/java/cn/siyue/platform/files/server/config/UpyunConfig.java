/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.server.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Primary
@ConfigurationProperties(prefix = "files.upyun")
@Data
public class UpyunConfig {


  /**
   * 空间名
   */
  private String bucket_name;

  /**
   * 名称
   */
  private String operator_name;

  /**
   * 密码
   */
  private String operator_pwd;


  /**
   * 域名url
   */
  private String url;

  /**
   * 上传服务平台
   */
  private String upload_platform;

  /**
   * 斯越平台
   */
  private String platform;

  /**
   * 临时存放文件
   */
  private String temp_file_path;



}
