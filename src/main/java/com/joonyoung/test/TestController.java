package com.joonyoung.test;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joonyoung.test.dao.IDao;
import com.joonyoung.test.dto.MemberDto;

@Controller
public class TestController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("join")
	public String join() {
		
		return "join";
	}
	
	@RequestMapping("joinMember")
	public String joinMember(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		dao.memberJoin(mid, mpw, mname, memail);
		model.addAttribute("mid", mid);
		
		return "joinOk";
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		ArrayList<MemberDto> memberDtos = dao.memberList();
		
		model.addAttribute("list", memberDtos);
		
		return "list";
	}
	
	@RequestMapping("searchId")
	public String searchId() {
		
		return "idSearch";
	}
	
	@RequestMapping("idOk")
	public String idOk(HttpServletRequest request, Model model) {
		
		IDao dao = sqlSession.getMapper(IDao.class);
		
		String sid = request.getParameter("searchId");
		MemberDto dtos = dao.searchIdOk(sid);

		model.addAttribute("sid", dtos);
		
		return "idOk";
	}
	
}
