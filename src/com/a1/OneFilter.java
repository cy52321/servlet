package com.a1;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class OneFilter implements Filter {
    /*@Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hr=(HttpServletRequest)servletRequest;
        HttpServletResponse hre=(HttpServletResponse)servletResponse;
        HttpSession session=hr.getSession(false);
        if(session==null){
            hr.getRequestDispatcher("/login.html").forward(servletRequest,servletResponse);
            return;
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }*/

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        String uri=request.getRequestURI();
        System.out.println(uri);
        HttpSession session=null;
        if(uri.indexOf("login")!=-1 || "/myWeb/".equals(uri)){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        session=request.getSession(false);
        if(session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        request.getRequestDispatcher("/login.html").forward(servletRequest,servletResponse);

    }
}
