package net.croz.contacts.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ServiceInvocationAdvice {

	long pocetnoVreme;
	long zavrsnoVreme;
	Logger LOGGER;

	@Before("within(net.croz.contacts.service.contactbook.ContactBookServiceImpl)")
	public void pocetakMerenja() {
		pocetnoVreme = System.currentTimeMillis();
	}

	@After("within(net.croz.contacts.service.contactbook.ContactBookServiceImpl)")
	public void krajMerenja(JoinPoint jp) {
		zavrsnoVreme = System.currentTimeMillis();
		long duration = zavrsnoVreme - pocetnoVreme;
		LOGGER = LoggerFactory.getLogger(jp.getTarget().getClass());
		LOGGER.info("Method "
				+ MethodSignature.class.cast(jp.getSignature()).getMethod()
						.getName() + " of interface "
				+ jp.getTarget().getClass().getInterfaces()[0].getSimpleName()
				+ " executed in " + duration + " ms");
	}

}
