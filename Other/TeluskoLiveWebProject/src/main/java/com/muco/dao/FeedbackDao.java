package com.muco.dao;

import com.muco.entity.Feedback;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class FeedbackDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void addFeedback(Feedback feedback) {
        System.out.println("in addFeedback " + feedback);

        Session session = sessionFactory.getCurrentSession();
        session.save(feedback);
    }

    @Transactional
    public List<Feedback> getFeedbacks() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Feedback");

        List<Feedback> listOfFeedbacks = (List<Feedback>) query.list();
        System.out.println(listOfFeedbacks);
        return listOfFeedbacks;
    }

}
