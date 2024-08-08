package com.innovationv2.cicd.demo.controller;

import com.innovationv2.cicd.demo.model.BaseResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasicController {

    @GetMapping("/getAllFarmInfo")
    public BaseResponse getAllFarmInfo(){
        return BaseResponse.FailResponse("All Farm Info");
    }
}
