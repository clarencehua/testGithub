package software.lawyer.dynamicds;

import java.util.ArrayList;
import java.util.List;

import software.lawyer.util.StringUtil;

public enum DataSourceEnum {
	
	/**
	 * mysql
	 */
	MYSQL("111111", "Default", "Mysql库", "cc"),
	
	/**
	 * 集中库
	 */
	DEFAULT("000000", "Sybase", "集中库", "aa"),

	TEST("test", "test", "测试", "bb"),
	/**
	 * 测试
	 */
	TJGY("120000 200", "Tjgy", "高院", "00"),
	/**
	 * 一中院
	 */
	TJYZY("120100 210", "Tjyzy", "一中院", "01"),
	/**
	 * 二中院
	 */
	TJEZY("120200 220", "Tjezy", "二中院", "02"),
	/**
	 * 铁路
	 */
	TJTLFY("920103 132", "Tjtlfy", "铁路", "24"),
	/**
	 * 海事
	 */
	TJHSFY("960200 230", "Tjhsfy", "海事", "03"),
	/**
	 * 和平
	 */
	TJHPFY("120101 211", "Tjhpfy", "和平", "05"),
	/**
	 * 南开
	 */
	TJNKFY("120104 212", "Tjnkfy", "南开", "09"),
	/**
	 * 河北
	 */
	TJHBFY("120105 213", "Tjhbfy", "河北", "08"),
	/**
	 * 红桥
	 */
	TJHQFY("120106 214", "Tjhqfy", "红桥", "10"),
	/**
	 * 西青
	 */
	TJXQFY("120107 215", "Tjxqfy", "西青", "12"),
	/**
	 * 北辰
	 */
	TJBCFY("120108 216", "Tjbcfy", "北辰", "14"),
	/**
	 * 河东
	 */
	TJHDFY("120202 221", "Tjhdfy", "河东", "06"),

	/**
	 * 河西
	 */
	TJHXFY("120203 222", "Tjhxfy", "河西", "07"),

	/**
	 * 塘沽
	 */
	TJTGFY("120204 223", "Tjtgfy", "塘沽", "20"),

	/**
	 * 汉沽
	 */
	TJHGFY("120205 224", "Tjhgfy", "汉沽", "21"),

	/**
	 * 大港
	 */
	TJDGFY("120206 225", "Tjdgfy", "大港", "22"),

	/**
	 * 东丽
	 */
	TJDLFY("120207 226", "Tjdlfy", "东丽", "11"),

	/**
	 * 津南
	 */
	TJJNFY("120208 227", "Tjjnfy", "津南", "13"),

	/**
	 * 宁河
	 */
	TJNHFY("120221 228", "Tjnhfy", "宁河", "18"),

	/**
	 * 武清
	 */
	TJWQFY("120222 217", "Tjwqfy", "武清", "15"),

	/**
	 * 静海
	 */
	TJJHFY("120223 218", "Tjjhfy", "静海", "17"),

	/**
	 * 宝坻
	 */
	TJBDFY("120224 219", "Tjbdfy", "宝坻", "16"),

	/**
	 * 蓟县
	 */
	TJJXFY("120225 21A", "Tjjxfy", "蓟县", "19"),
	/**
	 * 功能区
	 */
	TJKFQFY("120241 229", "Tjkfqfy", "功能区", "23"),
	/**
	 * 滨海
	 */
	TJBHXQFY("120242 22A", "Tjbhxqfy", "滨海", "04");

	String fydm;

	String source;

	String fymc;

	String gzzdm;

	/**
	 * @param fydm
	 * @param source
	 */
	private DataSourceEnum(String fydm, String source)
	{
		this.fydm = fydm;
		this.source = source;
	}

	/**
	 * @param fydm
	 * @param source
	 */
	private DataSourceEnum(String fydm, String source, String fy, String gzzdm)
	{
		this.fydm = fydm;
		this.source = source;
		this.fymc = fy;
		this.gzzdm = gzzdm;
	}

	public static String getFydmBySource(String source)
	{
		for(DataSourceEnum src : DataSourceEnum.values()) {
			if(StringUtil.equals(source, src.getSource())) {
				return src.getFydm();
			}
		}
		return "";
	}

	public static String getSourceByFydm(String fydm)
	{
		for(DataSourceEnum src : DataSourceEnum.values()) {
			if(StringUtil.equals(fydm, src.getFydm())) {
				return src.getSource();
			}
		}
		return "";
	}

	public static List<DataSourceEnum> getFydmList()
	{
		List<DataSourceEnum> list = new ArrayList<DataSourceEnum>();
		for(DataSourceEnum src : DataSourceEnum.values()) {
			if(src.getFydm() == DataSourceEnum.DEFAULT.getFydm()
					|| src.getFydm() == DataSourceEnum.TEST.getFydm()
					|| src.getFydm() == DataSourceEnum.MYSQL.getFydm())
				continue;
			list.add(src);
		}
		return list;
	}

	public static String getGzzdmByFydm(String fydm)
	{
		for(DataSourceEnum src : DataSourceEnum.values()) {
			if(StringUtil.equals(fydm, src.getFydm())) {
				return src.getGzzdm();
			}
		}
		return "";
	}

	public static String getFymcByFydm(String fydm)
	{
		for(DataSourceEnum src : DataSourceEnum.values()) {
			if(StringUtil.equals(fydm, src.getFydm())) {
				return src.getFymc();
			}
		}
		return "";
	}

