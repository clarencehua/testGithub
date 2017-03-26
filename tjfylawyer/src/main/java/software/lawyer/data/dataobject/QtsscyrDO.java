package software.lawyer.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * QtsscyrDO entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PUB_QTSSCYR")
@IdClass(QtsscyrDOId.class)
public class QtsscyrDO implements java.io.Serializable {

	// Fields

	private Integer ajxh;
	private Integer qtsscyrbh;
	private String qtsscyrlx;
	private String ydsrgx;
	private String xm;
	private String xb;
	private Date csnyr;
	private String whcd;
	private String gzdw;
	private String zw;
	private String zc;
	private String dh;
	private String yb;
	private String dz;
	private Date cysj;
	private String sfsfyz;
	private String zjlb;
	private String sfzhm;

	// Constructors

	/** default constructor */
	public QtsscyrDO() {
	}

	/** minimal constructor */
	public QtsscyrDO(Integer ajxh, Integer qtsscyrbh) {
		this.ajxh = ajxh;
		this.qtsscyrbh = qtsscyrbh;
	}

	/** full constructor */
	public QtsscyrDO(Integer ajxh, Integer qtsscyrbh, String qtsscyrlx, String ydsrgx,
			String xm, String xb, Date csnyr, String whcd, String gzdw,
			String zw, String zc, String dh, String yb, String dz, Date cysj,
			String sfsfyz, String zjlb, String sfzhm) {
		this.ajxh = ajxh;
		this.qtsscyrbh = qtsscyrbh;
		this.qtsscyrlx = qtsscyrlx;
		this.ydsrgx = ydsrgx;
		this.xm = xm;
		this.xb = xb;
		this.csnyr = csnyr;
		this.whcd = whcd;
		this.gzdw = gzdw;
		this.zw = zw;
		this.zc = zc;
		this.dh = dh;
		this.yb = yb;
		this.dz = dz;
		this.cysj = cysj;
		this.sfsfyz = sfsfyz;
		this.zjlb = zjlb;
		this.sfzhm = sfzhm;
	}

	/*public QtsscyrDO(DjDsrQtsscyrDO dsr){
		this.qtsscyrbh = dsr.getSscyrbh();
		this.qtsscyrlx = dsr.getLx();
		this.xm = dsr.getXm();
		this.xb = dsr.getXb();
		this.csnyr = dsr.getCsnyr();
		this.gzdw = dsr.getGzdw();
		this.zw = dsr.getZw();
		this.zc = dsr.getZy();
		this.dh = dsr.getDh();
		this.yb = dsr.getYb();
		this.dz = dsr.getDz();
		this.zjlb = dsr.getDjzlb();
		this.sfzhm = dsr.getDjzh();
	}
	*/
	// Property accessors
	
	@Id
	@Column(name="AJXH", nullable=false)
	public Integer getAjxh() {
		return ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Id
	@Column(name = "QTSSCYRBH", nullable = false)
	public Integer getQtsscyrbh() {
		return qtsscyrbh;
	}

	public void setQtsscyrbh(Integer qtsscyrbh) {
		this.qtsscyrbh = qtsscyrbh;
	}

	@Column(name = "QTSSCYRLX", length = 10)
	public String getQtsscyrlx() {
		return this.qtsscyrlx;
	}

	public void setQtsscyrlx(String qtsscyrlx) {
		this.qtsscyrlx = qtsscyrlx;
	}

	@Column(name = "YDSRGX", length = 10)
	public String getYdsrgx() {
		return this.ydsrgx;
	}

	public void setYdsrgx(String ydsrgx) {
		this.ydsrgx = ydsrgx;
	}

	@Column(name = "XM", length = 50)
	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	@Column(name = "XB", length = 10)
	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	@Column(name = "CSNYR", length = 23)
	public Date getCsnyr() {
		return this.csnyr;
	}

	public void setCsnyr(Date csnyr) {
		this.csnyr = csnyr;
	}

	@Column(name = "WHCD", length = 10)
	public String getWhcd() {
		return this.whcd;
	}

	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}

	@Column(name = "GZDW", length = 50)
	public String getGzdw() {
		return this.gzdw;
	}

	public void setGzdw(String gzdw) {
		this.gzdw = gzdw;
	}

	@Column(name = "ZW", length = 10)
	public String getZw() {
		return this.zw;
	}

	public void setZw(String zw) {
		this.zw = zw;
	}

	@Column(name = "ZC", length = 10)
	public String getZc() {
		return this.zc;
	}

	public void setZc(String zc) {
		this.zc = zc;
	}

	@Column(name = "DH", length = 20)
	public String getDh() {
		return this.dh;
	}

	public void setDh(String dh) {
		this.dh = dh;
	}

	@Column(name = "YB", length = 10)
	public String getYb() {
		return this.yb;
	}

	public void setYb(String yb) {
		this.yb = yb;
	}

	@Column(name = "DZ", length = 50)
	public String getDz() {
		return this.dz;
	}

	public void setDz(String dz) {
		this.dz = dz;
	}

	@Column(name = "CYSJ", length = 23)
	public Date getCysj() {
		return this.cysj;
	}

	public void setCysj(Date cysj) {
		this.cysj = cysj;
	}

	@Column(name = "SFSFYZ", length = 1)
	public String getSfsfyz() {
		return this.sfsfyz;
	}

	public void setSfsfyz(String sfsfyz) {
		this.sfsfyz = sfsfyz;
	}

	@Column(name = "ZJLB", length = 2)
	public String getZjlb() {
		return zjlb;
	}

	public void setZjlb(String zjlb) {
		this.zjlb = zjlb;
	}

	@Column(name = "SFZHM", length = 50)
	public String getSfzhm() {
		return sfzhm;
	}

	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}

}