package fr.unice.polytech.soa1.donato.redwarehouse.services.restimpl;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "unknown_resource")
class UnknownResource {
	private String type;
	private String key;

	public UnknownResource() {}

	public UnknownResource(String type, String key) {
		this.type = type;
		this.key = key;
	}

	@XmlElement(name = "kind")
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	@XmlElement(name = "key")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
