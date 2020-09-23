package controller;

import domain.Dormitory;
import domain.Speciality;
import domain.Student;
import service.impl.SpecialityService;
import service.impl.StudentService;
import service.intf.ISpecialitySercice;
import service.intf.IStudentService;
import utils.StringDateTransformUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SpecialityController")
public class SpecialityController extends HttpServlet {
    ISpecialitySercice specialitySercice = new SpecialityService();
    IStudentService studentService = new StudentService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int sims = Integer.parseInt(request.getParameter("sims"));
        //sims为0，遍历专业信息
        if (sims==0){
            try {
                List<Speciality> result = specialitySercice.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/spe-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //sims为1，搜索专业信息
        }else if (sims==1){
            String keyword = request.getParameter("keyword");
            try {
                List<Speciality> result = specialitySercice.findLike(keyword);
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/spe-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==2){ //sims为2，添加专业信息
            String name = request.getParameter("name");
            String faculty = request.getParameter("faculty");
            String type = request.getParameter("type");
            Speciality speciality = new Speciality();
            speciality.setName(name);
            speciality.setFaculty(faculty);
            speciality.setType(Integer.parseInt(type));
            try {
                //添加一条专业信息
                specialitySercice.addSpeciality(speciality);
                response.sendRedirect("/SpecialityController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==3){ //删除一条专业信息
            String specialityid = request.getParameter("specialityid");
            try {
                specialitySercice.deleteById(Integer.parseInt(specialityid));
                response.sendRedirect("/SpecialityController?sims=0");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==4){ //专业详情信息
            String specialityid = request.getParameter("specialityid");
            try {
                Speciality result = specialitySercice.findDetail(Integer.parseInt(specialityid));
                request.setAttribute("spe",result);
                request.getRequestDispatcher("/pages/spe-detail.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==5){ //注册(返回专业和没有选择专业的数据)
            int type = (Integer) request.getSession().getAttribute("type");
            //管理员权限
            if (1==type){
                int specialityid = Integer.parseInt(request.getParameter("specialityid"));
                try {
                    Speciality spe = specialitySercice.findDetail(specialityid);
                    List<Student> student = studentService.findStudentNotSpeciality();
                    request.setAttribute("student",student);
                    request.setAttribute("spe",spe);
                    request.getRequestDispatcher("/pages/spe-update-on.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("massage","当前用户权限不足！");
                request.getRequestDispatcher("/pages/fail.jsp");
            }
        }else if (sims==6){ //注册(给学生添加专业)
            String specialityid = request.getParameter("specialityid");
            System.out.println(specialityid);
            String[] values = request.getParameterValues("studentid") ;
            System.out.println(values[0]);
            if(values!=null&&values.length>0){
                try {
                    studentService.updateStudentSpeciality(Integer.parseInt(specialityid),values);
                    response.sendRedirect("/SpecialityController?sims=0");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("massage","请选择专业学生！");
                request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
            }
        }else if (sims==7){ //撤销(返回该专业和选择该专业的学生)
            int type = (Integer) request.getSession().getAttribute("type");
            //管理员权限
            if (1==type){
                int specialityid = Integer.parseInt(request.getParameter("specialityid"));
                try {
                    Speciality spe = specialitySercice.findDetail(specialityid);
                    List<Student> result = studentService.findStudentSpeciality(specialityid);
                    request.setAttribute("spe",spe);
                    request.setAttribute("student",result);
                    request.getRequestDispatcher("/pages/spe-update-off.jsp").forward(request,response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("massage","当前用户权限不足！");
                request.getRequestDispatcher("/pages/fail.jsp");
            }
        }else if (sims==8){ //撤销(删除学生专业)
            String[] values = request.getParameterValues("studentid");
            if(values!=null&&values.length>0){
                try {
                    studentService.updateStudentSpecialityIsNull(values);
                    response.sendRedirect("/SpecialityController?sims=0");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("massage","请选择专业学生！");
                request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
