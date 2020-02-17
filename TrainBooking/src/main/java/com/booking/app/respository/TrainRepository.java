package com.booking.app.respository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.booking.app.dto.Train;

@Repository
public class TrainRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public int saveTrain(Train train) {
		int pk = 0;
		Transaction tx = null;
		try (Session session = sessionFactory.openSession()) {
			tx = session.beginTransaction();
			pk = (int) session.save(train);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}

		return pk;

	}

}
