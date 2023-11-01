package main

import (
	"fmt"
	"math/rand"
	"time"
)

func main() {
	fmt.Println("Welcome to Switch case program")

	rand.New(rand.NewSource(time.Now().UnixNano()))
	diceNumber := rand.Intn(6) + 1

	switch diceNumber {
	case 1:
		fmt.Println("Value is 1")
		//runs the next case as well
		fallthrough
	case 2:
		fmt.Println("Value is 2")
	case 3:
		fmt.Println("Value is 3")
	case 4:
		fmt.Println("Value is 4")
	case 5:
		fmt.Println("Value is 5")
	case 6:
		fmt.Println("Value is 6")
	default:
		fmt.Println("What was that bro?")	
	}
}
