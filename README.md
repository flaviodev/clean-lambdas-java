# Clean Lambdas - by Victor Rentea at JBCNConf'17
https://www.youtube.com/watch?v=qcIiufH_u7c

In the words of Author:
> Everybody's using Java8 Lambdas and Streams nowadays, right? So then, why shouldn't you use them in developing your enterprise application? It's absurd to keep away from these exponents, but at some point you may start having some weird feeling about them. And then you get to your first code review, and you start wondering... How do the 'Clean Code' principles change, when you jump on Lambdas? How should you use Lambdas while keeping a clean maintainable codebase - the ultimate goal of any java enterprise application.

## Checking if a collection has any match

```java
 List<Order> orders = new ArrayList<>();
 boolean hasNotDeliveredOrders = orders.stream().anyMatch(order -> order.isNotDelivered());
```

## Optional Vs NPE

```java
 // Eminent NPE 
 BigDecimal discount = costumer.getProfile().getGoldCard().getDiscount();
	
 // Bad solution
 BigDecimal discount = BigDecimal.ZERO;
 if(costumer.getProfile() != null 
       && costumer.getProfile().getGoldCard()!= null
       && costumer.getProfile().getGoldCard().getDiscount() != null) 
    discount = costumer.getProfile().getGoldCard().getDiscount();
 
 // Optional
 BigDecimal discount = costumer.getProfileOpt()
				.flatMap(Profile::getGoldCardOpt)
				.map(GoldCard::getDiscount)
				.orElse(BigDecimal.ZERO);
```
