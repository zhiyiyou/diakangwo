package com.diankangwo.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.diankangwo.domain.UserInfo;

public class UserUtil {
    public static UserInfo getCurrentUser() {
        return (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
    /**
     * 刷新当前用户信息
     * @param user
     */
    public static void refreshCurrentUser(UserInfo user) {
    	final UserDetails authDetails = user;
		final Authentication authentication = new UsernamePasswordAuthenticationToken(
				authDetails, authDetails.getPassword(),
				authDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
