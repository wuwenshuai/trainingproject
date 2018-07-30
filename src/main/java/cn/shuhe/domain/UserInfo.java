package cn.shuhe.domain;

import lombok.Builder;
import lombok.Getter;
import sun.jvm.hotspot.interpreter.BytecodeGetPut;

@Builder(toBuilder = true)
@Getter
public class UserInfo {
  private String name;
  private String email;



}