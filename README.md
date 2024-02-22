# Mikroserwisy do zarządzania książkami

## Opis zadania
Zadanie polega na stworzenie 2 małych mikro serwisów w springu, gdzie każdy z nich wystawia API zwracające zgodnie z poniżej podanymi swagerem(załącznik).

Serwis pierwszy służy do dodania książki do stanu, zmianę jej stanu wypożyczenia, oraz wyświetlenia wszystkich książek

Serwis drugi ma trzymać (w swojej bazie) informacje o książęce zasilone z serwisu 1 oraz wyświetlać listę wypożyczonych. Dla obu serwisów isbn jest kluczem unikalnym.

Serwis 1 ma korzystać z bazy danych NoSql, serwis 2 natomiast z SQL Postgress

Komunikacja między serwisami ma wykorzystywać Kafkę. Chciałbym by schemat bazy danych był budowany jakiegoś systemu wersjonowania (plus za flyway).  Całość ma być budowana za pomocą Docker compose.

Zadanie ma na celu sprawdzić jak u Ciebie ze sprawnością korzystania elementów infrastruktury systemu, który będziesz budować.

Cała reszta jest dowolna tylko musisz mi opisać co potrzebuje wiedzieć analizując rozwiązanie. Na drugim etapie rekrutacji będę odnosił się do otrzymanego rozwiazania
## Swagger
- [BookService Swagger](http://localhost:8080/swagger-ui/index.html#): Serwis umożliwiający zarządzanie książkami.
- [LibraryService Swagger](http://localhost:8081/swagger-ui/index.html#): Serwis przechowujący informacje o książkach i prezentujący listę wypożyczonych książek.

## Uruchomienie projektu
Przed uruchomieniem aplikacji Spring Boot należy uruchomić środowisko za pomocą polecenia `docker-compose up`. Wsady inicjalizacyjne dla obu baz danych zostały przygotowane i uruchamiają się automatycznie.