package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @RetuestMapping
 * class 단독 매핑
 */

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {
	
	@ResponseBody
	@RequestMapping("/list")
	public String list() {
		return "GusetbookController:list";
	}
	
	@ResponseBody
	@RequestMapping("/delete")
	public String delete() {
		return "GusetbookController:delete";
	}
}
