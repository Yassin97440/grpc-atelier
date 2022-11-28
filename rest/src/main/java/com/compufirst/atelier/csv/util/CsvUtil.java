package com.compufirst.atelier.csv.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.compufirst.atelier.rest.model.User;

//import proto.User;

public class CsvUtil {

  
  public static List<User> parseRestFromCsv(List<String[]> dataToparse) {
    
    List<User> dataParsed = new ArrayList<>();

    Long i = 0L;
    for (String[] line : dataToparse) {

      User user = new User();
      if (i!=0) {
        
        user.setFirstName(line[0]);
        user.setLastName(line[1]);
        user.setEmail(line[2]);
        user.setAge(Integer.parseInt(line[3]));
      }


      dataParsed.add(user);
      i++;
    }

    return dataParsed;
  }
}