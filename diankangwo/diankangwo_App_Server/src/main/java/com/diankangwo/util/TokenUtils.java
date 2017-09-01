package com.diankangwo.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.RandomStringUtils;


public class TokenUtils{

	public static final String TOKEN_KEY_NUM = "_TOKEN_NUM";
	
	/**
	 * 生成token值 
	 * @param req
	 * @return
	 */
	public static String createToken(String tokenKey, HttpServletRequest req){
		HttpSession session = req.getSession();
		String token = RandomStringUtils.random(20, "ABCDDEFGHIJKLMNOPQRSTUVWXYZ");
		session.setAttribute(tokenKey, token);
		session.setAttribute(tokenKey + TOKEN_KEY_NUM, 0);
		return token;
	}
	
	/**
	 * 验证token是否正确
	 * @param req
	 * @return
	 */
	public static boolean authTokenIsOk(HttpServletRequest req, String tokenKey, String token){
		
		if(token.isEmpty()){
			return false;
		}
		
		HttpSession session = req.getSession();
		String sessionToken = (String)session.getAttribute(tokenKey);
		if(sessionToken.equals(token)){
			return true;
		}
		return false;
	}
	
	/**
	 * 验证token是否正确
	 * @param req
	 * @return
	 */
	public static boolean authTokenNumIsOk(HttpServletRequest req, String tokenKey, String token){

		if(token.isEmpty()){
			return false;
		}
		HttpSession session = req.getSession();
		//记录下验证的次数
		Integer num = (Integer)session.getAttribute(tokenKey + TOKEN_KEY_NUM);
		if(num < 5){
			session.setAttribute(tokenKey + TOKEN_KEY_NUM, num+1);
			return true;
		}
		return false;
	}
}