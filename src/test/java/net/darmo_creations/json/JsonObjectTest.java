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

import java.util.NoSuchElementException;

import org.junit.Test;

public class JsonObjectTest {
  @Test
  public void testGetObject() {
    testGet(new JsonObject(), JsonEntityType.OBJECT);
  }

  @Test
  public void testGetArray() {
    testGet(new JsonArray(), JsonEntityType.ARRAY);
  }

  @Test
  public void testGetValue() {
    testGet(new JsonNumber(1.5), JsonEntityType.VALUE);
  }

  @Test(expected = ClassCastException.class)
  public void testGetObjectError() {
    testGet(new JsonNumber(1.5), JsonEntityType.OBJECT);
  }

  @Test(expected = ClassCastException.class)
  public void testGetArrayError() {
    testGet(new JsonObject(), JsonEntityType.ARRAY);
  }

  @Test(expected = ClassCastException.class)
  public void testGetValueError() {
    testGet(new JsonArray(), JsonEntityType.VALUE);
  }

  private void testGet(JsonEntity object, JsonEntityType<?> type) {
    JsonObject o = new JsonObject();
    o.put("a", object);
    assertNotNull(o.getAs("a", type));
  }

  @Test(expected = NoSuchElementException.class)
  public void testGetKeyNotExists() {
    JsonObject o = new JsonObject();
    o.put("a", new JsonObject());
    o.getAs("b", JsonEntityType.OBJECT);
  }

  @Test(expected = NoSuchElementException.class)
  public void testGetEmpty() {
    new JsonObject().getAs("a", JsonEntityType.OBJECT);
  }

  @Test
  public void testEquals() {
    JsonObject o1 = new JsonObject();
    o1.put("a", new JsonArray());
    o1.put("b", new JsonObject());
    o1.put("c", new JsonNumber(1.5));
    JsonObject o2 = new JsonObject();
    o2.put("c", new JsonNumber(1.5));
    o2.put("b", new JsonObject());
    o2.put("a", new JsonArray());
    assertEquals(o1, o2);
    assertEquals(o1.hashCode(), o2.hashCode());
  }

  @Test
  public void testToString() {
    JsonObject o = new JsonObject();
    o.put("a", new JsonObject());
    assertEquals("{\"a\":{}}", o.toString());
  }
}
