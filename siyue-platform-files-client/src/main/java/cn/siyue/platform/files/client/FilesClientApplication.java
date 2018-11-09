/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import javax.servlet.MultipartConfigElement;

/**
 * 文件管理服务消费的应用
 */
@EnableCircuitBreaker
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"cn.siyue.platform.*"})
public class FilesClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(FilesClientApplication.class);
  }

}
