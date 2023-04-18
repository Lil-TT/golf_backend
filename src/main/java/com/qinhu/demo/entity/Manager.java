package com.qinhu.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
public class Manager implements Serializable {
  private static final long serialVersionUID = 1L;
  @TableId(value = "manager_id", type = IdType.AUTO)
  private long managerId;
  private String openId;
  private String address;
  private String managerName;
  private long managerPhone;
  private String storeImgUrl;
  private String storeDesc;
  private String storeName;


  public long getManagerId() {
    return managerId;
  }

  public void setManagerId(long managerId) {
    this.managerId = managerId;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }


  public long getManagerPhone() {
    return managerPhone;
  }

  public void setManagerPhone(long managerPhone) {
    this.managerPhone = managerPhone;
  }


  public String getStoreImgUrl() {
    return storeImgUrl;
  }

  public void setStoreImgUrl(String storeImgUrl) {
    this.storeImgUrl = storeImgUrl;
  }


  public String getStoreDesc() {
    return storeDesc;
  }

  public void setStoreDesc(String storeDesc) {
    this.storeDesc = storeDesc;
  }


  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

}
