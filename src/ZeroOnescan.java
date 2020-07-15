

import java.io.*;
class ZeroOnescan extends Tokenstream {
	private StreamTokenizer strtok;
	public ZeroOnescan(String filename) {
	try {
		strtok = new StreamTokenizer(new FileReader(filename));
		setup();
		next();
		} catch (IOException e)
			{ throw new Tokenerror("Error opening file " + filename); }
	}

		private void setup() {
		strtok.resetSyntax();
		strtok.whitespaceChars(' ', ' ');
		strtok.whitespaceChars('\t', '\t');
		strtok.whitespaceChars('\n', '\n');
		strtok.whitespaceChars('\r', '\r');
		}
		public void next() {
			if (tok != EOF)
				try {
					tok = strtok.nextToken();
					switch (tok) {
					case StreamTokenizer.TT_EOF:
						tok = EOF; break;
					case '0': case '1': case '2': case '3': case '4': case '5': 
					case '6': case '7': case '8': case '9': case 'a': case 'b':
					case 'c': case 'd': case 'e': case 'f': case 'g': case 'h':
					case 'i': case 'j': case 'k': case 'l': case 'm': case 'n':
					case 'o': case 'p': case 'q': case 'r': case 's': case 't':
					case 'u': case 'v': case 'w': case 'x': case 'y': case 'z':
					case 'A': case 'B': case 'C': case 'D': case 'E': case 'F': 
					case 'G': case 'H': case 'I': case 'J': case 'K': case 'L':
					case 'M': case 'N': case 'O': case 'P': case 'Q': case 'R':
					case 'S': case 'T': case 'U': case 'V': case 'W': case 'X': 
					case 'Y': case 'Z': case '-': case '+': case '*': case '/': 
					case '(': case ')': case '.': case ':': case '=': case '[':
					case ']': case ',': case ';': case '<': case '>': case '{':
					case '}': case '~': case '#': case '|': case '_': case '$':
						break;
					default:
						throw new Tokenerror("Illegal token " + this);
					}
				} catch (IOException e) { 
					throw new Tokenerror(e.getMessage());
				}
		}

		public String toString() {
			switch (tok) {
			case StreamTokenizer.TT_EOF: case EOF:
				return "<EOF>";
			default:
				return "" + (char)tok;
			}
		}
}

class Tokenerror extends IllegalArgumentException {
	public Tokenerror(String s)
	{ super(s); }
}
