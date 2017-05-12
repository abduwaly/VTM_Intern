package aboo.repoImpl;

import aboo.bean.User;
import aboo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by admin on 2017/5/11.
 */
@Repository("UserRepo")
public class UserRepositoryImpl extends SimpleJpaRepository<User,Long> implements UserRepository {


    private EntityManager em;

    @Autowired
    public UserRepositoryImpl(EntityManager em) {
        super(User.class,em);
        this.em=em;
    }


}
