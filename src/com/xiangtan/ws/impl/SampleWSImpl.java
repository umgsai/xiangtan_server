package com.xiangtan.ws.impl;

import java.util.List;

import com.xiangtan.service.SampleService;
import com.xiangtan.ws.SampleWS;

public class SampleWSImpl implements SampleWS{

	private static SampleService sampleService;
	public static void setSampleService(SampleService sampleService) {
		System.out.println("set sampleService:" + sampleService);
		SampleWSImpl.sampleService = sampleService;
	}
	@Override
	public List<String> getRegionByUserId(int userId, String key) {
		System.out.println("µ÷ÓÃ" + sampleService);
		
		return sampleService.getRegionByUserId(userId, key);
	}

}
