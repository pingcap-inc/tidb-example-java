FROM gitpod/workspace-java-17


RUN sudo apt-get install python3-pip -y && \
    sudo pip install pip -U -q && \
    sudo pip install mycli -q && \
    curl --proto '=https' --tlsv1.2 -sSf https://tiup-mirrors.pingcap.com/install.sh | sh
