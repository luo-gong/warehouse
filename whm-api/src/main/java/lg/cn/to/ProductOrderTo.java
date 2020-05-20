package lg.cn.to;

import lg.cn.whmoms.entity.Order;

import java.io.Serializable;

public class ProductOrderTo extends Order implements Serializable {

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    private boolean isChecked;//是否选中
}
