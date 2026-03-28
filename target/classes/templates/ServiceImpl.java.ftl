package ${packageName}.service.impl;

import ${packageName}.dto.${entityName}RequestDTO;
import ${packageName}.dto.${entityName}ResponseDTO;
import ${packageName}.mapper.${entityName}Mapper;
import ${packageName}.model.${entityName};
import ${packageName}.repository.${entityName}Repository;
import ${packageName}.service.${entityName}Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ${entityName}ServiceImpl implements ${entityName}Service {

    private final ${entityName}Repository repository;
    private final ${entityName}Mapper mapper;

    @Override
    public ${entityName}ResponseDTO create(${entityName}RequestDTO requestDTO) {
        ${entityName} entity = mapper.toEntity(requestDTO);
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Override
    public ${entityName}ResponseDTO findById(Long id) {
        ${entityName} entity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("${entityName} not found with id: " + id));
        return mapper.toResponseDTO(entity);
    }

    @Override
    public List<${entityName}ResponseDTO> findAll() {
        return repository.findAll().stream()
            .map(mapper::toResponseDTO)
            .toList();
    }

    @Override
    public ${entityName}ResponseDTO update(Long id, ${entityName}RequestDTO requestDTO) {
        repository.findById(id)
            .orElseThrow(() -> new RuntimeException("${entityName} not found with id: " + id));
        ${entityName} entity = mapper.toEntity(requestDTO);
        entity.setId(id);
        return mapper.toResponseDTO(repository.save(entity));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
