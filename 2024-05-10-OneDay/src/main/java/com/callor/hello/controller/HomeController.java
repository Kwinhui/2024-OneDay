package com.callor.hello.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.callor.hello.dao.GalleryDao;
import com.callor.hello.models.GalleryVO;
import com.callor.hello.service.GalleryService;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class HomeController {
	private final GalleryService galleryService;
	private final GalleryDao galleryDao;
	
	

	public HomeController(GalleryService galleryService, GalleryDao galleryDao) {
		super();
		this.galleryService = galleryService;
		this.galleryDao = galleryDao;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		List<GalleryVO> list = galleryService.selectAll();
		model.addAttribute("LIST", list);
		
		return "home";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.GET)
	public String insert() {
		
		return "input";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(Model model, GalleryVO vo, @RequestParam("image_file") MultipartFile image_file, MultipartHttpServletRequest image_files) {
		
		
		GalleryVO resultVO = null;
		String singleFileName = image_file.getOriginalFilename();
		
		try {
			if(!singleFileName.isEmpty()) {
				resultVO = galleryService.createGallery(vo, image_file);
			}
			if(image_files.getFiles("image_files").size()>0) {
				List<GalleryVO> VOs = galleryService.createGallery(vo, image_files);
				
			}
			model.addAttribute("GALLERY", resultVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		model.addAttribute("IMAGE", image_file.getOriginalFilename());
		
		return "redirect:/";
	}
	
}
