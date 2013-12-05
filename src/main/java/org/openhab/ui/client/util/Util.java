package org.openhab.ui.client.util;

import java.io.File;

import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Stage;

import org.openhab.ui.client.common.Define;

public class Util {

	public static File getSelectedFolderInPopupWindow(String title,
			Stage primaryStage) {
		DirectoryChooserBuilder builder = DirectoryChooserBuilder.create();
		builder.title(title);
		String cwd = System.getProperty(Define.CURRENT_WORKING_DIR_PROP);
		File file = new File(cwd);
		builder.initialDirectory(file);
		DirectoryChooser chooser = builder.build();
		return chooser.showDialog(primaryStage);
	}
}
