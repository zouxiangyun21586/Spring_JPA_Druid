package com.atguigu.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.jpa.dao.PersonDao;
import com.atguigu.jpa.spring.entities.Person;

@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;
	
	@Transactional // 开启事务的标签
	public void savePersons(Person p1, Person p2){
		personDao.save(p1);
		
//		int i = 10 / 0; // 事务回滚(开启后会插入p1值,但回滚后p1值消失,因为事务原则是要么都成功,要么都失败)
		
		personDao.save(p2);
	}
	
	@Transactional
	public void delPersons(Person person){
		personDao.del(person);
	}
	
	@Transactional
	public void updPersons(Person person){
		personDao.upd(person);
	}
	
}
