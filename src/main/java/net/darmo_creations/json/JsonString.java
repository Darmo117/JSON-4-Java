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
package net.darmo_creations.json;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents a JSON string.
 *
 * @author Damien Vergnet
 */
public final class JsonString extends JsonValue<String> {
  private static final long serialVersionUID = -4540752717027411018L;

  public JsonString(String value) {
    super(value);
  }

  /**
   * Returns an unformatted representation of this JSON string. Value will be between double quotes.
   */
  @Override
  public String toString() {
    return this.value != null ? "\"" + escaped(this.value) + "\"" : "null";
  }

  private static final Map<Character, String> ESCAPES = new HashMap<>();

  static {
    ESCAPES.put('\\', "\\\\");
    ESCAPES.put('"', "\\\"");
    ESCAPES.put('\b', "\\b");
    ESCAPES.put('\f', "\\f");
    ESCAPES.put('\n', "\\n");
    ESCAPES.put('\r', "\\r");
    ESCAPES.put('\t', "\\t");
  }

  private static String escaped(String s) {
    StringBuilder sb = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (ESCAPES.containsKey(c)) {
        sb.append(ESCAPES.get(c));
      }
      else if (Character.isISOControl(c)) {
        sb.append(String.format("\\u%04X", (int) c));
      }
      else
        sb.append(String.valueOf(c));
    }

    return sb.toString();
  }
}
