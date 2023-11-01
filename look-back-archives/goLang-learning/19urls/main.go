package main

import (
	"fmt"
	"net/url"
)

const myurl string = "https://lco.dev:3000/learn?coursename=reactjs&paymentid=ndfnodf3143"

func main() {
	fmt.Println("----Urls Program----")

	//parsing the url
	result, err := url.Parse(myurl)
	if err != nil {
		panic(err)
	}

	fmt.Println(result.Scheme)
	fmt.Println(result.Host)
	fmt.Println(result.Path)
	fmt.Println(result.Port())
	fmt.Println(result.RawQuery)

	fmt.Println("-----------------")

	qparams := result.Query()
	//fmt.Printf("%T",qparams)
	//fmt.Println(qparams["coursename"])
	//fmt.Println(qparams["paymentid"])
	for _, val := range qparams {
		fmt.Println("Param is: ", val)
	}

	partsOfUrl := &url.URL{
		Scheme: "https",
		Host: "lco.dev",
		Path: "/tutcss",
		RawQuery: "user=ansh",
	}

	fmt.Println("-----------------")
	fmt.Println(partsOfUrl.String())
}
