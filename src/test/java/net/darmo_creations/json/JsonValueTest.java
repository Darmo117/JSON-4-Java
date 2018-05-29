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

public abstract class JsonValueTest<T> {
  private T expectedValue;
  private JsonValue<T> expectedEntity;
  private String json;

  public JsonValueTest(T expectedValue, JsonValue<T> expectedEntity, String json) {
    this.expectedValue = expectedValue;
    this.expectedEntity = expectedEntity;
    this.json = json;
  }

  @Test
  public void testValue() {
    assertEquals(this.expectedValue, getValue(this.json).get());
  }

  @Test
  public void testEquals() {
    testEquals(this.expectedEntity, this.json);
  }

  @Test
  public void testToString() {
    testToString(this.json, this.expectedEntity);
  }

  @Test
  public void testNullity() {
    if (this.expectedValue == null) {
      assertTrue(this.expectedEntity.isNull());
      assertNull(this.expectedEntity.get());
    }
    else {
      assertFalse(this.expectedEntity.isNull());
      assertNotNull(this.expectedEntity.get());
    }
  }

  protected void testEquals(JsonValue<?> expected, String jsonValue) {
    JsonValue<?> actual = getValue(jsonValue);
    assertEquals(expected, actual);
    assertEquals(expected.hashCode(), actual.hashCode());
  }

  protected void testToString(String expected, JsonValue<?> value) {
    assertEquals(expected, value.toString());
  }

  protected JsonValue<?> getValue(String jsonValue) {
    return JsonManager.parse("{\"key\":" + jsonValue + "}").getAs("key", JsonEntityType.VALUE);
  }
}
