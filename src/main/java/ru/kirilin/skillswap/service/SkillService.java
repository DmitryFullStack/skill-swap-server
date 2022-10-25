package ru.kirilin.skillswap.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirilin.skillswap.dto.SkillDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.Skill;
import ru.kirilin.skillswap.entity.User;
import ru.kirilin.skillswap.mapper.SkillMapper;
import ru.kirilin.skillswap.repository.SkillRepository;
import ru.kirilin.skillswap.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;
    private final UserRepository userRepository;
    private final SkillMapper skillMapper;

    public SkillDto getSkillById(UUID id){
        return skillMapper.toDto(skillRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Skill with id {%S} not found!", id))));
    }

    public SkillDto createSkill(SkillDto skillDto,
                                @Nullable String userId,
                                @Nullable AccountType accountType){
        assert Objects.nonNull(skillDto) : "Skill Dto must not be null!";
        User user = null;
        if(Objects.nonNull(userId) && Objects.nonNull(accountType)){
            user = userRepository.findById(User.AccountId.of(userId, accountType))
                    .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        }
        Skill skill = skillMapper.toEntity(skillDto);
        skill.setUser(user);
        return skillMapper.toDto(skillRepository.save(skill));
    }

    public List<SkillDto> getAllUserSkills(String id, AccountType accountType){
        User user = userRepository.findById(User.AccountId.of(id, accountType))
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        return user.getSkills().stream()
                .map(skillMapper::toDto)
                .collect(Collectors.toList());
    }

    public SkillDto updateSkill(SkillDto skillDto, Skill skill) {
        BeanUtils.copyProperties(skillDto, skill, "id");
        return skillMapper.toDto(skillRepository.save(skill));
    }
}
