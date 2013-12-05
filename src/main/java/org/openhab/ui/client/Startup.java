package org.openhab.ui.client;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

import org.openhab.ui.client.controller.MainController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Startup extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// 将所有的 Controller 交给 Spring 管理
		final ApplicationContext context = new ClassPathXmlApplicationContext(
				"/beans.xml");

		// 初始化主界面
		MainController mc = context.getBean(MainController.class);
		mc.create(new Stage(), stage);
		mc.init();
		
		// 显示主界面
		mc.show();
	}

	public static <T> T getController(String fxmlFileName) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.load(Startup.class.getResourceAsStream("/fxml/" + fxmlFileName));
		return loader.getController();
	}
}
