# RetailManagement

Retail management system is used to calculate the final amount after applying various discounts. Discounts are divided into two parts:
1. Percentage based discount
2. Amount based discount

According to the given input, percent based discount is calculated on non grocery items. After that the calculated discount is deducted from the total amount. If total amount exceeds 100$ than addition 5$ discount is given for every multiple of 100$. After that this discount is deducted from the amount calculated above.

# Requirements:
1. Java8 of higher
2. Maven
3. Postman -- Tool to post request

# Installation
1. Go to the URL :: https://github.com/jibraniqbal2018/RetailManagement
2. Clone the project
3. Open cmd and navigate to the project location /RetailManagement/store/.
4. Run the command to run the project: mvn spring-boot:run

It will download the required jars and embedded tomcat server will run.
	

# Usage 
1. Open Postman and select method as post.
2. Click on body .
3. Click on raw tab and enter json(Find below the JSON under #Tests) data and put Content-Type as application/json.
4. Access the application by entering the URL http://localhost:8080/store/bill in the URL bar if postman

# Tests
# Case 1 : 
{"customerType":"EMPLOYEE","itemList":[{"name":"Belt","amount":20.5,"itemType":"NON_GROCERY"},{"name":"Chicken","amount":10.99,"itemType":"GROCERY"},{"name":"Butter","amount":15.95,"itemType":"GROCERY"},{"name":"Shoes","amount":250.0,"itemType":"NON_GROCERY"},{"name":"Shirt","amount":88.23,"itemType":"NON_GROCERY"}]}

# Output: 
{
    "groceriesAmount": 26.94,
    "nonGroceriesAmount": 358.73,
    "payableAmount": 268.05,
    "totalItems": 5
}

# Case 2:
{"customerType":"AFFILIATED","itemList":[{"name":"Belt","amount":20.5,"itemType":"NON_GROCERY"},{"name":"Chicken","amount":10.99,"itemType":"GROCERY"},{"name":"Butter","amount":15.95,"itemType":"GROCERY"},{"name":"Shoes","amount":250.0,"itemType":"NON_GROCERY"},{"name":"Shirt","amount":88.23,"itemType":"NON_GROCERY"}]}

# Output:
{
    "groceriesAmount": 26.94,
    "nonGroceriesAmount": 358.73,
    "payableAmount": 334.8,
    "totalItems": 5
}

# Case 3:
{"customerType":"VALUED_CUSTOMER","itemList":[{"name":"Belt","amount":20.5,"itemType":"NON_GROCERY"},{"name":"Chicken","amount":10.99,"itemType":"GROCERY"},{"name":"Butter","amount":15.95,"itemType":"GROCERY"},{"name":"Shoes","amount":250.0,"itemType":"NON_GROCERY"},{"name":"Shirt","amount":88.23,"itemType":"NON_GROCERY"}]}

# Output:
{
    "groceriesAmount": 26.94,
    "nonGroceriesAmount": 358.73,
    "payableAmount": 352.73,
    "totalItems": 5
}

# Case 4:
{"customerType":"NORMAL","itemList":[{"name":"Belt","amount":20.5,"itemType":"NON_GROCERY"},{"name":"Chicken","amount":10.99,"itemType":"GROCERY"},{"name":"Butter","amount":15.95,"itemType":"GROCERY"},{"name":"Shoes","amount":250.0,"itemType":"NON_GROCERY"},{"name":"Shirt","amount":88.23,"itemType":"NON_GROCERY"}]}

# Output
{
    "groceriesAmount": 26.94,
    "nonGroceriesAmount": 358.73,
    "payableAmount": 370.67,
    "totalItems": 5
}
