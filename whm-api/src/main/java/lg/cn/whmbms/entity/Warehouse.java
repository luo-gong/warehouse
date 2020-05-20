package lg.cn.whmbms.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
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
@ApiModel(value="Warehouse对象", description="")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库表id")
    @TableField("warehouse_id")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库编号")
    @TableField("warehouse_code")
    private String warehouseCode;

    @ApiModelProperty(value = "仓库名称")
    @TableField("warehouse_name")
    private String warehouseName;

    @ApiModelProperty(value = "租赁时间")
    @TableField("warehouse_leaseTime")
    private Date warehouseLeasetime;

    @ApiModelProperty(value = "仓库类型warehouse_type_id")
    @TableField("warehouse_type_id")
    private Integer warehouseTypeId;

    @ApiModelProperty(value = "所属部门warehouse_type_id")
    @TableField("department_id")
    private Integer departmentId;

    @ApiModelProperty(value = "是否禁用")
    @TableField("warehouse_isEnabled")
    private Integer warehouseIsenabled;

    @ApiModelProperty(value = "是否默认")
    @TableField("warehouse_isDefault")
    private Integer warehouseIsdefault;

    @ApiModelProperty(value = "仓库面积大小")
    @TableField("warehouse_areaSize")
    private Integer warehouseAreasize;

    @ApiModelProperty(value = "联系人")
    @TableField("warehouse_contacts")
    private String warehouseContacts;

    @ApiModelProperty(value = "电话")
    @TableField("warehouse_phone")
    private String warehousePhone;

    @ApiModelProperty(value = "仓库地址")
    @TableField("warehouse_adderss")
    private String warehouseAdderss;

    @ApiModelProperty(value = "仓库作用")
    @TableField("warehouse_effect")
    private String warehouseEffect;


}
