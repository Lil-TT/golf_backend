package com.qinhu.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class Worker implements Serializable {
  private static final long serialVersionUID = 1L;
  @TableId(value = "worker_id", type = IdType.AUTO)
  private Integer workerId;
  private String openId;
  private String phone;
  private String userAvatarurl;
  private String userNickname;
  private LocalDateTime registartionTime;

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }

  public String getUserAvatarurl() {
    return userAvatarurl;
  }

  public void setUserAvatarurl(String userAvatarurl) {
    this.userAvatarurl = userAvatarurl;
  }

  public String getUserNickname() {
    return userNickname;
  }

  public void setUserNickname(String userNickname) {
    this.userNickname = userNickname;
  }

  public LocalDateTime getRegistartionTime() {
    return registartionTime;
  }

  public void setRegistartionTime(LocalDateTime registartionTime) {
    this.registartionTime = registartionTime;
  }
}
