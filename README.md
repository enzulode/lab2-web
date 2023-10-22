# Web programming: 2nd lab work
```task: 29785```

### Task

Разработать веб-приложение на базе сервлетов и JSP, определяющее попадание точки на координатной 
плоскости в заданную область.
--------------------------------------------------------------------------------------------------

### Requirements
Приложение должно быть реализовано в соответствии с шаблоном MVC.

--------------------------------------------------------------------------------------------------

### Architecture
- ControllerServlet:
  - Принимает все запросы к приложению
  - Определяет тип запроса и при наличии в нём информации о координатах точки и размере области, делегирует запрос:```AreaCheckServlet``` или ```Страница JSP```

- AreaCheckServlet:
  - Осуществляет проверку попадания точки в область на координатной плоскости
  - Формирует HTML страницу с результатами проверки
  - Ответственен за все запросы, содержащие информацию о координатах точки и размере области

- Страница JSP:
  - формирует HTML страницу с формой
  - Ответственна за все запросы, не содержащие информации о координатах точки и размере области
--------------------------------------------------------------------------------------------------

### JSP Page requirements
```Main JSP page should contain the following parts:```
- Шапку, содержащую ФИО студента, номер группы и номер варианта
- Форму, отправляющую данные на сервер
- Сценарий на языке JavaScript, осуществляющий валидацию значений, вводимых пользователем в поля формы
- Интерактивный элемент, содержащий изображение области на координатной плоскости и реализующий следующую функциональность:
  - Если радиус области установлен, клик курсором мыши по изображению должен обрабатываться JavaScript-функцией, определяющей координаты точки, по которой кликнул пользователь и отправляющей полученные координаты на сервер для проверки факта попадания
  - В противном случае, после клика по картинке должно выводиться сообщение о невозможности определения координат точки
  - После проверки факта попадания точки в область изображение должно быть обновлено с учётом результатов этой проверки (т.е., на нём должна появиться новая точка)
- Таблицу с результатами предыдущих проверок. Список результатов должен браться из HTTP-сессии

```AreaCheckServlet results page should contain the following parts:```
- Страница, возвращаемая AreaCheckServlet, должна содержать:
  - Таблицу, содержащую полученные параметры
  - Результат вычислений - факт попадания или непопадания точки в область
  - Ссылку на страницу с веб-формой для формирования нового запроса
--------------------------------------------------------------------------------------------------

### Deployment requirements

Разработанное веб-приложение необходимо развернуть на сервере WildFly. Сервер должен быть запущен в standalone-конфигурации, 
порты должны быть настроены в соответствии с выданным portbase, доступ к http listener'у должен быть открыт для всех IP
--------------------------------------------------------------------------------------------------

### Defence questions
- Java сервлеты. Особенности реализации, ключевые методы, преимущества и недостатки относительно CGI и FastCGI
- Контейнеры сервлетов. Жизненный цикл сервлета
- Диспетчеризация запросов в сервлетах. Фильтры сервлетов
- HTTP-сессии - назначение, взаимодействие сервлетов с сессией, способы передачи идентификатора сессии
- Контекст сервлета - назначение, способы взаимодействия сервлетов с контекстом
- JavaServer Pages. Особенности, преимущества и недостатки по сравнению с сервлетами, область применения
- Жизненный цикл JSP
- Структура JSP-страницы. Комментарии, директивы, объявления, скриптлеты и выражения
- Правила записи Java-кода внутри JSP. Стандартные переменные, доступные в скриптлетах и выражениях
- Bean-компоненты и их использование в JSP
- Стандартные теги JSP. Использование Expression Language (EL) в JSP
- Параметры конфигурации JSP в дескрипторе развёртывания веб-приложения
- Шаблоны проектирования и архитектурные шаблоны. Использование в веб-приложениях
- Архитектура веб-приложений. Шаблон MVC. Архитектурные модели Model 1 и Model 2 и их реализация на платформе Java EE
