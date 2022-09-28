package ru.kirilin.skillswap.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kirilin.skillswap.dto.SkillDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.Skill;
import ru.kirilin.skillswap.service.SkillService;

import java.util.List;

@Controller
@RequestMapping("/v1")
@RequiredArgsConstructor
public class SkillController {

    private final SkillService skillService;

    @GetMapping("/skills")
    public ResponseEntity<List<SkillDto>> getUserSkills(@RequestParam String id,
                                                        @RequestParam(name = "accountType") AccountType accountType){
        return ResponseEntity.ok(skillService.getAllUserSkills(id, accountType));
    }

    @GetMapping("/skills/{id}")
    public ResponseEntity<SkillDto> getSkillById(@PathVariable(name = "id") Skill skill){
        return ResponseEntity.ok(skillService.toDto(skill));
    }

    @PostMapping("/skills")
    public ResponseEntity<SkillDto> createSkill(@RequestBody SkillDto skillDto,
                                                @RequestParam("userId") String userId,
                                                @RequestParam(name = "accountType") AccountType accountType){
        return ResponseEntity.ok(skillService.createSkill(skillDto, userId, accountType));
    }
}
