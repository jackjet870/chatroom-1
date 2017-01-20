package com.leeyom.chat.common;

import com.leeyom.chat.util.PageObject;
import org.hibernate.Session;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;

public abstract interface DaoSupport {
    public abstract Serializable saveObject(Object paramObject)
            throws Exception;

    public abstract void updateObject(Object paramObject)
            throws Exception;

    public abstract void saveOrUpdate(Object paramObject)
            throws Exception;

    public abstract void batchUpdateObject(String paramString, Object[] paramArrayOfObject);

    public abstract void deleteObject(Object paramObject);

    public abstract void deleteObject(Class paramClass, long paramLong)
            throws Exception;

    public abstract void deleteAllObjects(Class paramClass, long[] paramArrayOfLong)
            throws Exception;

    public abstract boolean isExist(Class paramClass, String paramString1, String paramString2, String paramString3, long paramLong)
            throws Exception;

    public abstract Object loadObject(Class paramClass, long paramLong)
            throws Exception;

    public abstract Object getObject(Class paramClass, Serializable paramSerializable)
            throws Exception;

    public abstract void flush();

    public abstract Object merge(Object paramObject);

    public abstract void hibernateclear();

    public abstract void sessionClear();

    public abstract void refresh(Object paramObject);

    public abstract List getList(String paramString, Object[] paramArrayOfObject);

    public abstract List getListPage(PageObject pageObject, String paramString, List paramLsit, List valueList);

    public abstract int executeByHQL(String paramString, Object[] paramArrayOfObject);

    public abstract int count(String paramString, Object[] paramArrayOfObject);

    public abstract PreparedStatement executeSQL(String paramString);

    public abstract Session getCurrentSession();

    public abstract PreparedStatement getPreparedStatement(String paramString);

    public List getListByIndex(String hql, List list);

}
