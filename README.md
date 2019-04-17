Project Title
	
	Sample demo application gradle, spring boot and oauth2 implementation --> token store in memory


Pre Requisites
	
	gradle, java8

Code Details
	
	The Code/application consists of the Authorization Server &, the Resource Server
	- Authorization Server: The class to provide the requestor the authorization
	- Resource Server: The resource would be the Rest API that we want to secure. 
	
Deployment / Run
	
	command: 
	- gradle build
	- gradle bootrun

Test Details
	
	To check the implementation:
	- from postman
		- make a post request to get the token using URL: http://localhost:8004/oauth/token
		- Under authorization --> Basic Auth --> Username(client) & Password(password)
		- Under Body: username(user/admin), password(secret) --> grant_type(password)
		- successful response will have the token details -->
			{
    			"access_token": "cb9d8140-2f58-45d4-ae15-469f5cafecea",
    			"token_type": "bearer",
    			"refresh_token": "b1f1091a-275c-4096-9042-381ce845f283",
    			"expires_in": 43199,
    			"scope": "read write"
    		}
    	- try accessing the resource/rest api with the token under the authorization --> bearer token to access the corresponding resource.
	
Built With
	
	Gradle, spring boot, gradle

Versioning
	
	Demo Version

Authors
	
	Mayank Gupta

License
	
	-NA

Acknowledgements
	
	-NA
