package main.analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import main.excepciones.Errores;

%%

%{
    public LinkedList<Errores> listaErrores = new LinkedList<>();

    public LinkedList<Errores> getErrores(){
        return listaErrores;
    }
%}

%init{
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
%init}

%cup 
%class scanner
%public 
%line 
%char 
%column
%full
%ignorecase

// SIMBOLOS
PAR1="("
PAR2=")"
MAS="+"
MENOS="-"
IGUAL="="
MENOR= "<"
MAYOR= ">"
POR="*"
DIVI="/"
OR="||"
AND="&&"
DIFER="!"
FINCADENA=";"
LLAVEA="{"
LLAVEC="}"
CORCHEA="["
CORCHEC="]"
DOSPTS=":"
COMID="\""
//COMIS= "\'"

//CC = HTML 
CC="C_CC"
HEAD="C_HEAD"
TITLE="C_TITLE"
LINK="C_LINK"
BODY="C_BODY"
SPAM="C_SPAM"
INPUT="C_INPUT"
TEXTAREA="C_TEXTAREA"
SELECT="C_SELECT"
OPTION="C_OPTION"
DIV="C_DIV"
IMG="C_IMG"
BR="C_BR"
BUTTON="C_BUTTON"
TITUH="C_H1"
PARRA="C_P"
SCRIPT="C_SCRIPTING"

//PARAMETROS
HREF="href"
BACKG="background"
COLOR="color"
FONTSI="font-size"
FONTFA="font-family"
TEXTALI="text-align"
TYPE="type"

// VALORES
ID="id"
NAME="name"
COLS="cols"
ROWS="rows"
CLASS="class"
SRC="src"
WIDTH="width"
HEIGHT="height"
ALT="alt"
ONCLICK="onclick"

// FUNCIONES CLC
ASC="ASC"
DESC="DESC"
LETPAR="LETPAR"
LETIMPAR="LETIMPAR"
REVERSE="REVERSE"
CARALE="CARACTER_ALEATORIO"
NUMALE="NUM_ALEATORIO"
ALEINF="ALERT_INFO"
EXIT="EXIT"
REDIRECT="REDIRECT"

// DECLARACIONES
INTERGER="integer"
BOOLEAN="boolean"
STRING="string"
DECIMAL="decimal"
CHAR="char"
TRUE="true"
FALSE="false"

// INSTRUCCIONES
INIT="INIT"
END="END"
INSERT="INSERT"

// SETENCIAS
IF="IF"
THEN="THEN"
ELSE="ELSE"

// CICLO
REPEAT="REPEAT"
HUNTIL="HUNTIL"
WHILE="WHILE"
THENWHILE="THENWHILE"

// EXPRESIONES REGULARES 
BLANCOS=[\ \r\t\f\n]+
ENTERO=[0-9]+
DECI=[0-9]+"."[0-9]+
IDENTIFICADOR=[-_a-zA-Z]+[a-zA-Z0-9_]*
VALOR=[a-zA-Z0-9_]+
COMENTARIO_LINEA="!!".*\\n
COMENTARIO_MULTI="<!--" [^>]* "-->"


