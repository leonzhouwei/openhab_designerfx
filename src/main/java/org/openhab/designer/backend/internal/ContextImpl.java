package org.openhab.designer.backend.internal;

import org.openhab.designer.backend.Context;
import org.springframework.stereotype.Component;

@Component
public class ContextImpl implements Context {

	private String openHABHome;

	public String getOpenHABHome() {
		synchronized (this) {
			return openHABHome;
		}
	}

	public void setOpenHABHome(String path) {
		synchronized (this) {
			openHABHome = path;
		}
	}

}
