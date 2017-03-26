package software.lawyer.data.dataobject;

// default package

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * Info entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "info", catalog = "itcasttax")
public class Info implements java.io.Serializable {

	// Fields

	private String infoId;
	private String type;
	private String source;
	private String title;
	private String content;
	private String memo;
	private String creator;
	private String createTime;
	private String state;

	// 状态
	public static String INFO_STATE_PUBLIC = "1";// 发布
	public static String INFO_STATE_STOP = "0";// 停用

	// 信息分类
	public static String INFO_TYPE_TZGG = "tzgg";
	public static String INFO_TYPE_ZCSD = "zcsd";
	public static String INFO_TYPE_NSZD = "nszd";
	public static Map<String, String> INFO_TYPE_MAP;
	static {
		INFO_TYPE_MAP = new HashMap<String, String>();
		INFO_TYPE_MAP.put(INFO_TYPE_TZGG, "通知公告");
		INFO_TYPE_MAP.put(INFO_TYPE_ZCSD, "政策速递");
		INFO_TYPE_MAP.put(INFO_TYPE_NSZD, "纳税指导");
	}

	// Constructors

	/** default constructor */
	public Info() {
	}

	/** minimal constructor */
	public Info(String infoId, String title) {
		this.infoId = infoId;
		this.title = title;
	}

	/** full constructor */
	public Info(String infoId, String type, String source, String title,
			String content, String memo, String creator, String createTime,
			String state) {
		this.infoId = infoId;
		this.type = type;
		this.source = source;
		this.title = title;
		this.content = content;
		this.memo = memo;
		this.creator = creator;
		this.createTime = createTime;
		this.state = state;
	}

	// Property accessors
	@Id
	@Column(name = "info_id", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getInfoId() {
		return this.infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}

	@Column(name = "type", length = 10)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "source", length = 50)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "memo", length = 200)
	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "creator", length = 10)
	public String getCreator() {
		return this.creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	@Column(name = "create_time", length = 19)
	public String getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name = "state", length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

}