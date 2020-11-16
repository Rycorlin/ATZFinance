Refactor issue #1:
This warning on compile seems to be system specific, and not showing up for everyone who compiles, 
so we believe that it has to do with the individual settings of the user who is compiling, and not 
an issue with the project itself. We have looked into a few different solutions to solve the warning 
but have not been able to replicate the issue or identify specifically what the problem is. 

Refactor issue #2:
UserView also contained a main method. Considering that it does not contain any startup programming 
data, the program itself starts from ATZFinance, this should not be. This has been refactored to 
remove the main method while still providing the same functionality.

Refactor issue #3:
Refactored the dynamic dropdown tabs into a DatePicker object since the date will be dependent on 
region, and should allow different users the option to select their date on a calendar instead of 
dropdowns. I believe I was incorrect in assuming that dropdown tabs were better, since a calendar 
seems to be the most foolproof method of ensuring correct date manipulation.

Refactor issue #4:
I had created a controller class in order to make the ApplyForLoanView adhere to more of a true “View”
 class. The controller class created, ApplyForLoanController reads and stores the data. This controller
 also handles the button logic.

Refactor issue #5:
Created a controller class for “create account” and added the functionality of checking if the passwords
 match and ensuring they meet the security standards. Checking if the passwords match was a simple 
comparison. In order to ensure security we used a regex pattern.

Refactor issue #6: 
In order to check to see if a username has been taken, we implemented serializing accounts for long-term 
persistence. Storing the user objects in an arraylist and storing the username in a HashSet for constant 
lookup time. In the future, we can replace this with a HashTable using username as the key and user object 
as the value. This was thought of last minute so it was not able to be fit into this week’s assignment.

Refactor issue #7:
More comments needed to be added so that anyone reviewing, or adjusting, the programming could understand 
it. Good documentation will allow future tech personnel understand what the code is doing without having 
to actually read the code. Each member has added additional code to make this possible.

Refactor issue #8:
Added a method in the createAccountController class called validNames() that checks to make sure that first
 and last name don’t contain any special characters or numbers. Before adding in this control first and
 last names associated with accounts could be non-identifiable like having a first name of “1” and last name 
of “2”, which wouldn’t be helpful when needing to identify customers.

Refactor issue #9: 
Added in a combobox that allows for the selection of a user (first name, lastname, and username) which then 
populates the first and last name of the user into the application below. This will allow for loan officers 
to ensure any loans they are filling out for others are already pre-existing users at ATZ Finance. 

Refactor issue #10:
Changed all conflicting camel case notation to follow the standard across all classes of CamelCaseClasses, 
methodNames(), and variableNames; to improve readability and consistency across the project. Changed class 
names which started with lowercase, and removed method names which included underscores, such_as_this_method().

