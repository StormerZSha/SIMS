package dao.intf;
/*
用户表（user）的持久化层接口
 */
import domain.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    //查询所有用户信息
    List<User> findAll() throws Exception;
    //根据用户名删除用户信息
    void deleteByUsername(String username)throws Exception;
    //根据用户名修改用户密码
    void updateByUsername(String username,String password)throws Exception;
    //根据用户查询用户信息。
    User  findUserByUsername(String username) throws Exception;
    //插入一条用户信息
    int insert(User user)throws Exception;
    //模糊查询
    List<User> findLike(String keyword) throws Exception;
    //授权
    void updateGrant(String name , int type) throws Exception;
}
