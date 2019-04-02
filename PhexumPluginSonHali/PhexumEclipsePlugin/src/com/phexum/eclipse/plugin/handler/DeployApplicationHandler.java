package com.phexum.eclipse.plugin.handler;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.internal.resources.File;
import org.eclipse.core.internal.resources.Project;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.internal.core.JavaProject;
import org.eclipse.jdt.ui.jarpackager.IJarExportRunnable;
import org.eclipse.jdt.ui.jarpackager.JarPackageData;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osgi.resource.Resource;

import com.phexum.eclipse.plugin.util.ProjectUtils;

public class DeployApplicationHandler extends AbstractHandler {

  public DeployApplicationHandler() {
  }

  public Object execute(ExecutionEvent event) throws ExecutionException {
    ISelection selection = HandlerUtil.getCurrentSelection(event);

    if (selection instanceof TreeSelection) {
      deploySelectedApps((TreeSelection) selection, event);
    }
    return null;
  }

  private void deploySelectedApps(TreeSelection selection, ExecutionEvent event) {
    Iterator i = selection.iterator();

    while (i.hasNext()) {
      try {
        Object o = i.next();
        if (o instanceof File) {
          deployJs((File) o, event);
        } else if (o instanceof Project) {
          deployProject((Project) o, event);
        } else if (o instanceof JavaProject) {
          deployProject(((JavaProject) o).getProject(), event);
        }
      } catch (Exception e) {
        MessageDialog.openError(ProjectUtils.getShell(event), "Application Deployment", e.getMessage());
      }
    }
  }

  private void deployProject(IProject project, final ExecutionEvent event) throws Exception {

    JarPackageData description = new JarPackageData();
    IPath location = ProjectUtils.getPathForJarExport(project);
    description.setJarLocation(location);
    description.setExportOutputFolders(true);
    description.setSaveManifest(true);
    description.setOverwrite(true);
    description.setExportErrors(false);
    description.setElements(new IProject[] { project });
    if (description.isValid()) {
      Shell shell = ProjectUtils.getShell(event);
      final IJarExportRunnable runnable = description.createJarExportRunnable(shell);
      try {
        new ProgressMonitorDialog(shell).run(false, true, runnable);
      } catch (Exception e) {
        e.printStackTrace();
      }

      new ApplicationDeployer(location, event).schedule();
    } else {
      throw new Exception("Project could not be validate");
    }
  }

  private void deployJs(File js, ExecutionEvent event) {
    new ApplicationDeployer(js.getLocation(), event).schedule();

  }

  private void deployClass(Class clazz) {

  }

  private void deployPackage(Resource pack) {

  }

}
