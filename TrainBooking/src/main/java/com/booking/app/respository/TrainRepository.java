package com.booking.app.respository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

	public List<Train> searchTrainByDestination(String from, String to) {
		List<Train> trains = null;

		try (Session session = sessionFactory.openSession()) {

			Query<Train> query = session
					.createQuery("from Train where startingPoint like :from and destinationPoint like :to ");
			query.setParameter("from", from + "%");
			query.setParameter("to", to + "%");
			
			/*
			 * Query<Train> query = session
			 * .createQuery("from Train where startingPoint like ?0 and destinationPoint like ?1"
			 * ); query.setParameter(0,from + "%"); query.setParameter(1, to + "%");
			 */
			
			trains = query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return trains;
	}

}
