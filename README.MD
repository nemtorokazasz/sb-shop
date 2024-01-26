# API Documentation

## Access level: `USER`

### Register a new user account [POST]
```bash
/api/auth/sign-up
```
```json
{
  "name": "John Example",
  "username": "user",
  "password": "user"
}
```
---
### Login to an  account [POST]
```bash
/api/auth/sign-in
```
```json
{
  "username": "user",
  "password": "user"
}
```
---
### Get all products [GET]
```bash
/api/product
```
---
### Save purchase [POST]
```bash
/api/purchase
```
```json
{
  "userId": 1,
  "productId": 1,
  "price": 1.5
}
```
---
### Get all purchase of logged-in user [GET]
```bash
/api/purchase
```
---
## Access level: `ADMIN`
### Add a new product [POST]
```bash
/api/product
```
```json
{
  "title": "Test",
  "category": "Test",
  "description": "Test",
  "price": 1.5,
  "quantity": 1000
}
```
---
### Delete a product [DELETE]
```bash
/api/product/${productId}
```
---
## Access level: `SYS_MANAGER`
### Changes role to ADMIN [PUT]
```bash
/api/internal/make-admin/${username}
```
---
### Changes role to USER [PUT]
```bash
/api/internal/make-user/${username}
```
---