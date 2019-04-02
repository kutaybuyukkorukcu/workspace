package com.phexum.eclipse.plugin.handler;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import com.phexum.eclipse.plugin.util.ProjectUtils;
import com.phexum.eclipse.plugin.window.SettingsWindow;

public class SettingsHandler extends AbstractHandler {

  public SettingsHandler() {
  }

  public Object execute(ExecutionEvent event) throws ExecutionException {
    SettingsWindow settings = new SettingsWindow(ProjectUtils.getShell());
    settings.open();
    return null;
  }

}
