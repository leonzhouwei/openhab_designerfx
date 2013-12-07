package org.openhab.designer.backend.queryservice;

import java.util.List;

import org.openhab.designer.backend.Item;

public interface ItemResourceQueryService {
	
	public List<String> listAllNames();
	
	public List<Item> getItems(String resourceName) ;
	
}
