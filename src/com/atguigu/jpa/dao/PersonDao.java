package com.atguigu.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.atguigu.jpa.spring.entities.Person;

@Repository
public class PersonDao {

	//如何获取到和当前事务关联的 EntityManager 对象呢 ?
	//通过 @PersistenceContext 注解来标记成员变量!
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Person person){
		entityManager.persist(person);
	}
	
	/**
	 * 第一种是根据本地数据库直接删除
	 * 第二种是先查询出指定数据后删除
	 * @author zxy-un
	 * 
	 * @param person
	 * 
	 * 上午11:45:28
	 */
	public void del(Person person){
		Query qu = entityManager.createNativeQuery("delete from spring_jpa_druid where id =" + person.getId());
		qu.executeUpdate();
		
//		Person q = entityManager.find(Person.class, person.getId());
//		entityManager.remove(q);
	}
	
	/**
	 * 修改的id存在便修改,如果修改的id不存在就新增(因为表是自动增长所以id与你插入的id不一致是可能的)
	 * @author zxy-un
	 * 
	 * @param person
	 * 
	 * 上午11:53:32
	 */
	public void upd(Person person){
		Person p = entityManager.merge(person);
	}
	
}
