package com.bill99.acs.gun.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bill99.acs.gun.common.base.BaseController;
import com.bill99.acs.gun.entity.Resource;
import com.bill99.acs.gun.entity.vo.ResourceVo;
import com.bill99.acs.gun.service.impl.ResourceServiceImpl;

/**
 * @className ResourceController
 * @description 资源控制器
 * @author haodong.wang
 * @date 2017年9月13日 下午3:38:57
 */

@RequestMapping("resource")
@Controller
public class ResourceController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(ResourceController.class);
	@Autowired
	private ResourceServiceImpl resourceService;

	/**
	 * 菜单管理
	 * 
	 * @return
	 */
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	public String getResource() {
		return "/resource/resource";
	}

	/**
	 * 菜单详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "detail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView toResourceDetail(@RequestParam("pId") Long pId, @RequestParam("id") Long id) {
		Resource resource = this.resourceService.queryResourceById(id);
		ModelAndView view = new ModelAndView("/resource/resource_detail");
		ResourceVo resourceVo = new ResourceVo();
		resourceVo.setId(resource.getId());
		resourceVo.setpId(resource.getParentResourceId());
		resourceVo.setName(resource.getResourceName());
		resourceVo.setPage(resource.getResourceUrl());
		view.addObject("resource", resourceVo);
		return view;
	}

	@ResponseBody
	@RequestMapping(value = "tree", method = RequestMethod.GET)
	public ArrayList<ResourceVo> queryResourceList() {
		logger.info("get resourceTree");
		ArrayList<ResourceVo> resourceVoList = new ArrayList<ResourceVo>();
		ArrayList<Resource> resList = this.resourceService.getResourceList();
		for (Resource resource : resList) {
			ResourceVo resourceVo = new ResourceVo();
			resourceVo.setId(resource.getId());
			resourceVo.setpId(resource.getParentResourceId());
			resourceVo.setName(resource.getResourceName());
			resourceVo.setPage(resource.getResourceUrl());
			resourceVoList.add(resourceVo);
		}
		return resourceVoList;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String updateResourceSelective(ResourceVo resourceVo) {
		Resource resource = new Resource();
		resource.setId(resourceVo.getId());
		resource.setParentResourceId(resourceVo.getpId());
		resource.setResourceName(resourceVo.getName());
		resource.setResourceUrl(resourceVo.getPage());
		this.resourceService.updateResourceSelective(resource);
		return REDIRECT + "/index";

	}

}
