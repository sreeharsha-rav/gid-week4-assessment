package com.iotdevices.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iotdevices.request.NumDevices;
import com.iotdevices.service.NumDevicesService;

@RestController
@RequestMapping("/iotdevices")
public class IotDevicesRestController {
	
	// Request to get the number of devices
	@PostMapping("/devices")
	public int getNumberOfDevices(@RequestBody NumDevices numDevicesRequest) {
		NumDevicesService numDevicesService = new NumDevicesService();
		return numDevicesService.processRequest(numDevicesRequest);
	}
}
