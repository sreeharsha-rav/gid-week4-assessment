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

