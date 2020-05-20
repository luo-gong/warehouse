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
@ApiModel(value = "Movewarehouse对象", description = "")
public class Movewarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "移库表id")
    @TableId(value = "movewarehouse_id", type = IdType.AUTO)
    private Integer movewarehouseId;

    @ApiModelProperty(value = "移库单号")
    @TableField("movewarehouse_code")
    private String movewarehouseCode;

    @ApiModelProperty(value = "移库类型id")
    @TableField("movewarehouse_type_id")
    private Integer movewarehouseTypeId;

    @ApiModelProperty(value = "订单表id")
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

    @ApiModelProperty(value = "原仓库id")
    @TableField("warehouse_start_id")
    private Integer warehouseStartId;

    @ApiModelProperty(value = "原仓库名称")
    @TableField("warehouse_start_name")
    private String warehouseStartName;

    @ApiModelProperty(value = "原库位id")
    @TableField("storehouse_start_id")
    private Integer storehouseStartId;

    @ApiModelProperty(value = "原库位名称")
    @TableField("storehouse_start_name")
    private String storehouseStartName;

    @ApiModelProperty(value = "新仓库id")
    @TableField("warehouse_new_id")
    private Integer warehouseNewId;

    @ApiModelProperty(value = "新仓库名称")
    @TableField("warehouse_new_name")
    private String warehouseNewName;

    @ApiModelProperty(value = "新库位id")
    @TableField("storehouse_new_id")
    private Integer storehouseNewId;

    @ApiModelProperty(value = "新库位名称")
    @TableField("storehouse_new_name")
    private String storehouseNewName;

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


}
