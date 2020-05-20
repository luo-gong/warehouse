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
@ApiModel(value="OrderAuditor对象", description="")
public class OrderAuditor implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "审核状态id")
    @TableId(value = "order_auditor_id", type = IdType.AUTO)
    private Integer orderAuditorId;

    @ApiModelProperty(value = "审核状态")
    @TableField("order_auditor_name")
    private String orderAuditorName;


}
