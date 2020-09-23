package dao.intf;

import domain.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentDao {
        //查找所有学生记录
        List<Student> findAll() throws SQLException;

        //根据sno查找一个学生记录
        Student findBySno(int sno) throws SQLException;

        //根据id删除一条学生记录
        void deleteById(int id) throws SQLException;

        //根据学生id修改该学生信息
        void updateById(int id, Student student) throws SQLException;

        //添加一条学生信息（主键字段自增长不写）
        void insert(Student student) throws SQLException;

        //查询一条学生信息，并且包含该学生所对应的寝室信息和专业信息。
        Student findStudentWithAll(int id) throws SQLException;

        //模糊查询
        List<Student> findLike(String keyword) throws Exception;

        //查询一条学生信息，附带关联的宿舍信息和专业信息
        Student findDetail(int id) throws Exception;

        //更新学生专业和宿舍信息
        void updateStudent(int specialityid, int dormitoryid, int id) throws Exception;

        //查询没有宿舍的学生
        List<Student> findStudentNotDormitory() throws Exception;

        //查询当前宿舍的学生
        List<Student> findStudentDormitory(int dorId) throws Exception;

        //更新学生信息(插入宿舍信息)
        void updateStudentDormitory(int dorId ,int id) throws Exception;

        //更新学生信息(删除宿舍信息)
        void updateStudentDormitoryIsNull(int id) throws Exception;

        //查询没有专业的学生
        List<Student> findStudentNotSpeciality() throws Exception;

        //查询当前宿舍的学生
        List<Student> findStudentSpeciality(int speId) throws Exception;

        //更新学生信息(插入专业信息)
        void updateStudentSpeciality(int speId ,int id) throws Exception;

        //更新学生信息(删除专业信息)
        void updateStudentSpecialityIsNull(int id) throws Exception;
}
