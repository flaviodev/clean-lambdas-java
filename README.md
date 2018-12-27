# Clean Lambdas - by Victor Rentea at JBCNConf'17

## Checking if a collection has any match

```java
 List<Order> orders = new ArrayList<>();
 boolean hasNotDeliveredOrders = order.stream().anyMatch(order -> order.isNotDelivered());
```

