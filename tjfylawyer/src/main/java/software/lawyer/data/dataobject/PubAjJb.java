package software.lawyer.data.dataobject;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PubAjJb entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "PUB_AJ_JB")
public class PubAjJb implements java.io.Serializable {
	private Integer ajxh;
	private String ah;
	private String ajmc;
	private String ajxz;
	private String ajly;
	private String spcx;
	private String spcxdz;
	private String sycx;
	private String sfys;
	private String sfzdaj;
	private String sfjbaj;
	private String sffhcs;
	private String sfwdyj;
	private Integer sx;
	private Integer fjsx;
	private String lydq;
	private String baspt;
	private String jyaq;
	private Date larq;
	private String lar;
	private String bafy;
	private String gksjg;
	private String cbryj;
	private String hytyj;
	private String tzhyj;
	private String yzhyj;
	private String swhyj;
	private Date jarq;
	private String jafs;
	private String jayy;
	private String jayydm;
	private String bz;
	private Date sxrq;
	private String gdbz;
	private String ajzt;
	private String bycxdz;
	private String ajwsqk;
	private Date gdrq;
	private Integer gdxlh;
	private Date cbrbprq;
	private Date spzsqrq;
	private Date hythyrq;
	private Date tzsqrq;
	private Date yzsqrq;
	private Date swhjdrq;
	private Date yzqfrq;
	private String slqk;
	private String sslx;
	private String sfgs;
	private String fhcsyy;
	private String gpyy;
	private String jjar;
	private String sfzscq;
	private String swlx;
	private String modflag;
	private String transflag;
	private Integer sptg;
	private String psycy;
	private String msajtjs;
	private String msajtjsss;
	private String shwdfxpg;
	private String sfxess;
	private String sffcxx;
	private String fxhjcs;
	private String pjsffdjfnr;
	private String sfdtpj;
	private String sfhj;
	private String sfktsl;
	private String sftz;
	private String sfcqyscs;
	private String ajsfys;
	private String lybm;
	
	//退回案件
	private String isth;
	/**
	 * 无结案文书原因
	 */
	private String wjawsyy;
	
	//判决结果
	private String pjjg;
	
	//结案退回原因
	private String jathyy;
	
	//是否刑事速裁
	private String sfxssc;
	

	// private Set<PubSdfasqb> pubSdfasqbs = new HashSet<PubSdfasqb>(0);

	// Constructors

	/** default constructor */
	public PubAjJb() {
	}

	/** minimal constructor */
	public PubAjJb(Integer ajxh) {
		this.ajxh = ajxh;
	}

