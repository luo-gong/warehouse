package lg.cn.vo;

import lg.cn.whmmember.entity.User;

public class UserVo extends User {
    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    private Integer rid;
}
