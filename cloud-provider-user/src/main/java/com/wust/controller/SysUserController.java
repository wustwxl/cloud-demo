package com.wust.controller;

import com.wust.entity.SysUser;
import com.wust.service.ISysUserService;
import com.wust.vo.MessageVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/user")
public class SysUserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysUserController.class);

	@Resource
	private ISysUserService userService;

	@GetMapping(value = "")
	public MessageVo getUsers() {
		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());
		List<SysUser> userList = userService.selectUsers();
		mess.setCode(MessageVo.OK);
		mess.setInfo("Select Success");
		mess.setData(userList);
		return mess;
	}

	@GetMapping(value = "/{id}")
	public MessageVo getUser(@PathVariable Long id) {

		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());
		SysUser user = userService.selectUserById(id);
		mess.setCode(MessageVo.OK);
		mess.setInfo("Select Success");
		mess.setData(user);
		return mess;
	}

	@PutMapping(value = "")
	public MessageVo putUser(@RequestBody SysUser user) {

		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());

		userService.insertUser(user);
		mess.setCode(MessageVo.OK);
		mess.setInfo("Insert Success");
		mess.setData(user);
		return mess;

	}

	@PostMapping(value = "")
	public MessageVo updateUser(@RequestBody SysUser user) {

		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());
		userService.updateUserById(user);
		mess.setCode(MessageVo.OK);
		mess.setInfo("Update Success");
		return mess;
	}

	@DeleteMapping(value = "/{id}")
	public MessageVo deleteUser(@PathVariable Long id) {

		MessageVo mess = new MessageVo();
		LOGGER.info("-----------------LogCode = " + mess.getLogCode());
		userService.deleteUser(id);
		mess.setCode(MessageVo.OK);
		mess.setInfo("Delete Success");
		return mess;
	}
}
