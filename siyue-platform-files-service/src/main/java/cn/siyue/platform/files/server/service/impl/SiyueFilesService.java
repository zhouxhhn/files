package cn.siyue.platform.files.server.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import cn.siyue.platform.base.ResponseData;
import cn.siyue.platform.constants.ResponseBackCode;
import cn.siyue.platform.files.response.upyun.UploadFileResponse;
import cn.siyue.platform.files.server.config.UpyunConfig;
import cn.siyue.platform.files.server.constants.UpyunConstants;
import cn.siyue.platform.files.pojo.SiyueFiles;
import cn.siyue.platform.files.server.mapper.SiyueFilesMapper;
import cn.siyue.platform.files.server.service.SiyueFilesServiceContract;
import main.java.com.UpYun;

/**
 * <p>
 * 文件表 服务实现类
 * </p>
 */
@Primary
@Service
public class SiyueFilesService extends ServiceImpl<SiyueFilesMapper, SiyueFiles> implements SiyueFilesServiceContract {

  private  SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

  private UpyunConfig upyunConfig;


  @Autowired
  public SiyueFilesService(UpyunConfig upyunConfig){
    this.upyunConfig = upyunConfig;
  }



  @Override
  public ResponseData upyunUploadFile(MultipartFile multipartFile) throws Exception {
    String fileName = multipartFile.getOriginalFilename();

    UpYun upyun = new UpYun(upyunConfig.getBucket_name(), upyunConfig.getOperator_name(), upyunConfig.getOperator_pwd());

    // 可选属性1，是否开启 debug 模式，默认不开启
    upyun.setDebug(false);


    String secret = generateCode(20);

    upyun.setFileSecret(secret);

    String savePath = generateFilePath(fileName==null?"":fileName);

    boolean result = upyun.writeFile(savePath, multipartFile.getBytes());
    Long size = multipartFile.getSize();

    if(result){

      //保存到数据库中
      SiyueFiles files = new SiyueFiles();
      files.setFileType(fileName.substring(fileName.lastIndexOf(".")+1));
      files.setFileSize(size);
      files.setUrl(savePath);
      files.setFileSecret(secret);
      files.setPlatform(upyunConfig.getPlatform());
      files.setUploadPlatform(upyunConfig.getUpload_platform());
      insert(files);

      UploadFileResponse response = new UploadFileResponse();
      response.setUrl(upyunConfig.getUrl()+savePath);
      response.setSecret(secret);
      return ResponseData.build(ResponseBackCode.SUCCESS.getValue(),
                                ResponseBackCode.SUCCESS.getMessage(), response);
    }else{
      return ResponseData.build(ResponseBackCode.ERROR_FAIL.getValue(),
                                ResponseBackCode.ERROR_FAIL.getMessage(), "上传失败");
    }
  }

  /**
   * 生成文件路径
   * @param fileName 附件名
   * @return 文件路径
   */
  private String generateFilePath(String fileName){
    Date d = new Date();
    String YearMonthDay = sdf.format(d);
    String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
    String randomPath = System.currentTimeMillis()+generateCode(20);
    return UpyunConstants.savePath+YearMonthDay+"/"+randomPath+"."+fileType;

  }

  private String generateCode(int length){
    String sources = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // 加上一些字母，就可以生成pc站的验证码了
    Random rand = new Random();
    StringBuffer flag = new StringBuffer();
    for (int j = 0; j < length; j++){
      flag.append(sources.charAt(rand.nextInt(42)) + "");
    }
    return flag.toString();
  }

}
