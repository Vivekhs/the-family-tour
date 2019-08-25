/**
 * 
 */
package com.java.geektrust.models;

import java.util.ArrayList;
import java.util.List;

/**
 * @author vivekhs
 *
 */
public class MemberNode {
	
	private String name;
	private String gender;
	private MemberNode spouseOf;
	private MemberNode childOf;
	private List<MemberNode> children;
	
	public MemberNode(String name, String gender){
		this.name = name;
		this.gender = gender;
		this.children = new ArrayList<MemberNode>();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the spouseOf
	 */
	public MemberNode getSpouseOf() {
		return spouseOf;
	}
	/**
	 * @param spouseOf the spouseOf to set
	 */
	public void setSpouseOf(MemberNode spouseOf) {
		this.spouseOf = spouseOf;
	}
	/**
	 * @return the childOf
	 */
	public MemberNode getChildOf() {
		return childOf;
	}
	/**
	 * @param childOf the childOf to set
	 */
	public void setChildOf(MemberNode childOf) {
		this.childOf = childOf;
	}

	/**
	 * @return the children
	 */
	public List<MemberNode> getchildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setchildren(List<MemberNode> children) {
		this.children = children;
	}


}
