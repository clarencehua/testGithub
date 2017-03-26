package software.lawyer.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import software.lawyer.data.dataobject.User;
import software.lawyer.dynamicds.Constant;
import software.lawyer.service.model.UserModel;
import software.lawyer.web.permission.PermissionCheck;

public class LoginFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		// 判断当前请求地址是否是登录的请求地址
		if (!uri.contains("sys/login_")) {
			// 非登录请求
			
			
			if (request.getSession().getAttribute(Constant.USER) != null) {
				// 说明已经登录过
				// 判断是否访问纳税服务系统
				if (uri.contains("/nsfw/")) {
					// 访问纳税服务子系统
					UserModel user = (UserModel) request.getSession()
							.getAttribute(Constant.USER);
					// 获取spring容器
					WebApplicationContext applicationContext = WebApplicationContextUtils
							.getWebApplicationContext(request.getSession()
									.getServletContext());
					PermissionCheck pc = (PermissionCheck) applicationContext
							.getBean("permissionCheck");
					if (pc.isAccessible(user, "nsfw")) {
						// 说明有权限，放行
						chain.doFilter(request, response);
					} else {
						// 没有权限，跳转到没有权限提示页面
						response.sendRedirect(request.getContextPath()
								+ "/sys/login_toNoPermissionUI.do");
					}
				} else {
					// 非访问纳税服务子系统，则直接放行
					chain.doFilter(request, response);
				}
			} else {
				// 没有登录，跳转到登录页面
				response.sendRedirect(request.getContextPath()
						+ "/sys/login_toLoginUI.do");
			}
		} else {
			// 登录请求；直接放行
			chain.doFilter(request, response);
		}

	}

	public void destroy() {
	}

}
