package aboo.service;


import aboo.bean.FileInfo;

import java.util.List;

/**
 * Created by admin on 2017/5/15.
 *
 * @author Aboo
 *
 */
public interface FileService extends BaseService {

    /**
     * 显示所有的文件信息
     * @return {@link FileInfo}的List
     */
    List<FileInfo> showAll();

    FileInfo findByFilename(String filename);

    List<FileInfo> findByLastModified(long lastmodtime);

    List<FileInfo> findByExtension(String extension);

    List<FileInfo> findByLen(long len);

    /**
     * 保存文件信息
     * @param originalName
     * @param extension
     * @param mime_type
     * @param lastmodtime
     * @param len
     * @return 如果文件保存成功，返回该FileInfo
     */
    FileInfo saveInfo(String originalName,String extension, String mime_type,long lastmodtime, long len);

    /**
     * 根据文件名匹配文件并删除该文件
     * @param filename
     */
    void deleteByName(String filename);

    /**
     * 根据文件名判断该文件是否存在
     * @param filename
     * @return 若存在，返回true
     */
    boolean existFile(String filename);

    /**
     * 根据id判断文件是否存在
     * @param id
     * @return 若存在，返回true
     */
    boolean exists(Long id);

    FileInfo findById(Long id);

}