	/** full constructor */
	public PubAjJb(Integer ajxh, String ah, String ajmc, String ajxz,
			String ajly, String spcx, String spcxdz, String sycx, String sfys,
			String sfzdaj, String sfjbaj, String sffhcs, String sfwdyj,
			Integer sx, Integer fjsx, String lydq, String baspt, String jyaq,
			Date larq, String lar, String bafy, String gksjg, String cbryj,
			String hytyj, String tzhyj, String yzhyj, String swhyj, Date jarq,
			String jafs, String jayy, String jayydm, String bz, Date sxrq,
			String gdbz, String ajzt, String bycxdz, String ajwsqk, Date gdrq,
			Integer gdxlh, Date cbrbprq, Date spzsqrq, Date hythyrq,
			Date tzsqrq, Date yzsqrq, Date swhjdrq, Date yzqfrq, String slqk,
			String sslx, String sfgs, String fhcsyy, String gpyy, String jjar,
			String sfzscq, String swlx, String modflag, String transflag,
			Integer sptg, String psycy, String msajtjs, String msajtjsss,
			String shwdfxpg, String sfxess, String sffcxx, String fxhjcs,
			String pjsffdjfnr, String sfdtpj, String sfhj, String sfktsl,
			String sftz, String sfcqyscs, String ajsfys, String lybm,String isth/*
														 * , Set<PubSdfasqb>
														 * pubSdfasqbs
														 */) {
		this.ajxh = ajxh;
		this.ah = ah;
		this.ajmc = ajmc;
		this.ajxz = ajxz;
		this.ajly = ajly;
		this.spcx = spcx;
		this.spcxdz = spcxdz;
		this.sycx = sycx;
		this.sfys = sfys;
		this.sfzdaj = sfzdaj;
		this.sfjbaj = sfjbaj;
		this.sffhcs = sffhcs;
		this.sfwdyj = sfwdyj;
		this.sx = sx;
		this.fjsx = fjsx;
		this.lydq = lydq;
		this.baspt = baspt;
		this.jyaq = jyaq;
		this.larq = larq;
		this.lar = lar;
		this.bafy = bafy;
		this.gksjg = gksjg;
		this.cbryj = cbryj;
		this.hytyj = hytyj;
		this.tzhyj = tzhyj;
		this.yzhyj = yzhyj;
		this.swhyj = swhyj;
		this.jarq = jarq;
		this.jafs = jafs;
		this.jayy = jayy;
		this.jayydm = jayydm;
		this.bz = bz;
		this.sxrq = sxrq;
		this.gdbz = gdbz;
		this.ajzt = ajzt;
		this.bycxdz = bycxdz;
		this.ajwsqk = ajwsqk;
		this.gdrq = gdrq;
		this.gdxlh = gdxlh;
		this.cbrbprq = cbrbprq;
		this.spzsqrq = spzsqrq;
		this.hythyrq = hythyrq;
		this.tzsqrq = tzsqrq;
		this.yzsqrq = yzsqrq;
		this.swhjdrq = swhjdrq;
		this.yzqfrq = yzqfrq;
		this.slqk = slqk;
		this.sslx = sslx;
		this.sfgs = sfgs;
		this.fhcsyy = fhcsyy;
		this.gpyy = gpyy;
		this.jjar = jjar;
		this.sfzscq = sfzscq;
		this.swlx = swlx;
		this.modflag = modflag;
		this.transflag = transflag;
		this.sptg = sptg;
		this.psycy = psycy;
		this.msajtjs = msajtjs;
		this.msajtjsss = msajtjsss;
		this.shwdfxpg = shwdfxpg;
		this.sfxess = sfxess;
		this.sffcxx = sffcxx;
		this.fxhjcs = fxhjcs;
		this.pjsffdjfnr = pjsffdjfnr;
		this.sfdtpj = sfdtpj;
		this.sfhj = sfhj;
		this.sfktsl = sfktsl;
		this.sftz = sftz;
		this.sfcqyscs = sfcqyscs;
		this.ajsfys = ajsfys;
		this.lybm = lybm;
		// this.pubSdfasqbs = pubSdfasqbs;
	}

	
	// Property accessors
	@Id
	@Column(name = "AJXH", unique = true, nullable = false)
	public Integer getAjxh() {
		return this.ajxh;
	}

	public void setAjxh(Integer ajxh) {
		this.ajxh = ajxh;
	}

	@Column(name = "AH", length = 40)
	public String getAh() {
		return this.ah;
	}

	public void setAh(String ah) {
		this.ah = ah;
	}

	@Column(name = "AJMC", length = 250)
	public String getAjmc() {
		return this.ajmc;
	}

	public void setAjmc(String ajmc) {
		this.ajmc = ajmc;
	}

	@Column(name = "AJXZ", length = 10)
	public String getAjxz() {
		return this.ajxz;
	}

	public void setAjxz(String ajxz) {
		this.ajxz = ajxz;
	}

	@Column(name = "AJLY", length = 10)
	public String getAjly() {
		return this.ajly;
	}

	public void setAjly(String ajly) {
		this.ajly = ajly;
	}

	@Column(name = "SPCX", length = 10)
	public String getSpcx() {
		return this.spcx;
	}

	public void setSpcx(String spcx) {
		this.spcx = spcx;
	}

	@Column(name = "SPCXDZ", length = 10)
	public String getSpcxdz() {
		return this.spcxdz;
	}

	public void setSpcxdz(String spcxdz) {
		this.spcxdz = spcxdz;
	}

	@Column(name = "SYCX", length = 10)
	public String getSycx() {
		return this.sycx;
	}

	public void setSycx(String sycx) {
		this.sycx = sycx;
	}

	@Column(name = "SFYS", length = 1)
	public String getSfys() {
		return this.sfys;
	}

	public void setSfys(String sfys) {
		this.sfys = sfys;
	}

	@Column(name = "SFZDAJ", length = 1)
	public String getSfzdaj() {
		return this.sfzdaj;
	}

	public void setSfzdaj(String sfzdaj) {
		this.sfzdaj = sfzdaj;
	}

	@Column(name = "SFJBAJ", length = 1)
	public String getSfjbaj() {
		return this.sfjbaj;
	}

