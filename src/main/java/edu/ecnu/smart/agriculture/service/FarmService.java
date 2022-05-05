package edu.ecnu.smart.agriculture.service;

import edu.ecnu.smart.agriculture.mapper.FarmMapper;
import edu.ecnu.smart.agriculture.model.*;
import edu.ecnu.smart.agriculture.model.bo.TimeDuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmService {

    FarmMapper farmMapper;

    @Autowired
    public FarmService(FarmMapper farmMapper){
        this.farmMapper = farmMapper;
    }

    public BaseResponse getAllFarmInfo(){
        List<FarmInfo> farmInfoList = farmMapper.queryAllFarmInfo();
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(farmInfoList);
        return response;
    }

    public BaseResponse addNewFarm(FarmInfo farmInfo){
        farmMapper.insertNewFarm(farmInfo);
        return BaseResponse.SuccessResponse();
    }

    public BaseResponse getFarmStatus(Integer farmId){
        FarmInfo farmById = farmMapper.getFarmById(farmId);
        if(null == farmById)
            return BaseResponse.FailResponse("要查询农场不存在，请检查输入");
        FarmLandStatus landStatus = farmMapper.getFarmStatusById(farmId);
        if(landStatus == null)
            return BaseResponse.FailResponse("查询农场当前不存在观测记录，请稍后再试");
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(landStatus);
        return response;
    }

    public BaseResponse getFarmHistoryStatus(Integer farmId, TimeDuration duration){
        FarmInfo farmById = farmMapper.getFarmById(farmId);
        if(null == farmById)
            return BaseResponse.FailResponse("要查询农场不存在，请检查输入");
        List<FarmLandStatus> landStatus = farmMapper.getFarmHistoryStatus(farmId, duration);
        if(landStatus == null)
            return BaseResponse.FailResponse("查询农场当前不存在观测记录，请稍后再试");
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(landStatus);
        return response;
    }

    public BaseResponse getWeatherInfo(){
        Weather weather = farmMapper.getWeatherInfo();
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(weather);
        return response;
    }

    public BaseResponse getHistoryWeatherInfo(TimeDuration duration){
        List<Weather> weather = farmMapper.getHistoryWeatherInfo(duration);
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(weather);
        return response;
    }

    public BaseResponse getEquipStatusByFarmId(Integer farmId){
        FarmInfo farm = farmMapper.getFarmById(farmId);
        BaseResponse response;
        if(null == farm)
            return BaseResponse.FailResponse("要查询农场不存在，请检查输入");
        List<Equipment> equips = farmMapper.getEquipStatusByFarmId(farmId);
        response = BaseResponse.SuccessResponse();
        response.setData(equips);
        return response;
    }

    public BaseResponse getSpecialist(){
        List<Specialist> specialist = farmMapper.getSpecialist();
        BaseResponse response = BaseResponse.SuccessResponse();
        response.setData(specialist);
        return response;
    }
}
