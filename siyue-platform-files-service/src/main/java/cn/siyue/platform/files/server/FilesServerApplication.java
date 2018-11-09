/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

import cn.siyue.platform.files.server.config.UpyunConfig;

/**
 * 文件管理服务入口类
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.siyue.platform.*"})
@MapperScan("cn.siyue.platform.files.server*")
public class FilesServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(FilesServerApplication.class);
  }

}
