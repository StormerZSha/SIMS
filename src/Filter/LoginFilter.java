//package Filter;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/*")
//public class LoginFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//
//    }
//
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest request=(HttpServletRequest) req;
//        HttpServletResponse response=(HttpServletResponse) resp;
//        String requestURI = request.getRequestURI();
//
//        //如果是登录注册页面或者是登录注册请求路径就放行
//        if ()
//        {
//            chain.doFilter(req,resp);
//        }else{
//            Object username = request.getSession().getAttribute("username");
//            if (username!=null){
//                chain.doFilter(req,resp);
//            }else {
//                request.setAttribute("massage","您还没有登录，请登录");
//                request.getRequestDispatcher("/pages/fail.jsp").forward(request,response);
//            }
//        }
//        chain.doFilter(req, resp);
//    }
//
//    public void destroy() {
//    }
//
//}
