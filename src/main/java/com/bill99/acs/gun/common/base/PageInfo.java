package com.bill99.acs.gun.common.base;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
* @Description:分页实体类
* @author yangyang.yin   
* @date 2017年9月7日 下午4:59:54
* @company 99bill.com
 */
public class PageInfo {
	
	/**
	 * 默认显示的记录数
	 */
    private final static int PAGESIZE = 10;  
    
    /**
     * 总记录 
     */
    private int total; 
    
    /**
     * 显示的记录  
     */
    private List rows;
    
    /**
     * 开始页
     */
    @JSONField(serialize=false)  
    private int from;
    
    /**
     *每页大小
     */
    @JSONField(serialize=false)  
    private int size;
    
    /**
     * 当前页 
     */
    @JSONField(serialize=false)  
    private int nowpage;
    
    /**
     * 每页显示的记录数 
     */
    @JSONField(serialize=false)  
    private int pagesize;
    
    /**
     * 查询条件
     */
    @JSONField(serialize=false)  
    private Map<String, Object> condition;
    
    /**
     * 排序字段
     */
    @JSONField(serialize=false)  
    private String sort = "seq";
    
    /**
     * asc，desc mybatis Order 关键字
     */
    @JSONField(serialize=false)  
    private String order = "asc";

    public PageInfo() {}

    public PageInfo(int nowpage, int pagesize) {
        //计算当前页  
        if (nowpage < 0) {
            this.nowpage = 1;
        } else {
            //当前页
            this.nowpage = nowpage;
        }
        //记录每页显示的记录数  
        if (pagesize < 0) {
            this.pagesize = PAGESIZE;
        } else {
            this.pagesize = pagesize;
        }
        //计算开始的记录和结束的记录  
        this.from = (this.nowpage - 1) * this.pagesize;
        this.size = this.pagesize;
    }

    // 构造方法
    public PageInfo(int nowpage, int pagesize, String sort, String order) {
        this(nowpage, pagesize) ;
        // 排序字段，正序还是反序
        this.sort = sort;
        this.order = order;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNowpage() {
        return nowpage;
    }

    public void setNowpage(int nowpage) {
        this.nowpage = nowpage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public Map<String, Object> getCondition() {
        return condition;
    }

    public void setCondition(Map<String, Object> condition) {
        this.condition = condition;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
