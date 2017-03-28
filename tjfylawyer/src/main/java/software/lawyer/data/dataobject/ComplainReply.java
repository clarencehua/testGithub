package software.lawyer.data.dataobject;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * ComplainReply entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "complain_reply", catalog = "itcasttax")
public class ComplainReply implements java.io.Serializable {

	// Fields

	private String replyId;
	private Complain complain;
	private String replyer;
	private String replyDept;
	private String replyTime;
	private String replyContent;

	// Constructors

	/** default constructor */
	public ComplainReply() {
	}

	/** minimal constructor */
	public ComplainReply(String replyId, Complain complain) {
		this.replyId = replyId;
		this.complain = complain;
	}

	/** full constructor */
	public ComplainReply(String replyId, Complain complain, String replyer,
			String replyDept, String replyTime, String replyContent) {
		this.replyId = replyId;
		this.complain = complain;
		this.replyer = replyer;
		this.replyDept = replyDept;
		this.replyTime = replyTime;
		this.replyContent = replyContent;
	}

	// Property accessors
	@Id
	@Column(name = "reply_id", unique = true, nullable = false, length = 32)
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getReplyId() {
		return this.replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "comp_id", nullable = false)
	public Complain getComplain() {
		return this.complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	@Column(name = "replyer", length = 20)
	public String getReplyer() {
		return this.replyer;
	}

	public void setReplyer(String replyer) {
		this.replyer = replyer;
	}

	@Column(name = "reply_dept", length = 100)
	public String getReplyDept() {
		return this.replyDept;
	}

	public void setReplyDept(String replyDept) {
		this.replyDept = replyDept;
	}

	@Column(name = "reply_time", length = 19)
	public String getReplyTime() {
		return this.replyTime;
	}

	public void setReplyTime(String replyTime) {
		this.replyTime = replyTime;
	}

	@Column(name = "reply_content", length = 300)
	public String getReplyContent() {
		return this.replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	
	
}