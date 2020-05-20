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
@ApiModel(value="Bill对象", description="")
public class Bill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单据类型表id")
    @TableId(value = "bill_id", type = IdType.AUTO)
    private Integer billId;

    @ApiModelProperty(value = "单据类型名称  1.采购收货入库 2.销售退货入库 3.生产产品入库 4.领用退还入库  5.借货入库  6.借出还入 7.采购退货出库  8.销售出库 9领用出库10.借出出库")
    @TableField("bill_name")
    private String billName;


}
