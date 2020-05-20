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
@ApiModel(value="Storehouse对象", description="")
public class Storehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库位表id")
    @TableId(value = "storehouse_id", type = IdType.AUTO)
    private Integer storehouseId;

    @ApiModelProperty(value = "库位编号")
    @TableField("storehouse_code")
    private String storehouseCode;

    @ApiModelProperty(value = "库位名称")
    @TableField("storehouse_name")
    private String storehouseName;

    @ApiModelProperty(value = "库位类型storehouse type_id")
    @TableField("storehouse_type_id")
    private Integer storehouseTypeId;

    @ApiModelProperty(value = "仓库id")
    @TableField("warehouse_id")
    private Integer warehouseId;

    @ApiModelProperty(value = "是否禁用")
    @TableField("storehouse_isEnabled")
    private Integer storehouseIsenabled;

    @ApiModelProperty(value = "是否删除 0未删除 1已删除")
    @TableField("storehouse_isDelete")
    private Integer storehouseIsdelete;

    @ApiModelProperty(value = "是否默认 0不是默认 1为默认")
    @TableField("storehouse_isDefault")
    private Integer storehouseIsdefault;

    @ApiModelProperty(value = "创建时间")
    @TableField("storehouse_careateDate")
    private Date storehouseCareatedate;

    @ApiModelProperty(value = "备注")
    @TableField("storehouse_remarks")
    private String storehouseRemarks;


}
