package com.xiangtan.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.cxf.binding.corba.wsdl.Array;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.dao.AreaDao;
import com.xiangtan.dao.Role_lvDao;
import com.xiangtan.dao.SampleDao;
import com.xiangtan.service.SampleService;

public class SampleServiceImpl implements SampleService{

	private SampleDao sampleDao;
	private Role_lvDao role_lvDao;
	private AreaDao areaDao;
	public void setSampleDao(SampleDao sampleDao) {
		//System.out.println("set SampleDao:" + sampleDao);
		this.sampleDao = sampleDao;
	}
	public void setRole_lvDao(Role_lvDao role_lvDao) {
		this.role_lvDao = role_lvDao;
	}
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}
	
	@Override
	public List<String> getRegionByUserId(int userId, String key) {
		// TODO Auto-generated method stub
//		System.out.println("role_lvs:" + role_lvDao.getRole_lvsByUserid(userId));
		List<Role_lv>role_lvs = role_lvDao.getRole_lvsByUserid(userId);
		List<String>regions = new ArrayList<>();
		for (Role_lv role_lv : role_lvs) {
			//此处只取region类型的角色
			if (role_lv.getType().equals("command")) {
				continue;
			}
			String regionText = role_lv.getDesText();
			String str[] = regionText.split("\\|\\|");
			for (int i = 0; i < str.length; i++) {
				if(!str[i].equals("")){
					if (!regions.contains(str[i])) {
						regions.add(str[i]);
					}
				}
			}
			/*
			if (!regions.contains(role_lv.getDesText())) {
				regions.add(role_lv.getDesText());
			}
			*/
		}
		System.out.println(regions);
		List<String>list = new ArrayList<>();
		for (String region : regions) {
			list.add(areaDao.get(region).getAreaName());
		}
		System.out.println(list);
		//List<String>list = new ArrayList<>();
		return list;
	}
}
