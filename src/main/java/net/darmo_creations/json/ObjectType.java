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

import java.io.Serializable;

public final class ObjectType<T extends JsonEntity> implements Serializable {
  private static final long serialVersionUID = 7068360356239378250L;

  public static final ObjectType<JsonObject> OBJECT = new ObjectType<>(JsonObject.class);
  public static final ObjectType<JsonArray> ARRAY = new ObjectType<>(JsonArray.class);
  public static final ObjectType<JsonValue> VALUE = new ObjectType<>(JsonValue.class);

  private final Class<T> objectClass;

  private ObjectType(Class<T> objectClass) {
    this.objectClass = objectClass;
  }

  public Class<T> getObjectClass() {
    return this.objectClass;
  }
}
