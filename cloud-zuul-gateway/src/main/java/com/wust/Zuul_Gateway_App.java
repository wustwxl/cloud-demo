package com.wust;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
//使用@EnableZuulProxy注解激活zuul。
//该注解整合了@EnableCircuitBreaker、@EnableDiscoveryClient，是个组合注解，目的是简化配置。
@EnableZuulProxy
public class Zuul_Gateway_App
{
	public static void main(String[] args)
	{

		//常规开启Banner
		//SpringApplication.run(Zuul_Gateway_App.class, args);


		//修改Banner的模式为OFF
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Zuul_Gateway_App.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
}
