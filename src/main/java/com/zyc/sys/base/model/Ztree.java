package com.zyc.sys.base.model;

import java.util.List;
import java.util.Map;

public class Ztree {
	private String id;
	private String pId;
	private String name;
	private Boolean checked;
	private String delete;
	private Boolean isParent;
	private Boolean open;
	private String isRoot;
	private String info;
	private String icon;
	private Boolean nocheck;
	private String flag;

	private List<Map<String, Object>> remark;
	private Map<String, Object> mapremark;

	public Ztree(Object id, Object pId, Object name) {
		this.id = toString(id);
		this.pId = toString(pId);
		this.name = toString(name);
	}

	public Ztree(Object id, Object pId, Object name, Object... vals) {
		this.id = toString(id);
		this.pId = toString(pId);
		this.name = toString(name);
		for (int i = 0; i < vals.length; i++) {
			if (toString(vals[i]).equals("del")) {
				if (toString(vals[i + 1]).equals("true")) {
					this.delete = "true";
				}
			} else if (toString(vals[i]).equals("chk")) {
				if (toString(vals[i + 1]).equals("true")) {
					this.checked = true;
				}
			} else if (toString(vals[i]).equals("par")) {
				if (toString(vals[i + 1]).equals("true")) {
					this.isParent = true;
				}
			} else if (toString(vals[i]).equals("open")) {
				if (toString(vals[i + 1]).equals("true")) {
					this.open = true;
				}
			}
			i++;
		}

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}

	public String getDelete() {
		return delete;
	}

	public void setDelete(String delete) {
		this.delete = delete;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public Boolean getOpen() {
		return open;
	}

	public void setOpen(Boolean open) {
		this.open = open;
	}

	public String getIsRoot() {
		return isRoot;
	}

	public void setIsRoot(String isRoot) {
		this.isRoot = isRoot;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getNocheck() {
		return nocheck;
	}

	public void setNocheck(Boolean nocheck) {
		this.nocheck = nocheck;
	}

	public List<Map<String, Object>> getRemark() {
		return remark;
	}

	public void setRemark(List<Map<String, Object>> remark) {
		this.remark = remark;
	}

	public Map<String, Object> getMapremark() {
		return mapremark;
	}

	public void setMapremark(Map<String, Object> mapremark) {
		this.mapremark = mapremark;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String toString(Object obj) {
		return obj == null ? "" : obj.toString().trim();
	}
}
