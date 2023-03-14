package com.crio.qcontest.services;

 import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.management.RuntimeErrorException;
import com.crio.qcontest.constants.UserOrder;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.IUserRepository;

public class UserService{

    private static final UserOrder SCORE_ASC = null;
    private static final UserOrder SCORE_DESC = null;
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        User.autoIncrementUserId = 1L;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of createUser method
    // Implementation must take care of the following cases:-
    // 1) Create and store user in the repository.

    public User createUser(String name) {
        // if(name == null)
        //     throw new RuntimeErrorException(null, "UserName not given");
        User user = new User(name);
        userRepository.save(user);
        
        return user;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Complete the implementation of getAllUser method
    // Implementation must take care of the following cases:-
    // 1) Get all the users in ascending Order w.r.t score.
    // 2) Get all the users in descending Order w.r.t score.

    public List<User> getUsers(UserOrder userOrder) {
      List<User> userList ;
      if(userOrder == UserOrder.SCORE_ASC)
      {
        userList = userRepository.findAll();
        Collections.sort(userList, (a,b)-> a.getTotalScore()-b.getTotalScore());
        return userList;
      }
   
        userList = userRepository.findAll();
        Collections.sort(userList, (a,b)-> b.getTotalScore()-a.getTotalScore());
        return userList;
      
    } 
}
