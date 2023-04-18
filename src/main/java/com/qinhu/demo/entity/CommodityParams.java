package com.qinhu.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommodityParams implements Serializable {
  private static final long serialVersionUID = 1L;
  @TableId(value = "commodityId", type = IdType.AUTO)
  private long paramId;
  private long commodityId;
  private String commodityPlace;
  private String packagingMethod;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getParamId() {
    return paramId;
  }

  public void setParamId(long paramId) {
    this.paramId = paramId;
  }


  public long getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(long commodityId) {
    this.commodityId = commodityId;
  }


  public String getCommodityPlace() {
    return commodityPlace;
  }

  public void setCommodityPlace(String commodityPlace) {
    this.commodityPlace = commodityPlace;
  }


  public String getPackagingMethod() {
    return packagingMethod;
  }

  public void setPackagingMethod(String packagingMethod) {
    this.packagingMethod = packagingMethod;
  }


  public java.sql.Timestamp getCreateTime() {
    return createTime;
  }

  public void setCreateTime(java.sql.Timestamp createTime) {
    this.createTime = createTime;
  }


  public java.sql.Timestamp getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(java.sql.Timestamp updateTime) {
    this.updateTime = updateTime;
  }

}
