package edu.ecnu.smart.agriculture.mapper;

import edu.ecnu.smart.agriculture.model.*;
import edu.ecnu.smart.agriculture.model.bo.TimeDuration;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface FarmMapper {

    @Select("SELECT * FROM FARM_LAND")
    List<FarmInfo> queryAllFarmInfo();

    @Select("SELECT * FROM FARM_LAND WHERE id = #{id}")
    FarmInfo getFarmById(Integer id);

    @Insert("INSERT INTO FARM_LAND(location, crop, status, comment) VALUES (#{location}, #{crop}, #{status}, #{comment})")
    void insertNewFarm(FarmInfo farmInfo);

    @Select("SELECT * FROM FARM_MONITOR WHERE farm_id = #{farmId} ORDER BY monitor_time DESC LIMIT 1")
    FarmLandStatus getFarmStatusById(Integer farmId);

    @Select("SELECT * FROM FARM_MONITOR WHERE farm_id = #{farmId} AND watch_time BETWEEN #{startDateTime} AND #{endDateTime}")
    List<FarmLandStatus> getFarmHistoryStatus(Integer farmId, TimeDuration duration);

    @Select("SELECT * FROM WEATHER ORDER BY monitor_time DESC LIMIT 1")
    Weather getWeatherInfo();

    @Select("SELECT * FROM WEATHER WHERE monitor_time BETWEEN #{startDateTime} AND #{endDateTime}")
    List<Weather> getHistoryWeatherInfo(TimeDuration duration);

    @Select("SELECT * FROM EQUIP WHERE farm_id = #{farmId}")
    List<Equipment> getEquipStatusByFarmId(Integer farmId);

    @Select("SELECT * FROM SPECIALIST")
    List<Specialist> getSpecialist();
}
