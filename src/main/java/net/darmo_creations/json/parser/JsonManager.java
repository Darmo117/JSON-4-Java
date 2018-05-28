package net.darmo_creations.json.parser;

import java.io.StringReader;
import java.util.Map;
import java.util.StringJoiner;

import java_cup.runtime.Symbol;
import net.darmo_creations.json.JsonArray;
import net.darmo_creations.json.JsonEntity;
import net.darmo_creations.json.JsonObject;

public final class JsonManager {
  /**
   * Parses a JSON string.
   */
  public static JsonEntity parse(String json) {
    Parser parser = new Parser(new Lexer(new StringReader(json)));
    try {
      Symbol s = parser.parse();
      return (JsonEntity) s.value;
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns a formatted representation of the given JSON entity.
   */
  public static String format(JsonEntity entity) {
    return format(entity, 0);
  }

  private static String format(JsonEntity entity, int indentLevel) {
    String indent = String.format("%" + indentLevel + "s", "");

    if (entity.isObject()) {
      StringJoiner sj = new StringJoiner(",\n", "{\n", indent + "}");
      JsonObject object = (JsonObject) entity;

      for (Map.Entry<String, JsonEntity> e : object.entrySet()) {
        sj.add(e.getKey() + ":" + format(e.getValue(), indentLevel + 1));
      }

      return sj.toString();
    }
    else if (entity.isArray()) {
      StringJoiner sj = new StringJoiner(",\n", "[\n", indent + "]");
      JsonArray array = (JsonArray) entity;

      for (JsonEntity e : array) {
        sj.add(format(e, indentLevel + 1));
      }

      return sj.toString();
    }
    else if (entity.isValue()) {
      return entity.toString();
    }

    throw new IllegalArgumentException("Invalid JSON entity!");
  }

  private JsonManager() {}
}
