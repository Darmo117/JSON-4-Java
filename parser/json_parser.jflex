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
import java_cup.runtime.*;

%%

%class Lexer
%unicode
%cup
%line
%column

%{
  private StringBuilder sb = new StringBuilder();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
%}

Number = -?(0|\d+(\.?\d+)?)([eE][+-]?\d+)?
WhiteSpace = [ \t\n\r]+

%state STRING

%%

<YYINITIAL> {
  "{"           { return symbol(Tokens.LCURLY); }
  "}"           { return symbol(Tokens.RCURLY); }
  "["           { return symbol(Tokens.LBRACKET); }
  "]"           { return symbol(Tokens.RBRACKET); }
  ":"           { return symbol(Tokens.COLON); }
  ","           { return symbol(Tokens.COMMA); }
  "true"        { return symbol(Tokens.BOOLEAN, true); }
  "false"       { return symbol(Tokens.BOOLEAN, false); }
  "null"        { return symbol(Tokens.NULL); }
  \" /*"*/      { sb.setLength(0); yybegin(STRING); }
  {Number}      { return symbol(Tokens.NUMBER, Double.parseDouble(yytext())); }
  {WhiteSpace}  { /* ignored */ }
}

<STRING> {
  \"   /*"*/        { yybegin(YYINITIAL); return symbol(Tokens.STRING, sb.toString()); }
  \\\" /*"*/        { sb.append("\""); }
  \\\\              { sb.append("\\"); }
  \\\               { sb.append("/"); }
  \\b               { sb.append("\b"); }
  \\f               { sb.append("\f"); }
  \\n               { sb.append("\n"); }
  \\r               { sb.append("\r"); }
  \\t               { sb.append("\t"); }
  \\u[\dA-Fa-f]{4}  { sb.append((char) Integer.parseInt(yytext().substring(2), 16)); }
  .                 { sb.append(yytext()); }
}
