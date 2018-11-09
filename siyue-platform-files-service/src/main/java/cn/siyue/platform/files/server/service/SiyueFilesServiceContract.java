package cn.siyue.platform.files.server.service;

import com.baomidou.mybatisplus.service.IService;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.files.pojo.SiyueFiles;

/**
 * <p>
 * 文件表 服务类
 * </p>
 *
 * @author Sipin ERP Development Team
 */
public interface SiyueFilesServiceContract extends IService<SiyueFiles> {

   /**
    * 上传文件
    */
   ResponseData upyunUploadFile(MultipartFile multipartFile) throws Exception;

}
