package software.lawyer.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * ���乤����.
 * �ṩ����getter/setter����, ����˽�б���, ����˽�з���, ��ȡ��������Class, ��AOP������ʵ��ȹ��ߺ���.
 */
@SuppressWarnings("rawtypes")
public class ReflectionUtil {
	
	private static final String SETTER_PREFIX = "set";

	private static final String GETTER_PREFIX = "get";

	private static final String CGLIB_CLASS_SEPARATOR = "$$";
	
	private static Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

	/**
	 * ����Getter����.
	 * ֧�ֶ༶���磺������.������.����
	 */
	public static Object invokeGetter(Object obj, String propertyName) {
		Object object = obj;
		for (String name : StringUtils.split(propertyName, ".")){
			String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(name);
			object = invokeMethod(object, getterMethodName, new Class[] {}, new Object[] {});
		}
		return object;
	}

	/**
	 * ����Setter����, ��ƥ�䷽������
	 * ֧�ֶ༶���磺������.������.����
	 */
	public static void invokeSetter(Object obj, String propertyName, Object value) {
		Object object = obj;
		String[] names = StringUtils.split(propertyName, ".");
		for (int i=0; i<names.length; i++){
			if(i<names.length-1){
				String getterMethodName = GETTER_PREFIX + StringUtils.capitalize(names[i]);
				object = invokeMethod(object, getterMethodName, new Class[] {}, new Object[] {});
			}else{
				String setterMethodName = SETTER_PREFIX + StringUtils.capitalize(names[i]);
				invokeMethodByName(object, setterMethodName, new Object[] { value });
			}
		}
	}

	/**
	 * ֱ�Ӷ�ȡ��������ֵ, ����private/protected���η�, ������getter����.
	 */
	public static Object getFieldValue(final Object obj, final String fieldName) {
		Field field = getAccessibleField(obj, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
		}

		Object result = null;
		try {
			result = field.get(obj);
		} catch (IllegalAccessException e) {
			logger.error("�������׳����쳣{}", e.getMessage());
		}
		return result;
	}

	/**
	 * ֱ�����ö�������ֵ, ����private/protected���η�, ������setter����.
	 */
	public static void setFieldValue(final Object obj, final String fieldName, final Object value) {
		Field field = getAccessibleField(obj, fieldName);

		if (field == null) {
			throw new IllegalArgumentException("Could not find field [" + fieldName + "] on target [" + obj + "]");
		}

		try {
			field.set(obj, value);
		} catch (IllegalAccessException e) {
			logger.error("�������׳����쳣:{}", e.getMessage());
		}
	}

	/**
	 * ֱ�ӵ��ö��󷽷�, ����private/protected���η�.
	 * ����һ���Ե��õ����������Ӧʹ��getAccessibleMethod()�������Method�󷴸�����.
	 * ͬʱƥ�䷽����+�������ͣ�
	 */
	public static Object invokeMethod(final Object obj, final String methodName, final Class<?>[] parameterTypes,
			final Object[] args) {
		Method method = getAccessibleMethod(obj, methodName, parameterTypes);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
		}

		try {
			return method.invoke(obj, args);
		} catch (Exception e) {
			throw convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * ֱ�ӵ��ö��󷽷�, ����private/protected���η���
	 * ����һ���Ե��õ����������Ӧʹ��getAccessibleMethodByName()�������Method�󷴸�����.
	 * ֻƥ�亯����������ж��ͬ���������õ�һ����
	 */
	public static Object invokeMethodByName(final Object obj, final String methodName, final Object[] args) {
		Method method = getAccessibleMethodByName(obj, methodName);
		if (method == null) {
			throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + obj + "]");
		}

		try {
			return method.invoke(obj, args);
		} catch (Exception e) {
			throw convertReflectionExceptionToUnchecked(e);
		}
	}

