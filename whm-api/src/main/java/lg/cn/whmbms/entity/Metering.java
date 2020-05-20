package lg.cn.whmbms.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Metering对象", description="")
public class Metering implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "计量单位id")
    @TableId(value = "metering_id", type = IdType.AUTO)
    private Integer meteringId;

    @ApiModelProperty(value = "单位编号")
    @TableField("metering_code")
    private String meteringCode;

    @ApiModelProperty(value = "单位名称")
    @TableField("metering_name")
    private String meteringName;

    @ApiModelProperty(value = "备注")
    @TableField("metering_remarks")
    private String meteringRemarks;


}
