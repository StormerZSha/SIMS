package dao.intf;

import domain.Dormitory;

import java.sql.SQLException;
import java.util.List;

/**
 * 宿舍Dao层接口
 */
public interface IDormitoryDao {
    /**
     * 查询所有宿舍信息
     * @return
     * @throws SQLException
     */
    List<Dormitory> findAll() throws SQLException;

    /**
     * 根据宿舍编号查询宿舍信息
     * @param dno
     * @return
     * @throws SQLException
     */
    Dormitory findByDno(int dno) throws SQLException;

    /**
     * 根据宿舍ID删除宿舍信息
     * @param id
     * @throws SQLException
     */
    void deleteById(int id) throws SQLException;

    /**
     * 根据宿舍id修改宿舍信息
     * @param id
     * @param dormitory
     * @throws SQLException
     */
    void updateById(int id,Dormitory dormitory) throws SQLException;

    /**
     * 插入一条宿舍信息
     * @param dormitory
     * @throws SQLException
     */
    void inset(Dormitory dormitory) throws SQLException;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<Dormitory> findLike(String keyword) throws Exception;

    /**
     * 查询宿舍信息，包含学生信息
     * @param id
     * @return
     * @throws Exception
     */
    Dormitory findDetail(int id) throws Exception;
}
