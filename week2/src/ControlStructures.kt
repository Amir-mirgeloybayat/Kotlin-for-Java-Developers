//**************************************** CONDITIONALS, IF AND WHEN *********************************/

/*
* The control flow pretty much looks like Java.
* One new feature is the "when" keyword which is somehow close to the switch statement in Java with subtle differences.
* One difference is that, when, like other conditionals in Kotlin, is an expression so it can return the
* result of its lastly executed branch and also, unlike switch, it doesn't need a break keyword.
* When looks pretty much like pattern matching in OCaml.
*
* Ternary operation doesn't exist in Kotlin (a > b) ? a : b
*
* * */

// example for when
enum class Color {
    BLUE, GREEN, RED
}

fun getWeatherDescription(color: Color): String {
    return when (color) {
        Color.BLUE -> "cold"
        Color.GREEN -> "mild"
        Color.RED -> "hot"
        else -> "Error"
    }
}
/*
*
   switch(color) {
	case RED:
		//action
		break;
}
* * */

// you can have several conditions on the same line as well. Just like Java:
/*for example:
        switch(day) {
    case "monday":
    case "tuesday":
        doSomething();
    break;
}
*/

fun respondToMessage(message: String): String {
    return when (message) {
        "y", "yes" -> "good!"
        "n", "no" -> "bad"
        else -> "pardon?!" // you can also throw an exception on the else branch if you need to
    }
}

/*
* Next on the topic, imagine you have these classes:
*           Cat <- Pet -> Dog
* and you have to check the sub-types .
you can say
// "is" keyword is analogous to "instanceof" in Java.
* when(pet) {
	is Cat -> pet.meow()
	is Dog -> pet.bark()
}

* Note that you don’t need to cast pet to Cat or Dog, and the casting is being done automatically (smart cast)
* so, no need for ((Cat) pet).meow()
*
* Just to show you how smart the compiler is:
*

val pet = getMyPet()
when (pet) {
	is Cat -> pet.meow()
}

can be done in this way too!

when(val pet = getMyPet()) {
	is Cat -> pet.meow()
}
*
*
* */

//******************************************** LOOPS ********************************************/

/*
* Loops are pretty much the same.
    while (condition) {}
    do {} while(condition)

* for-loops are done differently
*
    val list = listOf(1,2,3)
        for (num in list) {
	        print(s)
        }

* num read-only here. You can't say for example num += 10, even if the list was mutable.
* Also, you can't say
    for (var num in list) {} -> var in loop definition is not allowed
*
*
* In Kotlin, you can iterate over the contents of a map effortlessly
    val map = mapOf(1 to “one”
		            2 to “two”
	      	        3 to “three”)

    for ((key, value) in map) {
	    println(“$key = $value”)
    }

* This syntax can be used to iterate over a collection with index

    val list = listOf(“a”,”b”,”c”)
    for ((index, element) in list.withIndex()) {
        println(“$index = $element”)
    }


* Now, let's get more in-depth with for-loops.
*
* for loops basically work pretty well with the range operator which Java doesn't have.

    for (i in 1..9) {
        // this is inclusive -> 1 2 3 4 5 6 7 8 9
    }

    for (i in 1 until 9) {
        // this will exclude 9 -> 1 2 3 4 5 6 7 8
    }

    for (i in 9 downto 1 step 2) {
        9 7 5 3 1
    }

    for (ch in “abc”) {
	    print(ch + 1) //bcd [offsets the characters in lexical order]
    }

* */

//************************************** IN CHECKS AND RANGES ****************************************/
/*
* Pay attention to these two operations
*
    for (i in ‘a’ ..’z’) {} is for iterating
    c in ‘a’ .. ‘z’ check for belonging

* common mistake is that people use to instead of .. -> to is for pairs and mapping
*
* */

fun isLetter(c : Char) = c in 'a' .. 'z' || c in 'A' .. 'Z'
// under the hood the code being produced is ‘a’ <= c && c <= ‘z’

//you can also use !in range

fun isNotDigit(c : Char) = c !in '0' .. '9'

/*
    There are different ranges. in fact, you can make a custom range for the data type that you define.
    val stringRange: ClosedRange<String> = “ab” .. “az”
    val dateRange: ClosedRange<MyDate> = startDate .. endDate
    Just like implementing Comparable for your class in Java
        Range of custom types:
	    class MyDate : Comparable<MyDate> //implements Comparable
            In Java: if (myDate.compareTo(startDate) >= 0 && myDate.compareTo(endDate) <= 0){}
            In Kotlin: if (myDate >= startDate && myDate <= endDate) {}
    which can be even improved more to:
        if (myDate in startDate..endDate){}

    in can be used to see if an element belongs to a collection
        if (element in list){}
            equivalent to
        if (list.contains(element)){}


    What will be printed?
        println(“Kotlin” in “Java”..”Scala”) //true
        println(“Kotlin” in setOff(“Java”, “Scala”)) // false: Kotlin is not in that set

* in is simply compiled to <= >= which in a deeper level done by compareTo()
* */


//************************************** EXCEPTIONS *******************************************/

/*
*   The important difference is that Kotlin doesn't differentiate checked and unchecked exceptions.
    You may or may not handle any exceptions and your function doesn't need to specify which exception its handling.
    In Kotlin, throw is an expression that its result can be assigned to a variable.
    Throw can be assigned to a variable of any type.
    example:
        val percentage =
	        if (number in 0..100)
		        number
	        else
		        throw IllegalArgumentExeption(“message”)


        val number = try {
	        Integer.parseInt(string)
        } catch (e: NumberFormatException) {
	        return // OR null
        }

*
* Important:        “In Java, you cannot catch a checked exception if it wasn't thrown.
*                    For this reason, when you throw a checked exception from Java point of view in Kotlin
*                    and want to later handle it in Java, you need to add this annotation.
*                    Note that if you only use a function throwing an exception in Kotlin,
*                    then you don't need the throws annotations at all.”
*
     //Kotlin
    @Throws(IOException::class)
    fun bar() {
        throw IOException()
    }

    //Java
    try {
	    kot.bar();
    } catch (IOException e) {}
*
* */