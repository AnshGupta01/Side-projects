package main

import "fmt"

func main() {
	fmt.Println("Program for if-else")

	loginCount := 10
	var result string

	if loginCount < 10 {
		result = "Regular user"
	} else if loginCount > 10 {
		result = "Pro user"
	} else {
		result = "10 only"
	}
	fmt.Println(result)

	if num := 3; num < 10 {
		fmt.Println("Num is less than 10")
	} else {
		fmt.Println("Num is not less than 10")
	}

	


}
