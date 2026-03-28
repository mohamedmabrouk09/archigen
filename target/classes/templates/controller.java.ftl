package ${packageName}.controller;

import ${packageName}.dto.${entityName}RequestDTO;
import ${packageName}.dto.${entityName}ResponseDTO;
import ${packageName}.service.${entityName}Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/${entityName?lower_case}s")
@RequiredArgsConstructor
public class ${entityName}Controller {

    private final ${entityName}Service service;

    @PostMapping
    public ResponseEntity<${entityName}ResponseDTO> create(@RequestBody ${entityName}RequestDTO requestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(requestDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<${entityName}ResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<${entityName}ResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<${entityName}ResponseDTO> update(@PathVariable Long id,
                                                           @RequestBody ${entityName}RequestDTO requestDTO) {
        return ResponseEntity.ok(service.update(id, requestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
