package lg.cn.whmbms.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author Lfy
 * @since 2020-04-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "Customer对象", description = "")
public class Customer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    @TableField("customer_code")
    private String customerCode;

    @TableField("customer_name")
    private String customerName;

    @TableField("customer_contactName")
    private String customerContactname;

    @TableField("customer_address")
    private String customerAddress;

    @TableField("customer_emailCode")
    private String customerEmailcode;

    @TableField("customer_phone")
    private String customerPhone;

    @TableField("customer_fax")
    private String customerFax;

    @TableField("customer_remarks")
    private String customerRemarks;

    @TableField("customer_createDate")
    private Date customerCreatedate;


}
