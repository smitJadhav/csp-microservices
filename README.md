# csp-microservices
microservices implementation

This is a customer service provider apllication.
This application uses technologies like Spring boot, postgres, hibernate, Oauth2, Eureka, Zuul, Ribbon, Common configuration, docker.

Application has different services as follows.
1.Eureka service - This is a eureka server application used for service descovery.
2.Config service - This service is a one place for configuration used in all services. This is very helpfull as we will be having multiple instances of each service in prod and to                    update application property across many instance is a pain. This application enable us to refresh properties live on prod without impacting business.
3.Gateway service - Simple zull service which will be exposed to client application and it will delegate the client request to appropriate backend service(private services not                         exposed to clients).
4.Oauth2 service - This service authorize client and authenticate resource owners with the help of JWT.
5.Admin Service - This service is responsible for admin related functionalities

More services are coming soon. WIP.


