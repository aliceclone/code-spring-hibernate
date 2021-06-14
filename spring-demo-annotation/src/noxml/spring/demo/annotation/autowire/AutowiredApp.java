package noxml.spring.demo.annotation.autowire;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredApp {

    public static void main(String[] args) {

	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfig.class);

	Service bean = context.getBean(Service.class);
	bean.doSomething();

	// close
	context.close();

    }

}
