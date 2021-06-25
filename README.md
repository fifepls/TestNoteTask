# TestNoteTask
test note task by bezborodovk@mail.ru

Выбрал реализацию задания через REST API.
Сборщик - maven
СУБД - postgres
Технологии spring boot, spring web, hibernate, junit

Название БД note
username и passowrd от БД в hibernate.cfg.xml


Инстуркция по мапингу

Главный маппинг localhost:8080/note



(POST mapping)
localhost:8080/note/add
RequestParams title, text - название и текст
RequestBody Set<HashTagEntity> - теги для заметки


(POST mapping)
localhost:8080/note/update
RequestParams noteId, title, text - Id статьи которую мы обновляем, название и текст
RequestBody Set<HashTagEntity> - теги для заметки


(DELETE mapping) 
localhost:8080/note/remove
RequestParams removeNoteId - Id статьи которую мы удаляем


(GET mapping)
localhost:8080/note/get
Получить все заметки без сортировки


(GET mapping)
localhost:8080/note/get/sorted/date
Получить все заметки с сортировкой по дате


(GET mapping)
localhost:8080/note/get/sorted/tags
Request body Set<HashTagEntity> сет тегов, по которым будет сделана сортировка, чем больше тегов из сета у заметки, тем она выше.
Получить все заметки с сортировкой по тегам


(GET mapping)
localhost:8080/note/get/contains
RequestParam keyWord = строка, которую мы будем искать в названии и в тексте заметок

 







