package lg.cn.whmbms.entity;


import java.math.BigDecimal;

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
@ApiModel(value = "Product对象", description = "")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品id")
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    @ApiModelProperty(value = "产品编号")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "厂商编码")
    @TableField("product_manufacturerCode")
    private String productManufacturercode;

    @ApiModelProperty(value = "内部编码")
    @TableField("product_insideCode")
    private String productInsidecode;

    @ApiModelProperty(value = "产品规格")
    @TableField("product_spec")
    private String productSpec;

    @ApiModelProperty(value = "产品类别  ProductType id")
    @TableField("product_type_id")
    private String productTypeId;

    @ApiModelProperty(value = "存储单位  metering id")
    @TableField("metering_id_store")
    private Integer meteringIdStore;

    @ApiModelProperty(value = "上限")
    @TableField("product_upperLimit")
    private Integer productUpperlimit;

    @ApiModelProperty(value = "下限")
    @TableField("product_downlimit")
    private Integer productDownlimit;

    @ApiModelProperty(value = "包装类型")
    @TableField("product_packagingType")
    private String productPackagingtype;

    @ApiModelProperty(value = "价格")
    @TableField("product_price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "重量")
    @TableField("product_weight")
    private BigDecimal productWeight;

    @ApiModelProperty(value = "重量单位")
    @TableField("metering_id_weight")
    private Integer meteringIdWeight;

    @ApiModelProperty(value = "默认供应商")
    @TableField("supplier_id")
    private Integer supplierId;

    @ApiModelProperty(value = "默认客户")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty(value = "备注")
    @TableField("product_remarks")
    private String productRemarks;

    @ApiModelProperty(value = "是否删除  0未删除 1已删除")
    @TableField("product_isDelete")
    private Integer productIsdelete;

    @ApiModelProperty(value = "批次")
    @TableField("product_batch")
    private String productBatch;

}
