/**
 * 
 */
package com.java.geektrust.services;

import java.util.List;

import com.java.geektrust.models.MemberNode;

/**
 * @author vivekhs
 *
 */
public interface FamilyTourService {
	
	MemberNode initializeFamilyTree(String husband, String wife);
	
	boolean addChild(MemberNode rootNode, String motherName, String childName);
	
	boolean addSpouse(MemberNode rootNode, String spouseName, String name);
	
	List<MemberNode> findMembers(MemberNode rootNode, String name, String relationship);

}
