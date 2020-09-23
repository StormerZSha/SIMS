package service.impl;

import dao.impl.CourseDao;
import dao.intf.ICourseDao;
import domain.Course;
import service.intf.ICourseService;

import java.util.List;

public class CourseService implements ICourseService {
    ICourseDao courseDao = new CourseDao();
    @Override
    public List<Course> findAll() throws Exception {
        List<Course> result = courseDao.findAll();
        return result;
    }

    @Override
    public void addCourse(Course course) throws Exception {
        courseDao.insert(course);
    }

    @Override
    public void deleteById(int id) throws Exception {
        courseDao.deleteById(id);
    }

    @Override
    public List<Course> findLike(String keyword) throws Exception {
        List<Course> result = courseDao.findLike("%" + keyword + "%");
        return result;
    }
}
