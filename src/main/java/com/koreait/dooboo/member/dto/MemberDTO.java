package com.koreait.dooboo.member.dto;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO {
	 private long Member_NO;             
	 private String Member_NAME;           
	 private String	Member_PHONE;         
	 private String	Member_ID;            
	 private String	Member_PW;              
	 private String	Member_EMAIL;            
	 private String	Member_NICKNAME;        
	 private String Member_GENDER;         
	 private Date Member_REGDATE;         
	 private Date Member_OUTDATE;        
	 private long Member_STATUS;          
	 private String Member_CITY;           
	 private String	Member_REGION;          
	 private String	Member_LOCATION;      
	 private Date Member_LASTMODIFIED;    
	 private String Member_BIRTHDAY;
	
	 
}
