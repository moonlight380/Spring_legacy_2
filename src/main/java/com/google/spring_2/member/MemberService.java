package com.google.spring_2.member;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.spring_2.member.MemberDAO;

@Service
public class MemberService {
	
	  @Autowired 
	  private MemberDAO memberDAO; //멤버변수 선언
	 
	 /* @Autowired public MemberService(MemberDAO memberDAO) {
	 * 
	 * this.memberDAO = new MemberDAO(); }
	 * 
	 * 
	 * @Autowired public void setMemberDAO(MemberDAO memberDAO) { this.memberDAO =
	 * memberDAO; }
	 */



	public int memberJoin(MemberVO memberDTO) throws Exception {
		int result =memberDAO.memberJoin(memberDTO);
		return result;
				
	}
	public MemberVO memberLogin(MemberVO memberDTO) throws Exception {
		memberDTO =memberDAO.memberLogin(memberDTO);
		return memberDTO;
				
	}
	//딜리트
	
	public int memberDelete(String id) throws Exception{
		int result=memberDAO.memberDelete(id);
		
		return result;
	}
	//업데이트
	public int memberUpdate(MemberVO memberDTO) throws Exception{
		int result=memberDAO.memberUpdate(memberDTO);
		
		return result;
		
	}
	
	
	
	/*
	 * public MemberDTO myPage(int num) throws Exception {
	 * 
	 * int result =memberDAO.memberJoin(memberDTO); return result;
	 * 
	 * }
	 */


}
