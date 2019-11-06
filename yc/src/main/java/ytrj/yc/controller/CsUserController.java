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
	 * 显示注册页面
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
		//如果返回true,表示用户名存在
		//如果返回false，表示用户名不存在
		if(csUserService.cheakCsUserName(name)) {
			rr = new ResponseResult<Void>(0,"用户名已经存在");
		}else {
			rr = new ResponseResult<Void>(1,"用户名可以使用");
		}
		return rr;
	}
	
	@RequestMapping("/cheakCsUserPhone.do")
	@ResponseBody
	public ResponseResult<Void> cheakCsUserPhone(String phone){
		ResponseResult<Void> rr;
		//如果返回true,表示用户名存在,
		//如果返回false,表示用户名不存在
		if(csUserService.cheakCsUserPhone(phone)){
			rr = new ResponseResult<Void>(0,"电话号码已经存在");
		}else{
			rr = new ResponseResult<Void>(1,"电话号码可以使用");
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
			rr= new ResponseResult<Void>(1, "注册成功");
		} catch (Exception e) {
			rr = new ResponseResult<Void>(0,e.getMessage());
		}
		return rr;
	}

}
