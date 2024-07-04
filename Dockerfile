FROM sbtscala/scala-sbt:eclipse-temurin-17.0.4_1.7.1_3.2.0

# Install required dependencies for X11
RUN apt-get update && \
    apt-get install -y libxrender1 libxtst6 libxi6 libgl1-mesa-glx libgtk-3-0

# Set the working directory
WORKDIR /ConnectFour

# Add the project files into the container
ADD . /ConnectFour
CMD sbt run
#ENTRYPOINT ["/VierGewinnt/view.sh"]

