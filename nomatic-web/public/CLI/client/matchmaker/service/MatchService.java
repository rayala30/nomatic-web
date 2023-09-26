package com.rayala30.nomatic.client.matchmaker.service;

import com.rayala30.nomatic.server.model.Match;
import com.rayala30.nomatic.server.dao.*;
import com.rayala30.nomatic.server.user.User;
import org.springframework.stereotype.Component;

import java.nio.file.AccessDeniedException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


/**
 * The MatchService is a class for handling the business logic around creating, reading,
 * updating, and deleting Matches.
 *
 * It depends on three DAOs for retrieving and storing data: MatchDao and UserDao.
 * Instances of each of those DAOs are provided via dependency injection.
 */

//@Component
public class MatchService {
//    // Instantiate DAO interfaces
//    private MatchDao matchDao;
//    private UserDao userDao;
//
//    // Constructor
//    public MatchService(MatchDao matchDao, UserDao userDao) {
//        this.matchDao = matchDao;
//        this.userDao = userDao;
//    }
//
//    public MatchService() {}
//
//    /**
//     * Gets all Matches for specified user.
//     *
//     * Rules for Match access:
//     *      - Users with the "USER_ROLE" get only matches associated to their user ID
//     *      - Users with the "ADMIN_ROLE" can get all matches in datastore
//     *
//     * @param principal the Principal for the user
//     * @return the list of Matches visible to that user
//     */
//    public List<Match> getMatchesForAthleteUser(Principal principal) {
//        List<Match> matchList = new ArrayList<>();
//
//        User user = getUser(principal);
////        if (user != null) {
////            if (user.getAuthorities().contains(Authority.ADMIN_AUTHORITY)) {
////                matchList = matchDao.getMatches();
////            } else {
////                matchList = matchDao.getMatchesByAthleteId(user.getId());
////            }
////        }
//        return matchList;
//    }
//
//    /**
//     * Gets all matches marked as public. These are visible to any user.
//     *
//     * @return list of all public matches
//     */
//    public List<Match> getAllPublicMatches() {
//        return matchDao.getPublicMatches();
//    }
//
//
//    /**
//     * Gets all public Matches that are associated with a specific user.
//     *
//     * @param userId the id of the user to use for filtering
//     * @return List of all matching public matches
//     */
//    public List<Match> getPublicMatchesByUserId(int userId) {
//        return matchDao.getPublicMatchesByAthleteId(userId);
//    }
//
//
//    /**
//     * Gets a single Match by id.
//     * The Match must be public or associated to the user.
//     *
//     * @param matchId the id for the match
//     * @param principal the Principal for the user
//     * @return the match if found and accessible to the user, null otherwise
//     */
//    public Match getMatchById(int matchId, Principal principal) throws AccessDeniedException {
//        Match match = null;
//
//        User user = getUser(principal);
//        if (user != null) {
//            // Access matchDao to see if match with match ID exists
//            match = matchDao.getMatchById(matchId);
//            if (match != null) {
//                if ( ((match.getAthleteOneId() != user.getId()) || (match.getAthleteTwoId() != user.getId())) && match.isPublic() == false ) {
//                    throw new AccessDeniedException("Access denied.");
//                }
//            }
//        }
//        return match;
//    }
//
//    /**
//     * Gets all public Bookmarks that contain the filter string in either the title, description or associated tags.
//     *
//     * @param filterName string to use for filtering bookmarks
//     * @param startYear start year for search range
//     * @param endYear end year for search range
//     * @return List of all matching Matches
//     */
//    public List<Match> filterPublicMatches(String filterName, int startYear, int endYear) {
//        return matchDao.filterMatches(filterName, startYear, endYear, true, true);
//    }
//
//
//    /**
//     * Adds a new match to the database. The added match currently only assigns the two users.
//     * Other match parameters will be empty until updated from results of the match.
//     *
//     * Rules:
//     *      - Two users are required to add match into database
//     *
//     * @param newMatch the information for the new Match
//     * @param principalOne the Principal for user one
//     * @param principalTwo the Principal for user two
//     * @return the newly created match
//     */
//    public Match addMatch(Match newMatch, Principal principalOne, Principal principalTwo) {
//        Match match = null;
//        // We need two users to assign to a saved match in the database
//        User userOne = getUser(principalOne);
//        User userTwo = getUser(principalTwo);
//
//        // Check if both users exist.
//        if (userOne != null && userTwo != null) {
//            newMatch.setAthleteOneId(userOne.getId());
//            newMatch.setAthleteTwoId(userTwo.getId());
//
//            match = matchDao.createMatch(newMatch);
//        }
//        return match;
//    }
//
//
//    /**
//     * The purpose of this method is to immediately update a newly created match based on the Matchmaker results.
//     *
//     * @param modifiedMatch
//     * @return the updated Match if found and updated, or null otherwise
//     */
//    public Match updateBlankMatch(Match modifiedMatch) {
//        Match match = null;
//
//        // Verify match was created and currently exists in database
//        Match existingMatch = matchDao.getMatchById(modifiedMatch.getMatchId());
//        if (existingMatch != null) {
//            match = matchDao.updateMatch(modifiedMatch);
//        }
//        return match;
//    }
//
//
//    /**
//     * This method allows updates to the match AFTER the match information has been populated.
//     *
//     * Rules:
//     *    - Only users associated with the match can update that specific match
//     *
//     * @param modifiedMatch
//     * @param principal
//     * @return the updated Match if found and updated or null otherwise
//     * @throws AccessDeniedException if user does not have required access
//     */
//    public Match updateMatch(Match modifiedMatch, Principal principal) throws AccessDeniedException {
//        Match match = null;
//        // Verify match was created and currently exists in database
//        Match existingMatch = matchDao.getMatchById(modifiedMatch.getMatchId());
//        if (existingMatch != null) {
//            // Check if user is associated with the match
//            User user = getUser(principal);
//            if (user != null) {
//                if ((existingMatch.getAthleteOneId() == user.getId()) || (existingMatch.getAthleteTwoId() == user.getId())) {
//                    // Allow update of everything except userId
//                    modifiedMatch.setAthleteOneId(existingMatch.getAthleteOneId());
//                    modifiedMatch.setAthleteTwoId(existingMatch.getAthleteTwoId());
//                    match = matchDao.updateMatch(modifiedMatch);
//                }
//                else {
//                    throw new AccessDeniedException("Access denied.");
//                }
//            }
//        }
//        // If existing match does not exist, match will return null
//        return match;
//    }
//
//    /**
//     * Removes a single Match by id.
//     * Rules:
//     *    - Only users with the "ADMIN_ROLE" may delete Matches
//     *
//     * @param matchId
//     * @param principal
//     * @return true if match is found and removed, false otherwise
//     * @throws AccessDeniedException if user does not have required access
//     */
//    public boolean removeMatch(int matchId, Principal principal) throws AccessDeniedException {
//        boolean matchRemoved = false;
//
//        Match match = matchDao.getMatchById(matchId);
//        if (match != null) {
//            User user = getUser(principal);
//            if(user != null) {
//                if (isAdminUser(user)) {
//                    int deleteCount = matchDao.deleteMatchById(matchId);
//                    matchRemoved = (deleteCount != 0);
//                } else {
//                    throw new AccessDeniedException("Access denied");
//                }
//            }
//        }
//
//        return matchRemoved;
//    }
//
//
//    /*
//    Helper method to get the User object from Principal
//     */
//    private User getUser(Principal principal) {
//        String username = principal.getName();
//        User user = userDao.getUserByUsername(username);
//        return user;
//    }
//
//    /*
//    Helper method to check if a user is an Admin user
//     */
//    private boolean isAdminUser(User user) {
//        return false;
//    }
}
