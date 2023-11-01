package main

import "fmt"

func main() {
	fmt.Println("Structs in go lang")

	//There is no inheritence in golang; No super or parent classes

	Ansh := User{"Ansh", "Ansh@ansh.dev", true, 20}
	fmt.Println(Ansh)
	fmt.Printf("Ansh's Details are: %+v", Ansh)
}

type User struct {
	Name   string
	Email  string
	Status bool
	Age    int
}
