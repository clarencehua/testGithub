package software.lawyer.data.dao;

import java.util.List;

import software.lawyer.data.dataobject.PubAjJb;

public interface PubajjbDao extends BaseDao<PubAjJb>{
	public PubAjJb getAjJbDObyAjxh(long ajxh);
	public List<PubAjJb> find(String sfzh);
}
