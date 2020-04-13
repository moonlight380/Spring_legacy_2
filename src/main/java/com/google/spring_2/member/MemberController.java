package com.google.spring_2.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/member/**")
public class MemberController {

	@RequestMapping(value = "memberJoin" , method = RequestMethod.POST) //컨트롤러 선언부에 있는 주소 + sub1
	public void memberJoin2() {
		//uri 경로와 리턴되는 경로명이 같을 경우/ void 이명 uri 주소가 리턴값
		System.out.println("member.post");
	}
	@RequestMapping(value = "memberJoin" ) //컨트롤러 선언부에 있는 주소 + sub1
	public void memberJoin() {
		System.out.println("member.get");
	}
	@RequestMapping(value = "memberLogin" )//컨트롤러 선언부에 있는 주소 + sub2
	public String memberLogin() {
		
		return "member/memberLogin";	
	}
	@RequestMapping(value = "memberLogin" , method = RequestMethod.POST)//컨트롤러 선언부에 있는 주소 + sub2
	public String memberLogin2() {
		System.out.println("memberLogin.post");
		return "redirect:../";	
	}
	@RequestMapping(value = "memberPage" )//컨트롤러 선언부에 있는 주소 + sub2
	public String memberPage() {
		
		return "member/memberPage";
		
	}
	@RequestMapping(value = "memberPage" , method = RequestMethod.POST)//컨트롤러 선언부에 있는 주소 + sub2
	public String memberPage2() {
		return "member/memberPage";
		
	}
	@RequestMapping(value = "memberUpdate" )//컨트롤러 선언부에 있는 주소 + sub2
	public String memberUpdate() {	
		return "member/memberUpdate";
		
	}
	@RequestMapping(value = "memberUpdate" , method = RequestMethod.POST)//컨트롤러 선언부에 있는 주소 + sub2
	public String memberUpdate2() {
		
		return "member/memberUpdate";
		
	}
}
