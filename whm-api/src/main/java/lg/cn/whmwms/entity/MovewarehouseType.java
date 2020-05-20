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
@ApiModel(value="MovewarehouseType对象", description="")
public class MovewarehouseType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "移库类型表id")
    @TableId(value = "movewarehouse_type_id", type = IdType.AUTO)
    private Integer movewarehouseTypeId;

    @ApiModelProperty(value = "移库类型 1.衣库上架 2.仓库移库 3.报损移库")
    @TableField("movewarehouse_type_name")
    private String movewarehouseTypeName;


}
