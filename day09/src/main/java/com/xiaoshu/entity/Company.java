package com.xiaoshu.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "express_company")
public class Company implements Serializable {
    @Id
    @Column(name = "express_type_id")
    private Integer expressTypeId;

    @Column(name = "express_cname")
    private String expressCname;

    private String status;

    @Column(name = "create_time")
    private Date createTime;

    private static final long serialVersionUID = 1L;

    /**
     * @return express_type_id
     */
    public Integer getExpressTypeId() {
        return expressTypeId;
    }

    /**
     * @param expressTypeId
     */
    public void setExpressTypeId(Integer expressTypeId) {
        this.expressTypeId = expressTypeId;
    }

    /**
     * @return express_cname
     */
    public String getExpressCname() {
        return expressCname;
    }

    /**
     * @param expressCname
     */
    public void setExpressCname(String expressCname) {
        this.expressCname = expressCname == null ? null : expressCname.trim();
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", expressTypeId=").append(expressTypeId);
        sb.append(", expressCname=").append(expressCname);
        sb.append(", status=").append(status);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}