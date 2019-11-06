package ytrj.yc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WxdlLoginController {
	private static final String APPID = "wxb88xxxxxxxx46140e";
	private static final String SECRET = "19fa40c6xxxxxxxx6ae971267";
	
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@RequestMapping(value = "login")
	public String login(String code) {
		System.out.println(code);
		System.out.println("-----------------------------");
		//微信接口
		String url = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";
		//发送请求给微信后端
		
		return code;
		
	}
}
