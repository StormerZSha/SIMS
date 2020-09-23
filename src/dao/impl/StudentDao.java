package dao.impl;

import dao.intf.IStudentDao;
import domain.Dormitory;
import domain.Speciality;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao implements IStudentDao {
    /**
     * 查询所有学生信息
     * @return
     * @throws SQLException
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Student> results = queryRunner.query("select * from student",
                           new BeanListHandler<Student>(Student.class));
        List<Student> result = new ArrayList<>();
        for (Student student : results){
            int id = student.getId();
            Student studentWithAll = findStudentWithAll(id);
            result.add(studentWithAll);
        }
        return result;
    }

    /**
     * 根据学号查询学生信息
     * @param sno
     * @return
     * @throws SQLException
     */
    @Override
    public Student findBySno(int sno) throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Object[] param = {sno};
        Connection connection = JDBCUtils.getDataSource().getConnection();
        Student result = queryRunner.query(connection, "select * from student where sno =?", new BeanHandler<Student>(Student.class), param);
        connection.close();
        return result;
    }

    /**
     * 根据学生ID删除学生信息
     * @param id
     * @throws SQLException
     */
    @Override
    public void deleteById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        queryRunner.update("delete from student where id =?", param);
    }

    /**
     * 根据id更新学生信息
     * @param id
     * @param student
     * @throws SQLException
     */
    @Override
    public void updateById(int id,Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {student.getName(),student.getSex(),student.getBirthday(),
                    student.getSpeciality().getId(),student.getDormitory().getId(),student.getSno(),id};
        queryRunner.update(
                "update student set name=?,sex=?,birthday=?,specialityid=?,domitoryid=?,sno=? where id=?",param);
    }

    /**
     * 插入一条学生信息
     * @param student
     * @throws SQLException
     */
    @Override
    public void insert(Student student) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {student.getName(),student.getSex(),student.getBirthday(),student.getSpecialityid(),
                student.getDormitoryid(),student.getSno()};
        queryRunner.update(
                "insert into student(name,sex,birthday,specialityid,dormitoryid,sno) values(?,?,?,?,?,?)", param);
    }

    //查询一条学生信息，并且包含该学生所对应的寝室信息和专业信息。
    @Override
    public Student findStudentWithAll(int id) throws SQLException {
        QueryRunner queryRunner=new QueryRunner(JDBCUtils.getDataSource());
        Object[] param={id};
        //查询学生信息
        Student student = queryRunner.query("select * from student where id=?", new BeanHandler<Student>(Student.class), param);
        Object[] p={student.getId()};
        //查询跟该学生信息有关联的寝室信息
        Dormitory dormitory = queryRunner.query(
                "select * from dormitory where id=(select dormitoryid from student where id=?)", new BeanHandler<Dormitory>(Dormitory.class),p);
        //查询跟该学生有关联的专业信息
        Speciality speciality = queryRunner.query(
                "select * from speciality where id=(select specialityid from student where id=?)", new BeanHandler<Speciality>(Speciality.class), p);
        //将关联信息全部分装为Student对象
        student.setDormitory(dormitory);
        student.setSpeciality(speciality);
        return student;
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findLike(String keyword) throws Exception{
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {keyword};
        List<Student> result = queryRunner.query("select * from student where name like ?", new BeanListHandler<Student>(Student.class), param);
        return result;
    }

    /**
     * 查询一条学生信息，附带关联的宿舍信息和专业信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Student findDetail(int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        Student result = queryRunner.query("select * from student where id=?", new BeanHandler<Student>(Student.class), param);
        Object[] p = {result.getDormitoryid()};
        Dormitory dormitory = queryRunner.query("select * from dormitory where id =?", new BeanHandler<Dormitory>(Dormitory.class), p);
        Object[] p2 = {result.getSpecialityid()};
        Speciality speciality = queryRunner.query("select * from speciality where id=?", new BeanHandler<Speciality>(Speciality.class), p2);
        result.setDormitory(dormitory);
        result.setSpeciality(speciality);
        return result;
    }

    /**
     *  更新学生专业和宿舍信息
     * @param specialityid
     * @param dormitoryid
     * @throws Exception
     */
    @Override
    public void updateStudent(int specialityid, int dormitoryid,int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param ={specialityid,dormitoryid,id};
        queryRunner.update("update student set specialityid=?,dormitoryid=? where id=?",param);
    }

    /**
     * 获取没有宿舍的学生信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentNotDormitory() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Student> result = queryRunner.query("select * from student where dormitoryid is null", new BeanListHandler<Student>(Student.class));
        return result;
    }

    /**
     * 查询当前宿舍的所有学生
     * @param dorId
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentDormitory(int dorId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {dorId};
        List<Student> result = queryRunner.query("select * from student where dormitoryid=?", new BeanListHandler<Student>(Student.class), param);
        return result;
    }

    /**
     * 更新学生信息(添加宿舍)
     * @param dorId
     * @param id
     * @throws Exception
     */
    @Override
    public void updateStudentDormitory(int dorId, int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {dorId,id};
        queryRunner.update("update student set dormitoryid=? where id=?",param);
    }

    /**
     * 删除学生的宿舍信息
     * @throws Exception
     */
    @Override
    public void updateStudentDormitoryIsNull(int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param ={id};
        queryRunner.update("update student set dormitoryid=null where id=?",param);
    }

    /**
     * 查询没有专业的学生
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentNotSpeciality() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Student> result = queryRunner.query("select * from student where specialityid is null", new BeanListHandler<Student>(Student.class));
        return result;
    }

    /**
     * 获取当前专业的所有学生
     * @param speId
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentSpeciality(int speId) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {speId};
        List<Student> result = queryRunner.query("select * from student where specialityid=?", new BeanListHandler<Student>(Student.class), param);
        return result;
    }

    /**
     * 更新学生信息(插入专业信息)
     * @param speId
     * @param id
     * @throws Exception
     */
    @Override
    public void updateStudentSpeciality(int speId, int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {speId,id};
        queryRunner.update("update student set specialityid=? where id=?",param);
    }

    /**
     * 更新学生信息(删除专业信息)
     * @throws Exception
     */
    @Override
    public void updateStudentSpecialityIsNull(int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        queryRunner.update("update student set specialityid=null where id=?",param);
    }
}
