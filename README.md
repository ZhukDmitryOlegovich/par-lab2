# par-lab2

1. Разрабатываем Writable для каждого из входных наборов данных, который может читать данные из csv.

2. разрабатываем WritableComparable ключа имеющий два столбца: 
   - AEROPORT_ID, 
   - индикатор набора данных (для набора данных с аэропортом = 0 , для перелетов = 1) сортировка по умолчанию по двум столбцам

3. разрабатываем map функцию для каждого из набора данных, которая генерирует WritableComparable ключа и Writable данных
   - для списка аэропортов эта функция в качестве value отправляет имя аэропорта.
   - для списка рейсов в качестве value эта функция отправляет время задержки (в виде строки)
   также надо фильтровать только рейсы с задержкой прибытия.
   в. Разрабатываем Partitioner, который учитывает только код аэропорта
   г. Разрабатываем GroupingComparatorClass, который учитывает только код
   аэропорта
   д. Разрабатываем reduce функцию, которая берет первую строку, извлекает из
   нее имя аэропорта, далее рассчитывает из последующих строк среднее
   минимальное и максимальное время задержки и печатает результат.
   В случае если в аэропорт не осуществлялось рейсов, то запись в результат
   добавлять не надо.
