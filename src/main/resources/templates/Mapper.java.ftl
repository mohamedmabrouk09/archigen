package ${packageName}.mapper;

import ${packageName}.dto.${entityName}RequestDTO;
import ${packageName}.dto.${entityName}ResponseDTO;
import ${packageName}.model.${entityName};
import org.springframework.stereotype.Component;

@Component
public class ${entityName}Mapper {

    public ${entityName} toEntity(${entityName}RequestDTO dto) {
        ${entityName} entity = new ${entityName}();
        // TODO: map fields
        return entity;
    }

    public ${entityName}ResponseDTO toResponseDTO(${entityName} entity) {
        ${entityName}ResponseDTO dto = new ${entityName}ResponseDTO();
        dto.setId(entity.getId());
        // TODO: map fields
        return dto;
    }
}
