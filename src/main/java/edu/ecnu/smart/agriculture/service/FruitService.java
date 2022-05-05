package edu.ecnu.smart.agriculture.service;

import edu.ecnu.smart.agriculture.mapper.FruitMapper;
import edu.ecnu.smart.agriculture.model.BaseResponse;
import edu.ecnu.smart.agriculture.model.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FruitService {

    FruitMapper fruitMapper;

    @Autowired
    public FruitService(FruitMapper fruitMapper){
        this.fruitMapper = fruitMapper;
    }

    public BaseResponse getProductSource(Integer fruitNo){
        Fruit fruit = fruitMapper.getProductSource(fruitNo);
        if(null == fruit)
            return BaseResponse.FailResponse("查询编号不存在");
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(fruit);
        return response;
    }

}
