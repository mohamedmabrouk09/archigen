package ${packageName}.adapter.in.web;

import ${packageName}.application.port.in.${entityName}UseCase;

public class ${entityName}Controller {

    private final ${entityName}UseCase useCase;

    public ${entityName}Controller(${entityName}UseCase useCase) {
        this.useCase = useCase;
    }
}
