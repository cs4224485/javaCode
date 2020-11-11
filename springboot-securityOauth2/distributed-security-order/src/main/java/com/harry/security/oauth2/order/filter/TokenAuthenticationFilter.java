package com.harry.security.oauth2.order.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.harry.security.oauth2.order.common.EncryptUtil;
import com.harry.security.oauth2.order.model.UserDto;
import com.sun.org.apache.bcel.internal.generic.NEW;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader("json-token");
        if (token != null) {
            // 1.解析token
            String json = EncryptUtil.decodeUTF8StringBase64(token);
            //将token转成json对象
//            JSONObject jsonObject = JSON.parseObject(json);
//            UserDto userDto = new UserDto();
//            userDto.setUsername(jsonObject.getString("principal"));
//            JSONArray authoritiesArray = jsonObject.getJSONArray("authorities");
            // 用户身份信息
            JSONObject userJson = JSON.parseObject(json);
            String principal = userJson.getString("principal");
            //将json转成对象
            UserDto userDTO = JSON.parseObject(principal, UserDto.class);
            JSONArray authoritiesArray = userJson.getJSONArray("authorities");
            String[] authorities = authoritiesArray.toArray(new String[authoritiesArray.size()]);

            // 2.新建并填充authentication
            //将用户信息和权限填充 到用户身份token对象中
            UsernamePasswordAuthenticationToken authenticationToken
                    = new UsernamePasswordAuthenticationToken(userDTO, null, AuthorityUtils.createAuthorityList(authorities));
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
            //将authenticationToken填充到安全上下文
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}