Hackaton
========

Step 1: Import project from existing Maven project in Eclipse

Step 2: Run the Application class

Step 3: Install MySQL with specific credentials (view com.ing.hackaton.database.DBConnector.java)
Import DB with the dump file Dump20141111.sql

Step 4 (for the client): Those are APIs provided from the back-end: 
BASE_URL: localhost:8080
GET /addUser?username=vi&password=1234&email=thanhvi.ng@gmail.com&firstname=vi&lastname=nguyen&image=...
--- Add one user to DB, return true/false

GET /validateUser?username=vi&password=1234
--- Validate user, return true/false

GET /getUser?username=vi
--- Get user detail, return
{"username":"vi","password":"1234","email":"...","image":"thanhvi.ng@gmail.com","firstname":"vi","lastname":"nguyen","id":6}

GET /addBankAccount?username=vi&account_number=12345678&bank_holder=T.T.V.Nguyen&bank_name=TESTBANK
--- Add a bank account for an user, return true/false

