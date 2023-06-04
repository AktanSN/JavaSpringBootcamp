package com.aktansanhal.homeworkweek2.service;


import com.aktansanhal.homeworkweek2.entity.User;
import com.aktansanhal.homeworkweek2.general.BaseEntityService;
import com.aktansanhal.homeworkweek2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends BaseEntityService<User, UserRepository> {
    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository repository) {
        super(repository);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void deleteByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);
        if(user != null)
            userRepository.delete(user);

    }

     public User update(User user, Long id){
        User user1 = userRepository.findById(id).orElseThrow();  //hata
        user1.setUsername(user.getUsername());
        user1.setPhoneNumber(user.getPhoneNumber());
        return userRepository.save(user1);

     }


}
