package com.provedcode.util.annotations.doc.controller.kudos;

import com.provedcode.talent.model.dto.SkillsOnProofDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Operation(summary = "Add Kudos To Skill",
        description = "As sponsor I want to have an opportunity to give kudos to certain skill on a proof")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200",
                description = "SUCCESS"),
        @ApiResponse(responseCode = "404",
                description = "NOT FOUND (skill with id = %s not found, " +
                        "talent with id = %s not found," +
                        "Sponsor with login = %s not found" +
                        "Proof with id = %d not found)",
                content = @Content(mediaType = "application/json",
                        schema = @Schema)),
        @ApiResponse(
                responseCode = "401",
                description = "UNAUTHORIZED",
                content = @Content(mediaType = "application/json",
                        schema = @Schema)),
        @ApiResponse(
                responseCode = "403",
                description = "FORBIDDEN (Skill on proof that was kudosed does not have the PUBLISHED status," +
                        "The sponsor cannot give more kudos than he has)",
                content = @Content(mediaType = "application/json",
                        schema = @Schema)),
        @ApiResponse(
                responseCode = "400",
                description = "BAD REQUEST",
                content = @Content(mediaType = "application/json",
                        schema = @Schema))
})
public @interface PostAddKudosToSkillApiDoc {
}
