package cn.siyue.platform.files.pojo;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * <p>
 * 文件表
 * </p>
 *
 * @author Sipin ERP Development Team
 */
@Data
@Accessors(chain = true)
@TableName("siyue_files")
public class SiyueFiles extends Model<SiyueFiles> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 文件格式
     */
    @TableField("file_type")
    private String fileType;

    /**
     * 文件大小
     */
    @TableField("file_size")
    private Long fileSize;
    /**
     * 存储地址url
     */
    private String url;

    /**
     * 上传人的用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 文件密钥
     */
    @TableField("file_secret")
    private String fileSecret;

    /**
     * 创建时间
     */
    @TableField("create_at")
    private LocalDateTime createAt;
    /**
     * 上传服务平台
     */
    @TableField("upload_platform")
    private String uploadPlatform;
    /**
     * 斯越平台
     */
    private String platform;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
