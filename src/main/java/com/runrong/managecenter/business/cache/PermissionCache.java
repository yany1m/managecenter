package com.runrong.managecenter.business.cache;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * 权限缓存
 * @author yanyimin
 *
 */
@Component
public class PermissionCache implements InitializingBean{
	@Autowired
  	CacheManager cacheManager;

    private Cache cache;

    public void put(String id,List<String> permission){
        cache.put(id,permission);
    }


    public List get(String id){
        return cache.get(id,List.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        cache = cacheManager.getCache("permissionCache");
    }
}
