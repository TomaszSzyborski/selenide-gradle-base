As it is Gradle and not Maven project running the tests is used as follows
`./gradlew clean test` Bear in mind that "test" is the name of gradle task so parallelization,
adding test suites, etc. can be done by creating other named tasks, whic can ease
execution and CI/DC maintenance.

Main frameworks used are Selenide for browser automation and
RestAssured for API Automation.
Allure is used for reporting.

For code style Spotless is used - for checkup use `./gradlew spotlessCheck`
to see any issues or violations against code styling.
For Automatic code style appliance use `./gradlew spotlessApply`. Any task with type of `test`
will trigger `spotlessApply` automatically.

Remember to avoid AVOID WILDCARD IMPORTS at all costs:
The solution is to go to Preferences ( ⌘ + , on macOS / Ctrl + Alt + S on Windows and Linux) > Editor > Code
Style > Java > Imports tab set Class count to use static imports with * to 999 