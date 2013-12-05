package org.openhab.designerfx.tabcontroller;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import org.openhab.designerfx.controller.MainController;
import org.openhab.designerfx.view.model.GuiElemDefine;

public class ConfigurationTabController {
	
	private MainController parent;
	
	@FXML
	private Parent root;
	@FXML
	private TreeView<String> treeView;
	
	public void init() {
		TreeItem<String> root = new TreeItem<String>(GuiElemDefine.CONFIGRATIONS);
		treeView.setRoot(root);
		root.setExpanded(true);
		TreeItem item = null;
		item = new TreeItem<String>(GuiElemDefine.ITEMS);
		root.getChildren().add(item);
		item = new TreeItem<String>(GuiElemDefine.SITEMAPS);
		root.getChildren().add(item);
		item = new TreeItem<String>(GuiElemDefine.RULES);
		root.getChildren().add(item);
		item = new TreeItem<String>(GuiElemDefine.SCRIPTS);
		root.getChildren().add(item);
		item = new TreeItem<String>(GuiElemDefine.TRANSFORMATIONS);
		root.getChildren().add(item);
	}
	
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
