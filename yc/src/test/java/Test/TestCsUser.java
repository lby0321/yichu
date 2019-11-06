package Test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ytrj.yc.bean.CsUser;
import ytrj.yc.mapper.CsUserMapper;

public class TestCsUser {
	@Test
	public void TestInsertCsUser() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml");
		CsUserMapper cum = ac.getBean("csUserMapper", CsUserMapper.class);
		CsUser cu = new CsUser();
		cu.setId(2);
		cu.setName("admin");
		cu.setPhone("123456");
		cu.setSite("河南省中原区");
		cum.insertCsUser(cu);
	}

	@Test
	public void TestselectCsUserName() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		CsUserMapper cum = ac.getBean("csUserMapper",CsUserMapper.class);
		System.out.println(cum.selectCsUserName("admin"));
	}
	
	@Test
	public void TestselectCsUserPhone() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring-dao.xml", "spring-service.xml");
		CsUserMapper cum = ac.getBean("csUserMapper",CsUserMapper.class);
		System.out.println(cum.selectCsUserPhone("123456"));
	}

}
