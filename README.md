# Restaurant Management System

Design a system for managing a restaurant. The system should handle the following functionalities:
- Allow the restaurant admin to define the number of tables. 
- Allow restaurant admin to add, update, or remove items from the menu. Each menu item should have attributes such as name, price, veg / non-veg and category (starter, main course, dessert).
- Allow customers to browse the menu and allow filtering on factors (veg / non-veg, category), add items to their order, specify quantities, and place the order.
- Allow restaurant admin to manage tables in the restaurant as in number of tables.
- Calculate the total bill for each order, including taxes and any additional charges. Provide options for customers to pay the bill via various payment options, such as cash, credit/debit card, or online payment (card payment levy additional charges).

## Bonus Functionality:
- Provide a system for kitchen staff to view incoming orders, mark them as prepared, and notify wait-staff when orders are ready for serving.
- Allow multiple orders for the same table (AddItems even after 1 order was placed)
Your task is to design the class structure and define the methods for implementing this system. You have 90 minutes to complete this task. Ensure your design is well-structured, addresses the given requirements, and demonstrates good object-oriented design principles.

## Demoable test cases:
- Add a new item to the menu (e.g., "Spaghetti Carbonara, 499 Rupees, Veg, Starter").
- Update the price of an existing menu item (e.g., Update the price of "Cheeseburger" to 299).
- Remove an item from the menu (e.g., Remove "French Fries").
- Allocate an empty table to the customer (e.g., Allocate Table)
- Mark the table as occupied and then vacant after bill payment.
- Make a reservation for a specific table (e.g., Reserve Table Number “7”)
- Display the status of all tables to show changes.
- Browse the menu with / without filters (veg / non-veg, category) and add items to an order (e.g., add "2 Margherita Pizza" and "1 Caesar Salad").
- Remove an item from the order (e.g., remove "1 Caesar Salad").
- Change the quantity of an item in the order (e.g., change the quantity of "Margherita Pizza" to 3).
- Place the order.
- Customers can ask for the bill. Get preferred payment type and calculate and show the total bill for an order with different items and quantities.
- Apply taxes and any additional charges to the bill based on payment type selected by customer
- Accept payment in various forms (Cash, CreditCard, UPI).
- Take additional 1% processing fees for CreditCard usage

## Bonus Test Cases:
- View incoming orders in the kitchen.
- Mark orders as prepared and notify waitstaff.
- Handle multiple orders simultaneously for the same table.

## Guidelines:
- Time: 90mins
- Write modular and clean code. 
- A driver program/main class/test case is needed to test out the code by the evaluator with multiple test cases. But do not spend too much time in the input parsing. Keep it as simple as possible.
- You are not allowed to use any external databases like MySQL. Use only in-memory data structures.
- No need to create any UI.
- Please focus on the Bonus Feature only after ensuring the required features are complete and demoable.

## Evaluation Criteria:

### Demoable code:
- Can the code be run to demonstrate the functionalities of the restaurant management system?
- Is there a clear and user-friendly interface for interacting with the system?

### Clear Separation of Concerns (Good OO Class Design):
- Are the responsibilities of different parts of the code well-separated into classes?
- Are there well-defined interfaces between different components of the system?

### Functional Correctness and Completeness:
- Does the code correctly implement all the required functionalities?
- Are there any missing or incomplete features?
- Does the system handle edge cases and unexpected inputs gracefully?

### Readability:
- Is the code easy to understand and follow?
- Are variable names, method names, and comments descriptive and meaningful?

### Modularity and Extensibility:
- Is the code modular, allowing for easy addition or modification of features?
- Are there clear extension points or hooks for adding new functionalities in the future?

### Exception handling:
- Does the code handle errors and unexpected situations appropriately?
- Are exceptions used to handle exceptional cases, such as invalid input or system errors?
- Is there appropriate error messaging to help users understand what went wrong?
