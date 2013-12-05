package org.openhab.designerfx.util;

import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.DirectoryChooserBuilder;
import javafx.stage.Stage;

import org.openhab.designerfx.common.Define;

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

	public static void setErrorMessage(Label msgLabel, String message) {
		msgLabel.setTextFill(Color.RED);
		msgLabel.setText(message);
	}

	public static void setNormalMessage(Label label, String message) {
		label.setTextFill(Color.BLACK);
		label.setText(message);
	}
	
}
