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
			//如果用户的名字和手机号都存在，抛出异常
			throw new UserInformationAlreadyExists("用户信息已存在");
		}else {
			//添加厨师用户
			csUserMapper.insertCsUser(csUser);
		}
	}
	/**
	 * 验证厨师用户名
	 */
	public boolean cheakCsUserName(String name) {
		if(csUserMapper.selectCsUserName(name)==null) {
			return false;
		}else {
			return true;			
		}
	}
	/**
	 * 验证厨师手机号
	 */
	public boolean cheakCsUserPhone(String phone) {
		return csUserMapper.selectCsUserPhone(phone)>0;
	}
}
