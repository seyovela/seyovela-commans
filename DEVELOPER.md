# seyovela-commons — Developer Guide

## Purpose

One place for identifiers and status enums shared across AuthEngine, OrgEngine, and product apps. Keeps `CHAR(36)` UUIDv7 and TINYINT-backed statuses consistent.

## Artifact

```xml
<dependency>
  <groupId>org.seyovela</groupId>
  <artifactId>seyovela-commons</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

Java package remains `org.seyovela.ids` (historical). The Maven artifact is `seyovela-commons` (renamed from `seyovela-ids`).

## IDs

```java
String id = SeyovelaIds.next(); // UUIDv7 string
```

Persist as `CHAR(36)`. Hibernate entities should use matching column definitions so `ddl-auto=validate` passes.

## Enums

Use the shared enums for account / membership / org role / record status instead of inventing parallel string or int constants per service. Map TINYINT in the DB to the enum in JPA converters where the project already does so.

## Compatibility

- Java 17
- `jakarta.persistence-api` is **provided** — consumers supply the JPA API via Spring Boot

## Database standards

Canonical notes: [docs/database-standards.md](./docs/database-standards.md)

| Product | Schema |
|---------|--------|
| AuthEngine | `seyovela_auth` |
| OrgEngine | `seyovela_org` |
| AIChatBot | `seyovela_ai_chatbot` (MariaDB) |
