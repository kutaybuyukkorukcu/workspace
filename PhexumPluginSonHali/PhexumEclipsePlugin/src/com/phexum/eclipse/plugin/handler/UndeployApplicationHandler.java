package com.phexum.eclipse.plugin.handler;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import com.phexum.eclipse.plugin.util.ProjectUtils;
import com.phexum.sdk.data.DataModel;

public class UndeployApplicationHandler extends AbstractHandler {

  public UndeployApplicationHandler() {
  }

  public Object execute(ExecutionEvent event) throws ExecutionException {
    TreeSelection selection = (TreeSelection) HandlerUtil.getCurrentSelection(event);

    Iterator i = selection.iterator();

    while (i.hasNext()) {
      try {
        Object o = i.next();
        if (o instanceof File) {
          undeployJs((File) o, event);
        } else if (o instanceof Project) {
          undeployProject((Project) o, event);
        } else if (o instanceof JavaProject) {
          undeployProject(((JavaProject) o).getProject(), event);
        }
      } catch (Exception e) {
        MessageDialog.openError(ProjectUtils.getShell(event), "Application Deployment", e.getMessage());
      }
    }

    return null;
  }

  private void undeployProject(IProject project, ExecutionEvent event) {
    System.out.println(project.getName());
  }

  private void undeployProject(Project o, ExecutionEvent event) {
    System.out.println(o.getName());

  }

  private void undeployJs(File o, ExecutionEvent event) {

//    String appName = o.getName().split("\\.")[0];
//    DataModel command = new DataModel();
//    command.put(DataModelOptions.REQUEST_COMMAND, "undeploy "+appName);
//
//    ConnectionManager.getInstance().getCommandConnection().getHandler().write(command);
    
  }
}
