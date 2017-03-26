package software.lawyer.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * ��ֵ��صĹ�����
 * @author zym
 *
 */
public class NumberUtil {
	/**
	 * ��ֵ������λС��
	 * 
	 * @param convert
	 *            ת��ǰ��ֵ
	 * @return ת�����ַ���
	 */
	public static String changeNumberType(BigDecimal big) {

		big.setScale(2, RoundingMode.HALF_UP);
		DecimalFormat format = new DecimalFormat("##0.00");
		return format.format(big);
	}
}
