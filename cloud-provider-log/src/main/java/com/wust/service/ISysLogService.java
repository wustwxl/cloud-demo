package com.wust.service;

import com.github.pagehelper.PageInfo;
import com.wust.entity.SysLog;

public interface ISysLogService {

	/**
	 * 获取单页日志
	 * @param page
	 * @param limit
	 * @return
	 */
	PageInfo<SysLog> selectLogs(Integer page, Integer limit);

	/**
	 * 插入日志
	 * @param log
	 */
	void insertLog(SysLog log);
}
