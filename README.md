# trade-service
   Springboot based Trade service. Handles Trade creation and updation. If the lower version is being received by the store it will reject and throw StaleTradeException. If trade has less maturity date then today date then it will return Maturity date in past using TradeExpiredException. Book data and CounterParty data is cached using Spring @Cachable anotation.


**Build Steps**

mvn clean install

**Run Steps**

java -jar target/trade-service-0.0.1-SNAPSHOT.jar


# The System Design

<p align="center">
  <img src="images/msarc.png">
  <br/>
</p>

**Eception Handling**
<p align="center">
  <img src="images/exception_handling.png">
  <br/>
</p>