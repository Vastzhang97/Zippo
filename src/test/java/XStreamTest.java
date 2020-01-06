
import com.thoughtworks.xstream.XStream;
import pojo.Person;
import pojo.PhoneNumber;
import util.XstreamUtil;

/**
 * 描述:xstream测试
 * 作者:姜鹏
 * 时间:20170911
 */
public class XStreamTest {

    public static void test2() throws Exception {
        // 拼接字符串
        StringBuffer sb = new StringBuffer();
        sb.append("<person>");
        sb.append("  <firstname>Joe</firstname>");
        sb.append("  <lastname>Walnes</lastname>");
        sb.append("  <phone>");
        sb.append("    <code>123</code>");
        sb.append("    <number>1234-456</number>");
        sb.append("  </phone>");
        sb.append("  <fax>");
        sb.append("    <code>123</code>");
        sb.append("    <number>9999-999</number>");
        sb.append("  </fax>");
        sb.append("</person>");
        String xml = sb.toString();
        Person person = (Person) XstreamUtil.xmlStr2Object(xml, Person.class);
        System.out.println("person2 = " + person);

    }

    public static void test3() throws Exception {
        Person joe = new Person("Joe", "Walnes");
        joe.setPhone(new PhoneNumber(123, "1234-456"));
        joe.setFax(new PhoneNumber(123, "9999-999"));

        PhoneNumber phoneNumber1 = new PhoneNumber(123, "1234-456");
        PhoneNumber phoneNumber2 = new PhoneNumber(123, "1234-456");
        joe.getMap().put("phoneNumber1", phoneNumber1);
        joe.getMap().put("phoneNumber2", phoneNumber2);

        String result = XstreamUtil.object2XmlStr(joe);
        System.out.println("result = " + result);
    }


    public static void test1() {
        // 拼接字符串
        StringBuffer sb = new StringBuffer();
        sb.append("<person>");
        sb.append("  <firstname>Joe</firstname>");
        sb.append("  <lastname>Walnes</lastname>");
        sb.append("  <phone>");
        sb.append("    <code>123</code>");
        sb.append("    <number>1234-456</number>");
        sb.append("  </phone>");
        sb.append("  <fax>");
        sb.append("    <code>123</code>");
        sb.append("    <number>9999-999</number>");
        sb.append("  </fax>");
        sb.append("</person>");
        String xml = sb.toString();
        // 构造XStream
        XStream xStream = new XStream();

        Person person = new Person();
        xStream.alias("person", Person.class);
        xStream.processAnnotations(new Class[]{Person.class});
        xStream.setMode(XStream.NO_REFERENCES);
        //转为对象
        person = (Person) xStream.fromXML(xml);
        System.out.println("person = " + person);
    }

    public static void main(String[] args) throws Exception {
        test1();
    }

}
