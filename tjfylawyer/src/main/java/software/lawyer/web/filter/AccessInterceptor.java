package software.lawyer.web.filter;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



/**
 * ����������
 * 
 * @author zym
 * 
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {
	/*private static final Logger log = Logger.getLogger(AccessInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		String requestURI = request.getRequestURI();
		String toLogin = request.getRequestURL().toString();
		String doName = request.getServletPath();
		if(StringUtil.contains(doName, "WEB-INF")){
			return true;
		}
		String cannotAccess = toLogin.substring(0,
				toLogin.length() - doName.length())
				+ "/login.do";
		UserContext user = (UserContext) request.getSession().getAttribute(
				"userContext");
		if (user == null) {
			if (requestURI.endsWith("/login.do")||requestURI.endsWith("/register.do")||requestURI.endsWith("/test.do")) {
				return true;
			} else {
				log.warn("����ķ���ҳ�档requestURI:" + requestURI);
//				response.sendRedirect(cannotAccess);
//				return false;
				return true;
			}
		} else {
			return true;
		}
	}
*/
}
