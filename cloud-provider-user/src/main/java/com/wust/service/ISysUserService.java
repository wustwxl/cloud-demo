package com.wust.service;

import com.wust.entity.SysUser;

import java.util.List;

public interface ISysUserService {

	/**
	 * 获取所有用户信息
	 * @return
	 */
	List<SysUser> selectUsers();

	/**
	 * 获取单个用户信息
	 * @return
	 */
	SysUser selectUserById(Long id);

	/**
	 * 添加用户
	 */
	void insertUser(SysUser user);

	/**
	 * 更改单个用户信息
	 * @param user
	 */
	void updateUserById(SysUser user);

	/**
	 * 注销用户
	 */
	void deleteUser(Long id);

}
