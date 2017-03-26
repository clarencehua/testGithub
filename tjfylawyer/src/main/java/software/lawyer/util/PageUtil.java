package software.lawyer.util;

import java.util.ArrayList;
import java.util.List;


/**
 * ��ҳ����ع��߷���
 * @author zym
 *
 */
public class PageUtil {

	/**
	 * ����ĳЩ���ݿ⣬��֧�ַ�ҳ��ѯ�﷨����Sybase
	 * ֻ�ܷ����������ݣ����ڴ��з�ҳ��
	 * @param data
	 * @param pageSize ҳ��С
	 * @param page ҳ��
	 * @return
	 */
	List<?> getDataByPage(List<?> data, int pageSize, int page){
		long allsize = data.size();
		if((page-1)*pageSize>allsize){
			return null;
		}
		List<Object> resultList = new ArrayList<Object>();
		int i=0,j=0;
		for(Object element:data){
			if(i>=(page-1)*pageSize){
				resultList.add(element);
				j++;
				if(j>pageSize){
					break;
				}
			}
			i++;
		}
		return resultList;
	}
	
	
	/**
	 * �Զ����ɷ�ҳsql
	 * 
	 * @param sql
	 * @param pageSize
	 * @param page
	 * @return
	 */
	String generatePageSqlForMysql(String sql, int pageSize, int page){
		long start = (page-1)*pageSize;
		sql += start+","+pageSize;
		return sql;
	}
	
	
}
