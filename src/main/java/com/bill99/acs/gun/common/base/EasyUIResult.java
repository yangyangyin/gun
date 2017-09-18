package com.bill99.acs.gun.common.base;

import java.util.List;

/**
 * 
* @Description:EasyUI返回的结果集
* @author yangyang.yin   
* @date 2017年8月25日 下午4:06:24
* @company 99bill.com
 */
public class EasyUIResult {
	private Long total;		//easyui返回的总条数
	private List<?> rows;	//返回的结果数据
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	public EasyUIResult(Long total, List<?> rows) {
		super();
		this.total = total;
		this.rows = rows;
	}
	public EasyUIResult() {
		super();
	}
}
