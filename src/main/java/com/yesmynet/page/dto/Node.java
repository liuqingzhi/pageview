package com.yesmynet.page.dto;

import java.util.List;

public class Node {
	/**
	 * 主键
	 */
	private String id;
	private Node parent;
	private List<Node> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Node getParent() {
		return parent;
	}
	public void setParent(Node parent) {
		this.parent = parent;
	}
	public List<Node> getChildren() {
		return children;
	}
	public void setChildren(List<Node> children) {
		this.children = children;
	}
	
}
