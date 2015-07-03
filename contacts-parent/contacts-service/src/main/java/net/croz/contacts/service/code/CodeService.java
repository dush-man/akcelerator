package net.croz.contacts.service.code;

import java.util.List;
import java.util.Map;

import net.croz.contacts.model.code.AbstractCode;

public interface CodeService {
	public <T extends AbstractCode> Map<Class<T>, List<T>> getCodes();
}
