package cn.shuhe.common;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class UserInfo {
  private String name;
  private String email;
  private int age;


}