package com.qefee.pj.qefee.bmob.bean;

import com.qefee.pj.qefee.bmob.bean.base.BaseBean;

/**
 * TagBean.
 * <ul>
 * <li>date: 16/10/11</li>
 * </ul>
 *
 * @author tongjin
 */

public class TagBean extends BaseBean {
    private String value;
    private String detail;
    private Integer type; // 0 = content type, 1 = manage type

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
