# Web Development 1 CA1 2025
## Development Space
 - The  **Development  Space** folder is where all my project development
	 - Includes source code servlets, java files and html/css
		 - Class
			- Main - purpose for me to test the actual connection via CLI
			- User - purpose to hold the data for ease get and set data
			- RegisterServlet - purpose is to get, post and redirect
			- LoginServlet - purpose is to check the users credentials
    		- PlayerServlet - responsibity is the action event of the buttons add and spend
       		- HTMLGenerator - purpose is to create the String that generates the HTML Docs
			- DatabaseConnection - Configuration for the database connection
- GamePortal is my production sort of folder
	- The folder is my final production web application
		- It prepares to be copied and put it to the webapp in tomcat
		- Then run the tomcat
  		- go to browser and paste this in localhost:8080/GamePortal
## My Database
- Table user
	- Column
		- fname *(VARCHAR 20)*
		- lname *(VARCHAR 20)*
		- username *(VARCHAR 20)*
		- password *(VARCHAR 20)*
		- balance *(INT)*
		
I am using my own database server which I created from my **HomeLab Server** project.

