package main

import "fmt"

func main() {
	fmt.Println("Welcome to functions program")
	
	ansh()

	result := adder(3,5)

	fmt.Println(result)

	result2, message := proAdder(2,5,8,7,10,11)
	fmt.Println(result2)
	fmt.Println(message)

}

func ansh() {
	fmt.Println("Hello from ansh")
}

func adder(val1 int, val2 int) int {
	return val1 + val2
}

func proAdder(values ...int) (int, string) {
	total := 0
	for _, val := range values {
		total += val
	}
	return total, "Trying one more thing"
}