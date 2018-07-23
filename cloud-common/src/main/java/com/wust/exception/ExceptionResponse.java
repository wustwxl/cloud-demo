package com.wust.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * @author : F7687967
 * Date: 2017/10/16
 * Time: 下午 05:00
 * Description: 统一异常处理返回对象类
 */
@Setter
@Getter
public class ExceptionResponse {

	public static final Integer OK = 0;
	public static final Integer ERROR = 1;

	//code：请求失败与否
	private Integer code;
	//info：请求返回类型
	private String info;
	//debug：用于日至搜索
	private String debug;
	//data：返回异常信息
	private Object data;

}
