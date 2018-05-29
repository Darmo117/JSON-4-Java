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

/**
 * This class represents a JSON object. It associates String keys with {@link JsonEntity} values.
 *
 * @author Damien Vergnet
 */
public final class JsonObject extends HashMap<String, JsonEntity> implements JsonEntity {
  private static final long serialVersionUID = -1090220898175859874L;

  /**
   * Creates an empty object.
   */
  public JsonObject() {
    super();
  }

  /**
   * Creates an object from the given map.
   */
  public JsonObject(Map<String, ? extends JsonEntity> m) {
    super(m);
  }

  /**
   * Returns the entity to which the specified key is mapped, or null if this object contains no
   * mapping for the key. It will try to cast the value into the given object type.
   * 
   * @param key the key whose associated value is to be returned
   * @param type the object type into which the entity has to be cast
   * @return the entity to which the specified key is mapped, or null if this map contains no
   *         mapping for the key
   */
  public <T extends JsonEntity> T getAs(String key, JsonEntityType<T> type) {
    return type.getEntityClass().cast(get(key));
  }

  /**
   * Returns the unformatted JSON representation of this object.
   */
  @Override
  public String toString() {
    StringJoiner sj = new StringJoiner(",", "{", "}");
    entrySet().forEach(e -> sj.add("\"" + e.getKey() + "\":" + e.getValue()));
    return sj.toString();
  }
}
