# Here are my little projects.

|N|Name of projects|Language|Option of using|Status|
| --- | --- | --- | --- | --- |
|1.|bioModel|PHP|web|finished|
|2.|figures|Java|console|finished|
|3.|parser|Java|console|finished|
|4.|ruler|Java|desktop|finished|
|5.|scripts|VBA|*.xls|finished|
|6.|tableBradis|Java|andriod|finished|
|7.|ticketOffice|Java|web|in action|



***
## 1. bioModel

**ENG**

The biological model of wolf island.

A detailed description can be found in the files Scan-121113-0001.jpg and Scan-121113-0002.jpg

**RUS**

Биологическая модель волчьего острова.

Подробное описание в файлах Scan-121113-0001.jpg и Scan-121113-0002.jpg



***
## 2. figures

**ENG**

Fail version Factory Pattern.) 

**RUS**

Не удавшаяся версия Factory Pattern.)



***
## 3. parser

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
## 4. ruler

**ENG**

This app is an e-line screen/monitor.

It can calculate the approximate number of pixels.

**RUS**

Это приложение являет собою электронную линейку для экрана/монитора.

С его помощью можно подсчитывать приблизительное количество пикселей.



***
## 5. scripts

**ENG**

Several scripts for data processing.)

**RUS**

Пару скриптов-костылей для работы.)



***
## 6. tableBradis

**ENG**

Android-apps: calculator with function tables Bradis and history calculate.

**RUS**

Android-приложение: фактически калькулятор с функциями таблиц Брадиса и историей вычислений.



***
## 7. ticketOffice

**ENG**

Web-apps: online-ticketWindow for network cinemas.

**RUS**

Web-приложение: онлайн-касса для сети кинотеатров.

[Help for me.)](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)