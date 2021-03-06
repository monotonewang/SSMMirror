package com.demo.springmvc.po;

import com.demo.springmvc.controller.validation.ValidGroup1;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class Items {

    private Integer id;

    @Size(min = 1, max = 30, message = "{items.name.length.error}")
    private String name;

    @NotNull(message = "{items.price.is.notnull}")
    private Float price;

    @NotNull(message = "{items.pic.is.notnull}")
    private String pic;

    //group可以指定校验分组，可以指定多个分组
    @NotNull(message = "{items.createtime.is.notnull}", groups = {ValidGroup1.class})
    private Date createtime;

    @NotNull(message = "{items.detail.is.notnull}")
    private String detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", pic='" + pic + '\'' +
                ", createtime=" + createtime +
                ", detail='" + detail + '\'' +
                '}';
    }
}