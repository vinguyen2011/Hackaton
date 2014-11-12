Hackaton
========

Step 1: Import project from existing Maven project in Eclipse

Step 2: Run the Application class

Step 3: Install MySQL with specific credentials (view com.ing.hackaton.database.DBConnector.java)
Import DB with the dump file Dump20141111.sql

Step 4 (for the client): Those are APIs provided from the back-end: 
BASE_URL: localhost:8080

GET /addUser?username=UID14201&password=1234&email=thanhvi.ng@gmail.com&firstname=vi&lastname=nguyen&image=...
--- Add one user to DB. Access token can be blank at this stage, return 
{"result":"true"}

GET /validateUser?username=UID14201&password=1234
--- Validate user, return 
{"result":"true"}

GET /addAccessToken?username=UID14201&access_token=...
--- Add access token for this user, return
{"result":"true"}

GET /getUser?username=UID14201
--- Get user detail, return
{"username":"UID14201","password":"1234","email":"...","image":"thanhvi.ng@gmail.com","firstname":"vi","lastname":"nguyen","access_token":"eyJhbGciOiJIUzI1NiIsImN0eSI6InRleHRcL3BsYWluIn0.eyJleHAiOjE0MTUwMDc3MzksIm5vbmNlIjoiMWJlMTQwZTEtOTE4Yy00MDY1LWE4MDAtMjUyYjA1ODA0MDY4IiwiYXVkIjpbImNsaWVudF9pZCJdLCJpc3MiOiJVSUQxNDIwMSIsImp0aSI6ImEyMzNjNmM5LWRhMTQtNGRhMC1iNDhiLWU1YThmZGEyYzVhZCIsImlhdCI6MTQxNTc4NDk5Mn0.a9HQzKwA4iC1IYKa1X5DURzIesS1t32AJCPdxgfZFdg","id":6}

GET /listAllCurrentBankAccount?username=UID14201
--- Get all current account (code = 1100) of this user in the API -> user can select one account to send/receive money. Data gather from the Common API but not save in our DB, return
{"id":"NL31INGX0007946820","currency":"EUR","customerDescription":"Koppe,Iris","availableBalance":39318.66}

GET /addCampaign?name=Birthday party&description=&target_amount=1200&currency=EUR&id_receiving_account=NL31INGX0007946820&creator_username=UID14201
--- Add a campaign created by an user, return 
{"result":"true"}

