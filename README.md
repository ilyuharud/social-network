# OTUS HighLoad Architect Homework

## Описание

Проект написан на языке `Java` с использованием фреймворка `Spring Boot` 

Для сборки используется `Maven`

Для запуска приложения необходимо установить `docker`

Для тестирования используется `Postman`

## Инструкция

1. Установка и запуск (Все команды выполняются из директории проекта)
   1. Перейти в директорию проекта
   2. Выполнить команду `docker compose up -d --build`
   3. Проверка API:
      1. Импортировать Postman коллекцию `./postman/Highload Architect.postman_collection.json`
      2. Импортировать Postman окружение `./postman/HighLoad Architect.postman_environment.json`
      3. Выполнить запрос с названием `Register`. Результат:
      ```json 
      {
        "user_id": "16588e2d-6915-4ec7-8e45-763216e9e85a"
      }
      ```
      4. Выполнить запрос с названием `Login`. Результат:
      ```json
      {
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIwOTYxNWY2YS00OGU1LTRiOWUtODFhMS03ZDU3M2VhNGMzZWEiLCJpYXQiOjE3MDg2MzUwMTksImV4cCI6MTcwODYzODYxOX0.gDT2iAIydz-0ezP1I1py-t77epKsTxmoGHtc4ilN6R0"
      }
      ```
          Можно попробовать изменить в Body поле password и убедиться что сервис вернёт 403 код ошибки
      5. Выполнить запрос с названием `Get User`. Результат:
      ```json
      {
        "first_name": "Maxim",
        "second_name": "Maximov",
        "id": "09615f6a-48e5-4b9e-81a1-7d573ea4c3ea",
        "birthdate": "2000-01-01",
        "gender": "male",
        "interests": "programming",
        "city": "Moscow"
      }
      ```