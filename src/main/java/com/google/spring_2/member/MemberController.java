package com.google.spring_2.member;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping(value = "/member/**")
public class MemberController {
	
	public MemberController() {
		
	}
	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value = "memberJoin" ) //컨트롤러 선언부에 있는 주소 + sub1
	
	public void memberJoin(Model model) {
		//Model model //request와 같은 생명주기,비슷
		/* model.addAttribute("id","test"); */ //request.setAttribute("id","test") 같음
		//String id ="test";  //작동이 안되는 경우가 많음
		//model.addAttribute(id);
	}
	
	@RequestMapping(value = "memberJoin" , method = RequestMethod.POST) //컨트롤러 선언부에 있는 주소 + sub1
	public void memberJoin2(MemberVO memberVO) {
		//uri 경로와 리턴되는 경로명이 같을 경우/ void 이면 uri 주소가 리턴값
		//디스패쳐에 request가 있음. 자기자신에 request가 있는지 찾아봄(매개변수)(//HttpServletRequest request//)
		//String id = request.getParameter("id");
	
		//MemberVO의 멤버변수의 값으로 파라미터 값 넣기
		//출력
		
		System.out.println(memberVO.getId());
		System.out.println(memberVO.getPassword());
		System.out.println(memberVO.getName());
		System.out.println(memberVO.getEmail());
		System.out.println(memberVO.getTel());
		System.out.println(memberVO.getAge());
		
	}

	
	@RequestMapping(value = "memberLogin" )//컨트롤러 선언부에 있는 주소 + sub2
	public String memberLogin() {
		
		return "member/memberLogin";	
	}
	
	
	@RequestMapping(value = "memberLogin" , method = RequestMethod.POST)//컨트롤러 선언부에 있는 주소 + sub2
	public String memberLogin2(Model model,HttpSession session, MemberVO memberVO ) throws Exception{
			
			 memberVO=memberService.memberLogin(memberVO);
			 session.setAttribute("member", memberVO);
		
				//로그인 성공이면 INDEX 페이지로 이동으로 하고  
				//로그인 실패하면 로그인 실패를 alert 창에 띄우고 login폼으로 이동
		
		
				  String path;
				 
				  if(memberVO != null) {
				  path="redirect:../"; 
				  
				  }
				  
				  else { 
					  model.addAttribute("result", "Login Fail");
					  model.addAttribute("path", "./memberLogin");
					  
					  
				 path="common/result";
				 }
				 

		return path;	
	}
	@RequestMapping(value = "memberPage" )//컨트롤러 선언부에 있는 주소 + sub2
	public String memberPage() {
		
		return "member/memberPage";
		
	}

	@RequestMapping(value = "memberUpdate" )//컨트롤러 선언부에 있는 주소 + sub2
	public String memberUpdate() {	
		return "member/memberUpdate";
		
	}
	
	@RequestMapping(value = "memberUpdate" , method = RequestMethod.POST)//컨트롤러 선언부에 있는 주소 + sub2
	public String memberUpdate2(Model model,MemberVO memberVO,HttpSession session) throws Exception {
		String path = null;
		 int num=memberService.memberUpdate(memberVO);
		 
		
			if(memberVO!=null) {
				  if(num>0) {
					  session.setAttribute("member", memberVO);
					  model.addAttribute("result", "Update");
					  model.addAttribute("path", "./memberPage");
					  path="common/result";
				  }
				  else { 
					  model.addAttribute("result", "Update Fail");
					  model.addAttribute("path", "./memberUpdate");
					  path="common/result";
					  
				 }

			}else {
				path="memberupdate";
			}

		  	return path;	
	
	}
	
	public String memberDelete(Model model,MemberVO memberVO,HttpSession session) throws Exception {
		String path = null;
		 int num=memberService.memberDelete(session.getId());
		 memberVO=(MemberVO)session.getAttribute("member");
		 String id =memberVO.getId();
		 if(memberVO!=null) {
			 if(num>0) {
					session.invalidate(); //로그 아웃 상태로 변하도록
					path="redirect:../";
				}
		 
	}
		 return path;	
	

	
	}
}
