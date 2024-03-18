package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
	"strings"
)

/*
 * Complete the 'timeConversion' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */

func timeConversion(s string) string {
	hour := strings.Split(s, ":")[0]
	minutes := strings.Split(s, ":")[1]
	second := strings.Join(strings.Split(strings.Split(s, ":")[2], "")[0:2], "")
	half := strings.Join(strings.Split(strings.Split(s, ":")[2], "")[2:4], "")
	//fmt.Printf("Hours: %v | minutes: %v | second: %v | half: %v", hour, minutes, second, half)
	hourAsNumber, _ := strconv.Atoi(hour)
	if half == "PM" {
		if hourAsNumber < 12 {
			hour = fmt.Sprintf("%v", hourAsNumber+12)
		}
	} else {
		if hourAsNumber == 12 {
			hourAsNumber = 0
		}
		if hourAsNumber < 10 {
			hour = fmt.Sprintf("0%v", hourAsNumber)
		}
	}
	result := fmt.Sprintf("%v:%v:%v", hour, minutes, second)
	fmt.Println(result)
	return result

}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	stdout, err := os.Create("stdout.txt")
	checkError(err)

	defer stdout.Close()

	writer := bufio.NewWriterSize(stdout, 16*1024*1024)

	s := readLine(reader)

	result := timeConversion(s)

	fmt.Fprintf(writer, "%s\n", result)

	writer.Flush()
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
