# AI Coding Guidelines for SchoolStudy Repository

## Project Overview
This repository contains educational code projects in Java, C, and MATLAB from university studies at OUC and HWU. Each language has its own folder with simple, standalone programs. No complex architectures or external dependencies.

## Architecture
- **Java Projects**: In `JAVA_Project/`. Console applications using `src/` for sources, `lib/` for dependencies (empty). Packages match folder paths, e.g., `package Coursework.SD_Coursework3;`.
- **C Projects**: In `C_Project/`. Basic programs like `C_Text/C-text.c`.
- **MATLAB Projects**: In `MATLAB_Project/`. Algorithm scripts, e.g., TSP solver in `Bro_TSP.m`.

Programs are standalone; no inter-component communication.

## Developer Workflows
### Java
- Compile: `javac src/*.java` (from project root, e.g., `JAVA_Project/Coursework/SD_Coursework1/`)
- Run: `java -cp src ClassName` (e.g., `java -cp src RegularShapeArea`)
- No build tools; manual compilation.

### C
- Compile: `gcc file.c -o output` (e.g., `gcc C-text.c -o C-text`)
- Run: `./output`

### MATLAB
- Execute scripts in MATLAB IDE or command window, e.g., `tsp_31_cities_battle_royale()`

No automated tests or CI/CD.

## Coding Patterns
- **Java I/O**: Use `Scanner` for input, `System.out.println` for output. Close scanners after use.
- **Validation**: Check input ranges explicitly, e.g., in `RegularShapeArea.java`, validate shape sides 3-6.
- **Math**: Leverage `Math` class for calculations (sqrt, pow).
- **Classes**: Simple POJOs with constructors, getters. Main methods in classes like `App.java`.
- **MATLAB**: Matrix-based data handling, custom functions for distance/fitness calculations. Comments in Chinese.

## Key Examples
- `JAVA_Project/Coursework/SD_Coursework1/src/RegularShapeArea.java`: User input, conditional logic, math formulas.
- `JAVA_Project/Coursework/SD_Coursework3/Rectangle.java`: Basic class with protected fields, methods.
- `MATLAB_Project/Bro_TSP.m`: Optimization algorithm with population-based search.

Prioritize console-based, educational code without frameworks or libraries.</content>
<parameter name="filePath">d:\Code Project\GitHub\SchoolStudy\.github\copilot-instructions.md