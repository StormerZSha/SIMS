package service.impl;

import dao.impl.TeacherDao;
import dao.intf.ITeacherDao;
import domain.Teacher;
import service.intf.ITeacherService;

import java.util.List;

public class TeacherService implements ITeacherService {
    ITeacherDao teacherDao = new TeacherDao();

    /**
     * 查询所有教师信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Teacher> findAll() throws Exception {
        List<Teacher> result = teacherDao.findAll();
        return result;
    }

    /**
     * 添加一条教师信息
     * @param teacher
     * @throws Exception
     */
    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        teacherDao.insert(teacher);
    }

    /**
     * 根据id删除一条教师信息
     * @throws Exception
     */
    @Override
    public void deleteById(int id) throws Exception {
        teacherDao.deleteByTeacherId(id);
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     * @throws Exception
     */
    @Override
    public List<Teacher> findLike(String keyword) throws Exception {
        List<Teacher> result = teacherDao.findLike("%" + keyword + "%");
        return result;
    }

    /**
     * 根据教师编号查询教师信息
     * @param tno
     * @return
     * @throws Exception
     */
    @Override
    public Teacher findTeacherByTno(int tno) throws Exception {
        Teacher result = teacherDao.findByTno(tno);
        return result;
    }
}
