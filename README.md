# Crypto Portfolio – Spring Boot projekt

Tento projekt je jednoduché REST API pro správu kryptoměnového portfolia.  
Slouží jako studijní úloha pro procvičení:

- Spring Boot (Controller, Service, Model)
- práce s kolekcemi (ArrayList)
- REST endpointů (GET, POST, PUT)
- řazení dat
- návrhu API a HTTP stavových kódů

---

## Zadání (stručný popis)

Aplikace umožňuje:

- přidávat kryptoměny do portfolia
- zobrazit všechny kryptoměny
- zobrazit detail kryptoměny podle ID
- řadit kryptoměny podle:
  - názvu
  - ceny
  - množství
- aktualizovat existující kryptoměnu
- spočítat celkovou hodnotu portfolia

Data se ukládají pouze do paměti (ArrayList), bez databáze.

---

## Použitý model

```text
Crypto
- id (Integer)
- name (String)
- symbol (String)
- price (Double)
- quantity (Double)
```

---

## Architektura projektu

```text
controller  → přijímá HTTP requesty
service     → obsahuje logiku aplikace
model       → datové objekty (Crypto)
```

### Tok dat

```text
Klient (Postman)
    ↓
CryptoController
    ↓
CryptoService
    ↓
ArrayList<Crypto>
```

---

## Endpointy

| Metoda | Cesta | Popis |
|--------|-------|-------|
| POST | `/cryptos` | Přidání kryptoměny do portfolia |
| GET | `/cryptos` | Získání všech kryptoměn |
| GET | `/cryptos?sort=name` | Řazení podle názvu |
| GET | `/cryptos?sort=price` | Řazení podle ceny |
| GET | `/cryptos?sort=quantity` | Řazení podle množství |
| GET | `/cryptos/{id}` | Detail kryptoměny |
| PUT | `/cryptos/{id}` | Aktualizace kryptoměny |
| GET | `/portfolio-value` | Celková hodnota portfolia |

---

## Testování

- Testovací data (ukázky JSON):
  - `src/test/resources/cryptos-test-data.json`
- Postman kolekce:
  - `postman/crypto-portfolio.postman_collection.json`
