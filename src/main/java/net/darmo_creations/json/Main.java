package net.darmo_creations.json;

import net.darmo_creations.json.parser.JsonManager;

public class Main {
  public static void main(String[] args) throws Exception {
    String input = "{\"a\": 1}";
    JsonEntity e = JsonManager.parse(input);
    System.out.println(e);
    System.out.println(JsonManager.format(e));
  }
}
