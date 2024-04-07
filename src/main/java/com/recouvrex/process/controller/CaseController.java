package com.recouvrex.process.controller;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.Procedure;
import com.recouvrex.process.model.Status;
import com.recouvrex.process.model.Tutorial;
import com.recouvrex.process.model.enums.FollowingActionEnum;
import com.recouvrex.process.model.enums.ProcessingActionEnum;
import com.recouvrex.process.service.CaseService;
import com.recouvrex.process.service.TutorialService;
import com.recouvrex.process.utils.IdentificationTool;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.impl.util.CollectionUtil;
import org.camunda.bpm.engine.runtime.Execution;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Case", description = "Case management API")
//@CrossOrigin(origins = "http://localhost:8089")
@RestController
@RequestMapping("/api/case")
public class CaseController {

	@Autowired
	CaseService caseService;

	@Operation(summary = "Create a new case"
	, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
					@ApiResponse(responseCode = "201", content = {
									@Content(schema = @Schema(implementation = Case.class), mediaType = "application/json") }),
					@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/")
	public ResponseEntity<Case> createCase(@RequestBody Case cas) {
		try {
			Case _case = caseService.createCase(cas);
			return new ResponseEntity<>(_case, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Operation(summary = "follow case"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Case.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping("/follow/{caseId}/followingAction/{followingAction}/status/{status}")
	public ResponseEntity<Case> decideOnAction(@PathVariable("caseId") String caseId,
											   @PathVariable("followingAction") FollowingActionEnum followingAction,
											   @PathVariable("status") Long statusId){
		Case _case = caseService.decideOnAction(caseId, followingAction, statusId);
		return new ResponseEntity<>(_case, HttpStatus.OK);
	}

	@Operation(summary = "process the collect action"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Case.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping("/processAction/{caseId}/ProcessingAction/{processingAction}/status/{status}")
	public ResponseEntity<Case> processCollectAction(@PathVariable("caseId") String caseId,
											   @PathVariable("processingAction") ProcessingActionEnum processingAction,
											   @PathVariable("status") Long statusId){
		Case _case = caseService.processCollectAction(caseId, processingAction, statusId);
		return new ResponseEntity<>(_case, HttpStatus.OK);
	}

	@Operation(summary = "decide on procedure"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Case.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PutMapping("/decideOnProcedure/{caseId}/procedureId/{procedureId}/status/{status}/processingAction/{processingAction}")
	public ResponseEntity<Case> decideOnProcedure(@PathVariable("caseId") String caseId,
													 @PathVariable("procedureId") Long procedureId,
													 @PathVariable("status") Long statusId,
												  @PathVariable("processingAction") ProcessingActionEnum processingAction){
		Case _case = caseService.processCollectAction(caseId, procedureId, statusId, processingAction);
		return new ResponseEntity<>(_case, HttpStatus.OK);
	}

	@Operation(summary = "Filter on cases"
			, security = @SecurityRequirement(name = "bearerAuth"))
	@ApiResponses({
			@ApiResponse(responseCode = "201", content = {
					@Content(schema = @Schema(implementation = Case.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/filter/")
	public ResponseEntity<List<Case>> filterCase(@RequestParam(value = "caseId", required = false) String caseId, @RequestParam(value = "status", required = false) Long statusId, @RequestParam(value = "procedure", required = false) Long procedureId) {
		List<Case> caseList = caseService.filterCase(caseId, statusId, procedureId);
		return new ResponseEntity<>(caseList, HttpStatus.OK);
	}

}
