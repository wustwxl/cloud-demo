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
public class SysFile {
    private Long id;

    private Long userId;

    private String fileName;

    private String fileType;

    private String filePath;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createDate;

}