package service.intf;

import domain.Speciality;

import java.util.List;

public interface ISpecialitySercice {
    /**
     * 根据专业名称查询专业信息
     * @return
     * @param name
     * @throws Exception
     */
    Speciality findSpecialityByName(String name) throws Exception;
    /**
     * 获取所有课程信息
     * @return
     * @throws Exception
     */
    List<Speciality> findAll() throws Exception;

    /**
     * 添加课程信息
     * @param speciality
     * @throws Exception
     */
    void addSpeciality(Speciality speciality) throws Exception;

    /**
     * 根据课程ID删除课程信息
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 模糊查询
     * @return
     * @throws Exception
     */
    List<Speciality> findLike(String keyword) throws Exception;

    /**
     * 查询专业详情信息
     * @param id
     * @return
     * @throws Exception
     */
    Speciality findDetail(int id) throws Exception;
}
