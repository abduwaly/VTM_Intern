package aboo.test;

import aboo.bean.FileInfo;
import aboo.repo.FileRepository;
import aboo.service.FileService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 */
public class SimpleSpringJpaDemo {
    public static void main(String[] args) {

            test_file();
    }

    private static void test_file() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("doc-persistent-application-context.xml");
        FileService fs = ctx.getBean("fileServiceImpl",FileService.class);
        System.out.println(fs.getClass());
        FileRepository fr = ctx.getBean("fileRepositoryImpl", FileRepository.class);
        fr.save(new FileInfo("all_logs",877689L,"doc",497676L));
        System.out.println(fr.findAll());

        System.out.println(fr.count());

    }





}
