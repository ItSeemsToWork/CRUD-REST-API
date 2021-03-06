package com.kostapo.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
 
import com.kostapo.spring.model.User;
 
 
@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int add(User user) {
		sessionFactory.getCurrentSession().save(user);
		return user.getId();
	}

	@Override
	public User get(int id) {
		return sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public List<User> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<User> cq = cb.createQuery(User.class);
		Root<User> root = cq.from(User.class);
		cq.select(root);
		Query<User> query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void update(int id, User user) {
		Session session = sessionFactory.getCurrentSession();
		User tmpuser = session.byId(User.class).load(id);
		tmpuser.setFirstname(user.getFirstname());
		tmpuser.setLastname(user.getLastname());
		session.flush();
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		User user = session.byId(User.class).load(id);
		session.delete(user);
	}
	
}
