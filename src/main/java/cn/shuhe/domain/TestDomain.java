package cn.shuhe.domain;


import lombok.*;

@Builder(toBuilder = true)
@Getter

public class TestDomain {

    private String name;
    private String email;
    private Integer money;
}