	/**
	 * ѭ������ת��, ��ȡ�����DeclaredField, ��ǿ������Ϊ�ɷ���.
	 * 
	 * ������ת�͵�Object���޷��ҵ�, ����null.
	 */
	public static Field getAccessibleField(final Object obj, final String fieldName) {
		Validate.notNull(obj, "object can't be null");
//		Validate.notBlank(fieldName, "fieldName can't be blank");
		for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
			try {
				Field field = superClass.getDeclaredField(fieldName);
				makeAccessible(field);
				return field;
			} catch (NoSuchFieldException e) {//NOSONAR
				// Field���ڵ�ǰ�ඨ��,��������ת��
				continue;// new add
			}
		}
		return null;
	}

	/**
	 * ѭ������ת��, ��ȡ�����DeclaredMethod,��ǿ������Ϊ�ɷ���.
	 * ������ת�͵�Object���޷��ҵ�, ����null.
	 * ƥ�亯����+�������͡�
	 * 
	 * ���ڷ�����Ҫ����ε��õ����. ��ʹ�ñ�������ȡ��Method,Ȼ�����Method.invoke(Object obj, Object... args)
	 */
	public static Method getAccessibleMethod(final Object obj, final String methodName,
			final Class<?>... parameterTypes) {
		Validate.notNull(obj, "object can't be null");
//		Validate.notBlank(methodName, "methodName can't be blank");

		for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass()) {
			try {
				Method method = searchType.getDeclaredMethod(methodName, parameterTypes);
				makeAccessible(method);
				return method;
			} catch (NoSuchMethodException e) {
				// Method���ڵ�ǰ�ඨ��,��������ת��
				continue;// new add
			}
		}
		return null;
	}

	/**
	 * ѭ������ת��, ��ȡ�����DeclaredMethod,��ǿ������Ϊ�ɷ���.
	 * ������ת�͵�Object���޷��ҵ�, ����null.
	 * ֻƥ�亯������
	 * 
	 * ���ڷ�����Ҫ����ε��õ����. ��ʹ�ñ�������ȡ��Method,Ȼ�����Method.invoke(Object obj, Object... args)
	 */
	public static Method getAccessibleMethodByName(final Object obj, final String methodName) {
		Validate.notNull(obj, "object can't be null");
//		Validate.notBlank(methodName, "methodName can't be blank");

		for (Class<?> searchType = obj.getClass(); searchType != Object.class; searchType = searchType.getSuperclass()) {
			Method[] methods = searchType.getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					makeAccessible(method);
					return method;
				}
			}
		}
		return null;
	}

	/**
	 * �ı�private/protected�ķ���Ϊpublic������������ʵ�ʸĶ�����䣬����JDK��SecurityManager��Թ��
	 */
	public static void makeAccessible(Method method) {
		if ((!Modifier.isPublic(method.getModifiers()) || !Modifier.isPublic(method.getDeclaringClass().getModifiers()))
				&& !method.isAccessible()) {
			method.setAccessible(true);
		}
	}

	/**
	 * �ı�private/protected�ĳ�Ա����Ϊpublic������������ʵ�ʸĶ�����䣬����JDK��SecurityManager��Թ��
	 */
	public static void makeAccessible(Field field) {
		if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) || Modifier
				.isFinal(field.getModifiers())) && !field.isAccessible()) {
			field.setAccessible(true);
		}
	}

	/**
	 * ͨ������, ���Class�����������ķ��Ͳ���������, ע�ⷺ�ͱ��붨���ڸ��ദ
	 * ���޷��ҵ�, ����Object.class.
	 * eg.
	 * public UserDao extends HibernateDao<User>
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or Object.class if cannot be determined
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> getClassGenricType(final Class clazz) {
		return getClassGenricType(clazz, 0);
	}

	/**
	 * ͨ������, ���Class�����������ĸ���ķ��Ͳ���������.
	 * ���޷��ҵ�, ����Object.class.
	 * 
	 * ��public UserDao extends HibernateDao<User,Long>
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic ddeclaration,start from 0.
	 * @return the index generic declaration, or Object.class if cannot be determined
	 */
	public static Class getClassGenricType(final Class clazz, final int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			logger.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			logger.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
					+ params.length);
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			logger.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
			return Object.class;
		}

		return (Class) params[index];
	}
	
	public static Class<?> getUserClass(Object instance) {
		Assert.notNull(instance, "Instance must not be null");
		Class clazz = instance.getClass();
		if (clazz != null && clazz.getName().contains(CGLIB_CLASS_SEPARATOR)) {
			Class<?> superClass = clazz.getSuperclass();
			if (superClass != null && !Object.class.equals(superClass)) {
				return superClass;
			}
		}
		return clazz;

	}
	
	/**
	 * ������ʱ��checked exceptionת��Ϊunchecked exception.
	 */
	public static RuntimeException convertReflectionExceptionToUnchecked(Exception e) {
		if (e instanceof IllegalAccessException || e instanceof IllegalArgumentException
				|| e instanceof NoSuchMethodException) {
			return new IllegalArgumentException(e);
		} else if (e instanceof InvocationTargetException) {
			return new RuntimeException(((InvocationTargetException) e).getTargetException());
		} else if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		}
		return new RuntimeException("Unexpected Checked Exception.", e);
	}
}

