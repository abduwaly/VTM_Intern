package aboo.repo;

import aboo.bean.User;
import aboo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by admin on 2017/5/11.
 */
public interface UserRepository extends BaseRepository<User, Long> {

    boolean exist(String empNo);

}
