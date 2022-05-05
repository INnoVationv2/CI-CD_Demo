package edu.ecnu.smart.agriculture.service;

import edu.ecnu.smart.agriculture.mapper.UserMapper;
import edu.ecnu.smart.agriculture.model.BaseResponse;
import edu.ecnu.smart.agriculture.model.User;
import edu.ecnu.smart.agriculture.model.bo.LoginForm;
import edu.ecnu.smart.agriculture.model.bo.SignupForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class UserService {
    UserMapper userMapper;

    HttpServletRequest request;

    @Autowired
    public UserService(UserMapper userMapper, HttpServletRequest request){
        this.userMapper = userMapper;
        this.request = request;
    }

    public BaseResponse loginService(LoginForm loginForm){
        User loginUser = userMapper.getUserByUsername(loginForm.getUsername());
        BaseResponse response;
        if(loginUser == null || !loginUser.getPassword().equals(loginForm.getPwd())){
            response = BaseResponse.FailResponse("登录失败,账户名或密码输入错误");
        }else {
            response = BaseResponse.SuccessResponse();
            request.getSession().setAttribute("loginUser", loginUser);
        }
        return response;
    }

    public BaseResponse signupService(SignupForm signupForm){
        BaseResponse response;
        User userByUsername = userMapper.getUserByUsername(signupForm.getUsername());
        if(userByUsername == null) {
            userMapper.saveUser(signupForm);
            response = BaseResponse.SuccessResponse();
        }else
            response = BaseResponse.FailResponse("用户名已存在");
        return response;
    }
}
