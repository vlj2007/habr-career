# Хабр Карьера

1. Собирает с сайта https://career.habr.com/ информацию.
2. Структурирует информацию: title, rating, vacancies, skills, links.
3. Сохраняет в файл CareerFiltered_yyyy-mm-dd_hh-mm-ss.json.
4. Покрываем код тестами.
5. Создаем файлы MANIFEST.MF и habr-career.jar

### Запуск файла 

```
java -jar habr-career.jar
```

### Ходы выполнения программы
```bash
2025-09-26 12:07:03,507 [main] INFO  my.code.Main - Запуск приложения
2025-09-26 12:09:03,973 [main] INFO  my.code.Main - Получение списка всех компаний
2025-09-26 12:09:04,044 [main] INFO  my.code.Main - Файл готов : CareerFiltered_2025-09-26_12-09-04.json
2025-09-26 12:09:04,045 [main] INFO  my.code.Main - Работа завершена
```

### Структура файла
```json
[
{
"title": "Яндекс",
"rating": "3.60",
"vacancies": "55 вакансий",
"skills": "Python • SQL • Java • PostgreSQL • Golang • Linux • C++ • React • JavaScript • Kotlin",
"links": "https://career.habr.com/companies/yandex/vacancies"
},
{
"title": "Т-Банк",
"rating": "4.12",
"vacancies": "20 вакансий",
"skills": "SQL • Java • Python • PostgreSQL • Apache Kafka • Docker • Git • Базы данных • Kubernetes • JavaScript",
"links": "https://career.habr.com/companies/tbank/vacancies"
}
]
```
