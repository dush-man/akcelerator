package net.croz.contacts.aspect;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import net.croz.contacts.service.exceptions.ServiceException;
import net.croz.contacts.service.exceptions.ServiceException.ErrorType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.util.ClassUtils;

@Aspect
public class ExceptionAdvice implements MessageSourceAware {
	
	private MessageSource messageSource;
	Logger log;
	private Map<ErrorType, List<Class<? extends Exception>>> errorTypes;

	@AfterThrowing(pointcut = "adviceContactBookService()", throwing = "e")
	public void handleException(JoinPoint jp, Throwable e) {
		log = LoggerFactory.getLogger(jp.getTarget().getClass());
		
		for (Entry<ErrorType, List<Class<? extends Exception>>> entry : this.getErrorTypes().entrySet()) {	
			for (Class<? extends Exception> th : entry.getValue()) {
				if (ClassUtils.isAssignableValue(th, e)) {
					log.error(jp.getTarget().getClass().getCanonicalName() + " baca gresku " + e.getMessage());
					throw new ServiceException(entry.getKey(), messageSource.getMessage(entry.getKey().toString(), null , null));
				}
			}
		}
	}

	@Pointcut(value = "within(net.croz.contacts.service.contactbook.ContactBookServiceImpl)")
	public void adviceContactBookService() {
	}

	public Map<ErrorType, List<Class<? extends Exception>>> getErrorTypes() {
		return errorTypes;
	}

	public void setErrorTypes(Map<ServiceException.ErrorType, List<Class<? extends Exception>>> errorTypes) {
		this.errorTypes = errorTypes;
	}

	public void setMessageSource(MessageSource messageSource) {
	
		this.messageSource=messageSource;
	}

}
