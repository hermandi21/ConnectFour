FROM hseeberger/scala-sbt:16.0.1_1.5.4_2.13.6

# Installiere benötigte Bibliotheken
RUN apt-get update && \
    apt-get install -y libxrender1 libxtst6 libxi6 libgl1-mesa-glx libgtk-3-0 && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Setze das Arbeitsverzeichnis im Container
WORKDIR /VierGewinnt

# Kopiere die Projektdateien in das Arbeitsverzeichnis
COPY . /VierGewinnt

# Setze die Berechtigungen für view.sh
RUN chmod +x /VierGewinnt/view.sh

# Setze das Entry-Point-Skript
ENTRYPOINT ["/VierGewinnt/view.sh"]
