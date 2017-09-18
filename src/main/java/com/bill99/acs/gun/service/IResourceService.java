package com.bill99.acs.gun.service;

import java.util.ArrayList;

import com.bill99.acs.gun.entity.Resource;

/**
 * 
 * @className IResourceService
 * @description
 * @author haodong.wang
 * @date 2017年9月14日 下午4:07:13
 */
public interface IResourceService {

	ArrayList<Resource> getResourceList();

	Resource queryResourceById(Long id);

	void updateResourceSelective(Resource resource);
}
