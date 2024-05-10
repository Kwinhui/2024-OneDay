package com.callor.hello.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.models.GalleryVO;
import com.callor.hello.models.ImagesVO;

public interface GalleryService {
	
	public List<GalleryVO> selectAll();
	
	
	// 1개이미지
	public GalleryVO createGallery(GalleryVO vo, MultipartFile image_file) throws Exception;
	
	// 여러이미지
	public List<GalleryVO> createGallery(GalleryVO vo,MultipartHttpServletRequest image_files) throws Exception;




}
