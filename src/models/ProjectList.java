package models;

import java.util.ArrayList;

public class ProjectList {
	private ArrayList<Project> proList;
	
	
	public ProjectList() {
		setproList(new ArrayList<Project>());
	}
	public ArrayList<Project>getproList() {
		return proList;
	}
	
	public void setproList(ArrayList<Project> proList) {
		this.proList = proList;
	}
	


}
