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
 * Created by admin on 2017/5/16.
 */
@Repository
public class FileRepositoryImpl extends SimpleJpaRepository<FileInfo,Long> implements FileRepository{

    private EntityManager em;

    @Autowired
    public FileRepositoryImpl(EntityManager em) {
        super(FileInfo.class,em);
        this.em=em;
    }

    @Override
    public FileInfo findByFilename(String filename) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.file_name='"+filename+"'");
        return (FileInfo) q.getSingleResult();
    }

    @Override
    public List<FileInfo> findByLastModified(long lastmodtime) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.last_modified='"+lastmodtime+"'");
        return q.getResultList();
    }

    @Override
    public List<FileInfo> findByType(String type) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.type='"+type+"'");
        return q.getResultList();
    }

    @Override
    public List<FileInfo> findByLen(long len) {
        Query q = em.createQuery("SELECT f FROM FileInfo f WHERE f.length='"+len+"'");
        return q.getResultList();
    }
}