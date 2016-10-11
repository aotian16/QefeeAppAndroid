package com.qefee.pj.qefee.bmob.bean;

import com.qefee.pj.qefee.bmob.bean.base.BaseBean;

/**
 * ContentTypeBean.
 * <ul>
 * <li>date: 16/10/9</li>
 * </ul>
 *
 * @author tongjin
 */

public class ContentTypeBean extends BaseBean {
    private String value;
    private String detail;

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
}
