package aboo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by admin on 2017/5/10.
 */
//在BaseRepository上添加如下标注，这样SpringDataJpa在启动时就不会去实例化BaseRepository这个接口
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
