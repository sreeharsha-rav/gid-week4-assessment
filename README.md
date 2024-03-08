# Week 4 Assessment

submitted by Sreeharsha Raveendra

## Problems

### REST API: Root Threshold in IoT Devices

- **Objective**: Query a REST API to retrieve a list of IoT devices meeting specific criteria and return the count of devices.
  
- **API Endpoint**: `GET https://jsonmock.hackerrank.com/api/iot_devices/search?status=<statusQuery>&page=<pageNumber>`

- **Criteria**:
  1. Retrieve devices with a given status substring.
  2. Filter devices added during a specific month and year.
  3. Filter devices with a root threshold greater than a specified value.
  
- **Request Parameters**:
  - `statusQuery`: Status substring to query.
  - `threshold`: Threshold value for the root threshold.
  - `dateStr`: Month and year to query in MM-YYYY format.

- **Response Structure**:
  - `page`: Current page.
  - `per_page`: Maximum number of devices returned per page.
  - `total`: Total number of devices.
  - `total_pages`: Total number of pages.
  - `data`: Array of device objects.
    - `id`: Unique ID of the device.
    - `timestamp`: Timestamp when the device was added (in UTC milliseconds).
    - `status`: Status of the device.
    - `operatingParams`: Object containing operating parameters.
      - `rotorSpeed`: Rotor speed of the device.
      - `slack`: Slack in the device.
      - `rootThreshold`: Root threshold for the device.
    - `asset`: Object containing information about the asset.
      - `id`: Unique ID of the asset.
      - `alias`: Alias for the asset.
    - `parent`: Optional object containing information about the parent of the device.
      - `id`: Unique ID of the parent.
      - `alias`: Alias for the parent.

- **Function Description**: 
  - Implement `NumDevices`.
  - Parameters:
    - `statusQuery`: Status substring to query.
    - `threshold`: Threshold value.
    - `dateStr`: Month and year to query in MM-YYYY format.
  - Returns: Total number of matching devices.

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


### Customer and Order Microservices with JWT Authentication

- **Objective**: Implement a customer microservice and an order microservice with JWT authentication.

