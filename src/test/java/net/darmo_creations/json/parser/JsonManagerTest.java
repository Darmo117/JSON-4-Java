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
package net.darmo_creations.json.parser;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import net.darmo_creations.json.JsonArray;
import net.darmo_creations.json.JsonBoolean;
import net.darmo_creations.json.JsonEntity;
import net.darmo_creations.json.JsonNull;
import net.darmo_creations.json.JsonNumber;
import net.darmo_creations.json.JsonObject;
import net.darmo_creations.json.JsonString;

public class JsonManagerTest {
  private static final Map<String, JsonEntity> TESTS;

  static {
    TESTS = new HashMap<>();
    TESTS.put("{\"key\": \"value\"}", getObject(new JsonString("value")));
    TESTS.put("{\"key\": 1}", getObject(new JsonNumber(1)));
    TESTS.put("{\"key\": 1.0}", getObject(new JsonNumber(1)));
    TESTS.put("{\"key\": -1}", getObject(new JsonNumber(-1)));
    TESTS.put("{\"key\": -1.0}", getObject(new JsonNumber(-1)));
    TESTS.put("{\"key\": 1.2}", getObject(new JsonNumber(1.2)));
    TESTS.put("{\"key\": -1.2}", getObject(new JsonNumber(-1.2)));
    TESTS.put("{\"key\": 1e2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": 1.0e2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": -1e2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": -1.0e2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": 1.2e2}", getObject(new JsonNumber(120)));
    TESTS.put("{\"key\": -1.2e2}", getObject(new JsonNumber(-120)));
    TESTS.put("{\"key\": 1e+2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": 1.0e+2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": -1e+2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": -1.0e+2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": 1.2e+2}", getObject(new JsonNumber(120)));
    TESTS.put("{\"key\": -1.2e+2}", getObject(new JsonNumber(-120)));
    TESTS.put("{\"key\": 1e-2}", getObject(new JsonNumber(0.01)));
    TESTS.put("{\"key\": 1.0e-2}", getObject(new JsonNumber(0.01)));
    TESTS.put("{\"key\": -1e-2}", getObject(new JsonNumber(-0.01)));
    TESTS.put("{\"key\": -1.0e-2}", getObject(new JsonNumber(-0.01)));
    TESTS.put("{\"key\": 1.2e-2}", getObject(new JsonNumber(0.012)));
    TESTS.put("{\"key\": -1.2e-2}", getObject(new JsonNumber(-0.012)));
    TESTS.put("{\"key\": 1E2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": 1.0E2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": -1E2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": -1.0E2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": 1.2E2}", getObject(new JsonNumber(120)));
    TESTS.put("{\"key\": -1.2E2}", getObject(new JsonNumber(-120)));
    TESTS.put("{\"key\": 1E+2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": 1.0E+2}", getObject(new JsonNumber(100)));
    TESTS.put("{\"key\": -1E+2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": -1.0E+2}", getObject(new JsonNumber(-100)));
    TESTS.put("{\"key\": 1.2E+2}", getObject(new JsonNumber(120)));
    TESTS.put("{\"key\": -1.2E+2}", getObject(new JsonNumber(-120)));
    TESTS.put("{\"key\": 1E-2}", getObject(new JsonNumber(0.01)));
    TESTS.put("{\"key\": 1.0E-2}", getObject(new JsonNumber(0.01)));
    TESTS.put("{\"key\": -1E-2}", getObject(new JsonNumber(-0.01)));
    TESTS.put("{\"key\": -1.0E-2}", getObject(new JsonNumber(-0.01)));
    TESTS.put("{\"key\": 1.2E-2}", getObject(new JsonNumber(0.012)));
    TESTS.put("{\"key\": -1.2E-2}", getObject(new JsonNumber(-0.012)));
    JsonObject o = new JsonObject();
    JsonArray a = new JsonArray();
    a.add(new JsonNumber(1d));
    a.add(new JsonNumber(2d));
    a.add(new JsonString("a"));
    JsonObject o2 = new JsonObject();
    o2.put("b", new JsonBoolean(true));
    a.add(o2);
    o.put("key", a);
    o.put("c", new JsonNull());
    TESTS.put("{\"key\": [1, 2, \"a\", {\"b\": true}], \"c\": null}", o);
  }

  private static JsonObject getObject(JsonEntity value) {
    JsonObject o = new JsonObject();
    o.put("key", value);
    return o;
  }

  @Test
  public void testCorrect() {
    for (Map.Entry<String, JsonEntity> entry : TESTS.entrySet()) {
      assertEquals(entry.getKey(), entry.getValue(), JsonManager.parse(entry.getKey()));
    }
  }

  @Test(expected = JsonParseException.class)
  public void testIncorrect() {
    JsonManager.parse("{]");
  }

  @Test(expected = JsonParseException.class)
  public void testIllegalCharacter() {
    JsonManager.parse("{\"a\":&}");
  }
}
