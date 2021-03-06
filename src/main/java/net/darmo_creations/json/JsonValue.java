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

import java.util.Objects;

/**
 * Base class for JSON literals.
 * 
 * @author Damien Vergnet
 *
 * @param <T> type of the internal value
 */
public abstract class JsonValue<T> implements JsonEntity {
  public static final String DEFAULT_TYPE_NAME = "literal value";
  private static final long serialVersionUID = -3315891098392786432L;

  protected T value;
  private String typeName;

  /**
   * Creates a value.
   * 
   * @param value entity value
   * @param typeName entity type name
   */
  public JsonValue(T value, String typeName) {
    this.value = Objects.requireNonNull(value);
    this.typeName = Objects.requireNonNull(typeName);
  }

  public T get() {
    return this.value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.value == null) ? 0 : this.value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    JsonValue<?> other = (JsonValue<?>) obj;
    if (this.value == null) {
      if (other.value != null)
        return false;
    }
    else if (!this.value.equals(other.value))
      return false;
    return true;
  }

  @Override
  public final String getTypeName() {
    return this.typeName;
  }

  /**
   * Returns an unformatted representation of this value. The result is the one returned by
   * {@link String#valueOf(Object)} method. May be overriden by subclasses.
   */
  @Override
  public String toString() {
    return String.valueOf(this.value);
  }
}
