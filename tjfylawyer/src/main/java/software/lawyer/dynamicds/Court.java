package software.lawyer.dynamicds;

public class Court {
	String fydm;
	String fymc;

	public Court(String fydm, String fymc) {
		this.fydm = fydm;
		this.fymc = fymc;
	}

	public String getFydm() {
		return fydm;
	}

	public void setFydm(String fydm) {
		this.fydm = fydm;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

}
