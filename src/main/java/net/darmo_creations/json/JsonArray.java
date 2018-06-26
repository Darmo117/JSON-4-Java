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

import java.util.ArrayList;
import java.util.Collection;
import java.util.StringJoiner;

/**
 * This class represents a JSON array. It can store {@link JsonEntity} values.
 *
 * @author Damien Vergnet
 */
public final class JsonArray extends ArrayList<JsonEntity> implements JsonEntity {
  public static final String TYPE_NAME = "array";
  private static final long serialVersionUID = -5326812842277159880L;

  /**
   * Creates an empty array.
   */
  public JsonArray() {
    super();
  }

  /**
   * Creates an array from the given collection.
   *
   * @param c the source collection
   */
  public JsonArray(Collection<? extends JsonEntity> c) {
    super(c);
  }

  /**
   * Returns the element at the specified position in this array. It will try to cast the element
   * into the given object type.
   *
   * @param index index of the element to return
   * @param type the object type into which the element has to be cast
   * @return the element at the specified position in this array
   * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 or index ≥ size())
   * @throws ClassCastException if the actual value is not assignable to the specified type
   */
  public <T extends JsonEntity> T getAs(int index, JsonEntityType<T> type) {
    return type.getEntityClass().cast(get(index));
  }

  /**
   * Returns the object at the specified position in this array.
   *
   * @param index index of the element to return
   * @return the object at the specified position in this array or null if the value is null
   * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 or index ≥ size())
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonObject}
   */
  public JsonObject getObject(int index) {
    return getAs(index, JsonEntityType.OBJECT);
  }

  /**
   * Returns the array at the specified position in this array.
   *
   * @param index index of the element to return
   * @return the array at the specified position in this array or null if the value is null
   * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 or index ≥ size())
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonArray}
   */
  public JsonArray getArray(int index) {
    return getAs(index, JsonEntityType.ARRAY);
  }

  /**
   * Returns the boolean at the specified position in this array.
   *
   * @param index index of the element to return
   * @return the boolean at the specified position in this array or null if the value is null
   * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 or index ≥ size())
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonBoolean}
   */
  public Boolean getBoolean(int index) {
    JsonBoolean b = getAs(index, JsonEntityType.BOOLEAN_VALUE);
    return b != null ? b.get() : null;
  }

  /**
   * Appends the specified boolean to the end of this list.
   *
   * @param b element to be appended to this list
   * @return true (as specified by {@link ArrayList#add})
   */
  public boolean addBoolean(boolean b) {
    return add(new JsonBoolean(b));
  }

  /**
   * Inserts the specified boolean at the specified position in this list. Shifts the element
   * currently at that position (if any) and any subsequent elements to the right (adds one to their
   * indices).
   *
   * @param index index at which the specified boolean is to be inserted
   * @param b element to be inserted
   */
  public void addBoolean(int index, boolean b) {
    add(index, new JsonBoolean(b));
  }

  /**
   * Returns the number at the specified position in this array.
   *
   * @param index index of the element to return
   * @return the number at the specified position in this array or null if the value is null
   * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 or index ≥ size())
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonNumber}
   */
  public Double getNumber(int index) {
    JsonNumber n = getAs(index, JsonEntityType.NUMBER_VALUE);
    return n != null ? n.get() : null;
  }

  /**
   * Appends the specified number to the end of this list.
   *
   * @param d element to be appended to this list
   * @return true (as specified by {@link ArrayList#add})
   */
  public boolean addNumber(double d) {
    return add(new JsonNumber(d));
  }

  /**
   * Inserts the specified number at the specified position in this list. Shifts the element
   * currently at that position (if any) and any subsequent elements to the right (adds one to their
   * indices).
   *
   * @param index index at which the specified boolean is to be inserted
   * @param d element to be inserted
   */
  public void addNumber(int index, double d) {
    add(index, new JsonNumber(d));
  }

  /**
   * Returns the string at the specified position in this array.
   *
   * @param index index of the element to return
   * @return the string at the specified position in this array or null if the value is null
   * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 or index ≥ size())
   * @throws ClassCastException if the actual value is not assignable to a {@link JsonString}
   */
  public String getString(int index) {
    JsonString s = getAs(index, JsonEntityType.STRING_VALUE);
    return s != null ? s.get() : null;
  }

  /**
   * Appends the specified string to the end of this list.
   *
   * @param s element to be appended to this list
   * @return true (as specified by {@link ArrayList#add})
   */
  public boolean addString(String s) {
    return add(new JsonString(s));
  }

  /**
   * Inserts the specified string at the specified position in this list. Shifts the element
   * currently at that position (if any) and any subsequent elements to the right (adds one to their
   * indices).
   *
   * @param index index at which the specified boolean is to be inserted
   * @param s element to be inserted
   */
  public void addString(int index, String s) {
    add(index, new JsonString(s));
  }

  @Override
  public String getTypeName() {
    return TYPE_NAME;
  }

  /**
   * Returns an unformatted JSON representation of this array.
   */
  @Override
  public String toString() {
    StringJoiner sj = new StringJoiner(",", "[", "]");
    forEach(e -> sj.add(e.toString()));
    return sj.toString();
  }
}
