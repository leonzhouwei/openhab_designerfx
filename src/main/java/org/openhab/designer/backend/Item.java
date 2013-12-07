package org.openhab.designer.backend;

import java.util.List;

public interface Item {

	public String getType();

	public String getName();
	
	public String getLabelText();
	
	public String getIconName();
	
	public List<String> getGroups();
	
	public String getBindingConfig();
	
}
