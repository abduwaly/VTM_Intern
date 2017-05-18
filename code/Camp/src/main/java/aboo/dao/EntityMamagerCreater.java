package aboo.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Created by admin on 2017/5/15.
 */
public class EntityMamagerCreater {

    static ApplicationContext ctx = new ClassPathXmlApplicationContext("file:C:\\Users\\admin\\VTM_Folder\\Camp\\src\\main\\java\\application-context.xml");
    static EntityManagerFactory emf = (EntityManagerFactory) ctx.getBean("entityManagerFactory");

    public static EntityManager get(){

        return emf.createEntityManager();
    }

}
