//Each time a "defer" statement executes, the function value and parameters to the call
//are evaluated as usual and saved anew but the actual function is not invoked.
//Instead, deferred functions are invoked immediately before the surrounding function retuins,
//in the reverse order they were deferred.
//That is, if the surrounding function returns through an explicit return statement,
//deferred functions are executed after any result parameters are set by that return statement
//but before the function returns to its caller.
//If a deferred function value evaluates to nil, execution panics when the function is invoked,
//not when the "defer" statement is executed.

package main

import "fmt"

func main() {
	fmt.Println("Defer Program")
	
	defer fmt.Println("World")
	defer fmt.Println("One")
	defer fmt.Println("Cheers to")
	fmt.Println("Hello")
}
