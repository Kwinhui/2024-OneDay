package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.callor.hello.models.ImagesVO;

public interface ImagesDao {

	public List<ImagesVO> selectAll();
	
	public ImagesVO findById(String seq);
	
	public int update(ImagesVO vo);
	public int delete(String seq);
	
	public int inserts(@Param("g_email") String i_gemail, @Param("images") List<ImagesVO> resultNames);
	
}
