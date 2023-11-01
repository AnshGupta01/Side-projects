package main

import "fmt"

func main() {
	fmt.Println("Methods program")

	ansh := User{"Ansh", "Ansh@go.dev", true, 20}
	ansh.GetStatus()
	ansh.NewMail()
	fmt.Println(ansh.Email)
}

type User struct {
	Name   string
	Email  string
	Status bool
	Age    int
}

func (u User) GetStatus() {
	fmt.Println("Is user active: ", u.Status)
}

//This passes a copy of the object and does not modify the base object
func (u User) NewMail() {
	u.Email = "test@go.dev"
	fmt.Println("Email of the user is: ", u.Email)
}
