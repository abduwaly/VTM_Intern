//package aboo.service;
//
//import aboo.bean.User;
//import aboo.dao.UserDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
///**
// */
//@Service("userService")
//public class UserServiceImpl implements UserService {
//
//    @Autowired
//    private UserDao userDao;
//
//
//    @Transactional
//    public User createNewUser(String empNo,String empName) {
//
//        User user = new User(empNo,empName);
//
//        return userDao.save(user);
//    }
//
//
//}
