package software.lawyer.service;

import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;


/**
 * ϵͳ�쳣����
 * @author ruanhao
 *
 */
public class SystemExceptionResolver extends SimpleMappingExceptionResolver {

	/**
	 * modified modified at 2012-7-6 by YU ��������־��¼��ʽlogException
	 * �������쳣��¼��Logger
	 */
	private static Logger logger = Logger.getLogger(SystemExceptionResolver.class);
	
	/**
	 * Ĭ�ϵ��ַ���
	 */
	private static final String DEFAULT_CHARSET = "utf-8";
	
		
	@Override
	protected ModelAndView doResolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		String  url = request.getRequestURI();
		
		//Ajax����
		if(url.endsWith(".aj")){
			
			String error = "{\"exception\":\"����ϵͳ�쳣������ϵͳ����Ա��ϵ��\"}";
			try {
				if(null!=error){
					writeJsonResponse(response, error);
				}
			} catch (Exception e) {
				logger.error("������Ϣʧ�ܣ�", e);
			}
			return null;
		}else{
			return super.doResolveException(request, response, handler, ex);
		}
	}
	/**
	 * ������SimpleMappingExceptionResolver��logException����
	 * modified modified at 2012-7-6 by YU ��������־��¼��ʽlogException
	 * �����쳣��־��¼��ʽ
	 */
	protected void logException(Exception ex, HttpServletRequest request) {
		String msg = null;
		msg = this.buildExceptionMessage(request);
		if(msg == null){
			msg="Unknown Request.";
		}
		if(ex == null){
			ex = new Exception(msg);
		}
		logger.error(msg,ex);
	}
	
	/**
	 * �����쳣������־����
	 * 
	 * @param request
	 * @return
	 */
	private String buildExceptionMessage(HttpServletRequest request){
		String msg = "parameters:";
		try {
			for (Enumeration e = request.getParameterNames() ; e.hasMoreElements() ;) {
	            String parameterName = (String) e.nextElement();
	            if(parameterName == null){
	            	continue;
	            }
	            String parameterValue = request.getParameter(parameterName);
	            if(parameterValue == null){
	            	parameterValue="null";
	            }
	            msg += ("["+parameterName+"="+parameterValue+"]");
	        } 
		} catch (Exception e) {
			logger.error("Error in buildExceptionMessage", e);
		}
		
		if(msg.equals("parameters:")){
			msg += "No HttpServletRequest parameter.";
		}
		return msg;
		
	}
	
	/**
	 * ��Response��дjson����
	 * @param response
	 * @param content
	 * @throws Exception
	 */
	private void writeJsonResponse(HttpServletResponse response, String content) throws Exception{
		response.addHeader("Content-Type", "text/html;charset=" + DEFAULT_CHARSET);
        response.setCharacterEncoding(DEFAULT_CHARSET);
        PrintWriter writer = response.getWriter();
        writer.write(content);
        writer.flush();
        writer.close();
	}
}
