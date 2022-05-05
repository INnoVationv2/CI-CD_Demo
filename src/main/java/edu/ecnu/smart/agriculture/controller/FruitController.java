package edu.ecnu.smart.agriculture.controller;


import edu.ecnu.smart.agriculture.model.BaseResponse;
import edu.ecnu.smart.agriculture.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FruitController {

    FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping("/getProductSource/{no}")
    public BaseResponse getProductSource(@PathVariable Integer no){
        return fruitService.getProductSource(no);
    }
}
