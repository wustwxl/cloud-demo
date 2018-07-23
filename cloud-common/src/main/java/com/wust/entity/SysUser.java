package com.wust.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 无参构造函数
@NoArgsConstructor
// 全参构造函数
// @AllArgsConstructor
@Data
// set链式写法
@Accessors(chain = true)
public class SysUser {
    private Long id;

    private String username;

    private String mobile;

    /**
     * 男：1
     * 女：0
     */
    private Integer sex;

    private String nickname;

    private String avatar;

    private String password;

    private String email;

    private String accessToken;

    private String refreshToken;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date expiryDate;

    /**
     * 正常：1
     * 限制：0
     */
    private Integer state;

    private Boolean delflag;

}