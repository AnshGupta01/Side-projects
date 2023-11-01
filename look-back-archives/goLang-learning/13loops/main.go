package main

import "fmt"

func main() {
	fmt.Println("Welcome to loops in GoLang")

	days := []string{"Sunday", "Tuesday", "Wednesday", "Friday", "Saturday"}

	fmt.Println(days)

	for d := 0; d < len(days); d++ {
		fmt.Println(days[d])
	}

	fmt.Println("")

	for i := range days {
		fmt.Println(days[i])
	}

	fmt.Println("")

	for index, day := range days {
		fmt.Printf("Index is %v & Value is %v\n", index, day)
	}

	fmt.Println("")

	newValue := 1

	for newValue < 11 {

		if(newValue == 2){
			goto lco
		}

		if newValue == 5 {
			//continue
			break
		}

		fmt.Println("Value is: ", newValue)
		newValue++
	}

	lco:
		fmt.Println("Navigating to Google.com")

}
