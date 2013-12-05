package org.openhab.designerfx.tabcontroller;

import org.openhab.designerfx.controller.MainController;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class ConfigurationTabController {
	
	private MainController parent;
	
	@FXML
	private Parent root;
	
	public Parent getView() {
		return root;
	}

	public MainController getParent() {
		return parent;
	}

	public void setParent(MainController parent) {
		this.parent = parent;
	}
	
}
