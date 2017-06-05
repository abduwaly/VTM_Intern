package aboo.bean;



import javax.persistence.*;
import java.io.Serializable;

/**
 * 文件信息的实体类，与数据库表tab_file对应
 * Created by admin on 2017/5/9.
 * @author Aboo
 * @see java.io.Serializable
 *
 */
@Entity
@Table(name = "tab_file")
public class FileInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;    //自增id

    private String file_name;
    private long last_modified;
    private String extension;
    private long length;
    private String mime_type;

    public FileInfo() {
    }

    /**
     * FileInfo的带参构造器，由于id为自动生成的类型，在此不接受此参数
     *
     * @param file_name 文件名
     * @param last_modified 最后修改时间
     * @param extension 文件扩展名
     * @param length 文件长度（单位：byte）
     * @param mime_type 文件的Mime类型
     */
    public FileInfo(String file_name, long last_modified, String extension, long length, String mime_type) {
        this.file_name = file_name;
        this.last_modified = last_modified;
        this.extension = extension;
        this.length = length;
        this.mime_type = mime_type;
    }

    public Long getId() {
        return id;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public long getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(long last_modified) {
        this.last_modified = last_modified;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "id=" + id +
                ", file_name='" + file_name + '\'' +
                ", last_modified=" + last_modified +
                ", extension='" + extension + '\'' +
                ", length=" + length +
                ", mime_type='" + mime_type + '\'' +
                '}';
    }
}
