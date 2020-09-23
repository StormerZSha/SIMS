package dao.intf;

import domain.Course;

import java.sql.SQLException;
import java.util.List;

public interface ICourseDao {
    /**
     * 查询所有课程信息
     * @return
     * @throws SQLException
     */
    List<Course> findAll() throws SQLException;

    /**
     * 根据课程的ID查询课程信息
     * @param id
     * @return
     * @throws SQLException
     */
    Course findById(int id) throws SQLException;

    /**
     * 根据课程ID删除课程信息
     * @param id
     * @throws SQLException
     */
    void deleteById(int id) throws SQLException;

    /**
     * 根据课程ID更新课程信息
     * @param id
     * @throws SQLException
     */
    void updateById(int id,Course course) throws SQLException;

    /**
     * 插入一条课程信息
     * @param course
     * @throws SQLException
     */
    void insert(Course course) throws SQLException;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<Course> findLike(String keyword) throws Exception;
}
