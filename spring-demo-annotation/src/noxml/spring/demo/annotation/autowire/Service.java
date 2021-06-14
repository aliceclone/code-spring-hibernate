package noxml.spring.demo.annotation.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {

    // private IClass a;
    // Error creating bean with name 'service':
    // Unsatisfied dependency expressed through field 'a';
    // nested exception is
    // org.springframework.beans.factory.NoUniqueBeanDefinitionException:
    // No qualifying bean of type 'noxml.spring.demo.annotation.autowire.IClass'
    // available: expected single matching bean but found 2: classA,classB
    // Exception in thread "main"
    // org.springframework.beans.factory.UnsatisfiedDependencyException: Error
    // creating bean with name 'service': Unsatisfied dependency expressed through
    // field 'a'; nested exception

    // solve: @Qualifier("classB") private IClass a;
    // >>> even variable is [a] ClassB invoke

    // private ClassB iClass; still work

    @Autowired
    private IClass classA;

    public void doSomething() {
	classA.doSomething();
    }

}
