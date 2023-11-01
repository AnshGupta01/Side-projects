package main

import (
	"fmt"
	"time"
)

func main()  {
	fmt.Println("Welcome to Time Program")

	presentTime := time.Now()
	fmt.Println(presentTime)

	fmt.Println(presentTime.Format("Monday Jan 2 2006 15:04 3PM"))

	createdDate := time.Date(2033, time.October, 28, 6, 12, 0, 0, time.UTC)
	fmt.Println(createdDate)
	fmt.Println(createdDate.Format("2 Jan 2006 Monday"))
}