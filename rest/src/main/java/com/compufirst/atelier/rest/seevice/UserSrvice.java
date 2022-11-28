package com.compufirst.atelier.rest.seevice;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.compufirst.atelier.csv.reader.CsvReader;
import com.compufirst.atelier.csv.util.CsvUtil;
import com.compufirst.atelier.rest.model.User;

@RestController
@RequestMapping(path = "/api/v1/user")
public class UserSrvice {


   @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() throws FileNotFoundException, IOException {
    CsvReader reader = new CsvReader();
    return CsvUtil.parseRestFromCsv(reader.readFile("C:/Users/yassin.abdulla/Desktop/atelier.csv"));
  }


}
