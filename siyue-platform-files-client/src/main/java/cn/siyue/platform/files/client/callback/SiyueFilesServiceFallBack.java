/*
 * (C) Copyright 2018 Siyue Holding Group.
 */
package cn.siyue.platform.files.client.callback;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.files.client.service.SiyueFilesService;

@Component
public class SiyueFilesServiceFallBack implements SiyueFilesService {

  @Override public ResponseData handleFileUpload(MultipartFile file) {
    return ResponseData.build(ResponseBackCode.ERROR_DOWNGRADE.getValue(),
                              ResponseBackCode.ERROR_DOWNGRADE.getMessage());
  }
}
