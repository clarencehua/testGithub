package software.lawyer.data.dataobject;

// default package

import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import software.lawyer.util.DateUtil;

/**
 * Complain entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "complain", catalog = "itcasttax")
public class Complain implements java.io.Serializable {

	// Fields

	private String compId;
	private String compCompany;
	private String compName;
	private String compMobile;
	private boolean isNm;
	private String compTime;
	private String compTitle;
	private String toCompName;
	private String toCompDept;
	private String compContent;
	private String state;
	private Set<ComplainReply> complainReplies = new HashSet<ComplainReply>();

	// 状态
	public static String COMPLAIN_STATE_UNDONE = "0";
	public static String COMPLAIN_STATE_DONE = "1";
	public static String COMPLAIN_STATE_INVALID = "2";
	public static Map<String, String> COMPLAIN_STATE_MAP;
	static {
		COMPLAIN_STATE_MAP = new HashMap<String, String>();
		COMPLAIN_STATE_MAP.put(COMPLAIN_STATE_UNDONE, "待受理");
		COMPLAIN_STATE_MAP.put(COMPLAIN_STATE_DONE, "已受理");
		COMPLAIN_STATE_MAP.put(COMPLAIN_STATE_INVALID, "已失效");
	}

	// Constructors

	/** default constructor */
	public Complain() {
	}

	/** minimal constructor */
	public Complain(String compId, String compTitle) {
		this.compId = compId;
		this.compTitle = compTitle;
	}

	/** full constructor */
	public Complain(String compId, String compCompany, String compName,
			String compMobile, boolean isNm, String compTime, String compTitle,
			String toCompName, String toCompDept, String compContent,
			String state, Set<ComplainReply> complainReplies) {
		this.compId = compId;
		this.compCompany = compCompany;
		this.compName = compName;
		this.compMobile = compMobile;
		this.isNm = isNm;
		this.compTime = compTime;
		this.compTitle = compTitle;
		this.toCompName = toCompName;
		this.toCompDept = toCompDept;
		this.compContent = compContent;
		this.state = state;
		this.complainReplies = complainReplies;
	}

	// Property accessors
	@Id
	@Column(name = "comp_id", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getCompId() {
		return this.compId;
	}

	public void setCompId(String compId) {
		this.compId = compId;
	}

	@Column(name = "comp_company", length = 100)
	public String getCompCompany() {
		return this.compCompany;
	}

	public void setCompCompany(String compCompany) {
		this.compCompany = compCompany;
	}

	@Column(name = "comp_name", length = 20)
	public String getCompName() {
		return this.compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	@Column(name = "comp_mobile", length = 20)
	public String getCompMobile() {
		return this.compMobile;
	}

	public void setCompMobile(String compMobile) {
		this.compMobile = compMobile;
	}

	@Column(name = "is_NM")
	public boolean getIsNm() {
		return this.isNm;
	}

	public void setIsNm(boolean isNm) {
		this.isNm = isNm;
	}

	@Column(name = "comp_time", length = 19)
	public String getCompTime() {
		return this.compTime;
	}

	public void setCompTime(String compTime) {
		this.compTime = compTime;
	}

	@Column(name = "comp_title", nullable = false, length = 200)
	public String getCompTitle() {
		return this.compTitle;
	}

	public void setCompTitle(String compTitle) {
		this.compTitle = compTitle;
	}

	@Column(name = "to_comp_name", length = 20)
	public String getToCompName() {
		return this.toCompName;
	}

	public void setToCompName(String toCompName) {
		this.toCompName = toCompName;
	}

	@Column(name = "to_comp_dept", length = 100)
	public String getToCompDept() {
		return this.toCompDept;
	}

	public void setToCompDept(String toCompDept) {
		this.toCompDept = toCompDept;
	}

	@Column(name = "comp_content")
	public String getCompContent() {
		return this.compContent;
	}

	public void setCompContent(String compContent) {
		this.compContent = compContent;
	}

	@Column(name = "state", length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "complain")
	@OrderBy("replyTime ASC")
	public Set<ComplainReply> getComplainReplies() {
		return this.complainReplies;
	}

	public void setComplainReplies(Set<ComplainReply> complainReplies) {
		this.complainReplies = complainReplies;
	}

	

	
	
}