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
import java.math.BigDecimal;
import java.sql.Date;

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
@ApiModel(value = "Inwarehouse对象", description = "")
public class Inwarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "入库表id")
    @TableId(value = "inwarehouse_id", type = IdType.AUTO)
    private Integer inwarehouseId;

    @ApiModelProperty(value = "入库单号")
    @TableField("inwarehouse_code")
    private String inwarehouseCode;

    @ApiModelProperty(value = "入库类型")
    @TableField("inwarehouse_type_id")
    private Integer inwarehouseTypeId;

    @ApiModelProperty(value = "是否删除 0未删除 1已删除")
    @TableField("inwarehouse_isDelete")
    private Integer inwarehouseIsdelete;

    @ApiModelProperty(value = "库位表id")
    @TableField("storehouse_id")
    private Integer storehouseId;

    @ApiModelProperty(value = "库位名称")
    @TableField("storehouse_name")
    private String storehouseName;

    @ApiModelProperty(value = "订单id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "制单人")
    @TableField("order_createuser")
    private String orderCreateuser;

    @ApiModelProperty(value = "制单时间")
    @TableField("order_createtime")
    private Date orderCreatetime;

    @ApiModelProperty(value = "备注")
    @TableField("order_remarks")
    private String orderRemarks;

    @ApiModelProperty(value = "订单产品数量")
    @TableField("order_number")
    private Integer orderNumber;

    @ApiModelProperty(value = "审核状态  1待审核 2审核成功 3.审核失败")
    @TableField("order_auditor_state")
    private Integer orderAuditorState;

    @ApiModelProperty(value = "审核人")
    @TableField("order_auditor")
    private String orderAuditor;

    @ApiModelProperty(value = "审核时间")
    @TableField("order_auditor_time")
    private Date orderAuditorTime;

    @ApiModelProperty(value = "该商品的总额")
    @TableField("order_product_price_sum")
    private BigDecimal orderProductPriceSum;

    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    private Integer productId;

    @ApiModelProperty(value = "产品编号")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "商品批次")
    @TableField("product_batch")
    private String productBatch;

    @ApiModelProperty(value = "产品规格")
    @TableField("product_spec")
    private String productSpec;

    @ApiModelProperty(value = "产品单价")
    @TableField("product_price")
    private BigDecimal productPrice;


    @ApiModelProperty(value = "供应商id")
    @TableField("supplier_id")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称")
    @TableField("supplier_companyName")
    private String supplierCompanyname;

    @ApiModelProperty(value = "供应商编号")
    @TableField("supplier_code")
    private String supplierCode;

    @ApiModelProperty(value = "供应商联系人")
    @TableField("supplier_contactName")
    private String supplierContactname;

    @ApiModelProperty(value = "供应商电话")
    @TableField("supplier_phone")
    private String supplierPhone;


}
