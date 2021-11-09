package ognl.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * author   : ruzun
 * date     : 2017/2/12 上午3:52
 */


public class SlDept implements java.io.Serializable {

	private static final long serialVersionUID = 3537237434024057830L;

	private String name;

	private Set<SlEmployee> slEmployees = new HashSet<SlEmployee>(0);

	public SlDept() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<SlEmployee> getSlEmployees() {
		return slEmployees;
	}

	public void setSlEmployees(Set<SlEmployee> slEmployees) {
		this.slEmployees = slEmployees;
	}

}