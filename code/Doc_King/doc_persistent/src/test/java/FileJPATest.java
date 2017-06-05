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

        System.out.println(fs.findByExtension("txt"));
        FileRepository fr = ctx.getBean("fileRepositoryImpl", FileRepository.class);

        String originalName = "a.flsfd";
        String extension=null;
        String mime_type=null;
        String[] s = originalName.split("\\.");
        if(s.length >1){
            extension = originalName.substring(originalName.lastIndexOf(".")+1);
            mime_type = extension;
        }
        fs.saveInfo(originalName,extension,mime_type,System.currentTimeMillis(),8979);

        System.out.println(s.length+","+extension+","+mime_type);



    }

}
