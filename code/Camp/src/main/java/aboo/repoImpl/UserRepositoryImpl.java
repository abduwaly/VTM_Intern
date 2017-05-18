package aboo.repoImpl;

import aboo.bean.User;
import aboo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Random;

/**
 * Created by admin on 2017/5/11.
 */
@Repository
public class UserRepositoryImpl extends SimpleJpaRepository<User,Long> implements UserRepository {


    private EntityManager em;

    @Autowired
    public UserRepositoryImpl(EntityManager em) {
        super(User.class,em);
        this.em=em;
    }

    //需要注意的是：[From + 类名User]  (它会自动匹配到表tab_user)
    public boolean exist(String empNo){
        Query q = em.createQuery("SELECT count(id) FROM User WHERE empNo='"+empNo+"'");
        String count =  q.getResultList().get(0).toString();

        log.debug("count:"+count);

        return (!"0".equals(count)) ? true : false;
    }


}
