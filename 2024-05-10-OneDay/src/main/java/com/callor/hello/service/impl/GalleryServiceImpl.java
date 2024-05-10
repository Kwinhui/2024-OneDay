package com.callor.hello.service.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.dao.GalleryDao;
import com.callor.hello.dao.ImagesDao;
import com.callor.hello.models.GalleryVO;
import com.callor.hello.models.ImagesVO;
import com.callor.hello.service.FileUploadService;
import com.callor.hello.service.GalleryService;


@Service
public class GalleryServiceImpl implements GalleryService {

	private final GalleryDao galleryDao;
	private final FileUploadService fileUploadService;
	private final ImagesDao imagesDao;
	

	public GalleryServiceImpl(GalleryDao galleryDao, FileUploadService fileUploadService, ImagesDao imagesDao) {
		super();
		this.galleryDao = galleryDao;
		this.fileUploadService = fileUploadService;
		this.imagesDao = imagesDao;
	}



	@Override
	public List<GalleryVO> selectAll() {
		// TODO Auto-generated method stub
		return galleryDao.selectAll();
	}



	@Override
	public GalleryVO createGallery(GalleryVO vo, MultipartFile image_file) throws Exception {
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		vo.setG_origin_image(image_file.getOriginalFilename());
		
			
		
		
		String fileName = fileUploadService.fileUpload(image_file);
		vo.setG_up_image(fileName);
		
		vo.setG_date(lt.format(date));
		vo.setG_time(lt.format(time));
		
		int ret = galleryDao.insert(vo);
		if(ret > 0) {
			return vo;
		}
		
		
		
		
		return null;
	}


	@Transactional
	@Override
	public List<GalleryVO> createGallery(GalleryVO vo, MultipartHttpServletRequest image_files) throws Exception {
		
		LocalDateTime lt = LocalDateTime.now();
		DateTimeFormatter date = DateTimeFormatter.ofPattern("YYYY-MM-dd");
		DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
		
		vo.setG_date(lt.format(date));
		vo.setG_time(lt.format(time));
		
		vo.setG_origin_image("");
		vo.setG_up_image("");
		
		
		int gRet = galleryDao.insert(vo);
		
		String i_gemail= vo.getG_email();;
		List<ImagesVO> resultNames = fileUploadService.fileUpload(image_files);
		
		int iRet = imagesDao.inserts(i_gemail, resultNames);
		
		
		
		return null;
	}


	
	
	
	

}
