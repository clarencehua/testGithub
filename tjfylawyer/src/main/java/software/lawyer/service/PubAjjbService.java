package software.lawyer.service;

import java.util.List;

import software.lawyer.data.dataobject.PubAjJb;

public interface PubAjjbService {
	public List<PubAjJb> findObjects();
	public PubAjJb getAjJbDObyAjxh(long ajxh);
	public List<PubAjJb> getLawyerIiformation(String sfzh);
}
