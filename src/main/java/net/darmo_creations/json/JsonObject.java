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
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * This class represents a JSON object. It associates String keys with {@link JsonEntity} values.
 *
 * @author Damien Vergnet
 */
public final class JsonObject extends HashMap<String, JsonEntity> implements JsonEntity {
  public static final String TYPE_NAME = "object";
  private static final long serialVersionUID = -1090220898175859874L;

  /**
   * Creates an empty object.
   */
  public JsonObject() {
    super();
  }

  /**
   * Creates an object from the given map.
   *
   * @param m the source map
   */
  public JsonObject(Map<String, ? extends JsonEntity> m) {
    super(m);
  }

  /**
   * Returns the entity to which the specified key is mapped. It will try to cast the value into the
   * given object type.
   *
   * @param key the key whose associated value is to be returned
   * @param type the object type into which the entity has to be cast
   * @return the entity to which the specified key is mapped
   * @throws NoSuchElementException if there is no mapping for the key
   * @throws ClassCastException if the actual value is not assignable to the specified type
   */
  public <T extends JsonEntity> T getAs(String key, JsonEntityType<T> type) {
    if (!containsKey(key))
      throw new NoSuchElementException("No mapping for key '" + key + "'!");
    return type.getEntityClass().cast(get(key));
  }

  /**
   * Returns the object for the given key.
   *
   * @param key the key whose associated value is to be returned
   * @return the object to which the specified key is mapped or null if the value is null
   * @throws NoSuchElementException if there is no mapping for the key
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonObject}
   */
  public JsonObject getObject(String key) {
    return getAs(key, JsonEntityType.OBJECT);
  }

  /**
   * Returns the array for the given key.
   *
   * @param key the key whose associated value is to be returned
   * @return the array to which the specified key is mapped or null if the value is null
   * @throws NoSuchElementException if there is no mapping for the key
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonArray}
   */
  public JsonArray getArray(String key) {
    return getAs(key, JsonEntityType.ARRAY);
  }

  /**
   * Returns the boolean for the given key.
   *
   * @param key the key whose associated value is to be returned
   * @return the boolean to which the specified key is mapped or null if the value is null
   * @throws NoSuchElementException if there is no mapping for the key
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonBoolean}
   */
  public Boolean getBoolean(String key) {
    JsonBoolean b = getAs(key, JsonEntityType.BOOLEAN_VALUE);
    return b != null ? b.get() : null;
  }

  /**
   * Associates the specified boolean value with the specified key in this map. If the map
   * previously contained a mapping for the key, the old value is replaced.
   *
   * @param key key with which the specified value is to be associated
   * @param b value to be associated with the specified key
   * @return the previous value associated with key, or null if there was no mapping for key. (A
   *         null return can also indicate that the map previously associated null with key.)
   */
  public JsonEntity putBoolean(String key, boolean b) {
    return put(key, new JsonBoolean(b));
  }

  /**
   * Returns the number for the given key.
   *
   * @param key the key whose associated value is to be returned
   * @return the number to which the specified key is mapped or null if the value is null
   * @throws NoSuchElementException if there is no mapping for the key
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonNumber}
   */
  public Double getNumber(String key) {
    JsonNumber n = getAs(key, JsonEntityType.NUMBER_VALUE);
    return n != null ? n.get() : null;
  }

  /**
   * Associates the specified double value with the specified key in this map. If the map previously
   * contained a mapping for the key, the old value is replaced.
   *
   * @param key key with which the specified value is to be associated
   * @param d value to be associated with the specified key
   * @return the previous value associated with key, or null if there was no mapping for key. (A
   *         null return can also indicate that the map previously associated null with key.)
   */
  public JsonEntity putNumber(String key, double d) {
    return put(key, new JsonNumber(d));
  }

  /**
   * Returns the string for the given key.
   *
   * @param key the key whose associated value is to be returned
   * @return the string to which the specified key is mapped or null if the value is null
   * @throws NoSuchElementException if there is no mapping for the key
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonString}
   */
  public String getString(String key) {
    JsonString s = getAs(key, JsonEntityType.STRING_VALUE);
    return s != null ? s.get() : null;
  }

  /**
   * Associates the specified string value with the specified key in this map. If the map previously
   * contained a mapping for the key, the old value is replaced.
   *
   * @param key key with which the specified value is to be associated
   * @param s value to be associated with the specified key
   * @return the previous value associated with key, or null if there was no mapping for key. (A
   *         null return can also indicate that the map previously associated null with key.)
   * @throws NullPointerException if the value is null
   */
  public JsonEntity putString(String key, String s) {
    return put(key, new JsonString(s));
  }

  @Override
  public String getTypeName() {
    return TYPE_NAME;
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
