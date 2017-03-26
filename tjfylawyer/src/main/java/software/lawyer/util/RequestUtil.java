package software.lawyer.util;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


/**
 * 
 * HttpRequest�Ĺ�����
 * 
 * @author zym
 *
 */
public class RequestUtil {
	
	
	/**
	 * ���һ�������ȫ·������������
	 * @param request
	 * @return
	 */
	public static String getFullUrlByReqeust(HttpServletRequest request){
		String doName = request.getServletPath();
		
		String argus="";
		Enumeration<String> names = request.getParameterNames();
		Map<String,String[]> m = request.getParameterMap();
		
		while(names.hasMoreElements()){
			String name = names.nextElement();
			String[] value = m.get(name);
			argus+=name+"="+value[0]+"&";
		}
		
		if(StringUtil.isEmpty(argus)){
			return doName;
		}
		else{
			argus = argus.substring(0, argus.length()-1);
			return doName+"?"+argus;
		}
	}
	
	/**
	 * �ж�һ�������Ƿ�Ϊajax
	 * @param request
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest request){
		String type = request.getHeader("X-Requested-With");
		if(StringUtil.isBlank(type)){
			return false;
		}
		return type.equals("XMLHttpRequest");
	}
}
