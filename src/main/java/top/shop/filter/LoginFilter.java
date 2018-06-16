package top.shop.filter;

import top.shop.dao.UserDao;
import top.shop.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 */
@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String servletPath = req.getServletPath();
        if ("/login".equals(servletPath)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = null;
            try {
                user = UserDao.getUserDao().loadUserByPassWord(username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (user != null) {
                //登陆成功
                resp.sendRedirect(req.getServletContext().getContextPath() + "/index.jsp");
                req.getSession().setAttribute("user", user);
            } else {
                resp.sendRedirect(req.getServletContext().getContextPath() + "/login.jsp");
            }
        } else {
            if (req.getSession().getAttribute("user") != null) {
                chain.doFilter(request, response);
            } else {
                if ("/CartServlet".equals(servletPath) || "/fruitServlet".equals(servletPath) || "typeServlet".equals(servletPath) || "userServlet".equals(servletPath)) {
                    resp.sendRedirect(req.getServletContext().getContextPath() + "/login.jsp");
                } else {
                    chain.doFilter(request, response);
                }
            }
        }
    }

    @Override
    public void destroy() {

    }
}
