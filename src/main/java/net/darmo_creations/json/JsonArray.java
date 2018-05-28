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

public final class JsonArray extends ArrayList<JsonBase> implements JsonBase {
  private static final long serialVersionUID = -5326812842277159880L;

  public JsonArray() {
    super();
  }

  public JsonArray(int initialCapacity) {
    super(initialCapacity);
  }

  public JsonArray(Collection<? extends JsonBase> c) {
    super(c);
  }

  public <T extends JsonBase> T getAs(int index, ObjectType<T> type) {
    return type.getObjectClass().cast(get(index));
  }
}
