1). You need PostgreSQL db.

2). Create loging user with name:shop and password: shop.

3). Set user privileges "Can login".

4). Create new DB with name:shop and owner: shop

5). Make sure you are running postgres on port 5432

6). Clone the repository.

7). Checkout ot master branch.

8). Go in project folder and run in terminal: mvn spring-boot:run

9). Server runs at port 8080.

10).Add new product: http://localhost:8080/product (POST)

JSON: 
  {
    "name":"ASUS",
    "category":"Laptop",
    "description":"desc",
    "quantity":35
  }
  
11).Update product: http://localhost:8080/product (PATCH)

JSON: 
  {
      "id":1004,
      "name":"Asus",
      "description":"new description",
      "category":"new category"
  }

12).Delete product: http://localhost:8080/product (DELETE)
  
 JSON: 
  {
      "id":1014
  }
  
13).Gett all products: http://localhost:8080/products/?page=3&pageSize=2&orderBy=name&direction=DESC (GET)
  
  JSON: 
  {
      "id":1014
  }
  
14).Gett all products: http://localhost:8080/categories (GET)
  
JSON: 
  {
      "id":1014
  }
  
  
