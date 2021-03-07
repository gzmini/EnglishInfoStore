package main.java.com.gzmini.common;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SetCharacterEncodingfilter extends HttpServlet implements Filter {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private FilterConfig filterConfig;

    private String encoding = null;



    // Handle the passed-in FilterConfig
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    // Process the request/response pair
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterChain) {
        try {
            if (encoding == null) {

                encoding = filterConfig.getInitParameter("encoding");

            }
            if (encoding == null) {

                encoding = System.getProperty("file.encoding", "gb2312");

            }

            request.setCharacterEncoding(encoding);
            response.setContentType("text/html;charset=" + encoding);
            filterChain.doFilter(request, response);
        } catch (ServletException sx) {
            filterConfig.getServletContext().log(sx.getMessage());
        } catch (IOException iox) {
            filterConfig.getServletContext().log(iox.getMessage());
        }
    }

    // Clean up resources
    public void destroy() {

    }
}

