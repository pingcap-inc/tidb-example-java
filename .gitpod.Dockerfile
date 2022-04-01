FROM gitpod/workspace-full

RUN brew install maven
RUN brew install openjdk
RUN brew install mysql-client
RUN echo 'export PATH="/home/linuxbrew/.linuxbrew/opt/mysql-client/bin:$PATH"' >> /home/gitpod/.bash_profile