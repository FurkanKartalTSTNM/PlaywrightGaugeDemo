# Playwright Gauge Project

Run all specs:

```bash
mvn test-compile
gauge run specs
```

Run with Maven:

```bash
mvn gauge:execute
```

Useful runtime options:

```bash
gauge run specs -Dbrowser=chromium -Dheadless=true
gauge run specs --tags "login"
```

Artifacts:

- `screenshot/<scenario-name>/`
- `trace/<scenario-name>.zip`
- `reports/html-report/index.html`
