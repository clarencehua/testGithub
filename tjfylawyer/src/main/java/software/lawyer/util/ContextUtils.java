package software.lawyer.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;

/**
 * SpringContext��ع�����
 * @author zym
 *
 */
public class ContextUtils {

	private static ApplicationContext applicationContext;

	private static Log log = LogFactory.getLog(ContextUtils.class);

	public static void setApplicationContext(
			ApplicationContext applicationContext) {
		synchronized (ContextUtils.class) {
			log.debug("setApplicationContext, notifyAll");
			ContextUtils.applicationContext = applicationContext;
			ContextUtils.class.notifyAll();
		}
	}

	public static ApplicationContext getApplicationContext() {
		synchronized (ContextUtils.class) {
			while (applicationContext == null) {
				try {
					log.debug("getApplicationContext, wait...");
					ContextUtils.class.wait(60000);
					if (applicationContext == null) {
						log.warn(
								"Have been waiting for ApplicationContext to be set for 1 minute",
								new Exception());
					}
				} catch (InterruptedException ex) {
					log.debug("getApplicationContext, wait interrupted");
				}
			}
			return applicationContext;
		}
	}

	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}

}
