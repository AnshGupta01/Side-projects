package main

import "fmt"

func main()  {
	fmt.Println("Welcome to pointers")

	// var one *int
	// fmt.Println("Value of pointer is: ", one)

	myNumber := 25

	var ptr = &myNumber
	fmt.Println("Value of this actual pointer is: ",ptr)
	fmt.Println("Value of this actual pointer is: ",*ptr)

	*ptr = *ptr * 2;
	fmt.Println(*ptr)
}