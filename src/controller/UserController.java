package controller;

import domain.User;
import service.impl.UserService;
import service.intf.IUserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        IUserService userService = new UserService();
        int sims = Integer.parseInt(request.getParameter("sims"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        HttpSession session = request.getSession();
        String drawCode = session.getAttribute("drawCode").toString();
        Boolean flag = drawCode.equalsIgnoreCase(code);//验证码
        //if-start
        if (sims == 0) { //用户登录
            if (flag){
                try {
                    User login = userService.login(user);
                    if (login!=null) {
                        //登陆成功，重定向
                        session.setAttribute("type",login.getType());
                        session.setAttribute("username",login.getUsername());
                        response.sendRedirect("/pages/main.jsp");
                    } else {
                        //登录失败,跳转到失败页面
                        request.setAttribute("massage", "登录失败，请检查用户名密码是否输入正确");
                        request.getRequestDispatcher("/pages/fail.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //验证码错误
                request.setAttribute("massage", "验证码错误");
                request.getRequestDispatcher("/pages/fail.jsp").forward(request, response);
            }
        } else if (sims == 1) {//用户注册
            if (flag) {
                try {
                    Boolean register = userService.register(user);
                    if (register) {
                        response.sendRedirect("/pages/login.jsp");
                    } else {
                        request.setAttribute("massage", "注册失败");
                        request.getRequestDispatcher("/pages/fail.jsp").forward(request, response);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                //验证码错误
                request.setAttribute("massage", "验证码错误");
                request.getRequestDispatcher("/pages/fail.jsp").forward(request, response);
            }
        } else if (sims == 2) {//用户查询
            try {
                List<User> result = userService.findAll();
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/user-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (sims == 3) {//用户授权
            String name = (String) session.getAttribute("username");
            if ("root".equals(name)){
                try {
                    userService.updateGrant(username,1);
                    response.sendRedirect("/UserController?sims=2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("massage","非ROOT用户，权限不足");
                request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
            }
        }else if (sims==4){//用户添加
                int type= (int) session.getAttribute("type");
                if (type==1){//如果是管理员
                    try {
                        user.setType(Integer.parseInt(request.getParameter("type")));
                        user.setPassword("123456");
                        //查询数据库添加用户是否存在
                        User result = userService.findUserByName(username);
                        if (result==null){
                            userService.add(user);
                            response.sendRedirect("/UserController?sims=2");
                        }else {
                            request.setAttribute("massage","添加用户已经存在，请重新输入");
                            request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
        }else if (sims == 5){ //模糊查询
            String keyword = request.getParameter("keyword");
            try {
                List<User> result = userService.findLike(keyword);
                request.setAttribute("result",result);
                request.getRequestDispatcher("/pages/user-list.jsp").forward(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==6){ //用户删除
            try {
                userService.deleteUserByName(username);
                response.sendRedirect("/UserController?sims=2");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (sims==7){ //撤销授权
            String name = (String) session.getAttribute("username");
            if ("root".equals(name)&&!"root".equals(username)){
                try {
                    userService.updateGrant(username,0);
                    response.sendRedirect("/UserController?sims=2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else {
                request.setAttribute("massage","管理员不能给自己撤权！");
                request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
            }
        }
        //if-end
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
