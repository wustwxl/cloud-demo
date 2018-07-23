package com.wust.service.Impl;

import com.wust.entity.SysUser;
import com.wust.entity.SysUserExample;
import com.wust.mapper.SysUserMapper;
import com.wust.service.ISysUserService;
import com.wust.utils.DateUtil;
import com.wust.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysUserServiceImpl implements ISysUserService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Value("${TOKEN_MAX_TIME}")
	private int TOKEN_MAX_TIME;

	@Resource
	private SysUserMapper userMapper;

	/**
	 * 获取所有用户信息
	 *
	 * @return
	 */
	@Override
	public List<SysUser> selectUsers() {
		SysUserExample example = new SysUserExample();
		example.createCriteria().andDelflagEqualTo(false);
		return userMapper.selectByExample(example);
	}

	/**
	 * 获取单个用户信息
	 *
	 * @return
	 */
	@Override
	public SysUser selectUserById(Long id) {

		return userMapper.selectByPrimaryKey(id);
	}

	/**
	 * 添加用户
	 */
	@Override
	public void insertUser(SysUser user) {

		String accessToken = StringUtil.getStringRandom(18);
		String refreshToken = StringUtil.getStringRandom(10);
		String createStr = DateUtil.getCurrDateTime();
		String expiryStr = DateUtil.dayMove(createStr,TOKEN_MAX_TIME);
		Date createDate = DateUtil.parseDate(createStr);
		Date expiryDate = DateUtil.parseDate(expiryStr);

		user.setAccessToken(accessToken);
		user.setRefreshToken(refreshToken);
		user.setCreateDate(createDate);
		user.setUpdateDate(createDate);
		user.setExpiryDate(expiryDate);
		user.setState(1);
		user.setDelflag(false);

		userMapper.insert(user);
	}

	/**
	 * 更改单个用户信息
	 *
	 * @param user
	 */
	@Override
	public void updateUserById(SysUser user) {
		String updateStr = DateUtil.getCurrDateTime();
		Date updateDate = DateUtil.parseDate(updateStr);
		user.setUpdateDate(updateDate);
		userMapper.updateByPrimaryKeySelective(user);
	}

	/**
	 * 注销用户
	 */
	@Override
	public void deleteUser(Long id) {

		userMapper.deleteByPrimaryKey(id);
	}
}
