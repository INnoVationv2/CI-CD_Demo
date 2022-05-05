package edu.ecnu.smart.agriculture.mapper;


import edu.ecnu.smart.agriculture.model.User;
import edu.ecnu.smart.agriculture.model.bo.SignupForm;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from USER where username = #{username}")
    User getUserByUsername(String username);

    @Insert("INSERT into USER(username, password, email, phone) VALUES (#{username}, #{pwd}, #{email}, #{phone})")
    void saveUser(SignupForm signupForm);

}
