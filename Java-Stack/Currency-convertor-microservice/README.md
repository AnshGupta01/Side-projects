# Currency Converter: Microservices
Currency Converter application using Spring Microservices, deployed with Docker & Kubernates.

# Project Implementations:
* API gateway
* Eureka server and client
* Spring cloud tools
* Resilience4j
* Zipkin for Distributed Tracing
* Feign client
* and a few more….

## URLS

#### Currency Exchange Service
- http://localhost:8000/currency-exchange/from/USD/to/INR

#### Currency Conversion Service
- http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
- http://localhost:8100/currency-conversion-feign/from/USD/to/INR/quantity/10

#### Eureka
- http://localhost:8761/

#### Zipkin
- http://localhost:9411/

#### API GATEWAY
- http://localhost:8765/currency-exchange/from/USD/to/INR
- http://localhost:8765/currency-conversion-feign/from/USD/to/INR/quantity/10
- http://localhost:8765/currency-conversion-new/from/USD/to/INR/quantity/10  
