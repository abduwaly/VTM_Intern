package aboo.repo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * 所有Repository类的基类
 * Created by admin on 2017/5/10.
 *
 * @author Aboo
 *
 * @param <T> the type of the entity to handle
 * @param <ID> the type of the entity's identifier
 *
 *
 * 注：在BaseRepository上添加该 {@link NoRepositoryBean}，这样SpringDataJpa在启动时就不会去实例化BaseRepository这个接口
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {

    Logger log = LoggerFactory.getLogger(BaseRepository.class);
}
