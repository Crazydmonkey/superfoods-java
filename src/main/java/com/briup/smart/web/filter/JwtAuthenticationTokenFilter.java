//package com.briup.smart.web.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.commons.lang.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.briup.smart.common.utils.JwtTokenUtils;
//import com.briup.smart.common.utils.MessageUtil;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
///**
// * @author HP
// *token过滤器，用来验证token的有效性
// */
//public class JwtAuthenticationTokenFilter  extends OncePerRequestFilter{
//	
//	/**
//	 * UserDetailsService接口用于返回用户相关数据。
//	 */
//	@Autowired
//	@Qualifier("userDetailServiceImpl")
//	private UserDetailsService userDetailService;
//	
//	/**
//	 * 数据模型转换框架，可以将模型对象转换为JSON，或者JSON生成相应的模型类
//	 */
//	@Autowired
//	private ObjectMapper objectMapper;
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		//获取单个请求头对应的value值  请求头中包含token
//		String token = request.getHeader(JwtTokenUtils.TOKEN_HEADER);
//		
//		filterChain.doFilter(request, response);
//        return;
//		
//		
//		
//		
//		//检测 字符串以prefix开始
////		if(token != null && StringUtils.startsWith(token, JwtTokenUtils.TOKEN_PREFIX)) {
////            token = StringUtils.substring(token, JwtTokenUtils.TOKEN_PREFIX.length());
////        } else {
////        	//一个过滤器，那么就将处理好的请求直接发给servlet。
////            filterChain.doFilter(request, response);
////            return;
////        }
//		
////		try {
////			//从token获取用户信息 返回用于验证用户的用户名
////			String username = JwtTokenUtils.getUsername(token);
////			//获取到当前用户的用户名    SecurityContextHolder 保存应用程序中当前使用人的安全上下文
////			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////				//查询到保存的信息
////				UserDetails userDetails = userDetailService.loadUserByUsername(username);
////
////				if (JwtTokenUtils.validateToken(token, userDetails)) {
////					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
////							userDetails, null, userDetails.getAuthorities());
////					authentication.setDetails(new WebAuthenticationDetails(request));
////
////					SecurityContextHolder.getContext().setAuthentication(authentication);
////				}
////
////            }
////		} catch (Exception e) {
////			response.setContentType("application/json;charset=UTF-8");
////            response.getWriter().write(objectMapper.writeValueAsString(MessageUtil.error(401,"token已失效")));
////            return;
////		}
//		
////		filterChain.doFilter(request, response);
//		
//		
//		
//		
//		
//		
//		
//		
//	}
//
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//}
