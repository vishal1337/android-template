/*
 * Copyright 2021 Vishal Choudhary
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
