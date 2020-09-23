package dao.intf;

import domain.Teacher;
import domain.User;

import java.sql.SQLException;
import java.util.List;

public interface ITeacherDao {
    /**
     * 查询所有教师信息
     * @return
     * @throws Exception
     */
    List<Teacher> findAll() throws Exception;

    /**
     * 根据教师编号(sno)查询教师信息
     * @param tno
     * @return
     * @throws SQLException
     */
    Teacher findByTno(int tno) throws SQLException;

    /**
     * 根据教师名删除一条教师信息
     * @param teacherName
     * @throws Exception
     */
    void deleteByTeacherName(String teacherName)throws Exception;

    /**
     * 根据教师编号删除教师信息
     * @param id
     * @throws Exception
     */
    void deleteByTeacherId(int id)throws Exception;

    /**
     * 根据教师ID修改教师信息
     * @param id
     * @param teacher
     * @throws Exception
     */
    void updateByTeacherId(int id,Teacher teacher)throws Exception;

    /**
     * 插入一条教师信息
     * @param teacher
     * @throws SQLException
     */
    void insert(Teacher teacher) throws SQLException;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<Teacher> findLike(String keyword) throws Exception;
}
