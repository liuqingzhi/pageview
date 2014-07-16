package com.yesmynet.page.dto;

import java.util.List;

public class Node<T> {
	/**
	 * 主键
	 */
	private String id;
	private T data;
	private Node<T> parent;
	private List<Node<T>> children;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Node<T> getParent() {
		return parent;
	}
	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	public List<Node<T>> getChildren() {
		return children;
	}
	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}
}
