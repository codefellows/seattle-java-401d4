# Pseudocode

## What is pseudocode?
Pseudocode is fake code. This includes a combination of words and fundamental codelogic written out to complete an algorithm without any worry of the syntax.
Pseudocode is language agnostic, which means anyone, regardless of their language, can read and understand what is going on before converting it into their language of choice. 

There is not an 'official' syntax of pseudocode, just standard guidelines. Pseudocode is designed to stay lightweight and flexible allowing for many dialects to be used. 


| Symbol        | Meaning           |
| ------------- |:-------------:|
| Not Equal    | &ne; |
| Equal     | =  |
| Greater than or equal to | &ge;      |
| Less than or equal to | &le;      |
| Greater than  | >   |
| Less than  | <      |

#### Pseudocode does not have
- colons (:)
- semicolons (;)
- curly braces for code blocks ({})
- parenthesis (other than method signature declarations)

#### Pseudocode does have
- backwards arrows to set a value (←)
- indentation to specify scope
- equal sign for comparison (=)
- keyword "DECLARE" when creating a variable in memory (no need to define type)
- keyword "OUTPUT" when writing out to the console
- keyword "RETURN" when returning a value out of a method

### Example 1

```
ALGORITHM FizzBuzz(n) 
//INPUT ← a non-negative integer n 
//OUTPUT ← no return, output string
for i ←  0 to n do 
	if i mod 3 AND i mod 5
		OUTPUT ← "FizzBuzz"
	else if i mod 3
		OUTPUT ← "Fizz"
	else if i mod 5
		OUTPUT ← "Buzz"
	else
		OUTPUT ← i
```

### Example 2

```
ALGORITHM Factorial(n)
// INPUT ← non-negative integer
// OUTPUT ← product of factorials
if n ≤ 0
    RETURN 1
DECLARE number ← n * Factorial(n-1)
RETURN number
```


### Example 3

```
ALGORITHM BubbleSort(A[0…n-1])
// INPUT ← An unsorted array of orderable elements
// OUTPUT ← array sorted in nondecreasing order
for i ← 0 to n-2 do
	for j ← 0 to n-2-i do
		if A[j+1] < A[j] SWAP A[j] and A[j+1]

```

### Example 4

```
ALGORITHM SumOfLLValues(l)
// INPUT ← Singly linkedlist with at lesat 1 node
// OUTPUT ← non-negative integer
DECLARE current ← l.Head
DECLARE sum ← 0

while current.Next ≠ null do
    sum ← sum current.Value
    current ← current.Next
    
RETURN sum
```

### Example 5

```
ALGORITHM Countdown(n)
//INPUT ← non-negative number
//OUTPUT ← none
for i ← n down to 0 do
	OUTPUT ← i
```
