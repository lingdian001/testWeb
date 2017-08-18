package com.zyc.sys.base.model;

import com.zyc.sys.base.model.BaseBean;

/**
 * @author walker
 * @date 创建时间：2015年9月6日 下午4:07:38 类说明 ： vo基类
 */

public class BaseVO extends BaseBean {
	
	/**
	 * 数据开始索引值
	 */
	private Integer startRowNum = 0;

	/**
	 * 数据结束索引值
	 */
	private Integer endRowNum;
	/**
	 * @Fields createStartDate : 创建日期始于
	 */
	protected String createStartDate;
	/**
	 * @Fields createEndDate : 创建日期截至
	 */
	protected String createEndDate;

	/**
	 * @Fields lastModifyStartDate : 修改日期始于
	 */
	protected String lastModifyStartDate;

	/**
	 * @Fields lastModifyEndDate : 修改日期截至
	 */
	protected String lastModifyEndDate;
	
	/**
	 * 获取数据开始索引值
	 * @return 返回类型为 Integer
	 */
    public Integer getStartRowNum() {
		return startRowNum;
	}

    /**
     * 设置数据开始索引值
     * @param startRowNum 数据开始索引值
     */
	public void setStartRowNum(Integer startRowNum) {
		this.startRowNum = startRowNum;
	}

	/**
	 * 获取数据结束索引值
	 * @return 返回类型为 Integer
	 */
	public Integer getEndRowNum() {
		return endRowNum;
	}

	/**
     * 设置数据结束索引值
     * @param startRowNum 数据结束索引值
     */
	public void setEndRowNum(Integer endRowNum) {
		this.endRowNum = endRowNum;
	}

	public String getCreateStartDate() {
		return createStartDate;
	}

	public void setCreateStartDate(String createStartDate) {
		this.createStartDate = createStartDate;
	}

	public String getCreateEndDate() {
		return createEndDate;
	}

	public void setCreateEndDate(String createEndDate) {
		this.createEndDate = createEndDate;
	}

	public String getLastModifyStartDate() {
		return lastModifyStartDate;
	}

	public void setLastModifyStartDate(String lastModifyStartDate) {
		this.lastModifyStartDate = lastModifyStartDate;
	}

	public String getLastModifyEndDate() {
		return lastModifyEndDate;
	}

	public void setLastModifyEndDate(String lastModifyEndDate) {
		this.lastModifyEndDate = lastModifyEndDate;
	}

}
