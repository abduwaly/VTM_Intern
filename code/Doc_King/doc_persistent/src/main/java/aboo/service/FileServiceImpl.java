package aboo.service;

import aboo.bean.FileInfo;
import aboo.repo.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    @Qualifier("fileRepository")
    private FileRepository fr ;

    @Override
    public List<FileInfo> showAll() {

        return fr.findAll();
    }

    @Override
    public FileInfo findByFilename(String filename) {
        return fr.findByFilename(filename);
    }

    @Override
    public List<FileInfo> findByLastModified(long lastmodtime) {
        return fr.findByLastModified(lastmodtime);
    }

    @Override
    public List<FileInfo> findByType(String type) {
        return fr.findByType(type);
    }

    @Override
    public List<FileInfo> findByLen(long len) {
        return fr.findByLen(len);
    }
}
