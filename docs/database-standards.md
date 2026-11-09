# Database standards (Seyovela)

Applies to AuthEngine, OrgEngine, AIChatBot, and future products.

## Database names

| Product | Schema |
|---|---|
| AuthEngine | `seyovela_auth` |
| OrgEngine | `seyovela_org` |
| AIChatBot | `seyovela_chatbot` (MariaDB; VECTOR RAG) |

## IDs

- Primary keys are `CHAR(36)` UUIDv7 strings.
- Runtime records: `org.seyovela.ids.SeyovelaIds.next()` from artifact `org.seyovela:seyovela-commons`.

## Integer-backed enums

Use shared enums from `seyovela-commons` (`AccountStatus`, `MembershipStatus`, `OrgRole`, `RecordStatus`, etc.).

## Product codes (OrgEngine seeds)

Product codes such as `AI_CHATBOT` are seeded in OrgEngine and matched case-insensitively by service-key consumers.
