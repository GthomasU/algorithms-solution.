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
 * Complete the 'plusMinus' function below.
 *
 * The function accepts INTEGER_ARRAY arr as parameter.
 */

func plusMinus(arr []int32) {
	countPositives := 0
	countNegatives := 0
	countZeros := 0
	for _, element := range arr {
		if element > 0 {
			countPositives++
		}
		if element < 0 {
			countNegatives++
		}
		if element == 0 {
			countZeros++
		}
	}
	ratePositive := float64(countPositives) / float64(len(arr))
	rateNegative := float64(countNegatives) / float64(len(arr))
	rateZeros := float64(countZeros) / float64(len(arr))
	fmt.Println(fmt.Sprintf("%.6f", ratePositive))
	fmt.Println(fmt.Sprintf("%.6f", rateNegative))
	fmt.Println(fmt.Sprintf("%.6f", rateZeros))

}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

	nTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)
	n := int32(nTemp)

	arrTemp := strings.Split(strings.TrimSpace(readLine(reader)), " ")

	var arr []int32

	for i := 0; i < int(n); i++ {
		arrItemTemp, err := strconv.ParseInt(arrTemp[i], 10, 64)
		checkError(err)
		arrItem := int32(arrItemTemp)
		arr = append(arr, arrItem)
	}

	plusMinus(arr)
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
