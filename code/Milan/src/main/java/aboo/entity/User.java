package aboo.entity;


/**
 *
 * ----------------数据模型-----------------------------------------------
 *
 *     用户 = 工号+姓名+帐号+部门+联系电话+电子邮箱+密码
 *
 *     User {empNo,empName,accountNo,department,tel,email,password }
 *
 * ----------------------------------------------------------------------
 *
 *
 * Created by admin on 2017/5/5.
 */

public class User {

    private String empNo;
    private String empName;
    private String accountNo;
    private String department;
    private String tel;
    private String email;
    private String password;

    public User(String empNo, String empName, String accountNo, String department, String tel, String email, String password) {
        this.empNo = empNo;
        this.empName = empName;
        this.accountNo = accountNo;
        this.department = department;
        this.tel = tel;
        this.email = email;
        this.password = password;
    }

    public User(){}

    public String getEmpNo() {
        return empNo;
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

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "empNo='" + empNo + '\'' +
                ", empName='" + empName + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", department='" + department + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
