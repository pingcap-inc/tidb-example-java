FROM gitpod/workspace-java-17


RUN brew install mysql-client
RUN echo 'export PATH="/home/linuxbrew/.linuxbrew/opt/mysql-client/bin:$PATH"' >> /home/gitpod/.bash_profile