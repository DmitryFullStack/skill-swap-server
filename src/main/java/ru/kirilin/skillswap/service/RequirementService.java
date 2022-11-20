package ru.kirilin.skillswap.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kirilin.skillswap.dto.RequirementDto;
import ru.kirilin.skillswap.entity.AccountType;
import ru.kirilin.skillswap.entity.Requirement;
import ru.kirilin.skillswap.entity.User;
import ru.kirilin.skillswap.mapper.RequirementMapper;
import ru.kirilin.skillswap.repository.RequirementRepository;
import ru.kirilin.skillswap.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class RequirementService {
    private final RequirementRepository requirementRepository;
    private final UserRepository userRepository;
    private final RequirementMapper requirementMapper;

    public RequirementDto getRequirementById(UUID id){
        return requirementMapper.toDto(requirementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Requirement with id {%S} not found!", id))));
    }

    public RequirementDto createRequirement(RequirementDto requirementDto,
                                @Nullable String userId,
                                @Nullable AccountType accountType){
        assert Objects.nonNull(requirementDto) : "Requirement Dto must not be null!";
        User user = null;
        if(Objects.nonNull(userId) && Objects.nonNull(accountType)){
            user = userRepository.findById(User.AccountId.of(userId, accountType))
                    .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        }
        Requirement Requirement = requirementMapper.toEntity(requirementDto);
        Requirement.setUser(user);
        return requirementMapper.toDto(requirementRepository.save(Requirement));
    }

    @Transactional(readOnly = true)
    public List<RequirementDto> getAllUserRequirements(String id, AccountType accountType){
        User user = userRepository.findById(User.AccountId.of(id, accountType))
                .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        return user.getRequirements().stream()
                .map(requirementMapper::toDto)
                .collect(Collectors.toList());
    }

    public RequirementDto editRequirement(Requirement requirement,
                                          RequirementDto requirementDto,
                                          @Nullable String userId,
                                          @Nullable AccountType accountType){
        assert Objects.nonNull(requirementDto) : "Requirement Dto must not be null!";
        if(Objects.nonNull(userId) && Objects.nonNull(accountType)){
           userRepository.findById(User.AccountId.of(userId, accountType))
                    .orElseThrow(() -> new IllegalArgumentException("User not found!"));
        }
        BeanUtils.copyProperties(requirementDto, requirement, "id");
        return requirementMapper.toDto(requirementRepository.save(requirement));
    }

    public int archiveRequirement(Requirement requirement) {
        return requirementRepository.setRequirementArchiveTrue(requirement.getId());
    }
}
