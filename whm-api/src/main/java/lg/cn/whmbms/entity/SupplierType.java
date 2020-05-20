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
@ApiModel(value="SupplierType对象", description="")
public class SupplierType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "供应商类型表id")
    @TableId(value = "supplier_type_id", type = IdType.AUTO)
    private Integer supplierTypeId;

    @ApiModelProperty(value = "供应商类型  0.合作供应商 1.虚拟合作商")
    @TableField("supplier_name")
    private String supplierName;


}
