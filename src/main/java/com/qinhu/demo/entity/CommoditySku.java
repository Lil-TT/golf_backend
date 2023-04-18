package com.qinhu.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class CommoditySku implements Serializable {
  private static final long serialVersionUID = 1L;
  @TableId(value = "commodityId", type = IdType.AUTO)
  private long skuId;
  private long commodityId;
  private String skuName;
  private String skuImg;
  private String fineness;
  private long originalPrice;
  private long sellPrice;
  private long stock;
  private java.sql.Timestamp createTime;
  private java.sql.Timestamp updateTime;


  public long getSkuId() {
    return skuId;
  }

  public void setSkuId(long skuId) {
    this.skuId = skuId;
  }


  public long getCommodityId() {
    return commodityId;
  }

  public void setCommodityId(long commodityId) {
    this.commodityId = commodityId;
  }


  public String getSkuName() {
    return skuName;
  }

  public void setSkuName(String skuName) {
    this.skuName = skuName;
  }


  public String getSkuImg() {
    return skuImg;
  }

  public void setSkuImg(String skuImg) {
    this.skuImg = skuImg;
  }


  public String getFineness() {
    return fineness;
  }

  public void setFineness(String fineness) {
    this.fineness = fineness;
  }


  public long getOriginalPrice() {
    return originalPrice;
  }

  public void setOriginalPrice(long originalPrice) {
    this.originalPrice = originalPrice;
  }


  public long getSellPrice() {
    return sellPrice;
  }

  public void setSellPrice(long sellPrice) {
    this.sellPrice = sellPrice;
  }


  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
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
