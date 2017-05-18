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
    public boolean existFile(String filename) {

        return fr.existFile(filename);
    }

    @Override
    public void deleteByName(String filename) {
        if(fr.existFile(filename)){
            fr.deleteByName(filename);
        }

    }

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
    public FileInfo saveInfo(String originalName, long lastmodtime, long len) {

        String type = originalName.substring(originalName.lastIndexOf(".")+1);
        FileInfo fileInfo = new FileInfo(originalName,lastmodtime,type,len);
        fr.save(fileInfo);
        return fileInfo;
    }

    @Override
    public List<FileInfo> findByLen(long len) {
        return fr.findByLen(len);
    }
}
