package controller;

import domain.Course;
import domain.Dormitory;
import domain.Speciality;
import domain.Student;
import service.impl.CourseService;
import service.intf.ICourseService;
import utils.StringDateTransformUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
    ICourseService courseService = new CourseService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sims = Integer.parseInt(request.getParameter("sims"));
        //sims为0，遍历课程信息
        if (sims==0){
            try {
                List<Course> result = courseService.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/cou-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==1){ //sims为1，搜索课程信息
            String keyword = request.getParameter("keyword");
            try {
                List<Course> result = courseService.findLike(keyword);
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/cou-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==2){ //sims为2，添加课程信息
            String name = request.getParameter("name");
            String cridit = request.getParameter("cridit");
            String type = request.getParameter("type");
            Course course = new Course();
            course.setName(name);
            course.setCridit(Integer.parseInt(cridit));
            course.setCheck(Integer.parseInt(type));
            try {
                courseService.addCourse(course);
                response.sendRedirect("/CourseController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==3){ //删除一条课程信息
            String courseid = request.getParameter("courseid");
            try {
                courseService.deleteById(Integer.parseInt(courseid));
                response.sendRedirect("/CourseController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
