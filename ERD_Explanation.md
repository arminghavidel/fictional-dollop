
# Entity-Relationship Diagram (ERD) Explanation

## Tables Description

### `provider`
- Represents information about providers.
- Has a one-to-many relationship with `product`.

### `product`
- Stores details about products.
- Each product is associated with one provider.
- Each product can have many reviews.
- Has fields for rating and review count aggregation.

### `user`
- Contains user information.
- Users can have many reviews (one-to-many relationship).

### `review`
- Contains reviews made by users on products.
- Links to `product` and `user` through foreign keys.

### `DATABASECHANGELOG` and `DATABASECHANGELOGLOCK`
- These are Liquibase-specific tables used to track database changes and locks.

## Relationships

- A `provider` can have multiple `product`s, but each `product` is associated with only one `provider`.
- A `product` can have multiple `review`s, but each `review` is associated with only one `product`.
- A `user` can leave multiple `review`s, but each `review` is associated with only one `user`.


![fictional_dollop_ERD.png](..%2F..%2F..%2Ffictional_dollop_ERD.png)