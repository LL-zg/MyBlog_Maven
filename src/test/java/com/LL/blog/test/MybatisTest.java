package com.LL.blog.test;


import com.LL.blog.entity.User;
import com.LL.blog.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*
* 入门案例
* */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取文件
        InputStream in= Resources.getResourceAsStream("mybatis_config.xml");
        //创建SqlSessionFactory
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //使用工厂生产SqlSession对象
        SqlSession session=factory.openSession();
        //使用SqlSession创建Mapper接口的代理对象
        UserMapper userMapper = session.getMapper(UserMapper.class);
        //使用代理对象执行方法
//        User user = new User("LL","123456","LILI");
//        userMapper.insert(user);
        List<User> userList= userMapper.listUser();
        for (User user:userList) {
              System.out.println(user);
        }
        //释放资源
        session.close();
        in.close();
    }

}