	public void setSfjbaj(String sfjbaj) {
		this.sfjbaj = sfjbaj;
	}

	@Column(name = "SFFHCS", length = 1)
	public String getSffhcs() {
		return this.sffhcs;
	}

	public void setSffhcs(String sffhcs) {
		this.sffhcs = sffhcs;
	}

	@Column(name = "SFWDYJ", length = 1)
	public String getSfwdyj() {
		return this.sfwdyj;
	}

	public void setSfwdyj(String sfwdyj) {
		this.sfwdyj = sfwdyj;
	}

	@Column(name = "SX")
	public Integer getSx() {
		return this.sx;
	}

	public void setSx(Integer sx) {
		this.sx = sx;
	}

	@Column(name = "FJSX")
	public Integer getFjsx() {
		return this.fjsx;
	}

	public void setFjsx(Integer fjsx) {
		this.fjsx = fjsx;
	}

	@Column(name = "LYDQ", length = 80)
	public String getLydq() {
		return this.lydq;
	}

	public void setLydq(String lydq) {
		this.lydq = lydq;
	}

	@Column(name = "BASPT", length = 10)
	public String getBaspt() {
		return this.baspt;
	}

	public void setBaspt(String baspt) {
		this.baspt = baspt;
	}

	@Column(name = "JYAQ")
	public String getJyaq() {
		return this.jyaq;
	}

	public void setJyaq(String jyaq) {
		this.jyaq = jyaq;
	}

	@Column(name = "LARQ", length = 23)
	public Date getLarq() {
		return this.larq;
	}

	public void setLarq(Date larq) {
		this.larq = larq;
	}

	@Column(name = "LAR", length = 50)
	public String getLar() {
		return this.lar;
	}

	public void setLar(String lar) {
		this.lar = lar;
	}

	@Column(name = "BAFY", length = 50)
	public String getBafy() {
		return this.bafy;
	}

	public void setBafy(String bafy) {
		this.bafy = bafy;
	}

	@Column(name = "GKSJG", length = 50)
	public String getGksjg() {
		return this.gksjg;
	}

	public void setGksjg(String gksjg) {
		this.gksjg = gksjg;
	}

	@Column(name = "CBRYJ")
	public String getCbryj() {
		return this.cbryj;
	}

	public void setCbryj(String cbryj) {
		this.cbryj = cbryj;
	}

	@Column(name = "HYTYJ")
	public String getHytyj() {
		return this.hytyj;
	}

	public void setHytyj(String hytyj) {
		this.hytyj = hytyj;
	}

	@Column(name = "TZHYJ")
	public String getTzhyj() {
		return this.tzhyj;
	}

	public void setTzhyj(String tzhyj) {
		this.tzhyj = tzhyj;
	}

	@Column(name = "YZHYJ")
	public String getYzhyj() {
		return this.yzhyj;
	}

	public void setYzhyj(String yzhyj) {
		this.yzhyj = yzhyj;
	}

	@Column(name = "SWHYJ")
	public String getSwhyj() {
		return this.swhyj;
	}

	public void setSwhyj(String swhyj) {
		this.swhyj = swhyj;
	}

	@Column(name = "JARQ", length = 23)
	public Date getJarq() {
		return this.jarq;
	}

	public void setJarq(Date jarq) {
		this.jarq = jarq;
	}

	@Column(name = "JAFS", length = 10)
	public String getJafs() {
		return this.jafs;
	}

	public void setJafs(String jafs) {
		this.jafs = jafs;
	}

	@Column(name = "JAYY", length = 100)
	public String getJayy() {
		return this.jayy;
	}

	public void setJayy(String jayy) {
		this.jayy = jayy;
	}

	@Column(name = "JAYYDM", length = 10)
	public String getJayydm() {
		return this.jayydm;
	}

	public void setJayydm(String jayydm) {
		this.jayydm = jayydm;
	}

