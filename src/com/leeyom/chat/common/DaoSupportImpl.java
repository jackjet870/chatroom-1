package com.leeyom.chat.common;


import com.leeyom.chat.util.PageObject;
import com.leeyom.chat.util.PageUtil;
import com.leeyom.chat.util.StringUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.impl.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoSupportImpl extends HibernateDaoSupport implements DaoSupport {
    private Logger log = LogManager.getLogger(getClass());
    private DetachedCriteria dc;


    @Autowired
    public void setSessionFactoryOverride(SessionFactory sessionFactory) {

        super.setSessionFactory(sessionFactory);
    }

    public Serializable saveObject(Object obj) throws Exception {
        return super.getHibernateTemplate().save(obj);
    }

    public void updateObject(Object obj) throws Exception {
        super.getHibernateTemplate().update(obj);
    }

    public void saveOrUpdate(Object obj) throws Exception {
        super.getHibernateTemplate().saveOrUpdate(obj);
    }

    public void batchUpdateObject(String hql, Object[] values) {
        super.getHibernateTemplate().bulkUpdate(hql, values);
    }

    public void deleteObject(Class clazz, long id) throws Exception {
        Object obj = loadObject(clazz, id);
        if (obj != null)
            super.getHibernateTemplate().delete(obj);
    }

    public void deleteAllObjects(Class clazz, long[] ids) throws Exception {
        for (int i = 0; i < ids.length; i++)
            deleteObject(clazz, ids[i]);
    }

    public boolean isExist(Class clazz, String propertyName, String value, String idColumn, long id)
            throws Exception {
        String hql = "select count(*) from " + clazz.getName() + " as a " +
                "where a." + propertyName + "=? and a." + idColumn + "<>?";
        Object[] values = {value, new Long(id)};
        Integer i =
                (Integer) super.getHibernateTemplate().iterate(hql, values)
                        .next();

        return i.intValue() > 0;
    }

    public Object loadObject(Class clazz, long id) throws Exception {
        return super.getHibernateTemplate().get(clazz, new Long(id));
    }

    public void flush() {
        super.getHibernateTemplate().flush();
    }

    public void hibernateclear() {
        super.getHibernateTemplate().clear();
    }

    public void sessionClear() {
        super.getSession().clear();
    }

    public void refresh(Object obj) {
        super.getHibernateTemplate().refresh(obj);
    }

    public void deleteObject(Object object) {
        super.getHibernateTemplate().delete(object);
    }

    public Object getObject(Class clazz, Serializable id) throws Exception {
        return super.getHibernateTemplate().get(clazz, id);
    }

    public Object merge(Object obj) {
        return super.getHibernateTemplate().merge(obj);
    }

    public List getList(String hql, Object[] values) {
        if (hql != null) {
            return super.getHibernateTemplate().find(hql, values);
        }
        this.log.error("hqlû�����ã����ߴ���");
        return null;
    }

    //��ҳ����
    public List getListPage(PageObject pageObject, String queryStr, List paramLsit, List valueList) {
        //queryStr = queryStr.replaceAll("\\|\\|", "+");//ת��sql
        List list = new ArrayList();
        int rowCount = 0;
        if (paramLsit == null) {
            rowCount = getTotal(queryStr, null, valueList);//获取总记录数
        } else {
            rowCount = getTotal(queryStr, paramLsit, valueList);//获取总记录数
        }

        System.out.println("获取总记录" + rowCount);
        int pageCount = PageUtil.getPageCount(rowCount, pageObject//获取总页数
                .getPageSize());
        if (pageObject.getPageCurrent() > pageCount) {
            return list;
        }
        int pageCurrent = PageUtil.getCurrentPage(rowCount, pageObject//获取当前页
                .getPageSize(), pageObject.getPageCurrent());
        pageObject.setPageCount(pageCount);
        pageObject.setPageCurrent(pageCurrent);
        pageObject.setRowCount(rowCount);
        Query query = getSession().createQuery(queryStr);

        for (int i = 0; i < valueList.size(); i++) {
            if (paramLsit == null) {
                Object valueStr = valueList.get(i);
                query.setParameter(i, valueStr);
            } else {
                String paramStr = (String) paramLsit.get(i);
                Object valueStr = valueList.get(i);
                query.setParameter(paramStr, valueStr);
            }

        }
        System.out.println((pageCurrent - 1) * pageObject.getPageSize() + "查询条数@@@@@@@@@@@@@@" + pageObject.getPageSize());
        query.setFirstResult((pageCurrent - 1) * pageObject.getPageSize());
        query.setMaxResults(pageObject.getPageSize());

        if (rowCount > 0) {
            list = query.list();
        }
        return list;
    }

    //获取总记录数
    protected int getTotal(String queryStr, List paramList, List valueList) {
        int start = queryStr.indexOf("from");
        List result = null;
        String from = queryStr.substring(start, queryStr.length());

        if (from.indexOf("order") > -1) {
            from = from.substring(0, from.indexOf("order"));
        }
        String countStr = "select count(*) " + from;
        if (paramList == null) {
            result = this.getHibernateTemplate().find(countStr, StringUtil.list2Values(valueList));
        } else {
            result = this.getHibernateTemplate().findByNamedParam(countStr,
                    StringUtil.list2Array(paramList),
                    StringUtil.list2Values(valueList));
        }


        if (null != result && !result.isEmpty()) {
            return ((Integer) result.get(0)).intValue();
        } else {
            return 0;
        }
    }

    public int executeByHQL(String hql, Object[] values) {
        if (hql != null) {
            Session session = getSession();
            Query query = session.createQuery(hql);
            if (values != null) {
                for (int i = 0; i < values.length; i++) {
                    query.setParameter(i, values[i]);
                }
            }
            int exEntities = query.executeUpdate();
            return exEntities;
        }
        return 0;
    }

    public int count(String hql, Object[] values) {
        if (hql != null) {
            String hqlCount = hql;
            if (hqlCount.indexOf(" order ") > 0) {
                hqlCount = hqlCount.substring(0, hqlCount.indexOf("order"));
            }
            if (hqlCount.indexOf("select") >= 0) {
                hqlCount = hqlCount.substring(hqlCount.indexOf("from"));
            }
            String hqlRowTotal = "select count(*) " + hqlCount;
            Integer totalNum =
                    (Integer) super.getHibernateTemplate().iterate(
                            hqlRowTotal, values).next();
            return totalNum.intValue();
        }
        this.log.error("hqlû�����ã����ߴ���");
        return 0;
    }

    private java.sql.Date stringToSQLDate(String datestring) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date newdate = null;
        try {
            newdate = sdf.parse(datestring);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        java.sql.Date datetime = new java.sql.Date(newdate.getTime());
        return datetime;
    }


    public PreparedStatement executeSQL(String sql) {
        Session session = super.getSession();
        PreparedStatement pstmt = null;
        try {
            pstmt = ((SessionImpl) session).getBatcher().prepareStatement(sql);
            pstmt.execute();
        } catch (HibernateException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public PreparedStatement getPreparedStatement(String sql) {
        Session session = super.getSession();
        PreparedStatement pstmt = null;
        try {
            pstmt = ((SessionImpl) session).getBatcher().prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pstmt;
    }

    public DetachedCriteria getDc() {
        return dc;
    }

    public void setDc(DetachedCriteria dc) {
        this.dc = dc;
    }

    public List getListByIndex(String hql, List list) {
        hql = hql.replaceAll("\\|\\|", "+");//针对sqlserver转换sql语句
        Query query = getSession().createQuery(hql);
        for (int i = 0; i < list.size(); i++) {
            Object valueStr = (Object) list.get(i);
            System.out.println("获取的值**********************************" + valueStr);
            query.setParameter(i, valueStr);
        }
        return query.list();
    }

    /**
     * 获取当前会话
     */
    @Override
    public Session getCurrentSession() {
        Session session = super.getSession();
        return session;
    }

}