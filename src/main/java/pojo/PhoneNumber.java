
package pojo;
 
import com.thoughtworks.xstream.annotations.XStreamAlias;
 
/**
 * 描述:电话号码 
 * 作者:姜鹏 
 * 时间:20170911
 * */
@XStreamAlias("PhoneNumber")
public class PhoneNumber {
	
	@XStreamAlias("code")
	private int code;
	
	@XStreamAlias("number")
	private String number;

	public PhoneNumber(int code, String number) {
		this.code = code;
		this.number = number;
	}
 
	public PhoneNumber() {
		
	}
 
	public void setCode(int code) {
		this.code = code;
	}
 
	public void setNumber(String number) {
		this.number = number;
	}
 
	public int getCode() {
		return code;
	}
 
	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "PhoneNumber{" +
				"code=" + code +
				", number='" + number + '\'' +
				'}';
	}
}
