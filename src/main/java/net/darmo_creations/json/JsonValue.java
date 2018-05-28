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

public final class JsonValue implements JsonBase {
  private Object value;

  public JsonValue(Object value) {
    this.value = value;
  }

  public String getString() {
    return (String) this.value;
  }

  public Integer getInteger() {
    return (Integer) this.value;
  }

  public Double getDouble() {
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
}
