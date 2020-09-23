package service.impl;

import dao.impl.UserDao;
import dao.intf.IUserDao;
import domain.User;
import service.intf.IUserService;

import java.util.List;

public class UserService implements IUserService {
    IUserDao userDao=new UserDao();

    /**查询所有用户信息
     *
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findAll() throws Exception {
        List<User> result = userDao.findAll();
        return result;
    }

    /**用户登录
     *
     * @param user
     * @return
     */
    @Override
    public User login(User user) throws Exception {
        User result = userDao.findUserByUsername(user.getUsername());
        if (result!=null){
            String password = result.getPassword();
            if (user.getPassword().equals(password)){
                return result;
            }else {
                return null;
            }
        }else {
            return null;
        }
    }

    /**用户注册
     *
     * @param user
     */
    @Override
    public Boolean register(User user) throws Exception {
        User userByUsername =null;
        userByUsername = userDao.findUserByUsername(user.getUsername());
        //用户不存在
        if (userByUsername==null){
            int insert = userDao.insert(user);
            if (insert==1){
                return true;
            }
            return false;
        }
        return false;
    }
    //添加一条用户信息
    @Override
    public void add(User user) throws Exception {
         userDao.insert(user);
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findLike(String keyword) throws Exception {
        List<User> result = userDao.findLike("%" + keyword + "%");
        return result;
    }

    @Override
    public User findUserByName(String name) throws Exception {
        User result = userDao.findUserByUsername(name);
        return result;
    }

    /**
     * 根据用户名删除用户信息
     * @param name
     * @throws Exception
     */
    @Override
    public void deleteUserByName(String name) throws Exception {
        userDao.deleteByUsername(name);
    }

    @Override
    public void updateGrant(String name, int type) throws Exception {
        userDao.updateGrant(name,type);
    }

}
