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

// TODO Add tests
public final class JsonValue implements JsonEntity {
  private Object value;

  public JsonValue(Object value) {
    this.value = value;
  }

  public String getString() {
    return (String) this.value;
  }

  public Double getNumber() {
    return (Double) this.value;
  }

  public Boolean getBoolean() {
    return (Boolean) this.value;
  }

  public boolean isNull() {
    return this.value == null;
  }

  public Class<?> getType() {
    return isNull() ? null : this.value.getClass();
  }

  @Override
  public boolean isValue() {
    return true;
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
    JsonValue other = (JsonValue) obj;
    if (this.value == null) {
      if (other.value != null)
        return false;
    }
    else if (!this.value.equals(other.value))
      return false;
    return true;
  }

  /**
   * Returns an unformatted representation of this value.
   */
  @Override
  public String toString() {
    if (this.value instanceof String)
      return "\"" + this.value + "\"";
    else if (this.value instanceof Double && (Double) this.value == Math.floor((Double) this.value))
      return Integer.toString(((Double) this.value).intValue());
    return String.valueOf(this.value);
  }
}
