package com.mescobar.dashboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mescobar.dashboard.model.Task;

@RestController
public class ApplicationController {

	private final List<Task> tasks;

	public ApplicationController() {
		tasks = new ArrayList<>();
	}

	@MessageMapping("/add_new_task")
	@SendTo("/tasks/added_task")
	public Task addTask(@RequestBody Task task) {
		tasks.add(task);
		return task;
	}
}
