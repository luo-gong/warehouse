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
 * @since 2020-04-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ReturnGoods对象", description="")
public class ReturnGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "采购退货表id")
    @TableId(value = "return_goods_id", type = IdType.AUTO)
    private Integer returnGoodsId;

    @ApiModelProperty(value = "退货单号")
    @TableField("return_goods_code")
    private String returnGoodsCode;

    @ApiModelProperty(value = "是否删除  0 未删除 1已删除")
    @TableField("return_goods_isDelete")
    private String returnGoodsIsdelete;

    @ApiModelProperty(value = "创建时间")
    @TableField("return_goods_createTime")
    private Date returnGoodsCreatetime;

    @ApiModelProperty(value = "采购表id")
    @TableField("buy_Id")
    private Integer buyId;

    @ApiModelProperty(value = "采购编号")
    @TableField("buy_code")
    private String buyCode;

    @ApiModelProperty(value = "订单表id")
    @TableField("order_id")
    private Integer orderId;

    @ApiModelProperty(value = "订单表编号")
    @TableField("order_code")
    private String orderCode;

    @ApiModelProperty(value = "订单是否支付")
    @TableField("order_isPayment")
    private Integer orderIspayment;

    @ApiModelProperty(value = "退货数")
    @TableField("order_number")
    private Integer orderNumber;

    @ApiModelProperty(value = "总额")
    @TableField("order_product_price_sum")
    private BigDecimal orderProductPriceSum;

    @ApiModelProperty(value = "订单状态1.全部入库，2.部分入库，4.采购中， 6.全部出货，7.部分出货 ，6.出货中，7.订单取消 8.订单确认")
    @TableField("order_state")
    private Integer orderState;

    @ApiModelProperty(value = "订单审核状态")
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

    @ApiModelProperty(value = "供应商名称")
    @TableField("supplie_companyName")
    private String supplieCompanyname;


}
