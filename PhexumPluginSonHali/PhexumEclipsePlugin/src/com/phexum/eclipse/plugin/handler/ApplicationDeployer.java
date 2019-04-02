package com.phexum.eclipse.plugin.handler;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;

import com.phexum.eclipse.plugin.config.PluginProperties;
import com.phexum.eclipse.plugin.util.ProjectUtils;

public class ApplicationDeployer extends Job {

  private IPath location;
  private ExecutionEvent event;

  public ApplicationDeployer(IPath location, ExecutionEvent event) {
    super("Application Deployment");
    this.location = location;
    this.event = event;
  }

  @Override
  protected IStatus run(IProgressMonitor monitor) {

    File appFile = location.toFile();
    String appName = appFile.getName();

    monitor.beginTask(appName + " deploying to Engine", 70);

    try {
      Socket socket = null;
      BufferedInputStream bis = null;
      BufferedOutputStream bos = null;
      DataOutputStream dos = null;
      String fileServerPort = PluginProperties.getFilePort();

      try {
        socket = new Socket(PluginProperties.getHost(), Integer.parseInt(fileServerPort));
        bis = new BufferedInputStream(new FileInputStream(appFile));
        bos = new BufferedOutputStream(socket.getOutputStream());
        dos = new DataOutputStream(socket.getOutputStream());

        dos.writeUTF("deploy");
        dos.writeUTF(appFile.getName());
        byte[] b = new byte[4096];
        int bytesRead;
        monitor.subTask("Sending application binary file");
        while ((bytesRead = bis.read(b)) != -1) {
          bos.write(b, 0, bytesRead);
        }
        monitor.worked(10);
        return Status.OK_STATUS;
      } catch (FileNotFoundException e) {
        error(e);
      } catch (IOException e) {
        error(e);
      } finally {
        try {
          if (bis != null)
            bis.close();
          if (bos != null)
            bos.close();
          if (dos != null)
            dos.close();
          if (socket != null)
            socket.close();
        } catch (IOException e) {
          error(e);
        }
      }

    } catch (Exception e) {
    }

    return Status.CANCEL_STATUS;

  }

  private void error(Exception e) {
    try {
      MessageDialog.openError(ProjectUtils.getShell(event), "Deployment Error", e.getMessage());
    } catch (Exception e2) {
      e2.printStackTrace();
      e.printStackTrace();
    }
  }
}