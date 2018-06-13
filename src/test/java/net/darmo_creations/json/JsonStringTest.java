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

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JsonStringTest extends JsonValueTest<String> {
  public JsonStringTest() {
    super("Test", new JsonString("Test"), "\"Test\"", JsonEntityType.STRING_VALUE, "string");
  }

  @Test
  public void testEscapeQuote() {
    testEscape("\"", "\\\"");
  }

  @Test
  public void testEscapeBackSolidus() {
    testEscape("\\", "\\\\");
  }

  @Test
  public void testEscapeBackSpace() {
    testEscape("\b", "\\b");
  }

  @Test
  public void testEscapeFormFeed() {
    testEscape("\f", "\\f");
  }

  @Test
  public void testEscapeNewLine() {
    testEscape("\n", "\\n");
  }

  @Test
  public void testEscapeCarriageReturn() {
    testEscape("\r", "\\r");
  }

  @Test
  public void testEscapeTab() {
    testEscape("\t", "\\t");
  }

  @Test
  public void testEscapeControls() {
    List<Character> controls = new ArrayList<>();

    // Control characters from 0x0 to 0x1f except those in the methods above
    for (char c = '\u0000'; c <= '\u001f'; c++) {
      if (c != '\b' && c != '\f' && c != '\n' && c != '\r' && c != '\t')
        controls.add(c);
    }
    // Control characters from 0x7f to 0x9f
    for (char c = '\u007f'; c <= '\u009f'; c++)
      controls.add(c);

    for (char c : controls)
      testEscape(String.valueOf(c), String.format("\\u%04X", (int) c));
  }

  private void testEscape(String value, String expected) {
    assertEquals("\"" + expected + "\"", new JsonString(value).toString());
  }
}
