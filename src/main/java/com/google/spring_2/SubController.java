package com.google.spring_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/sub/**")
public class SubController {
	@RequestMapping(value = "sub1") //컨트롤러 선언부에 있는 주소 + sub1
	public void sub1() {
		//uri 경로와 리턴되는 경로명이 같을 경우/ void 이명 uri 주소가 리턴값
	}
	@RequestMapping(value = "sub2")//컨트롤러 선언부에 있는 주소 + sub2
	public String sub2() {
		
		return "sub/sub2";
		
	}

}
