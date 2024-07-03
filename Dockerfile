FROM hseeberger/scala-sbt:graalvm-ce-21.3.0-java17_1.6.2_3.1.1

RUN apt-get update && \
    apt-get install -y libxrender1 libxtst6 libxi6 libgl1-mesa-glx libgtk-3-0

WORKDIR /VierGewinnt
ADD . /VierGewinnt

RUN chmod +x /VierGewinnt/view.sh
ENTRYPOINT ["/VierGewinnt/view.sh"]
