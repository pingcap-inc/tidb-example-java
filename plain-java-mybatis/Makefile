# Copyright 2022 PingCAP, Inc.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

.PHONY: all gen build run

all:
	make mysql gen build run

mysql:
	mysql --host 127.0.0.1 --port 4000 -u root<src/main/resources/dbinit.sql
	mysql --host 127.0.0.1 --port 4000 -u root -e "TRUNCATE test.player"

gen:
	rm -f src/main/java/com/pingcap/model/Player.java
	rm -f src/main/java/com/pingcap/model/PlayerMapper.java
	rm -f src/main/resources/mapper/PlayerMapper.xml
	mvn mybatis-generator:generate

build:
	mvn clean package

run:
	java -jar target/plain-java-mybatis-0.0.1-jar-with-dependencies.jar