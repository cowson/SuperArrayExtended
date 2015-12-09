/*
Niels Graham, Matthew So 
APCS pd10
hw44 --  This or That or Fourteen Other Things
2015-12-7
*/


//skeleton file for class Binary

public class Hexadecimal{

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";
    
    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHexR(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
        _hexNum = s;
	_decNum = hexToDec(s);
	
    }


    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
        return _hexNum ;
    }


    /*=====================================
      String decToBin(int) -- converts base-10 input to binary
      pre:  n >= 0
      post: returns String of bits
      eg  decToBin(0) -> "0"
      decToBin(1) -> "1"
      decToBin(2) -> "10"
      decToBin(3) -> "11"
      decToBin(14) -> "1110"
      =====================================*/
    public static String decToHex( int n ) {
	String retStr ="";
	int hexPlace;
	while (n > 0){
	    hexPlace = n%16;
	    retStr = HEXDIGITS.charAt(hexPlace) + retStr;
	    n /= 16;
	}
	return retStr;
    }


    /*=====================================
      String decToBinR(int) -- converts base-10 input to binary, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToBinR(0) -> "0"
      decToBinR(1) -> "1"
      decToBinR(2) -> "10"
      decToBinR(3) -> "11"
      decToBinR(14) -> "1110"
      =====================================*/
    public static String decToHexR( int n ) {
	if (n <= 0){
		return "";}
	else{
	    int hexPlace = n%16;
	    return "" + (decToHex (n / 16)) + HEXDIGITS.charAt(hexPlace);
	}
    }


    /*=====================================
      String binToDec(String) -- converts base-10 input to binary
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDec("0") -> 0
      binToDec("1") -> 1
      binToDec("10") -> 2
      binToDec("11") -> 3
      binToDec("1110") -> 14
      =====================================*/
  public static int hexToDec( String s ) {
	int ret = 0;
	for ( int i = 0; i < s.length(); i++){
	    ret += Math.pow(16,i) * HEXDIGITS.indexOf(( s.substring ( s.length() - i, s.length() - i + 1))); //multiply whats in the first position by its corresponding power then add that to the return int val
	}
	return ret;
    }


    /*=====================================
      String binToDecR(String) -- converts base-10 input to binary, recursively
      pre:  s represents non-negative binary number
      post: returns decimal equivalent as int
      eg  
      binToDecR("0") -> 0
      binToDecR("1") -> 1
      binToDecR("10") -> 2
      binToDecR("11") -> 3
      binToDecR("1110") -> 14
      =====================================*/
    public static int hexToDecR( String s ) { 
	if (s.length() < 0)
	    return 0;
	else
	    return (hexToDecR(s.substring(1,s.length()))) + 16*(HEXDIGITS.indexOf(s.charAt(0)));
	     
    }


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	boolean retVal = this == other;
	if (!retVal){
	    retVal = other instanceof Hexadecimal && (this.compareTo((Hexadecimal)other) ==0);
	}
	return retVal;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimalobjects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (! (other instanceof Hexadecimal))
	    throw new ClassCastException("\n My first Error Message" + "compareTo() input not a binary");
	
	Hexadecimal Hexadecimaltemp = (Hexadecimal)(other);
	if (Hexadecimaltemp._decNum == this._decNum)
	    return 0;
	if (Hexadecimaltemp._decNum < this._decNum)
	    return 1;
	if (Hexadecimaltemp._decNum > this._decNum)
	    return -1;
	else
	    System.out.println("error");
	return -2;
		
    }


    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal b1 = new Hexadecimal(1213423);
	Hexadecimal b2 = new Hexadecimal(5);
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(7);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos
	System.out.println( b1.compareTo(3) );
	
	}//end main()
	      
} //end class
