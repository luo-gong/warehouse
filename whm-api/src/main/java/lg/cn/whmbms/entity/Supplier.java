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
@ApiModel(value="Supplier对象", description="")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "供应商表id")
    @TableId(value = "supplier_id", type = IdType.AUTO)
    private Integer supplierId;

    @ApiModelProperty(value = "供应商编号")
    @TableField("supplier_code")
    private String supplierCode;

    @ApiModelProperty(value = "公司名称")
    @TableField("supplier_companyName")
    private String supplierCompanyname;

    @ApiModelProperty(value = "类型")
    @TableField("supplier_type_id")
    private Integer supplierTypeId;

    @ApiModelProperty(value = "联系人姓名")
    @TableField("supplier_contactName")
    private String supplierContactname;

    @ApiModelProperty(value = "联系地址")
    @TableField("supplier_address")
    private String supplierAddress;

    @ApiModelProperty(value = "邮箱")
    @TableField("supplier_emailCode")
    private String supplierEmailcode;

    @ApiModelProperty(value = "电话号码")
    @TableField("supplier_phone")
    private String supplierPhone;

    @ApiModelProperty(value = "传真号码")
    @TableField("supplier_fax")
    private String supplierFax;

    @ApiModelProperty(value = "备注信息")
    @TableField("supplier_remarks")
    private String supplierRemarks;

    @ApiModelProperty(value = "创建时间")
    @TableField("supplier_createdate")
    private Date supplierCreatedate;


}
