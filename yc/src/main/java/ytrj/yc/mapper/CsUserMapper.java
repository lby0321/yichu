package ytrj.yc.mapper;

import ytrj.yc.bean.CsUser;

public interface CsUserMapper {
	/**
	 * 添加厨师信息
	 */
	void insertCsUser(CsUser csUser);
	
	/**
	 * 查询姓名是否存在，存在返回非0，不存在返回0
	 */
	Integer selectCsUserName(String name);
	
	/**
	 * 查询手机号是否存在，存在返回非0，不存在返回0
	 */
	
	Integer selectCsUserPhone(String phone);
	

}
