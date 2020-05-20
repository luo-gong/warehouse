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
@ApiModel(value="InwarehouseType对象", description="")
public class InwarehouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入库类型表id")
    @TableId(value = "inwarehouse_type_id", type = IdType.AUTO)
    private Integer inwarehouseTypeId;

    @ApiModelProperty(value = "入库单类型")
    @TableField("inwarehouse_type_name")
    private String inwarehouseTypeName;


}
