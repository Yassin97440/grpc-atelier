package csv.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import proto.User;

//import proto.User;

public class CsvUtil {

  
  public static List<User> parseFromCsv(List<String[]> dataToparse) {
    
    List<User> dataParsed = new ArrayList<>();

    for (String[] line : dataToparse) {


      User user = User.newBuilder()
          .setFirstName(line[0])
          .setLastName(line[1])
          .setEmail(line[2])
          .setAge(Integer.parseInt(line[3]))
          .build();


      dataParsed.add(user);
    }

    return dataParsed;
  }
}