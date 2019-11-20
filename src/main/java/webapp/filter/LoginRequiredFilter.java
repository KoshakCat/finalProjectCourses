package webapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginRequiredFilter implements Filter {

        @Override
        public void destroy() {

        }

        @Override
        public void doFilter(ServletRequest servletRequest,
                             ServletResponse servletResponse, FilterChain chain)
                throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) servletRequest;

            if (request.getSession().getAttribute("name") != null) {
                chain.doFilter(servletRequest, servletResponse);
            } else {
                request.getRequestDispatcher("/login").forward(servletRequest,
                        servletResponse);
            }
        }

        @Override
        public void init(FilterConfig arg0) throws ServletException {
        }

    }

