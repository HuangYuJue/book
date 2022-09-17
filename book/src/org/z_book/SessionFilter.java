/*
package org.z_book;
import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

*/
/*
 * book在myssm之前，那book里面的代码优先执行，SessionFilter后，myssm的CharacterFilter就执行不到了
 * 就是post请求需要设置编码格式时执行不到，b开头先执行会出现小问题
 *//*

@WebFilter(urlPatterns = {"*.do"},
            initParams = {@WebInitParam(name = "bai",
                    value = "/page.do?operate=page&page=user/login," +
                            "/page.do?operate=page&page=user/register," +
                            "/user.do?null," +
                            "/book.do?operate=index"
            )})
public class SessionFilter implements Filter {

    List<String> baiList = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String bai = filterConfig.getInitParameter("bai");
        String[] baiArr = bai.split(",");//用逗号隔开，并得到String类型的数组
        System.out.println(baiArr);
        baiList = Arrays.asList(baiArr);//将数组转换为List集合
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("SessionFilter中request.getRequestURI() = "+request.getRequestURI());
        System.out.println("SessionFilter中request.getQueryString = "+request.getQueryString());
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        String str = uri + "?" + queryString;
        if (baiList.contains(str)){
            //如果白名单集合中包含str，则放行
            filterChain.doFilter(request,response);
        }else {
            //如果白名单集合中不包含str，则获取到当前登录用户
            HttpSession session = request.getSession();
            Object user = session.getAttribute("user");
            if (user == null){
                //如果不存在当前用户，则返回登陆页面
                response.sendRedirect("page.do?operate=&page=user/login");
            }else {
                //如果存在，则放行
                filterChain.doFilter(request,response);
            }
        }
    }
    @Override
    public void destroy() {

    }
}
*/
