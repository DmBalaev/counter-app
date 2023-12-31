# counter-app

## Описание
Приложение "Counter App" предназначено для подсчета частоты символов во входной строке. 
Оно предоставляет API для отправки строки и получения результата в JSON формате с символами и их повторением.


## Запуск
1. Убедитесь, что на вашем компьютере установлены Java и Spring Boot.
2. Склонируйте репозиторий с приложением:
    ```bash
    git clone https://github.com/DmBalaev/counter-app.git
    ```
3. Перейдите в каталог приложения:
    ```bash
    cd counter-app
    ```
4. Откройте файл `src/main/resources/application.yml` и укажите желаемый порт в следующей строке:
    ```yaml
   server:
      port: 8087
    ```
   По умолчанию порт установлен на 8087. Вы можете изменить его 
   на любой другой свободный порт. Сохраните файл application.yml.
5. Запустите приложение с помощью Maven:
   ```bash
   mvn spring-boot:run
    ```
6. Приложение будет запущено на указанном вами порту.


---
## Использование

### Запрос
Отправьте GET-запрос на эндпоинт `/api/v1/calculate` с JSON-телом, 
содержащим входную строку для обработки. Пример запроса:
```json
{
  "input": "aaaaaccccb"
}
```
Для отправки HTTP-запроса с помощью `curl`, вы можете использовать следующий пример
```bash
curl -X GET -H "Content-Type: application/json" -d '{"input": "aaaaaccccb"}' http://localhost:8087/api/v1/calculate
```
Обратите внимание на порт. Если вы его меняли, укажите тот порт, 
который вы указали в своей конфигурации

### Ответ
При успешном выполнении запроса, вы получите ответ в формате JSON. Пример ответа:
```json
{
  "a": 5,
  "c": 4,
  "b": 1
}
```

### Обработка ошибок
При возникновении ошибок в запросах будет возвращаться соответствующий 
HTTP-статус и описание ошибки в формате JSON. Пример ответа при ошибке:
```json
{
  "message": "Input string is too long. Maximum allowed length is 10000"
}
```

### Формат входных данных
Поле "input" (String): Входная строка для подсчета частоты символов.

### Формат выходных данных
JSON-объект, представляющий отображение Map с парами ключ-значение, 
где ключи представлены символами `Character`, а значения - количество повторений `Long`.

### Примечания
Максимальная длина входной строки ограничена 10 000 символами, 
как указано в настройках `app.maxLength`.
Вы также можете ее изменить в конфигурации приложения.