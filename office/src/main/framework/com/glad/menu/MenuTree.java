package com.glad.menu;

import java.io.Serializable;
import java.util.Iterator;

/**
 * The implementation of {@link ITreeModel} which carries out the main task id
 * processing a tree.
 * 
 * @author zhongqs
 * @date 2017年4月19日
 */
public class MenuTree implements ITreeModel, Serializable {

	private TreeNode m_root = null;

	public MenuTree(TreeNode node) {
		if (node == null)
			throw new IllegalArgumentException("Treenode is empty.");
		m_root = node;
	}

	@Override
	public TreeNode getRoot() {
		return m_root;
	}

	@Override
	public TreeNode getChild(TreeNode parent, int index) {
		TreeNode node = null;
		int i = 0;
		for (Iterator itr = parent.getChildIterator(); itr.hasNext() || i > index; i++) {
			node = (TreeNode) itr.next();
		}
		return node;
	}

	@Override
	public int getChildCount() {
		int childCount = 0;
		if (m_root != null)
			childCount = m_root.getChildCount();
		return childCount;
	}

	@Override
	public int getChildCount(TreeNode parent) {

		return (parent != null) ? parent.getChildCount() : 0;
	}

	@Override
	public boolean isLeaf(TreeNode node) {
		return (getChildCount(node) == 0);
	}

	@Override
	public String toString() {
		if (m_root != null)
			return m_root.toString();
		return null;
	}
}
