package com.codeWithProjects.ecom.config;

import jakarta.servlet.*;

import java.io.IOException;

public interface SimpleCorsFilterint {
    void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException, IOException;

    void init(FilterConfig filterConfig);

    void destroy();
}
