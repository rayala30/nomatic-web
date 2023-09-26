package com.rayala30.nomatic.client.matchmaker.service;


import com.rayala30.nomatic.server.dao.AthleteDao;
import com.rayala30.nomatic.server.model.athlete.Athlete;
import org.springframework.security.access.AccessDeniedException;

import java.util.List;

/**
 * The AthleteService is a class for handling the business logic around creating, reading,
 * updating, and deleting Athlete.
 *
 * It depends on DAOs for retrieving and storing data: AthleteDao.
 * Instances of each of those DAOs are provided via dependency injection.
 */

//@Component
public class AthleteService {
    // Instantiate DAO interfaces
    private AthleteDao athleteDao;

    // Constructor
    public AthleteService(AthleteDao athleteDao) {
        this.athleteDao = athleteDao;
    }

    public AthleteService() {}


    /**
     * Gets all athletes in datastore.
     *
     * @return list of all athletes
     */
    public List<Athlete> getAllAthletes() {
        return athleteDao.getAthletes();
    }


    /**
     * Get athlete public info by id.
     * The Athlete public info would be: name, gender, weight, affiliation.
     * Match record can be private if needed
     *
     *
     * @param userId
     * @return Athlete associated with user Id
     */
    public Athlete getAthleteById(int userId) {
        return athleteDao.getAthleteById(userId);
    }

    /**
     *
     * @param userId athlete Id
     * @param allowPublicAccess if user allows public access to their win records
     * @return athlete match records
     * @throws AccessDeniedException
     */
    public Athlete getAthleteMatchRecords(int userId, boolean allowPublicAccess) throws AccessDeniedException {
        Athlete athlete = null;
        if (allowPublicAccess) {
            athlete = athleteDao.getAthleteTotalWinLossRecord(userId);
        } else {
            throw new AccessDeniedException("Access denied.");
        }
        return athlete;
    }

}
