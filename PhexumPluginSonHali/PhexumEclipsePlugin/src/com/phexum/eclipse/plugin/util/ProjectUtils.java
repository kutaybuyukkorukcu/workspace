package com.phexum.eclipse.plugin.util;

import java.io.File;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import com.phexum.eclipse.plugin.config.PluginProperties;

public class ProjectUtils {
 

  public static IPath getPathForJarExport(IProject project) {
    return new Path(PluginProperties.getWorkspacePath() + File.separatorChar + "Apps" + File.separatorChar + project.getName() + ".jar");
  }

  public static Shell getShell() {
    return PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();

  }

  public static Shell getShell(ExecutionEvent event) {
    try {
      IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
      return window.getShell();
    } catch (ExecutionException e) {
      return getShell();
    }
  }

}
