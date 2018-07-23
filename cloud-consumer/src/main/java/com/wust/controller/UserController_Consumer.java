package com.wust.controller;

import com.wust.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consumer/user")
public class UserController_Consumer {

	//通过IP调用服务
	//private static final String USER_REST_URL_PREFIX = "http://localhost:8001/admin/user";
	//通过微服务名调用服务,不再关心地址和端口
	private static final String USER_REST_URL_PREFIX = "http://CLOUD-USER/admin/user";

	/**
	 * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
	 * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
	 */
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(value = "")
	public MessageVo getUsers() {

		return restTemplate.getForObject(USER_REST_URL_PREFIX, MessageVo.class);
	}

}
