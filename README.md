# LUMA Automation Testing Project  

## Overview  
This is an automation testing project designed to validate key functionalities of the **LUMA eCommerce website** using test cases that cover user registration, login, landing page interactions, and wishlist management.  

## Technology Stack  
- **Programming Language:** Java  
- **Testing Framework:** Selenium WebDriver  
- **Build Tool:** Maven  
- **Test Runner:** TestNG  
- **Page Object Model (POM):** Implemented for better maintainability  

## Project Structure  
The project follows a structured **Page Object Model (POM)** approach, dividing test cases and page interactions into separate classes for better maintainability and readability.  

### Packages & Classes  
- **testCase Package**: Contains test classes for executing test cases.  
  - `T01_Register.java` – Tests related to user registration  
  - `T02_Login.java` – Tests related to login functionality  
  - `T03_LandingPage.java` – Tests validating landing page features  
  - `T04_Wishlist.java` – Tests related to wishlist functionality  

- **Pages Package**: Contains classes representing web pages with corresponding actions.  
  - `P01_Register.java`  
  - `P02_Login.java`  
  - `P03_LandingPage.java`  
  - `P04_Wishlist.java`  

## Test Scenarios  

### Scenario 1: User Registration  
✔️ Validate error messages when leaving mandatory fields empty.  
✔️ Ensure password and confirm password fields match.  
✔️ Successful registration redirects users to the "My Account" page.  

### Scenario 2: User Login  
✔️ Validate that registered users can log in successfully.  
✔️ Ensure login displays a welcome message with the user’s name.  

### Scenario 3: Landing Page Validation  
✔️ Verify that "Hot Sellers" items display prices in dollars.  
✔️ Ensure each product card has an "Add to Cart" button that works.  
✔️ Validate that guest users can add products to the cart.  

### Scenario 4: Wishlist Management  
✔️ Guest users cannot add products to the wishlist and are redirected to the login page.  
✔️ Logged-in users can successfully add products to the wishlist.  
