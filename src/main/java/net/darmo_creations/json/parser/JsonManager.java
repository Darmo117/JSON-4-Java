/*
 * Copyright © 2018 Damien Vergnet
 * 
 * This file is part of JSON-4-Java.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
  public static JsonObject parse(String json) {
    // FIXME try using non-deprecated constructor
    @SuppressWarnings("deprecation")
    Parser parser = new Parser(new Lexer(new StringReader(json)));
    try {
      Symbol s = parser.parse();
      return (JsonObject) s.value;
    }
    catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Returns a formatted representation of the given JSON entity.
   */
  public static String format(JsonEntity entity, int indentation) {
    if (indentation <= 0)
      throw new IllegalArgumentException("Indentation must be > 0");
    return format(entity, indentation, 0);
  }

  private static String format(JsonEntity entity, int indentation, int indentLevel) {
    String indent1 = indentLevel > 0 ? String.format("%" + indentation * indentLevel + "s", "") : "";
    String indent = String.format("%" + indentation * (indentLevel + 1) + "s", "");

    if (entity.isObject()) {
      StringJoiner sj = new StringJoiner(",\n", "{\n", "\n" + indent1 + "}");
      JsonObject object = (JsonObject) entity;

      for (Map.Entry<String, JsonEntity> e : object.entrySet()) {
        sj.add(indent + "\"" + e.getKey() + "\": " + format(e.getValue(), indentation, indentLevel + 1));
      }

      return sj.toString();
    }
    else if (entity.isArray()) {
      StringJoiner sj = new StringJoiner(",\n", "[\n", "\n" + indent1 + "]");
      JsonArray array = (JsonArray) entity;

      for (JsonEntity e : array) {
        sj.add(indent + format(e, indentation, indentLevel + 1));
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
