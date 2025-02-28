
# Quarkus Recipe Manager

## Projektübersicht

Dies ist eine **Rezeptverwaltungs-API** basierend auf **Quarkus** und **MongoDB** mit Panache. Die Anwendung ermöglicht das **Erstellen, Bearbeiten, Anzeigen und Löschen von Rezepten**, wobei Benutzer Rezepte speichern und verwalten können.

## Projektstruktur

```
blogPost-manager/
│-- src/
│   ├── main/
│   │   ├── java/ch/hftm/nosql/workspace/entity/  # Datenbank-Entities
│   │   │   ├── User.java
│   │   │   ├── Recipe.java
│   │   │   ├── Ingredient.java
│   │   ├── java/ch/hftm/nosql/workspace/resource/  # REST API Endpunkte
│   │   │   ├── UserResource.java
│   │   │   ├── RecipeResource.java
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

**🔹 Rezept-Endpoints (`/recipes`)**

Methode

Endpoint

Beschreibung

`GET`

`/recipes`

Alle Rezepte abrufen

`POST`

`/recipes`

Neues Rezept erstellen

`GET`

`/recipes/{id}`

Einzelnes Rezept abrufen

`PUT`

`/recipes/{id}`

Rezept aktualisieren

`DELETE`

`/recipes/{id}`

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
curl -X POST http://localhost:8080/recipes \
     -H "Content-Type: application/json" \
     -d '{
        "title": "Pasta Carbonara",
        "ingredients": [
            {"name": "Spaghetti", "amount": "200g"},
            {"name": "Eier", "amount": "2 Stück"},
            {"name": "Parmesan", "amount": "50g"}
        ],
        "instructions": "Alles vermischen und genießen!",
        "authorId": "<USER_ID>"
     }'

```

**Wichtig:** Ersetze `<USER_ID>` mit einer gültigen Benutzer-ID.

### ** Alle Rezepte abrufen**

```sh
curl http://localhost:8080/recipes

```

### ** Rezept aktualisieren**

```sh
curl -X PUT http://localhost:8080/recipes/<RECIPE_ID> \
     -H "Content-Type: application/json" \
     -d '{
        "title": "Pasta Carbonara (Updated)",
        "ingredients": [
            {"name": "Spaghetti", "amount": "250g"},
            {"name": "Eier", "amount": "3 Stück"},
            {"name": "Parmesan", "amount": "60g"},
            {"name": "Speck", "amount": "100g"}
        ],
        "instructions": "Neues Rezept mit mehr Zutaten."
     }'

```

### **🗑 Rezept löschen**

```sh
curl -X DELETE http://localhost:8080/recipes/<RECIPE_ID>

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
use recipeDB             # Wechselt zur Datenbank
show collections         # Zeigt alle Collections

```

----------

## 🎯 Fazit

🔹 **Quarkus + MongoDB mit Panache** für einfache Abfragen 🔹 **REST API mit CRUD-Funktionalität** für Benutzer & Rezepte 🔹 **Automatische MongoDB-Collection-Erstellung** durch Panache

<Table  {field}  />