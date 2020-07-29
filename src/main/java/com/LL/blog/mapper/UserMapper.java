package com.LL.blog.mapper;

import com.LL.blog.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    /**
     * 添加
     * @param 用户
     * @return  影响行数
    * */

    int insert(User user);

    /**
     * 根据ID删除用户
     * **/
    int deleteById(Integer userId);

    /**
     * 根据Id查询
     * @param 用户ID
     * @return 用户
     * **/
    User getUserById(Integer userId);

    /**
     * 更新
     * @param 用户
     * @return 影响行数
     * **/
    int update(User user);

    /**
     * 获取用户列表
     * @return 用户列表
     * **/
    @Select("select * from forest_blog")
    List<User> listUser();

    /**
     * 根据用户名或者Email查找用户
     * **/

    User getUserByNameOrEmail(String str);



}
