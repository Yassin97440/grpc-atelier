package com.compufirst.atelier.csv.reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CsvReader {

  final String COMMA_DELIMITER = ",";


  public List<String[]> readFile(String pathFile) throws FileNotFoundException, IOException {

    /*on créer un HashMap car quand on va spliter, on aura 2 valeurs par ligne.
     * Du coup on stocke la valeur1 (name) en clé du hadhmap
     * et la valeur2 (email) en valeur du hashmap
     */
    List<String[]> dataReaded = new ArrayList<>();
    // HashMap<String, String> dataReaded = new HashMap<String, String>();
    /*on essaye de lire fichier */
    try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {

      String line;
      /*tant qu'il y a une ligne à lire, on l'a lit */
      while ((line = br.readLine()) != null) {

        String[] values = line.split(COMMA_DELIMITER);

        dataReaded.add(values);

      }
    }
    return dataReaded;
  }

}
