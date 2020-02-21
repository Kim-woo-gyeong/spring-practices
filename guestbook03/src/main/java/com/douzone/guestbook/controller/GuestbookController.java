package com.douzone.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.douzone.guestbook.repository.GuestBookRepository;
import com.douzone.guestbook.vo.GuestBookVo;

@Controller
public class GuestbookController {
	
	@Autowired
	private GuestBookRepository guestbookR;
	
	@RequestMapping("")
	public String index(Model model) {
		List<GuestBookVo> list = guestbookR.findAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(GuestBookVo vo ) {
		
		guestbookR.insert(vo);
		return "redirect:/";
	}
	
	@RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	public String delete(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "delete";
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String delete(GuestBookVo vo) {
		guestbookR.delete(vo);
		return "redirect:/";
	}
}
