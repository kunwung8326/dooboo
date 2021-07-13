package com.koreait.dooboo.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.dooboo.member.dao.MemberDAO;
import com.koreait.dooboo.member.dto.MemberDTO;

public class UpdateCommand3 implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_PW(request.getParameter("pw"));
		dto.setMember_ID(request.getParameter("id"));
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.update1(dto);
	}

}
