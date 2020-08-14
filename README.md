# QU Test Task
<hr>

# Table of Contents
* [Project structure](#structure)
* [For developer](#for-developer)
* [Test project](#test-project)
* [Author](#author)
<hr>

# <a name="structure"></a>Project Structure
* Java 11
* Maven 3.6.0
* Maven checkstyle plugin 3.1.1
* Log4j 1.2.17
* JUnit 4.12
<hr>

# <a name="for-developer"></a>For developer

1. Open the project in your IDE.

2. Add Java SDK 11 or above in Project Structure

3. Change the path to log file in src/main/resources/log4j.properties. (Optional)

4. Change the path to txt file with input data in src/main/java/Main.java (PATH_TO_FILE_WITH_INPUT_DATA). (Optional)

5. Change the path to the directory where will be saved txt file with output data in src/main/java/Main.java (PATH_TO_DIRECTORY_WITH_OUTPUT_DATA). By default, file with output data will be created in the directory called output located in the root directory of the project. (Optional)

6. Run the project.
<hr>

# <a name="test-project"></a>Test project
There is file.txt with input data located in src/main/resources, but you can provide your own input data. The first option is to change the content of file.txt. The second option is to change the path to file with input data for yours. For this purpose look paragraph 4 of "For developer" section.
<hr>

# <a name="author"></a>Author

[Arkhanhelskyi Mykyta](https://github.com/Nick97-git)
