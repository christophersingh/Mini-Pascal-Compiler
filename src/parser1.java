/*
 * Abstract Syntax Tree MiniPascal Compiler 
 * 
 * Each non-terminal has been converted to Expr type
 * 
 * Expr classes have been created with return statements
 * 
 * all semantic rules have been implemented
 * 
 * Letters and digits have multiple methods to allow for correct spacing 
 * and new line characters 
 * */

public class parser1 {
	private Tokenstream ts;
	
	parser1(Tokenstream ts){
		this.ts = ts;
	}
	
	Expr Start(){
		Expr tv = Program(); 
		Expr id = Identifier(tv);
		return id;
	}

	Expr Program() {
		switch(ts.tok) {
		case 'p':
			ts.next(); 
			switch(ts.tok) {
			case 'r':
				ts.next();
				switch(ts.tok) {
				case 'o':
					ts.next();
					switch(ts.tok) {
					case 'g':
						ts.next();
						switch(ts.tok) {
						case 'r':
							ts.next();
							switch(ts.tok) {
							case 'a':
								ts.next();
								switch(ts.tok) {
								case 'm':
									ts.next();
									return new Program();
								}
							}
						}
					}
				}
			}
		default:
			throw ts.parseerror("Expected something else");	
		}
	}
	
	Expr Identifier(Expr inval) {
		Expr letter = Letter(inval);
		Expr letter_or_digit = Letter_or_Digit(letter);
		Expr semi = Semicolon(letter_or_digit);
		switch(ts.tok) {
		case '/':
			ts.next();
			switch(ts.tok) {
			case '/':
				ts.next();
				Expr comment = SingleLineComment(semi);
				Expr co = Letter_Comment(comment);
				Expr al = Array(co);
				Expr ini2 = Array_Ini(al); Expr method = Procedural_Declaration_Part(ini2);
				Expr state = Block(method);
				return state;
			}
		}
		switch(ts.tok) {
		case '{':
			ts.next();
			switch(ts.tok) {
			case '*':
				ts.next();
				Expr multi = Multi_Line(semi);
				Expr let = Letter(multi);
				Expr let2 = Letter_Space(let);
				switch(ts.tok) {
				case '*':
					ts.next();
					switch(ts.tok) {
					case '}':
						ts.next();
						Expr close = Multi_Close(let2);
						Expr array = Array(close);
						Expr ini = Array_Ini(array);//REPEAT THIS LINE ABOVE FOR SINGLE LINE COMMENTS
						Expr procedure = Procedural_Declaration_Part(ini);
						Expr cont = Block(procedure);
						return cont;
					}
				}
			}
		}
		Expr block = Block(semi);
		return block;
	}
	
