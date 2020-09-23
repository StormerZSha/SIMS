package service.intf;

import domain.User;

import java.util.List;

/**
用户表（user）的业务层接口
 */
public interface IUserService {
    /**查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    List<User> findAll() throws Exception;

    /**用户登录
     * @return
     * @param user
     */
    User login(User user) throws Exception;

    /**用户注册
     *
     * @param user
     */
    Boolean register(User user) throws Exception;

    //添加一条用户信息
    void add(User user)throws Exception;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<User> findLike(String keyword) throws Exception;

    /**
     * 通过用户名查询用户信息
     * @param name
     * @return
     * @throws Exception
     */
    User findUserByName(String name) throws Exception;

    /**
     * 根据用户名删除用户信息
     * @param name
     * @throws Exception
     */
    void deleteUserByName(String name) throws Exception;

    /**
     * 授权和解除算法
     * @param type
     * @throws Exception
     */
    void updateGrant(String name, int type) throws Exception;
}
