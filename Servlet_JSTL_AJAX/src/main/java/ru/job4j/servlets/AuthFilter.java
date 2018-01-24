package ru.job4j.servlets;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by VLADIMIR on 11.12.2017.
 */
public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    /**
     * Проверит зарегестринован ли пользователь. Если нет то переадресует на страницу регистрации.
     * @param servletRequest - Request.
     * @param servletResponse - Response.
     * @param filterChain - filterChain.
     * @throws IOException - IOException.
     * @throws ServletException - ServletException.
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // прокастуем
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;

        // если переход сразу осуществлялся на страницу регистрации, то пропустить переход на страницу регистрации
        if (request.getRequestURI().contains("/signin")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // получаем сессию
            final HttpSession session = request.getSession();

            // если не залогинен
            if (session.getAttribute("sessionUser") == null) {
                // страница регистрации
                final String urlSignIn = String.format("%s/signin", request.getContextPath());
                // перенаправить на страницу регистрации
                response.sendRedirect(urlSignIn);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }


    @Override
    public void destroy() {
    }
}
