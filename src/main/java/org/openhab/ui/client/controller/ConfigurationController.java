package org.openhab.ui.client.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;

public class ConfigurationController {
	
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
