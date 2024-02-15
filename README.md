**RUS**

**Тестовое задание для позиции Java-разработчик (стажер)
в компанию Т1 Консалтинг:**

Спроектировать(продумать формат и ограничения входящих/исходящих параметров) и реализовать REST API, вычисляющее частоту встречи символов по заданной строке. Результат должен быть отсортирован по убыванию количества вхождений символа в заданную строку.

Пример входной строки: “aaaaabcccc”
Пример выходного результата: “a”: 5, “c”: 4, “b”: 1

Требования к решению:
Java 8+
Spring boot 2+
Решение должно быть покрыто тестами
У решения должна быть документация по запуску и формату входящих/исходящих параметров
Код решения необходимо разместить в публичном Github репозитории.
______________________
**Документация по запуску приложения**

Шаги по запуску:

1. Убедитесь, что на вашем сервере установлена Java Runtime Environment (JRE) версии 17 или выше.

2. Скачайте репозиторий с исходным кодом приложения

3. Убедитесь, что у вас установлен Maven. Если нет, установите его с официального сайта на ваш компьютер https://maven.apache.org/

4. После загрузки репозитория перейдите в его корневую директорию и выполните команду **mvn clean install**
Эта команда соберет приложение и создаст JAR-файл в директории target.

Запуск приложения: После успешной сборки выполните команду **mvn spring-boot:run** , чтобы запустить приложение.

**Дополнительная информация:**

Приложение запускается с использованием Java 17 и Spring Boot 3.2.2.

Если вам нужно изменить порт, на котором работает приложение (по умолчанию в application.properties указан server.port = 9093), вы можете указать параметр server.port в файле application.properties или при сборке приложения через Maven вы также можете указать порт как параметр:

**mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080**

После запуска приложения вы можете открыть веб-браузер и перейти по адресу http://ВАШ_ХОСТ:ВАШ_ПОРТ/test/calculate-frequency?input=aaaaabccc

**?input=aaaaabccc** - Это пример строки, которую мы передаем GET-запросом через @RequestParam единственного метода данного приложения calculateFrequency.

Метод вычисляет частоту встречи символов по заданной строке в виде Map.

Тестирование приложения доступно через Swagger: http://ВАШ_ХОСТ:ВАШ_ПОРТ/swagger-ui/index.html#/controller/calculateFrequency

________________

**ENG**


Test task for the position of Java developer (intern)
at T1 Consulting company:

Design (consider the format and limitations of input/output parameters) and implement a REST API that calculates the frequency of characters in a given string. The result should be sorted in descending order by the number of occurrences of each character in the specified string.

Example input string: "aaaaabcccc"
Example output result: "a": 5, "c": 4, "b": 1

Requirements for the solution:
Java 8+
Spring Boot 2+
The solution must be covered by tests
The solution should have documentation on how to run it and the format of input/output parameters
The solution code must be placed in a public Github repository.

**Documentation for running the application**

**Steps to run:**

1. Ensure that Java Runtime Environment (JRE) version 17 or higher is installed on your server.

2. Download the repository with the application source code.

3. Make sure Maven is installed on your computer. If not, install it from the official website https://maven.apache.org/

4. After downloading the repository, navigate to its root directory and execute the command mvn clean install
This command will build the application and create a JAR file in the target directory.

Running the application: After successful build, execute the command mvn spring-boot:run to start the application.

**Additional Information:**

The application runs using Java 17 and Spring Boot 3.2.2.

If you need to change the port on which the application runs (by default, server.port = 9093 is specified in application.properties), you can specify the server.port parameter in the application.properties file or when building the application via Maven, you can also specify the port as a parameter:

**mvn spring-boot:run -Dspring-boot.run.arguments=--server.port=8080**

After starting the application, you can open a web browser and go to http://YOUR_HOST:YOUR_PORT/test/calculate-frequency?input=aaaaabccc

**?input=aaaaabccc** - This is an example string that we pass as a GET request parameter through the @RequestParam of the calculateFrequency method of this application.

The method calculates the frequency of characters in the specified string as a Map.

Application testing is available via Swagger: http://YOUR_HOST:YOUR_PORT/swagger-ui/index.html#/controller/calculateFrequency