# Here are the my little projects on JAVA.



## 1. figures

**ENG**

Fail version Factory Pattern.)

**RUS**

Не удавшаяся версия Factory Pattern.)


***
## 2. parser

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
## 3. ruler

**ENG**

This app is an e-line screen/monitor.

It can calculate the approximate number of pixels.

**RUS**

Это приложение являет собою электронную линейку для экрана/монитора.

С его помощью можно подсчитывать приблизительное количество пикселей.










[Help for me.)](https://github.com/adam-p/markdown-here/wiki/Markdown-Cheatsheet)