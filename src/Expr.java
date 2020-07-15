
abstract class Expr {
	abstract public String toString();

}

class Program extends Expr {
	public String toString()
	{
		return "program";
	}
}

class Letter extends Expr {
	Expr e1;
	char e2;

	public Letter(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + " " + e2;
	}
	
}

class Letter_or_Digit extends Expr {
	Expr e1;
	String e2;

	public Letter_or_Digit(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Semicolon extends Expr {
	Expr e1;
	char e2;

	public Semicolon(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 +"\n";
	}
	
}

class Var_Dec extends Expr {
	Expr e1;
	String e2;

	public Var_Dec(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 +"";
	}
	
}

class Special extends Expr {
	Expr e1;
	char e2;

	public Special(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class line extends Expr {
	Expr e1;
	char e2;

	public line(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 + "\n";
	}
	
}

class Type extends Expr {
	Expr e1;
	String e2;

	public Type(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 +"";
	}
	
}

class Compound extends Expr {
	Expr e1;
	String e2;

	public Compound(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 +"\n";
	}
	
}

class Read extends Expr {
	Expr e1;
	String e2;

	public Read(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Assign extends Expr {
	Expr e1;
	String e2;

	public Assign(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Digit extends Expr {
	Expr e1;
	char e2;

	public Digit(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 + "\n";
	}
	
}

class Sign extends Expr {
	Expr e1;
	char e2;

	public Sign(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Adding_Operator extends Expr {
	Expr e1;
	char e2;

	public Adding_Operator(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Write extends Expr {
	Expr e1;
	String e2;

	public Write(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class End extends Expr {
	Expr e1;
	String e2;

	public End(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Factor extends Expr {
	Expr e1;
	char e2;

	public Factor(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Multiply_Op extends Expr {
	Expr e1;
	String e2;

	public Multiply_Op(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class If extends Expr {
	Expr e1;
	String e2;

	public If(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Relation extends Expr {
	Expr e1;
	String e2;

	public Relation(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
	
}

class Then extends Expr {
	Expr e1;
	String e2;

	public Then(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + " " + e2 + "\n";
	}
	
}

class Procedure extends Expr {
	Expr e1;
	String e2;

	public Procedure(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 + " ";
	}
	
}

class Arr extends Expr {
	Expr e1;
	String e2;

	public Arr(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + " " + e2 + "\n";
	}
	
}

class While extends Expr {
	Expr e1;
	String e2;

	public While(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + " " + e2 + "\n";
	}
	
}

class Else extends Expr {
	Expr e1;
	String e2;

	public Else(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 + "\n";
	}
	
}

class Minus extends Expr {
	Expr e1, e2;
	
	public Minus(Expr e1, Expr e2) {
		this.e1 = e1; this.e2 = e2;
	}
	public String toString()
	{
		return e1 + "-" + e2;
	}
}

class Plus extends Expr {
	Expr e1, e2;
	
	public Plus(Expr e1, Expr e2) {
		this.e1 = e1; this.e2 = e2;
	}
	public String toString()
	{
		return e1 + "+" + e2;
	}
}

class Multiply extends Expr {
	Expr e1, e2;
	
	public Multiply(Expr e1, Expr e2) {
		this.e1 = e1; this.e2 = e2;
	}
	public String toString()
	{
		return e1 + "*" + e2;
	}
}

class Divide extends Expr {
	Expr e1, e2;
	
	public Divide(Expr e1, Expr e2) {
		this.e1 = e1; this.e2 = e2;
	}
	public String toString()
	{
		return e1 + "/" + e2;
	}
}

class Period extends Expr {
	Expr e1;
	char e2;

	public Period(Expr inval, char c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + " " + e2;
	}
	
}

class Comment extends Expr{
	Expr e1;
	String e2;

	public Comment(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
}

class Comment_Letter extends Expr{
	Expr e1;
	String e2;

	public Comment_Letter(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2+"\n";
	}
}

class Multi extends Expr{
	
	char e1;
	
	public Multi(char inval) {
		e1 = inval;
	}
	public String toString() {
		return e1 +"";
	}
	
}

class var extends Expr{
	Expr e1;
	String e2;
	
	public var(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
}

class close extends Expr{
	Expr e1;
	String e2;

	public close(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2+"\n";
	}
}

class pro extends Expr{
	Expr e1;
	String e2;

	public pro(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2+"\n";
	}
}

class MultiLineComment extends Expr{
	Expr e1;
	String e2;

	public MultiLineComment(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2+"\n";
	}
}

class Array_Var extends Expr{
	Expr e1;
	String e2;
	
	public Array_Var(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 +" ";
	}
	
}

class proID extends Expr {
	Expr e1;
	String e2;
	
	public proID(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2;
	}
}

class Ends extends Expr {
	Expr e1;
	String e2;
	
	public Ends(Expr inval, String c) {
		e1 = inval;
		e2 = c;
	}
	public String toString()
	{
		return e1 + "" + e2 +"\n";
	}
}

