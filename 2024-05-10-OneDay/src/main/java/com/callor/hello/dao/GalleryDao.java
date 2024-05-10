package com.callor.hello.dao;

import java.util.List;

import com.callor.hello.models.GalleryVO;

public interface GalleryDao {
	
	public List<GalleryVO> selectAll();
	
	public GalleryVO findById(String seq);
	public int insert(GalleryVO vo);
	public int update(GalleryVO vo);
	public int delete(String seq);

}
