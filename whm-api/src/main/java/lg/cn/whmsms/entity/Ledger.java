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
@ApiModel(value = "Ledger对象", description = "")
public class Ledger implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库存台账表id")
    @TableId(value = "ledger_id", type = IdType.AUTO)
    @Excel(name = "库存台账表id")
    private Integer ledgerId;

    @ApiModelProperty(value = "类型（0出，1入）")
    @TableField("ledger_type")
    @Excel(name = "类型（0出，1入）", replace = {"出_0", "入_1"})
    private Integer ledgerType;

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

    @ApiModelProperty(value = "产品批次")
    @TableField("product_batch")
    @Excel(name = "产品批次")
    private String productBatch;

    @ApiModelProperty(value = "订单id")
    @TableField("order_id")
    @Excel(name = "订单id")
    private Integer orderId;

    @ApiModelProperty(value = "订单产品数量")
    @TableField("order_number")
    @Excel(name = "订单产品数量")
    private Integer orderNumber;

    @ApiModelProperty(value = "订单产品数量")
    @TableField("metering_id")
    @Excel(name = "订单产品数量")
    private Integer meteringId;

    @ApiModelProperty(value = "存储单位名称")
    @TableField("metering_id_name")
    @Excel(name = "存储单位名称")
    private String meteringIdName;

    @ApiModelProperty(value = "原仓库id")
    @TableField("warehouse_start_id")
    @Excel(name = "原仓库id")
    private Integer warehouseStartId;

    @ApiModelProperty(value = "原仓库名称")
    @TableField("warehouse_start_name")
    @Excel(name = "原仓库名称")
    private String warehouseStartName;

    @ApiModelProperty(value = "原库位id")
    @TableField("storehouse_start_id")
    @Excel(name = "原库位id")
    private Integer storehouseStartId;

    @ApiModelProperty(value = "原库位名称")
    @TableField("storehouse_start_name")
    @Excel(name = "原库位名称")
    private String storehouseStartName;

    @ApiModelProperty(value = "目标仓库id")
    @TableField("warehouse_end_id")
    @Excel(name = "目标仓库id")
    private Integer warehouseEndId;

    @ApiModelProperty(value = "目标仓库名称")
    @TableField("warehouse_end_name")
    @Excel(name = "目标仓库名称")
    private String warehouseEndName;

    @ApiModelProperty(value = "目标库位id")
    @TableField("storehouse_end_id")
    @Excel(name = "目标库位id")
    private Integer storehouseEndId;

    @ApiModelProperty(value = "目标库位名称")
    @TableField("storehouse_end_name")
    @Excel(name = "目标库位名称")
    private String storehouseEndName;

    @ApiModelProperty(value = "日期")
    @TableField("ledger_createtime")
    @Excel(name = "日期", format = "yyyy-MM-dd")
    private Date ledgerCreatetime;


}
