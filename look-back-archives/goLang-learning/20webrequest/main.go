package main

import (
	"fmt"
	"io"
	"net/http"
	"strings"
)

func main() {
	fmt.Println("Welcome to WEB REQUEST program")

	PerformGetRequest("http://localhost:8000/get")
}

func PerformGetRequest(myurl string) {

	res, err := http.Get(myurl)
	if err != nil {
		panic(err)
	}

	defer res.Body.Close() //our job to close it

	fmt.Println("Status Code: ", res.StatusCode)
	fmt.Println("Content Length: ", res.ContentLength)

	var responseString strings.Builder
	content, _ := io.ReadAll(res.Body)
	byteCount, _ := responseString.Write(content)

	fmt.Println(responseString.String())
	fmt.Println(byteCount)

	//fmt.Println(string(content))
}
