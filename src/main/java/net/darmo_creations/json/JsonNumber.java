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
 * This class represents a JSON number.
 *
 * @author Damien Vergnet
 */
public final class JsonNumber extends JsonValue<Double> {
  private static final long serialVersionUID = 3006650913617176985L;

  public JsonNumber(Double value) {
    super(value, "number");
  }

  /**
   * Returns an unformatted representation of this value. If the number is an integer the decimal
   * part and dot will not appear.
   */
  @Override
  public String toString() {
    if (this.value == null)
      return "null";
    if (this.value == Math.floor(this.value))
      return Integer.toString(this.value.intValue());
    return super.toString();
  }
}
