package ru.galkin.task.controller;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.galkin.task.service.CalculateFrequencyService;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class CalculateController {
    CalculateFrequencyService service;

    @Autowired
    public CalculateController(CalculateFrequencyService service) {
        this.service = service;
    }

    @Operation(summary = "Count frequency of letters in the input string")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ок. Calculation is successful",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Map.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Nothing is found",
                    content = @Content)})

    @GetMapping("/calculate-frequency")
    public Map<Character, Long>
    calculateFrequency(@Parameter(description =
            "Input string of letters in English") @RequestParam String input) {
        return service.calculateFrequencyService(input);
    }
}
