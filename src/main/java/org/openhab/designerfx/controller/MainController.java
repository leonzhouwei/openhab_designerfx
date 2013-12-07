package org.openhab.designerfx.controller;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;

import javax.annotation.Resource;

import org.openhab.designerfx.tabcontroller.ConfigurationTabController;
import org.openhab.designerfx.util.Util;
import org.openhab.designerfx.view.GuiElemDefine;
import org.openhab.designerfx.view.GuiPromptMessage;

public class MainController extends BaseController {

	@FXML
	private Parent root;
	@FXML
	private Label msgLabel;
	@FXML
	private Tab confTab;
	@FXML
	private Tab logTab;
	@FXML
	private MenuItem openFolderMenuItem;
	
	@Resource
	private ConfigurationTabController confTabController;

	@Override
	public Parent getView() {
		return root;
	}

	public void init() {
		stage.setTitle(GuiElemDefine.MAIN_WINDOW_TTTLE);
		confTabController.setParent(this);
		confTabController.init();
		confTab.setContent(confTabController.getView());
	}
	
	@FXML
	public void openFolder(ActionEvent actionEvent) {
		try {
			File folder = Util.getSelectedFolderInPopupWindow(GuiElemDefine.SELECT_CONF_DIR, stage);
			if (folder == null) {
				return;
			}
			confTabController.loadConfDir(folder);	
		} catch (Exception e) {
			Util.setErrorMessage(msgLabel, e.getMessage());
		}
		
	}
	
	public void setErrorMessage(String message) {
		Util.setErrorMessage(msgLabel, message);
	}
	
	public void resetMessageLabel() {
		Util.setNormalMessage(msgLabel, GuiPromptMessage.WELCOME);
	}

}
