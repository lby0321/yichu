package ytrj.yc.mapper;

import ytrj.yc.bean.CsUser;

public interface CsUserMapper {
	/**
	 * ��ӳ�ʦ��Ϣ
	 */
	void insertCsUser(CsUser csUser);
	
	/**
	 * ��ѯ�����Ƿ���ڣ����ڷ��ط�0�������ڷ���0
	 */
	Integer selectCsUserName(String name);
	
	/**
	 * ��ѯ�ֻ����Ƿ���ڣ����ڷ��ط�0�������ڷ���0
	 */
	
	Integer selectCsUserPhone(String phone);
	

}
