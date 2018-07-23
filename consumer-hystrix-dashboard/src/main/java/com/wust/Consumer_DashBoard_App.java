package com.wust;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class Consumer_DashBoard_App {

	public static void main(String[] args)
	{

		//常规开启Banner
		//SpringApplication.run(Consumer_DashBoard_App.class, args);


		//修改Banner的模式为OFF
		SpringApplicationBuilder builder = new SpringApplicationBuilder(Consumer_DashBoard_App.class);
		builder.bannerMode(Banner.Mode.OFF).run(args);
	}
}
