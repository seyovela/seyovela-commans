# AGENTS.md — seyovela-commons

Guidance for AI agents working in this repository.

## What this repo is

Tiny shared JAR: UUIDv7 + integer-backed enums. No Spring Boot app, no HTTP, no database runtime.

## Hard rules

- Artifact id: `seyovela-commons` (not `seyovela-ids`)
- Keep Java packages under `org.seyovela.ids` unless a coordinated multi-repo rename is requested
- Do not add product-specific domain (orgs, chat, sessions) here
- Do not bump to a breaking enum ordinal change without updating all Flyway seeds/consumers
- After changes: `mvn install` so AuthEngine / OrgEngine / AIChatBot pick up the SNAPSHOT

## Typical change flow

1. Edit sources under `src/main/java/org/seyovela/ids/`
2. `mvn -DskipTests install`
3. Rebuild dependents that import the changed types

## Docs

- [README.md](./README.md)
- [DEVELOPER.md](./DEVELOPER.md)
- [docs/database-standards.md](./docs/database-standards.md)
