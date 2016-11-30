package org.ldong.java.json;

import java.util.List;
import java.util.Map;

public class MyBeanWithPerson {

	private List<Person> personlist = null;
	private Map<String,Person> map = null;
	
	public Map getMap() {
		return map;
	}
	public void setMap(Map map) {
		this.map = map;
	}
	public List<Person> getPersonlist() {
		return personlist;
	}
	public void setPersonlist(List<Person> personlist) {
		this.personlist = personlist;
	}
	
	
}
