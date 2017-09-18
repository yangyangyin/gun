package com.bill99.acs.gun.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bill99.acs.gun.dao.ResourceMapper;
import com.bill99.acs.gun.entity.Resource;
import com.bill99.acs.gun.service.IResourceService;

/**
 * 
 * @className ResourceServiceImpl
 * @description
 * @author haodong.wang
 * @date 2017年9月14日 下午4:08:49
 */
@Service
public class ResourceServiceImpl implements IResourceService {

	@Autowired
	private ResourceMapper resourceMapper;

	@Override
	public ArrayList<Resource> getResourceList() {
		return this.resourceMapper.getResourceList();
	}

	@Override
	public Resource queryResourceById(Long id) {
		return this.resourceMapper.getResource(id);
	}

	@Override
	public void updateResourceSelective(Resource resource) {
		this.resourceMapper.updateResourceSelective(resource);
	}

}
