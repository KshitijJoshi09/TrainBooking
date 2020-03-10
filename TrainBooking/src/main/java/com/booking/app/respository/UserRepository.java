package com.booking.app.respository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.booking.app.dto.User;

@Repository
public class UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public User findUserByEmailOrMobileNoOrUserName(String loginData) {

		User user = null;

		try (Session session = sessionFactory.openSession()) {

			Query<User> hql = 
					session.createQuery(" from User where  email =:loginData or mobileNo =:loginData or userName = :loginData  ");

			hql.setParameter("loginData", loginData);
			user = hql.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public int addUser(User user) {
		int pk = -1;
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			pk = (int)session.save(user);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return pk;
	}

}
