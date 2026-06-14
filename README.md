# 🌐 JakartaSimpleWebApp

<p align="center">
  <img src="https://img.shields.io/badge/Java-Web_App-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Jakarta-EE-0A66C2?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Build-Apache_Ant-A81C7D?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Deploy-Apache_Tomcat-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black"/>
</p>

---

## 📌 Cos'è questo progetto

**JakartaSimpleWebApp** è una semplice applicazione web Java sviluppata per approfondire lo sviluppo in ambiente Jakarta.
Il progetto è stato realizzato come esercizio pratico per studiare la struttura di una web application Java classica, il processo di build con **Apache Ant** e il deploy su un **application server esterno** come Apache Tomcat.

---

## 🎯 Per cosa è pensato

Il progetto nasce come attività di studio e approfondimento personale sullo sviluppo web Java tradizionale.
L'obiettivo è comprendere il ciclo completo di una web application Java: organizzazione del codice sorgente, compilazione, gestione delle risorse, packaging in formato **WAR** e deploy su un application server.

È particolarmente utile per chi vuole comprendere cosa avviene "sotto il cofano" prima di usare framework più astratti come Spring Boot, che gestisce autonomamente il server embedded.

---

## 🖼️ Immagini del progetto

> Inserire gli screenshot dell'applicazione nella cartella `images/` del repository.

```text
JakartaSimpleWebApp/
├── images/
│   ├── home.png
│   ├── form.png
│   └── result.png
└── README.md
```

```md
![Home page](images/home.png)
![Form page](images/form.png)
![Result page](images/result.png)
```

---

## ⚙️ Come funziona

Il progetto segue il ciclo classico delle web application Java enterprise:

1. **Compilazione** — Ant compila i sorgenti Java da `src/` nella directory `build/`
2. **Copia risorse** — le risorse da `resources/` vengono copiate nella `build/`
3. **Packaging WAR** — Ant assembla il file `JakartaSimpleWebApp.war` nella cartella `dist/`, includendo classi compilate, file web da `web/` e le librerie da `lib/`
4. **Deploy** — il file WAR generato viene deployato manualmente su un application server esterno (es. Apache Tomcat)

> ⚠️ **Importante:** questa applicazione **non include un server embedded**. Per eseguirla è necessario un application server esterno come **Apache Tomcat** (versione compatibile con Jakarta Servlet 5+ raccomandata).

---

## 🛠️ Stack tecnico

| Componente | Tecnologia |
|---|---|
| Linguaggio | Java |
| Piattaforma | Jakarta EE |
| Build tool | Apache Ant |
| File di build | `build.xml` |
| Formato di output | WAR |
| Application Server | Apache Tomcat (esterno, richiesto) |
| Finalità | Studio e approfondimento personale |

---

## 🚀 Avvio del progetto

### Prerequisiti

- **Java JDK** installato e configurato nel PATH
- **Apache Ant** installato (`ant -version` per verificare)
- **Apache Tomcat** installato e avviato (server esterno richiesto)

### 1. Clonazione

```bash
git clone https://github.com/Lele97/JakartaSimpleWebApp.git
cd JakartaSimpleWebApp
```

### 2. Build con Ant

Il target di default è `war`, che esegue automaticamente la catena `clean → compile → copy-resources → war`:

```bash
ant
```

Oppure esplicitamente:

```bash
ant -buildfile build.xml
```

Al termine della build, il file WAR sarà disponibile in:

```
dist/JakartaSimpleWebApp.war
```

### 3. Altri target disponibili

```bash
ant clean           # Cancella build/ e dist/
ant compile         # Compila solo i sorgenti Java
ant copy-resources  # Copia le risorse nella directory di build
ant war             # Esegue la build completa e genera il WAR
```

### 4. Deploy su Apache Tomcat

Copia il file WAR generato nella directory `webapps/` di Tomcat:

```bash
cp dist/JakartaSimpleWebApp.war $CATALINA_HOME/webapps/
```

Se Tomcat è in esecuzione, il deploy avviene automaticamente. L'applicazione sarà disponibile all'indirizzo:

```
http://localhost:8080/JakartaSimpleWebApp
```

---

## 📂 Struttura del progetto

```text
JakartaSimpleWebApp/
├── src/                    # Sorgenti Java
├── resources/              # Risorse applicative (properties, config, ecc.)
├── web/                    # File web (HTML, JSP, ecc.)
│   └── WEB-INF/
│       └── web.xml         # Deployment descriptor
├── lib/                    # Librerie JAR richieste
├── build/                  # Output della compilazione (generato da Ant)
├── dist/                   # Artefatto WAR finale (generato da Ant)
├── build.xml               # Script di build Apache Ant
└── README.md
```

---

## 👤 Autore

**Gabriele Grandinetti**
- 🌐 [gabrielegrandinetti.dev](https://gabrielegrandinetti.dev)
- 💼 [GitHub @Lele97](https://github.com/Lele97)
- 📧 gabriele.grandinetti@hotmail.com

> Progetto realizzato a scopo di studio e approfondimento personale sullo sviluppo web Java con Jakarta, Apache Ant e Apache Tomcat.
