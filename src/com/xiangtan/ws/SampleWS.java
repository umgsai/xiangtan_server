package com.xiangtan.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface SampleWS {

	@WebMethod
	public List<String> getRegionByUserId(int userId, String key);
}
