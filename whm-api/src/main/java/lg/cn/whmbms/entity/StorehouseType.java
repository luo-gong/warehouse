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
@ApiModel(value="StorehouseType对象", description="")
public class StorehouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库位类型表id")
    @TableId(value = "storehouse_type_id", type = IdType.AUTO)
    private Integer storehouseTypeId;

    @ApiModelProperty(value = "库位类型名称 1正式库区 2.待入库区  3.待检库区 4.待出库区")
    @TableField("storehouse_type_name")
    private String storehouseTypeName;


}
