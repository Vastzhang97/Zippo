package util;
 
import com.thoughtworks.xstream.XStream;
 
/**
 * 描述:xtream工具类
 * 作者:姜鹏
 * 时间:20170911
 * */
public class XstreamUtil {
	
	/**
	 * 将xml字符串转为对象
	 * */
	public static Object xmlStr2Object(String xmlString,Class clazz) throws Exception{
		if( clazz == null || xmlString == null || "".equals(xmlString.replace(" ", "")) ) return null;
		Object object = clazz.newInstance();
		XStream xStream = new XStream();
		String className = object.getClass().getName();
		xStream.alias(className, clazz);
		xStream.processAnnotations(new Class[]{clazz});
		xStream.setMode(XStream.NO_REFERENCES);
		//转为对象
		object = xStream.fromXML(xmlString);
		return object;
		
	}
	
	/**
	 * 将对象转为xml格式字符串
	 * */
	public static String object2XmlStr(Object obj) throws Exception{
		if(obj==null) return null;
		XStream xStream = new XStream();
		String xml = xStream.toXML(obj);
		return xml;
	}
 
}
