package com.zyc.sys.base.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zyc.sys.base.dao.IBaseDao;
import com.zyc.sys.base.exception.SysException;
import com.zyc.sys.base.model.BasePO;
import com.zyc.sys.base.model.BaseVO;
import com.zyc.sys.base.model.CurrentPage;
import com.zyc.sys.util.consts.PubConstants;
import com.zyc.sys.util.lang.DateUtil;

@Repository
public class BaseDaoImpl<T extends BasePO,V extends BaseVO> implements IBaseDao<T,V>  {
	 	private Logger logger = Logger.getLogger(BaseDaoImpl.class);
	 	
	 	private final static String MYSQL_DB = "mysql";
	 	private final static String ORACLE_DB = "orcle";

	    @Autowired
	    private SqlSessionTemplate sqlSessionTemplate;

	    private SqlSessionTemplate getSqlSessionTemplate() {
	        return sqlSessionTemplate;
	    }

	    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
	        this.sqlSessionTemplate = sqlSessionTemplate;
	    }
	    
	    

	    public T createObject(String sqlName, T po) throws SysException{
	        if (null == po) {
	            logger.error(" createObject failed , because po is null ! ");
	            throw new SysException(" createObject failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" createObject failed , because sqlName is null ! ");
	            throw new SysException(" createObject failed , because sqlName is null ! ");
	        }

	        if (null == this.sqlSessionTemplate) {
	            logger.error(" createObject failed , SqlSessionTemplate is null ! ");
	            throw new SysException(" createObject failed , SqlSessionTemplate is null ! ");
	        }
	        /*if (StringUtils.isBlank(po.getCreator())) {
	            logger.error(" createObject failed , because creator is null ! ");
	            throw new SysException(" createObject failed , because creator is null ! ");
	        }*/
	        //TODO 为创建人赋值
	        po.setCreateDate(DateUtil.getTodayTime());

	        int result = sqlSessionTemplate.insert(sqlName, po);

	        if (result != 0) { // 返回创建了主键的对象
	            return po;
	        } else {
	            logger.error(" createObject failed , the class is : {}"+po.getClass());
	            throw new SysException(" createObject failed , the class is :" + po.getClass());
	        }
	    }

	    public T queryForObject(String sqlName, V po) throws SysException{

	        if (null == po) {
	            logger.error(" queryForObject failed , because po is null ! ");
	            throw new SysException(" findObject failed , because po is null ! ");
	        }

	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryForObject failed , because sqlName is null ! ");
	            throw new SysException(" findObject failed , because sqlName is null ! ");
	        }

	        if (null == this.sqlSessionTemplate) {
	            logger.error(" queryForObject failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" findObject failed , because SqlSessionTemplate is null ! ");
	        }

	        return (T) sqlSessionTemplate.selectOne(sqlName, po);

	    }
	    
	    /**
	     * id查询对象
	     * <一句话功能简述>
	     * <功能详细描述>
	     * @param sqlName
	     * @param id
	     * @return
	     * @throws SysException
	     * @see [类、类#方法、类#成员]
	     */
	    public T queryById(String sqlName,String id)  throws SysException{

	        if (StringUtils.isBlank(id)) {
	            logger.error(" queryById failed , because id is null ! ");
	            throw new SysException(" queryById failed , because id is null ! ");
	        }

	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryById failed , because sqlName is null ! ");
	            throw new SysException(" queryById failed , because sqlName is null ! ");
	        }

	        if (null == this.sqlSessionTemplate) {
	            logger.error(" queryById failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" queryById failed , because SqlSessionTemplate is null ! ");
	        }

	        return (T) sqlSessionTemplate.selectOne(sqlName, id);

	    }


	    public List<T> queryForList(String sqlName, V po) throws SysException{
	        if (null == po) {
	            logger.error(" queryForList failed , because po is null ! ");
	            throw new SysException(" findAll failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryForList failed , because sqlName is null ! ");
	            throw new SysException(" findAll failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error("  queryForList failed , SqlSessionTemplate is null ! ");
	            throw new SysException("  findAll failed , SqlSessionTemplate is null ! ");
	        }
	        List<T> result = new ArrayList<T>();
	        result = sqlSessionTemplate.selectList(sqlName, po);
	        return result;
	    }

	    public List<Map<String, Object>> queryForMap(String sqlName, V po) throws SysException{
	        if (null == po) {
	            logger.error(" queryForMap failed , because po is null ! ");
	            throw new SysException(" findAll failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryForMap failed , because sqlName is null ! ");
	            throw new SysException(" findAll failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error("  queryForMap failed , SqlSessionTemplate is null ! ");
	            throw new SysException("  findAll failed , SqlSessionTemplate is null ! ");
	        }
	        return sqlSessionTemplate.selectList(sqlName, po);
	    }

	    public CurrentPage<T,V> queryForPage(String countSqlName, String sqlName,
	            CurrentPage<T,V> currentPage,String dbName)throws SysException{
	        if (null == currentPage) {
	            logger.error(" queryForPage failed , because currentPage is null ! ");
	            throw new SysException(" queryForPage failed , because currentPage is null ! ");
	        }
	        if (StringUtils.isBlank(countSqlName)) {
	            logger.error(" queryForPage failed , because countSqlName is null ! ");
	            throw new SysException(" queryForPage failed , because countSqlName is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryForPage failed , because sqlName is null ! ");
	            throw new SysException(" queryForPage failed , because sqlName is null ! ");
	        }
	        return fetchPage(countSqlName, sqlName, currentPage, dbName);
	    }

	    public int queryForInt(String sqlName, V po) throws SysException{
	        if (null == po) {
	            logger.error(" queryForInt failed , because po is null ! ");
	            throw new SysException(" findCount failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryForInt failed , because sqlName is null ! ");
	            throw new SysException(" findCount failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" queryForInt failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" findCount failed , because SqlSessionTemplate is null ! ");
	        }
	        int result = (Integer) sqlSessionTemplate.selectOne(sqlName, po);
	        return result;
	    }

	    /**
	     * @description
	     * @version
	     * @title
	     * @author walker
	     * @param sqlName String
	     * @param paramMap Map<String, Object>
	     * @return int
	     */
	    private int getCount(String sqlName, Object paramObject) {
	        SqlSessionTemplate losqlSessionTemplate = getSqlSessionTemplate();
	        if (null == losqlSessionTemplate) {
	            logger.error(" getCount failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" queryForPage failed , because SqlSessionTemplate is null ! ");
	        }
	        int result = 0;
	        if (null != paramObject) { // 如果有查询条件则获得mapper文件里的sql
	            // getMapperSql(sqlName, paramMap);
	            result = (Integer) losqlSessionTemplate.selectOne(sqlName, paramObject);
	        } else {
	            // getMapperSql(sqlName, null);
	            result = (Integer) losqlSessionTemplate.selectOne(sqlName);
	        }
	        return result;
	    }

	    /**
	     * oracle 数据库查询
	     * 
	     * @param countSqlName 查询符合条件记录数的sqlId
	     * @param sqlName 查询符合条件记录数详细内容的sqlId
	     * @param currentPage 当前页对象
	     * @param clazz 具体的泛型类型,封装查询结果用的
	     * @param <T> BasePO
	     * @param dbFlag 数据库标识
	     * @return CurrentPage<T>
	     */
	    private CurrentPage<T,V> fetchPage(String countSqlName, String sqlName,
	            CurrentPage<T,V> currentPage, String dbName) {
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" oracleFetchPage failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" oracleFetchPage failed , because SqlSessionTemplate is null ! ");
	        }
	        int pageNo = 0;
	        if (currentPage.getPageNo() == 1) { // 如果当前页码是第一页
	            pageNo = 0;
	        } else {
	            pageNo = currentPage.getPageNo() - 1;
	        }
	        int greaterNum = pageNo * currentPage.getPageSize();
	        int lessNum = (pageNo + 1) * currentPage.getPageSize();
	        
	        V paramObject = currentPage.getParamObject();
	        
	        // 总共查询到多少数记录
	        int rowCount = getCount(countSqlName, paramObject);
	        
	        // 计算页数
	        int pageCount = rowCount / currentPage.getPageSize();
	        // 如果总记录数大于每页条数*页数的总数量，则页数加1
	        if (rowCount > currentPage.getPageSize() * pageCount) {
	            pageCount++;
	        }
	        if (currentPage.getPageNo() > pageCount) { // 如果分页控件可也指定跳转到xx页，且最大页码已经超过总页数
	            currentPage.setPageNo(pageCount); // 设置为总页数
	        }
	        if(null == paramObject){
	            paramObject = (V) new BaseVO();
	            currentPage.setParamObject(paramObject);
	        }
	        //不同数据库进行分页
	        if(dbName==null || BaseDaoImpl.MYSQL_DB.equals(dbName)){
	        	paramObject.setStartRowNum(greaterNum);
	        	paramObject.setEndRowNum(currentPage.getPageSize());
	        }else if(BaseDaoImpl.ORACLE_DB.equals(dbName)){
	        	paramObject.setStartRowNum(greaterNum+1);
	        	paramObject.setEndRowNum(lessNum);
	        }
	        
	        // 创建返回的分页对象 ,并为其赋相应的值
	        CurrentPage<T,V> page = new CurrentPage<T,V>();
	        page.setPageNo(currentPage.getPageNo());
	        page.setPageSize(currentPage.getPageSize());
	        page.setPageTotal(pageCount);
	        page.setTotal(rowCount);
	        page.setMaxSize(currentPage.getMaxSize());
	        page.setParamObject(currentPage.getParamObject());

	        List<T> pageItems = new ArrayList<T>(); // 每页的集合
	        if (null != currentPage.getParamObject()) {
	            pageItems = sqlSessionTemplate.selectList(sqlName, currentPage.getParamObject());
	        } else {
	            pageItems = sqlSessionTemplate.selectList(sqlName);
	        }
	        page.setPageItems(pageItems);
	        return page;
	    }

	    public T updateObject(String sqlName, T po) throws SysException{
	        if (null == po) {
	            logger.error(" updateObject failed , because po is null ! ");
	            throw new SysException(" updateObject failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" updateObject failed , because sqlName is null ! ");
	            throw new SysException(" updateObject failed , because sqlName is null ! ");
	        }
	        /*if (StringUtils.isBlank(po.getLastModifyBy())) {
	            logger.error(" updateObject failed , because lastModifyBy is null ! ");
	            throw new SysException(" updateObject failed , because lastModifyBy is null ! ");
	        }*/
	        //TODO 为修改人赋值
//	        po.setLastModifyDate(DateUtil.getTodayTime());
//	        if (null == this.sqlSessionTemplate) {
//	            logger.error(" updateObject failed , SqlSessionTemplate is null ! ");
//	            throw new SysException(" updateObject failed , SqlSessionTemplate is null ! ");
//	        }
	        int result = sqlSessionTemplate.update(sqlName, po);
//	        if (result != 0) {
	            return po;
//	        } else {
//	            logger.error(" updateObject failed , the class is : {}", po.getClass());
//	           throw new SysException(" updateObject failed , the class is : " + po.getClass());
//	        }
	        
	      
	    }
	    
	    public int updateObjectReturnInt(String sqlName, T po) throws SysException{
	        if (null == po) {
	            logger.error(" updateObject failed , because po is null ! ");
	            throw new SysException(" updateObject failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" updateObject failed , because sqlName is null ! ");
	            throw new SysException(" updateObject failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" updateObject failed , SqlSessionTemplate is null ! ");
	            throw new SysException(" updateObject failed , SqlSessionTemplate is null ! ");
	        }
	        if (StringUtils.isBlank(po.getLastModifyBy())) {
	            logger.error(" updateObject failed , because lastModifyBy is null ! ");
	            throw new SysException(" updateObject failed , because lastModifyBy is null ! ");
	        }
	        po.setLastModifyDate(DateUtil.getTodayTime());
	        //TODO 为修改人赋值
	        po.setLastModifyDate(DateUtil.getTodayTime());
	        int result = sqlSessionTemplate.update(sqlName, po);
	        if (result != 0) {
	            return result;
	        } else {
	            logger.error(" updateObject failed , the class is : {}"+ po.getClass());
	            throw new SysException(" updateObject failed , the class is : " + po.getClass());
	        }
	    }

	    public boolean deleteObject(String sqlName, T po) throws SysException{
	        if (null == po) {
	            logger.error(" deleteObject failed , because po is null ! ");
	            throw new SysException(" deleteObject failed , because po is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" deleteObject failed , because sqlName is null ! ");
	            throw new SysException(" deleteObject failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" SqlSessionTemplate is null ! ");
	            throw new SysException(" SqlSessionTemplate is null ! ");
	        }
	        int result = sqlSessionTemplate.delete(sqlName, po);
	        if (result != 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean batchSave(String sqlName, List<T> poList) throws SysException{
	        if (null == poList) {
	            logger.error(" batchSave failed , because poList is null ! ");
	            throw new SysException(" batchSave failed , because poList is null ! ");
	        }
	        if (poList.size() == 0) {
	            return false;
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" batchSave failed , because sqlName is null ! ");
	            throw new SysException(" batchSave failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" batchSave failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" batchSave failed , because SqlSessionTemplate is null ! ");
	        }
	        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
	        if (null == sqlSessionFactory) {
	            logger.error(" batchSave failed , because sqlSessionFactory is null ! ");
	            throw new SysException(" batchSave failed , because sqlSessionFactory is null ! ");
	        }
	        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
	        if (null == sqlSession) {
	            logger.error(" batchSave failed , because sqlSession is null ! ");
	            throw new SysException(" batchSave failed , because sqlSession is null ! ");
	        }
	        int times = 0;
	        int cnt = poList.size();
	        for (int i = 0; i < cnt; i++) {
	            if (null != poList.get(i)) { // 为查询对象所对应的表中inert_time,insert_timestamp,update_time,update_timestamp插入默认的值
	                //TODO 为创建人赋值
	                 poList.get(i).setCreateDate(DateUtil.getTodayTime());
	                // getMapperSql(sqlName, poList.get(i));
	                int time = sqlSession.insert(sqlName, poList.get(i));
	                if (time != 0) {
	                    times++;
	                }
	            } else {
	                // getMapperSql(sqlName, null);
	                int time = sqlSession.insert(sqlName);
	                if (time != 0) {
	                    times++;
	                }
	            }
	            if ((i + 1) % PubConstants.BATCH_DEAL_NUM == 0) { // 如果处理成功的总数等于传入总条数,或是满足每50条提交一次的请求
	                sqlSession.flushStatements();
	            }
	        }
	        if (cnt % PubConstants.BATCH_DEAL_NUM != 0) { // 如果处理成功的总数不满足每50条提交一次的请求
	            sqlSession.flushStatements();
	            sqlSession.close();
	        }
	        if (times > 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean batchUpdate(String sqlName, List<T> poList) throws SysException{
	        if (null == poList) {
	            logger.error(" batchUpdate failed , because poList is null ! ");
	            throw new SysException(" batchUpdate failed , because poList is null ! ");
	        }
	        if (poList.size() == 0) {
	            return false;
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" batchUpdate failed , because sqlName is null ! ");
	            throw new SysException(" batchUpdate failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" batchUpdate failed ,  because  SqlSessionTemplate is null ! ");
	            throw new SysException(" batchUpdate failed ,  because  SqlSessionTemplate is null ! ");
	        }
	        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
	        if (null == sqlSessionFactory) {
	            logger.error(" batchUpdate failed ,  because  sqlSessionFactory is null ! ");
	            throw new SysException(" batchUpdate failed ,  because  sqlSessionFactory is null ! ");
	        }
	        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
	        if (null == sqlSession) {
	            logger.error(" batchUpdate failed , because  sqlSession is null ! ");
	            throw new SysException(" batchUpdate failed , because  sqlSession is null ! ");
	        }
	        int times = 0;
	        int cnt = poList.size();
	        for (int i = 0; i < cnt; i++) {
	            if (null != poList.get(i)) {
	                
	                //TODO 为修改人赋值
	                poList.get(i).setLastModifyDate(DateUtil.getTodayTime());
	                // getMapperSql(sqlName, poList.get(i));
	                int time = sqlSessionTemplate.update(sqlName, poList.get(i));
	                if (time != 0) {
	                    times++;
	                }
	            } else {
	                // getMapperSql(sqlName, null);
	                int time = sqlSessionTemplate.update(sqlName);
	                if (time != 0) {
	                    times++;
	                }
	            }
	            if ((i + 1) % PubConstants.BATCH_DEAL_NUM == 0) { // 如果处理成功的总数等于传入总条数,或是满足每50条提交一次的请求
	                sqlSession.flushStatements();
	            }
	        }
	        if (cnt % PubConstants.BATCH_DEAL_NUM != 0) { // 如果处理成功的总数不满足每50条提交一次的请求
	            sqlSession.flushStatements();
	            sqlSession.close();
	        }
	        if (times > 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public boolean batchDelete(String sqlName, List<T> poList) throws SysException{
	        if (null == poList) {
	            logger.error(" batchDelete failed , because poList is null ! ");
	            throw new SysException(" batchDelete failed , because poList is null ! ");
	        }
	        if (poList.size() == 0) {
	            return false;
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" batchDelete failed , because sqlName is null ! ");
	            throw new SysException(" batchDelete failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" batchDelete failed ,  because  SqlSessionTemplate is null ! ");
	            throw new SysException(" batchDelete failed ,  because  SqlSessionTemplate is null ! ");
	        }
	        SqlSessionFactory sqlSessionFactory = sqlSessionTemplate.getSqlSessionFactory();
	        if (null == sqlSessionFactory) {
	            logger.error("batchDelete failed ,  because  sqlSessionFactory is null ! ");
	            throw new SysException("batchDelete failed ,  because  sqlSessionFactory is null ! ");
	        }
	        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH, false);
	        if (null == sqlSession) {
	            logger.error("batchDelete failed ,  because sqlSession is null ! ");
	            throw new SysException("batchDelete failed ,  because sqlSession is null ! ");
	        }
	        int times = 0;
	        int cnt = poList.size();
	        for (int i = 0; i < cnt; i++) {
	            int time = sqlSessionTemplate.delete(sqlName, poList.get(i));
	            if (time != 0) {
	                times++;
	            }
	            if ((i + 1) % PubConstants.BATCH_DEAL_NUM == 0) { // 如果处理成功的总数等于传入总条数,或是满足每50条提交一次的请求
	                sqlSession.flushStatements();
	            }
	        }
	        if (cnt % PubConstants.BATCH_DEAL_NUM != 0) { // 如果处理成功的总数不满足每50条提交一次的请求
	            sqlSession.flushStatements();
	            sqlSession.close();
	        }
	        if (times > 0) {
	            return true;
	        } else {
	            return false;
	        }
	    }

		@Override
		public String queryForString(String sqlName, V vo) throws SysException {
			if (null == vo) {
	            logger.error(" queryForString failed , because po is null ! ");
	            throw new SysException(" findCount failed , because vo is null ! ");
	        }
	        if (StringUtils.isBlank(sqlName)) {
	            logger.error(" queryForString failed , because sqlName is null ! ");
	            throw new SysException(" findCount failed , because sqlName is null ! ");
	        }
	        if (null == this.sqlSessionTemplate) {
	            logger.error(" queryForString failed , because SqlSessionTemplate is null ! ");
	            throw new SysException(" findCount failed , because SqlSessionTemplate is null ! ");
	        }
	        String result =  sqlSessionTemplate.selectOne(sqlName, vo);
	        return result;
		}


}
