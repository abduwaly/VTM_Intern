package aboo.bean;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by admin on 2017/5/9.
 */
@Entity
@Table(name = "tab_user")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String empNo;
    private String empName;

    public User() {
    }

    public User(String empNo, String empName) {
        this.empNo = empNo;
        this.empName = empName;
    }

    public String getEmpNo() {
        return empNo;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }

    public void setEmpNo(String empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }
}
