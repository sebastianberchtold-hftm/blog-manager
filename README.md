
# Quarkus Blog Manager

## Projektübersicht

Dies ist eine **Blog-API** basierend auf **Quarkus** und **MongoDB** mit Panache. Die Anwendung ermöglicht das **Erstellen, Bearbeiten, Anzeigen und Löschen von Blogs**, wobei Benutzer Rezepte speichern und verwalten können.

## Projektstruktur

```
blogPost-manager/
│-- src/
│   ├── main/
│   │   ├── java/ch/hftm/nosql/workspace/entity/  # Datenbank-Entities
│   │   │   ├── User.java
│   │   │   ├── BlogPost.java
│   │   │   ├── Comment.java
│   │   ├── java/ch/hftm/nosql/workspace/resource/  # REST API Endpunkte
│   │   │   ├── UserResource.java
│   │   │   ├── BlogPostResource.java
│-- src/main/resources/application.properties  # MongoDB Konfiguration
│-- pom.xml  # Maven Dependencies

```

## Installation & Setup

### **Projekt klonen und Abhängigkeiten installieren**

```sh
git clone <repository-url>
cd blogPost-manager
./mvnw install

```

###  **MongoDB Konfiguration**

Füge die MongoDB-Verbindungsdetails in `src/main/resources/application.properties` hinzu:

```properties
quarkus.mongodb.connection-string=mongodb+srv://admin:<DEIN_PASSWORD>@cluster0.u8hde.mongodb.net/
quarkus.mongodb.database=recipeDB

```

🔹 **Hinweis:** Ersetze `<DEIN_PASSWORD>` mit deinem MongoDB-Atlas-Passwort.

### **Anwendung starten**

```sh
./mvnw quarkus:dev

```

----------

## 📡 API Endpunkte

### 🔹 **Benutzer-Endpoints (`/users`)**

Methode

Endpoint

Beschreibung

`GET`

`/users`

Alle Benutzer abrufen

`POST`

`/users`

Neuen Benutzer anlegen

**🔹 Blog-Endpoints (`/blogs`)**

Methode

Endpoint

Beschreibung

`GET`

`/blogs`

Alle Rezepte abrufen

`POST`

`/blogs`

Neues Rezept erstellen

`GET`

`/blogs/{id}`

Einzelnes Rezept abrufen

`PUT`

`/blogs/{id}`

Rezept aktualisieren

`DELETE`

`/blogs/{id}`

Rezept löschen

----------

## 🛠 Beispielanfragen (cURL)

### **Benutzer erstellen**

```sh
curl -X POST http://localhost:8080/users \
     -H "Content-Type: application/json" \
     -d '{"name": "Max Mustermann", "email": "max@example.com"}'

```

### **➕ Rezept erstellen**

```sh
curl -X POST http://localhost:8080/blogs \
     -H "Content-Type: application/json" \
     -d '{
           "title": "Mein erster Blogpost",
           "content": "Dies ist der Inhalt meines Blogposts.",
           "createdAt": "2025-02-28T12:00:00",
           "comments": []
         }'


```

**Wichtig:** Ersetze `<USER_ID>` mit einer gültigen Benutzer-ID.

### ** Alle Blogs abrufen**

```sh
curl http://localhost:8080/recipes

```

### ** Blogs aktualisieren**

```sh
curl -X PUT http://localhost:8080/posts \
     -H "Content-Type: application/json" \
     -d '{
           "title": "Mein erster Blogpostasdf",
           "content": "Dies ist der Inhalt meinesneu nue Blogposts.",
           "createdAt": "2025-02-28T12:00:00",
           "comments": []
         }'


```

### **🗑 Rezept löschen**

```sh
curl -X DELETE http://localhost:8080/blogs/<BLOGS_ID>

```

----------

## Deployment

Falls du das Projekt als JAR-Datei deployen möchtest:

```sh
./mvnw package
java -jar target/quarkus-app/quarkus-run.jar

```

----------

## 🛠 Nützliche MongoDB-Befehle

Falls du direkt in der MongoDB-CLI arbeiten möchtest, kannst du dich mit `mongosh` verbinden:

```sh
mongosh "mongodb+srv://admin:<DEIN_PASSWORD>@cluster0.u8hde.mongodb.net/"

```

**Befehle zur Überprüfung:**

```sh
show dbs                 # Zeigt alle Datenbanken
use blogsdb             # Wechselt zur Datenbank
show collections         # Zeigt alle Collections

```

----------

## 🎯 Fazit

🔹 **Quarkus + MongoDB mit Panache** für einfache Abfragen 🔹 **REST API mit CRUD-Funktionalität** für Benutzer & Blogs 🔹 **Automatische MongoDB-Collection-Erstellung** durch Panache

<Table  {field}  />