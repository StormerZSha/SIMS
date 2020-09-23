package service.intf;

import domain.Course;

import java.util.List;

public interface ICourseService {
    /**
     * 获取所有课程信息
     * @return
     * @throws Exception
     */
    List<Course> findAll() throws Exception;

    /**
     * 添加课程信息
     * @param course
     * @throws Exception
     */
    void addCourse(Course course) throws Exception;

    /**
     * 根据课程ID删除课程信息
     * @param id
     * @throws Exception
     */
    void deleteById(int id) throws Exception;

    /**
     * 模糊查询
     * @return
     * @throws Exception
     */
    List<Course> findLike(String keyword) throws Exception;
}
