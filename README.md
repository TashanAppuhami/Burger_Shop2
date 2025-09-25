:

🍔 iHungry Burger Ordering System

A simple Java console application that simulates a burger shop ordering system.
This project was created for learning Object-Oriented Programming (OOP) concepts such as classes, objects, constructors, arrays, methods, validation, and encapsulation.

🚀 Features

Place an Order

Automatically generates unique Order IDs (B0001, B0002, …).

Validates customer phone number (must be 10 digits starting with 0).

Validates customer name (only letters allowed).

Calculates total price (Quantity × BURGERPRICE).

Best Customer

Finds customers who spent the most.

Ignores cancelled orders.

Displays all customers with their total spent, sorted from lowest → highest.

Search Order

Look up an order using its Order ID.

Displays order details (ID, customer, quantity, total, and status).

Search Customer

Search orders by customer phone number.

Displays all orders placed by that customer.

View Orders by Status

Delivered Orders

Preparing Orders

Cancelled Orders

Update Order Details

Update order quantity (recalculates price).

Update order status (PREPARING, DELIVERED, CANCELLED).

Restrictions: Delivered or Cancelled orders cannot be updated.

Exit

Cleanly exits the system.

🛠️ Technologies Used

Java (Core, Console I/O, OOP)

No external libraries needed

📂 Project Structure
├── Burger.java        # Burger class with order details & methods
├── BurgerShop2.java   # Main class with menu & logic


Burger.java

Fields: orderId, customerId, customerName, burgerQty, burgerPrice, orderStatus

Methods: Getters, setters, update quantity, update status

BurgerShop2.java

Handles menu, input, and program flow

Stores all Burger objects in a static array

Contains validation and search functions

▶️ How to Run

Clone the repository

git clone https://github.com/your-username/burger-ordering-system.git
cd burger-ordering-system


Compile the program

javac BurgerShop2.java


Run the program

java BurgerShop2

📖 Example Menu
+----------------------------------------------------+
|                   iHungry Burger                   |
+----------------------------------------------------+

[1] Place Order        [2] Search Best Customer
[3] Search Order       [4] Search Customer
[5] View Orders        [6] Update Order Details
[7] Exit

Enter an option :

🔮 Future Improvements

Replace arrays with ArrayList for easier order management.

Allow customer names with spaces (e.g., "John Doe").

Save orders to a file (so data isn’t lost when the program closes).

Add discounts and loyalty points for frequent customers.