	@Column(name = "BZ", length = 200)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "SXRQ", length = 23)
	public Date getSxrq() {
		return this.sxrq;
	}

	public void setSxrq(Date sxrq) {
		this.sxrq = sxrq;
	}

	@Column(name = "GDBZ", length = 10)
	public String getGdbz() {
		return this.gdbz;
	}

	public void setGdbz(String gdbz) {
		this.gdbz = gdbz;
	}

	@Column(name = "AJZT", length = 10)
	public String getAjzt() {
		return this.ajzt;
	}

	public void setAjzt(String ajzt) {
		this.ajzt = ajzt;
	}

	@Column(name = "BYCXDZ", length = 10)
	public String getBycxdz() {
		return this.bycxdz;
	}

	public void setBycxdz(String bycxdz) {
		this.bycxdz = bycxdz;
	}

	@Column(name = "AJWSQK", length = 10)
	public String getAjwsqk() {
		return this.ajwsqk;
	}

	public void setAjwsqk(String ajwsqk) {
		this.ajwsqk = ajwsqk;
	}

	@Column(name = "GDRQ", length = 23)
	public Date getGdrq() {
		return this.gdrq;
	}

	public void setGdrq(Date gdrq) {
		this.gdrq = gdrq;
	}

	@Column(name = "GDXLH")
	public Integer getGdxlh() {
		return this.gdxlh;
	}

	public void setGdxlh(Integer gdxlh) {
		this.gdxlh = gdxlh;
	}

	@Column(name = "CBRBPRQ", length = 23)
	public Date getCbrbprq() {
		return this.cbrbprq;
	}

	public void setCbrbprq(Date cbrbprq) {
		this.cbrbprq = cbrbprq;
	}

	@Column(name = "SPZSQRQ", length = 23)
	public Date getSpzsqrq() {
		return this.spzsqrq;
	}

	public void setSpzsqrq(Date spzsqrq) {
		this.spzsqrq = spzsqrq;
	}

	@Column(name = "HYTHYRQ", length = 23)
	public Date getHythyrq() {
		return this.hythyrq;
	}

	public void setHythyrq(Date hythyrq) {
		this.hythyrq = hythyrq;
	}

	@Column(name = "TZSQRQ", length = 23)
	public Date getTzsqrq() {
		return this.tzsqrq;
	}

	public void setTzsqrq(Date tzsqrq) {
		this.tzsqrq = tzsqrq;
	}

	@Column(name = "YZSQRQ", length = 23)
	public Date getYzsqrq() {
		return this.yzsqrq;
	}

	public void setYzsqrq(Date yzsqrq) {
		this.yzsqrq = yzsqrq;
	}

	@Column(name = "SWHJDRQ", length = 23)
	public Date getSwhjdrq() {
		return this.swhjdrq;
	}

	public void setSwhjdrq(Date swhjdrq) {
		this.swhjdrq = swhjdrq;
	}

	@Column(name = "YZQFRQ", length = 23)
	public Date getYzqfrq() {
		return this.yzqfrq;
	}

	public void setYzqfrq(Date yzqfrq) {
		this.yzqfrq = yzqfrq;
	}

	@Column(name = "SLQK", length = 10)
	public String getSlqk() {
		return this.slqk;
	}

	public void setSlqk(String slqk) {
		this.slqk = slqk;
	}

	@Column(name = "SSLX", length = 10)
	public String getSslx() {
		return this.sslx;
	}

	public void setSslx(String sslx) {
		this.sslx = sslx;
	}

	@Column(name = "SFGS", length = 1)
	public String getSfgs() {
		return this.sfgs;
	}

	public void setSfgs(String sfgs) {
		this.sfgs = sfgs;
	}

	@Column(name = "FHCSYY", length = 10)
	public String getFhcsyy() {
		return this.fhcsyy;
	}

	public void setFhcsyy(String fhcsyy) {
		this.fhcsyy = fhcsyy;
	}

	@Column(name = "GPYY", length = 10)
	public String getGpyy() {
		return this.gpyy;
	}

	public void setGpyy(String gpyy) {
		this.gpyy = gpyy;
	}

	@Column(name = "JJAR", length = 10)
	public String getJjar() {
		return this.jjar;
	}

	public void setJjar(String jjar) {
		this.jjar = jjar;
	}

	@Column(name = "SFZSCQ", length = 1)
	public String getSfzscq() {
		return this.sfzscq;
	}

	public void setSfzscq(String sfzscq) {
		this.sfzscq = sfzscq;
	}

	@Column(name = "SWLX", length = 10)
	public String getSwlx() {
		return this.swlx;
	}

	public void setSwlx(String swlx) {
		this.swlx = swlx;
	}

	@Column(name = "MODFLAG", length = 1)
	public String getModflag() {
		return this.modflag;
	}

	public void setModflag(String modflag) {
		this.modflag = modflag;
	}

	@Column(name = "TRANSFLAG", length = 1)
	public String getTransflag() {
		return this.transflag;
	}

	public void setTransflag(String transflag) {
		this.transflag = transflag;
	}

	@Column(name = "SPTG")
	public Integer getSptg() {
		return this.sptg;
	}

	public void setSptg(Integer sptg) {
		this.sptg = sptg;
	}

	@Column(name = "PSYCY", length = 1)
	public String getPsycy() {
		return this.psycy;
	}

	public void setPsycy(String psycy) {
		this.psycy = psycy;
	}

	@Column(name = "MSAJTJS", length = 1)
	public String getMsajtjs() {
		return this.msajtjs;
	}

	public void setMsajtjs(String msajtjs) {
		this.msajtjs = msajtjs;
	}

	@Column(name = "MSAJTJSSS", length = 1)
	public String getMsajtjsss() {
		return this.msajtjsss;
	}

	public void setMsajtjsss(String msajtjsss) {
		this.msajtjsss = msajtjsss;
	}

	@Column(name = "SHWDFXPG", length = 10)
	public String getShwdfxpg() {
		return this.shwdfxpg;
	}

	public void setShwdfxpg(String shwdfxpg) {
		this.shwdfxpg = shwdfxpg;
	}

	@Column(name = "SFXESS", length = 1)
	public String getSfxess() {
		return this.sfxess;
	}

	public void setSfxess(String sfxess) {
		this.sfxess = sfxess;
	}

	@Column(name = "SFFCXX", length = 1)
	public String getSffcxx() {
		return this.sffcxx;
	}

	public void setSffcxx(String sffcxx) {
		this.sffcxx = sffcxx;
	}

	@Column(name = "FXHJCS", length = 100)
	public String getFxhjcs() {
		return this.fxhjcs;
	}

	public void setFxhjcs(String fxhjcs) {
		this.fxhjcs = fxhjcs;
	}

	@Column(name = "PJSFFDJFNR", length = 10)
	public String getPjsffdjfnr() {
		return this.pjsffdjfnr;
	}

	public void setPjsffdjfnr(String pjsffdjfnr) {
		this.pjsffdjfnr = pjsffdjfnr;
	}

	@Column(name = "SFDTPJ", length = 10)
	public String getSfdtpj() {
		return this.sfdtpj;
	}

	public void setSfdtpj(String sfdtpj) {
		this.sfdtpj = sfdtpj;
	}

	@Column(name = "SFHJ", length = 10)
	public String getSfhj() {
		return this.sfhj;
	}

	public void setSfhj(String sfhj) {
		this.sfhj = sfhj;
	}

	@Column(name = "SFKTSL", length = 10)
	public String getSfktsl() {
		return this.sfktsl;
	}

	public void setSfktsl(String sfktsl) {
		this.sfktsl = sfktsl;
	}

	@Column(name = "SFTZ", length = 10)
	public String getSftz() {
		return this.sftz;
	}

	public void setSftz(String sftz) {
		this.sftz = sftz;
	}

	@Column(name = "SFCQYSCS", length = 1)
	public String getSfcqyscs() {
		return this.sfcqyscs;
	}

	public void setSfcqyscs(String sfcqyscs) {
		this.sfcqyscs = sfcqyscs;
	}

	@Column(name = "AJSFYS", length = 1)
	public String getAjsfys() {
		return this.ajsfys;
	}

	public void setAjsfys(String ajsfys) {
		this.ajsfys = ajsfys;
	}
	
	@Column(name = "LYBM", length = 80)
	public String getLybm() {
		return this.lybm;
	}

	public void setLybm(String lybm) {
		this.lybm = lybm;
	}

	@Column(name = "WJAWSYY", length = 2)
	public String getWjawsyy() {
		return wjawsyy;
	}

	public void setWjawsyy(String wjawsyy) {
		this.wjawsyy = wjawsyy;
	}

	@Column(name = "PJJG", length = 10)
	public String getPjjg() {
		return pjjg;
	}

	public void setPjjg(String pjjg) {
		this.pjjg = pjjg;
	}

	@Column(name = "JATHYY", length = 200)
	public String getJathyy() {
		return jathyy;
	}

	public void setJathyy(String jathyy) {
		this.jathyy = jathyy;
	}
	@Column(name = "SFXSSC", length = 1)
	public String getSfxssc() {
		return sfxssc;
	}

	public void setSfxssc(String sfxssc) {
		this.sfxssc = sfxssc;
	}
	
}
