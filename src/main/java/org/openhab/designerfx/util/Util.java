package org.openhab.designerfx.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Platform;
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
		File file = new File(Define.USER_HOME_DIR);
		builder.initialDirectory(file);
		DirectoryChooser chooser = builder.build();
		return chooser.showDialog(primaryStage);
	}

	public static void setErrorMessage(final Label msgLabel,
			final String message) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				msgLabel.setTextFill(Color.RED);
				msgLabel.setText(message);
			}
		};
		runLaterInJavaFXAppThread(r);
	}

	public static void setNormalMessage(final Label label, final String message) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				label.setTextFill(Color.BLACK);
				label.setText(message);
			}
		};
		runLaterInJavaFXAppThread(r);
	}

	public static void runLaterInJavaFXAppThread(Runnable r) {
		Platform.runLater(r);
	}
	
	public static List<String> listRegularFileNames(String path, String fileExtension) {
		File directory = new File(path);
		String[] array = directory.list();
		List<String> names = new ArrayList<String>();
		for (String name : array) {
			if (name.endsWith(fileExtension)) {
				System.out.println(name);
				names.add(name);
			}
		}
		return names;
	}

}
