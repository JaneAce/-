package com.example.demo2.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//serializable提供通用数据保存，读取和传输的接口
public class PageHelp implements Serializable {
    //序列化和反序列化操作时的唯一标识，建议只要实现序列化接口，都要手动添加这个id
    private static final long serialVersionUID = -3130527491950235344L;
    /**
     * 总记录数
     */
    private Integer rowCount;
    /**
     * 当前页记录
     */
    private List<Nucleic> records;
    /**
     * 总页数
     */
    private Integer pageCount;
    /**
     * 页面大小（每页最多显示多少条记录）
     */
    private Integer pageSize;
    /**
     * 页码值
     */
    private Integer pageCurrent;

    public PageHelp() {
    }

    public PageHelp(Integer rowCount, List<Nucleic> records, Integer pageSize, Integer pageCurrent) {
        this.rowCount = rowCount;
        this.records = records;
        this.pageSize = pageSize;
        this.pageCurrent = pageCurrent;
        this.pageCount = this.rowCount / this.pageSize;
        if (this.rowCount % this.pageSize != 0)
            this.pageCount++;

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getRowCount() {
        return rowCount;
    }

    public void setRowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }

    public List<Nucleic> getRecords() {
        return records;
    }

    public void setRecords(List<Nucleic> records) {
        this.records = records;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCurrent() {
        return pageCurrent;
    }

    public void setPageCurrent(Integer pageCurrent) {
        this.pageCurrent = pageCurrent;
    }
}
