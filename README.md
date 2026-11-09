# seyovela-commons

Shared Java library for Seyovela platform services.

| Contents | Package |
|----------|---------|
| UUIDv7 generator | `org.seyovela.ids.SeyovelaIds` |
| Integer-backed enums | `org.seyovela.ids` (`AccountStatus`, `MembershipStatus`, `OrgRole`, `RecordStatus`, …) |

**Maven:** `org.seyovela:seyovela-commons:1.0.0-SNAPSHOT`

Consumers: AuthEngine, OrgEngine, AIChatBot (and future products).

## Build & install

```bash
cd seyovela-commons
mvn clean install
```

## Docs

- [Platform overview](../seyovela/README.md) — Auth / Org / products structure
- [DEVELOPER.md](./DEVELOPER.md) — usage and conventions
- [AGENTS.md](./AGENTS.md) — agent rules
- [docs/database-standards.md](./docs/database-standards.md) — cross-product DB standards
