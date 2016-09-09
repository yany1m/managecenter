package com.runrong.managecenter.business.cache;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import com.runrong.managecenter.business.model.StatementTemplate;

/**
 * 被选择的报表模板缓存
 * @author yanyimin
 *
 */
@Component
public class SelectdStatementTemplateCache implements InitializingBean{
	@Autowired
  	CacheManager cacheManager;

    private Cache cache;

    public void put(String adminId,Integer id){
        cache.put(adminId,id);
    }


    public Integer get(String adminId){
        return cache.get(adminId,Integer.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = cacheManager.getCache("selectdStatementTemplate");
    }
}
