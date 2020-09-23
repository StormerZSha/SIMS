package service.impl;

import dao.impl.StudentDao;
import dao.intf.IStudentDao;
import domain.Student;
import service.intf.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentDao studentDao = new StudentDao();
    /**
     * 获取所有学生信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findAll() throws Exception {
        List<Student> result = studentDao.findAll();
        return result;
    }

    /**
     * 根据学生关键字查询学生信息
     * @param keyWord
     * @return
     * @throws Exception
     */
    @Override
    public Student findStudentByName(String keyWord) throws Exception {
        return null;
    }

    /**
     * 添加一条学生信息
     * @param student
     * @throws Exception
     */
    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.insert(student);
    }

    /**
     * 根据学生ID删除学生信息
     * @param id
     * @throws Exception
     */
    @Override
    public void deleteById(int id) throws Exception {
        studentDao.deleteById(id);
    }

    @Override
    public List<Student> findLike(String keyword) throws Exception{
        List<Student> result = studentDao.findLike("%"+keyword+"%");
        return result;
    }

    /**
     * 详情
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Student findDetail(int id) throws Exception {
        Student result = studentDao.findDetail(id);
        return result;
    }

    /**
     * 根据学生sno查询学生信息
     * @return
     * @throws Exception
     */
    @Override
    public Student findStudentBySno(int sno) throws Exception {
        Student result = studentDao.findBySno(sno);
        return result;
    }

    /**
     * 学生注册更新(专业和宿舍)
     * @param specialityid
     * @param dormitoryid
     * @throws Exception
     */
    @Override
    public void updateStudent(int specialityid, int dormitoryid,int id) throws Exception {
        studentDao.updateStudent(specialityid,dormitoryid,id);
    }

    /**
     * 查询没有宿舍的学生
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentNotDormitory() throws Exception{
        List<Student> result = studentDao.findStudentNotDormitory();
        return result;
    }

    /**
     * 给学生添加宿舍
     * @param dorId
     * @param
     * @throws Exception
     */
    @Override
    public void updateStudentDormitory(int dorId, String[] values) throws Exception {
        for (String s : values) {
          studentDao.updateStudentDormitory(dorId,Integer.parseInt(s));
        }
    }

    /**
     * 查询当前宿舍的所有学生信息
     * @param dorId
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentDormitory(int dorId) throws Exception {
        List<Student> result = studentDao.findStudentDormitory(dorId);
        return result;
    }

    /**
     * 删除当前学生的宿舍信息
     * @param values
     * @throws Exception
     */
    @Override
    public void updateStudentDormitoryIsNull(String[] values) throws Exception {
        for (String s: values){
            studentDao.updateStudentDormitoryIsNull(Integer.parseInt(s));
        }
    }

    /**
     * 查询没有专业的学生
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentNotSpeciality() throws Exception{
        List<Student> result = studentDao.findStudentNotSpeciality();
        return result;
    }

    /**
     * 给学生添加专业
     * @param speId
     * @param values
     * @throws Exception
     */
    @Override
    public void updateStudentSpeciality(int speId, String[] values) throws Exception {
        for (String s:values){
            studentDao.updateStudentSpeciality(speId,Integer.parseInt(s));
        }
    }

    /**
     * 查询当前专业的所有学生
     * @param speId
     * @return
     * @throws Exception
     */
    @Override
    public List<Student> findStudentSpeciality(int speId) throws Exception {
        List<Student> result = studentDao.findStudentSpeciality(speId);
        return result;
    }

    /**
     * 删除当前学生的专业信息
     * @param values
     * @throws Exception
     */
    @Override
    public void updateStudentSpecialityIsNull(String[] values) throws Exception {
        for (String s:values){
            studentDao.updateStudentSpecialityIsNull(Integer.parseInt(s));
        }
    }
}