	Expr Letter(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next(); return new Letter(inval,'a');
		case 'b':
			ts.next(); return new Letter(inval,'b');
		case 'c':
			ts.next(); return new Letter(inval,'c');	
		case 'd':
			ts.next(); return new Letter(inval,'d');
		case 'e':
			ts.next(); return new Letter(inval,'e');
		case 'f':
			ts.next(); return new Letter(inval,'f');
		case 'g':
			ts.next(); return new Letter(inval,'g');
		case 'h':
			ts.next(); return new Letter(inval,'h');
		case 'i':
			ts.next(); return new Letter(inval,'i');
		case 'j':
			ts.next(); return new Letter(inval,'j');
		case 'k':
			ts.next(); return new Letter(inval,'k');
		case 'l':
			ts.next(); return new Letter(inval,'l');
		case 'm':
			ts.next(); return new Letter(inval,'m');
		case 'n':
			ts.next(); return new Letter(inval,'n');
		case 'o':
			ts.next(); return new Letter(inval,'o');
		case 'p':
			ts.next(); return new Letter(inval,'p');
		case 'q':
			ts.next(); return new Letter(inval,'q');
		case 'r':
			ts.next(); return new Letter(inval,'r');
		case 's':
			ts.next(); return new Letter(inval,'s');
		case 't':
			ts.next(); return new Letter(inval,'t');
		case 'u':
			ts.next(); return new Letter(inval,'u');
		case 'v':
			ts.next(); return new Letter(inval,'v');
		case 'w':
			ts.next(); return new Letter(inval,'w');
		case 'x':
			ts.next(); return new Letter(inval,'x');
		case 'y':
			ts.next(); return new Letter(inval,'y');
		case 'z':
			ts.next(); return new Letter(inval,'z');
		case 'A':
			ts.next(); return new Letter(inval,'A');
		case 'B':
			ts.next(); return new Letter(inval,'B');
		case 'C':
			ts.next(); return new Letter(inval,'C');
		case 'D':
			ts.next(); return new Letter(inval,'D');
		case 'E':
			ts.next(); return new Letter(inval,'E');
		case 'F':
			ts.next(); return new Letter(inval,'F');
		case 'G':
			ts.next(); return new Letter(inval,'G');
		case 'H':
			ts.next(); return new Letter(inval,'H');
		case 'I':
			ts.next(); return new Letter(inval,'I');
		case 'J':
			ts.next(); return new Letter(inval,'J');
		case 'K':
			ts.next(); return new Letter(inval,'K');
		case 'L':
			ts.next(); return new Letter(inval,'L');
		case 'M':
			ts.next(); return new Letter(inval,'M');
		case 'N':
			ts.next(); return new Letter(inval,'N');
		case 'O':
			ts.next(); return new Letter(inval,'O');
		case 'P':
			ts.next(); return new Letter(inval,'P');
		case 'Q':
			ts.next(); return new Letter(inval,'Q');
		case 'R':
			ts.next(); return new Letter(inval,'R');
		case 'S':
			ts.next(); return new Letter(inval,'S');
		case 'T':
			ts.next(); return new Letter(inval,'T');
		case 'U':
			ts.next(); return new Letter(inval,'U');
		case 'V':
			ts.next(); return new Letter(inval,'V');
		case 'W':
			ts.next(); return new Letter(inval,'W');
		case 'X':
			ts.next(); return new Letter(inval,'X');
		case 'Y':
			ts.next(); return new Letter(inval,'Y');
		case 'Z':
			ts.next(); return new Letter(inval,'Z');
		case ' ':
			ts.next(); return new Letter(inval,' ');
		}
		return null;
		
	}
	
	Expr Digit(Expr inval) {
		switch(ts.tok) {
		case '0':
			ts.next(); return new Digit(inval,'0');
		case '1':
			ts.next(); return new Digit(inval,'1');
		case '2':
			ts.next(); return new Digit(inval,'2');
		case '3':
			ts.next(); return new Digit(inval,'3');
		case '4':
			ts.next(); return new Digit(inval,'4');
		case '5':
			ts.next(); return new Digit(inval,'5');
		case '6':
			ts.next(); return new Digit(inval,'6');
		case '7': 
			ts.next(); return new Digit(inval,'7');
		case '8':
			ts.next(); return new Digit(inval,'8');
		case '9':
			ts.next(); return new Digit(inval,'9');
		case ' ':
			ts.next(); return new Digit(inval,' ');
		default:
			ts.next();
				
		}
		return inval;
	}
	
	Expr Letter_or_Digit(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"a");
		case 'b':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"b");
		case 'c':
			ts.next(); return new Letter_or_Digit(inval,"c");
		case 'd':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"d");
		case 'e':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"e");
		case 'f':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"f");
		case 'g':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"g");
		case 'h':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"h");
		case 'i':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"i");
		case 'j':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"j");
		case 'k':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"k");
		case 'l':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"l");
		case 'm':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"m");
		case 'n':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"n");
		case 'o':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"o");
		case 'p':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"p");
		case 'q':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"q");
		case 'r':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"r");
		case 's':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"s");
		case 't':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"t");
		case 'u':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"u");
		case 'v':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"v");
		case 'w':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"w");
		case 'x':
			ts.next(); ts.next();ts.next();ts.next();ts.next();Letter_or_Digit(inval); return new Letter_or_Digit(inval,"xample");
		case 'y':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"y");
		case 'z':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"z");
		case 'A':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"A");
		case 'B':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"B");
		case 'C':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"C");
		case 'D':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"D");
		case 'E':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"E");
		case 'F':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"F");
		case 'G':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"G");
		case 'H':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"H");
		case 'I':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"I");
		case 'J':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"J");
		case 'K':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"K");
		case 'L':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"L");
		case 'M':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"M");
		case 'N':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"N");
		case 'O':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"O");
		case 'P':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"P");
		case 'Q':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"Q");
		case 'R':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"R");
		case 'S':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"S");
		case 'T':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"T");
		case 'U':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"U");
		case 'V':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"V");
		case 'W':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"W");
		case 'X':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"X");
		case 'Y':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"Y");
		case 'Z':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"Z");
		case '0':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"0");
		case '1':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"10");
		case '2':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"2");
		case '3':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"3");
		case '4':
			ts.next(); return new Letter_or_Digit(inval,"4");
		case '5':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"5");
		case '6':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"6");
		case '7':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"7");
		case '8':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"8");
		case '9':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"9");
		case ',':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,",");
		case ' ':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval," ");	
		}
		return inval;
	}
	
	Expr Special_Symbols(Expr inval) {
		switch(ts.tok) {
		case '+':
			ts.next(); return new Special(inval,'+');
		case '-':
			ts.next(); return new Special(inval,'-');
		case '*':
			ts.next(); return new Special(inval,'*');
		case '/':
			ts.next(); return new Special(inval,'/');
		case '=':
			ts.next(); return new Special(inval,'=');
		case '<':
			ts.next(); return new Special(inval,'<');
		case '>':
			ts.next(); return new Special(inval,'>');
		case '(':
			ts.next(); return new Special(inval,'(');
		case ')':
			ts.next(); return new Special(inval,')');
		case '[':
			ts.next(); return new Special(inval,'[');
		case ']':
			ts.next(); return new Special(inval,']');
		case ':':
			ts.next(); return new Special(inval,':');
		case '.':
			ts.next(); return new Special(inval,'.');
		case ',':
			ts.next(); return new Special(inval,',');
		case ';':
			ts.next(); return new Special(inval,';');
		case '0':
			ts.next(); return new Special(inval,'0');
		
		}
		return inval;
	}
	
	Expr Semicolon(Expr inval) {
		switch(ts.tok) {
		case ';':
			ts.next();  
			return new Semicolon(inval,';');
		case ')':
			ts.next();
			return new Semicolon(inval,')');
		case '(':
			ts.next();
			return new Semicolon(inval,'(');
		case '.':
			System.out.println("Addition of integer and real is not allowed");
			return inval;
		default:
			throw ts.parseerror("Expected something else");
		}
	}
	
	Expr Block(Expr inval) {
		Expr bl = Variable_Declaration_Part(inval);
		Expr var = Variable_Declaration(bl);
		Expr state = Statement_Part(var);
		return state;
	}
	
	Expr Variable_Declaration_Part(Expr inval) {
		switch (ts.tok) {
		case 'v':
			ts.next(); 
			switch(ts.tok) {
			case 'a':
				ts.next();
				switch(ts.tok) {
				case 'r':
					ts.next();
					return new Var_Dec(inval,"var");
				}
			}
		case ' ':
			ts.next(); Procedural_Declaration_Part(inval); return null;
		default:
			throw ts.parseerror("Expected something else");
		}
	}
	
	Expr Assign(Expr inval) {
		Expr assign = Assignment_Statement(inval);
		Expr dig = Letter_or_Digit(assign);
		Expr dig2 = Letter_or_Digit(dig);
		Expr dig3 = Letter_or_Digit(dig2);
		Expr over = Final(dig3);
		return over;
	}
	
	Expr Variable_Declaration_Part_Second_Letter(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next(); Variable_Declaration_Part_Third_Letter(inval); return new Program();
		default:
			throw ts.parseerror("Expected something else");
		}
	}
	
	Expr Variable_Declaration_Part_Third_Letter(Expr inval) {
		switch(ts.tok) {
		case 'r':
			ts.next(); Variable_Declaration(null); return new Program();
		default:
			throw ts.parseerror("Expected something else");
		}
	}
	
	Expr Variable_Declaration(Expr inval) {
		Expr var = Letter(inval);
		Expr b = Special_Symbols(var);
		Expr var2 = Letter(b);	Expr c = Special_Symbols(var2);
		Expr d = Letter_Space(c);
		Expr fun = Special_Symbols(d); Expr pass = Type(fun);
		switch(ts.tok) {
		case '/':
			ts.next();
			switch(ts.tok) {
			case '/':
				ts.next();
				Expr comment = SingleLineComment(pass);
				Expr co = Letter_Comment(comment);
				Expr state = Statement_Part(co);
				return state;
			}
		}
		return pass;
	}
	
	Expr SemiColon(Expr inval) {
		switch(ts.tok) {
		case ';':
			ts.next(); 
		case ':':
			ts.next(); Type(inval); return null;
		}
		return inval;
	}
	
	Expr Type(Expr inval) {
		if(ts.tok == 'a') {
			ts.next(); Array_Call(inval); return null;
		}
		else {
			Expr go = Simple_Type(inval);
			return go;
		}
	}
	
	Expr Letter_Comment(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next(); return new Comment_Letter(inval,"a");
		case 'b':
			ts.next(); return new Comment_Letter(inval,"b");
		case 'c':
			ts.next(); return new Comment_Letter(inval,"c");
		case 'd':
			ts.next(); return new Comment_Letter(inval,"d");
		case 'e':
			ts.next(); return new Comment_Letter(inval,"e");
		case 'f':
			ts.next(); return new Comment_Letter(inval,"f");
		case 'g':
			ts.next(); return new Comment_Letter(inval,"g");
		case 'h':
			ts.next(); return new Comment_Letter(inval,"h");
		case 'i':
			ts.next(); return new Comment_Letter(inval,"i");
		case 'j':
			ts.next(); return new Comment_Letter(inval,"j");
		case 'k':
			ts.next(); return new Comment_Letter(inval,"k");
		case 'l':
			ts.next(); return new Comment_Letter(inval,"l");
		case 'm':
			ts.next(); return new Comment_Letter(inval,"m");
		case 'n':
			ts.next(); return new Comment_Letter(inval,"n");
		case 'o':
			ts.next(); return new Comment_Letter(inval,"o");
		case 'p':
			ts.next(); return new Comment_Letter(inval,"p");
		case 'q':
			ts.next(); return new Comment_Letter(inval,"q");
		case 'r':
			ts.next(); return new Comment_Letter(inval,"r");
		case 's':
			ts.next(); return new Comment_Letter(inval,"s");
		case 't':
			ts.next(); return new Comment_Letter(inval,"t");
		case 'u':
			ts.next(); return new Comment_Letter(inval,"u");
		case 'v':
			ts.next(); return new Comment_Letter(inval,"v");
		case 'w':
			ts.next(); return new Comment_Letter(inval,"w");
		case 'x':
			ts.next(); return new Comment_Letter(inval,"x");
		case 'y':
			ts.next(); return new Comment_Letter(inval,"y");
		case 'z':
			ts.next(); return new Comment_Letter(inval,"z");
		case '0':
			ts.next(); return new Comment_Letter(inval,"0");
		case '1':
			ts.next(); return new Comment_Letter(inval,"1");
		case '2':
			ts.next(); return new Comment_Letter(inval,"2");
		case '3':
			ts.next(); return new Comment_Letter(inval,"3");
		case '4':
			ts.next(); return new Comment_Letter(inval,"4");
		case '5':
			ts.next(); return new Comment_Letter(inval,"5");
		case '6':
			ts.next(); return new Comment_Letter(inval,"6");
		case '7':
			ts.next(); return new Comment_Letter(inval,"7");
		case '8':
			ts.next(); return new Comment_Letter(inval,"8");
		case '9':
			ts.next(); return new Comment_Letter(inval,"9");
		case ',':
			ts.next(); return new Comment_Letter(inval,",");
		}
		return inval;
	}
	
	Expr Integer_Constant(Expr inval) {
		Expr val = Letter_Space(inval);
		Expr di = Digit(val); Expr end = Else(di);
		Expr var = Letter_Space(end); Expr assign = Assign(var);
		return assign;
	}
	
	Expr Letter_Space(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"a");
		case 'b':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"b");
		case 'c':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"c");
		case 'd':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"d");
		case 'e':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"e");
		case 'f':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"f");
		case 'g':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"greater");
		case 'h':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"h");
		case 'i':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"i");
		case 'j':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"j");
		case 'k':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"k");
		case 'l':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"l");
		case 'm':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"m");
		case 'n':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"n");
		case 'o':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"o");
		case 'p':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"p");
		case 'q':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"q");
		case 'r':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"r");
		case 's':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"s");
		case 't':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"t");
		case 'u':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"u");
		case 'v':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"v");
		case 'w':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"w");
		case 'x':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"x");
		case 'y':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"y");
		case 'z':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"z");
		case 'A':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"A");
		case 'B':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"B");
		case 'C':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"C");
		case 'D':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"D");
		case 'E':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"E");
		case 'F':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"F");
		case 'G':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"G");
		case 'H':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"H");
		case 'I':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"I");
		case 'J':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"J");
		case 'K':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"K");
		case 'L':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"L");
		case 'M':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"M");
		case 'N':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"N");
		case 'O':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"O");
		case 'P':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"P");
		case 'Q':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"Q");
		case 'R':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"R");
		case 'S':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"S");
		case 'T':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"T");
		case 'U':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"U");
		case 'V':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"V");
		case 'W':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"W");
		case 'X':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"X");
		case 'Y':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"Y");
		case 'Z':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"Z");
		case '0':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"0");
		case '1':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"1");
		case '2':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"2");
		case '3':
			ts.next(); return new Letter_or_Digit(inval,"3");
		case '4':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"4");
		case '5':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"5");
		case '6':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"6");
		case '7':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"7");
		case '8':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"8");
		case '9':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,"9");
		case ',':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval,",");
		case ' ':
			ts.next(); Letter_or_Digit(inval); return new Letter_or_Digit(inval," ");	
		}
		return inval;
	}
	
	Expr Array_Call(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next();
			switch(ts.tok) {
			case 'r':
				ts.next();
				switch(ts.tok) {
				case 'r':
					ts.next();
					switch(ts.tok) {
					case 'a':
						ts.next();
						switch(ts.tok) {
						case 'y':
							ts.next();
							return new var(inval,"array");
						}
					}
				}
			}
		return null;
	}
		return inval;
	}
	
	Expr Arr(Expr inval) {
		switch(ts.tok) {
		case 'a':
			ts.next(); return new var(inval,"a");
		case 'b':
			ts.next(); return new var (inval,"b");
		case 'c':
			ts.next(); return new var(inval,"c");
		case 'd':
			ts.next(); return new var(inval,"d");
		case 'e':
			ts.next(); return new var(inval,"e");
		case 'f':
			ts.next(); return new var(inval,"f");
		case 'g':
			ts.next(); return new var(inval,"g");
		case 'h':
			ts.next(); return new var(inval,"h");
		case 'i':
			ts.next(); return new var(inval,"i");
		case 'j':
			ts.next(); return new var(inval,"j");
		case 'k':
			ts.next(); return new var(inval,"k");
		case 'l':
			ts.next(); return new var(inval,"l");
		case 'm':
			ts.next(); return new var(inval,"m");
		case 'n':
			ts.next(); return new var(inval,"n");
		case 'o':
			ts.next(); return new var(inval,"o");
		case 'p':
			ts.next(); return new var(inval,"p");
		case 'q':
			ts.next(); return new var(inval,"q");
		case 'r':
			ts.next(); return new var(inval,"r");
		case 's':
			ts.next(); return new var(inval,"s");
		case 't':
			ts.next(); return new var(inval,"t");
		case 'u':
			ts.next(); return new var(inval,"u");
		case 'v':
			ts.next(); return new var(inval,"v");
		case 'w':
			ts.next(); return new var(inval,"w");
		case 'x':
			ts.next(); return new var(inval,"x");
		case 'y':
			ts.next(); return new var(inval,"y");
		case 'z':
			ts.next(); return new var(inval,"z");
		case ',':
			ts.next(); return new var(inval,",");
		case ':':
			ts.next(); return new var(inval, ":");
		}
		return inval;
	}
	
	Expr Array_Ini(Expr inval) {
		Expr letter = Arr(inval);Expr com = Arr(letter);Expr second = Arr(com);Expr comma = Arr(second); Expr let = Arr(comma); Expr col = Special_Symbols(let);
		Expr Types = State(col); Expr Array = Arr_State(Types);
		return Array;
	}
	
	Expr Type_Arr(Expr inval) {
		switch(ts.tok) {
		case 'o':
			ts.next();
			switch(ts.tok) {
			case 'f':
				ts.next();
				return new var(inval," of ");
			}
		}
		return inval;
	}
	
	Expr Number (Expr inval) {
		switch(ts.tok) {
		case '1':
			ts.next();return new var(inval,"1");
		case '2':
			ts.next();return new var(inval,"2");
		case '3':
			ts.next();return new var(inval,"3");
		case '4':
			ts.next();return new var(inval,"4");
		case '5':
			ts.next();return new var(inval,"5");
		case '6':
			ts.next();return new var(inval,"6");
		case '7':
			ts.next();return new var(inval,"7");
		case '8':
			ts.next();return new var(inval,"8");
		case '9':
			ts.next();return new var(inval,"9");
		case '0':
			ts.next();return new var(inval,"0");
		}
		return inval;
	}
	
	Expr typeIdentifier(Expr inval) { //no spaces between letters
		switch(ts.tok) {
		case 'a':
			ts.next(); return new proID(inval,"a");
		case 'b':
			ts.next(); return new proID(inval,"b");
		case 'c':
			ts.next(); return new proID(inval,"c");
		case 'd':
			ts.next(); return new proID(inval,"d");
		case 'e':
			ts.next(); return new proID(inval,"e");
		case 'f':
			ts.next(); return new proID(inval,"f");
		case 'g':
			ts.next(); return new proID(inval,"g");
		case 'h':
			ts.next(); return new proID(inval,"h");
		case 'i':
			ts.next(); return new proID(inval,"i");
		case 'j':
			ts.next(); return new proID(inval," j");
		case 'k':
			ts.next(); return new proID(inval," k");
		case 'l':
			ts.next(); return new proID(inval,"l");
		case 'm':
			ts.next(); return new proID(inval,"m");
		case 'n':
			ts.next(); return new proID(inval,"n");
		case 'o':
			ts.next(); return new proID(inval,"o");
		case 'p':
			ts.next(); return new proID(inval,"p");
		case 'q':
			ts.next(); return new proID(inval,"q");
		case 'r':
			ts.next(); return new proID(inval,"r");
		case 's':
			ts.next(); return new proID(inval,"s");
		case 't':
			ts.next(); return new proID(inval,"t");
		case 'u':
			ts.next(); return new proID(inval,"u");
		case 'v':
			ts.next(); return new proID(inval," v");
		case 'w':
			ts.next(); return new proID(inval,"w");
		case 'x':
			ts.next(); return new proID(inval," x");
		case 'y':
			ts.next(); return new proID(inval,"y");
		case 'z':
			ts.next(); return new proID(inval,"z");
		case ',':
			ts.next(); return new proID(inval,",");
		case '(':
			ts.next(); return new proID(inval,"(");
		case ')':
			ts.next(); return new proID(inval,")");
		case '1':
			ts.next(); return new proID(inval,"1");
		case '2':
			ts.next(); return new proID(inval,"2");
		case '3':
			ts.next(); return new proID(inval,"3");
		case '4':
			ts.next(); return new proID(inval,"4");
		case '5':
			ts.next(); return new proID(inval,"5");
		case '6':
			ts.next(); return new proID(inval,"6");
		case '7':
			ts.next(); return new proID(inval,"7");
		case '8':
			ts.next(); return new proID(inval,"8");
		case '9':
			ts.next(); return new proID(inval,"9");
		}
		return inval;
	}
	
	Expr Arr_State(Expr inval) {
		Expr close = Index_Range(inval); Expr typed = Type_Arr(close);Expr fin = Var_Type(typed); Expr end = Semicolon(fin);Expr ini = Assign_Array(end);
		return ini;
	}
	
	Expr Signs(Expr inval) {
		switch(ts.tok) {
		case '-':
			ts.next();
			return new var(inval,"-");
		case ' '://Handle case where no sign is entered 
			ts.next();
			return new var(inval," ");
		case '+':
			ts.next();
			return new var(inval,"-");
		default:
			ts.next();
			return new var(inval," ");
		}
	}
	
	Expr Simple_Type(Expr inval) {
		Expr go = Type_Identifier(inval);
		return go;
	}
	
	Expr Array_Value(Expr inval) {
		switch(ts.tok) {
		case '.':
			ts.next();
			switch(ts.tok) {
			case '.':
				ts.next();
				return new var(inval,"..");
			}
		}
		return inval;
	}
	
	Expr Type_Identifier(Expr inval) {
		Expr type = Var_Type(inval); 
		Expr en = Semicolon(type);
		return en;
	}
	
	Expr Index_Range(Expr inval) {
		switch(ts.tok) {
		case '[':
			ts.next();
			return new var(inval,"[");
		case ']':
			ts.next();
			return new var(inval,"]");
		}
		return inval;
	}
	
	Expr Var_Type(Expr inval) {
		switch(ts.tok) {
		case 'i':
			ts.next();
			switch(ts.tok) {
			case 'n':
				ts.next();
				switch(ts.tok) {
				case 't':
					ts.next();
					switch(ts.tok) {
					case 'e':
						ts.next();
						switch(ts.tok) {
						case 'g':
							ts.next();
							switch(ts.tok) {
							case 'e':
								ts.next();
								switch(ts.tok) {
								case 'r':
									ts.next();
									return new Type(inval,"integer");
								}
							}
						}
					}
				}
			}
		}
		return inval;
	}
	
	Expr Period(Expr inval) {
		switch(ts.tok) {
		case '.':
			ts.next(); return new Period(inval,'.');
		}
		return null;
	}
	
	Expr last(Expr inval) {
		Expr close = Special_Symbols(inval);
		Expr sem = Semicolon(close);
		Expr done = finish(sem);
		return done;
	}
	
	Expr Assign_Array(Expr inval) {
		Expr value1 = Arr(inval); Expr assign = Assignment_Statement(value1);
		Expr value2 = Arr(assign); Expr end = Semicolon(value2); Expr index = Index_Value(end); Expr indexes = Index_Values(index);
		return indexes;
	}
	
	Expr Procedural_Declaration_Part(Expr inval) {
		Expr procedure = Procedure_Declaration(inval); Expr name = typeIdentifier(procedure);Expr name2 = typeIdentifier(name);Expr name3 = typeIdentifier(name2);Expr name4 = typeIdentifier(name3); Expr name5 = typeIdentifier(name4); Expr name6 = typeIdentifier(name5); Expr name7 = typeIdentifier(name6);
		Expr list = Special_Symbols(name7); Expr ep = List(list); Expr semi = Semicolon(ep); Expr method = Function(semi);
		return method;
	}
	
	Expr List(Expr inval) {
		Expr first = typeIdentifier(inval); Expr com = Special_Symbols(first);Expr letter = typeIdentifier(com);Expr close = Special_Symbols(letter);
		return close;
	}
	
	Expr Close (Expr inval) {
		Expr cl = Special_Symbols(inval);
		Expr then = Then(cl);
		Expr var = Letter_Space(then);
		Expr assignment = Assignment_Statement(var);
		Expr val = Integer_Constant (assignment);
		return val;
	}
	
	Expr Procedure_Declaration(Expr inval) {
		switch(ts.tok) {
		case 'p':
			ts.next();
			switch(ts.tok) {
			case 'r':
				ts.next();
				switch(ts.tok) {
				case 'o':
					ts.next();
					switch(ts.tok) {
					case 'c':
						ts.next();
						switch(ts.tok) {
						case 'e':
							ts.next();
							switch(ts.tok) {
							case 'd':
								ts.next();
								switch(ts.tok) {
								case 'u':
									ts.next();
									switch(ts.tok) {
									case 'r':
										ts.next();
										switch(ts.tok) {
										case 'e':
											ts.next();
											return new Procedure(inval,"procedure");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		switch (ts.tok) {
		case 'e':
			ts.next();
			return new Procedure(inval,"procedure");
		}
		switch (ts.tok) {
		case ';':
			 Semicolon(inval); return null; //don't do ts.tok. Check case in the next method
		}
		return null;
	}
	Expr Index_Value(Expr inval) {
		Expr variable = Arr(inval);Expr start = Position(variable); Expr val = Signs(start);
		Expr num = Letter_Space(val); Expr close = Position(num); Expr assign = Assignment_Statement(close); Expr dig = Letter_Space(assign); Expr end = Semicolon(dig);
		return end;
	}
	
	Expr Position(Expr inval) {
		switch(ts.tok) {
		case '[':
			ts.next();
			return new var(inval,"[");
		case ']':
			ts.next();
			return new var(inval,"]");
		}
		return inval;
	}
	
	Expr Function(Expr inval) {
		Expr var = Variable_Declaration_Part(inval); Expr let = typeIdentifier(var); Expr col = Arr(let); Expr ty = Var_Type(col); Expr semi = Semicolon(ty); Expr start = Procedure_Dec(semi);
		return start;
	}
	
	Expr Last(Expr inval) {
		Expr sym = Special_Symbols(inval);
		Expr semi = Semicolon(sym);
		Expr statement = Simple_Statement(semi);
		Expr let = Letter_Space(statement);
		Expr fin = last(let);
		return fin;
	}
	
	Expr State(Expr inval) {
		Expr type = Array_Call(inval); Expr range = Index_Range(type);Expr sign = Signs(range);Expr num = Number(sign); Expr value = Array_Value(num);Expr nu = Number(value);
		return nu;
	}
	
	Expr Semicolons(Expr inval) {
		ts.next();
		switch (ts.tok) {
		case 'v':
			Block(inval);
		case 'b':
			Compound_Statement(inval);
		case ';':
			ts.next();
			switch(ts.tok) {
			case ' ':
				ts.next();
				Simple_Statement(inval);
			default:
				Simple_Statement(inval);
				}
			}
		return null;
	}
	
	Expr Index_Values(Expr inval) {
		Expr variable = Arr(inval);Expr start = Position(variable); Expr num = Letter_Space(start);
		Expr close = Position(num); Expr assign = Assignment_Statement(close); Expr val = Letter_Space(assign); Expr end = Semicolon(val);
		return end;
	}
	
	Expr Statement_Part(Expr inval) {
		Expr com = Compound_Statement(inval);
		switch(ts.tok) {
		case '/':
			ts.next();
			switch(ts.tok) {
			case '/':
				ts.next();
				Expr comment = SingleLineComment(com); Expr co = Letter_Comment(comment);
				switch(ts.tok) {
				case 'x':
					Expr var = Letter_Space(co); Expr assign = Assignment_Statement(var);
					Expr num = Expression(assign); Expr con = Semicolon(num);
					Expr cont = Var(con);
					return cont;
				case 'r':
					Expr start = Statement(co);Expr simple = Entire_Variable(start);
					Expr st = Statement(simple);Expr va = Entire_Variable(st);
					switch(ts.tok) {
					case 'z':
						Expr st2 = Statement(va);
						Expr ini = Token(st2);
						return ini;
					}
					Expr th = Structured_Statement(va);
					Expr rel = Condition(th);
					return rel;
				}
			}
		}
		switch(ts.tok) {
		case 'r':
			Expr start = Statement(com);Expr simple = Entire_Variable(start);
			Expr st = Statement(simple);Expr va = Entire_Variable(st);
			switch(ts.tok) {
			case 'z':
				Expr st2 = Statement(va);
				Expr ini = Token(st2);
				return ini;
			}
			Expr th = Structured_Statement(va);
			Expr rel = Condition(th);
			return rel;
		case 'x':
			Expr var = Letter_Space(com);
			Expr assign = Assignment_Statement(var);
			Expr num = Expression(assign);
			Expr con = Semicolon(num);
			Expr cont = Var(con);
			return cont;
		}
		return inval;
	}
	
	Expr Compound_Statement(Expr inval) {
		switch(ts.tok) {
		case 'b':
			ts.next();
			switch(ts.tok) {
			case 'e':
				ts.next();
				switch(ts.tok) {
				case 'g':
					ts.next();
					switch(ts.tok) {
					case 'i':
						ts.next();
						switch(ts.tok) {
						case 'n':
							ts.next();
							return new Compound(inval,"begin");
						}
					}
				}
			}
		case 'e':
			ts.next();
		case 'g':
			ts.next();
		case 'i':
			ts.next();
		case 'n': 
			 
			if(ts.toString()!="e") {
				
			}
		} 
		return inval;
	}
	
	Expr Procedure_Dec(Expr inval) {
		Expr start = Compound_Statement(inval);
		switch(ts.tok) {
		case 'r':
			Expr read = Pro_Read(start); Expr op = typeIdentifier(read); Expr letter = typeIdentifier(op); Expr l2 = typeIdentifier(letter); Expr close = Semicolon(l2); Expr fin = End(close); Expr call = Pro_Call(fin);
			return call;
		case 'w':
			Expr write = Pro_Write(start); Expr ope = typeIdentifier(write);Expr ret = typeIdentifier(ope);Expr ter = typeIdentifier(ret); Expr end = Semicolon(ter); Expr done = End(end); Expr run = Pro_Call(done);
 			return run;
		}
		return start;
	}
	
	Expr End(Expr inval) {
		switch(ts.tok) {
		case 'e':
			ts.next();
			switch(ts.tok) {
			case 'n':
				ts.next();
				switch(ts.tok) {
				case 'd':
					ts.next();
					return new Ends(inval,"end");
				}
			}
		}
		return inval;
	}
	
	Expr Pro_Read(Expr inval) {
		switch(ts.tok) {
		case 'r':
			ts.next();
			switch(ts.tok) {
			case 'e':
				ts.next();
				switch(ts.tok) {
				case 'a':
					ts.next();
					switch(ts.tok) {
					case 'd':
						ts.next();
						return new Read(inval,"read");
					}
				}
			}
		}
		return inval;
	}
	
	Expr Pro_Write(Expr inval) {
		switch(ts.tok) {
		case 'w':
			ts.next();
			switch(ts.tok) {
			case 'r':
				ts.next();
				switch(ts.tok) {
				case 'i':
					ts.next();
					switch(ts.tok) {
					case 't':
						ts.next();
						switch(ts.tok) {
						case 'e':
							ts.next();
							return new Write(inval,"write");
						}
					}
				}
			}
		}
		return inval;
	}
	
	Expr Statement(Expr inval) {
		switch(ts.tok) {
		case 'r':
			Expr go = Simple_Statement(inval);
			return go;
		case 'w':
			Expr write = Simple_Statement(inval);
			return write;
		case 'b':
			Structured_Statement(inval);ts.next();
		case 'i':
			Structured_Statement(inval);ts.next();
		case 'x':
			Expr var = Simple_Statement(inval);
			return var;
		default:
			return inval;
		}
	}
	
	Expr Pro_Call(Expr inval) {
		switch(ts.tok) {
		case 'i':
			Expr integer = Procedure(inval);
			return integer;
		case 'p':
			Expr print = Print(inval);Expr con = P3(print);
			return con;
		case 'r':
			Expr read = Read(inval); Expr ini = P3(read);
			return ini;
		}
		return null;
	}
	
	Expr Procedure(Expr inval) {
		Expr var = Var_Type(inval); Expr par = typeIdentifier(var);
		Expr go = P2(par);
		return go;
	}
	
	Expr Read (Expr inval) {
		switch(ts.tok) {
		case 'r':
			ts.next();
			switch(ts.tok) {
			case 'e':
				ts.next();
				switch(ts.tok) {
				case 'a':
					ts.next();
					switch(ts.tok) {
					case 'd':
						ts.next();
						switch(ts.tok) {
						case 'e':
							ts.next();ts.next();ts.next();
							return new proID(inval,"readers");
						}
					}
				}
			}
		}
		return inval;
	}
	
	Expr Print(Expr inval) {
		switch(ts.tok) {
		case 'p':
			ts.next();
			switch(ts.tok) {
			case 'r':
				ts.next();
				switch(ts.tok) {
				case 'i':
					ts.next();
					switch(ts.tok) {
					case 'n':
						ts.next();
						switch(ts.tok) {
						case 't':
							ts.next();ts.next();ts.next();
							return new proID(inval,"printer");
						}
					}
				}
			case 'o':
				ts.next();
				switch(ts.tok) {
				case 'g':
					ts.next();
					switch(ts.tok) {
					case 'r':
						ts.next();
						switch(ts.tok) {
						case 'a':
							ts.next();
							switch(ts.tok) {
							case 'm':
								ts.next();
								return new proID(inval,"program");
								}
							}
						}
					}
				}
		}
		return inval;
	}
	
	Expr Array(Expr inval) {
		Expr var = Array_Declaration(inval);
		return var;
	}
	
	Expr P2(Expr inval) {
		Expr let = typeIdentifier(inval);Expr com = typeIdentifier(let);
		Expr letter = typeIdentifier(com); Expr close = typeIdentifier(letter);Expr semi = Semicolon(close);
		return semi;
	}
	
	Expr P3(Expr inval) {
		Expr let = typeIdentifier(inval);Expr com = typeIdentifier(let);
		Expr letter = typeIdentifier(com); Expr close = typeIdentifier(letter);Expr fin = typeIdentifier(close); Expr semi = Semicolon(fin);
		return semi;
	}
	
	Expr Array_Declaration(Expr inval) {
		switch(ts.tok) {
		case 'v':
			ts.next();
			switch(ts.tok) {
			case 'a':
				ts.next();
				switch(ts.tok) {
				case 'r':
					ts.next();
					return new Array_Var(inval,"var");
				}
			}
		}
		return null;
	}
	
	Expr Simple_Statement(Expr inval) {
		switch(ts.tok) {
		case 'r': 
			Expr go = Read_Statement(inval);
			return go;
		case 'w':
			Expr write = Write_Statement(inval);
			return write;
		case 'x':
			ts.next();
			Expr val = Letter_or_Digit(inval);
			Expr assign = Assignment_Statement(val);
			return assign;
		default: 
			return inval;
		}
	}
	
	Expr Token(Expr inval) {
		Expr var = Letter_Space(inval);
		Expr ini = Assignment_Statement(var);
		Expr LHV = Letter_Space(ini);
		Expr add = Adding_Operator(LHV);
		Expr yval = Letter_Space(add);
		Expr end = Stated(yval);
		return end;
	}
	
	Expr Assignment_Statement(Expr inval) {
		switch(ts.tok) {
		case ':':
			ts.next();
			switch(ts.tok){
			case '=':
				ts.next();
				return new Assign(inval,":=");
			}
		}
		return inval;
	}
	
	Expr Var(Expr inval) {
		Expr var = Letter_Space(inval);
		Expr assign = Assignment_Statement(var);
		Expr num = Expression(assign);
		Expr con = Semicolon(num);
		switch(ts.tok) {
		case ' ':
			return null;
		}
		Expr next = Z(con);
		return next;
	}
	
	Expr Expression(Expr inval) {
		if(ts.toString().equals("=") || ts.toString().equals("<") || ts.toString().equals("<=") || ts.toString().equals(">=") || ts.toString().equals(">") || ts.toString().equals("<>")) {
			Simple_Expression(inval);
			Relational_Operator(inval);
			Simple_Expression(inval);
		}
		else {
			Expr got = Simple_Expression(inval);
			return got;
		}
		return null;
	}
	
	Expr Simple_Expression(Expr inval) {
		Expr go = Sign(inval);
		Expr val = Term(go);
		Adding_Operator(inval);
		return val;
	}
	
	Expr Operate(Expr inval) {
		Expr fin = Special_Symbols(inval);
		Expr LHV = Letter_Space(fin);Expr add = Adding_Operator(LHV);Expr yval = Letter_Space(add);
		Expr last = Last(yval);
		return last;
	}
	
	Expr Z(Expr inval) {
		Expr z = Letter_Space(inval);
		Expr next = Assignment_Statement(z);
		switch(ts.tok) {
		case 'x':
			Expr LHV = Letter_Space(next); Expr add = Adding_Operator(LHV);	Expr yval = Letter_Space(add);
			Expr en = Semicolon(yval);	Expr wr = Statement(en); Expr let = Letter_Space(wr);
			Expr close = Semicolon(let);
			Expr fin = finish(close);
			return fin;
		case '(':
			Expr variable = var(next);
			return variable;
		default:
			Expr LHV2 = Letter_Space(next); Expr add2 = Adding_Operator(LHV2);	Expr yval2 = Letter_Space(add2);
			Expr en2 = Semicolon(yval2);	Expr wr2 = Statement(en2); Expr let2 = Letter_Space(wr2); Expr close2 = Semicolon(let2);
			switch(ts.tok) {
			case '.':
				ts.next();
				System.out.println("Not allowed");
			case '-':
				ts.next();ts.next();
				System.out.println("Not allowed");
			}
			Expr fin2 = finish(close2);
			return fin2;
		}
	}
	
	Expr Sign(Expr inval) {
		switch(ts.tok) {
		case '+':
			ts.next();return new Sign(inval,'+');
		case '-':
			ts.next();return new Sign(inval,'-');
		case '*':
			ts.next();return new Sign(inval,'*');
		case ' ':
			ts.next();return new Sign(inval,' ');
		}
		return inval;
	}
	
	Expr Condition(Expr inval) {
		Expr l = Letter_Space(inval);
		Expr rel = Relational_Operator(l);
		Expr m = Letter_Space(rel);
		Expr par = Close(m);
		return par;
	}
	
	Expr Adding_Operator (Expr inval) {
		switch(ts.tok) {
		case '+':
			ts.next(); return new Adding_Operator(inval,'+');
		case '-':
			ts.next() ;return new Adding_Operator(inval,'-');
		case 'o':
			ts.next();
			switch(ts.tok) {
			case 'r':
				ts.next();
			}    
		case ' ':
			ts.next(); return new Adding_Operator(inval,' ');
		}
		return null;
	}
	
	Expr Paren(Expr inval) {
		Expr cl = Special_Symbols(inval);
		Expr mull = Multiplying_Operator(cl);
		Expr spec = Operate(mull);
		return spec;
	}
	
	Expr Term (Expr inval) {
		Expr val = Factor(inval);
		Multiplying_Operator(inval);
		return val;
	}
	
	Expr Stated(Expr inval) {
		Expr semi = Semicolon(inval);
		Expr state = Statement(semi);
		Expr letter = Letter_or_Digit(state);
		Expr spec = Semicolon(letter);
		Expr en = finish(spec);
		return en;
	}
	
	Expr Factor(Expr inval) {
		switch(ts.tok) {
		case 'n':
			ts.next();
			switch(ts.tok) {
			case 'o':
				ts.next();
				switch(ts.tok) {
				case 't':
					ts.next(); 
				}
			}
		case '(':
			ts.next();
			return new Factor(inval,'(');
		default:
			Expr numb = Constant(inval);
			return numb;
		}
	}
	
	Expr finish (Expr inval) {
		switch(ts.tok) {
		case 'e':
			ts.next();
			switch(ts.tok) {
			case 'n':
				ts.next();
				switch(ts.tok) {
				case 'd':
					ts.next();
					switch(ts.tok) {
					case '.':
						ts.next();
						return new End(inval,"end.");
					}
				}
			}
		}
		return null;
	}
	
	Expr Variable (Expr inval) {
		switch(ts.tok) {
		case ',':
			ts.next();
		}
		Expr go = Entire_Variable(inval);
		return go;
	}
	
	Expr Indexed_Variable(Expr inval) {
		Expr arr = Array_Variable(inval); 
		switch(ts.tok) {
		case '[':
		}
		switch(ts.tok) {
		case ']':
			ts.next();
		}
		return arr;
	}
	
	Expr var(Expr inval) {
		Expr exp = Factor(inval);
		Expr LHV = Letter_Space(exp);
		Expr add = Adding_Operator(LHV);
		Expr yval = Letter_Space(add);
		Expr cont = Continue(yval);
		return cont;
	}
	
	Expr Array_Variable(Expr inval) {
		Expr array = Entire_Variable(inval);
		return array;
	}
	
	Expr Entire_Variable(Expr inval) {
		Expr go = Variable_Identifier(inval);
		return go;
	}
	
	Expr Variable_Identifier(Expr inval) {
		Expr go = Letter_Space(inval);
		Expr close = Special_Symbols(go);
		Expr end = Semicolon(close);
		return end;
	}
	
	Expr Constant(Expr inval) {
		Expr value = Letter_or_Digit(inval);
		return value;
	}
	
	Expr Multiplying_Operator(Expr inval) {
		switch(ts.tok) {
		case '*':
			ts.next();return new Multiply_Op(inval,"*");
		case 'd':
			ts.next();
			switch(ts.tok) {
			case 'i':
				ts.next();
				switch(ts.tok) {
				case 'v':
					ts.next();return new Multiply_Op(inval,"div");
				}
			}
		case 'a':
			ts.next();
			switch(ts.tok) {
			case 'n':
				ts.next();
				switch(ts.tok) {
				case 'd':
					ts.next(); 
					return new Multiply_Op(inval,"and");
				}
			}
		}
		return inval;
		
	}
	
	Expr Continue(Expr inval) {
		Expr close = Special_Symbols(inval); Expr var = Multiplying_Operator(close);Expr finish = Letter_or_Digit(var);
		Expr cont = Second(finish);
		return cont;
	}
	
	Expr Relational_Operator(Expr inval) {
		switch(ts.tok) {
		case '=':
			ts.next();
		case '<':
			ts.next();
			switch(ts.tok) {
			case '=':
				ts.next();
				return new Relation(inval,"<=");
			}
		case '>':
			ts.next();
			switch(ts.tok) {
			case '=':
				ts.next();
			default: ts.next();
			}
		
		}
		return null;
		
	}
	
	Expr Procedure_Statement(Expr inval) {
		Expr id = Procedure_Identifier(inval);
		return id;
	}
	
	Expr Procedure_Identifier(Expr inval) {
		Expr name = Letter_or_Digit(inval);
		return name;
	}
	
	Expr Read_Statement(Expr inval) {
		switch(ts.tok) {
		case 'r':
			ts.next();
			switch(ts.tok) {
			case 'e':
				ts.next();
				switch(ts.tok) {
				case 'a':
					ts.next();
					switch(ts.tok) {
					case 'd':
						ts.next();
						switch(ts.tok) {
						case '(':
							ts.next();
							return new Read(inval,"read(");
						}
					}
				}
			}
		case 'e':
			ts.next();
		case 'a':
			ts.next();
		case 'd':
			ts.next();
		case '(':
			ts.next(); 
		}
		return inval;
	}   
	
	Expr Second(Expr inval) {
		Expr var = Special_Symbols(inval);
		Expr next = Special_Symbols(var);Expr place = Letter_or_Digit(next);Expr multiply = Multiplying_Operator(place);
		Expr go = Third(multiply);
		return go;
	}
	
	Expr Input_Variable(Expr inval) {
		switch(ts.tok) {
		case ',':
			ts.next();
		}                                                               
		Expr go = Variable(inval);
		return go;                                           
	}
	
	Expr Write_Statement(Expr inval) {
		switch (ts.tok) {
		case 'w':
			ts.next();
			switch(ts.tok) {
			case 'r':
				ts.next();
				switch(ts.tok) {
				case 'i':
					ts.next();
					switch(ts.tok) {
					case 't':
						ts.next();
						switch(ts.tok) {
						case 'e':
							ts.next();
							switch(ts.tok) {
							case '(':
								ts.next();
								return new Write(inval,"write(");
							}
						}
					}
				}
			}
		case 'r':
			ts.next();
		case 'i':
			ts.next();
		case 't':
			ts.next();
		case 'e':
			ts.next();
		case '(':
			ts.next(); Output_Value(inval);
		case ')':
			ts.next();
		}
		return null;
	}
	
	Expr Output_Value(Expr inval) {
		Expr par = Semicolon(inval);
		Expr end = finish(par);
		return end;
	}
	
	Expr Third(Expr inval) {
		Expr op = Special_Symbols(inval);
		Expr LHV = Letter_Space(op);Expr add = Adding_Operator(LHV);Expr yval = Letter_Space(add);
		Expr en = Special_Symbols(yval);
		Expr done = Paren(en);
		return done;
	}
	
	Expr Structured_Statement(Expr inval) {
		switch(ts.tok) {
		case 'b':
			Compound_Statement(inval);
		case 'i':
			Expr in = If_Statement(inval);
			return in;
		case 'w':
			Expr whi = While_Statement(inval);
			return whi;
		}
		return inval;
		
	}
	
	Expr Final(Expr inval) {
		Expr en = Semicolon(inval);
		Expr state = Simple_Statement(en);
		Expr let = Letter_Space(state);
		Expr m3 = Output_Value(let);
		return m3;
	}
	
	Expr If_Statement(Expr inval) {
		switch(ts.tok) {
		case 'i':
			ts.next();
			switch(ts.tok) {
			case 'f':
				ts.next();
				switch(ts.tok) {
				case '(':
					ts.next();
				}
				return new If(inval,"if(");
				
			}
		}
		return null;
		
	}
	
	Expr Then(Expr inval) {
		switch(ts.tok) {
		case 't':
			ts.next();
			switch(ts.tok) {
			case 'h':
				ts.next();
				switch(ts.tok) {
				case 'e':
					ts.next();
					switch(ts.tok) {
					case 'n':
						ts.next();
						return new Then(inval,"then");
					}
				}
			}
		}
		return null;
	}
	
	Expr Multi_Line(Expr inval) {
		return new MultiLineComment(inval,"{*") ;
	}
	
	Expr Multi_Close(Expr inval) {
		return new MultiLineComment(inval,"*}");
	}
	
	Expr Let() {
		switch(ts.tok) {
		case 'a':
			ts.next(); return new Multi('a');
		case 'b':
			ts.next(); return new Multi('b');
		case 'c':
			ts.next(); return new Multi('c');	
		case 'd':
			ts.next(); return new Multi('d');
		case 'e':
			ts.next(); return new Multi('e');
		case 'f':
			ts.next(); return new Multi('f');
		case 'g':
			ts.next(); return new Multi('g');
		case 'h':
			ts.next(); return new Multi('h');
		case 'i':
			ts.next(); return new Multi('i');
		case 'j':
			ts.next(); return new Multi('j');
		case 'k':
			ts.next(); return new Multi('k');
		case 'l':
			ts.next(); return new Multi('l');
		case 'm':
			ts.next(); return new Multi('m');
		case 'n':
			ts.next(); return new Multi('n');
		case 'o':
			ts.next(); return new Multi('o');
		case 'p':
			ts.next(); return new Multi('p');
		case 'q':
			ts.next(); return new Multi('q');
		case 'r':
			ts.next(); return new Multi('r');
		case 's':
			ts.next(); return new Multi('s');
		case 't':
			ts.next(); return new Multi('t');
		case 'u':
			ts.next(); return new Multi('u');
		case 'v':
			ts.next(); return new Multi('v');
		case 'w':
			ts.next(); return new Multi('w');
		case 'x':
			ts.next(); return new Multi('x');
		case 'y':
			ts.next(); return new Multi('y');
		case 'z':
			ts.next(); return new Multi('z');
		}
		return null;
	}
	
	
	Expr Else(Expr inval) {
		switch(ts.tok) {
		case 'e':
			ts.next();
			switch(ts.tok) {
			case 'l':
				ts.next();
				switch(ts.tok) {
				case 's':
					ts.next();
					switch(ts.tok) {
					case 'e':
						ts.next();
						return new Else(inval,"else");
					}
				}
			}
		}
		return null;
	}
	
	Expr While_Statement(Expr inval) {
		switch(ts.tok) {
		case 'w':
			ts.next();
			switch(ts.tok) {
			case 'h':
				ts.next();
				switch(ts.tok) {
				case 'i':
					ts.next();
					switch(ts.tok) {
					case 'l':
						ts.next();
						switch(ts.tok) {
						case 'e':
							ts.next();
							return new While(inval,"while");
						}
					}
				}
			}
		}
		return null;
	}
	
	Expr dowhile (Expr inval) {
		switch(ts.tok) {
		case 'd':
			ts.next();
			switch(ts.tok) {
			case 'o':
				ts.next();
				return new While(inval,"do");
			}
		}
		return null;
	}
	
	Expr SingleLineComment(Expr inval) {
		return new Comment(inval,"//");
	}
	
	Expr parse (){
		return Start();
	}
	
	
}
