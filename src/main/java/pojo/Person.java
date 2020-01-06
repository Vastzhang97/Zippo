package pojo;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamInclude;
 
/**
 * 描述:人 
 * 作者:姜鹏 
 * 时间:20170911
 * */
@XStreamAlias("person")
public class Person {
	
	@XStreamAlias("firstname")
	private String firstname;
	
	@XStreamAlias("lastname")
	private String lastname;
 
	@XStreamAlias("phone")
	private PhoneNumber phone;
	
	@XStreamAlias("fax")
	private PhoneNumber fax;
	
//	@XStreamImplicit()
//	private List<PhoneNumber> para = new ArrayList<PhoneNumber>();
	
	@XStreamImplicit()
	private Map<String,PhoneNumber> map = new HashMap<String,PhoneNumber>();
	
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}
 
	public Person() {
		
	}
 
	public String getFirstname() {
		return firstname;
	}
 
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
 
	public String getLastname() {
		return lastname;
	}
 
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
 
	public PhoneNumber getPhone() {
		return phone;
	}
 
	public void setPhone(PhoneNumber phone) {
		this.phone = phone;
	}
 
	public PhoneNumber getFax() {
		return fax;
	}
 
	public void setFax(PhoneNumber fax) {
		this.fax = fax;
	}
 
	public Map getMap() {
		return map;
	}
 
	public void setMap(Map map) {
		this.map = map;
	}


	@Override
	public String toString() {
		return "Person{" +
				"firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", phone=" + phone +
				", fax=" + fax +
				", map=" + map +
				'}';
	}
}
