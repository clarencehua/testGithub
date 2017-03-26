package software.lawyer.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LAWYER_JL")
public class Lawyer {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private String id;
	@Column(name="lawyer_date",nullable = false)
	private String date;
	@Column(name="lawyer_xm",nullable = false)
	private String xm;
	@Column(name="lawyer_id",nullable = false)
	private String lawyerid;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getLawyerid() {
		return lawyerid;
	}
	public void setLawyerid(String lawyerid) {
		this.lawyerid = lawyerid;
	}
	
	
}
