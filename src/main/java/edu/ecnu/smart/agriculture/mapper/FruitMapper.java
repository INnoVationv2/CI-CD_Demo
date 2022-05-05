package edu.ecnu.smart.agriculture.mapper;

import edu.ecnu.smart.agriculture.model.Fruit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FruitMapper {

    @Select("SELECT * FROM FRUIT WHERE ID = #{fruitNo}")
    Fruit getProductSource(Integer fruitNo);
}
