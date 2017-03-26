package software.lawyer.service.convertor;

import java.util.ArrayList;
import java.util.List;

import software.lawyer.data.dataobject.PubAjJb;
import software.lawyer.service.model.AjjbQss;
import software.lawyer.util.DateUtil;

public class GetLawyerIiformationConvertor {
	public List<AjjbQss> Lawyerinformation(List<PubAjJb> list){
		ArrayList<AjjbQss> list1=new ArrayList<AjjbQss>();
		for (PubAjJb pubAjJb : list) {
			AjjbQss e=new AjjbQss();
			e.setAjmc(pubAjJb.getAjmc());
			e.setAh(pubAjJb.getAh());
			e.setLarq(pubAjJb.getLarq());
			list1.add(e);
		}
		return list1;
	}
}
