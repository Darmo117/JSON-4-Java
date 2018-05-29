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

/**
 * This class lists all JSON entities types.
 * 
 * @author Damien Vergnet
 *
 * @param <T> the associated entity type
 */
public final class JsonEntityType<T extends JsonEntity> {
  public static final JsonEntityType<JsonObject> OBJECT = new JsonEntityType<>(JsonObject.class);
  public static final JsonEntityType<JsonArray> ARRAY = new JsonEntityType<>(JsonArray.class);
  @SuppressWarnings("rawtypes")
  public static final JsonEntityType<JsonValue> VALUE = new JsonEntityType<>(JsonValue.class);
  public static final JsonEntityType<JsonString> STRING_VALUE = new JsonEntityType<>(JsonString.class);
  public static final JsonEntityType<JsonNumber> NUMBER_VALUE = new JsonEntityType<>(JsonNumber.class);
  public static final JsonEntityType<JsonBoolean> BOOLEAN_VALUE = new JsonEntityType<>(JsonBoolean.class);

  private final Class<T> entityClass;

  private JsonEntityType(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  /**
   * Returns the class of the entity it represents.
   */
  public Class<T> getEntityClass() {
    return this.entityClass;
  }
}
