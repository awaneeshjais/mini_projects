# Here are my little projects.

|N|Name of projects|Language|Option of using|Status|
| --- | --- | --- | --- | --- |
|1.|bioModel|PHP|web|finished|
|2.|codingBat|Java|console|in action|
|3.|figures|Java|console|finished|
|4.|parser|Java|console|finished|
|5.|ruler|Java|desktop|finished|
|6.|scripts|VBA|*.xls|finished|
|7.|tableBradis|Java|andriod|finished|
|8.|testAndroid_e-legion.ru|Java|console|finished|
|9.|testComparorImg|Java|console|finished|
|10.|testSimpleBank|Java|console|finished|
|11.|ticketOffice|Java|web|frozen|
|12.|workingHours|Java|andriod|in action|



***
## 1. bioModel

**ENG**

The biological model of wolf island.

A detailed description can be found in the files Scan-121113-0001.jpg and Scan-121113-0002.jpg

**RUS**

Биологическая модель волчьего острова.

Подробное описание в файлах Scan-121113-0001.jpg и Scan-121113-0002.jpg



***
## 2. codingBat

**ENG**

This part is a decision tasks for [codingbat.com] (http://codingbat.com/java) in section Java.

It's only my opinion & my view.

**RUS**

Этот раздел репозитория примеры решений задач для ресурса [codingbat.com] (http://codingbat.com/java).

Исключительно личный опыт.



***
## 3. figures

**ENG**

Fail version Factory Pattern.) 

**RUS**

Не удавшаяся версия Factory Pattern.)



***
## 4. parser

**ENG**

Small parsing text information.

The usage of the script/code: 25 000 records per one file, 50 files.

The purpose of the script: we have a text file with lines of the form /001XXX/002XXXX/003XXXXX. / - data separator, 001,002,003 ... NNN - number of fields, XXX - field values. XXX - length can be any symbols (text or numbers), field order whatever. As a result, we must have a text file with inserts for load into the database. Question with the name field is not critical, decision - join the 001,002 ... NNN front service symbol "c".

Part of the text input file:

>/0013213513/0023213541/00332543513/004432135421
>/0013213513/0023213541/0033213543513/0044321421
>/0013213513/00233541/0033213543513/004432135421
>/0013213513/0023213541/003321313/004432135421
>/0013213513/0023213541/003321313/004432135421
>/001313/0023213541/0033213543513/00443AELIRFVBAFD

Result in the output file:

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '32543513', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '3213543513', '4321421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '33541', '3213543513', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '321313', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '321313', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('313', '3213541', '3213543513', '43AELIRFVBAFD');

**RUS**

Небольшой парсинг текстовой информации.

Масштабы использования скрипта/кода: около 50 файлов приблизительно по 25 000 записей.

Цель скрипта: есть текстовый файл со строками вида /001ХХХ/002ХХХХ/003ХХХХ. / - разделитель данных, 001,002,003...NNN - номера полей, ХХХ - значения полей. ХХХ - длинна может быть любая (текст или цифры), порядок полей какой угодно. В результате необходимо получить текстовый файл в котором будут созданы инсерты для загрузки в БД. Вопрос с названием полей не принципиален, решение - присоединить к 001,002...NNN спереди служебный символ "с".

Часть текста входного файла:

>/0013213513/0023213541/00332543513/004432135421
>/0013213513/0023213541/0033213543513/0044321421
>/0013213513/00233541/0033213543513/004432135421
>/0013213513/0023213541/003321313/004432135421
>/0013213513/0023213541/003321313/004432135421
>/001313/0023213541/0033213543513/00443AELIRFVBAFD

Результат в выходном файле:

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '32543513', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '3213543513', '4321421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '33541', '3213543513', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '321313', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('3213513', '3213541', '321313', '432135421');

>INSERT INTO test (c001, c002, c003, c004) VALUES ('313', '3213541', '3213543513', '43AELIRFVBAFD');



***
## 5. ruler

**ENG**

This app is an e-line screen/monitor.

It can calculate the approximate number of pixels.

**RUS**

Это приложение являет собою электронную линейку для экрана/монитора.

С его помощью можно подсчитывать приблизительное количество пикселей.



***
## 6. scripts

**ENG**

Several scripts for data processing.)

**RUS**

Пару скриптов-костылей для работы.)



***
## 7. tableBradis

**ENG**

Android-apps: calculator with function tables Bradis and history calculate.

**RUS**

Android-приложение: фактически калькулятор с функциями таблиц Брадиса и историей вычислений.



***
## 8. testAndroid_e-legion.ru

**ENG**

Console-apps: count area of overlapping rectangles (two opposite coordinates of corners). Detailed test conditions in the file 2015-android_school.pdf.

**RUS**

Консольное приложение: подсчитывает площадь фигуры из перекрывающихся прямоугольников (заданы два противоположных угла). Детальные условия теста в файле 2015-android_school.pdf.



***
## 9. testComparorImg

**ENG**

Jar-file (script) which compare two grafical files and displays the difference between files. Detailed test conditions in the file ImageComparisonRequirements.pdf.

**RUS**

Jar-файл (скрипт), который сравнивает подобные графические файлы и выводит разницу между ними. Детальные условия теста в файле ImageComparisonRequirements.pdf.



***
## 10. testSimpleBank

**ENG**

Console-apps: this is primitive architecture of simple bank (create credit annuity/classic, transaction payment, calculate current fill). Detailed test conditions in the file simpleBank.png. Non-correct realization of Spring IoC.

**RUS**

Консольное приложение: примитивная архитектура работы обычного банка (создание кредита аннуитет/классика, проведение платежа, просчёт текущего платежа). Детальные условия теста в файле simpleBank.png. Не корректная реализация Spring IoC.



***
## 11. ticketOffice

**ENG**

Web-apps: online-ticketWindow for network cinemas.

**RUS**

Web-приложение: онлайн-касса для сети кинотеатров.



***
## 12. Working Hours

**ENG**

Android-apps: help users "keep in mind" working hours a lot of stores, markets etc

**RUS**

Android-приложение: помогает пользователю запоминать рабочее время магазинов, маркетов и т. д.



[Help for me.)](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)