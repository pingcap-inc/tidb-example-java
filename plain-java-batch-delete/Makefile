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

.PHONY: all prepare build run

all:
	. ../env.sh && make prepare build run

prepare:
	tiup demo bookshop prepare -D $(TIDB_DB_NAME) -H $(TIDB_HOST) -P $(TIDB_PORT) -U $(TIDB_USER) -p $(TIDB_PASSWORD) --authors 100 --books 1000 --orders 11451 --users 1000 --ratings 11451 --drop-tables

build:
	mvn clean package

run:
	java -jar target/plain-java-batch-delete-jar-with-dependencies.jar