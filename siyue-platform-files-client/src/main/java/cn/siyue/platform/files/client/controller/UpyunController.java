/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.files.client.service.SiyueFilesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 斯越里收货地址管理类
 */
@Api(tags = "斯越_文件管理接口")
@RequestMapping(path = "/siyue/files", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class UpyunController {

  private SiyueFilesService siyueFilesService;

  @Autowired
  public UpyunController(SiyueFilesService siyueFilesService){
    this.siyueFilesService = siyueFilesService;
  }

  /*
   * 上传文件
   */
  /*
   * 新增等级
   */
  @ApiOperation(nickname = "upyunFileUpload",value = "上传文件接口")
  @PostMapping("/fileUpload")
  public ResponseData fileUpload(@RequestParam("file") MultipartFile multipartFile) {
    if(multipartFile.isEmpty()){
      return null;
    }
    return siyueFilesService.handleFileUpload(multipartFile);
  }
}
