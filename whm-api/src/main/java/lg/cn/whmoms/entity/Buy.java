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
@ApiModel(value = "Buy对象", description = "")
public class Buy implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "采购表id")
    @TableId(value = "buy_Id", type = IdType.AUTO)
    private Integer buyId;

    @ApiModelProperty(value = "采购编号")
    @TableField("buy_code")
    private String buyCode;

    @ApiModelProperty(value = "单据类型id")
    @TableField("bill_id")
    private Integer billId;

    @ApiModelProperty(value = "单据类型名称")
    @TableField("bill_name")
    private String billName;

    @ApiModelProperty(value = "订单表id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单表编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "订单是否支付")
    @TableField("order_isPayment")
    private Integer orderIspayment;

    @ApiModelProperty(value = "是否退货 0为没有 1为退货")
    @TableField("order_isreturngoods")
    private Integer orderIsreturngoods;


    @ApiModelProperty(value = "订单产品数量")
    @TableField("order_number")
    private Integer orderNumber;

    @ApiModelProperty(value = "该商品的总额")
    @TableField("order_product_price_sum")
    private BigDecimal orderProductPriceSum;

    @ApiModelProperty(value = "订单总金额")
    @TableField("order_price_sum")
    private BigDecimal orderPriceSum;

    @ApiModelProperty(value = "订单状态1.全部入库，2.部分入库，4.采购中， 6.全部出货，7.部分出货 ，6.出货中，7.订单取消 8.订单确认")
    @TableField("order_state")
    private Integer orderState;

    @ApiModelProperty(value = "产品id")
    @TableField("product_id")
    private Integer productId;

    @ApiModelProperty(value = "产品编号")
    @TableField("product_code")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    @TableField("product_name")
    private String productName;

    @ApiModelProperty(value = "价格")
    @TableField("product_price")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "产品规格")
    @TableField("product_spec")
    private String productSpec;

    @ApiModelProperty(value = "存储单位  metering id")
    @TableField("metering_id_store")
    private Integer meteringIdStore;

    @ApiModelProperty(value = "供应商id")
    @TableField("supplier_id")
    private Integer supplierId;

    @ApiModelProperty(value = "供应商编号")
    @TableField("supplier_code")
    private String supplierCode;

    @ApiModelProperty(value = "供应商编号")
    @TableField("supplier_companyName")
    private String supplierCompanyname;

    @ApiModelProperty(value = "供应商联系人")
    @TableField("supplier_contactName")
    private String supplierContactname;

    @ApiModelProperty(value = "供应商电话")
    @TableField("supplier_phone")
    private String supplierPhone;

    @ApiModelProperty(value = "客户表id")
    @TableField("customer_id")
    private Integer customerId;

    @ApiModelProperty(value = "客户表名称")
    @TableField("customer_name")
    private String customerName;

    @ApiModelProperty(value = "收货日")
    @TableField("buy_income_time")
    private Date buyIncomeTime;

    @ApiModelProperty(value = "备注")
    @TableField("buy_remarks")
    private String buyRemarks;

    @ApiModelProperty(value = "制单人")
    @TableField("buy_createuser")
    private String buyCreateuser;

    @ApiModelProperty(value = "制单时间")
    @TableField("buy_createtime")
    private Date buyCreatetime;

    @ApiModelProperty(value = "订单审核状态")
    @TableField("order_auditor_id")
    private Integer orderAuditorId;


}
