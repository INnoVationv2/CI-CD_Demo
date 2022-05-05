package edu.ecnu.smart.agriculture.controller;

import edu.ecnu.smart.agriculture.model.BaseResponse;
import edu.ecnu.smart.agriculture.model.FarmInfo;
import edu.ecnu.smart.agriculture.model.bo.TimeDuration;
import edu.ecnu.smart.agriculture.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class FarmController {

    FarmService farmService;

    @Autowired
    public FarmController(FarmService farmService){
        this.farmService = farmService;
    }

    @GetMapping("/getAllFarmInfo")
    public BaseResponse getAllFarmInfo(){
        return farmService.getAllFarmInfo();
    }

    @PostMapping("/addNewFarm")
    public BaseResponse addNewFarm(@RequestBody FarmInfo farmInfo){
        return farmService.addNewFarm(farmInfo);
    }

    @GetMapping("/getFarmStatus/{farmId}")
    public BaseResponse getFarmStatus(@PathVariable Integer farmId){
        return farmService.getFarmStatus(farmId);
    }

    @PostMapping("/getFarmStatus/{farmId}")
    public BaseResponse getFarmHistoryStatus(@PathVariable Integer farmId, @RequestBody TimeDuration duration) {
        return farmService.getFarmHistoryStatus(farmId, duration);
    }

    @GetMapping("/getWeather")
    public BaseResponse getWeather(){
        return farmService.getWeatherInfo();
    }

    @PostMapping("/getWeather")
    public BaseResponse getWeather(@RequestBody TimeDuration duration){
        return farmService.getHistoryWeatherInfo(duration);
    }

    @GetMapping("/getEquipStatusByFarmId/{farmId}")
    public BaseResponse getEquipStatusByFarmId(@PathVariable Integer farmId){
        return farmService.getEquipStatusByFarmId(farmId);
    }

    @GetMapping("/getSpecialist")
    public BaseResponse getSpecialist(){
        return farmService.getSpecialist();
    }
}
