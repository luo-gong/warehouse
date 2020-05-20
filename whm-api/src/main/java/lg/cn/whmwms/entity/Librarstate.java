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
@ApiModel(value="Librarstate对象", description="")
public class Librarstate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "库单状态表id")
    @TableId(value = "librarstate_id", type = IdType.AUTO)
    private Integer librarstateId;

    @ApiModelProperty(value = "1待审核 2审核成功 3.审核失败")
    @TableField("librarstate_name")
    private String librarstateName;


}
