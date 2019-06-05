package com.company;

public class PrepTest {

    public static void main(String[] args) {
	// write your code here

        // LEGAL ARR DECLARATIONS
        char [] myChars;
        int [] x = new int[] {2,4,5};
        int [] myScores [];

        //Car carArray [];
        char [] array2 [] [];
        int [] [] array1;

        // WHATS THE RESULT
        int[] arr1 = new int[1];
        int[] arr2 = new int[1];
        arr1[0] = arr2[0] = 1;
        System.out.println( "Array 1 equals array 2 - " + arr1.equals( arr2 ) );
        // Array 1 equals array 2 - false
        // NE sravnqvame stoinostite a samiq array


        /*class Alpha {
            static class Beta {
                public static int i;
            }
        }
        System.out.println( Alpha.Beta.i );
        // RESULT: 0
        */

        /*
            String a = "grape";
            String b = a;
            a = "banana";
            String c = a;
            System.out.println(" b = " + b + " c = " + c);
            // b = grape c = banana
        */

        /*
        for (int x = 3; x > 0; x--) {
            switch (x - 1) {
                     0: System.out.print("foo ");
                     1: System.out.print("bar ");
                     2: System.out.print("baz ");
                     3: System.out.print("foo ");
                   }
        }
        COMPILATION FAILS
        */

        String aa = "freddy";
        String bb = aa.toUpperCase();
        aa.replace('f', 't');
        System.out.println( aa+= bb);
        // RESULT: freddyFREDDY


        String a = "door";
        String b = "bell";
        a.substring(0,2);
        a.concat("ring");
        System.out.println(a += "buzzer" + b.toUpperCase());
        // RESULT: doorbuzzerBELL

    }
}

/*
What's the output
     1. class Test {
     2.    int doStuff () {
     3.       return 99;
     4. }
     5.
     6. public static void main(String args [] ) {
     7.    Test t = new Test1();
  -> 8.    t.printStuff(args[1]);
     9.   }
     10.
     11. abstract void printStuff(String s);
     12. }

     13. class Test1 extends Test {
     14.      void printStuff(String argh) {
     15.         System.out.println(argh);
     16.   }
     17. }

Input: Java Test A B
OUTPUT: A
 */

/*
     1.
     2. public class NewCollections {
     3.   public static void main(String [] args) {
  -> 4.     java.util.WeakHashMap hm = new java.util.WeakHashMap();
     5.     Object o1 = null;
     6.     o1 = hm.put(o1, o1);
     7.   }
     8. }

 NO STATEMENT REQUIRED!!!!
We are using it from the library directly
 */

/*
     1. interface XX {}
     2. interface YY extends XX {}
     3. abstract class ZZ implements XX {}
     4. class AA extends ZZ implements YY {
     5.   private class BB{}
     6. }
     7. class Main extends AA {
     8.   public static void main( String[] args ) {
  -> 9.      XX xx1 = new XX ();
     10.     XX xx2 = new AA ();
     11.     ZZ zz1 = new Main ();
  -> 12.     Main m = new AA();
     13.   }
     14. }

LINE 9  UNCOMPILABLE
LINE 12 UNCOMPILABLE

 */


/*
     10. public void op2( String s ) {
  -> 11.   s.toUpperCase();
     12. }
     13. public void immutabilityTest () {
     14.   String msg = new String("Hello");
     15.   op2(msg);
     16.   System.out.println( msg );
     17. }

OUTPUT Hello - NO RETURN
 */

/*
     1. public class Test {
     2.    _____ doMath ( long l, short s) {
     3.     return (int) s / (l * 10);
     4.    }
     5. }

doMath returns long
 */

/*
     10. abstract class X {
     11.   public final void op(){}
  -> 12.   abstract final void op();
     13.   void op( String s ){}
  -> 14.   abstract synchronized void op(int i) throws Exception;
  -> 15.   abstract private void op( String a, int i );
     16. }

Errors in:
LINE 12, 14, 15

 */


