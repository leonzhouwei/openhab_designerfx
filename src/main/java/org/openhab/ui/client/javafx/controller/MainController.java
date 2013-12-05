package org.openhab.ui.client.javafx.controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;

import javax.annotation.Resource;

import org.openhab.ui.client.javafx.tabcontroller.ConfigurationTabController;
import org.openhab.ui.client.javafx.util.Util;
import org.openhab.ui.client.javafx.view.model.GuiElemDefine;

public class MainController extends BaseController {

	@FXML
	private Parent root;
	@FXML
	private Tab confTab;
	@FXML
	private Tab logTab;
	@FXML
	private MenuItem openFolderMenuItem;
	
	@Resource
	private ConfigurationTabController confController;

	@Override
	public Parent getView() {
		return root;
	}

	public void init() {
		stage.setTitle(GuiElemDefine.MAIN_WINDOW_TTTLE);
		confController.setParent(this);
		confTab.setContent(confController.getView());
	}
	
	public void openFolder(ActionEvent actionEvent) {
		File file = Util.getSelectedFolderInPopupWindow(GuiElemDefine.SELECT_CONF_DIR, stage);
		System.out.println(file == null ? null : file.getPath());
	}

}
