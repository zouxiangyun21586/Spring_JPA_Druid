package com.atguigu.jpa.spring;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.jpa.service.PersonService;
import com.atguigu.jpa.spring.entities.Person;

/**
 * 测试使用durid 数据源整合spring与jpa
 * @author zxy-un
 * 
 * 2018年8月31日 下午3:15:54
 */
public class JPATest {
	
	private ApplicationContext ctx = null;
	private PersonService personService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		personService = ctx.getBean(PersonService.class);
	}
	
	@Test
	public void savePersonService(){
		Person p1 = new Person();
		p1.setAge(13);
		p1.setEmail("CC@163.com");
		p1.setLastName("CC");
		
		Person p2 = new Person();
		p2.setAge(14);
		p2.setEmail("DD@163.com");
		p2.setLastName("DD");
		
		System.out.println(personService.getClass().getName());
		personService.savePersons(p1, p2);
	}
	
	@Test
	public void delPersonService(){
		Person p = new Person();
		p.setId(4);
		personService.delPersons(p);
	}
	
	@Test
	public void updPersonService(){
		Person p1 = new Person();
		p1.setId(5);
		p1.setAge(18);
		p1.setEmail("DDE@163.com");
		p1.setLastName("DDE");
		
		personService.updPersons(p1);
		
	}
	
	@Test
	public void testDataSource() throws SQLException {
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection());
	}

}