/*
     new U().doIt() method

     10. interface R {
     11.   void op();
     12. }
     13. class S implements R {
     14.   void op(){}
     15. }
     16. class T extends S {}
     17. class U extends T {
     18.    public void doIt() {
     19.       super.op();
     20.    }
     21. }

// An exception is thrown at runtime
 */


/*
Whats valid for interface

 -> a. short doShort(); Правилно
    b. protected byte doByte();
 -> c. public boolean doBoolean(int x);
    d. static char doChar(); Неправилно
    e. final public String doString(int x);

// a, c

 */

/*
     1. for (int x = 3; x > = 0; x--) {
     2.    switch (x - 1) {
     3.      case 0: System.out.print("foo ");
     4.      case 1: System.out.print("bar ");
     5.      case 2: System.out.print("baz ");
     6.      case 3: System.out.print("foo ");
     7.    }
     8. }

RESULT: baz foo bar baz foo foo bar baz foo
 */

/*
     10. final int MAX=3;
     11. int j = 0;
     12. for ( int i=0; i<MAX; i++, j++ ) {
     13.    System.out.print( i );
     14. }
     15. System.out.println( j*i );

COMPILATION FAILS!
 */

/*
ArrayList

    a. It implements java.util.Set
 -> b. Can be iterated bi-directionally Правилно
 -> c. It can contain duplicates Правилно
    d. Its methods are thread-safe
    e. It implements java.util.Collections

RESULT b, c
*/


/*
     1. public class Test826 {
     2.   public static void main(String [] args) {
     3.     String s = "banana";
     4.     s = s.substring(1,3);
     5.     s.substring(1,2);
     6.     System.out.println(" s = " + s);
     7.   }
     8. }

RESULT: "an"
 */

/*
    int getSum() {
        short x;
        int[] y = new int[4];
        y[0] = x;
        y[1] = x + 1;
        for (int z = 3; z > -1; z--) {
            System.out.println(" " + y[z]);
        }
    }
    compilation fails
    NO RETURN STATEMENT FOR INT
    */


/*
WHATS TRUE
     1. interface D {}
     2.   class E implements D {}
     3.   class F extends E {
     4.     F() {}
     5.   }
     6.   class G extends F implements D {}
     7.   class X {
     8.      public static void main( String[] args ) {
     9.         F f = new E();
  -> 10.        D d = new G();
     11.     }
     12.  }

A variable can be declared using an interface type
Compilation fails
The assignment at line 10 is legal
 */

/*
What is the result?
     1. public class Test812 {
     2.    public static void main(String [] args) {
     3.      double y = 24.7;
     4.      double a = Math.abs(y);
     5.      double b = Math.ceil(y);
     6.      double c = Math.floor(y);
     7.      double d = Math.round(y);
     8.      double e = Math.min(14.78,56.3);
     9.     System.out.print( "Results: " + a + " " + b + " " + c + " " + d + " " + e);
     10.   }
     11. }

a. Results: 24.7 25.0 24.0 25.0 14.78 Правилно
 */

/*
Which two statements are true of class java.util.HashMap? (Choose two.)
Изберете едно или повече:
 -> a. Its elements can be accesssed using a unique key. Правилно
    b. It implements java.util.Hashable.
    c. Its methods are thread-safe. Неправилно
    d. It provides fast, bi-directional iteration.
 -> e. It allows null references to be stored.
    f. It tracks when its elements were last accessed.

Its elements can be accesssed using a unique key. Правилно
It allows null references to be stored.
 */

/*
Which two are true about the default constructors? (Choose two.)

Изберете едно или повече:
 -> a. The default constructor is created only when the class has no constructors defined Правилно
    b. The default constructor inherits the arguments of the superclass constructor
    c. The default constructor is always public
    d. The compiler creates a default constructor if the class does not have a no-arg constructor defined
 -> e. The default always invokes the no-arg superclass constructor Правилно

 */