%%
// SIMBOLOS
<YYINITIAL> {PAR1} {return new Symbol(sym.PAR1, yyline, yycolumn,yytext());}
<YYINITIAL> {PAR2} {return new Symbol(sym.PAR2, yyline, yycolumn,yytext());}
<YYINITIAL> {MAS} {return new Symbol(sym.MAS, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOS} {return new Symbol(sym.MENOS, yyline, yycolumn,yytext());}
<YYINITIAL> {IGUAL} {return new Symbol(sym.IGUAL, yyline, yycolumn,yytext());}
<YYINITIAL> {MENOR} {return new Symbol(sym.MENOR, yyline, yycolumn,yytext());}
<YYINITIAL> {MAYOR} {return new Symbol(sym.MAYOR, yyline, yycolumn,yytext());}
<YYINITIAL> {POR} {return new Symbol(sym.POR, yyline, yycolumn,yytext());}
<YYINITIAL> {DIVI} {return new Symbol(sym.DIVI, yyline, yycolumn,yytext());}
<YYINITIAL> {OR} {return new Symbol(sym.OR, yyline, yycolumn,yytext());}
<YYINITIAL> {AND} {return new Symbol(sym.AND, yyline, yycolumn,yytext());}
<YYINITIAL> {DIFER} {return new Symbol(sym.DIFER, yyline, yycolumn,yytext());}
<YYINITIAL> {FINCADENA} {return new Symbol(sym.FINCADENA, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAVEA} {return new Symbol(sym.LLAVEA, yyline, yycolumn,yytext());}
<YYINITIAL> {LLAVEC} {return new Symbol(sym.LLAVEC, yyline, yycolumn,yytext());}
<YYINITIAL> {CORCHEA} {return new Symbol(sym.CORCHEA, yyline, yycolumn,yytext());}
<YYINITIAL> {CORCHEC} {return new Symbol(sym.CORCHEC, yyline, yycolumn,yytext());}
<YYINITIAL> {DOSPTS} {return new Symbol(sym.DOSPTS, yyline, yycolumn,yytext());}
<YYINITIAL> {COMID} {return new Symbol(sym.COMID, yyline, yycolumn,yytext());}
// CC = HTML
<YYINITIAL> {CC} {return new Symbol(sym.CC, yyline, yycolumn,yytext());}
<YYINITIAL> {HEAD} {return new Symbol(sym.HEAD, yyline, yycolumn,yytext());}
<YYINITIAL> {TITLE} {return new Symbol(sym.TITLE, yyline, yycolumn,yytext());}
<YYINITIAL> {LINK} {return new Symbol(sym.LINK, yyline, yycolumn,yytext());}
<YYINITIAL> {BODY} {return new Symbol(sym.BODY, yyline, yycolumn,yytext());}
<YYINITIAL> {SPAM} {return new Symbol(sym.SPAM, yyline, yycolumn,yytext());}
<YYINITIAL> {INPUT} {return new Symbol(sym.INPUT, yyline, yycolumn,yytext());}
<YYINITIAL> {TEXTAREA} {return new Symbol(sym.TEXTAREA, yyline, yycolumn,yytext());}
<YYINITIAL> {SELECT} {return new Symbol(sym.SELECT, yyline, yycolumn,yytext());}
<YYINITIAL> {OPTION} {return new Symbol(sym.OPTION, yyline, yycolumn,yytext());}
<YYINITIAL> {DIV} {return new Symbol(sym.DIV, yyline, yycolumn,yytext());}
<YYINITIAL> {IMG} {return new Symbol(sym.IMG, yyline, yycolumn,yytext());}
<YYINITIAL> {BR} {return new Symbol(sym.BR, yyline, yycolumn,yytext());}
<YYINITIAL> {BUTTON} {return new Symbol(sym.BUTTON, yyline, yycolumn,yytext());}
<YYINITIAL> {TITUH} {return new Symbol(sym.TITUH, yyline, yycolumn,yytext());}
<YYINITIAL> {PARRA} {return new Symbol(sym.PARRA, yyline, yycolumn,yytext());}
<YYINITIAL> {SCRIPT} {return new Symbol(sym.SCRIPT, yyline, yycolumn,yytext());}
// PARAMETROS
<YYINITIAL> {HREF} {return new Symbol(sym.HREF, yyline, yycolumn,yytext());}
<YYINITIAL> {BACKG} {return new Symbol(sym.BACKG, yyline, yycolumn,yytext());}
<YYINITIAL> {COLOR} {return new Symbol(sym.COLOR, yyline, yycolumn,yytext());}
<YYINITIAL> {FONTSI} {return new Symbol(sym.FONTSI, yyline, yycolumn,yytext());}
<YYINITIAL> {FONTFA} {return new Symbol(sym.FONTFA, yyline, yycolumn,yytext());}
<YYINITIAL> {TEXTALI} {return new Symbol(sym.TEXTALI, yyline, yycolumn,yytext());}
<YYINITIAL> {TYPE} {return new Symbol(sym.TYPE, yyline, yycolumn,yytext());}
// VALORES
<YYINITIAL> {ID} {return new Symbol(sym.ID, yyline, yycolumn,yytext());}
<YYINITIAL> {NAME} {return new Symbol(sym.NAME, yyline, yycolumn,yytext());}
<YYINITIAL> {COLS} {return new Symbol(sym.COLS, yyline, yycolumn,yytext());}
<YYINITIAL> {ROWS} {return new Symbol(sym.ROWS, yyline, yycolumn,yytext());}
<YYINITIAL> {CLASS} {return new Symbol(sym.CLASS, yyline, yycolumn,yytext());}
<YYINITIAL> {SRC} {return new Symbol(sym.SRC, yyline, yycolumn,yytext());}
<YYINITIAL> {WIDTH} {return new Symbol(sym.WIDTH, yyline, yycolumn,yytext());}
<YYINITIAL> {HEIGHT} {return new Symbol(sym.HEIGHT, yyline, yycolumn,yytext());}
<YYINITIAL> {ALT} {return new Symbol(sym.ALT, yyline, yycolumn,yytext());}
<YYINITIAL> {ONCLICK} {return new Symbol(sym.ONCLICK, yyline, yycolumn,yytext());}
// FUNCIONES CLC
<YYINITIAL> {ASC} {return new Symbol(sym.ASC, yyline, yycolumn,yytext());}
<YYINITIAL> {DESC} {return new Symbol(sym.DESC, yyline, yycolumn,yytext());}
<YYINITIAL> {LETPAR} {return new Symbol(sym.LETPAR, yyline, yycolumn,yytext());}
<YYINITIAL> {LETIMPAR} {return new Symbol(sym.LETIMPAR, yyline, yycolumn,yytext());}
<YYINITIAL> {REVERSE} {return new Symbol(sym.REVERSE, yyline, yycolumn,yytext());}
<YYINITIAL> {CARALE} {return new Symbol(sym.CARALE, yyline, yycolumn,yytext());}
<YYINITIAL> {NUMALE} {return new Symbol(sym.NUMALE, yyline, yycolumn,yytext());}
<YYINITIAL> {ALEINF} {return new Symbol(sym.ALEINF, yyline, yycolumn,yytext());}
<YYINITIAL> {EXIT} {return new Symbol(sym.EXIT, yyline, yycolumn,yytext());}
<YYINITIAL> {REDIRECT} {return new Symbol(sym.REDIRECT, yyline, yycolumn,yytext());}
// DECLARACIONES
<YYINITIAL> {INTERGER} {return new Symbol(sym.INTERGER, yyline, yycolumn,yytext());}
<YYINITIAL> {BOOLEAN} {return new Symbol(sym.BOOLEAN, yyline, yycolumn,yytext());}
<YYINITIAL> {STRING} {return new Symbol(sym.STRING, yyline, yycolumn,yytext());}
<YYINITIAL> {DECIMAL} {return new Symbol(sym.DECIMAL, yyline, yycolumn,yytext());}
<YYINITIAL> {CHAR} {return new Symbol(sym.CHAR, yyline, yycolumn,yytext());}
<YYINITIAL> {TRUE} {return new Symbol(sym.TRUE, yyline, yycolumn,yytext());}
<YYINITIAL> {FALSE} {return new Symbol(sym.FALSE, yyline, yycolumn,yytext());}
// INSTRUCCIONES
<YYINITIAL> {INIT} {return new Symbol(sym.INIT, yyline, yycolumn,yytext());}
<YYINITIAL> {END} {return new Symbol(sym.END, yyline, yycolumn,yytext());}
<YYINITIAL> {INSERT} {return new Symbol(sym.INSERT, yyline, yycolumn,yytext());}
// SETENCIAS
<YYINITIAL> {IF} {return new Symbol(sym.IF, yyline, yycolumn,yytext());}
<YYINITIAL> {THEN} {return new Symbol(sym.THEN, yyline, yycolumn,yytext());}
<YYINITIAL> {ELSE} {return new Symbol(sym.ELSE, yyline, yycolumn,yytext());}
// CICLO
<YYINITIAL> {REPEAT} {return new Symbol(sym.REPEAT, yyline, yycolumn,yytext());}
<YYINITIAL> {HUNTIL} {return new Symbol(sym.HUNTIL, yyline, yycolumn,yytext());}
<YYINITIAL> {WHILE} {return new Symbol(sym.WHILE, yyline, yycolumn,yytext());}
<YYINITIAL> {THENWHILE} {return new Symbol(sym.THENWHILE, yyline, yycolumn,yytext());}
// EXPRESIONES REGULARES
<YYINITIAL> {ENTERO} {return new Symbol(sym.ENTERO, yyline, yycolumn,yytext());}
<YYINITIAL> {DECI} {return new Symbol(sym.DECI, yyline, yycolumn,yytext());}
<YYINITIAL> {IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR, yyline, yycolumn,yytext());}
<YYINITIAL> {VALOR} {return new Symbol(sym.VALOR, yyline, yycolumn,yytext());}

<YYINITIAL> {BLANCOS} {}
<YYINITIAL> {COMENTARIO_LINEA} {}
<YYINITIAL> {COMENTARIO_MULTI} {}

<YYINITIAL> . {
                listaErrores.add(new Errores("LEXICO","El caracter "+
                yytext() + " No pertenece al lenguaje", yyline, yycolumn, "Eliminar Caracter: "+ yytext()));
}