package com.douzone.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.douzone.hellospring.vo.UserVo;

/*
 * RequestMapping
 * Class + Method
 * 
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
//	@Autowired
//	UserRepository userRepository;
	
	@RequestMapping(value= {"/join", "/j"},method=RequestMethod.GET)
	public String joinform() {
		return "/WEB-INF/views/join.jsp";
	}
	
	@RequestMapping(value="/join",method=RequestMethod.POST)
	public String join(UserVo userVo) {
		System.out.println(userVo);
		//userRepository.insert(userVo);
//		return "UserController:join";
		return "redirect:/main";
	}
	
	@ResponseBody
	@RequestMapping(value="/update")
	public String update(@RequestParam("n") String name) {
		/**
		 * 만일 n이라는 이름으로 파라미터가 없는 경우 400 Bad Request 오류 발생
		 */
		System.out.println(name);
		return "UserController:update";
	}
	
	@ResponseBody
	@RequestMapping(value="/update2")
	public String update2(@RequestParam(value = "n", required =false, defaultValue = "") String name, 
						  @RequestParam(value = "a", required =false, defaultValue = "0") int age) {
		System.out.println("-------"+name+"-------"+age);
		return "UserController:update2";
	}
}
