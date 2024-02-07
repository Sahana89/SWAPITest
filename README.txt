This package here contains API tests for SWAPI website.
SWAPI website linked here(https://swapi.dev/) provides facts about movie world Star Wars.
The website has 6 vertical which will referred as terms within the whole package.
These terms are people, vehicle, film, planets, species and starships.
This package currently tests various different aspects of SAWPI API.
The test plan below provides more details.
I have divided the Functionality tests around the category of base url, individual term/vertical, search related.
    1. Base URL --> This tests for base url and incorrect url results from the API. More tests such as load, urls with
    special characters, incorrect paths etc can also be written.
    2. Individual term/vertical --> For the example here I have used Film vertical. Created a Film object similar to
    JSON object returned. Similar POJO objects can be created for all verticals. Each and every attribute
    deserialization for each vertical can be performed. As an example within the test here, title, episode_no,
    director and list of planets are asserted. However all attributes of the POJO could also be asserted.
    3. Search Related --> The tests here search for vertical and search term for 3 conditions. Search term being empty,
    search term being specific, search term being incorrect. These tests could also be enhanced further by searching for
    multiple search terms within space in between, special characters etc.

Future enhancements
The source of truth for the tests have been defined locally currently. However when the number of tests would increase
exponentially, A S3 or Database could be used for storing actual results.
The results of tests could also be stored as separate Object and results run every time could be stored within DB or
maintained within tools such as Test Rail etc.

The package will need to be unzipped and imported into Intellij or similar IDE (Supports java).
Follow the below steps to import the package into Intellij
    1. Pull the project from github repository.
    2. Use File --> New --> Import from Existing Sources
    3. Select an applicable JDK(Preferably JAVA 11 and onwards).
    4. Keep rest of selection as default.
Once imported, make sure to not have any build or compiler issues.
Compiler issues can be identified by red lines on right side end of the screen within each file.
Make sure to have appropriate library attached for running the program.
Follow the below steps to attach library.
    1. File --> Project Structure --> Library --> New Project Library (+) --> From Maven
    2. Type and choose the below 2 apache.httpcomponents.fluent.hc and google.code.gson libraries.
    3. Once added, click Apply
    4. If changes are not reflected, File --> Invalidate caches --> Intellij should restart and changes will be reflected.
Use the File --> Run to run the Main class.
If the tests have run successfully, then the terminal will be open and process exit 0 will be shown.
The tests currently do not print results, However using custom objects that can be achieved.
