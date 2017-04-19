package com.glad.menu;

/**
 * Represents a tree model having node of type (TreeNode).
 * 
 * @author zhongqs
 * @date 2017年4月19日
 */
public interface ITreeModel {

	/**
	 * Returns the root of tree model.
	 * 
	 * @return
	 */
	TreeNode getRoot();

	/**
	 * Returns the child node of <index>order.
	 * 
	 * @return
	 */
	TreeNode getChild(TreeNode parent, int index);

	/**
	 * Returns number of child nodes of root.
	 * 
	 * @return
	 */
	int getChildCount();

	/**
	 * Returns number of child nodes immediate to specified node.
	 * 
	 * @param parent
	 * @return
	 */
	int getChildCount(TreeNode parent);

	/**
	 * check whether it has ant child or not.
	 * 
	 * @param node
	 * @return
	 */
	boolean isLeaf(TreeNode node);
}
