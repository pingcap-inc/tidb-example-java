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

.PHONY: all prepare re-prepare build not-oversell oversell

all:
	make build prepare not-oversell re-prepare oversell

prepare:
	tiup demo bookshop prepare --drop-tables --books 0 --authors 0 --orders 0 --ratings 0 --users 0

re-prepare:
	tiup demo bookshop prepare --drop-tables --books 0 --authors 0 --orders 0 --ratings 0 --users 0

build:
	mvn clean package

not-oversell:
	java -jar target/plain-java-txn-pessimistic-0.0.1-jar-with-dependencies.jar ALICE_NUM=4 BOB_NUM=6

oversell:
	java -jar target/plain-java-txn-pessimistic-0.0.1-jar-with-dependencies.jar ALICE_NUM=4 BOB_NUM=7