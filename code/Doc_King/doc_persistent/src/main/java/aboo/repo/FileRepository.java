package aboo.repo;

import aboo.bean.FileInfo;

import java.util.List;

/**
 * Created by admin on 2017/5/16.
 */
public interface FileRepository extends BaseRepository<FileInfo,Long> {

    FileInfo findByFilename(String filename);

    List<FileInfo> findByLastModified(long lastmodtime);

    List<FileInfo> findByType(String type);

    List findByLen(long len);

    boolean existFile(String filename);

    void deleteByName(String filename);
}
