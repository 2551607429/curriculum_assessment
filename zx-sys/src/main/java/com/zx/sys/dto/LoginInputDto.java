package com.zx.sys.dto;

import lombok.Data;

/**
 * @ClassName LoginInputDto
 * @Description TODO
 * @Author ZX
 * @Date 2020/3/10 21:22
 */
@Data
public class LoginInputDto {
    private String username;

    private String password;

    private Integer option;
}
