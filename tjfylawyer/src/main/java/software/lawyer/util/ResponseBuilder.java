package software.lawyer.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;



import com.google.gson.Gson;

/**
 * Http��Ӧ�Ĺ�����
 * 
 * @author zym
 * 
 */
public class ResponseBuilder {
	
	/**
	 * Ĭ�ϵ��ַ���
	 */
	private static final String DEFAULT_CHARSET = "utf-8";
	
	
	/**
	 * ����Json��ʽ�Ľ��
	 * 
	 * @param response http��Ӧ����
	 * @param content ��Ӧ����
	 * @throws IOException 
	 */
	public void writeJsonResponse(HttpServletResponse response, String content) throws IOException {
		response.addHeader("Content-Type", "application/json;charset=" + DEFAULT_CHARSET);
		//response.set
        response.setCharacterEncoding(DEFAULT_CHARSET);
        
        PrintWriter writer = response.getWriter();
        writer.write(content);
        writer.flush();
        writer.close();
	}
	
	public void writeAjaxJsonResponse(HttpServletResponse response, String content) throws IOException {
		response.addHeader("Content-Type", "text/html;charset=" + DEFAULT_CHARSET);
		//response.set
        response.setCharacterEncoding(DEFAULT_CHARSET);
        
        PrintWriter writer = response.getWriter();
        writer.write(content);
        writer.flush();
        writer.close();
	}
	
	/**
	 * 
	 * @param response
	 * @param o
	 * @throws Exception
	 */
	public void writeAjaxJsonResponse(HttpServletResponse response, Object o) throws IOException{
		Gson gson = new Gson();
		String content = gson.toJson(o);
		writeAjaxJsonResponse(response, content);
	}
	
	/**
	 * 
	 * @param response
	 * @param o
	 * @throws Exception
	 */
	public void writeJsonResponse(HttpServletResponse response, Object o) throws IOException{
		Gson gson = new Gson();
		String content = gson.toJson(o);
		writeJsonResponse(response, content);
	}
	
	/**
	 * 
	 * @param response
	 * @param o
	 * @throws Exception
	 */
	public void writeJsonResponseAH(HttpServletResponse response, String o) throws IOException{
		Gson gson = new Gson();
		String content = gson.toJson(o);
		writeJsonResponse(response, content);
	}
	
	/**
	 * ���������ת����json��ʽ����
	 *  
	 * @param response http��Ӧ����
	 * @param LaayVO ��������
	 * @throws Exception
	 */
	public void writeJsonResponseFafs(HttpServletResponse response,String fafs) throws Exception{
		Gson gson = new Gson();
		String strJson = gson.toJson(fafs);
		writeJsonResponse(response, strJson);
	}
	
	
}