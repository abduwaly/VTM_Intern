package aboo.test;

import aboo.bean.User;
import aboo.repo.UserRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;


/**
 */
public class SimpleSpringJpaDemo {
    public static void main(String[] args) {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:C:\\Users\\admin\\VTM_Folder\\Camp\\src\\main\\java\\application-context.xml");
//        System.out.println(ctx);
//        UserService userService = ctx.getBean("userService",UserService.class);
//        System.out.print(userService);
//        userService.createNewUser("22","kaka");


            test();

    }

    static void test(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("file:C:\\Users\\admin\\VTM_Folder\\Camp\\src\\main\\java\\application-context.xml");
        System.out.println(ctx);


        EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");
        System.out.println(emf+"---\n---em:"+emf.createEntityManager());

        UserRepository ur = ctx.getBean("UserRepo",UserRepository.class);

        System.out.println("user-repo:"+ur);

        //ur.delete(1L);
        System.out.println(ur.exists(1L));

        System.out.println(ur.save(new User("10","messi")));

        System.out.println(ur.findAll());

        System.out.println("---END----");



    }

}
