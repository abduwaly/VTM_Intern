package aboo.service;


import aboo.bean.FileInfo;

import java.util.List;

/**
 *
 */

public interface FileService extends BaseService {

    List<FileInfo> showAll();

    FileInfo findByFilename(String filename);

    List<FileInfo> findByLastModified(long lastmodtime);

    List<FileInfo> findByType(String type);

    List<FileInfo> findByLen(long len);

    FileInfo saveInfo(String originalName,long lastmodtime,long len);

    boolean existFile(String filename);

    void deleteByName(String filename);

}
