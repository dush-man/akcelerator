package net.croz.contacts.service.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.croz.contacts.dao.CodeDao;
import net.croz.contacts.model.code.AbstractCode;

import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
public class CodeServiceImpl<T extends AbstractCode> implements CodeService {
	private CodeDao hcd;
	private List<Class<T>> key;

	public CodeDao getHcd() {
		return hcd;
	}

	public void setHcd(CodeDao hcd) {
		this.hcd = hcd;
	}

	public List<Class<T>> getKey() {
		return key;
	}

	public void setKey(List<Class<T>> key) {
		this.key = key;
	}

	@Transactional
	public Map<Class<T>, List<T>> getCodes() {
		Map<Class<T>, List<T>> mapa = new HashMap<Class<T>, List<T>>();

		for (Class<T> c : key) {
			ArrayList<T> lista = (ArrayList<T>) hcd.fetchAll(c);
			mapa.put(c, lista);
		}

		return mapa;
	}

}
