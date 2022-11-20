package ru.kirilin.skillswap.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kirilin.skillswap.dto.RequirementDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.Requirement;
import ru.kirilin.skillswap.entity.Skill;
import ru.kirilin.skillswap.mapper.RequirementMapper;
import ru.kirilin.skillswap.service.RequirementService;

import java.util.List;

@Controller
@RequestMapping("/v1")
@RequiredArgsConstructor
public class RequirementController {

    private final RequirementService requirementService;
    private final RequirementMapper requirementMapper;

    @GetMapping("/requirements")
    public ResponseEntity<List<RequirementDto>> getUserRequirements(@RequestParam String id,
                                                              @RequestParam(name = "accountType") AccountType accountType){
        return ResponseEntity.ok(requirementService.getAllUserRequirements(id, accountType));
    }

    @GetMapping("/requirements/{id}")
    public ResponseEntity<RequirementDto> getRequirementById(@PathVariable(name = "id") Requirement requirement){
        return ResponseEntity.ok(requirementMapper.toDto(requirement));
    }

    @PostMapping("/requirements")
    public ResponseEntity<RequirementDto> createRequirement(@RequestBody RequirementDto requirementDto,
                                                @RequestParam("userId") String userId,
                                                @RequestParam(name = "accountType") AccountType accountType){
        return ResponseEntity.ok(requirementService.createRequirement(requirementDto, userId, accountType));
    }

    @PostMapping("/requirements/{requirement}")
    public ResponseEntity<RequirementDto> createRequirement(@RequestBody RequirementDto requirementDto,
                                                            @PathVariable(name = "requirement") Requirement requirement,
                                                            @RequestParam("userId") String userId,
                                                            @RequestParam(name = "accountType") AccountType accountType){
        return ResponseEntity.ok(requirementService.editRequirement(requirement, requirementDto, userId, accountType));
    }

    @DeleteMapping("/requirements/{requirement}")
    public ResponseEntity<Integer> archiveSkill(@PathVariable(name = "requirement") Requirement requirement){
        return ResponseEntity.ok(requirementService.archiveRequirement(requirement));
    }
}
