package com.recouvrex.process.controller;

import com.recouvrex.process.model.Task;
import com.recouvrex.process.model.Tutorial;
import com.recouvrex.process.service.TaskService;
import com.recouvrex.process.service.TutorialService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.camunda.bpm.engine.impl.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Task", description = "Tutorial management APIs")
//@CrossOrigin(origins = "http://localhost:8089")
@RestController
@RequestMapping("/api")
public class TaskController {

	@Autowired
	TaskService taskService;


	@Operation(summary = "Create a new Task"
	, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
					@ApiResponse(responseCode = "201", content = {
									@Content(schema = @Schema(implementation = Task.class), mediaType = "application/json") }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/Task")
	public ResponseEntity<Task> createTask(@RequestBody Task task,Long caseId) {
		try {

			Task _task = taskService.save(task,caseId);

			return new ResponseEntity<>(_task, HttpStatus.CREATED);
		} catch (Exception e) {
			//e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Retrieve all Task by caseId"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
					@ApiResponse(responseCode = "200", content = {
									@Content(schema = @Schema(implementation = Task.class), mediaType = "application/json") }),
					@ApiResponse(responseCode = "204", description = "There are no Task this caseId", content = {
									@Content(schema = @Schema()) }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/task/{caseId}")
	public ResponseEntity<List<Task>> getTaskByCaseId(@PathVariable("caseId") Long CaseId) {
		return new ResponseEntity<>(taskService.findByCaseId(CaseId), HttpStatus.OK);
	}
	/*
	@Operation(summary = "Delete a Tutorial by Id", tags = { "tutorials", "delete" },
			security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/tutorials/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			tutorialService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "Delete all Tutorials", tags = { "tutorials", "delete" }
	, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({ @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/tutorials")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
		try {
			tutorialService.deleteAll();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@Operation(summary = "Retrieve all published Tutorials", tags = { "tutorials", "get", "filter" }
			,security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({ @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema()) }),
			 @ApiResponse(responseCode = "204", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/tutorials/published/{isPublished}")
	public ResponseEntity<List<Tutorial>> findByPublished(@PathVariable boolean isPublished) {
		try {
			List<Tutorial> tutorials = tutorialService.findByPublished(isPublished);

			if (CollectionUtil.isEmpty(tutorials)) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(tutorials, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
}
