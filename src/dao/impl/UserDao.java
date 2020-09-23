package dao.impl;

import com.alibaba.druid.pool.DruidPooledConnection;
import dao.intf.IUserDao;
import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.util.List;

public class UserDao implements IUserDao {
    //查询所有用户信息
    @Override
    public List<User> findAll() throws Exception{
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        List<User> result = queryRunner.query("select * from user",new BeanListHandler<User>(User.class));
        return result;
    }
    //根据用户名删除用户信息
    @Override
    public void deleteByUsername(String username) throws Exception {
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Object[] param={username};
        queryRunner.update("delete from user where username=?",param);
    }
    //根据用户名用户修改密码
    @Override
    public void updateByUsername(String username,String password) throws Exception {
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Object[] param={username,password};
        queryRunner.update("update user set password=？where username=?",param);
    }
    //根据用户名查询单个用户信息
    @Override
    public User findUserByUsername(String username) throws Exception {
        QueryRunner queryRunner = new QueryRunner();
        DruidPooledConnection connection = JDBCUtils.getDataSource().getConnection();
        Object[] param={username};
        User result = queryRunner.query(connection, "select * from user where username=?", new BeanHandler<User>(User.class), param);
        connection.close();
        return result;
    }
    //插入一条用户数据
    @Override
    public int insert(User user) throws Exception {
        QueryRunner queryRunner=new QueryRunner();
        DruidPooledConnection connection = JDBCUtils.getDataSource().getConnection();
        Object[] param={user.getUsername(),user.getPassword(),user.getType(),user.getEmail()};
        int result = queryRunner.update(connection, "insert into user(username,password,type,email) values(?,?,?,?)", param);
        connection.close();
        return result;
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<User> findLike(String keyword) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {keyword};
        List<User> result = queryRunner.query("select * from user where username like ?", new BeanListHandler<User>(User.class), param);
        return result;
    }

    /**
     * 授权
     * @param type
     * @throws Exception
     */
    @Override
    public void updateGrant(String name,int type) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {type,name};
        queryRunner.update("update user set type=? where username=?", param);
    }


}
