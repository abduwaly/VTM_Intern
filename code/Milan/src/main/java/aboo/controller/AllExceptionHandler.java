package aboo.controller;

import aboo.entity.ExAndErr;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by admin on 2017/5/8.
 */
@ControllerAdvice
public class AllExceptionHandler {

    private Logger log = LoggerFactory.getLogger(AllExceptionHandler.class);


    @ExceptionHandler(SystemException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExAndErr err_500(SystemException ex) {

        log.debug("----------------500--------------------");
        return new ExAndErr(HttpStatus.INTERNAL_SERVER_ERROR.value(),ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    public ExAndErr err_415(Exception ex){

        Integer code = HttpStatus.UNSUPPORTED_MEDIA_TYPE.value();
        String msg = ex.getMessage();

        log.debug("--------------415---------");
        log.debug(">>>"+code+"======"+HttpStatus.UNSUPPORTED_MEDIA_TYPE.getReasonPhrase()+"======"+msg+"<<<");

        return new ExAndErr(code,msg);
    }

//    @ExceptionHandler(SystemException.class)
//    @ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
//    @ResponseBody
//    public ExAndErr err_405(SystemException ex){
//
//        Integer code = HttpStatus.METHOD_NOT_ALLOWED.value();
//        String msg = ex.getMessage();
//
//        log.debug("--------------405---------");
//        log.debug(">>>"+code+"======"+HttpStatus.METHOD_NOT_ALLOWED.getReasonPhrase()+"======"+msg+"<<<");
//
//        return new ExAndErr(code,msg);
//    }

}
