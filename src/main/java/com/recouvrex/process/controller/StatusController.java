package com.recouvrex.process.controller;

import com.recouvrex.process.model.Status;
import com.recouvrex.process.model.Task;
import com.recouvrex.process.service.StatusService;
import com.recouvrex.process.service.TaskService;
import com.recouvrex.process.utils.CountCasesStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Status", description = "Status management APIs")
//@CrossOrigin(origins = "http://localhost:8089")
@RestController
@RequestMapping("/api/Status")
public class StatusController {

	@Autowired
	StatusService statusService;


	/*@Operation(summary = "Create a new Tutorial"
	, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
					@ApiResponse(responseCode = "201", content = {
									@Content(schema = @Schema(implementation = Task.class), mediaType = "application/json") }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/")
	public ResponseEntity<Status> createTask(@RequestBody Status status) {
		try {
			Status _status = statusService.save(status);

			return new ResponseEntity<>(_status, HttpStatus.CREATED);
		} catch (Exception e) {
			//e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
*/
    @Operation(summary = "Retrieve all Status"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
					@ApiResponse(responseCode = "200", content = {
									@Content(schema = @Schema(implementation = Status.class), mediaType = "application/json") }),
					@ApiResponse(responseCode = "204", description = "No status found", content = {
									@Content(schema = @Schema()) }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/")
	public ResponseEntity<List<Status>> listStatus() {
		return new ResponseEntity<>(statusService.listStatus(), HttpStatus.OK);
	}

	@Operation(summary = "Retrieve count Status"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = Status.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "204", description = "No status found", content = {
					@Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/countStatus/{userId}")
	public ResponseEntity<List<CountCasesStatus>> findStatusCount(@PathVariable("userId") Long userId) {
		return new ResponseEntity<>(statusService.findStatusCounts(userId), HttpStatus.OK);
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
