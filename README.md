1). You need PostgreSQL db.
2). Create loging user with name:shop and password: shop.
3). Set user privileges "Can login".
4). Create new DB with name:shop and owner: shop
5). Make sure you are running postgres on port 5432
6). Go in project folder and run in terminal: mvn spring-boot:run
7). Server runs at port 8080.
8).Add new product: http://localhost:8080/product (POST)
  JSON: 
  {
    "name":"ASUS",
    "category":"Laptop",
    "description":"desc",
    "quantity":35
  }
9).Update product: http://localhost:8080/product (PATCH)
  JSON: 
  {
      "id":1004,
      "name":"Asus",
      "description":"new description",
      "category":"new category"
  }

10).Delete product: http://localhost:8080/product (DELETE)
  JSON: 
  {
      "id":1014
  }
  
11).Gett all products: http://localhost:8080/products/?page=3&pageSize=2&orderBy=name&direction=DESC (GET)
  JSON: 
  {
      "id":1014
  }
  
12).Gett all products: http://localhost:8080/categories (GET)
  JSON: 
  {
      "id":1014
  }
  
  
