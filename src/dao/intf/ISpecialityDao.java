package dao.intf;

import domain.Speciality;

import java.sql.SQLException;
import java.util.List;

/**
 * 学生专业的Dao层接口
 */
public interface ISpecialityDao {
    /**
     * 查询所有专业
     * @return
     * @throws SQLException
     */
    List<Speciality> findAll() throws SQLException;

    /**
     * 根据专业 ID查询专业信息
     * @return
     * @throws SQLException
     */
    Speciality findById(int id) throws SQLException;

    /**
     * 根据专业名称查询专业信息
     * @param name
     * @return
     * @throws SQLException
     */
    Speciality findByName(String name) throws SQLException;

    /**
     * 根据专业 ID删除专业
     * @param id
     * @throws SQLException
     */
    void deleteById(int id) throws SQLException;

    /**
     * 根据专业id,更新专业信息
     * @param id
     * @param speciality
     * @throws SQLException
     */
    void updateById(int id,Speciality speciality) throws SQLException;

    /**
     * 插入一条专业信息
     * @param speciality
     * @throws SQLException
     */
    void insert(Speciality speciality) throws SQLException;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<Speciality> findLike(String keyword) throws Exception;

    /**
     * 查询宿舍详情信息，包含宿舍学生
     * @param id
     * @return
     * @throws Exception
     */
    Speciality findDetail(int id) throws Exception;
}
