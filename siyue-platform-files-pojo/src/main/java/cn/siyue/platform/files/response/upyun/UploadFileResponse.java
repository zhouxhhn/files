/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.response.upyun;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UploadFileResponse {

  @ApiModelProperty(value = "上传url")
  private String url;

  @ApiModelProperty(value = "文件密钥")
  private String secret;

}
