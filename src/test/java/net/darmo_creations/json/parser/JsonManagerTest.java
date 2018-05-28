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

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class JsonManagerTest {
  @Test
  public void testCorrect() throws IOException {
    List<String> lines = Files.readAllLines(Paths.get("src/test/java/net/darmo_creations/json/parser/correct.txt"));

    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);
      // Ignore comments
      if (!line.trim().startsWith("#") && !line.trim().isEmpty()) {
        String[] values = line.split(";");
        assertEquals("Line " + (i + 1), values[0], JsonManager.parse(values[1]).toString());
      }
    }
  }
  // TODO ass tests for incorrect inputs
}
