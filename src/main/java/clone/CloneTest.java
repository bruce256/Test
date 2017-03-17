package clone;

import java.util.Date;

import com.alibaba.fastjson.JSON;

class Obj implements Cloneable {

	private Date	birthday	= new Date();
	private int		a			= 0;

	public int getA() {
		return a;
	}

	public void setA(int b) {
		this.a = b;
	}

	public void changedA() {
		this.a = 1;
	}

	public Date getDate() {
		return birthday;
	}

	public void setDate(Date date) {
		this.birthday = date;
	}

	public void changeDate() {
		this.birthday.setMonth(4);
	}

	public Object clone() {
		Object o = null;
		try {
			o = (Obj) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		// 实现深复制
		((Obj) o).birthday = (Date) this.getDate().clone();
		return o;
	}
}

public class CloneTest {

	public static void main(String args[]) {
		Obj a = new Obj();
		Obj b = (Obj) a.clone();
		b.changeDate();
		System.out.println(JSON.toJSONString(a));
		System.out.println(JSON.toJSONString(b));
		
	}
}
