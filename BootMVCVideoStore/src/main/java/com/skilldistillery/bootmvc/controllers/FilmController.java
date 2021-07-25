package com.skilldistillery.bootmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.bootmvc.data.FilmDAO;

@Controller
public class FilmController {
	
	@Autowired
	private FilmDAO dao; {
		
	}
	

		@RequestMapping(path="/")
		public String index() {
//		    return "WEB-INF/index.jsp";
			return "index"; // if using a ViewResolver.
	}
		
		@RequestMapping("getFilm.do")
		public String showFilm(Integer fid, Model model) {
			
			model.addAttribute("film", dao.findById(fid)); 
			return "film/show"; 
	}
		
}	
	

