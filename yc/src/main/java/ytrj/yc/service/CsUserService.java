package ytrj.yc.service;

import ytrj.yc.bean.CsUser;

public interface CsUserService {
	/**
	 * 厨师注册信息
	 */
	void regiCsUser(CsUser csUser);
	
	/**
	 * 验证用户名是否存在
	 */
	boolean cheakCsUserName(String name);
	
	/**
	 * 验证电话号码是否存在
	 */
	boolean cheakCsUserPhone(String phone);
}
