package utils;

import dao.impl.*;
import dao.intf.IStudentDao;
import dao.intf.IUserDao;
import domain.*;
import org.junit.Test;
import service.impl.UserService;
import service.intf.IUserService;

import java.sql.SQLException;
import java.util.List;

public class test {
    @Test
    public void findStudentWithAllTTest(){

        try {
            IStudentDao studentDao=new StudentDao();
            Student studentWithAll = studentDao.findStudentWithAll(1);
            System.out.println(studentWithAll);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findDormitory(){
        try {
            List<Dormitory> dormitories = new DormitoryDao().findAll();
            for (Dormitory dormitory:dormitories){
                System.out.println(dormitory.getDno());
                System.out.println(dormitory.getType());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindById(){
        try {
            Dormitory dno = new DormitoryDao().findByDno(221);
            System.out.println(dno.getDno());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdateDormitory(){
        Dormitory dormitory = new Dormitory();
        dormitory.setDno(221);
        dormitory.setType(1);
        try {
            new DormitoryDao().updateById(1,dormitory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testDeleteDormitory(){
        try {
            new DormitoryDao().deleteById(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertDormitory(){
        Dormitory dormitory = new Dormitory();
        dormitory.setDno(421);
        dormitory.setType(1);
        try {
            new DormitoryDao().inset(dormitory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testInsertCourse(){
        Course course = new Course();
        course.setId(1);
        course.setName("Java程序设计");
        course.setCridit(100);
        course.setCheck(1);
        try {
            new CourseDao().insert(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindTeacher(){
        try {
            List<Teacher> teachers = new TeacherDao().findAll();
            for (Teacher teacher:teachers){
                System.out.println(teacher.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() throws Exception {
        IUserDao userDao=new UserDao();
        User kk = userDao.findUserByUsername("kk");
        System.out.println(kk);
    }
}
