package com.wust.controller;

import com.wust.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/file")
public class FileController_Consumer {

	//通过IP调用服务
	//private static final String FILE_REST_URL_PREFIX = "http://localhost:8003/admin/file";
	//通过微服务名调用服务,不再关心地址和端口
	private static final String FILE_REST_URL_PREFIX = "http://CLOUD-FILE/admin/file";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "")
	public MessageVo getFiles() {

		return restTemplate.getForObject(FILE_REST_URL_PREFIX, MessageVo.class);
	}

}
