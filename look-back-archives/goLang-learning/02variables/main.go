package main

import "fmt"

const jwtToken string = "4000"

func main() {
	var username string = "ansh"
	fmt.Println(username)
	fmt.Printf("Variable is of type: %T \n", username)

	var isLoggedIn bool = false
	fmt.Println(isLoggedIn)
	fmt.Printf("Variable is of type: %T \n", isLoggedIn)

	var str string
	fmt.Println(str)
	fmt.Printf("Variable is of type: %T \n", str)

	ansh := 3000
	fmt.Println(ansh)
}
