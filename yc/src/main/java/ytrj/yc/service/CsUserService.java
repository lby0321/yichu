package ytrj.yc.service;

import ytrj.yc.bean.CsUser;

public interface CsUserService {
	/**
	 * ��ʦע����Ϣ
	 */
	void regiCsUser(CsUser csUser);
	
	/**
	 * ��֤�û����Ƿ����
	 */
	boolean cheakCsUserName(String name);
	
	/**
	 * ��֤�绰�����Ƿ����
	 */
	boolean cheakCsUserPhone(String phone);
}
