/**
 * 
 */
package com.java.geektrust.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.java.geektrust.models.MemberNode;
import com.java.geektrust.services.FamilyTourService;
import com.java.geektrust.util.AppConstants;

/**
 * @author vivekhs
 *
 */
public class FamilyTourServiceImpl implements FamilyTourService {

	@Override
	public MemberNode initializeFamilyTree(String husband, String wife) {
		MemberNode husbandNode = new MemberNode(husband, AppConstants.MALE);
		MemberNode wifeNode = new MemberNode(wife, AppConstants.FEMALE);
		husbandNode.setSpouseOf(wifeNode);
		wifeNode.setSpouseOf(husbandNode);
		// always start traversing from wifeNode to look down in the hierarchy
		// child will always be added to wife node
		return wifeNode;
	}

	@Override
	public boolean addChild(MemberNode rootNode, String motherName, String childName) {
		// TODO Auto-generated method stub
		
		return false;
	}

	/**
	 * @author vivekhs
	 * this will add spouse of the person and automatically opposite gender
	 * will also be computed
	 * @param { rootNode of the family tree } rootNode
	 * @param { it will be the person name whose spouse to be added } name 
	 * @param { this will be the spouse name } spouseName 
	 * @return { false if person not found for spouse addition, else true } boolean
	 */
	@Override
	public boolean addSpouse(MemberNode rootNode, String name, String spouseName) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public List<MemberNode> findMembers(MemberNode rootNode, String name, String relationship) {
		MemberNode person = searchPerson(rootNode, name);
		if(person != null) {
			switch(relationship) {
			case AppConstants.PARENTAL_UNCLE:
			case AppConstants.MATERNAL_UNCLE:
			case AppConstants.PATERNAL_AUNT:
			case AppConstants.MATERNAL_AUNT:
			case AppConstants.BROTHER_IN_LAW:
			case AppConstants.SISTER_IN_LAW:
			case AppConstants.SON:
			case AppConstants.DAUGHTHER:
			case AppConstants.SIBLINGS:
				// invalid relationship
				// TODO throw custom exception 
				default: return null;
			}
		}
		return null;
	}
	
	private MemberNode searchPerson(MemberNode wifeNode, String name) {
		List<MemberNode> children = wifeNode.getchildren();
		List<MemberNode> wifeList = new ArrayList<MemberNode>();
		if(!children.isEmpty()) {
			for(MemberNode childNode : children) {
				if(childNode.getName().equals(name)) {
					return childNode;
				}
				if(childNode.getSpouseOf() != null) {
					if(childNode.getGender().equals(AppConstants.FEMALE) && !childNode.getchildren().isEmpty()) {
						wifeList.add(childNode);
					}
					else if(!childNode.getSpouseOf().getchildren().isEmpty()) {
						wifeList.add(childNode.getSpouseOf());
					}
				}
			}
			if(!wifeList.isEmpty()) {
				for(MemberNode currentWifeNode: wifeList) {
					MemberNode personNode = searchPerson(currentWifeNode, name);
					if(personNode != null) {
						return personNode;
					}
				}
			}
		}
		return null;
	}

	

}
