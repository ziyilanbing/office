package com.glad.model;

import java.util.ArrayList;
import java.util.List;

import com.glad.component.AbstractModel;
import com.glad.entity.Datatables;

public class TablesModel extends AbstractModel {
	List<Datatables> datatablesList = new ArrayList<Datatables>();

	public List<Datatables> getDatatablesList() {
		return datatablesList;
	}

	public void setDatatablesList(List<Datatables> datatablesList) {
		this.datatablesList = datatablesList;
	}

}
