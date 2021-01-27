package com.v15h4l.template.library

/**
 * Factorial Calculator
 */
object FactorialCalculator {

    /**
     * Compute factorial of an Integer using recursion.
     */
    tailrec fun computeFactorial(input: Int, temp: Long = 1L): Long =
        when {
            input < 0 -> error("Factorial is not defined for negative numbers")
            input == 0 -> temp
            else -> computeFactorial(input - 1, temp * input)
        }
}