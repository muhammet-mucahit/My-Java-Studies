package com.muco.dao;

import java.util.List;

import com.muco.entity.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QuestionDao
{
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void saveQuestion(Question q) {
        Session session = sessionFactory.getCurrentSession();
        session.save(q);
    }

    @Transactional
    public List<Question> getQuestions() {

        Session session = sessionFactory.getCurrentSession();
        // not sql... it is Hql
        Query<Question> q = session.createQuery("from Question", Question.class);
        List<Question> questions = q.list();

        return questions;
    }

    @Transactional
    public List<Question> getTestQuestions() {

        Session session = sessionFactory.getCurrentSession();
        NativeQuery<Question> query = session.createNativeQuery("select * from question order by rand() limit 3", Question.class);
        List<Question> questions = query.list();
        return questions;
    }
}
