package aboo.service;

import aboo.bean.User;
import aboo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 */
@Service
public class UserServiceImpl implements UserService {

//    @Resource(name = "userRepository")
    @Autowired
    @Qualifier("userRepository")
    private UserRepository ur ;


    @Transactional
    public User create_account(String empNo,String empName){
        if(!ur.exist(empNo)){

            log.debug("Account Created Successfully!");

            return ur.save(new User(empNo,empName));
        }
            log.debug("Sorry! This empNo has been occupied!");
        return null;
    }


}
