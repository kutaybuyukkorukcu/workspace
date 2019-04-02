package com.kutay.github.webservice.serverToClýent;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
   public static void main(String args[]) {
      String data = "Toobie ornaught toobie";
      try {
         ServerSocket srvr = new ServerSocket(1234);
         Socket skt = srvr.accept();
         System.out.print("Server has connected!\n");
         PrintWriter out = new PrintWriter(skt.getOutputStream());
         System.out.print("Sending string: '" + data + "'\n");
         out.print("im sad");
         out.close();
         skt.close();
         srvr.close();
      }
      catch(Exception e) {
         System.out.print("Whoops! It didn't work!\n");
      }
   }
}