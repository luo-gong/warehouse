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
@ApiModel(value="Equipment对象", description="")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备表id")
    @TableId(value = "equipment_id", type = IdType.AUTO)
    private Integer equipmentId;

    @ApiModelProperty(value = "设备编号")
    @TableField("equipment_code")
    private String equipmentCode;

    @ApiModelProperty(value = "设备名称")
    @TableField("equipment_name")
    private String equipmentName;

    @ApiModelProperty(value = "是否授权 0未授权 1已授权")
    @TableField("equipment_isAuthorization")
    private Integer equipmentIsauthorization;

    @ApiModelProperty(value = "授权标识符")
    @TableField("equipment_authorizationIdentifier")
    private String equipmentAuthorizationidentifier;

    @ApiModelProperty(value = "状态 1闲置 2正在使用")
    @TableField("equipment_state")
    private Integer equipmentState;

    @ApiModelProperty(value = "是否删除  0未删除 1已删除")
    @TableField("equipment_isDelete")
    private Integer equipmentIsdelete;

    @ApiModelProperty(value = "备注")
    @TableField("equipment_remarks")
    private String equipmentRemarks;


}
