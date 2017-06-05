package aboo.service;

import aboo.bean.FileInfo;
import aboo.repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * {@link FileService}的实现类
 *
 */
@Service
public class FileServiceImpl implements FileService {


    @Autowired
    @Qualifier("fileRepository")
    private FileRepository fr ;


    /**
     * @see FileService#deleteByName(String)
     */
    @Override
    public void deleteByName(String filename) {
        if(fr.existFile(filename)){
            fr.deleteByName(filename);
        }

    }

    /**
     * @see FileService#showAll()
     */
    @Override
    public List<FileInfo> showAll() {
        return fr.findAll();
    }

    @Override
    public FileInfo findByFilename(String filename) {
        log.debug(filename);
        return fr.findByFilename(filename);
    }

    @Override
    public List<FileInfo> findByLastModified(long lastmodtime) {
        return fr.findByLastModified(lastmodtime);
    }

    @Override
    public List<FileInfo> findByExtension(String extension) {
        return fr.findByExtension(extension);
    }

    /**
     * @see FileService#saveInfo(String, String, String, long, long)
     */
    @Override
    public FileInfo saveInfo(String originalName,String extension, String mime_type,long lastmodtime, long len) {
        FileInfo fileInfo = new FileInfo(originalName,lastmodtime,extension,len,mime_type);
        return fr.save(fileInfo);
    }

    @Override
    public List<FileInfo> findByLen(long len) {
        return fr.findByLen(len);
    }

    /**
     * @see FileService#existFile(String)
     */
    @Override
    public boolean existFile(String filename) {
        return fr.existFile(filename);
    }

    /**
     * @see FileService#exists(Long)
     */
    @Override
    public boolean exists(Long id) {
        return fr.exists(id);
    }

    @Override
    public FileInfo findById(Long id) {
        return fr.findOne(id);
    }
}
