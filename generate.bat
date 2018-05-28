@echo off

set fname=json_parser
set package=net.darmo_creations.json.parser
set dir=src\main\java\%package:.=\%\
set symbols=Tokens

java -jar libs\jflex-1.6.1.jar parser\%fname%.jflex -d %dir%
java -jar libs\java-cup-11a.jar -package %package% -symbols %symbols% -parser Parser perser\%fname%.cup
rem Move Parser.java and Tokens.java
move *.java %dir%
rem Delete backup file Lexer.java~
del %dir%*.java~

cd %dir%

set lexer_file=Lexer.java

rem Add package at lexer file start
echo package %package%;> tmp.txt
type %lexer_file% >> tmp.txt
del %lexer_file%
ren tmp.txt %lexer_file%

rem Replace 'sym' class by 'symbols' variable value
set search=sym.
set replace=%symbols%.

for /f "delims=" %%i in ('type "%lexer_file%" ^& break ^> "%lexer_file%" ') do (
  set line=%%i
  setlocal enabledelayedexpansion
  >>"%lexer_file%" echo(!line:%search%=%replace%!
  endlocal
)
