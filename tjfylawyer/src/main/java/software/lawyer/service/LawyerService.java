package software.lawyer.service;

import java.util.List;

import software.lawyer.data.dataobject.Lawyer;

public interface LawyerService {
	public void save(Lawyer lawyer);
	public List<Lawyer> find();
}
