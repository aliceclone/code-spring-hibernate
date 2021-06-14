package noxml.spring.demo.annotation.autowire;

import org.springframework.stereotype.Component;

@Component
public class ClassA implements IClass {

    @Override
    public void doSomething() {
	System.out.println(getClass().getSimpleName());
    }

}
