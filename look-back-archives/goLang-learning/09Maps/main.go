package main

import "fmt"

func main() {
	fmt.Println("Welcomet to maps program")

	languages := make(map[string]string)

	languages["JS"] = "JavaScript"
	languages["RB"] = "Ruby"
	languages["GO"] = "GOLang"

	fmt.Println(languages)
	fmt.Println(languages["JS"])

	delete(languages, "RB")
	fmt.Println(languages)

	for key, value := range languages {
		fmt.Printf("For Key %v, value is %v\n", key, value)
	}
}
