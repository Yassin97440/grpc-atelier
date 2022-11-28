package server.service;

import java.util.ArrayList;
import java.util.List;

import csv.reader.CsvReader;
import csv.util.CsvUtil;
import io.grpc.stub.StreamObserver;
import proto.User;
import proto.UserRequest;
import proto.UserServiceGrpc.UserServiceImplBase;
import proto.UsersResponse;



public class UserServiceImpl extends UserServiceImplBase {

  @Override
  public void readAndSendUsers(UserRequest request, StreamObserver<UsersResponse> responseObserver) {
  //   List<User> users = new ArrayList<>();
  //   CsvReader csvReader = new CsvReader();
  //   try {
  //     CsvUtil.parseFromCsv(csvReader.readFile(""));
      
  //   } catch (Exception e) {
  //     e.printStackTrace();
  //   }
  //   // User user = User.newBuilder().
  //   // UsersResponse response = UsersResponse.newBuilder().addUsers(users).build;
  //   // responseObserver.onNext(response);
  //   super.readAndSendUsers(request, responseObserver);
  }


  

}
