package com.glad.menu;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Defines the requirements to be a tree node of ItreeModel.
 * 
 * @author zhongqs
 * @date 2017年4月19日
 */
public class TreeNode implements Serializable {
	/**
	 * The <code>m_parent</code>
	 */
	private TreeNode m_parent = null;
	/**
	 * The <code>m_children</code>
	 */
	private Collection m_children = null;
	/**
	 * The <code>m_data</code>
	 */
	private Object m_data = null;
	/**
	 * The <code>m_comparator</code>
	 */
	private Comparator m_comparator = null;

	public TreeNode(Object data) {
		m_children = new LinkedList<>();
		setData(data);
	}

	public TreeNode(Object data, Comparator comparator) {

		m_children = new TreeSet(comparator);
		m_comparator = comparator;
		setData(data);
	}

	public void setData(Object data) {
		m_data = data;
	}

	public Object getData() {
		return m_data;
	}

	public void addChild(TreeNode node) {
		if (m_comparator != null) {
			((TreeSet) m_children).add(node);
		} else {
			m_children.add(node);
		}
		node.m_parent = this;

	}

	public int getChildCount() {
		return m_children.size();
	}

	public boolean hasChild() {
		return (getChildCount() > 0);
	}

	public Iterator getChildIterator() {
		return m_children.iterator();
	}

	public void removeChildren() {
		for (Iterator itr = getChildIterator(); itr.hasNext();) {
			((TreeNode) itr.next()).removeChildren();
			itr.remove();
		}
	}

	public TreeNode getParent() {
		return m_parent;
	}

	static String spc = "                                                        ";
	static int depth = 0;

	/**
	 * @return the tree structure in string format
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(spc.substring(0, depth * 3) + getData().toString());
		depth++;
		Iterator itr = getChildIterator();
		TreeNode node = null;
		while (itr.hasNext()) {
			node = (TreeNode) itr.next();
			sb.append(spc.substring(0, depth * 3) + node.toString());
		}
		depth--;
		return sb.toString();
	}
}
