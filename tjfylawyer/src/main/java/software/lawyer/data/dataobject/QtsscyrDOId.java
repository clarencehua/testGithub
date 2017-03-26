package software.lawyer.data.dataobject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * QtsscyrDOId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class QtsscyrDOId implements java.io.Serializable {

	// Fields

	private Integer ajxh;
	private Integer qtsscyrbh;

	// Constructors

	/** default constructor */
	public QtsscyrDOId() {
	}

	/** full constructor */
	public QtsscyrDOId(Integer ajxh, Integer qtsscyrbh) {
		this.ajxh = ajxh;
		this.qtsscyrbh = qtsscyrbh;
	}

	// Property accessors

	@Column(name = "AJXH", nullable = false)
	public Integer getAjxh() {
		return this.ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Column(name = "QTSSCYRBH", nullable = false)
	public Integer getQtsscyrbh() {
		return this.qtsscyrbh;
	}

	public void setQtsscyrbh(Integer qtsscyrbh) {
		this.qtsscyrbh = qtsscyrbh;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QtsscyrDOId))
			return false;
		QtsscyrDOId castOther = (QtsscyrDOId) other;

		return ((this.getAjxh() == castOther.getAjxh()) || (this.getAjxh() != null
				&& castOther.getAjxh() != null && this.getAjxh().equals(
				castOther.getAjxh())))
				&& ((this.getQtsscyrbh() == castOther.getQtsscyrbh()) || (this
						.getQtsscyrbh() != null
						&& castOther.getQtsscyrbh() != null && this
						.getQtsscyrbh().equals(castOther.getQtsscyrbh())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAjxh() == null ? 0 : this.getAjxh().hashCode());
		result = 37 * result
				+ (getQtsscyrbh() == null ? 0 : this.getQtsscyrbh().hashCode());
		return result;
	}

}