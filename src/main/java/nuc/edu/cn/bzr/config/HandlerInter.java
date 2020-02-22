package nuc.edu.cn.bzr.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HandlerInter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("power", "没有权限，请先登录");
            request.getRequestDispatcher("/to/login").forward(request, response);
            return false;
        }
        return true;
    }
}
