package com.zyc.sys.base.model;

public class BaseBean {

	/**
	 * @Fields rowId : 主键
	 */
	protected String rowId;
	/**
	 * @Fields visible : 是否可见
	 */
	protected String visible;
	/**
	 * @Fields isDeleted : 删除标识
	 */
	protected String isDeleted;
	/**
	 * @Fields creator : 创建者id
	 */
	protected String creator;
	/**
	 * @Fields lastModifyBy : 修改者id
	 */
	protected String lastModifyBy;

	public String getRowId() {
		return rowId;
	}

	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getLastModifyBy() {
		return lastModifyBy;
	}

	public void setLastModifyBy(String lastModifyBy) {
		this.lastModifyBy = lastModifyBy;
	}


}
