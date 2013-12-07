package org.openhab.designer.backend.internal.queryservice;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.openhab.designer.backend.Context;
import org.openhab.designer.backend.Item;
import org.openhab.designer.backend.internal.common.Constants;
import org.openhab.designer.backend.internal.util.Util;
import org.openhab.designer.backend.queryservice.ItemResourceQueryService;
import org.openhab.designerfx.common.Config;
import org.springframework.stereotype.Component;

@Component
public class ItemResourceQueryServiceImpl implements ItemResourceQueryService {
	
	@Resource
	private Context context;
	
	@Override
	public List<String> listAllNames() {
		File dir = new File(context.getOpenHABHome() + Constants.FILE_SEPARATOR + Config.getItemsDirBaseName());
		if (!dir.exists() || !dir.isDirectory()) {
			return new ArrayList<String>();
		}
		List<File> files = Util.listRegularFileNames(dir, Constants.ITEMS_FILE_EXTENSION);
		List<String> names = Util.baseNames(files, Constants.ITEMS_FILE_EXTENSION);
		return names;
	}

	@Override
	public List<Item> getItems(String resourceName) {
		File file = new File(context.getOpenHABHome() + Constants.FILE_SEPARATOR + Config.getItemsDirBaseName() + Constants.FILE_SEPARATOR + resourceName);
		if (!file.exists() || !file.isFile()) {
			return null;
		}
		try {
			Util.readAll(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
