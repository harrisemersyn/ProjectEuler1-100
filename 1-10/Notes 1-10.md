Project Euler Problems 1-10 Notes
----------------------------------
I will make notes on the rest of the ones I've finished when I'm not tired and lazy

DigitString.txt is a file of the digits from problem 8. DigitStringTwo.txt is a larger, randomly generated string of numbers I used to test runtime.

Problem 1
----------
In my first attempt in Problem1.java, I wrote it so that both multiples of three and five are incremented and added to the sum in the same loop to avoid using seperate loops to reduce runtime. I tried rearraging some of the conditionals, but the order I started with originally makes it run the fastest.

In Problem1a.java, I wrote out the brute-force solution to compare. The solution in Problem1.java was more efficient than brute-force by about ~11%.

After coming back to it a third time, I noticed I could remove the if conditional for "multOfThree < 1000" since the multiples of three will always be less than the multiples of five. This only decreased runtime by about ~0.5%, though. There is one more implementation that I am going to come back to later that may reduce it even further.

Problem 2
----------
In my first attempt, I used mod 2 to determine if a number was even or odd, and if it was even, I would add it to the sum. The is a conditional to check whether the next two terms in the sequence are above 4 million, and if so, it will terminate the loop. One minor change I made that reduced runtime by at max ~6-7% is removing the conditional check to see whether i is less than 4 million, and only leaving the check for j, since j will always be the highest term in the sequence stored.

One thing I noticed is that the Fibbonaci sequence follows the pattern odd-odd-even, so I am going to make another attempt later that uses this.

Problem 3
----------
In this problem, I used brute-force to go through all of the numbers and check to see if they were a factor, and if a factor, then a prime. But I used fermat's primality test, which comes with a for loop, and room for error with carmichael numbers. This is probably a good place for me to go back to and look for other primality tests.

Problem 4
----------
Currently just brute force.

Problem 8
----------
The first attempt I made with the brute-force method was straight-forward, other than not realizing for a minute that the product was to big for Java int to handle, and I had to make changes using BigInteger. I thought that I might be able to make things run faster if I took a more methodical approach instead of testing every single combination of products, which I have in Problem8a.java. I parsed the digit string and made a list out of all substrings that did not contain a 0, since with a 0 in the string, it would be useless to calculate the product anyways. Then, I took the largest number(s) in each substring and rotated around it to get the biggest substring-of-a-substring. Needless to say, it was not more efficient because it took way too many for-loops. I tested it out with a second data set of 10000000000 numbers, and the efficiency results were the same as the lower number test. 

I rewrote it one more time in Problem8b.java, where I combined the last two attempts. It takes the list of strings that don't contain a 0, and then brute forces each. It took slightly longer than my orginal attempt, but shorter than the second attempt.

One more thing I tried in regards to efficiency is removing the if statement that terminates the multiple check if a 0 is found in the substring that I put in my original attempt. If the program brute-forces without breaking the inner-most for loop on a 0, it takes slightly longer than when it does terminate (just barely though). Terminating the loop on a 0 improves the efficiency by about ~2%.