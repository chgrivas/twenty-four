package com.twentyfour.persistence.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaQuery;

import org.eclipse.persistence.exceptions.DatabaseException;

import com.twentyfour.model.Properties;
import com.twentyfour.model.enums.Role;
import com.twentyfour.persistence.utils.TwentyFourConstants;
import com.twentyfour.service.DatabaseService;
import com.vaadin.addon.jpacontainer.JPAContainerFactory;

public class DatabaseServiceImpl implements DatabaseService {

    EntityManager em = JPAContainerFactory.createEntityManagerForPersistenceUnit(TwentyFourConstants.PERSISTENCE_UNIT);

    @Override
    public void init() {
        if (isInitiated()) {
            System.out.println("The database is already initiated.");
            return;
        }

        System.out.println("Initiating database for the first time.");

        addUsers();
        markAsInitiated();
    }

    private boolean isInitiated() {
        boolean initiated = false;

        CriteriaQuery<Properties> query = em.getCriteriaBuilder().createQuery(Properties.class);
        List<Properties> propertiesList = em.createQuery(query.select(query.from(Properties.class))).getResultList();

        for (Properties properties : propertiesList) {
            if (properties.getDb().toString().equals("basic") && properties.getState().toString().equals("Initiated")) {

                initiated = true;
            }
        }

        return initiated;
    }

    private void addUsers() {
        UserServiceImpl service = new UserServiceImpl();

        service.addUser("chgri", "Chris", "Grivas", Role.ADMIN);

    }

    private void markAsInitiated() {
        Properties twentyFourDatabaseState = new Properties();
        twentyFourDatabaseState.setDb("basic");
        twentyFourDatabaseState.setState("Initiated");

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(twentyFourDatabaseState);
        tx.commit();
    }

}
