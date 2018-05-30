package net.darmo_creations.json.parser;

/* The following code was generated by JFlex 1.6.1 */
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
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by <a href="http://www.jflex.de/">JFlex</a> 1.6.1 from the
 * specification file <tt>parser/json_parser.jflex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {
  /** This character denotes the end of file */
  public static final int YYEOF = -1;
  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;
  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;
  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l ZZ_LEXSTATE[l+1] is the state in
   * the DFA for the lexical state l at the beginning of a line l is of the form l = 2*k, k a non
   * negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 0, 0, 1, 1 };
  /**
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = "\11\0\2\6\2\0\1\6\22\0\1\6\1\0\1\26\10\0\1\5"
      + "\1\14\1\1\1\3\1\30\1\2\11\2\1\13\6\0\4\32\1\4" + "\1\32\24\0\1\11\1\27\1\12\3\0\1\22\1\31\2\32\1\20"
      + "\1\21\5\0\1\23\1\0\1\25\3\0\1\16\1\24\1\15\1\17" + "\5\0\1\7\1\0\1\10\u05e2\0\12\2\206\0\12\2\306\0\12\2"
      + "\u019c\0\12\2\166\0\12\2\166\0\12\2\166\0\12\2\166\0\12\2" + "\166\0\12\2\166\0\12\2\166\0\12\2\166\0\12\2\166\0\12\2"
      + "\140\0\12\2\166\0\12\2\106\0\12\2\u0116\0\12\2\106\0\12\2" + "\u0746\0\12\2\46\0\12\2\u012c\0\12\2\200\0\12\2\246\0\12\2"
      + "\6\0\12\2\266\0\12\2\126\0\12\2\206\0\12\2\6\0\12\2" + "\u89c6\0\12\2\u02a6\0\12\2\46\0\12\2\306\0\12\2\26\0\12\2"
      + "\126\0\12\2\u0196\0\12\2\u5316\0\12\2\u0586\0\12\2\u0bbc\0\12\2" + "\200\0\12\2\74\0\12\2\220\0\12\2\u0116\0\12\2\u01d6\0\12\2"
      + "\u0176\0\12\2\146\0\12\2\u0216\0\12\2\u5176\0\12\2\346\0\12\2"
      + "\u6c74\0\62\2\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\u280f\0";
  /**
   * Translates characters to character classes
   */
  private static final char[] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);
  /**
   * Translates DFA states to action switch labels.
   */
  private static final int[] ZZ_ACTION = zzUnpackAction();
  private static final String ZZ_ACTION_PACKED_0 = "\3\0\1\1\1\2\1\3\1\4\1\5\1\6\1\7" + "\1\10\3\0\1\11\1\12\1\13\6\0\1\14\1\15"
      + "\1\0\1\16\1\17\1\20\1\21\1\22\1\23\1\1" + "\1\0\1\1\4\0\1\24\1\0\1\25\1\0\1\26" + "\1\0\1\27";

  private static int[] zzUnpackAction() {
    int[] result = new int[46];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int[] result) {
    int i = 0; /* index in packed string */
    int j = offset; /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do
        result[j++] = value;
      while (--count > 0);
    }
    return j;
  }

  /**
   * Translates a state to a row index in the transition table
   */
  private static final int[] ZZ_ROWMAP = zzUnpackRowMap();
  private static final String ZZ_ROWMAP_PACKED_0 = "\0\0\0\33\0\66\0\121\0\154\0\207\0\207\0\207"
      + "\0\207\0\207\0\207\0\242\0\275\0\330\0\207\0\207" + "\0\207\0\363\0\u010e\0\u0129\0\u0144\0\u015f\0\u017a\0\207"
      + "\0\207\0\u0195\0\207\0\207\0\207\0\207\0\207\0\207" + "\0\u01b0\0\u01cb\0\u01cb\0\u01e6\0\u0201\0\u021c\0\u0237\0\207"
      + "\0\u0252\0\207\0\u026d\0\207\0\u0288\0\207";

  private static int[] zzUnpackRowMap() {
    int[] result = new int[46];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int[] result) {
    int i = 0; /* index in packed string */
    int j = offset; /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int[] ZZ_TRANS = zzUnpackTrans();
  private static final String ZZ_TRANS_PACKED_0 = "\1\0\1\3\1\4\3\0\1\5\1\6\1\7\1\10" + "\1\11\1\12\1\13\1\14\3\0\1\15\3\0\1\16"
      + "\1\17\4\0\26\20\1\21\1\22\3\20\2\0\1\4" + "\32\0\1\4\1\23\1\24\13\0\1\24\20\0\1\5" + "\75\0\1\25\36\0\1\26\27\0\1\27\30\0\1\30"
      + "\1\31\1\32\1\0\1\33\3\0\1\34\1\35\1\36" + "\1\37\1\40\3\0\1\41\31\0\1\42\1\43\2\0" + "\1\42\44\0\1\44\36\0\1\45\32\0\1\46\11\0"
      + "\1\47\1\0\1\47\13\0\3\47\6\0\2\47\2\0" + "\1\41\1\0\1\24\13\0\1\24\14\0\1\43\50\0" + "\1\50\36\0\1\51\31\0\1\52\11\0\1\53\1\0"
      + "\1\53\13\0\3\53\6\0\2\53\20\0\1\54\14\0" + "\1\55\1\0\1\55\13\0\3\55\6\0\2\55\2\0" + "\1\56\1\0\1\56\13\0\3\56\6\0\2\56";

  private static int[] zzUnpackTrans() {
    int[] result = new int[675];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int[] result) {
    int i = 0; /* index in packed string */
    int j = offset; /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do
        result[j++] = value;
      while (--count > 0);
    }
    return j;
  }

  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;
  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = { "Unknown internal scanner error", "Error: could not match input",
    "Error: pushback value was too large" };
  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int[] ZZ_ATTRIBUTE = zzUnpackAttribute();
  private static final String ZZ_ATTRIBUTE_PACKED_0 = "\3\0\2\1\6\11\3\0\3\11\6\0\2\11\1\0" + "\6\11\1\1\1\0\1\1\4\0\1\11\1\0\1\11"
      + "\1\0\1\11\1\0\1\11";

  private static int[] zzUnpackAttribute() {
    int[] result = new int[46];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int[] result) {
    int i = 0; /* index in packed string */
    int j = offset; /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do
        result[j++] = value;
      while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;
  /** the current state of the DFA */
  private int zzState;
  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;
  /**
   * this buffer contains the current text to be matched and is the source of the yytext() string
   */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];
  /** the textposition at the last accepting state */
  private int zzMarkedPos;
  /** the current text position in the buffer */
  private int zzCurrentPos;
  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;
  /**
   * endRead marks the last character in the buffer, that has been read from input
   */
  private int zzEndRead;
  /** number of newlines encountered up to the start of the matched text */
  private int yyline;
  /** the number of characters up to the start of the matched text */
  @SuppressWarnings("unused")
  private int yychar;
  /**
   * the number of characters from the last newline up to the start of the matched text
   */
  private int yycolumn;
  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;
  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;
  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /**
   * The number of occupied positions in zzBuffer beyond zzEndRead. When a lead/high surrogate has
   * been read from the input stream into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;
  /* user code: */
  private StringBuilder sb = new StringBuilder();

  private Symbol symbol(int type) {
    return new Symbol(type, this.yyline, this.yycolumn);
  }

  private Symbol symbol(int type, Object value) {
    return new Symbol(type, this.yyline, this.yycolumn, value);
  }

  /**
   * Creates a new scanner
   *
   * @param in the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Unpacks the compressed character translation table.
   *
   * @param packed the packed character translation table
   * @return the unpacked character translation table
   */
  private static char[] zzUnpackCMap(String packed) {
    char[] map = new char[0x110000];
    int i = 0; /* index in packed string */
    int j = 0; /* index in unpacked array */
    while (i < 316) {
      int count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do
        map[j++] = value;
      while (--count > 0);
    }
    return map;
  }

  /**
   * Refills the input buffer.
   *
   * @return <code>false</code>, iff there was new input.
   * 
   * @exception java.io.IOException if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    /* first: make room (if you can) */
    if (this.zzStartRead > 0) {
      this.zzEndRead += this.zzFinalHighSurrogate;
      this.zzFinalHighSurrogate = 0;
      System.arraycopy(this.zzBuffer, this.zzStartRead, this.zzBuffer, 0, this.zzEndRead - this.zzStartRead);
      /* translate stored positions */
      this.zzEndRead -= this.zzStartRead;
      this.zzCurrentPos -= this.zzStartRead;
      this.zzMarkedPos -= this.zzStartRead;
      this.zzStartRead = 0;
    }
    /* is the buffer big enough? */
    if (this.zzCurrentPos >= this.zzBuffer.length - this.zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[this.zzBuffer.length * 2];
      System.arraycopy(this.zzBuffer, 0, newBuffer, 0, this.zzBuffer.length);
      this.zzBuffer = newBuffer;
      this.zzEndRead += this.zzFinalHighSurrogate;
      this.zzFinalHighSurrogate = 0;
    }
    /* fill the buffer with new input */
    int requested = this.zzBuffer.length - this.zzEndRead;
    int numRead = this.zzReader.read(this.zzBuffer, this.zzEndRead, requested);
    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      this.zzEndRead += numRead;
      /*
       * If numRead == requested, we might have requested to few chars to encode a full Unicode
       * character. We assume that a Reader would otherwise never return half characters.
       */
      if (numRead == requested) {
        if (Character.isHighSurrogate(this.zzBuffer[this.zzEndRead - 1])) {
          --this.zzEndRead;
          this.zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }
    /* numRead < 0 ==> end of stream */
    return true;
  }

  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    this.zzAtEOF = true; /* indicate end of file */
    this.zzEndRead = this.zzStartRead; /* invalidate buffer */
    if (this.zzReader != null)
      this.zzReader.close();
  }

  /**
   * Resets the scanner to read from a new input stream. Does not close the old reader.
   *
   * All internal variables are reset, the old input stream <b>cannot</b> be reused (internal buffer
   * is discarded and lost). Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader the new input stream
   */
  public final void yyreset(java.io.Reader reader) {
    this.zzReader = reader;
    this.zzAtBOL = true;
    this.zzAtEOF = false;
    this.zzEOFDone = false;
    this.zzEndRead = this.zzStartRead = 0;
    this.zzCurrentPos = this.zzMarkedPos = 0;
    this.zzFinalHighSurrogate = 0;
    this.yyline = this.yychar = this.yycolumn = 0;
    this.zzLexicalState = YYINITIAL;
    if (this.zzBuffer.length > ZZ_BUFFERSIZE)
      this.zzBuffer = new char[ZZ_BUFFERSIZE];
  }

  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return this.zzLexicalState;
  }

  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    this.zzLexicalState = newState;
  }

  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String(this.zzBuffer, this.zzStartRead, this.zzMarkedPos - this.zzStartRead);
  }

  /**
   * Returns the character at position <tt>pos</tt> from the matched text.
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return this.zzBuffer[this.zzStartRead + pos];
  }

  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return this.zzMarkedPos - this.zzStartRead;
  }

  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of yypushback(int) and a match-all fallback
   * rule) this method will only be called with things that "Can't Possibly Happen". If this method
   * is called, something is seriously wrong (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }
    throw new Error(message);
  }

  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *          yylength()!
   */
  public void yypushback(int number) {
    if (number > yylength())
      zzScanError(ZZ_PUSHBACK_2BIG);
    this.zzMarkedPos -= number;
  }

  /**
   * Contains user EOF-code, which will be executed exactly once, when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!this.zzEOFDone) {
      this.zzEOFDone = true;
      yyclose();
    }
  }

  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token
   * @exception java.io.IOException if any I/O-Error occurs
   */
  @Override
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;
    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = this.zzEndRead;
    char[] zzBufferL = this.zzBuffer;
    char[] zzCMapL = ZZ_CMAP;
    int[] zzTransL = ZZ_TRANS;
    int[] zzRowMapL = ZZ_ROWMAP;
    int[] zzAttrL = ZZ_ATTRIBUTE;
    while (true) {
      zzMarkedPosL = this.zzMarkedPos;
      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = this.zzStartRead; zzCurrentPosL < zzMarkedPosL; zzCurrentPosL += zzCharCount) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
          case '\u000B':
          case '\u000C':
          case '\u0085':
          case '\u2028':
          case '\u2029':
            this.yyline++;
            this.yycolumn = 0;
            zzR = false;
            break;
          case '\r':
            this.yyline++;
            this.yycolumn = 0;
            zzR = true;
            break;
          case '\n':
            if (zzR)
              zzR = false;
            else {
              this.yyline++;
              this.yycolumn = 0;
            }
            break;
          default:
            zzR = false;
            this.yycolumn += zzCharCount;
        }
      }
      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (this.zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = this.zzEndRead;
          zzMarkedPosL = this.zzMarkedPos;
          zzBufferL = this.zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek)
          this.yyline--;
      }
      zzAction = -1;
      zzCurrentPosL = this.zzCurrentPos = this.zzStartRead = zzMarkedPosL;

      this.zzState = ZZ_LEXSTATE[this.zzLexicalState];
      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[this.zzState];
      if ((zzAttributes & 1) == 1) {
        zzAction = this.zzState;
      }
      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (this.zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            this.zzCurrentPos = zzCurrentPosL;
            this.zzMarkedPos = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL = this.zzCurrentPos;
            zzMarkedPosL = this.zzMarkedPos;
            zzBufferL = this.zzBuffer;
            zzEndReadL = this.zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[zzRowMapL[this.zzState] + zzCMapL[zzInput]];
          if (zzNext == -1)
            break zzForAction;
          this.zzState = zzNext;
          zzAttributes = zzAttrL[this.zzState];
          if ((zzAttributes & 1) == 1) {
            zzAction = this.zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ((zzAttributes & 8) == 8)
              break zzForAction;
          }
        }
      }
      // store back cached position
      this.zzMarkedPos = zzMarkedPosL;
      if (zzInput == YYEOF && this.zzStartRead == this.zzCurrentPos) {
        this.zzAtEOF = true;
        zzDoEOF();
        {
          return new java_cup.runtime.Symbol(Tokens.EOF);
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: {
            return symbol(Tokens.NUMBER, Double.parseDouble(yytext()));
          }
          case 24:
            break;
          case 2: { /* ignored */
          }
          case 25:
            break;
          case 3: {
            return symbol(Tokens.LCURLY);
          }
          case 26:
            break;
          case 4: {
            return symbol(Tokens.RCURLY);
          }
          case 27:
            break;
          case 5: {
            return symbol(Tokens.LBRACKET);
          }
          case 28:
            break;
          case 6: {
            return symbol(Tokens.RBRACKET);
          }
          case 29:
            break;
          case 7: {
            return symbol(Tokens.COLON);
          }
          case 30:
            break;
          case 8: {
            return symbol(Tokens.COMMA);
          }
          case 31:
            break;
          case 9: {
            this.sb.setLength(0);
            yybegin(STRING);
          }
          case 32:
            break;
          case 10: {
            if (Character.isISOControl(yytext().charAt(0)))
              throw new JsonParseException("Control characters are not allowed in strings!");
            this.sb.append(yytext());
          }
          case 33:
            break;
          case 11: {
            yybegin(YYINITIAL);
            return symbol(Tokens.STRING, this.sb.toString());
          }
          case 34:
            break;
          case 12: {
            this.sb.append("\t");
          }
          case 35:
            break;
          case 13: {
            this.sb.append("\r");
          }
          case 36:
            break;
          case 14: {
            this.sb.append("\f");
          }
          case 37:
            break;
          case 15: {
            this.sb.append("\n");
          }
          case 38:
            break;
          case 16: {
            this.sb.append("\"");
          }
          case 39:
            break;
          case 17: {
            this.sb.append("\\");
          }
          case 40:
            break;
          case 18: {
            this.sb.append("/");
          }
          case 41:
            break;
          case 19: {
            this.sb.append("\b");
          }
          case 42:
            break;
          case 20: {
            return symbol(Tokens.BOOLEAN, true);
          }
          case 43:
            break;
          case 21: {
            return symbol(Tokens.NULL);
          }
          case 44:
            break;
          case 22: {
            return symbol(Tokens.BOOLEAN, false);
          }
          case 45:
            break;
          case 23: {
            this.sb.append((char) Integer.parseInt(yytext().substring(2), 16));
          }
          case 46:
            break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }
}
