package com.tensquare.qa.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 功能描述:
 * @作者: lj
 * @创建时间: 2019/5/11 12:18
 */
@Entity
@Table(name = "tb_ul")
public class Ul implements Serializable {

    @Id
    private String uid;

    @Id
    private String lid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }
}
