package service;

import constant.UserRole;
import entity.User;
import repository.UserRepo;

public class UserService {

    public String addUser(String userName, UserRole userRole) throws Exception {
        if(userRole == null){
            throw new Exception("User role does not exisr");
        }
        User user = new User(userName, userRole);
        UserRepo.userMap.put(userName, user);

        return "User successfully added";
    }


}
