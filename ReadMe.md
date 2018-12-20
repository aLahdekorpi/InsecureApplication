

In this program, I present the following Security issues from the OWASP top 10 security issues list https://www.owasp.org/images/7/72/OWASP_Top_10-2017_%28en%29.pdf.pdf :
1. Security configuration.
2. Broken authentication.
3. Broken access control.
4. Sensitive data exposure.
5. Insufficient logging.

The first issue is pretty obvious to anyone. In the first method of the SecurityConfiguration.java class, there is a line ( http.authorizeRequests().anyRequest().permitAll(); ), which allows every request, and basically does nothing to secure the app.
This creates too many problems to be listed here, but Spring documentation (https://docs.spring.io/spring-security/site/docs/current/reference/html/jc.html) considers most of them. 
Fixing this issue depends largely on the application, and what do we want to secure. The least we can do is to add ".authenticated()" , ".formLogin()" and ".httpBasic();" to HttpSecurity http to ensure that any request to our application requires the user to be authenticated, allow users to authenticate with form based login and allow users to authenticate with HTTP Basic authentication.

The second issue is the horrible login system in the application. You dont have to know anything about cyber security to break this login. Firstly, the only working credentials are admin/admin which are hard-coded to the class. Secondly, if the credentials fail the application just redirects you back to the login page, which allows fast endless brute-force. Fixing this issue requires an understanding of spring login-systems. It should be constructed using the Spring documentation, and not by yourself. The passwords (and usernames) should be encrypted and on a database, not hard-coded. The login system should also keep track of the session, not just redirect you around depending on success.  

Issues #3 and #4 are presented in the same function. In SignupController.java class, there is a function listAll. It gets all the signups and shows them to the user when accessing the url ~/signups. 
The function has two issues. Firstly, anyone should not be able to access all the signups. There is no access control on the function, so this is possible. Secondly, it should not show all the data to anyone as there is sensitive data (user address) on the site.
Fixing the access issue should be done with a secure login system, and session management. When those two are done, you can control who accesses this page. The access control issue is on each url on the application, since the login system does not prevent access to anything from users who have not logged in.
Data exposure issue can be fixed by just not showing the sensitive part of the data on the site,
deleting the line 12 <!---<p th:text="${s.address}"></p>--> from signups.html. 

The last issue is logging. The application currently logs nothing, and this is an issue. As it reads on the OWASP list, "Most breach studies show time to detect a breach is over
200 days, typically detected by external parties rather than internal processes or monitoring." Spring Boot offers great tool to logging, we just have to create a logging controller and a simple logback-spring.xml - file to determine what we want to log and where. The steps to a simple logger are provided here : https://www.baeldung.com/spring-boot-logging.


 


