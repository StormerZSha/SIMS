package controller;

import domain.Teacher;
import service.impl.TeacherService;
import service.intf.ITeacherService;
import utils.StringDateTransformUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
    ITeacherService teacherService = new TeacherService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            int sims = Integer.parseInt(request.getParameter("sims"));
            //sims为0，遍历教师信息
            if (sims==0){
                try {
                    List<Teacher> result = teacherService.findAll();
                    request.setAttribute("result",result);
                    request.getRequestDispatcher("/pages/tea-list.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (sims==1){ //sims为1，搜索教师信息
                String keyword = request.getParameter("keyword");
                try {
                    List<Teacher> result = teacherService.findLike(keyword);
                    request.setAttribute("result",result);
                    request.getRequestDispatcher("/pages/tea-list.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (sims==2){ //sims为2，添加教师信息
                String tno = request.getParameter("tno");
                String name = request.getParameter("name");
                String sex = request.getParameter("sex");
                String birth = request.getParameter("birth");
                try {
                    Teacher teacher = new Teacher();
                    //查询数据库中是否有该教师信息
                    Teacher result = teacherService.findTeacherByTno(Integer.parseInt(tno));
                    if (result==null){
                        teacher.setTno(Integer.parseInt(tno));
                        teacher.setName(name);
                        teacher.setSex(Integer.parseInt(sex));
                        teacher.setBirthday(new StringDateTransformUtils().StringToDate(birth));
                        //添加一条教师信息
                        teacherService.addTeacher(teacher);
                        response.sendRedirect("/TeacherController?sims=0");
                    }else {
                        request.setAttribute("massage","当前教师已经存在，请重新输入");
                        request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else if (sims==3){ //删除一条教师信息
                String teacherid = request.getParameter("teacherid");
                try {
                    teacherService.deleteById(Integer.parseInt(teacherid));
                    response.sendRedirect("/TeacherController?sims=0");
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
