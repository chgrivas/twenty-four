package com.twentyfour.persistence.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import com.twentyfour.model.User;
import com.twentyfour.model.enums.Role;
import com.twentyfour.persistence.utils.TwentyFourConstants;
import com.twentyfour.service.UserService;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class UserServiceImpl implements UserService {
    
    EntityManager em = JPAContainerFactory
            .createEntityManagerForPersistenceUnit(TwentyFourConstants.PERSISTENCE_UNIT);
    
    @Override
    public User getUser(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public List<User> getUsers() {
        CriteriaQuery<User> query = em.getCriteriaBuilder().createQuery(User.class);
        return em.createQuery(query.select(query.from(User.class))).getResultList();
    }

    @Override
    public Long addUser(String userName, String firstName, String lastName, Role role) {
        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setRole(role);
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(newUser);
        tx.commit();
        
        
        return newUser.getId();
    }
}
