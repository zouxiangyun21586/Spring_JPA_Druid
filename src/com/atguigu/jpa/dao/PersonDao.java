package com.atguigu.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.atguigu.jpa.spring.entities.Person;

@Repository
public class PersonDao {

	//��λ�ȡ���͵�ǰ��������� EntityManager ������ ?
	//ͨ�� @PersistenceContext ע������ǳ�Ա����!
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(Person person){
		entityManager.persist(person);
	}
	
	/**
	 * ��һ���Ǹ��ݱ������ݿ�ֱ��ɾ��
	 * �ڶ������Ȳ�ѯ��ָ�����ݺ�ɾ��
	 * @author zxy-un
	 * 
	 * @param person
	 * 
	 * ����11:45:28
	 */
	public void del(Person person){
		Query qu = entityManager.createNativeQuery("delete from spring_jpa_druid where id =" + person.getId());
		qu.executeUpdate();
		
//		Person q = entityManager.find(Person.class, person.getId());
//		entityManager.remove(q);
	}
	
	/**
	 * �޸ĵ�id���ڱ��޸�,����޸ĵ�id�����ھ�����(��Ϊ�����Զ���������id��������id��һ���ǿ��ܵ�)
	 * @author zxy-un
	 * 
	 * @param person
	 * 
	 * ����11:53:32
	 */
	public void upd(Person person){
		Person p = entityManager.merge(person);
	}
	
}
