package ognl.domain;

/**
 * author   : ruzun
 * date     : 2017/2/12 上午3:53
 */
public class SlEmployee implements java.io.Serializable {

	private static final long serialVersionUID = 4873217019660076767L;

	private SlDept slDept;

	private String name;

	public String getAge() {
		return age;
	}

	public SlEmployee setAge(String age) {
		this.age = age;
		return this;
	}

	private String age;

	public SlEmployee() {
	}

	public SlDept getSlDept() {
		return slDept;
	}

	public void setSlDept(SlDept slDept) {
		this.slDept = slDept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}