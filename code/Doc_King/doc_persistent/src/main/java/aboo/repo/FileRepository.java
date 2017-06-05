package aboo.repo;

import aboo.bean.FileInfo;

import java.util.List;

/**
 * FileInfo的Repository接口，继承自 {@link BaseRepository}接口
 *
 * Created by admin on 2017/5/16.
 *
 * @author Aboo
 */
public interface FileRepository extends BaseRepository<FileInfo,Long> {

    /**
     * 根据文件名匹配文件并返回其信息
     * @param filename
     * @return {@link FileInfo}
     */
    FileInfo findByFilename(String filename);

    /**
     * 根据最后修改时间匹配并返回文件信息
     * @param lastmodtime
     * @return {@link FileInfo}的List
     */
    List<FileInfo> findByLastModified(long lastmodtime);

    /**
     * 根据文件扩展名匹配并返回文件信息
     * @param extension
     * @return {@link FileInfo}的List
     */
    List<FileInfo> findByExtension(String extension);

    /**
     * 根据文件长度返回文件信息
     * @param len 文件长度
     * @return {@link FileInfo}的List
     */
    List<FileInfo> findByLen(long len);

    /**
     * 根据文件名filename来判断该文件是否存在
     * @param filename
     * @return 若存在，返回true;否则，返回false
     */
    boolean existFile(String filename);

    /**
     * 根据文件名filename删除文件
     * @param filename
     */
    void deleteByName(String filename);
}
