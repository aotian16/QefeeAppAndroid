package com.qefee.pj.qefee.bmob.bean.base;

/**
 * BaseBean.
 * <ul>
 * <li>date: 16/10/9</li>
 * </ul>
 *
 * @author tongjin
 */

public abstract class BaseBean {
    private Boolean isDelete;
    private Integer state;

    public Boolean getDelete() {
        return isDelete;
    }

    public void setDelete(Boolean delete) {
        isDelete = delete;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
