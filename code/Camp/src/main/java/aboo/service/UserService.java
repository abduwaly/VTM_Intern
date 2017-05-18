package aboo.service;


import aboo.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 */

public interface UserService extends BaseService {


    User create_account(String empNo,String empName);

}
