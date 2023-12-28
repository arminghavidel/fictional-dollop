# API Documentation

## product

### products
- **Method**: `GET`
- **URL**: `localhost:8383/product`

#### Headers


#### Response example (response)

```json
{
    "content": [
        {
            "id": 1,
            "name": "Product One",
            "description": "This is a product.",
            "provider": {
                "id": 1,
                "name": "Provider One"
            },
            "onlyBuyersCanReview": false,
            "reviews": [
                {
                    "id": 5,
                    "comment": "Could be better, but worth the price.",
                    "rating": 2,
                    "user": {
                        "id": 5,
                        "username": "userfive"
                    }
                },
                {
                    "id": 4,
                    "comment": "Not what I expected, but okay",
                    "rating": 3,
                    "user": {
                        "id": 4,
                        "username": "userfour"
                    }
                },
                {
                    "id": 3,
                    "comment": "Great product, highly recommended!",
                    "rating": 4,
                    "user": {
                        "id": 3,
                        "username": "userthree"
                    }
                }
            ],
            "reviewCount": 5,
            "averageRating": 3.8,
            "commentingEnabled": true,
            "ratingEnabled": true
        },
        {
            "id": 2,
            "name": "Product Two",
            "description": "This is a product.",
            "provider": {
                "id": 1,
                "name": "Provider One"
            },
            "onlyBuyersCanReview": false,
            "reviews": [
                {
                    "id": 7,
                    "comment": null,
                    "rating": 2,
                    "user": {
                        "id": 7,
                        "username": "userseven"
                    }
                },
                {
                    "id": 6,
                    "comment": null,
                    "rating": 4,
                    "user": {
                        "id": 6,
                        "username": "usersix"
                    }
                }
            ],
            "reviewCount": 2,
            "averageRating": 3,
            "commentingEnabled": false,
            "ratingEnabled": true
        },
        {
            "id": 3,
            "name": "Product Three",
            "description": "This is a product.",
            "provider": {
                "id": 1,
                "name": "Provider One"
            },
            "onlyBuyersCanReview": true,
            "reviews": [
                {
                    "id": 10,
                    "comment": "Highly recommended for anyone looking for reliability and efficiency.",
                    "rating": 4,
                    "user": {
                        "id": 3,
                        "username": "userthree"
                    }
                }
            ],
            "reviewCount": 1,
            "averageRating": 4,
            "commentingEnabled": true,
            "ratingEnabled": true
        },
        {
            "id": 4,
            "name": "Product Four",
            "description": "This is a product.",
            "provider": {
                "id": 2,
                "name": "Provider Two"
            },
            "onlyBuyersCanReview": true,
            "reviews": [],
            "reviewCount": null,
            "averageRating": null,
            "commentingEnabled": false,
            "ratingEnabled": true
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 4,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 4,
    "empty": false
}
```

---

### add review
- **Method**: `POST`
- **URL**: `localhost:8383/product/:productId/review`

#### Headers

- `user_id`: `3`

#### Body

```json
{
    "comment": "Highly recommended for anyone looking for reliability and efficiency.",
    "rating": 4
}
```

#### Response example (response)

```json
None
```

---

## review

### reviews
- **Method**: `GET`
- **URL**: `localhost:8383/review?isApproved=true`

#### Headers


#### Response example (response)

```json
{
    "content": [
        {
            "id": 10,
            "comment": "Highly recommended for anyone looking for reliability and efficiency.",
            "rating": 4,
            "product": {
                "id": 3,
                "name": "Product Three"
            },
            "user": {
                "id": 3,
                "username": "userthree"
            },
            "approved": true
        },
        {
            "id": 7,
            "comment": null,
            "rating": 2,
            "product": {
                "id": 2,
                "name": "Product Two"
            },
            "user": {
                "id": 7,
                "username": "userseven"
            },
            "approved": true
        },
        {
            "id": 6,
            "comment": null,
            "rating": 4,
            "product": {
                "id": 2,
                "name": "Product Two"
            },
            "user": {
                "id": 6,
                "username": "usersix"
            },
            "approved": true
        },
        {
            "id": 5,
            "comment": "Could be better, but worth the price.",
            "rating": 2,
            "product": {
                "id": 1,
                "name": "Product One"
            },
            "user": {
                "id": 5,
                "username": "userfive"
            },
            "approved": true
        },
        {
            "id": 4,
            "comment": "Not what I expected, but okay",
            "rating": 3,
            "product": {
                "id": 1,
                "name": "Product One"
            },
            "user": {
                "id": 4,
                "username": "userfour"
            },
            "approved": true
        },
        {
            "id": 3,
            "comment": "Great product, highly recommended!",
            "rating": 4,
            "product": {
                "id": 1,
                "name": "Product One"
            },
            "user": {
                "id": 3,
                "username": "userthree"
            },
            "approved": true
        },
        {
            "id": 2,
            "comment": "Loved it, will definitely buy again!",
            "rating": 5,
            "product": {
                "id": 1,
                "name": "Product One"
            },
            "user": {
                "id": 2,
                "username": "usertwo"
            },
            "approved": true
        },
        {
            "id": 1,
            "comment": "Fantastic quality at a great price.",
            "rating": 5,
            "product": {
                "id": 1,
                "name": "Product One"
            },
            "user": {
                "id": 1,
                "username": "userone"
            },
            "approved": true
        }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 20,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "last": true,
    "totalPages": 1,
    "totalElements": 8,
    "size": 20,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "first": true,
    "numberOfElements": 8,
    "empty": false
}
```

---

### review
- **Method**: `GET`
- **URL**: `localhost:8383/review/:reviewId`

#### Headers


#### Response example (resposne)

```json
{
    "id": 1,
    "comment": "Fantastic quality at a great price.",
    "rating": 5,
    "product": {
        "id": 1,
        "name": "Product One"
    },
    "user": {
        "id": 1,
        "username": "userone"
    },
    "approved": true
}
```

---

### approve review
- **Method**: `POST`
- **URL**: `localhost:8383/review/:reviewId/approve`

#### Headers


#### Response example (response)

```json
None
```

---

