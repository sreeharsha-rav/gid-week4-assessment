# Week 4 Assessment

submitted by Sreeharsha Raveendra

## Problems

### REST API: Root Threshold in IoT Devices

- **Objective**: Query a REST API to retrieve a list of IoT devices meeting specific criteria and return the count of devices.
  
- **API Endpoint**: `POST http://localhost:8080/iotdevices/devices`

- **Criteria**:
  1. Retrieve devices with a given status substring from endpoint `GET https://jsonmock.hackerrank.com/api/iot_devices/search?status=<statusQuery>`.
  2. Go through the paginated results to get the count of devices.
  3. If the device's threshold is greater than or equal to the given threshold, then consider it as a valid device.
  4. Or, if the device's date is equal to given date, then consider it as a valid device.

- **Sample Input**:
  ```
  STOPPED
  45
  04-2019
  ```

- **Sample Output**: 
  ```
  4
  ```

- **Testing Endpoint**: 
  - `POST http://localhost:8080/iotdevices/devices`
  - Request Body:
    ```json
    {
      "statusQuery": "STOPPED",
      "threshold": 45,
      "dateStr": "04-2019"
    }
    ```

- **solution**:
    - [IotDevicesApplication](iot-devices\src\main\java\com\iotdevices\IotDevicesApplication.java) - This is a spring boot application which has a rest controller with a get method to get the count of devices based on the given criteria.
    - [NumDevicesService](iot-devices\src\main\java\com\iotdevices\service\NumDevicesService.java) - This is a service class which has the logic to get the count of devices based on the given criteria.
    - [IotDevicesController](iot-devices\src\main\java\com\iotdevices\controller\IotDevicesRestController.java) - This is a rest controller which has a get method to get the count of devices based on the given criteria.

<hr>

### Customer and Order Microservices with JWT Authentication

- **Objective**: Implement a customer microservice and an order microservice with JWT authentication.

- **MySQL Setup**:
  - Create a database named `microservices_demo`.
  - Refer to the [microservices_sql](microservices_sql.txt) for all the SQL scripts to create the tables and insert data.

- Start `OrderMicroserviceApplication` first and then `CustomerMicroserviceApplication` to run the microservices.

- **JWT Authentication for Customer Microservice**:
  - **API Endpoint**: `POST http://localhost:8090/authenticate`
  - **Request Body**:
    ```json
    {
      "username": "user",
      "password": "user"
    }
    ```
  - **Response**: 
    ```json
    {
        "jwt": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNzEwMTQ2NDg1LCJpYXQiOjE3MTAxMTA0ODV9.Msuop1xCp0Up4ne8tro1Bex1-Zk3GiDCnsD2F0Fx_u4"
    }
    ```

- **Customer Microservice**:
  - **API Endpoint**: `POST http://localhost:8090/api/customer`
  - Use JWT token for authentication in the header as `Authorization` and value as `Bearer <jwt token>`.
  - Get customer details by customer id.
    - GET `http://localhost:8090/api/customer/1`
    - Response:
      ```json
      {
        "id": 1,
        "name": "John Doe",
        "email": "john@example.com",
        "orderResponse": {
            "id": 1,
            "name": "Order1",
            "quantity": 10
        }
      }
      ```

- **Folder Structure**:
  - [customer-microservice-jwt](customer-microservice-jwt) - Customer Microservice with JWT Authentication
  - [order-microservice](order-microservice) - Order Microservice
  - [microservices_sql](microservices_sql.txt) - SQL scripts to create tables and insert data

### Additional Information

Referenced [Spring Security JWT Authentication](spring-security-jwt) for JWT authentication in the customer microservice.