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

import org.junit.Test;

public class JsonNumberTest extends JsonValueTest<Double> {
  public JsonNumberTest() {
    super(1.5, new JsonNumber(1.5), "1.5", JsonEntityType.NUMBER_VALUE, "number");
  }

  @Test
  public void testToStringInteger() {
    testToString("1", new JsonNumber(1d));
  }
}
