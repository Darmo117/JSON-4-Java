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
  private static final long serialVersionUID = -5326812842277159880L;

  /**
   * Creates an empty array.
   */
  public JsonArray() {
    super();
  }

  /**
   * Creates an array from the given collection.
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
   */
  public <T extends JsonEntity> T getAs(int index, JsonEntityType<T> type) {
    return type.getEntityClass().cast(get(index));
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
