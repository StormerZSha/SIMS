package service.intf;

import domain.Teacher;

import java.util.List;

public interface ITeacherService {
    /**
     * 获取所有教师信息
     * @return
     * @throws Exception
     */
    List<Teacher> findAll() throws Exception;

    /**
     * 添加一个教师信息
     * @throws Exception
     */
    void addTeacher(Teacher teacher) throws Exception;

    /**
     * 删除一条教师信息
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    List<Teacher> findLike(String keyword) throws Exception;

    /**
     * 根据教师tno查询教师信息
     * @param tno
     * @return
     * @throws Exception
     */
    Teacher findTeacherByTno(int tno) throws Exception;
}
