package com.wust.service.Impl;

import com.wust.entity.SysFile;
import com.wust.entity.SysFileExample;
import com.wust.mapper.SysFileMapper;
import com.wust.service.ISysFileService;
import com.wust.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SysFileServiceImpl implements ISysFileService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SysFileServiceImpl.class);

	@Resource
	private SysFileMapper fileMapper;

	/**
	 * 获取所有文件信息
	 *
	 * @return
	 */
	@Override
	public List<SysFile> selectFiles() {

		SysFileExample file = new SysFileExample();
		return fileMapper.selectByExample(file);
	}

	/**
	 * 获取单个文件信息
	 *
	 * @param id
	 * @return
	 */
	@Override
	public SysFile selectFileById(Long id) {

		return fileMapper.selectByPrimaryKey(id);
	}

	/**
	 * 上传文件
	 *
	 * @param file
	 */
	@Override
	public void insertFile(SysFile file) {

		Date createDate = new Date();
		file.setCreateDate(createDate);
		fileMapper.insert(file);
	}

	/**
	 * 删除单个文件
	 *
	 * @param id
	 */
	@Override
	public void deleteFileById(Long id) {

		fileMapper.deleteByPrimaryKey(id);
	}
}
