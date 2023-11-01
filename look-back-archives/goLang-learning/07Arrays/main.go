package main

import "fmt"

func main() {
	fmt.Println("Welcome to Arrays Program")

	var carList [4]string
	carList[0] = "BMW"
	carList[1] = "AUDI"
	//carList[2] = "MERC"
	carList[3] = "HONDA"

	fmt.Println(carList)
	fmt.Println(len(carList))

	var modelList = [4]string{"City", "M4", "Q3"}
	fmt.Println(modelList)
	fmt.Println(len(modelList))
}
