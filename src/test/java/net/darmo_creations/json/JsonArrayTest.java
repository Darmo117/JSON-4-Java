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

import static org.junit.Assert.*;

import org.junit.Test;

public class JsonArrayTest {
  @Test
  public void testNotIsArray() {
    assertTrue(new JsonArray().isArray());
  }

  @Test
  public void testNotIsObject() {
    assertFalse(new JsonArray().isObject());
  }

  @Test
  public void testNotIsValue() {
    assertFalse(new JsonArray().isValue());
  }

  @Test
  public void testGetObject() {
    testGet(new JsonObject(), ObjectType.OBJECT);
  }

  @Test
  public void testGetArray() {
    testGet(new JsonArray(), ObjectType.ARRAY);
  }

  @Test
  public void testGetValue() {
    testGet(new JsonValue(1.5), ObjectType.VALUE);
  }

  @Test(expected = ClassCastException.class)
  public void testGetObjectError() {
    testGet(new JsonValue(1.5), ObjectType.OBJECT);
  }

  @Test(expected = ClassCastException.class)
  public void testGetArrayError() {
    testGet(new JsonObject(), ObjectType.ARRAY);
  }

  @Test(expected = ClassCastException.class)
  public void testGetValueError() {
    testGet(new JsonArray(), ObjectType.VALUE);;
  }

  private void testGet(JsonEntity object, ObjectType<?> type) {
    JsonArray a = new JsonArray();
    a.add(object);
    assertNotNull(a.getAs(0, type));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetIndexNotExists() {
    JsonArray a = new JsonArray();
    a.add(new JsonObject());
    assertNull(a.getAs(1, ObjectType.OBJECT));
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void testGetEmpty() {
    assertNull(new JsonArray().getAs(0, ObjectType.OBJECT));
  }

  @Test
  public void testEquals() {
    JsonArray a1 = new JsonArray();
    a1.add(new JsonObject());
    a1.add(new JsonArray());
    a1.add(new JsonValue(1.5));
    JsonArray a2 = new JsonArray();
    a2.add(new JsonObject());
    a2.add(new JsonArray());
    a2.add(new JsonValue(1.5));
    assertEquals(a1, a2);
    assertEquals(a1.hashCode(), a2.hashCode());
  }

  @Test
  public void testToString() {
    JsonArray a = new JsonArray();
    a.add(new JsonObject());
    a.add(new JsonArray());
    a.add(new JsonValue(1.5));
    assertEquals("[{},[],1.5]", a.toString());
  }
}
