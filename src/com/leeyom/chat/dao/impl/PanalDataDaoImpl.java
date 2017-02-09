package com.leeyom.chat.dao.impl;

import com.leeyom.chat.common.BaseServiceSupport;
import com.leeyom.chat.dao.PanalDataDao;
import com.leeyom.chat.domain.PanalData;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述:
 * author:leeyom
 * Date: 17/1/19
 */
@Repository
public class PanalDataDaoImpl extends BaseServiceSupport implements PanalDataDao{

    /**
     * 描述: 保存面板数据
     * 作者: leeyom
     * 时间: 2017-01-19 11:38
     * @param panalData
     */
    @Override
    public void saveOrUpdatePanalData(PanalData panalData) {
        try {
            dao.saveOrUpdate(panalData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public PanalData getPanalDataById(String hql, Object[] objects) {
        try {
            List<PanalData> panalDatas = dao.getList(hql,objects);
            if (panalDatas.size()>0){
                return panalDatas.get(0);
            }else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
