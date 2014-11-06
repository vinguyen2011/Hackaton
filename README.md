Hackaton
========
View images in Images folder for clarification...

Step 1: Import project from existing Maven project in Eclipse

Step 2: Run the Application class

Step 3: In the console you will see a notification to visit a link, such as:
https://api.openbankproject.com/oauth/authorize?oauth_token=Q3YYPNQ4SSKXDPVDIERN2GETT24NEMOIVQA04NAY

Open this link in your browser, please sign up and then log in with your credential. You will receive a verification code (5 digits).
Then paste this code to the console and hit enter

Step 4: Open your browser and enter the link:
http://localhost:8080/banks?name=postbank
---You should see detail of this bank gather from the API

http://localhost:8080/banks/accounts/private?name=postbank 
---You should see last private accounts of this bank (authentication required)

http://localhost:8080/banks/accounts/public?name=postbank
---You should see the last public accounts of this bank (authentication not required)
