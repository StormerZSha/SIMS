package dao.impl;

import dao.intf.ISpecialityDao;
import domain.Course;
import domain.Speciality;
import domain.Student;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class SpecialityDao implements ISpecialityDao {
    @Override
    public List<Speciality> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Speciality> result = queryRunner.query("select * from speciality", new BeanListHandler<Speciality>(Speciality.class));
        return result;
    }

    @Override
    public Speciality findById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        Speciality result = queryRunner.query("select * from speciality where id=?", new BeanHandler<>(Speciality.class), param);
        return result;
    }

    @Override
    public Speciality findByName(String name) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {name};
        Speciality result = queryRunner.query("select * from speciality where name =?", new BeanHandler<>(Speciality.class), param);
        return result;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        queryRunner.update("delete from speciality where id=?",param);
    }

    @Override
    public void updateById(int id, Speciality speciality) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {speciality.getName(),speciality.getFaculty(),speciality.getType(),id};
        queryRunner.update("update speciality set name=?,faculty=?,type=? where id=?",param);
    }

    @Override
    public void insert(Speciality speciality) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {speciality.getName(),speciality.getFaculty(),speciality.getType()};
        queryRunner.update("insert into speciality(name,faculty,type) values(?,?,?)",param);
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<Speciality> findLike(String keyword) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {keyword};
        List<Speciality> result = queryRunner.query("select * from speciality where name like ?", new BeanListHandler<Speciality>(Speciality.class), param);
        return result;
    }

    /**
     * 询专业详情信息，包含专业学生
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Speciality findDetail(int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        Speciality result = queryRunner.query("select * from speciality where id =?", new BeanHandler<Speciality>(Speciality.class), param);
        Object[] p = {result.getId()};
        List<Student> students = queryRunner.query("select * from student where specialityid=?", new BeanListHandler<Student>(Student.class), p);
        result.setStudents(students);
        return result;
    }
}
