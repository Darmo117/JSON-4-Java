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

/**
 * This exception indicates that an error occured while parsing a JSON string.
 *
 * @author Damien Vergnet
 */
public class JsonParseException extends RuntimeException {
  private static final long serialVersionUID = 1687685075367161391L;

  public JsonParseException(String message) {
    super(message);
  }

  public JsonParseException(Throwable cause) {
    super(cause);
  }

  public JsonParseException(String message, Throwable cause) {
    super(message, cause);
  }

  public JsonParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
