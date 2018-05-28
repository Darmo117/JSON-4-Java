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
