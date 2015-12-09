/*
Niels Graham, Matthew So 
APCS pd10
hw44 --  This or That or Fourteen Other Things
2015-12-7
*/


//skeleton file for class Binary

public class Binary {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF";
    
    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _binNum to "0"
      =====================================*/
    public Hex() { 
	_decNum = 0;
	_hexNum = "0";
    }


    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _binNum to equiv string of bits
      =====================================*/
    public Hex( int n ) {
	_decNum = n;
	_hexNum = decToBin(n);
    }


    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative binary number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hex( String s ) {
        _hexNum = s;
	_decNum = binToDec(s);
	
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
	String retStr = ""; 
	int v = 1;
        while (v <= n/2) {
            v = v * 2;
        }
        while (v > 0) {
            if (n < v) {
                retStr += "0";
            }
            else {
                retStr += "1";
                n = n - v;
            }
            v = v / 2;
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
    //  public static String decToHexR( int n ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
    //}


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
        double j=0;
	for(int i=0;i<s.length();i++){
	    if(s.charAt(i)== '1'){
		j=j+ Math.pow(2,s.length()-1-i);
	    }
	    
	}
	return (int) j;
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
    //    public static int HextoDecR( String s ) { 
	/****** YOUR IMPLEMENTATION HURRR ******/   
    //}


    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Binary
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal binary values
      =============================================*/
    public boolean equals( Object other ) { 
	boolean retVal = this == other;
	if (!retVal){
	    retVal = other instanceof Binary && (this.compareTo((Binary)other) ==0);
	}
	return retVal;
    }


    /*=============================================
      int compareTo(Object) -- tells which of two Binary objects is greater
      pre:  other is instance of class Binary
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo( Object other ) {
	if (! (other instanceof Binary))
	    throw new ClassCastException("\n My first Error Message" + "compareTo() input not a binary");

	Binary temp = (Binary)(other);
	if (temp._decNum == this._decNum)
	    return 0;
	if (temp._decNum < this._decNum)
	    return 1;
	if (temp._decNum > this._decNum)
	    return -1;
	else
	    System.out.println("error");
	return -2;
		
    }


    //main method for testing
    public static void main( String[] args ) {

	System.out.println();
	System.out.println( "Testing ..." );

	Binary b1 = new Binary(5);
	Binary b2 = new Binary(5);
	Binary b3 = b1;
	Binary b4 = new Binary(7);

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
