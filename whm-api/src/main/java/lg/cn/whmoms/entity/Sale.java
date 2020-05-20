package lg.cn.whmoms.entity;

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
@ApiModel(value = "Sale对象", description = "")
public class Sale implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售表id")
    @TableId(value = "sale_id", type = IdType.AUTO)
    private Integer saleId;

    @ApiModelProperty(value = "销售编号")
    @TableField("sale_code")
    private String saleCode;

    @ApiModelProperty(value = "出库数")
    @TableField("sale_number")
    private Integer saleNumber;

    @ApiModelProperty(value = "订单表id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单表编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "订单是否支付")
    @TableField("order_isPayment")
    private Integer orderIsPayment;

    @ApiModelProperty(value = "数量")
    @TableField("order_number")
    private Integer orderNumber;

    @ApiModelProperty(value = "单商品总额")
    @TableField("order_product_price_sum")
    private BigDecimal orderProductPriceSum;

    @ApiModelProperty(value = "订单总金额")
    @TableField("order_price_sum")
    private BigDecimal orderPriceSum;

    @ApiModelProperty(value = "采购状态 1.全部入库，2.部分入库，4.采购中， 6.全部出货，7.部分出货 ，6.出货中，7.订单取消 8.订单确认")
    @TableField("order_state")
    private Integer orderState;

    @ApiModelProperty(value = "单据类型id")
    @TableField("bill_id")
    private Integer billId;

    @ApiModelProperty(value = "单据类型名称")
    @TableField("bill_name")
    private String billName;

    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    private Integer productId;

    @ApiModelProperty(value = "产品编号")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "产品规格")
    @TableField("product_spec")
    private String productSpec;

    @ApiModelProperty(value = "价格")
    @TableField("product_price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "单位  metering id")
    @TableField("metering_id")
    private Integer meteringId;

    @ApiModelProperty(value = "客户id")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty(value = "客户编号")
    @TableField("customer_code")
    private String customerCode;

    @ApiModelProperty(value = "客户表名称")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty(value = "电话号码")
    @TableField("customer_phone")
    private String customerPhone;

    @ApiModelProperty(value = "联系人")
    @TableField("customer_contactName")
    private String customerContactname;

    @ApiModelProperty(value = "收货日")
    @TableField("sale_income_time")
    private Date saleIncomeTime;

    @ApiModelProperty(value = "备注")
    @TableField("sale_remarks")
    private String saleRemarks;

    @ApiModelProperty(value = "制单人")
    @TableField("sale_createuser")
    private String saleCreateuser;

    @ApiModelProperty(value = "制单时间")
    @TableField("sale_createtime")
    private Date saleCreatetime;

    @ApiModelProperty(value = "订单审核id")
    @TableField("order_auditor_id")
    private Integer orderAuditorId;

}
