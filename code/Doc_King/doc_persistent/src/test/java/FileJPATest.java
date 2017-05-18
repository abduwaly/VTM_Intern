import aboo.bean.FileInfo;
import aboo.repo.FileRepository;
import aboo.service.FileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by admin on 2017/5/16.
 */
public class FileJPATest {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("doc-persistent-application-context.xml");
        FileService fs = ctx.getBean("fileServiceImpl",FileService.class);
//        System.out.println(fs.getClass());
//        FileRepository fr = ctx.getBean("fileRepositoryImpl", FileRepository.class);
//        fr.save(new FileInfo("all_logs",877689L,"doc",497676L));


        fs.deleteByName("huige");


    }

}
