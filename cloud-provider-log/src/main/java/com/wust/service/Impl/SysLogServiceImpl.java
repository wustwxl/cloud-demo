package com.wust.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wust.entity.SysLog;
import com.wust.entity.SysLogExample;
import com.wust.mapper.SysLogMapper;
import com.wust.service.ISysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService{

	private static final Logger LOGGER = LoggerFactory.getLogger(SysLogServiceImpl.class);

	@Resource
	private SysLogMapper logMapper;


	/**
	 * 获取单页日志
	 *
	 * @param page
	 * @param limit
	 * @return
	 */
	@Override
	public PageInfo<SysLog> selectLogs(Integer page, Integer limit) {

		SysLogExample example = new SysLogExample();
		PageHelper.startPage(page, limit);
		List<SysLog> logsList = logMapper.selectByExample(example);
		PageInfo<SysLog> logsPageInfo = new PageInfo<>(logsList);
		return logsPageInfo;
	}

	/**
	 * 插入日志
	 *
	 * @param log
	 */
	@Override
	public void insertLog(SysLog log) {

		LOGGER.info("=========== SysLog " + log);
		if(null == log.getCreateDate()){
			log.setCreateDate(new Date());
		}
		logMapper.insert(log);
	}
}
