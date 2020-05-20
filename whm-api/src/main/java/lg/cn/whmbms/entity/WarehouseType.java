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
@ApiModel(value="WarehouseType对象", description="")
public class WarehouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库类型表id")
    @TableId(value = "warehouse_type_id", type = IdType.AUTO)
    private Integer warehouseTypeId;

    @ApiModelProperty(value = "仓库类型名称")
    @TableField("warehouse_type_name")
    private String warehouseTypeName;


}
