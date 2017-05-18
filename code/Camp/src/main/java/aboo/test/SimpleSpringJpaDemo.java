package aboo.test;

import aboo.bean.User;
import aboo.repo.BaseRepository;
import aboo.repo.UserRepository;
import aboo.service.BaseService;
import aboo.service.UserService;
import aboo.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/**
 */
public class SimpleSpringJpaDemo {
    public static void main(String[] args) {



            test();

    }



    static void test(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");

        UserService userService = ctx.getBean("userServiceImpl",UserService.class);

        userService.create_account("456","flashman");

    }

}
