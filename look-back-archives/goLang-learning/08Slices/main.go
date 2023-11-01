package main

import (
	"fmt"
	"sort"
)

func main() {
	//fmt.Println("Welcome to slices")

	var list = []string{"Hello", "Hi", "Bye"}
	//fmt.Printf("The type of list is: %T\n", list)

	list = append(list, "Ansh", "AG")
	//fmt.Println(list)

	list = append(list[1:3])
	//fmt.Println(list)

	highScore := make([]int, 4)

	highScore[0] = 235
	highScore[1] = 233
	highScore[2] = 236
	highScore[3] = 220

	//doesnt work
	//highScore[4] = 238

	//does work
	highScore = append(highScore, 555, 666, 777)

	//fmt.Println(highScore)

	sort.Ints(highScore)
	// fmt.Println(highScore)
	// fmt.Println(sort.IntsAreSorted(highScore))

	//how to remove a value from slices based on index
	var courses = []string{"reactJs", "Javascript", "Swift", "Java"}
	fmt.Println(courses)

	var index int = 2
	//the value in [] is non inclusive
	courses = append(courses[:index], courses[index+1:]...)
	fmt.Println(courses)
}