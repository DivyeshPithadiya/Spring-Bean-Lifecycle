package com.spring.SpringBeanLifecycle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	
	
    public static void main( String[] args ) throws ClassNotFoundException, SQLException {
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    	ApplicationDao dao = context.getBean(ApplicationDao.class);
    	dao.getStudentDetails();
    	dao.deleteStudent(3);
    	
    	((AbstractApplicationContext)context).close();
    }
}
