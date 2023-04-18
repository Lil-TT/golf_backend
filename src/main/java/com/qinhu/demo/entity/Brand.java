package com.qinhu.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Brand implements Serializable {
  private static final long serialVersionUID = 1L;

  @TableId(value = "id", type = IdType.AUTO)
  private long id;
  private String brief;
  private String detail;
  private String imgc;
  private String name;
  private String brandpic;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getDesc() {
    return brief;
  }

  public void setDesc(String desc) {
    this.brief = desc;
  }


  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
  }


  public String getImgc() {
    return imgc;
  }

  public void setImgc(String imgc) {
    this.imgc = imgc;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getBrandpic() {
    return brandpic;
  }

  public void setBrandpic(String brandpic) {
    this.brandpic = brandpic;
  }

}
