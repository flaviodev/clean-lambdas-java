# Clean Lambdas - by Victor Rentea at JBCNConf'17
https://www.youtube.com/watch?v=qcIiufH_u7c

## Checking if a collection has any match

```java
 List<Order> orders = new ArrayList<>();
 boolean hasNotDeliveredOrders = orders.stream().anyMatch(order -> order.isNotDelivered());
```

