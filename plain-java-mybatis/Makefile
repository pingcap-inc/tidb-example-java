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

.PHONY: gen build run

all:
	make build run

gen:
	rm -f src/main/java/com/pingcap/dao/Player.java
	rm -f src/main/java/com/pingcap/dao/PlayerMapper.java
	rm -f src/main/resources/mapper/PlayerMapper.xml
	mvn mybatis-generator:generate

build:
	mvn clean package

run:
	java -jar target/plain-java-mybatis-0.0.1-jar-with-dependencies.jar