package com.zyc.sys.base.dao;

import java.util.List;
import java.util.Map;

import com.zyc.sys.base.exception.SysException;
import com.zyc.sys.base.model.BasePO;
import com.zyc.sys.base.model.BaseVO;
import com.zyc.sys.base.model.CurrentPage;

public interface IBaseDao <T extends BasePO,V extends BaseVO> {
	
	/**
     * 创建对象
     * 
     * @param sqlName mapper文件sqlId
     * @param po po实体
     * @return 创建后的对象并赋予了主键 @
     */
    public T createObject(String sqlName, T po)throws SysException;
    
    /**
     * 返回int值
     * 
     * @param sqlName String
     * @param vo实体 T
     * @param <T> BasePO
     * @return int
     */
    public int queryForInt(String sqlName, V vo)throws SysException;
    /**
     * 返回String
     * @Description: TODO
     * @param @param sqlName
     * @param @param vo
     * @param @return
     * @param @throws SysException   
     * @return String  
     * @throws
     * @author jinbaocai
     * @date 2016年4月27日
     */
    public String queryForString(String sqlName, V vo)throws SysException;

    /**
     * 查询单条数据
     * 
     * @param sqlName mapper文件sqlId
     * @param po实体
     * @param vo实体
     * @param <T> BasePO
     * @return 符合条件的记录 @
     */
    public T queryForObject(String sqlName, V vo)throws SysException;

    /**
     * 查询多单数据
     * 
     * @param sqlName mapper文件sqlId
     * @param po实体
     * @param vo实体
     * @return 符合条件的记录 @
     */
    public List<T> queryForList(String sqlName, V vo)throws SysException;
    

    /**
     * 查询多条数据
     * 
     * @param sqlName mapper文件sqlId
     * @param vo实体 
     * @return 查询多条数据 @
     */
    public List<Map<String, Object>> queryForMap(String sqlName, V po)throws SysException;

    /**
     * 分页查询
     * 
     * @param countSqlName 查询总数的sqlId
     * @param sqlName mapper文件sqlId
     * @param currentPage 当前页对象
     * @param dbName 数据库名称
     * @return 当前页page对象 @
     */
    public CurrentPage<T,V> queryForPage(String countSqlName, String sqlName,
            CurrentPage<T,V> currentPage,String dbName)throws SysException;

    /**
     * 修改对象
     * 
     * @param sqlName mapper文件sqlId
     * @param po where条件后赋值用的po
     * @return 修改后的对象的 @
     */
    public T updateObject(String sqlName, T po)throws SysException;
    
    /**
     * @description 修改对象
     * @version
     * @title
     * @author walker
     * @param sqlName mapper文件sqlId
     * @param po where条件后赋值用的po
     * @return 修改成功数据的条数
    */
    public int updateObjectReturnInt(String sqlName, T po)throws SysException;

    /**
     * 删除对象
     * 
     * @param sqlName mapper文件sqlId
     * @param po where条件后赋值用的po
     * @return true:删除成功，false:失败 @
     */
    public boolean deleteObject(String sqlName, T po)throws SysException;

    /**
     * 批量新增
     * 
     * @param sqlName mapper文件sqlId
     * @param poList po对象集合
     * @return true:删除成功，false:失败 @
     */
    public boolean batchSave(String sqlName, List<T> poList)throws SysException;

    /**
     * 批量更新
     * 
     * @param sqlName mapper文件sqlId
     * @param poList po对象集合
     * @return true:删除成功，false:失败 @
     */
    public boolean batchUpdate(String sqlName, List<T> poList)throws SysException;

    /**
     * 批量删除
     * 
     * @param sqlName mapper文件sqlId
     * @param poList po对象集合
     * @return true:删除成功，false:失败 @
     */
    public boolean batchDelete(String sqlName, List<T> poList)throws SysException;

}
