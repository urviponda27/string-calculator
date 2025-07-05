# TDD String Calculator

# Standard Mevan Folder Structure

├── src <br>
&emsp;├── main/java/org/incubyte <br>
&emsp;&emsp;├── StringCalculator.java <br>
&emsp;├── test/java/org/incubyte <br>
&emsp;&emsp;├── StringCalculatorTest.java <br>

This project implements the classic *String Calculator Kata* using *Test-Driven Development (TDD)* principles. The objective is to progressively develop a string-based calculator that parses and sums numbers with support for a variety of delimiters and input constraints.

---

## ✅ Features (Incrementally Built)

1. Return `0` for empty string input.  
1.1 Return the number itself for a single number.  
1.2 Add two comma-separated numbers.  
2. Handle unknown amount of numbers.  
3. Handle newlines (`\n`) as additional delimiters along with commas.  
4. Support custom delimiters like `//;\n1;2`.  
5. Throw exception for negative numbers and include all of them in the error message.  
6. Ignore numbers greater than 1000.  
7. Allow single custom delimiters of **any length** like `//[***]\n1***2`.  
8. Allow **multiple custom delimiters** like `//[*][%]\n1*2%3`.  
9. Support multiple custom delimiters **with length longer than one character** like `//[**][%%%]\n1**2%%%3`.  

---

## ⚙️ Tech Stack

This project uses the following tools and technologies:

- **Java 8+** — Core language features with use of **Stream API** and modern Java patterns
- **JUnit 5** — Modern unit testing framework with annotations and lifecycle support
- **AssertJ** — Fluent assertion library for readable and expressive test validations
- **Maven** — Build automation and dependency management tool
- **IntelliJ IDEA** — Recommended IDE for seamless Maven + Java development

---

## 🧪 Test-Driven Development Strategy

Each functionality is developed in **two TDD steps**:

- **Red:** Write a failing test first  
- **Green:** Implement minimal code to pass the test  
- **Refactor:** Clean the implementation if needed  

## Test History and Visual Evidence
Each requirement below is accompanied by screenshots representing the failing and passing test states.

## 1 Empty string  
# 🔴 Failing test case for Empty String
![image](https://github.com/user-attachments/assets/393881ef-d896-4d62-bab0-b492fede80fb)
# 🟢 Empty string test case passed  
![image](https://github.com/user-attachments/assets/aebf79b0-e7a8-49d8-8459-fcd9f1722bbe)


## 1.1 Single number input  
# 🔴 Failing test case for single number input  
![image](https://github.com/user-attachments/assets/43a01774-537d-4907-bdec-e31c0f94168c)
# 🟢 Test passed for single number input  
![image](https://github.com/user-attachments/assets/b83a2c23-bd89-4fb3-9ccc-c84d57b5bd5e)

## 1.2 Two number input  
# 🔴 Failing test case for input having two numbers  
![image](https://github.com/user-attachments/assets/28b7c1d3-991d-4b80-91ab-1334168a3032)
# 🟢 Test passed for input having two numbers  
![image](https://github.com/user-attachments/assets/f8a429e2-15bc-4d8e-9cdb-d532a59d82ff)

# 2 Unknown amount amount of numbers  
# 🔴 Failing test case for unknown amount of numbers  
![image](https://github.com/user-attachments/assets/13acd909-5060-4c7f-905e-54f9ec874c5b)
# 🟢 Test passed for input having unknown amount of numbers  
![image](https://github.com/user-attachments/assets/5acb4784-5a91-4274-8c06-530c1689fa42)

# 3 Number separated by comma and newline  
# 🔴 Failing test case for input having numbers separated by comma and newline  
![image](https://github.com/user-attachments/assets/5fec340f-3186-47fd-9d87-f7f290fa561e)
# 🟢 Test passed for input having numbers separated by comma and newline  
![image](https://github.com/user-attachments/assets/43706147-76e6-4555-9cba-e46e1579d01e)

# 4 Custome delimiter  
# 🔴 Failing test case for custom delimiter 
![image](https://github.com/user-attachments/assets/4da3b38c-c4ee-4f2d-9ecb-21302fc10f66)
# 🟢 Test passed for custome delimiter  
![image](https://github.com/user-attachments/assets/cc2b7699-8fdc-4b31-a27f-da604cb7912b)

# 5 Exception for negative numbers  
# 🔴 Failing test case for input having negative numbers  
![image](https://github.com/user-attachments/assets/db38594a-9cf1-4781-81cc-1198cd5a7ec6)
# 🟢 Test passed for input having negative numbers  
![image](https://github.com/user-attachments/assets/e026d3c7-165f-4fea-922c-a893d27e383c)

# 6 Number greater than 1000  
# 🔴 Failing test case for input having number greater than 1000  
![image](https://github.com/user-attachments/assets/534214a4-fb1b-4fb3-a98a-6b96cda9c699)
# 🟢 Test passed for input having number greater than 1000  
![image](https://github.com/user-attachments/assets/7777e055-fc89-454e-abe7-4f4e2c9ac68b)

# 7 Delimiter of any length  
# 🔴 Failing test case for input having delimiter of any length 
![image](https://github.com/user-attachments/assets/16a35a44-9669-4a56-8de9-a4fbaab8e65e)
# 🟢 Test passed for input having delimiter of any length  
![image](https://github.com/user-attachments/assets/7c9c2285-e7b7-4b03-9a36-25803d052f88)


# 8 Mulitiple custome delimiter having length more than one character  
# 🔴 Failing test case for the input having mulitiple custome delimiter having length more than one character 
![image](https://github.com/user-attachments/assets/efea3a8f-6400-4898-98f2-688fdac1c7b5)
# 🟢 Test passed for the input having mulitiple custome delimiter having length more than one character  
![image](https://github.com/user-attachments/assets/480d186b-ce10-4949-9f53-f87354455856)

## Summary

This project demonstrates clean TDD practices in Java by progressively building a robust and flexible string calculator. Each feature is thoroughly tested, and the development process strictly adheres to the Red-Green-Refactor cycle, ensuring code correctness and maintainability.
