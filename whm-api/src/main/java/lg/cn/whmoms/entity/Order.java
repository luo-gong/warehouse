package lg.cn.whmoms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

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
@ApiModel(value = "Order对象", description = "")
@TableName(value = "order_")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单表id")
    @TableId(value = "order_id", type = IdType.AUTO)
    private Integer orderId;

    @ApiModelProperty(value = "订单编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "订单产品数量")
    @TableField("order_number")
    private Integer orderNumber;

    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    private Integer productId;

    @ApiModelProperty(value = "产品单价")
    @TableField("product_price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "产品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "产品批次")
    @TableField("product_batch")
    private String productBatch;

    @ApiModelProperty(value = "产品编号")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty(value = "商品规格")
    @TableField("product_spec")
    private String productSpec;

    @ApiModelProperty(value = "该商品的总额")
    @TableField("order_product_price_sum")
    private BigDecimal orderProductPriceSum;

    @ApiModelProperty(value = "订单总金额")
    @TableField("order_price_sum")
    private BigDecimal orderPriceSum;

    @ApiModelProperty(value = "供应商id")
    @TableField("supplier_id")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商名称")
    @TableField("supplier_companyName")
    private String supplierCompanyname;

    @ApiModelProperty(value = "供应商编号")
    @TableField("supplier_code")
    private String supplierCode;

    @ApiModelProperty(value = "订单是否支付  0 未支付  1.已支付")
    @TableField("order_isPayment")
    private Integer orderIspayment;

    @ApiModelProperty(value = "订单状态，产品是否入库  1.全部入库，2.部分入库，4.采购中，6.全部出货，7.部分出货 ，6.出货中，7.订单取消 8.订单确认")
    @TableField("order_state")
    private Integer orderState;

    @ApiModelProperty(value = "出库数量")
    @TableField("order_outlibrary")
    private Integer orderOutlibrary;

    @ApiModelProperty(value = "制单人")
    @TableField("order_createuser")
    private String orderCreateuser;

    @ApiModelProperty(value = "制单时间")
    @TableField("order_createtime")
    private Date orderCreatetime;

    @ApiModelProperty(value = " 是否退货 0为没有 1为退货")
    @TableField("order_isreturngoods")
    private Integer orderIsreturngoods;

    @ApiModelProperty(value = "审核状态  1待审核 2审核成功 3.审核失败")
    @TableField("order_auditor_state")
    private Integer orderAuditorState;

    @ApiModelProperty(value = "审核人")
    @TableField("order_auditor")
    private String orderAuditor;

    @ApiModelProperty(value = "审核时间")
    @TableField("order_auditor_time")
    private Date orderAuditorTime;

    @ApiModelProperty(value = "库位id")
    @TableField("storehouse_id")
    private Integer storehouseId;

    @ApiModelProperty(value = "库位名称")
    @TableField("storehouse_name")
    private String storehouseName;


    @ApiModelProperty(value = "客户id")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty(value = "客户编号")
    @TableField("customer_code")
    private String customerCode;

    @ApiModelProperty(value = "客户名称")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty(value = "客户联系人")
    @TableField("customer_contactName")
    private String customerContactName;

    @ApiModelProperty(value = "客户联系方式")
    @TableField("customer_phone")
    private String customerPhone;


}
