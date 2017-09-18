package com.bill99.acs.gun.dao;

import java.util.ArrayList;

import com.bill99.acs.gun.entity.Resource;

public interface ResourceMapper {

	ArrayList<Resource> getResourceList();

	Resource getResource(Long id);

	void updateResourceSelective(Resource resource);

}