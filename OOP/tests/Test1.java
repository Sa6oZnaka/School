package com.company;


public class Test1 {

    static short [] x = new short[3];

    public static void main(String[] args) {


        x[1] = 7;
        for (int y= 0;y<3; y++) {
            System.out.print(" " + x[y]);
        }
        // 0 7 0



        int x = -1, y = -2;
        System.out.println((x < 0) ^ (y < 0));
        // false

        int a = 0xfa0f;
        int b = 0x05f0;
        int c = 0x000f;
        System.out.println(((a & b) ^ c) >= 16);
        // false

        String[] xyz = new String[4];
        String abc = xyz[2];
        System.out.println("output = " + xyz[1] + " " + abc);
        // output = null null


        /*
            int rand = (int) Math.random(42);
            System.out.print(rand);
            // compilation FAILS
        */


        // IMPORTANT
        /*
        argv in main will contain
        [ "one", "two" ]
        after running
        java MyProgram one two

        */


        /*
            public static void op1(String s) {
                s += new String("Sailor");
            }
            String msg = new String("Hello");
            op1(msg);
            System.out.println(msg);
            // Output: Hello
        */

        /*
            class A {
                private static class B {
                    private static String msg = "ok";
                }

                public static String access() {
                    return B.msg;
                }
            }
            System.out.println(A.access());
            // ok

        */


    }


    /*
         public class Stuff {
              public Stuff doStuff(int z) { return this; }
         }

         class Y extends Stuff {

         }

         // WHATS gonna cause comilation error?
         // public void doStuff(int z) { }
      */

    /*
            1. class XXX {
            2.   long doStuff (int input) {
            3.     static long x = 7;
            4.     return (long) input / x;
            5.   }
            6.
            7.   public static void main(String [] args) {
            8.      XXX xxx = new XXX();
            9.      System.out.println(xxx.doStuff(42));
            10.  }
            11. }

            // COMPILATON FAILS
            */

        /*
         1. public class Test243 {
         2. public static void main (String [] args) {
         3.      try {
         4.          String s = "two";
         5.          int i = Integer.parseInt(s);
         6.          System.out.print("i = " + i);
         7.      } catch (Exception ex) {
         8.          System.out.print(" Exception ");
      -> 9.      } catch(NumberFormatException exc) {
         10.         System.out.print(" NumberFormatException ");
         11.     } finally {
         12.         System.out.print(" finally ");
         13.     }
         14.        System.out.print(" done ");
         15.   }
         16. }

     COMPILATION FAILS
     */


        /*
        WAYS TO CONVERT SHORT
            short x = Short.parseShort(s);
            short x = Short.valueOf(s).shortValue();

         */



        // Which interface guarantees that no duplicates are stored?
        //
        // SET
        // SET
        // SET
        // SET
        // SET
        // SET
        // SET
        // SET
        // SET

        // Which interface does NOT declare methods?
        // LIST
        // LISt

        // Which two are keywords? (Choose two.)
        // super, interface
        // super, interface
        // super, interface
        // super, interface
        // super, interface

        // Which declaration ensures that a class cannot be subclassed?
        //  final abstract class MyClass { }
        //  final abstract class MyClass { }
        //  final abstract class MyClass { }

        // Which two are true about encapsulation? (Choose two.)
        //
        // Encapsulation is also known as "data hiding" Correct
        // Encapsulation can best be provided through public access modifiers

        // What is the numerical range of a byte?
        //
        // -128 to 127
        // -128 to 127

}

