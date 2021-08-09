/*
* In Kotlin, you can benefit from coding in the top-level.
* The code that you write in Java needs to be run in the main method and also
* the main method needs to be encapsulated in a class.
* However, in Kotlin, instead of creating a class for the purpose of running code,
* you can open a Kotlin file
* and start your process through main function.
*
* One different thing here is that you necessarily don't need to provide arguments for the
* main method/ function. The example below works perfectly.
* */

/*
fun main() {
    println("hello, world!")
}
*/

/*
* And obviously, if you want to use then commandline arguments, then you have to specify the parameters like Java
* */


/*
* Is it possible to call a top-level function from Java? If yes, how?
	You call it as a static function of the class, which name corresponds to the file name

* for example, imagine you have a MyFileKt.kt kotlin file as:
*
    package intro
    fun foo() = 0

    * In Java:
    in Java
        package other;
        import intro.MyFileKt;
        public class UsingFoo {
	        public static main(String[] args) {
	        MyFilekt.foo();
            }
        }

    You can also put @file:JvmName(“whatever”)
    and call it in Java like “Whatever”.foo()
*
* */


/*
* Note two things here:
*   1- Unlike OCaml, you can have different data types in different branches of your if statement.
*   In OCaml, saying if (condition) then 1 else "Amir" is illegal, but Kotlin's type inference allows that.
*
*   2- To involve a value in the String, you use $reference.
*       You can also send the control inside another method, and then have it back by it's return|default to main
*       Just pay attention to the order that the things get printed. (kinda weird)
*
* Look at the foo example in the main and pay attention to the order of the prints.
* */
fun main(args: Array<String>) {
    val message = if (args.size > 0) "Kotlin" else "Amir"
    println("hello, $message")
    println("SEE! ${foo(3)}")

    /*
    * Let's talk about variables.
    * There are two type of variables regardless of their data type.
    * var and val
    * var is mutable and val is immutable.
    *
    * The important thing to notice here is that the val keyword doesn't enforce more in-depth rules to their reference.
    * Imagine you have a mutable list referenced by a val.
    * Val still allows you change the contents of the list
    * but you can't make it refer to something else.
    *
    * Generally, it is considered a better style to use var if possible
    * */

    val myList = mutableListOf<Int>(1,2,3)
    myList.add(4) // this is allowed!
    // myList = mutableListOf(1); the compiler complains.

    /*
    * For now, know that there are two types of lists. Mutable & immutable. ListOf: immutable and mutableListOf()
    * for making mutable lists.
    * */

        /*
        * This is here to show
        * */
    println("value is ${max(4, 1)}")


    displaySeparator()
    displaySeparator(size = 4)
    displaySeparator('a')

}

fun foo(times: Int): String {
    repeat(times) {
        println("inside foo")
    }
    return "getting out of foo"
}

/*
* 1- If-clauses are expressions in Kotlin, so they return the value of their branch
* 2- This function only has one single expression.So, you can change it to a Expression-Body function
*
fun max(a: Int, b: Int): Int {
    return if (a >= b) a else b
}
*/
// for 2: and you call it as you call any other function. Look at the main function
fun max(a: Int, b: Int): Int = if (a >= b) a else b

// NAMED AND DEFAULT ARGUMENTS:

/*
* In Java, you can overload a method and call it with different number of arguments.
* For example:
*
*   String sayHi() {
*       return "world";
*   }
*
* String sayHi(String name) {
*       return "Hi" + name;
*   }
*
*
* In kotlin, all you have to do is to provide a default argument for an arbitrary
* parameter. Kotlin will implement the needed methods under the hood automatically.
* (Maybe it's not too efficient. I'll research and come back to this part later)
*
* So, let's say we have this method below:
* See how the arguments are initialized? If you don't provide anything,
* Kotlin will print *****
* You just have to be careful about the order of arguments.
* this is how you help Kotlin. If you don't want to provide the character here,
* you have to call it like displaySeparator(size = 6)
*
*
* P.S. Under the hood, Kotlin will provide Java with these overloads:
* displaySeparator(), displaySeparator(a), displaySeparator(a,b), displaySeparator(a b c), etc.
* */
fun displaySeparator(character: Char = '*', size: Int = 5) {
    repeat(size) {
        print(character)
    }
    println()
}

