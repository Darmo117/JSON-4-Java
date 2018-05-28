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
import java.util.StringJoiner;

public final class JsonObject extends HashMap<String, JsonEntity> implements JsonEntity {
  private static final long serialVersionUID = -1090220898175859874L;

  public JsonObject() {
    super();
  }

  public JsonObject(int initialCapacity) {
    super(initialCapacity);
  }

  public JsonObject(int initialCapacity, float loadFactor) {
    super(initialCapacity, loadFactor);
  }

  public JsonObject(Map<String, ? extends JsonEntity> m) {
    super(m);
  }

  public <T extends JsonEntity> T getAs(String key, ObjectType<T> type) {
    return type.getObjectClass().cast(get(key));
  }

  @Override
  public boolean isObject() {
    return true;
  }

  @Override
  public String toString() {
    StringJoiner sj = new StringJoiner(",", "{", "}");
    entrySet().forEach(e -> sj.add(e.getKey() + ":" + e.getValue()));
    return sj.toString();
  }
}
