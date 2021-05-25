package noxml.spring.demo.annotation.bean;

import com.spring.demo.annotation.FortuneService;

//@Component NO Need
public class BadFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "[BadFortuneService] OMG!";
	}

}
