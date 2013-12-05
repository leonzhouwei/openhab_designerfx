package org.openhab.ui.client.controller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Tab;

import javax.annotation.Resource;

import org.openhab.ui.client.view.model.GuiElemDefine;

public class MainController extends BaseController {

	@FXML
	private Parent root;
	@FXML
	private Tab confTab;
	@FXML
	private Tab logTab;
	@Resource
	private ConfigurationController confController;

	@Override
	public Parent getView() {
		return root;
	}

	public void init() {
		stage.setTitle(GuiElemDefine.MAIN_WINDOW_TTTLE);
		confController.setParent(this);
		confTab.setContent(confController.getView());
	}

}
