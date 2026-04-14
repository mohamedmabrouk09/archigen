# ArchiGen

A CLI tool that scaffolds a full Spring Boot project structure in seconds — controllers, services, repositories, DTOs, mappers, and build files, all generated from a single command.

## Requirements

- Java 17+

## Installation

Clone the repository and add the `bin/` folder to your system PATH:

```bash
git clone https://github.com/your-username/archigen.git
```

**Windows** — run this in PowerShell to add `bin/` to your PATH permanently:

```powershell
[System.Environment]::SetEnvironmentVariable("Path", $env:Path + ";C:\archigen\bin", "User")
```

Then restart your terminal.

Then verify:

```bash
archigen --version
```

## Usage

```bash
archigen new <project-name> [options]
```

### Options

| Option | Alias | Default | Description |
|---|---|---|---|
| `--group-id` | `-g` | `com.example` | Maven group ID |
| `--artifact-id` | `-a` | project name | Maven artifact ID |
| `--version` | `-v` | `0.0.1-SNAPSHOT` | Project version |
| `--entity` | `-e` | `Sample` | Entity name to scaffold (e.g. `Order`) |
| `--build-tool` | `-b` | `maven` | Build tool: `maven` or `gradle` |
| `--output` | `-o` | `.` | Output directory |

## Examples

```bash
# Minimal — generates a project with a "Sample" entity
archigen new my-app

# Full example
archigen new shop -g com.mycompany -a shop -e Order --build-tool maven -o ./projects -j 17
```

## Generated Structure

```
<project-name>/
├── pom.xml  (or build.gradle)
├── README.md
└── src/main/java/<group>/<artifact>/
    ├── Application.java
    ├── controller/
    │   └── <Entity>Controller.java
    ├── service/
    │   ├── <Entity>Service.java
    │   └── impl/<Entity>ServiceImpl.java
    ├── repository/
    │   └── <Entity>Repository.java
    ├── model/
    │   └── <Entity>.java
    ├── dto/
    │   ├── <Entity>RequestDTO.java
    │   └── <Entity>ResponseDTO.java
    └── mapper/
        └── <Entity>Mapper.java
```

## Building from Source

```bash
mvn package
```

The fat JAR is automatically copied to `bin/archigen.jar`.
