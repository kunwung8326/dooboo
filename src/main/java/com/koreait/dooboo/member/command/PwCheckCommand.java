package com.koreait.dooboo.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.dooboo.member.dto.MemberDTO;
import com.koreait.dooboo.member.util.SecurityUtils;

public class PwCheckCommand  {

	
	public Map<String, Boolean> execute(SqlSession sqlSession, Model model) {
		
		Map<String, Object> map = model.asMap();
		MemberDTO member = (MemberDTO) map.get("member");
		HttpSession session = (HttpSession) map.get("session");
		
		String pw1 = ((MemberDTO)session.getAttribute("loginUser")).getMember_PW();
		String pw2 = SecurityUtils.encodeBase64(member.getMember_PW());
		
		Map<String, Boolean> resultMap = new HashMap<String, Boolean>();
		resultMap.put("isCorrect", pw1.equals(pw2));
		return resultMap;
		
	}

}
