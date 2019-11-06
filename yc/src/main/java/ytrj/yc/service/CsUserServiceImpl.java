package ytrj.yc.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ytrj.yc.bean.CsUser;
import ytrj.yc.mapper.CsUserMapper;
import ytrj.yc.service.ex.UserInformationAlreadyExists;
@Service
public class CsUserServiceImpl implements CsUserService{
	@Resource
	private CsUserMapper csUserMapper;

	public void regiCsUser(CsUser csUser) {
		Integer csUser1 = csUserMapper.selectCsUserName(csUser.getName());
		Integer csUser2 = csUserMapper.selectCsUserPhone(csUser.getPhone());
		Integer csUser3 = csUser1+csUser2;
		if(csUser3>3) {
			//����û������ֺ��ֻ��Ŷ����ڣ��׳��쳣
			throw new UserInformationAlreadyExists("�û���Ϣ�Ѵ���");
		}else {
			//��ӳ�ʦ�û�
			csUserMapper.insertCsUser(csUser);
		}
	}
	/**
	 * ��֤��ʦ�û���
	 */
	public boolean cheakCsUserName(String name) {
		if(csUserMapper.selectCsUserName(name)==null) {
			return false;
		}else {
			return true;			
		}
	}
	/**
	 * ��֤��ʦ�ֻ���
	 */
	public boolean cheakCsUserPhone(String phone) {
		return csUserMapper.selectCsUserPhone(phone)>0;
	}
}
