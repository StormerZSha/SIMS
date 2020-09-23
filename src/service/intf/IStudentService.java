package service.intf;

import domain.Student;

import java.util.List;

public interface IStudentService {
    /**
     * 获取所有学生信息
     * @return
     * @throws Exception
     */
    List<Student> findAll() throws Exception;

    /**
     * 根据学生关键字搜索学生信息
     * @return
     * @throws Exception
     */
    Student findStudentByName(String keyWord) throws Exception;

    /**
     * 添加学生信息
     * @param student
     * @throws Exception
     */
    void addStudent(Student student) throws Exception;

    /**
     * 根据学生ID删除学生信息
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 模糊查询
     * @return
     * @throws Exception
     */
    List<Student> findLike(String keyword) throws Exception;

    /**
     * 详情
     * @param id
     * @return
     * @throws Exception
     */
    Student findDetail(int id) throws Exception;

    /**
     * 根据学生sno查询学生信息
     * @return
     * @throws Exception
     */
    Student findStudentBySno(int sno) throws Exception;

    /**
     * 更新学生信息(专业和宿舍)
     * @param specialityid
     * @param dormitoryid
     * @throws Exception
     */
    void updateStudent(int specialityid,int dormitoryid,int id) throws Exception;

    /**
     * 查询没有宿舍的学生
     * @return
     * @throws Exception
     */
    List<Student> findStudentNotDormitory() throws Exception;

    /**
     * 给学生添加宿舍
     * @param dorId
     * @param values
     * @throws Exception
     */
    void updateStudentDormitory(int dorId,String[] values) throws Exception;

    /**
     * 查询当前宿舍的所有学生
     * @param dorId
     * @return
     * @throws Exception
     */
    List<Student> findStudentDormitory(int dorId) throws Exception;

    /**
     * 删除学生的宿舍信息
     * @param values
     * @throws Exception
     */
    void updateStudentDormitoryIsNull(String[] values) throws Exception;

    /**
     * 查询没有专业的学生
     * @return
     * @throws Exception
     */
    List<Student> findStudentNotSpeciality() throws Exception;

    /**
     * 给学生添加专业
     * @param speId
     * @param values
     * @throws Exception
     */
    void updateStudentSpeciality(int speId,String[] values) throws Exception;

    /**
     * 查询当前专业的所有学生
     * @param speId
     * @return
     * @throws Exception
     */
    List<Student> findStudentSpeciality(int speId) throws Exception;

    /**
     * 删除学生的专业信息
     * @param values
     * @throws Exception
     */
    void updateStudentSpecialityIsNull(String[] values) throws Exception;

}
