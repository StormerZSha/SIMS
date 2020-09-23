package dao.impl;

import dao.intf.ICourseDao;
import domain.Course;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class CourseDao implements ICourseDao {
    @Override
    public List<Course> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Course> result = queryRunner.query("select * from course", new BeanListHandler<Course>(Course.class));
        return result;
    }

    @Override
    public Course findById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        Course result = queryRunner.query("select * from course where id=?", new BeanHandler<>(Course.class), param);
        return result;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        queryRunner.update("delete from course where id=?",param);
    }

    @Override
    public void updateById(int id, Course course) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {course.getName(),course.getCridit(),course.getCheck(),id};
        queryRunner.update("update course set name=?,cridit=?,check=? where id=?",param);
    }

    @Override
    public void insert(Course course) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {course.getId(),course.getName(),course.getCridit(),course.getCheck()};
        queryRunner.update("insert into course values(?,?,?,?)",param);
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<Course> findLike(String keyword) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {keyword};
        List<Course> result = queryRunner.query("select * from course where name like ?", new BeanListHandler<Course>(Course.class), param);
        return result;
    }
}
