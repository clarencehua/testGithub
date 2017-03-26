package software.lawyer.data.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import software.lawyer.data.dao.BaseDao;
import software.lawyer.data.dataobject.PageResult;
import software.lawyer.util.QueryHelper;

public abstract class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
	
	Class<T> clazz;
	
	public BaseDaoImpl(){
		ParameterizedType pt =  (ParameterizedType)this.getClass().getGenericSuperclass();//BaseDaoImpl<User>
		clazz = (Class<T>)pt.getActualTypeArguments()[0];
	}
	public void save(T entity) {
		try{
			getHibernateTemplate().save(entity);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void update(T entity) {
		getHibernateTemplate().update(entity);
	}

	public void delete(Serializable id) {
		getHibernateTemplate().delete(findObjectById(id));
	}

	public T findObjectById(Serializable id) {
		return getHibernateTemplate().get(clazz, id);
	}

	public List<T> findObjects() {
		
		//Query query  = getSession().createQuery("FROM " + clazz.getSimpleName());
		List<T> list=getHibernateTemplate().find("FROM " + clazz.getSimpleName());
		//List<T> list=null;
		/*List list=new ArrayList<Postb>();
		Postb p=new Postb();
		p.setPostId(1);
		list.add(p);*/
		/*try {
			list=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
		System.out.println(list);
		return list;
	}

	public List<T> findObjects(String hql, List<Object> parameters) {
		Query query = getSession().createQuery(hql);
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}

	public List<T> findObjects(QueryHelper queryHelper) {
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		return query.list();
	}
	
	public PageResult getPageResult(QueryHelper queryHelper, int pageNo, int pageSize) {
		Query query = getSession().createQuery(queryHelper.getQueryListHql());
		List<Object> parameters = queryHelper.getParameters();
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				query.setParameter(i, parameters.get(i));
			}
		}
		if(pageNo < 1) pageNo = 1;
		
		query.setFirstResult((pageNo-1)*pageSize);//设置数据起始索引号
		query.setMaxResults(pageSize);
		List items = query.list();
		//获取总记录数
		Query queryCount = getSession().createQuery(queryHelper.getQueryCountHql());
		if(parameters != null){
			for(int i = 0; i < parameters.size(); i++){
				queryCount.setParameter(i, parameters.get(i));
			}
		}
		long totalCount = (Long)queryCount.uniqueResult();
		
		return new PageResult(totalCount, pageNo, pageSize, items);
	}
}
