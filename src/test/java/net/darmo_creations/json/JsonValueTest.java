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

import net.darmo_creations.json.parser.JsonManager;

public class JsonValueTest {
  @Test
  public void testString() {
    assertEquals("Test", getValue("\"Test\"").getValue());
  }

  @Test
  public void testNumber() {
    assertEquals(1.5, (Double) getValue("1.5").getValue(), 1e-4);
  }

  @Test
  public void testBooleanTrue() {
    assertEquals(true, getValue("true").getValue());
  }

  @Test
  public void testBooleanFalse() {
    assertEquals(false, getValue("false").getValue());
  }

  @Test
  public void testNull() {
    JsonValue<?> v = getValue("null");
    assertTrue(v.isNull());
    assertNull(v.getValue());
  }

  @Test
  public void testNotNull() {
    JsonValue<?> v = getValue("\"Test\"");
    assertFalse(v.isNull());
    assertNotNull(v.getValue());
  }

  @Test
  public void testClassString() {
    assertEquals(String.class, getValue("\"Test\"").getType());
  }

  @Test
  public void testClassNumber() {
    assertEquals(Double.class, getValue("1.5").getType());
  }

  @Test
  public void testClassBoolean() {
    assertEquals(Boolean.class, getValue("true").getType());
  }

  @Test
  public void testClassNull() {
    assertNull(getValue("null").getType());
  }

  @Test
  public void testEqualsString() {
    testEquals(new JsonString("Test"), "\"Test\"");
  }

  @Test
  public void testEqualsNumber() {
    testEquals(new JsonNumber(1.5), "1.5");
  }

  @Test
  public void testEqualsBooleanTrue() {
    testEquals(new JsonBoolean(true), "true");
  }

  @Test
  public void testEqualsBooleanFalse() {
    testEquals(new JsonBoolean(false), "false");
  }

  @Test
  public void testEqualsNull() {
    testEquals(new JsonNull(), "null");
  }

  @Test
  public void testToStringString() {
    testToString("\"Test\"", new JsonString("Test"));
  }

  @Test
  public void testToStringInteger() {
    testToString("1", new JsonNumber(1.0));
  }

  @Test
  public void testToStringStrinDouble() {
    testToString("1.5", new JsonNumber(1.5));
  }

  @Test
  public void testToStringBooleanTrue() {
    testToString("true", new JsonBoolean(true));
  }

  @Test
  public void testToStringBooleanFalse() {
    testToString("false", new JsonBoolean(false));
  }

  @Test
  public void testToStringNull() {
    testToString("null", new JsonNull());
  }

  private void testEquals(JsonValue<?> expected, String jsonValue) {
    JsonValue<?> actual = getValue(jsonValue);
    assertEquals(expected, actual);
    assertEquals(expected.hashCode(), actual.hashCode());
  }

  private void testToString(String expected, JsonValue<?> value) {
    assertEquals(expected, value.toString());
  }

  private JsonValue<?> getValue(String jsonValue) {
    return JsonManager.parse("{\"key\":" + jsonValue + "}").getAs("key", JsonEntityType.VALUE);
  }
}
