package com.wust.controller;

import com.github.pagehelper.PageInfo;
import com.wust.entity.SysLog;
import com.wust.service.ISysLogService;
import com.wust.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;


@RestController
@RequestMapping("/admin/log")
public class SysLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysLogController.class);

	@Resource
	private ISysLogService logService;

	@GetMapping(value = "")
	public MessageVo getLogs(@RequestParam(value = "page", defaultValue = "1") int page,
	                          @RequestParam(value = "limit", defaultValue = "1") int limit) {
		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());
		PageInfo<SysLog> logsPageInfo = logService.selectLogs(page,limit);
		mess.setCode(MessageVo.OK);
		mess.setInfo("Select Success");
		mess.setData(logsPageInfo);
		return mess;
	}

	@PutMapping(value = "")
	public MessageVo putUser(@RequestBody SysLog log) {

		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());

		logService.insertLog(log);
		mess.setCode(MessageVo.OK);
		mess.setInfo("Insert Success");
		mess.setData(log);
		return mess;

	}
}
