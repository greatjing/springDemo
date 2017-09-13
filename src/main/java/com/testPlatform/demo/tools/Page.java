package com.testPlatform.demo.tools;/**
 * Created by guojingjing on 13/9/17.
 */

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 ** @description $
 ** Created by guojingjing on 13/9/17. 
 **/
public class Page {
    // 记录总数
    private int totalRows;
    // 每页记录
    private int numPerPage;
    // 总页数
    private int totalPages;
    // 当前页码
    private int currentPage;
    // 起始顺序数
    private int startIndex;
    // 结束行数
    private int endIndex;
    // 结果集放在list
    private List<Map<String, Object>> resultList;

    public Page(String sql, int currentPage, int numPerPage, JdbcTemplate jdbcTemplate){
        if(jdbcTemplate == null){
            throw new IllegalArgumentException("Page.jdbcTemplate is null");
        }else if (sql == null || sql.equals("")){
            throw new IllegalArgumentException("Page.sql is null");
        }
        // 设置当前页数和当前页
        setNumPerPage(numPerPage);
        setCurrentPage(currentPage);
        //sql 获取总记录数
        StringBuffer totalSQL = new StringBuffer(" SELECT count(*) From ( ");
        totalSQL.append(sql);
        totalSQL.append(" ) totalTable");
        // 计算出总记录数
        setTotalRows(jdbcTemplate.queryForObject(totalSQL.toString(), Integer.class));

        // 设置总页数
        setTotalPages();

        //设置当前页开始行数
        setStartIndex();

        // ****当前页结束行数
        setEndIndex();
        //sql 设置当前页返回的记录，startIndex是从0开始
        StringBuffer paginationSQL = new StringBuffer();
        paginationSQL.append(sql);
        paginationSQL.append("limit" + startIndex + "," + endIndex);
        //装入结果集
        setResultList(jdbcTemplate.queryForList(paginationSQL.toString()));

    }


    public int getTotalRows(){
        return totalRows;
    }

    public void setTotalRows( int totalRows ){
        this.totalRows = totalRows;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage){
        this.currentPage = currentPage;
    }

    public int getNumPerPage() {
        return numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getTotalPages() {
        return totalPages;
    }

//    总页数
    public void setTotalPages() {
        if (totalRows % numPerPage == 0){
            this.totalPages = totalRows / numPerPage ;
        }else {
            this.totalPages = totalRows / numPerPage ;
        }
//        this.totalPages = totalPages;
    }

    public int getStartIndex() {
        return startIndex;
    }

//    开始顺序数
    public void setStartIndex() {
        this.startIndex = (currentPage - 1) * numPerPage + 1;
//        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex() {
        if( totalRows < numPerPage ){
            this.endIndex = totalRows;
        }else if( (totalRows % numPerPage == 0) || (totalRows % numPerPage != 0 && currentPage < totalPages) ){
            this.endIndex = currentPage * numPerPage;
        }else {
            this.endIndex = totalRows;
        }

    }

    public List<Map<String, Object>> getResultList() {
        return resultList;
    }

    public void setResultList(List<Map<String, Object>> resultList) {
        this.resultList = resultList;
    }
}
