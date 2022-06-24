package com.pingcap.model;

import java.util.List;

public interface AutoPlayerMapper {
    int insert(AutoPlayer row);
    int insertBatch(List<AutoPlayer> rows);
}