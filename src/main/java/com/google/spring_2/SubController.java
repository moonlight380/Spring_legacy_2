package com.google.spring_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/**")
public class SubController {
	@RequestMapping(value = "sub1") //컨트롤러 선언부에 있는 주소 + sub1
	public String sub1() {
		
		return "sub/sub1";
		
	}
	@RequestMapping(value = "sub2")//컨트롤러 선언부에 있는 주소 + sub2
	public String sub2() {
		
		return "sub/sub2";
		
	}

}
