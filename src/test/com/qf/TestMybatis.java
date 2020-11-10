package com.qf;


import com.qf.dao.UserDao;
import com.qf.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestMybatis {

    @Test
    public void testMybatis() throws IOException {

        String resource = "mybatis-config.xml";
        // 读取mybatis的配置信息
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 使用配置信息创建出sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 使用工程打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 使用sqlSession对象加载你要执行的接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        // 使用userDao调用接口中的方法
        List<User> all = mapper.findAll();
        for (User u : all) {
            System.out.println(u);
        }
    }

    @Test
    public void testMybatisFindById() throws IOException {

        // 读取配置信息
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 加载接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 执行 sql
        User byId = mapper.findById(18);
        System.out.println("所查询的数据=="+byId);
    }

    @Test
    public void testMybatisFindByAndName() throws IOException {

        // 读取配置信息
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 加载接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 执行 sql
        User byId = mapper.findByIdAndName(18,"李");
        System.out.println("所查询的数据=="+byId);
    }

    @Test
    public void testMybatisDelete() throws IOException {

        // 读取配置信息
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 通过sqlSession工厂打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true代表默认执行完毕后提交，省略commit
        // 加载接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // sqlSession调用dao层方法执行
        int i = mapper.deleteById(11);
        // sqlSession.commit();
        System.out.println("当前删除受影响的行数=="+i);
    }

    @Test
    public void testMybatisUpdateById() throws IOException {

        // 读取配置 信息
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true 代表默认打开mybatis的commit提交
        // 加载接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 执行方法，声明对象
        User user = new User();
        user.setId(18);
        user.setUserName("李凯");
        user.setPassWord("555555");
        int i = mapper.updateById(user);
        System.out.println("当前受影响行数=="+i);
    }

    @Test
    public void testMybatisAdd() throws IOException {

        // 读取配置 信息
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true 代表默认打开mybatis的commit提交
        // 加载接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 执行方法，声明对象
        //User user = new User(0,"","",new Date());
        User user = new User();
        user.setUserName("李凯");
        user.setPassWord("000000");
        int i = mapper.addUser(user);
        System.out.println("当前受影响行数=="+i);
    }

    @Test
    public void testMybatisGetId() throws IOException {

        // 读取配置 信息
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 创建sqlSession工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 打开一个连接
        SqlSession sqlSession = sqlSessionFactory.openSession(true); // true 代表默认打开mybatis的commit提交
        // 加载接口
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        // 执行方法，声明对象
        //User user = new User(0,"","",new Date());
        User user = new User();
        user.setUserName("罗工旋");
        user.setPassWord("1111");
        int i = mapper.insertGetId(user);
        System.out.println("当前新增用户ID=="+user.getId());
    }
}
