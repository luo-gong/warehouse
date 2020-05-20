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
@ApiModel(value="ProductType对象", description="")
public class ProductType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_type_id", type = IdType.AUTO)
    private Integer productTypeId;

    @TableField("product_type_code")
    private String productTypeCode;

    @TableField("product_type_name")
    private String productTypeName;

    @TableField("product_type_level")
    private Integer productTypeLevel;

    @TableField("product_type_parentid")
    private Integer productTypeParentid;

    @TableField("product_type_careateDate")
    private Date productTypeCareatedate;

    @TableField("product_type_remarks")
    private String productTypeRemarks;


}
