package com.wust.service;

import com.wust.entity.SysFile;

import java.util.List;

public interface ISysFileService {

	/**
	 * 获取所有文件信息
	 * @return
	 */
	List<SysFile> selectFiles();

	/**
	 * 获取单个文件信息
	 * @param id
	 * @return
	 */
	SysFile selectFileById(Long id);

	/**
	 * 上传文件
	 * @param file
	 */
	void insertFile(SysFile file);

	/**
	 * 删除单个文件
	 * @param id
	 */
	void deleteFileById(Long id);
}
