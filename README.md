# kboot-shell

```bash
sdk install java 21.0.2-graalce
```

```bash
sdk use java 21.0.2-graalce
```

```bash
./mvnw -Pnative native:compile -DskipTests
```

```bash
cp target/kboot-shell bin/
```

```bash
./bin/kboot-shell
```

```bash
./target/kboot-shell create --create bar
```
