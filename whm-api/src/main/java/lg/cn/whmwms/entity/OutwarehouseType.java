package lg.cn.whmwms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Lfy
 * @since 2020-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OutwarehouseType对象", description="")
public class OutwarehouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "出库类型表id")
    @TableId(value = "outwarehouse_type_id", type = IdType.AUTO)
    private Integer outwarehouseTypeId;

    @ApiModelProperty(value = "出库类型 1 销售提货出库 2.采购退货出库 3.。。。")
    @TableField("outwarehouse_type_name")
    private String outwarehouseTypeName;


}
