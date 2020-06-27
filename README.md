##Coffee Machine

PACKAGES :
The System has 5 Packages. The driver API is com.dunzo.coffeemachine and the class which interacts with the user is Driver.java 
The 5 packages are –
1.	com.dunzo.coffeemachine 
2.	com.dunzo.coffeemachine.alert
3.	com.dunzo.coffeemachine.beverages
4.	com.dunzo.coffeemachine.inventory
5.	com.dunzo.coffeemachine.utility

INPUT JSON :
The Coffee Machine expects a json input with keys same as : https://www.npoint.io/docs/e8cd5a9bbd1331de326a
Enter the input json file location in the console when prompted to enter.

REFILL INGREDIENTS :
The initial ingredients are added based on the input. After all beverages are processed (N at a time), the machine asks whether any of the present ingredients need to be refilled.
To refill any of the ingredients, input has to be provided in the console as asked by the machine. 
Note : The ingredient to be refilled must be present in the machine.

ALERT MESSAGES :
After processing each drink the ingredient quantity is checked and an alert message is shown if the quantity has fallen below 50.

ASSUMPTIONS :
Json input is not valid if it has duplicate keys. Such a json input will still be parsed considering the first value as the only valid one.

NOTE :
1.	To simulate real like experience a delay of one second is added to certain responses.
2.	To parse the json file `json-simple-1.1’ Jar has been used.
3.	Test Input json files are provided in Folder `FunctionalTestingJson’.
