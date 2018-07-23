package com.wust.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wust.entity.SysFile;
import com.wust.entity.SysUser;
import com.wust.service.ISysFileService;
import com.wust.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/file")
public class SysFileController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysFileController.class);

	@Resource
	private ISysFileService fileService;

	@GetMapping(value = "")
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public MessageVo getFiles() {
		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());
		List<SysFile> fileList = fileService.selectFiles();
		mess.setCode(MessageVo.OK);
		mess.setInfo("Select Success");
		mess.setData(fileList);
		return mess;
	}

	public MessageVo processHystrix_Get()
	{

		return new MessageVo().setCode(MessageVo.HYSTRIX).setInfo("HYSTRIX服务降级信息.");
	}
}
