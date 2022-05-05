package edu.ecnu.smart.agriculture.controller;

import edu.ecnu.smart.agriculture.model.BaseResponse;
import edu.ecnu.smart.agriculture.model.bo.LoginForm;
import edu.ecnu.smart.agriculture.model.bo.SignupForm;
import edu.ecnu.smart.agriculture.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class LoginController {
    UserService userService;
    HttpServletRequest request;

    @Autowired
    public LoginController(UserService userService, HttpServletRequest request){
        this.userService = userService;
        this.request = request;
    }

    @PostMapping("login")
    public BaseResponse login(@RequestBody LoginForm loginForm){
        return userService.loginService(loginForm);
    }

    @GetMapping("logout")
    public BaseResponse logout(){
        request.getSession().removeAttribute("logInUser");
        return BaseResponse.SuccessResponse();
    }

    @PostMapping("signup")
    public BaseResponse signup(@RequestBody SignupForm signupForm){
        return userService.signupService(signupForm);
    }

}
