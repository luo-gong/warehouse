package lg.cn.whmsms.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
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
@ApiModel(value = "Stock对象", description = "")

public class Stock implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存清单表id")
    @TableId(value = "stock_id", type = IdType.AUTO)
    @Excel(name = "库存清单表id")
    private Integer stockId;

    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    @Excel(name = "产品id")
    private Integer productId;

    @ApiModelProperty(value = "产品编号")
    @TableField("product_code")
    @Excel(name = "产品编号")
    private String productCode;

    @ApiModelProperty(value = "产品名称")
    @TableField("product_name")
    @Excel(name = "产品名称")
    private String productName;

    @ApiModelProperty(value = "产品规格")
    @TableField("product_spec")
    @Excel(name = "产品规格")
    private String productSpec;

    @ApiModelProperty(value = "产品类别id")
    @TableField("product_type_id")
    @Excel(name = "产品类别id")
    private Integer productTypeId;

    @ApiModelProperty(value = "产品类型名称")
    @TableField("product_type_name")
    @Excel(name = "产品类型名称")
    private String productTypeName;

    @ApiModelProperty(value = "产品批次")
    @TableField("product_batch")
    @Excel(name = "产品批次")
    private String productBatch;

    @ApiModelProperty(value = "存储单位id")
    @TableField("metering_id")
    @Excel(name = "存储单位id")
    private Integer meteringId;

    @ApiModelProperty(value = "存储单位名称")
    @TableField("metering_name")
    @Excel(name = "存储单位名称")
    private String meteringName;

    @ApiModelProperty(value = "库位id")
    @TableField("storehouse_id")
    @Excel(name = "库存id")
    private Integer storehouseId;

    @ApiModelProperty(value = "库位名称")
    @TableField("storehouse_name")
    @Excel(name = "库位名称")
    private String storehouseName;

    @ApiModelProperty(value = "仓库id")
    @TableField("warehouse_id")
    @Excel(name = "库存id")
    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称")
    @TableField("warehouse_name")
    @Excel(name = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "库存量")
    @TableField("stock_number")
    @Excel(name = "库存量")
    private Integer stockNumber;
}
