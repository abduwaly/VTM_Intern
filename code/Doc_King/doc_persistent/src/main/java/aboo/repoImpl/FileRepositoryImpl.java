package aboo.repoImpl;

import aboo.bean.FileInfo;
import aboo.repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * {@link FileRepository}的实现类
 * Created by admin on 2017/5/16.
 *
 * @author Aboo
 */
@Repository
public class FileRepositoryImpl extends SimpleJpaRepository<FileInfo,Long> implements FileRepository{

    private EntityManager em;

    @Autowired
    public FileRepositoryImpl(EntityManager em) {
        super(FileInfo.class,em);
        this.em=em;
    }

    /**
     * @see FileRepository#deleteByName(String)
     */
    @Override
    public void deleteByName(String filename) {
        em.createQuery("delete from FileInfo f where f.file_name='"+filename+"'").executeUpdate();

    }

    /**
     * @see FileRepository#findByFilename(String)
     */
    @Override
    public FileInfo findByFilename(String filename) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.file_name='"+filename+"'");
        if(this.existFile(filename)) {
            return (FileInfo) q.getSingleResult();
        }
        return null;
    }

    /**
     * @see FileRepository#findByLastModified(long)
     */
    @Override
    public List<FileInfo> findByLastModified(long lastmodtime) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.last_modified='"+lastmodtime+"'");
        return q.getResultList();
    }

    /**
     * @see FileRepository#findByExtension(String)
     */
    @Override
    public List<FileInfo> findByExtension(String extension) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.extension='"+extension+"'");
        return q.getResultList();
    }

    /**
     * @see FileRepository#findByLen(long)
     */
    @Override
    public List<FileInfo> findByLen(long len) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.length='"+len+"'");
        return q.getResultList();
    }

    /**
     * @see FileRepository#existFile(String)
     */
    @Override
    public boolean existFile(String filename) {
        Query q = em.createQuery("SELECT count(f) FROM FileInfo f WHERE f.file_name='"+filename+"'");
        String count = q.getResultList().get(0).toString();
        log.debug(count);
        return "0".equals(count)?false:true;
    }
}
