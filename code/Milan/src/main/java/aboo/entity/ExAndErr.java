package aboo.entity;

/**
 * "status": 404,
 "code": 40483,
 "message": "Oops! It looks like that file does not exist.",
 "developerMessage": "File resource for path /uploads/foobar.txt does not exist.  Please wait 10 minutes until the upload batch completes before checking again.",
 "moreInfo": "http://www.mycompany.com/errors/40483"

 *
 * Created by admin on 2017/5/8.
 */
public class ExAndErr {

    private Integer code;
    private String message;


    public ExAndErr() {}

    public ExAndErr(Integer code ,String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
