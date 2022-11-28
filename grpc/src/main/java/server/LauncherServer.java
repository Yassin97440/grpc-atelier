package server;

import java.io.IOException;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import server.service.UserServiceImpl;

public class LauncherServer {
  
  public static void main(String[] args) {
    //on instancie le serveur 
    Server server = ServerBuilder
          .forPort(8080)
          .addService(new UserServiceImpl()).build();

    try {
      server.start();
      server.awaitTermination();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
