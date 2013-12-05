package org.openhab.designerfx.util;

import java.io.File;

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
		String cwd = System.getProperty(Define.USER_HOME_DIR);
		File file = new File(cwd);
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

}
