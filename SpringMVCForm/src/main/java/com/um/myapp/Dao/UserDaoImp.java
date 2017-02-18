package com.um.myapp.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.um.myapp.model.User;

@Repository ("userDao")
public class UserDaoImp extends AbstractDao<Integer,User> implements UserDao {
	private static Logger logger = LoggerFactory.getLogger(UserDaoImp.class);

	public User findById(Integer id) {
		return getByKey(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		Criteria criteria = createEntityCriteria();
		return (List<User>)criteria.list();
	}

	public void save(User user) {
		persist(user);	
	}

	public void update(User user) {
		persist(user);	
	}

	public void delete(Integer id) {
		Query query = getSession().createQuery("delete from User where id = ?");
		query.setInteger("id", id);
		query.executeUpdate();	
	}
	
}
