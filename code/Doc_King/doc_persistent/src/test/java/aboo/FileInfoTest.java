package aboo;

import aboo.bean.FileInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by admin on 2017/5/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:doc-persistent-application-context.xml")
public class FileInfoTest {

    @Test
    public void testConstructor(){
        FileInfo f = new FileInfo("test.txt",System.currentTimeMillis(),"txt",123,"text/plain");
        f.toString();
    }

    @Test
    public void testGetterSetter(){
        FileInfo f = new FileInfo();
        f.setFile_name("test.txt");
        f.setExtension("txt");
        f.setLast_modified(System.currentTimeMillis());
        f.setMime_type("text/plain");
        f.setLength(789);
        System.out.println(""+f.getFile_name()+f.getExtension()+f.getMime_type()+f.getId()+f.getLast_modified()+f.getLength());
    }

}
