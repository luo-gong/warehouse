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
@ApiModel(value = "ReturnSale对象", description = "")
public class ReturnSale implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售退货表id")
    @TableId(value = "return_sale_id", type = IdType.AUTO)
    private Integer returnSaleId;

    @ApiModelProperty(value = "销售退货单号")
    @TableField("return_sale_code")
    private String returnSaleCode;

    @ApiModelProperty(value = "销售编号")
    @TableField("sale_code")
    private String saleCode;

    @ApiModelProperty(value = "订单表id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单表编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "数量(退货数)")
    @TableField("order_number")
    private Integer orderNumber;

    @ApiModelProperty(value = "单商品总额")
    @TableField("order_product_price_sum")
    private BigDecimal orderProductPriceSum;

    @ApiModelProperty(value = "采购状态 1.全部入库，2.部分入库，4.采购中， 6.全部出货，7.部分出货 ，6.出货中，7.订单取消 8.订单确认 9创建订单")
    @TableField("order_state")
    private Integer orderState;

    @ApiModelProperty(value = "订单审核状态id")
    @TableField("order_auditor_id")
    private Integer orderAuditorId;

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

    @ApiModelProperty(value = "备注")
    @TableField("sale_remarks")
    private String saleRemarks;

    @ApiModelProperty(value = "制单人")
    @TableField("sale_createuser")
    private String saleCreateuser;

    @ApiModelProperty(value = "制单人")
    @TableField("return_sale_createtime")
    private Date returnSaleCreatetime;

    @ApiModelProperty(value = "是否删除  0未删除 1已删除")
    @TableField("return_sale_isDelete")
    private Integer returnSaleIsdelete;


}
