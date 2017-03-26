/**
 * created by 2010-7-2
 */
package software.lawyer.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ���ڹ�����
 * 
 * @author zym
 * 
 */
public class DateUtil {
	public final static String shortFormat = "yyyyMMdd";
	public final static String longFormat = "yyyyMMddHHmmss";
	public final static String webFormat = "yyyy-MM-dd";
	public final static String timeFormat = "HHmmss";
	public final static String monthFormat = "yyyyMM";
	public final static String chineseDtFormat = "yyyy��MM��dd��";
	/**
	 * ���Ժʹ�����ڸ�ʽYYYY-MM-DD
	 */
	public final static String newFormat = "yyyy-MM-dd";
	public final static String zbFormat = "yyyy/MM/dd";
	public final static String tsfxFormat = "yyyy.MM.dd";
	public final static String noSecondFormat = "yyyy-MM-dd HH:mm";
	public final static String secondFormat = "yyyy-MM-dd HH:mm:ss";
	public final static long ONE_DAY_MILL_SECONDS = 86400000;

	// -----------------------------------------------------------------------
	/**
	 * Adds to a date returning a new object. The original date object is
	 * unchanged.
	 * 
	 * @param date
	 *            the date, not null
	 * @param calendarField
	 *            the calendar field to add to
	 * @param amount
	 *            the amount to add, may be negative
	 * @return the new date object with the amount added
	 * @throws IllegalArgumentException
	 *             if the date is null
	 */
	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	public static Date addYears(Date date, int amount) {
		return add(date, Calendar.YEAR, amount);
	}

	public static Date addMonths(Date date, int amount) {
		return add(date, Calendar.MONTH, amount);
	}

	public static Date addWeeks(Date date, int amount) {
		return add(date, Calendar.WEEK_OF_YEAR, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	/**
	 * ��׼�����
	 * 
	 * @param date
	 *            ���ڶ���
	 * @param format
	 *            ���������ʽ
	 * @return ����ָ����ʽ������ַ�
	 */
	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}

		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * ���һ��ʱ��������
	 * 
	 * @param date
	 * @return
	 */
	public static int getYear(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}

	/**
	 * ���һ��ʱ����·���
	 * 
	 * @param date
	 * @return
	 */
	public static int getMonth(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH) + 1;
	}

	/**
	 * ���һ��ʱ����һ�����е�����
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfMonth(Date date) {
		if (date == null) {
			return -1;
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * ��׼�����
	 * 
	 * @param s_date
	 * @param format
	 * @return
	 */
	public static Date parse(String s_date, String format) {
		if (s_date == null)
			return null;
		try {
			return new SimpleDateFormat(format).parse(s_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ȡ���������ڼ����������1-����2��
	 * 
	 * @param one
	 *            ����1
	 * @param two
	 *            ����2
	 * 
	 * @return �������
	 */
	public static long getDiffSeconds(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis()) / 1000;
	}

	/**
	 * ȡ���������ڼ������������1-����2��
	 * 
	 * @param one
	 * @param two
	 * @return
	 */
	public static long getDiffMinutes(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis())
				/ (60 * 1000);
	}

	/**
	 * ȡ���������ڵļ������
	 * 
	 * @param one
	 * @param two
	 * 
	 * @return �������
	 */
	public static long getDiffDays(Date one, Date two) {
		Calendar sysDate = new GregorianCalendar();

		sysDate.setTime(one);

		Calendar failDate = new GregorianCalendar();

		failDate.setTime(two);
		return (sysDate.getTimeInMillis() - failDate.getTimeInMillis())
				/ (24 * 60 * 60 * 1000);
	}

	/**
	 * �ж��Ƿ�����ȷ�����ڸ�ʽ
	 * 
	 * @param str_date
	 *            �����ַ�
	 * @param format
	 *            ���ڸ�ʽ
	 * @return
	 */
	public static boolean isValidDateFormat(String strDate, String format) {
		// ��鳤��
		if (strDate.length() != longFormat.length()) {
			return false;
		}

		//����ʽ�Ƿ���ȷ
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		try {
			df.parse(strDate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * ��õ���Ŀ�ʼʱ��
	 * 
	 * @return
	 */
	public static Date today() {
		return parse(format(new Date(), webFormat), webFormat);
	}

}