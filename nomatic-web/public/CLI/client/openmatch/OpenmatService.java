package com.rayala30.nomatic.client.openmatch;

/**
 * The OpenmatService is a class for handling the business logic around creating, reading,
 * updating, and deleting Openmats.
 *
 * It depends on two DAOs for retrieving and storing data: OpenmatDao and UserDao.
 * Instances of each of those DAOs are provided via dependency injection.
 */

//TODO

//@Component
public class OpenmatService {
//    // Instantiate DAO interfaces
//    private UserDao userDao;
//
//    private OpenmatDao openmatDao;
//
//    public OpenmatService(UserDao userDao, OpenmatDao openmatDao) {
//        this.userDao = userDao;
//        this.openmatDao = openmatDao;
//    }
//
//    //TODO openmats are retrieved by user, public, location, date, or filter
//
//
//    /**
//     * Gets all Openmats for specified user.
//     *
//     * Rules for Openmat access:
//     *      - Users with the "USER_ROLE" get only openmats associated to their user ID
//     *      - Users with the "ADMIN_ROLE" can get all openmats in datastore
//     *
//     * @param principal the Principal for the user
//     * @return the list of Openmats visible to that user
//     */
//    public List<Openmat> getOpenmatsFromUser(Principal principal) {
//        List <Openmat> openmatList = new ArrayList<>();
//
////        User user = getUser(principal);
////        if (user != null) {
////            if (user.getAuthorities().contains(Authority.ADMIN_AUTHORITY)) {
////                openmatList = openmatDao.getOpenmats();
////            } else {
////                openmatList = openmatDao.getOpenmatByUserId(user.getId());
////            }
////        }
//        return openmatList;
//    }
//
//
//    /**
//     * Gets all openmats marked as public. These are visible to any user.
//     *
//     * @return list of all public openmats
//     */
//    public List<Openmat> getAllPublicOpenmats() {
//        return openmatDao.getPublicOpenmats();
//    }
//
//    public Openmat getOpenmatById(int openmatId, Principal principal) throws AccessDeniedException {
//        Openmat openmat = null;
//
//        User user = getUser(principal);
//        if (user != null) {
//            // Access openmatDao to see if openmat with openmat ID exists
//            openmat = openmatDao.getOpenmatById(openmatId);
//            if (openmat != null) {
//                if ((openmat.getEventHostId() != user.getId()) && openmat.isPublic() == false) {
//                    throw new AccessDeniedException("Access denied.");
//                }
//            }
//        }
//        return openmat;
//    }
//
//
//    /**
//     * Adds a new openmat to the database. Currently sets blank openmat to event host.
//     * Other openmat parameters can be added after openmat is created
//     *
//     * Rules:
//     *      - One event host is required to add openmat into database
//     *
//     * @param newOpenmat the information for the new Openmat
//     * @param principal the Principal for event host
//     * @param isPublic if openmat is public or private
//     * @return the newly created openmat
//     */
//    public Openmat addOpenmat(Openmat newOpenmat, Principal principal, boolean isPublic) {
//        Openmat openmat = null;
//        // We need one user to assign a saved Openmat in the database
//        User user = getUser(principal);
//
//        // Check if user exists
//        if (user != null) {
//            newOpenmat.setEventHostId(user.getId());
//
//            openmat = openmatDao.createOpenmat(newOpenmat);
//            openmat.setPublic(isPublic);
//        }
//        return openmat;
//    }
//
//    /**
//     * This method allows updates to the match AFTER the openmat information has been populated.
//     *
//     * Rules:
//     *    - Only users associated with the openmat can update that specific match
//     *
//     * @param modifiedOpenmat
//     * @param principal
//     * @return the updated Match if found and updated or null otherwise
//     * @throws AccessDeniedException if user does not have required access
//     */
//    public Openmat updateOpenmat(Openmat modifiedOpenmat, Principal principal) throws  AccessDeniedException {
//        Openmat openmat = null;
//        // Verify openmat was created and currently exists in database
//        Openmat existingOpenmat = openmatDao.getOpenmatById(modifiedOpenmat.getOpenmatId());
//        if (existingOpenmat != null) {
//            // Check if user is associated with the openmat
//            User user = getUser(principal);
//            if (user != null) {
//                if (existingOpenmat.getEventHostId() == user.getId()) {
//                    // Allow update of everything except userId
//                    modifiedOpenmat.setEventHostId(existingOpenmat.getEventHostId());
//                    openmat = openmatDao.updateOpenmat(modifiedOpenmat);
//                }
//                else {
//                    throw new AccessDeniedException("Access denied.");
//                }
//            }
//        }
//        // If existing openmat does not exist, openma will return null
//        return openmat;
//    }
//
//
//    /**
//     * Removes a single Openmat by id.
//     * Rules:
//     *    - Only users associated with Openmat may delete Openmats
//     *
//     * @param openmatId
//     * @param principal
//     * @return true if openmat is found and removed, false otherwise
//     * @throws AccessDeniedException if user does not have required access
//     */
//    public boolean removeOpenmat(int openmatId, Principal principal) throws AccessDeniedException {
//        boolean openmatRemoved = false;
//
//        Openmat openmat = openmatDao.getOpenmatById(openmatId);
//        if (openmat != null) {
//            User user = getUser(principal);
//            if (user != null) {
//                if (openmat.getEventHostId() == user.getId()) {
//                    int deleteCount = openmatDao.deleteOpenmatById(openmatId);
//                    openmatRemoved = (deleteCount !=0);
//                }
//                else {
//                    throw new AccessDeniedException("Access denied.");
//                }
//            }
//        }
//
//        return openmatRemoved;
//    }
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
