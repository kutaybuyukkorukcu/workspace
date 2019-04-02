package com.phexum.eclipse.plugin.window;

import java.util.Properties;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.phexum.eclipse.plugin.config.PluginProperties;

public class SettingsWindow extends TitleAreaDialog {

  private Text txtHost;
  private Text txtFilePort;

  public SettingsWindow(Shell parentShell) {
    super(parentShell);
  }

  @Override
  public void create() {
    super.create();
    setTitle("Phexum Eclipse Plugin Engine Preferences");
    setMessage("Please be sure press ok button after changes", IMessageProvider.INFORMATION);
  }

  @Override
  protected Control createDialogArea(Composite parent) {
    Composite area = (Composite) super.createDialogArea(parent);
    Composite container = new Composite(area, SWT.NONE);
    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(2, false);
    container.setLayout(layout);

    createHostTextBox(container);
    createFilePortTextBox(container);

    return area;
  }

  private void createHostTextBox(Composite container) {
    Label lbtFirstName = new Label(container, SWT.NONE);
    lbtFirstName.setText("Engine Ip/Host");

    GridData dataFirstName = new GridData();
    dataFirstName.grabExcessHorizontalSpace = true;
    dataFirstName.horizontalAlignment = GridData.FILL;

    txtHost = new Text(container, SWT.BORDER);
    txtHost.setLayoutData(dataFirstName);
    txtHost.setText(PluginProperties.getHost());
  }

  private void createFilePortTextBox(Composite container) {
    Label lbtLastName = new Label(container, SWT.NONE);
    lbtLastName.setText("Engine File Port");

    GridData dataLastName = new GridData();
    dataLastName.grabExcessHorizontalSpace = true;
    dataLastName.horizontalAlignment = GridData.FILL;
    txtFilePort = new Text(container, SWT.BORDER);
    txtFilePort.setLayoutData(dataLastName);
    txtFilePort.setText(PluginProperties.getFilePort());
  }

  @Override
  protected boolean isResizable() {
    return false;
  }

  private void saveInput() {

    String url = txtHost.getText();
    String port = txtFilePort.getText();

    PluginProperties.setHost(url);
    PluginProperties.setFilePort(port);
    PluginProperties.saveProperties();

  }

  @Override
  protected void okPressed() {
    saveInput();
    super.okPressed();
  }

}