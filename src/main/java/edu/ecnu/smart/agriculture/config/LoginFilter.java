package edu.ecnu.smart.agriculture.config;

import com.google.gson.Gson;
import edu.ecnu.smart.agriculture.model.BaseResponse;
import edu.ecnu.smart.agriculture.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;

@Configuration
public class LoginFilter implements Filter {
    private final Gson gson;

    @Autowired
    public LoginFilter(Gson gson){
        this.gson = gson;
    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String requestURI = httpServletRequest.getRequestURI();
        if(!requestURI.equals("/login") && !requestURI.equals("/signup")){
            User loginUser = (User) httpServletRequest.getSession().getAttribute("loginUser");
            if(null == loginUser) {
                response.setCharacterEncoding("UTF-8");
                PrintWriter writer = response.getWriter();
                BaseResponse failResponse = BaseResponse.FailResponse("请登录后再试");
                writer.write(gson.toJson(failResponse));
                writer.close();
                response.flushBuffer();
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