	public static String getFydmByFymc(String fymc)
	{
		for(DataSourceEnum src : DataSourceEnum.values()) {
			if(StringUtil.equals(fymc, src.getFymc())) {
				return src.getFydm();
			}
		}
		return "";
	}

	public static List<Court> getSubFy(String fydm)
	{
		List<Court> fydmList = new ArrayList<Court>();
		if(StringUtil.equals(TJGY.getFydm(), fydm)) {
			for(DataSourceEnum dataSource : DataSourceEnum.values()) {
				if(dataSource.getFydm().equals(DataSourceEnum.DEFAULT.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TJGY.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TJYZY.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TJEZY.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TEST.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.MYSQL.getFydm()))
					continue;
				fydmList.add(new Court(dataSource.getFydm(), dataSource.getFymc()));
			}
		}
		else if(StringUtil.equals(TJYZY.getFydm(), fydm)) {
			fydmList.add(new Court(TJHPFY.getFydm(), TJHPFY.getFymc()));
			fydmList.add(new Court(TJNKFY.getFydm(), TJNKFY.getFymc()));
			fydmList.add(new Court(TJHBFY.getFydm(), TJHBFY.getFymc()));
			fydmList.add(new Court(TJHQFY.getFydm(), TJHQFY.getFymc()));
			fydmList.add(new Court(TJXQFY.getFydm(), TJXQFY.getFymc()));
			fydmList.add(new Court(TJBCFY.getFydm(), TJBCFY.getFymc()));
			fydmList.add(new Court(TJWQFY.getFydm(), TJWQFY.getFymc()));
			fydmList.add(new Court(TJJHFY.getFydm(), TJJHFY.getFymc()));
			fydmList.add(new Court(TJBDFY.getFydm(), TJBDFY.getFymc()));
			fydmList.add(new Court(TJJXFY.getFydm(), TJJXFY.getFymc()));
		}
		else if(StringUtil.equals(TJEZY.getFydm(), fydm)) {
			fydmList.add(new Court(TJHDFY.getFydm(), TJHDFY.getFymc()));
			fydmList.add(new Court(TJHXFY.getFydm(), TJHXFY.getFymc()));
			fydmList.add(new Court(TJTGFY.getFydm(), TJTGFY.getFymc()));
			fydmList.add(new Court(TJHGFY.getFydm(), TJHGFY.getFymc()));
			fydmList.add(new Court(TJDGFY.getFydm(), TJDGFY.getFymc()));
			fydmList.add(new Court(TJDLFY.getFydm(), TJDLFY.getFymc()));
			fydmList.add(new Court(TJJNFY.getFydm(), TJJNFY.getFymc()));
			fydmList.add(new Court(TJNHFY.getFydm(), TJNHFY.getFymc()));
			fydmList.add(new Court(TJKFQFY.getFydm(), TJKFQFY.getFymc()));
			fydmList.add(new Court(TJBHXQFY.getFydm(), TJBHXQFY.getFymc()));
		}
		return fydmList;
	}

	public static List<String> getSubFydm(String fydm)
	{
		List<String> fydmList = new ArrayList<String>();
		if(StringUtil.equals(TJGY.getFydm(), fydm)) {
			for(DataSourceEnum dataSource : DataSourceEnum.values()) {
				if(dataSource.getFydm().equals(DataSourceEnum.DEFAULT.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TJGY.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TJYZY.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TJEZY.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.TEST.getFydm())
						|| dataSource.getFydm().equals(DataSourceEnum.MYSQL.getFydm()))
					continue;
				fydmList.add(dataSource.getFydm());
			}
		}
		else if(StringUtil.equals(TJYZY.getFydm(), fydm)) {
			fydmList.add(TJHPFY.getFydm());
			fydmList.add(TJNKFY.getFydm());
			fydmList.add(TJHBFY.getFydm());
			fydmList.add(TJHQFY.getFydm());
			fydmList.add(TJXQFY.getFydm());
			fydmList.add(TJBCFY.getFydm());
			fydmList.add(TJWQFY.getFydm());
			fydmList.add(TJJHFY.getFydm());
			fydmList.add(TJBDFY.getFydm());
			fydmList.add(TJJXFY.getFydm());
		}
		else if(StringUtil.equals(TJEZY.getFydm(), fydm)) {
			fydmList.add(TJHDFY.getFydm());
			fydmList.add(TJHXFY.getFydm());
			fydmList.add(TJTGFY.getFydm());
			fydmList.add(TJHGFY.getFydm());
			fydmList.add(TJDGFY.getFydm());
			fydmList.add(TJDLFY.getFydm());
			fydmList.add(TJJNFY.getFydm());
			fydmList.add(TJNHFY.getFydm());
			fydmList.add(TJKFQFY.getFydm());
			fydmList.add(TJBHXQFY.getFydm());
		}
		else if(StringUtil.equals(TJHSFY.getFydm(), fydm)) {
			fydmList.add(TJTGFY.getFydm());
			fydmList.add(TJHGFY.getFydm());
			fydmList.add(TJDGFY.getFydm());
			fydmList.add(TJBHXQFY.getFydm());
			fydmList.add(TJKFQFY.getFydm());
		}
		else {
			fydmList.add(fydm);
		}

		return fydmList;
	}

	/**
	 * @return the fydm
	 */
	public String getFydm()
	{
		return fydm;
	}

	/**
	 * @return the source
	 */
	public String getSource()
	{
		return source;
	}

	public String getFymc()
	{
		return fymc;
	}

	public String getGzzdm()
	{
		return gzzdm;
	}

}
