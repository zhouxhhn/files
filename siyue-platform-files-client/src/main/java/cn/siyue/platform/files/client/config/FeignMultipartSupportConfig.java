/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.client.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class FeignMultipartSupportConfig {

  @Bean
  @Primary
  @Scope("prototype")
  public Encoder multipartFormEncoder() {
    return new SpringFormEncoder();
  }
}
