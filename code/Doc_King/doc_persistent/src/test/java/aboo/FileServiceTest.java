package aboo;

import aboo.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by admin on 2017/5/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:doc-persistent-application-context.xml")
public class FileServiceTest {

    @Autowired
    FileService fs;

    @Test
    public void testFind(){
        fs.showAll();
        System.out.println(fs.findByFilename("man"));
        System.out.println(fs.findByFilename("foe.doc"));

        fs.findByFilename("man");
        fs.findById(93L);
        fs.findByExtension("txt");
        fs.findByLastModified(587343567L);
        fs.findByLen(15);
    }

    @Test
    @Transactional
    public void testDelete(){
        fs.deleteByName("man");
    }

    @Test
    public void testExists(){
        fs.existFile("man");
        fs.exists(88L);
    }

    @Test
    @Transactional
    public void testSave(){
        fs.saveInfo("test.txt","txt","text/plain",System.currentTimeMillis(),98L);
    }

}
