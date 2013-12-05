package org.openhab.designerfx.tabcontroller;

import java.io.File;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

import org.openhab.designerfx.common.Config;
import org.openhab.designerfx.common.Constants;
import org.openhab.designerfx.controller.MainController;
import org.openhab.designerfx.util.Util;
import org.openhab.designerfx.view.GuiElemDefine;

public class ConfigurationTabController {
	
	private MainController parent;
	
	@FXML
	private Parent root;
	@FXML
	private TreeView<String> treeView;
	private TreeItem<String> treeItemOfItems = new TreeItem<String>(GuiElemDefine.ITEMS);
	private TreeItem<String> treeItemOfSitemaps = new TreeItem<String>(GuiElemDefine.SITEMAPS);
	
	public void init() {
		treeItemOfItems.setExpanded(true);
		treeItemOfItems.getChildren().clear();
		treeItemOfSitemaps.setExpanded(true);
		treeItemOfSitemaps.getChildren().clear();
		TreeItem<String> root = new TreeItem<String>(GuiElemDefine.CONFIGRATIONS);
		treeView.setRoot(root);
		root.setExpanded(true);
		root.getChildren().add(treeItemOfItems);
		root.getChildren().add(treeItemOfSitemaps);
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
	
	public void loadConfDir(File confDir) {
		if (confDir == null || confDir.isDirectory() == false) {
			return;
		}
		File dir = null;
		List<File> files = null;
		dir = new File(confDir.getPath() + Constants.FILE_SEPARATOR + Config.getItemsDirBaseName());
		files = Util.listRegularFileNames(dir, Constants.ITEMS_FILE_EXTENSION);
		List<String> baseNames = Util.baseNames(files, Constants.ITEMS_FILE_EXTENSION);
		setNonLeafNode(treeItemOfItems, baseNames);
	}
	
	public void setNonLeafNode(TreeItem<String> parent, List<String> baseNames) {
		parent.getChildren().clear();
		for (String baseName : baseNames) {
			TreeItem<String> child = new TreeItem<String>(baseName);
			parent.getChildren().add(child);
		}
	}
	
}
