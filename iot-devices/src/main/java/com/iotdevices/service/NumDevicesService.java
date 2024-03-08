package com.iotdevices.service;

import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.iotdevices.request.NumDevices;
import com.iotdevices.response.PageResponse;
import com.iotdevices.response.Device;
import com.iotdevices.response.OperatingParameters;

// Class to process the number of devices request
public class NumDevicesService {

	private final String url = "https://jsonmock.hackerrank.com/api/iot_devices/search";
	private RestTemplate restTemplate;
	
	// Method to process the number of devices request
	public int processRequest(NumDevices numDevicesRequest) {
		// Extract the fields from the request
		String statusQuery = numDevicesRequest.getStatusQuery();
		int threshold = numDevicesRequest.getThreshold();
		String dateStr = numDevicesRequest.getDateStr();
		
		String requestURL = url + "?status=" + statusQuery; // Request URL

		int totalPages = getTotalPages(requestURL); // Get the total number of pages
		int devicesCount = 0; // Count of devices
		
		// Iterate through the pages
		for (int i = 1; i <= totalPages; i++) {
			requestURL = url + "?status=" + statusQuery + "&page=" + i; // Request URL
			System.out.println("\nCurrent Page: " + i + " Total Pages: " + totalPages);
			System.out.println("Current devices count: " + devicesCount);
			PageResponse pageResponse = getPageResponse(requestURL); // Get the page response
			if (pageResponse == null) {
				break; // Break if the page response is null
			}
			devicesCount += getCount(pageResponse, threshold, dateStr); // Get the count of devices based on the														// threshold and date
		}
		
		return devicesCount; // Return the count of devices;
	}
	
	// Method to get the page response
	private PageResponse getPageResponse(String requestURL) {
		// Make a GET request to the URL
		restTemplate = new RestTemplate();
		PageResponse response = restTemplate.getForObject(requestURL, PageResponse.class);
		return response;
	}
	
	// Method to get the total number of pages
	private int getTotalPages(String requestURL) {
		PageResponse pageResponse = getPageResponse(requestURL);	// Get the page response
		return pageResponse.getTotal_pages();	// Return the total number of pages
	}
	
	// Method to get the count of devices based on the threshold and date
	private int getCount(PageResponse pageResponse, int threshold, String dateStr) {
		int count = 0;
		int devicesInPage = pageResponse.getData().size(); // Number of devices in the page
		// Iterate through the devices
		for (int i = 0; i < devicesInPage; i++) {
			// Extract Device object and OperatingParameters object
			Device device = pageResponse.getData().get(i);
			OperatingParameters operatingParameters = device.getOperatingParameters();
			
			// Extract the fields from the Device object
			long timestamp = device.getTimestamp(); // Get the timestamp
			String formattedDate = convertTimestampToDate(timestamp); // Convert the timestamp to date string MM-YYYY
			boolean dateMatch = formattedDate.equalsIgnoreCase(dateStr); // Flag to check if the date matches
			
			// Extract the root threshold from the OperatingParameters object
			boolean thresholdMatch = false; // Flag to check if the root threshold matches
			if (operatingParameters != null) {
				double rootThreshold = operatingParameters.getRootThreshold(); // Get the root threshold
				if (rootThreshold >= threshold) {
                    thresholdMatch = true; // Set the flag to true if the root threshold matches
                }
			}
			
			if (dateMatch || thresholdMatch) {
				System.out.println(device);
				count++; // Increment the count if the date matches or the root threshold matches
			}
		}
		return count; // Return the count
	}
	
	// Method to convert the timestamp to date string
	private String convertTimestampToDate(long timestamp) {
		Instant instant = Instant.ofEpochMilli(timestamp);
		ZonedDateTime zdt = instant.atZone(ZoneId.of("UTC"));
		String formattedDate = DateTimeFormatter.ofPattern("MM-yyyy").format(zdt);
		return formattedDate;
	}
}
