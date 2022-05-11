package com.kitto.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author kitto
 * @create 2022-04-09-11:30
 */
public class MyLocalResolver implements LocaleResolver {

    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //获取请求当中的语言参数
        String language=request.getParameter("l");
        //如果没有请求就用默认的
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(language)){
            String[] split = language.split("_");
            //分割出国家和地区
           locale= new Locale(split[0],split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
