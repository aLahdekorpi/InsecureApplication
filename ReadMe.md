In this program, I present the following Security issues from the OWASP top 10 security issues list https://www.owasp.org/images/7/72/OWASP_Top_10-2017_%28en%29.pdf.pdf :
1. Security configuration.
2. Broken authentication.
3. Broken access control.
4. Sensitive data exposure.
5. Insufficient logging.

The first issue is pretty obvious to anyone. In the first method of the SecurityConfiguration.java class, there is a line, which allows every request, and basically does nothing to secure the app.
This creates too many problems to be listed here, but Spring documentation (https://docs.spring.io/spring-security/site/docs/current/reference/html/jc.html) considers most of them. 
Fixing this issue depends largely on the application, and what do we want to secure. The least we can do is to add ".authenticated()" , ".formLogin()" and ".httpBasic();" to HttpSecurity http to ensures that any request to our application requires the user to be authenticated, allow users to authenticate with form based login and allow users to authenticate with HTTP Basic authentication.

Issues #3 and #4 are presented in the same function. In SignupController.java class, there is a function listAll. It gets all the signups from and shows them to the user when accessing the url ~/signups. 
The function has two issues. Firstly, anyone should not be able to access all the signups. There is no access control on the function, so this is possible. Secondly, it should not show all the data to anyone as there is sensitive data (user address) on the site.
Fixing the access issue should be done with a secure login system, and session management. When those two are done, you can control who accesses this page.
Data exposure issue can be fixed by just not showing the sensitive part of the data on the site.


 


