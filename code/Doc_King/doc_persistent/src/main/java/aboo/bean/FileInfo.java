package aboo.bean;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/5/9.
 */
@Entity
@Table(name = "tab_file")
public class FileInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String file_name;
    private long last_modified;
    private String type;
    private long length;

    public FileInfo() {

    }

    public FileInfo(String file_name, long last_modified, String type, long length) {
        this.file_name = file_name;
        this.last_modified = last_modified;
        this.type = type;
        this.length = length;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
                ", type='" + type + '\'' +
                ", length=" + length +
                '}';
    }
}
