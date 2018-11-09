/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.server.controller;

import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.files.server.constants.UpyunConstants;
import cn.siyue.platform.files.server.service.impl.SiyueFilesService;

/**
 * 斯越里收货地址管理类
 */
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
  @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
  public ResponseData fileUpload(@RequestPart(value = "file")MultipartFile multipartFile) throws Exception{
    if(multipartFile.isEmpty()){
      return null;
    }
    return siyueFilesService.upyunUploadFile(multipartFile);
  }

}
