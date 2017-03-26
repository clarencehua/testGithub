package software.lawyer.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RMPSY_HOLIDAY")
public class RmpsyHolidayDO implements java.io.Serializable {
	private static final long serialVersionUID = 5741160517159659452L;


	private Integer id;
	private Integer juror_id;
	private String holiday_start;
	private String holiday_end;
	private String qjyy;
	public String getQjyy() {
		return qjyy;
	}


	public void setQjyy(String qjyy) {
		this.qjyy = qjyy;
	}


	/** default constructor*/
	public RmpsyHolidayDO() {
		this.id = -1;
	}
	

	/** minimal constructor */
	public RmpsyHolidayDO(Integer id) {
		this.id = id;
	}
	
	public RmpsyHolidayDO(Integer id, Integer juror_id, String holiday_start, String holiday_end) {
		super();
		this.id=id;
		this.juror_id=juror_id;
		this.holiday_start=holiday_start;
		this.holiday_end=holiday_end;
	}
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "juror_id")
	public Integer getJuror_id() {
		return juror_id;
	}


	public void setJuror_id(Integer juror_id) {
		this.juror_id = juror_id;
	}

	@Column(name = "holiday_start")
	public String getHoliday_start() {
		return holiday_start;
	}


	public void setHoliday_start(String holiday_start) {
		this.holiday_start = holiday_start;
	}

	@Column(name = "holiday_end")
	public String getHoliday_end() {
		return holiday_end;
	}


	public void setHoliday_end(String holiday_end) {
		this.holiday_end = holiday_end;
	}
	
}
