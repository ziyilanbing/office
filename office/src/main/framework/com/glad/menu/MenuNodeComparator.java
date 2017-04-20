package com.glad.menu;

import java.util.Comparator;

import com.glad.entity.SysMenu;

public class MenuNodeComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Long currSeq = new Long(((SysMenu) ((TreeNode) o1).getData()).getDisplayOrder());
		Long nextSeq = new Long(((SysMenu) ((TreeNode) o2).getData()).getDisplayOrder());
		int cmp = currSeq.compareTo(nextSeq);
		if (cmp == 0)
			return 1;
		return cmp;
	}

}
