package ytrj.yc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ytrj.yc.bean.CsUser;
import ytrj.yc.bean.ResponseResult;
import ytrj.yc.service.CsUserService;

@Controller
@RequestMapping("/csuser")
public class CsUserController {
	@Resource
	private CsUserService csUserService;
	
	/**
	 * ��ʾע��ҳ��
	 * @return
	 */
	@RequestMapping("/showregicsuser.do")
	public String regiCsUser() {
		return "register";
	}
	
	@RequestMapping("/checkCsUsername.do")
	@ResponseBody
	public ResponseResult<Void> cheakCsUserName(String name){
		ResponseResult<Void> rr;
		//�������true,��ʾ�û�������
		//�������false����ʾ�û���������
		if(csUserService.cheakCsUserName(name)) {
			rr = new ResponseResult<Void>(0,"�û����Ѿ�����");
		}else {
			rr = new ResponseResult<Void>(1,"�û�������ʹ��");
		}
		return rr;
	}
	
	@RequestMapping("/cheakCsUserPhone.do")
	@ResponseBody
	public ResponseResult<Void> cheakCsUserPhone(String phone){
		ResponseResult<Void> rr;
		//�������true,��ʾ�û�������,
		//�������false,��ʾ�û���������
		if(csUserService.cheakCsUserPhone(phone)){
			rr = new ResponseResult<Void>(0,"�绰�����Ѿ�����");
		}else{
			rr = new ResponseResult<Void>(1,"�绰�������ʹ��");
		}
		return rr;
	}
	
	@RequestMapping("/regicsuser.do")
	@ResponseBody
	public ResponseResult<Void> regiCsUser(
			String name,String phone,
			String site,Integer age,String password){
		ResponseResult<Void> rr;
		CsUser csUser =  new CsUser();
		csUser.setName(name);
		csUser.setPhone(phone);
		csUser.setSite(site);
		csUser.setAge(age);
		csUser.setPassword(password);
		try {
			csUserService.regiCsUser(csUser);
			rr= new ResponseResult<Void>(1, "ע��ɹ�");
		} catch (Exception e) {
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}

}
