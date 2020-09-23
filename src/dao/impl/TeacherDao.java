package dao.impl;

import dao.intf.ITeacherDao;
import domain.Teacher;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class TeacherDao implements ITeacherDao {
    @Override
    public List<Teacher> findAll() throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        List<Teacher> result = queryRunner.query("select * from teacher", new BeanListHandler<Teacher>(Teacher.class));
        return result;
    }

    @Override
    public Teacher findByTno(int tno) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {tno};
        Teacher result = queryRunner.query("select * from teacher where tno=?", new BeanHandler<>(Teacher.class), param);
        return result;
    }

    @Override
    public void deleteByTeacherName(String teacherName) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {teacherName};
        queryRunner.update("delete from teacher where name=?",param);
    }

    @Override
    public void deleteByTeacherId(int id) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {id};
        queryRunner.update("delete from teacher where id=?",param);
    }

    @Override
    public void updateByTeacherId(int id, Teacher teacher) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {teacher.getName(),teacher.getTno(),teacher.getAcademic(),teacher.getBirthday(),teacher.getSex(),teacher.getDescription(),id};
        queryRunner.update("update teacher set name=?,tno=?,academic=?,birthday=?,sex=?,description=? where id=?",param);
    }

    @Override
    public void insert(Teacher teacher) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {teacher.getName(),teacher.getTno(),teacher.getAcademic(),teacher.getBirthday(),teacher.getSex(),teacher.getDescription()};
        queryRunner.update("insert into teacher(name,tno,academic,birthday,sex,description) values(?,?,?,?,?,?)",param);
    }

    @Override
    public List<Teacher> findLike(String keyword) throws Exception {
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] param = {keyword};
        List<Teacher> result = queryRunner.query("select * from teacher where name like ?", new BeanListHandler<Teacher>(Teacher.class), param);
        return result;
    }
}
